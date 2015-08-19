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
 * $Id: EntitlementServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import java.util.Vector;

//import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.security.auth.PrincipalException;

//import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.service.base.EntitlementServiceBaseImpl;
//import de.fraunhofer.fokus.movepla.service.permission.ActionKeys;
//import de.fraunhofer.fokus.movepla.service.permission.Permission;

/**
 * The implementation of the entitlement remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.EntitlementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.EntitlementServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.EntitlementServiceUtil
 */
public class EntitlementServiceImpl extends EntitlementServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.EntitlementServiceUtil} to access the entitlement remote service.
	 */

	//	private static Log _log = LogFactoryUtil.getLog(EntitlementServiceImpl.class);

	
	/*
	
	public Entitlement addEntitlement(long userId, long companyId, String entitlementName, String explanation) throws PortalException, SystemException {
		_log.debug("addEntitlement::entitlementName: " + entitlementName);
		_log.debug("addEntitlement::explanation: " + explanation);
		try {
			Permission.check(getPermissionChecker(), ActionKeys.ADD_ENTITLEMENT);
			return entitlementLocalService.addEntitlement(userId, companyId, entitlementName, explanation);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Entitlement addEntitlement(Entitlement entitlement) throws PortalException, SystemException {
		try {			
			Permission.check(getPermissionChecker(), ActionKeys.ADD_ENTITLEMENT);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return entitlementLocalService.addEntitlement(entitlement);
	}
	
	
	public Entitlement updateEntitlement(long userId, long companyId, long entitlementId, String entitlementName, String explanation, String estimation) throws SystemException {
		try {			
			Permission.check(getPermissionChecker(), ActionKeys.EDIT_ENTITLEMENT);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return entitlementLocalService.updateEntitlement(userId, companyId, entitlementId, entitlementName, explanation, estimation);
	}
	
	public Entitlement updateEntitlement(Entitlement entitlement) throws SystemException {
		try {			
			Permission.check(getPermissionChecker(), ActionKeys.EDIT_ENTITLEMENT);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return entitlementLocalService.updateEntitlement(entitlement);
	}

	public void deleteEntitlement(Entitlement entitlement) throws PortalException, SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_ENTITLEMENT);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		entitlementLocalService.deleteEntitlement(entitlement);
	}
	
	
	public void deleteEntitlement(long entitlementId) throws PortalException, SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_ENTITLEMENT);
		} catch (PrincipalException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		entitlementLocalService.deleteEntitlement(entitlementId);
	}

*/	
	public List<Entitlement> getEntitlements(long companyId) throws SystemException {
		return entitlementLocalService.getEntitlements(companyId);
	}
	
/*	
	public int getEntitlementsCount(long companyId) throws SystemException {
		return entitlementLocalService.getEntitlementsCount(companyId);
	}
	
	
	
	public List<Application> getApplications(long entitlementId) throws SystemException {
		return entitlementLocalService.getApplications(entitlementId);
	}

	
*/
	
//	public List<Vector<Object>> getRegionsCategoriesEntitlements(long companyId) throws SystemException {
	public List<Vector> getRegionsCategoriesEntitlements(long companyId) throws SystemException {
//		List<Vector<Object>> reCaEnResultList = new ArrayList<Vector<Object>>();
		List<Vector> reCaEnResultList = new ArrayList<Vector>();

//		Vector<Object> regionResult = new Vector<Object>();
		Vector regionResult = new Vector();
		List<Region> regions = regionLocalService.findByc(companyId);
		for (Region region : regions) {
			regionResult.add(region);			
		}		
		reCaEnResultList.add(regionResult);

		Vector<Object> categoryResult = new Vector<Object>();
		List<Category> categories = categoryLocalService.getCategories(companyId);
		for (Category category : categories) {
			categoryResult.add(category);			
		}		
		reCaEnResultList.add(categoryResult);

		Vector<Object> entitlementResult = new Vector<Object>();
		List<Entitlement> entitlements = entitlementLocalService.getEntitlements(companyId);
		for (Entitlement entitlement : entitlements) {
			entitlementResult.add(entitlement);			
		}		
		reCaEnResultList.add(entitlementResult);
		
		return reCaEnResultList;
	}
	
	
}
