package de.fraunhofer.fokus.movepla.service.permission;

/*
 * #%L
 * govapps_data
 * $Id: Permission.java 566 2014-11-13 15:22:01Z sma $
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

//import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserServiceUtil;


//import de.fraunhofer.fokus.movepla.model.Application;
//import de.fraunhofer.fokus.movepla.model.Category;
//import de.fraunhofer.fokus.movepla.model.CategoryConstants;
//import de.fraunhofer.fokus.movepla.model.Entitlement;
//import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class Permission {

	private static Log _log = LogFactoryUtil.getLog(Permission.class);

	public static final String APP_DEVELOPER     = "Anwendung_entwickler";
	public static final String CONTENT_PROVIDER  = "Anwendung_redakteur";
	public static final String PLATFORM_ADMIN    = "Anwendung_admin";
	
	
	public static void check(PermissionChecker permissionChecker, long applicationId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, applicationId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, actionId)) {
			throw new PrincipalException();
		}
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long applicationId, String actionId) throws PortalException, SystemException {

		// Role Anwendung_redakteur
		if (actionId.equals(ActionKeys.ADD_CATEGORY) || 
				actionId.equals(ActionKeys.EDIT_CATEGORY) ||
				actionId.equals(ActionKeys.DELETE_CATEGORY) ||
				actionId.equals(ActionKeys.ADD_ENTITLEMENT) || 
				actionId.equals(ActionKeys.EDIT_ENTITLEMENT) ||
				actionId.equals(ActionKeys.DELETE_ENTITLEMENT) ||
				actionId.equals(ActionKeys.ADD_REGION) ||
				actionId.equals(ActionKeys.EDIT_REGION ) ||
				actionId.equals(ActionKeys.DELETE_REGION) ||
				actionId.equals(ActionKeys.ADD_LANGUAGE) ||
				actionId.equals(ActionKeys.EDIT_LANGUAGE ) ||
				actionId.equals(ActionKeys.DELETE_LANGUAGE)
				) {
			long userId = permissionChecker.getUserId();
			User user = UserServiceUtil.getUserById(userId);
			long roleId = RoleServiceUtil.getRole(user.getCompanyId(), CONTENT_PROVIDER).getRoleId();
			
			if (! UserServiceUtil.hasRoleUser(roleId, userId)) {
				return false;
			}
		}
		
		// Role Anwendung_entwickler
		if (actionId.equals(ActionKeys.ADD_APPLICATION) || 
				actionId.equals(ActionKeys.EDIT_APPLICATION) ||
				actionId.equals(ActionKeys.DELETE_APPLICATION) 
				) {
			long userId = permissionChecker.getUserId();
			
			_log.debug("userId: " + userId);
			User user = UserServiceUtil.getUserById(userId);
			long roleId = RoleServiceUtil.getRole(user.getCompanyId(), APP_DEVELOPER).getRoleId();
			
			if (! UserServiceUtil.hasRoleUser(roleId, userId)) {
				return false;
			}
			// delete/edit only own Applications
			if (actionId.equals(ActionKeys.EDIT_APPLICATION) ||
					actionId.equals(ActionKeys.DELETE_APPLICATION) 
					) {
				if(userId != ApplicationLocalServiceUtil.getApplication(applicationId).getUserId()) {
					return false;
				}
			}
		}
		return true;
	}	
	

	public static boolean contains(PermissionChecker permissionChecker, String actionId) throws PortalException, SystemException {

		// Anwendung_redakteur
		if (actionId.equals(ActionKeys.ADD_CATEGORY) || 
				actionId.equals(ActionKeys.EDIT_CATEGORY) ||
				actionId.equals(ActionKeys.DELETE_CATEGORY) ||
				actionId.equals(ActionKeys.ADD_ENTITLEMENT) || 
				actionId.equals(ActionKeys.EDIT_ENTITLEMENT) ||
				actionId.equals(ActionKeys.DELETE_ENTITLEMENT) ||
				actionId.equals(ActionKeys.ADD_REGION) ||
				actionId.equals(ActionKeys.EDIT_REGION ) ||
				actionId.equals(ActionKeys.DELETE_REGION) ||
				actionId.equals(ActionKeys.ADD_LANGUAGE) ||
				actionId.equals(ActionKeys.EDIT_LANGUAGE ) ||
				actionId.equals(ActionKeys.DELETE_LANGUAGE)
				) {
			long userId = permissionChecker.getUserId();
			User user = UserServiceUtil.getUserById(userId);
			long roleId = RoleServiceUtil.getRole(user.getCompanyId(), CONTENT_PROVIDER).getRoleId();
			
			if (! UserServiceUtil.hasRoleUser(roleId, userId)) {
				return false;
			}
		}
		
		// Anwendung_entwickler
		if (actionId.equals(ActionKeys.ADD_APPLICATION) || 
				actionId.equals(ActionKeys.EDIT_APPLICATION) ||
				actionId.equals(ActionKeys.DELETE_APPLICATION) 
				) {
			long userId = permissionChecker.getUserId();
			
			_log.debug("userId: " + userId);
			User user = UserServiceUtil.getUserById(userId);
			long roleId = RoleServiceUtil.getRole(user.getCompanyId(), APP_DEVELOPER).getRoleId();
			
			if (! UserServiceUtil.hasRoleUser(roleId, userId)) {
				return false;
			}
			// delete/edit only own Applications
		}
		return true;
	}	
}
