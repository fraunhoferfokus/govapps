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
 * $Id: RegionServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.List;

//import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.service.base.RegionServiceBaseImpl;
//import de.fraunhofer.fokus.movepla.service.permission.ActionKeys;
//import de.fraunhofer.fokus.movepla.service.permission.Permission;

/**
 * The implementation of the region remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.RegionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.RegionServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.RegionServiceUtil
 */
public class RegionServiceImpl extends RegionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.RegionServiceUtil} to access the region remote service.
	 */
	

	private static Log _log = LogFactoryUtil.getLog(RegionLocalServiceImpl.class);
	
/*	
	public Region addRegion(Region region) throws SystemException, PortalException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.ADD_REGION);
			return regionLocalService.addRegion(region);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
		return null;
	}
	
	
	public Region updateRegion(Region region) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.EDIT_REGION);
			return regionLocalService.updateRegion(region);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
		return null;
	}
	
	
	public void deleteRegion(Region region) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_REGION);
			regionLocalService.deleteRegion(region);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
	}
	
	
	public void deleteRegion(long regionId) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_REGION);
			regionLocalService.deleteRegion(regionId);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
	}
	
	
	public List<Region> findByc(long companyId) throws SystemException {
		return regionLocalService.findByc(companyId);		
	}
	
	
	public int countRegions(long companyId) throws SystemException {
		return regionLocalService.countRegions(companyId);
	}
	
	
*/	
	
	public List<Region> getAllRegions(long companyId) throws SystemException {
		_log.debug("getAllRegions");
		return regionLocalService.findByc(companyId);		
	}

}
