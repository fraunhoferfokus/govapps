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
 * $Id: Application_EntitlementLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.service.base.Application_EntitlementLocalServiceBaseImpl;

/**
 * The implementation of the application_ entitlement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.Application_EntitlementLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil
 */
public class Application_EntitlementLocalServiceImpl
	extends Application_EntitlementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil} to access the application_ entitlement local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(Application_EntitlementLocalServiceImpl.class);

	
	@Override
	public Application_Entitlement addApplication_Entitlement(Application_Entitlement application_Entitlement) throws SystemException {
		long application_EntitlementID = CounterLocalServiceUtil.increment(Application_Entitlement.class.getName());
		_log.debug("addApplication_Entitlement:application_EntitlementID: " + application_EntitlementID);
		Application_Entitlement model =  application_EntitlementPersistence.create(application_EntitlementID);
		model.setApplicationId(application_Entitlement.getApplicationId());
		model.setEntitlementId(application_Entitlement.getEntitlementId());
		model.setName(application_Entitlement.getName());
		model.setMotivation(application_Entitlement.getMotivation());
		model.setCompanyId(application_Entitlement.getCompanyId());
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		model.setUserId(application_Entitlement.getUserId());		
		return application_EntitlementPersistence.update(model, true);
	}
	
	
	public Application_Entitlement addApplication_Entitlement(long userId, long companyId, long applicationId, long entitlementId, String name, String motivation) throws SystemException {
		long application_EntitlementID = CounterLocalServiceUtil.increment(Application_Entitlement.class.getName());
		_log.debug("addApplication_Entitlement:application_EntitlementID: " + application_EntitlementID);				
		Application_Entitlement model =  application_EntitlementPersistence.create(application_EntitlementID);
		model.setApplicationId(applicationId);
		model.setEntitlementId(entitlementId);
		model.setName(name);
		model.setMotivation(motivation);
		model.setCompanyId(companyId);
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		model.setUserId(userId);		
		return application_EntitlementPersistence.update(model, true);
	}
		
	
	public Application_Entitlement deleteApplication_Entitlement(Application_Entitlement application_Entitlement) throws SystemException {
		return super.deleteApplication_Entitlement(application_Entitlement);
	}
	
	
	public void deleteApplication_EntitlementById(long application_EntitlementId) throws SystemException, PortalException {
		super.deleteApplication_Entitlement(application_EntitlementId);
	}
	
	
	public int getApplication_EntitlementsCount(long companyId) throws SystemException {
		return application_EntitlementPersistence.countByc(companyId);
	}
	
	
	public List<Application_Entitlement> getApplication_Entitlements(long companyId) throws SystemException {
		 return application_EntitlementPersistence.findByc(companyId);
	}
	
	public List<Application_Entitlement> findByca(long companyId, long applicationId) throws SystemException {
		 return application_EntitlementPersistence.findByca(companyId, applicationId);
	}
	
	public List<Application_Entitlement> findByce(long companyId, long entitlementId) throws SystemException {
		 return application_EntitlementPersistence.findByce(companyId, entitlementId);
	}

	public List<Application_Entitlement> findBycae(long companyId, long applicationId, long entitlementId) throws SystemException {
		 return application_EntitlementPersistence.findBycae(companyId, applicationId, entitlementId);
	}

	public Application_Entitlement updateApplication_Entitlement(Application_Entitlement application_Entitlement) throws SystemException {
//		Application_Entitlement model =  application_EntitlementPersistence.fetchByPrimaryKey(application_Entitlement.getApplicationEntitlementID());
//		model.setApplicationId(application_Entitlement.getApplicationId());
//		model.setEntitlementId(application_Entitlement.getEntitlementId());
//		model.setName(application_Entitlement.getName());
//		model.setMotivation(application_Entitlement.getMotivation());
//		model.setCompanyId(application_Entitlement.getCompanyId());
//		model.setModifiedDate(new Date());
		application_Entitlement.setModifiedDate(new Date());
//		model.setUserId(application_Entitlement.getUserId());
//		return application_EntitlementPersistence.update(model, true);
		return application_EntitlementPersistence.update(application_Entitlement, true);
	}

	
	public Application_Entitlement updateApplication_Entitlement(long userId, long companyId, long applicationId, long entitlementId, String name, String motivation, long application_EntitlementId) throws SystemException {
		Application_Entitlement model =  application_EntitlementPersistence.fetchByPrimaryKey(application_EntitlementId);
		model.setApplicationId(applicationId);
		model.setEntitlementId(entitlementId);
		model.setName(name);
		model.setMotivation(motivation);
		model.setCompanyId(companyId);
		model.setModifiedDate(new Date());
		model.setUserId(userId);
		return application_EntitlementPersistence.update(model, true);
	}
}
