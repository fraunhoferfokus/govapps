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
 * $Id: CategoryLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.service.base.CategoryLocalServiceBaseImpl;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.CategoryLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(CategoryLocalServiceImpl.class);
	
	public Category addCategory(long userId, long companyId, String categoryName, long parentCategory) throws SystemException {
		long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
		_log.debug("addCategory: " + categoryId);
		
		Category category =  categoryPersistence.create(categoryId);
				
		category.setCategoryName(categoryName);
		category.setParentCategory(parentCategory);
		category.setUserId(userId);
		category.setCompanyId(companyId);
		category.setCreateDate(new Date());
		category.setModifiedDate((new Date()));		
		return categoryPersistence.update(category, true);		
	}
	
	
	public Category updateCategory(long userId, long companyId, long categoryId, String categoryName, long parentCategoryId) throws SystemException {
//		Permission.check(getPermissionChecker(), ActionKeys.DELETE_CATEGORY);
		Category category =  categoryPersistence.fetchByPrimaryKey(categoryId);
		category.setCategoryName(categoryName);
		category.setParentCategory(parentCategoryId);
		category.setUserId(userId);
		category.setCompanyId(companyId);
		category.setModifiedDate((new Date()));		
		return categoryPersistence.update(category, true);
	}
	
	public Category updateCategory(Category category) throws SystemException {		
		long categoryId = category.getCategoryId();
		_log.debug("updateCategory::categoryId: " + categoryId);
		Category model =  categoryPersistence.fetchByPrimaryKey(categoryId);
		model.setCompanyId(category.getCompanyId());
		model.setParentCategory(category.getParentCategory());
		model.setUserId(category.getUserId());
		model.setCategoryName(category.getCategoryName());
		model.setModifiedDate(new Date());
		return categoryPersistence.update(model, true);		
	}

	
	public Category addCategory(Category category) throws SystemException {		
		long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
		_log.debug("addCategory::categoryId: " + categoryId);
		Category model =  categoryPersistence.create(categoryId);
		model.setCompanyId(category.getCompanyId());
		model.setParentCategory(category.getParentCategory());
		model.setUserId(category.getUserId());
		model.setCategoryName(category.getCategoryName());
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		return categoryPersistence.update(model, true);		
	}
	
	
	@Override
	public Category deleteCategory(Category category) throws SystemException {
		List<Application>  apps = categoryPersistence.getApplications(category.getCategoryId());
		List<Category>  childs = getChildCategories(category.getCategoryId(), category.getCompanyId());
		
		if (apps.size() == 0 && childs.size() == 0) {
			categoryPersistence.remove(category);
			_log.debug("delete category");
		} else {
			_log.debug("category " + category.getCategoryName() + " is not empty");
			_log.debug("apps.size(): " + apps.size());
			_log.debug("childs.size()" + childs.size());
		}
		return category;
		
	}
	
	
	public Category deleteCategory(long categoryId) throws PortalException, SystemException {
		Category category =  categoryPersistence.findByPrimaryKey(categoryId);
		return deleteCategory(category);
	}
	
	
	public int getCategoriesCount(long companyId) throws SystemException {
		return categoryPersistence.countByc(companyId);
	}
	
	public Category getCategory(long categoryId) throws SystemException {
		return categoryPersistence.fetchByPrimaryKey(categoryId);
	}

	
	public List<Category> getCategories(long companyId) throws SystemException {
		return categoryPersistence.findByc(companyId);
	}
	
	
	public List<Category> getRootCategories(long companyId) throws SystemException {
		return categoryPersistence.findBycp(companyId, -1);
	}
	
	
	public List<Category> getChildCategories(long catId, long companyId) throws SystemException {
		return categoryPersistence.findBycp(companyId, catId);
	}
	

	public List<Application> getApplications(long catId) throws SystemException {
		return categoryPersistence.getApplications(catId);
	}
	
}
