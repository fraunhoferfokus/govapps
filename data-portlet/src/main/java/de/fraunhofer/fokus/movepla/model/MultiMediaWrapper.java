package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: MultiMediaWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link MultiMedia}.
 * </p>
 *
 * @author    jpa
 * @see       MultiMedia
 * @generated
 */
public class MultiMediaWrapper implements MultiMedia, ModelWrapper<MultiMedia> {
    private MultiMedia _multiMedia;

    public MultiMediaWrapper(MultiMedia multiMedia) {
        _multiMedia = multiMedia;
    }

    public Class<?> getModelClass() {
        return MultiMedia.class;
    }

    public String getModelClassName() {
        return MultiMedia.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("multiMediaId", getMultiMediaId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("type", getType());
        attributes.put("imageId", getImageId());
        attributes.put("applicationId", getApplicationId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long multiMediaId = (Long) attributes.get("multiMediaId");

        if (multiMediaId != null) {
            setMultiMediaId(multiMediaId);
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

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Long imageId = (Long) attributes.get("imageId");

        if (imageId != null) {
            setImageId(imageId);
        }

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }
    }

    /**
    * Returns the primary key of this multi media.
    *
    * @return the primary key of this multi media
    */
    public long getPrimaryKey() {
        return _multiMedia.getPrimaryKey();
    }

    /**
    * Sets the primary key of this multi media.
    *
    * @param primaryKey the primary key of this multi media
    */
    public void setPrimaryKey(long primaryKey) {
        _multiMedia.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the multi media ID of this multi media.
    *
    * @return the multi media ID of this multi media
    */
    public long getMultiMediaId() {
        return _multiMedia.getMultiMediaId();
    }

    /**
    * Sets the multi media ID of this multi media.
    *
    * @param multiMediaId the multi media ID of this multi media
    */
    public void setMultiMediaId(long multiMediaId) {
        _multiMedia.setMultiMediaId(multiMediaId);
    }

    /**
    * Returns the company ID of this multi media.
    *
    * @return the company ID of this multi media
    */
    public long getCompanyId() {
        return _multiMedia.getCompanyId();
    }

    /**
    * Sets the company ID of this multi media.
    *
    * @param companyId the company ID of this multi media
    */
    public void setCompanyId(long companyId) {
        _multiMedia.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this multi media.
    *
    * @return the user ID of this multi media
    */
    public long getUserId() {
        return _multiMedia.getUserId();
    }

    /**
    * Sets the user ID of this multi media.
    *
    * @param userId the user ID of this multi media
    */
    public void setUserId(long userId) {
        _multiMedia.setUserId(userId);
    }

    /**
    * Returns the user uuid of this multi media.
    *
    * @return the user uuid of this multi media
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _multiMedia.getUserUuid();
    }

    /**
    * Sets the user uuid of this multi media.
    *
    * @param userUuid the user uuid of this multi media
    */
    public void setUserUuid(java.lang.String userUuid) {
        _multiMedia.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this multi media.
    *
    * @return the create date of this multi media
    */
    public java.util.Date getCreateDate() {
        return _multiMedia.getCreateDate();
    }

    /**
    * Sets the create date of this multi media.
    *
    * @param createDate the create date of this multi media
    */
    public void setCreateDate(java.util.Date createDate) {
        _multiMedia.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this multi media.
    *
    * @return the modified date of this multi media
    */
    public java.util.Date getModifiedDate() {
        return _multiMedia.getModifiedDate();
    }

    /**
    * Sets the modified date of this multi media.
    *
    * @param modifiedDate the modified date of this multi media
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _multiMedia.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this multi media.
    *
    * @return the name of this multi media
    */
    public java.lang.String getName() {
        return _multiMedia.getName();
    }

    /**
    * Sets the name of this multi media.
    *
    * @param name the name of this multi media
    */
    public void setName(java.lang.String name) {
        _multiMedia.setName(name);
    }

    /**
    * Returns the type of this multi media.
    *
    * @return the type of this multi media
    */
    public int getType() {
        return _multiMedia.getType();
    }

    /**
    * Sets the type of this multi media.
    *
    * @param type the type of this multi media
    */
    public void setType(int type) {
        _multiMedia.setType(type);
    }

    /**
    * Returns the image ID of this multi media.
    *
    * @return the image ID of this multi media
    */
    public long getImageId() {
        return _multiMedia.getImageId();
    }

    /**
    * Sets the image ID of this multi media.
    *
    * @param imageId the image ID of this multi media
    */
    public void setImageId(long imageId) {
        _multiMedia.setImageId(imageId);
    }

    /**
    * Returns the application ID of this multi media.
    *
    * @return the application ID of this multi media
    */
    public long getApplicationId() {
        return _multiMedia.getApplicationId();
    }

    /**
    * Sets the application ID of this multi media.
    *
    * @param applicationId the application ID of this multi media
    */
    public void setApplicationId(long applicationId) {
        _multiMedia.setApplicationId(applicationId);
    }

    public boolean isNew() {
        return _multiMedia.isNew();
    }

    public void setNew(boolean n) {
        _multiMedia.setNew(n);
    }

    public boolean isCachedModel() {
        return _multiMedia.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _multiMedia.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _multiMedia.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _multiMedia.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _multiMedia.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _multiMedia.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _multiMedia.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MultiMediaWrapper((MultiMedia) _multiMedia.clone());
    }

    public int compareTo(MultiMedia multiMedia) {
        return _multiMedia.compareTo(multiMedia);
    }

    @Override
    public int hashCode() {
        return _multiMedia.hashCode();
    }

    public com.liferay.portal.model.CacheModel<MultiMedia> toCacheModel() {
        return _multiMedia.toCacheModel();
    }

    public MultiMedia toEscapedModel() {
        return new MultiMediaWrapper(_multiMedia.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _multiMedia.toString();
    }

    public java.lang.String toXmlString() {
        return _multiMedia.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _multiMedia.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public MultiMedia getWrappedMultiMedia() {
        return _multiMedia;
    }

    public MultiMedia getWrappedModel() {
        return _multiMedia;
    }

    public void resetOriginalValues() {
        _multiMedia.resetOriginalValues();
    }
}
