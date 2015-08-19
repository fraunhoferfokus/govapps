/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.fraunhofer.fokus.movepla.service.impl;

/*
 * #%L
 * govapps_data
 * $Id: RegionLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS / CC ÖFIT
 * %%
 * Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 * 2) Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 * 3) All advertising materials mentioning features or use of this software must 
 *    display the following acknowledgement: 
 *    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
 * 
 * 4) Neither the name of the organization nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL 
 * Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.service.base.RegionLocalServiceBaseImpl;

/**
 * The implementation of the region local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.RegionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.RegionLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil
 */
public class RegionLocalServiceImpl extends RegionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil} to access the region local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(RegionLocalServiceImpl.class);
	
	@Override
	public Region addRegion(Region region) throws SystemException {
		_log.debug("addRegion");
		long regionId = CounterLocalServiceUtil.increment(Region.class.getName());
		Region model = regionPersistence.create(regionId);
		model.setUserId(region.getUserId());
		model.setCompanyId(region.getCompanyId());
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		model.setAgs(region.getAgs());
		model.setName(region.getName());
		model.setCoordniates_x(region.getCoordniates_x());
		model.setCoordniates_y(region.getCoordniates_y());
		model.setParentRegion(region.getParentRegion());
		return regionPersistence.update(model, true);
	}
	
	
	@Override
	public Region updateRegion(Region region) throws SystemException {
		_log.debug("region.getRegionId(): " + region.getRegionId());
		Region model =  regionPersistence.fetchByPrimaryKey(region.getRegionId());
		model.setUserId(region.getUserId());
		model.setCompanyId(region.getCompanyId());
		model.setModifiedDate(new Date());
		model.setAgs(region.getAgs());
		model.setName(region.getName());
		model.setCoordniates_x(region.getCoordniates_x());
		model.setCoordniates_y(region.getCoordniates_y());
		model.setParentRegion(region.getParentRegion());
		return regionPersistence.update(model, true);		
	}
	
	
	public Region deleteRegion(Region region) throws SystemException {
		List<Application>  apps = regionPersistence.getApplications(region.getRegionId());
		List<Region>  childs = getChildRegions(region.getCompanyId(), region.getRegionId());
		_log.debug("apps.size: " + apps.size());
		_log.debug("childs.size: " + childs.size());
		if (apps.size() == 0 && childs.size() == 0) {
			regionPersistence.remove(region);
		}
		return region;
	}
	
	
	public Region deleteRegion(long regionId) throws SystemException {
		Region model =  regionPersistence.fetchByPrimaryKey(regionId);
		List<Application>  apps = regionPersistence.getApplications(model.getRegionId());
		List<Region>  childs = getChildRegions(model.getCompanyId(), model.getRegionId());
		
		if (apps.size() == 0 && childs.size() == 0) {
			regionPersistence.remove(model);
		}
		return model;
	}
	
	
	public List<Region> findByc(long companyId) throws SystemException {
		return regionPersistence.findByc(companyId);		
	}
	
	public List<Region> getChildRegions(long companyId, long parentRegionId) throws SystemException {
		return regionPersistence.findBycp(companyId, parentRegionId);		
	}
	
	public int countRegions(long companyId) throws SystemException {
		return regionPersistence.countByc(companyId);
	}
	
	
	public List<Application> getApplications(long regionId) throws SystemException {
		return regionPersistence.getApplications(regionId);
	}


}
