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
 * $Id: Application_EntitlementServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.service.base.Application_EntitlementServiceBaseImpl;
//import de.fraunhofer.fokus.movepla.service.permission.ActionKeys;
//import de.fraunhofer.fokus.movepla.service.permission.Permission;

/**
 * The implementation of the application_ entitlement remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.Application_EntitlementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.Application_EntitlementServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.Application_EntitlementServiceUtil
 */
public class Application_EntitlementServiceImpl
	extends Application_EntitlementServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.Application_EntitlementServiceUtil} to access the application_ entitlement remote service.
	 */
	
//	private static Log _log = LogFactoryUtil.getLog(Application_EntitlementServiceImpl.class);

/*	
	public Application_Entitlement addApplication_Entitlement(Application_Entitlement application_Entitlement) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.ADD_APPLICATION);
			return application_EntitlementLocalService.addApplication_Entitlement(application_Entitlement);
		} catch (Exception e) {
			_log.debug("error: " + e.getMessage());
		}
		return null;
	}
	
	public Application_Entitlement addApplication_Entitlement(long userId, long companyId, long applicationId, long entitlementId, String name, String motivation) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.ADD_APPLICATION);
			return application_EntitlementLocalService.addApplication_Entitlement(userId, companyId, applicationId, entitlementId, name, motivation);
		} catch (Exception e) {
			_log.debug("error: " + e.getMessage());
		}
		return null;
	}
		
	public void deleteApplication_Entitlement(Application_Entitlement application_Entitlement) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_APPLICATION);
			application_EntitlementLocalService.deleteApplication_Entitlement(application_Entitlement);
		} catch (Exception e) {
			_log.debug("error: " + e.getMessage());
		}
	}
	
	public void deleteApplication_Entitlement(long application_EntitlementId) throws SystemException, PortalException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_APPLICATION);
			application_EntitlementLocalService.deleteApplication_Entitlement(application_EntitlementId);
		} catch (Exception e) {
			_log.debug("error: " + e.getMessage());
		}
	}
*/	
	public List<Application_Entitlement> getApplication_Entitlements(long companyId) throws SystemException {
		return application_EntitlementLocalService.getApplication_Entitlements(companyId); 
	}

	
	public int getApplication_EntitlementsCount(long companyId) throws SystemException {
		return application_EntitlementLocalService.getApplication_EntitlementsCount(companyId);
	}
	
/*	
	public Application_Entitlement updateApplication_Entitlement(long userId, long companyId, long applicationId, long entitlementId, String name, String motivation, long application_EntitlementId) throws SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.EDIT_APPLICATION);
			return application_EntitlementLocalService.updateApplication_Entitlement(userId, companyId, applicationId, entitlementId, name, motivation, application_EntitlementId);
		} catch (Exception e) {
			_log.debug("error: " + e.getMessage());
			
			return null;
		}
	}	
	
*/	
}
