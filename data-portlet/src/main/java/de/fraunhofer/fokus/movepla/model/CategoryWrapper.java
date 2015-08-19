package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: CategoryWrapper.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author    jpa
 * @see       Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
    private Category _category;

    public CategoryWrapper(Category category) {
        _category = category;
    }

    public Class<?> getModelClass() {
        return Category.class;
    }

    public String getModelClassName() {
        return Category.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("categoryId", getCategoryId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("categoryName", getCategoryName());
        attributes.put("parentCategory", getParentCategory());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String categoryName = (String) attributes.get("categoryName");

        if (categoryName != null) {
            setCategoryName(categoryName);
        }

        Long parentCategory = (Long) attributes.get("parentCategory");

        if (parentCategory != null) {
            setParentCategory(parentCategory);
        }
    }

    /**
    * Returns the primary key of this category.
    *
    * @return the primary key of this category
    */
    public long getPrimaryKey() {
        return _category.getPrimaryKey();
    }

    /**
    * Sets the primary key of this category.
    *
    * @param primaryKey the primary key of this category
    */
    public void setPrimaryKey(long primaryKey) {
        _category.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the category ID of this category.
    *
    * @return the category ID of this category
    */
    public long getCategoryId() {
        return _category.getCategoryId();
    }

    /**
    * Sets the category ID of this category.
    *
    * @param categoryId the category ID of this category
    */
    public void setCategoryId(long categoryId) {
        _category.setCategoryId(categoryId);
    }

    /**
    * Returns the company ID of this category.
    *
    * @return the company ID of this category
    */
    public long getCompanyId() {
        return _category.getCompanyId();
    }

    /**
    * Sets the company ID of this category.
    *
    * @param companyId the company ID of this category
    */
    public void setCompanyId(long companyId) {
        _category.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this category.
    *
    * @return the user ID of this category
    */
    public long getUserId() {
        return _category.getUserId();
    }

    /**
    * Sets the user ID of this category.
    *
    * @param userId the user ID of this category
    */
    public void setUserId(long userId) {
        _category.setUserId(userId);
    }

    /**
    * Returns the user uuid of this category.
    *
    * @return the user uuid of this category
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _category.getUserUuid();
    }

    /**
    * Sets the user uuid of this category.
    *
    * @param userUuid the user uuid of this category
    */
    public void setUserUuid(java.lang.String userUuid) {
        _category.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this category.
    *
    * @return the create date of this category
    */
    public java.util.Date getCreateDate() {
        return _category.getCreateDate();
    }

    /**
    * Sets the create date of this category.
    *
    * @param createDate the create date of this category
    */
    public void setCreateDate(java.util.Date createDate) {
        _category.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this category.
    *
    * @return the modified date of this category
    */
    public java.util.Date getModifiedDate() {
        return _category.getModifiedDate();
    }

    /**
    * Sets the modified date of this category.
    *
    * @param modifiedDate the modified date of this category
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _category.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the category name of this category.
    *
    * @return the category name of this category
    */
    public java.lang.String getCategoryName() {
        return _category.getCategoryName();
    }

    /**
    * Sets the category name of this category.
    *
    * @param categoryName the category name of this category
    */
    public void setCategoryName(java.lang.String categoryName) {
        _category.setCategoryName(categoryName);
    }

    /**
    * Returns the parent category of this category.
    *
    * @return the parent category of this category
    */
    public long getParentCategory() {
        return _category.getParentCategory();
    }

    /**
    * Sets the parent category of this category.
    *
    * @param parentCategory the parent category of this category
    */
    public void setParentCategory(long parentCategory) {
        _category.setParentCategory(parentCategory);
    }

    public boolean isNew() {
        return _category.isNew();
    }

    public void setNew(boolean n) {
        _category.setNew(n);
    }

    public boolean isCachedModel() {
        return _category.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _category.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _category.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _category.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _category.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _category.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _category.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CategoryWrapper((Category) _category.clone());
    }

    public int compareTo(Category category) {
        return _category.compareTo(category);
    }

    @Override
    public int hashCode() {
        return _category.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Category> toCacheModel() {
        return _category.toCacheModel();
    }

    public Category toEscapedModel() {
        return new CategoryWrapper(_category.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _category.toString();
    }

    public java.lang.String toXmlString() {
        return _category.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _category.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Category getWrappedCategory() {
        return _category;
    }

    public Category getWrappedModel() {
        return _category;
    }

    public void resetOriginalValues() {
        _category.resetOriginalValues();
    }
}
