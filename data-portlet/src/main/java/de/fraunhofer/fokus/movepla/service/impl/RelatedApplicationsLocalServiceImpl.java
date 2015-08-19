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
 * $Id: RelatedApplicationsLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.RelatedApplications;
import de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.base.RelatedApplicationsLocalServiceBaseImpl;

/**
 * The implementation of the related applications local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.RelatedApplicationsLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalServiceUtil
 */
public class RelatedApplicationsLocalServiceImpl extends RelatedApplicationsLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(RelatedApplicationsLocalServiceImpl.class);
	
	public RelatedApplications createRelatedApplications(long appId1, long appId2) {		
		long newRelatedApplicationsId;
		RelatedApplications _relatedApplications = null;
		try {
			if (! alreadyAreRelated(appId1, appId2)) {
				newRelatedApplicationsId = CounterLocalServiceUtil.increment(RelatedApplications.class.getName());
				_relatedApplications =  relatedApplicationsPersistence.create(newRelatedApplicationsId);
				_relatedApplications.setApplicationId(appId1);
				_relatedApplications.setApplicationId2(appId2);			
				relatedApplicationsPersistence.update(_relatedApplications, true);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return _relatedApplications;
	}

	
	public RelatedApplications createRecursiveRelatedApplications(long appId1, long appId2) {		
		long newRelatedApplicationsId;
		RelatedApplications _relatedApplications = null;
		try {

			// check whether app1, app2 are related:
			if (! alreadyAreRelated(appId1, appId2)) {
				
				newRelatedApplicationsId = CounterLocalServiceUtil.increment(RelatedApplications.class.getName());
				_relatedApplications =  relatedApplicationsPersistence.create(newRelatedApplicationsId);
				_relatedApplications.setApplicationId(appId1);
				_relatedApplications.setApplicationId2(appId2);			
				relatedApplicationsPersistence.update(_relatedApplications, true);
				
				// if app1 are already related to others apps_n => also relate app2 to app_n
				List<Long> relAppsFromApp1 = getRelAppIds(appId1);
				for (long appId_n : relAppsFromApp1) {
					createRelatedApplications(appId_n, appId2);					
				}
				
				// if app2 are already related to others apps_n => also relate app1 to app_n
				List<Long> relAppsFromApp2 = getRelAppIds(appId2);
				for (long appId_n : relAppsFromApp2) {
					createRelatedApplications(appId_n, appId1);					
				}
				
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return _relatedApplications;
	}
	
	
	public boolean alreadyAreRelated(long appId1, long appId2) throws SystemException {

/*		
		boolean areRelated = false;
		List<RelatedApplications> relatedApplicationsList =  relatedApplicationsPersistence.findBya(appId1);
		for (RelatedApplications relatedApps: relatedApplicationsList) {
			if (relatedApps.getApplicationId2() == appId2) {
				return true;				
			}
		}
		relatedApplicationsList =  relatedApplicationsPersistence.findBya2(appId1);
		for (RelatedApplications relatedApps: relatedApplicationsList) {
			if (relatedApps.getApplicationId() == appId2) {
				return true;				
			}
		}		
		return areRelated;
*/		

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RelatedApplications.class);
		Criterion criterionOr   = null;
		Criterion criterionAnd1 = null;
		Criterion criterionAnd2 = null;
		
		criterionAnd1 = RestrictionsFactoryUtil.eq("applicationId", appId1);
		criterionAnd1 = RestrictionsFactoryUtil.and(criterionAnd1, RestrictionsFactoryUtil.eq("applicationId2", appId2));
		
		criterionAnd2 = RestrictionsFactoryUtil.eq("applicationId", appId2);
		criterionAnd2 = RestrictionsFactoryUtil.and(criterionAnd2, RestrictionsFactoryUtil.eq("applicationId2", appId1));
		
		criterionOr = RestrictionsFactoryUtil.or(criterionAnd1, criterionAnd2);
		dynamicQuery.add(criterionOr);
					
		List<RelatedApplications> relatedApplications = dynamicQuery(dynamicQuery);
		
		if (relatedApplications.size() == 0) {
			return false;
		} 
		if (relatedApplications.size() == 1) {
			return true;			
		}
		if (relatedApplications.size() > 1) {
			_log.info("too many related entries for appId1: " + appId1 + " and appId2: " + appId2) ;
			throw new SystemException("too many related entries for appId1: " + appId1 + " and appId2: " + appId2);
		}
		return false;
	}
	
	
	public List<Long>  getRelAppIds(long appId) throws SystemException {
		List<Long> result = new ArrayList<Long>();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RelatedApplications.class);
		Criterion criterionOr   = null;
		criterionOr = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("applicationId", appId), RestrictionsFactoryUtil.eq("applicationId2", appId));
		dynamicQuery.add(criterionOr);		
		List<RelatedApplications> relatedApplicationsList = dynamicQuery(dynamicQuery);
		
		for (RelatedApplications relatedApplications: relatedApplicationsList) {
			if (relatedApplications.getApplicationId() == appId && !result.contains(relatedApplications.getApplicationId2() )) {
				result.add(relatedApplications.getApplicationId2());
			}
			if (relatedApplications.getApplicationId2() == appId && !result.contains(relatedApplications.getApplicationId() )) {
				result.add(relatedApplications.getApplicationId());
			}			
		}
		
		return result;
		
	}
	
}
