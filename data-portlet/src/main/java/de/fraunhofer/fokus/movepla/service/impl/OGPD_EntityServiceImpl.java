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
 * $Id: OGPD_EntityServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import de.fraunhofer.fokus.movepla.service.base.OGPD_EntityServiceBaseImpl;

/**
 * The implementation of the o g p d_ entity remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.OGPD_EntityService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.OGPD_EntityServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.OGPD_EntityServiceUtil
 */
public class OGPD_EntityServiceImpl extends OGPD_EntityServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.OGPD_EntityServiceUtil} to access the o g p d_ entity remote service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(OGPD_EntityServiceImpl.class);
	
	public JSONArray getAllEntities()  {
		try {
			PermissionChecker pc = getPermissionChecker();
			long userId = pc.getUserId();
			_log.debug("userId: " + userId);
			_log.debug("pc.isSignedIn(): " + pc.isSignedIn());			
			_log.debug("getCompanyId: " + pc.getCompanyId());
			User _user = userLocalService.fetchUser(userId);
			_log.debug("_user.getFullName(): " + _user.getFullName());
			_log.debug("_user.isActive(): " + _user.isActive());
			_log.debug("_user.isAgreedToTermsOfUse(): " + _user.isAgreedToTermsOfUse());
			_log.debug("_user.isEmailAddressVerified(): " + _user.isEmailAddressVerified());
			_log.debug("_user.isLockout(): " + _user.isLockout());
			_log.debug("_user.isNew(): " + _user.isNew());
			
		} catch (PrincipalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		return ogpd_EntityLocalService.getOGPD_Entities();
	}

	
	public JSONArray getRegionEntitiesForWidget(String regionID)  {
		try {
			PermissionChecker pc = getPermissionChecker();
			long userId = pc.getUserId();
			_log.debug("userId: " + userId);
			_log.debug("pc.isSignedIn(): " + pc.isSignedIn());			
			_log.debug("getCompanyId: " + pc.getCompanyId());
			User _user = userLocalService.fetchUser(userId);
			_log.debug("_user.getFullName(): " + _user.getFullName());
			_log.debug("_user.isActive(): " + _user.isActive());
			_log.debug("_user.isAgreedToTermsOfUse(): " + _user.isAgreedToTermsOfUse());
			_log.debug("_user.isEmailAddressVerified(): " + _user.isEmailAddressVerified());
			_log.debug("_user.isLockout(): " + _user.isLockout());
			_log.debug("_user.isNew(): " + _user.isNew());
			
		} catch (PrincipalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		return ogpd_EntityLocalService.getRegionEntitiesForWidget(regionID);
	}
	
	
	public JSONArray getRegionEntitiesForWidgetParamFirst(String regionID, String name) {
		try {
			PermissionChecker pc = getPermissionChecker();
			long userId = pc.getUserId();
			_log.debug("userId: " + userId);
			_log.debug("pc.isSignedIn(): " + pc.isSignedIn());			
			_log.debug("getCompanyId: " + pc.getCompanyId());
			User _user = userLocalService.fetchUser(userId);
			_log.debug("_user.getFullName(): " + _user.getFullName());
			_log.debug("_user.isActive(): " + _user.isActive());
			_log.debug("_user.isAgreedToTermsOfUse(): " + _user.isAgreedToTermsOfUse());
			_log.debug("_user.isEmailAddressVerified(): " + _user.isEmailAddressVerified());
			_log.debug("_user.isLockout(): " + _user.isLockout());
			_log.debug("_user.isNew(): " + _user.isNew());
			
		} catch (PrincipalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		return ogpd_EntityLocalService.getRegionEntitiesForWidgetParamFirst(regionID, name);
	}
	
	
	public JSONArray getOpenDataEntitiesForWidget()  {
		try {
			PermissionChecker pc = getPermissionChecker();
			long userId = pc.getUserId();
			_log.debug("userId: " + userId);
			_log.debug("pc.isSignedIn(): " + pc.isSignedIn());			
			_log.debug("getCompanyId: " + pc.getCompanyId());
			User _user = userLocalService.fetchUser(userId);
			_log.debug("_user.getFullName(): " + _user.getFullName());
			_log.debug("_user.isActive(): " + _user.isActive());
			_log.debug("_user.isAgreedToTermsOfUse(): " + _user.isAgreedToTermsOfUse());
			_log.debug("_user.isEmailAddressVerified(): " + _user.isEmailAddressVerified());
			_log.debug("_user.isLockout(): " + _user.isLockout());
			_log.debug("_user.isNew(): " + _user.isNew());
			
		} catch (PrincipalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		return ogpd_EntityLocalService.getOpenDataEntitiesForWidget();
	}
	
}
