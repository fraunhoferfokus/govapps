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
 * $Id: CategoryServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
//import com.liferay.portal.security.auth.PrincipalException;

import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.service.base.CategoryServiceBaseImpl;
//import de.fraunhofer.fokus.movepla.service.permission.ActionKeys;
//import de.fraunhofer.fokus.movepla.service.permission.Permission;

/**
 * The implementation of the category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.CategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.CategoryServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.CategoryServiceUtil
 */
public class CategoryServiceImpl extends CategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.CategoryServiceUtil} to access the category remote service.
	 */
	

	private static Log _log = LogFactoryUtil.getLog(CategoryServiceImpl.class);
	
/*	
	public Category addCategory(long userId, long companyId, String categoryName, long parentCategory) throws PortalException, SystemException {
		_log.debug("CategoryServiceImpl::addCategory::categoryName: " + categoryName);
		_log.debug("CategoryServiceImpl::addCategory::parentCategory: " + parentCategory);
		try {
			Permission.check(getPermissionChecker(), ActionKeys.ADD_CATEGORY);
			Category category = categoryLocalService.addCategory(userId, companyId, categoryName, parentCategory);
			return category;
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
		return null;
	}
	
	
	public void editCategory(long userId, long companyId, long categoryId, String categoryName, long parentCategoryId) throws SystemException, PrincipalException, PortalException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.EDIT_CATEGORY);
			categoryLocalService.updateCategory(userId, companyId, categoryId, categoryName, parentCategoryId);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
	}

	
	public void deleteCategory(long categoryId) throws PortalException, SystemException {
		try {
			Permission.check(getPermissionChecker(), ActionKeys.DELETE_CATEGORY);
			categoryLocalService.deleteCategory(categoryId);
		} catch (Exception e) {
			_log.info("error: " + e.getMessage());
		}
	}
	
	
	public int getCategoriesCount(long companyId) throws SystemException {
		return categoryLocalService.getCategoriesCount(companyId);
	}
	
	

	public List<Category> getCategories(long companyId) throws SystemException {
		return categoryLocalService.getCategories(companyId);
	}
	
	
	public List<Category> getRootCategories(long companyId) throws SystemException {
		return categoryLocalService.getRootCategories(companyId);
	}
	
	
	public List<Category> getChildCategories(long catId, long companyId) throws SystemException {
		return categoryLocalService.getChildCategories(catId, companyId);
	}
*/	
	
	public List<Category> getAllCategories(long companyId) throws SystemException {
		_log.debug("getAllCategories");
		return categoryLocalService.getCategories(companyId);
	}

}
