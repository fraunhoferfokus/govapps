package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link RelatedApplications}.
 * </p>
 *
 * @author    jpa
 * @see       RelatedApplications
 * @generated
 */
public class RelatedApplicationsWrapper implements RelatedApplications,
    ModelWrapper<RelatedApplications> {
    private RelatedApplications _relatedApplications;

    public RelatedApplicationsWrapper(RelatedApplications relatedApplications) {
        _relatedApplications = relatedApplications;
    }

    public Class<?> getModelClass() {
        return RelatedApplications.class;
    }

    public String getModelClassName() {
        return RelatedApplications.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("RelatedApplicationsID", getRelatedApplicationsID());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("applicationId", getApplicationId());
        attributes.put("applicationId2", getApplicationId2());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long RelatedApplicationsID = (Long) attributes.get(
                "RelatedApplicationsID");

        if (RelatedApplicationsID != null) {
            setRelatedApplicationsID(RelatedApplicationsID);
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

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        Long applicationId2 = (Long) attributes.get("applicationId2");

        if (applicationId2 != null) {
            setApplicationId2(applicationId2);
        }
    }

    /**
    * Returns the primary key of this related applications.
    *
    * @return the primary key of this related applications
    */
    public long getPrimaryKey() {
        return _relatedApplications.getPrimaryKey();
    }

    /**
    * Sets the primary key of this related applications.
    *
    * @param primaryKey the primary key of this related applications
    */
    public void setPrimaryKey(long primaryKey) {
        _relatedApplications.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the related applications i d of this related applications.
    *
    * @return the related applications i d of this related applications
    */
    public long getRelatedApplicationsID() {
        return _relatedApplications.getRelatedApplicationsID();
    }

    /**
    * Sets the related applications i d of this related applications.
    *
    * @param RelatedApplicationsID the related applications i d of this related applications
    */
    public void setRelatedApplicationsID(long RelatedApplicationsID) {
        _relatedApplications.setRelatedApplicationsID(RelatedApplicationsID);
    }

    /**
    * Returns the company ID of this related applications.
    *
    * @return the company ID of this related applications
    */
    public long getCompanyId() {
        return _relatedApplications.getCompanyId();
    }

    /**
    * Sets the company ID of this related applications.
    *
    * @param companyId the company ID of this related applications
    */
    public void setCompanyId(long companyId) {
        _relatedApplications.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this related applications.
    *
    * @return the user ID of this related applications
    */
    public long getUserId() {
        return _relatedApplications.getUserId();
    }

    /**
    * Sets the user ID of this related applications.
    *
    * @param userId the user ID of this related applications
    */
    public void setUserId(long userId) {
        _relatedApplications.setUserId(userId);
    }

    /**
    * Returns the user uuid of this related applications.
    *
    * @return the user uuid of this related applications
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _relatedApplications.getUserUuid();
    }

    /**
    * Sets the user uuid of this related applications.
    *
    * @param userUuid the user uuid of this related applications
    */
    public void setUserUuid(java.lang.String userUuid) {
        _relatedApplications.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this related applications.
    *
    * @return the create date of this related applications
    */
    public java.util.Date getCreateDate() {
        return _relatedApplications.getCreateDate();
    }

    /**
    * Sets the create date of this related applications.
    *
    * @param createDate the create date of this related applications
    */
    public void setCreateDate(java.util.Date createDate) {
        _relatedApplications.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this related applications.
    *
    * @return the modified date of this related applications
    */
    public java.util.Date getModifiedDate() {
        return _relatedApplications.getModifiedDate();
    }

    /**
    * Sets the modified date of this related applications.
    *
    * @param modifiedDate the modified date of this related applications
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _relatedApplications.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the application ID of this related applications.
    *
    * @return the application ID of this related applications
    */
    public long getApplicationId() {
        return _relatedApplications.getApplicationId();
    }

    /**
    * Sets the application ID of this related applications.
    *
    * @param applicationId the application ID of this related applications
    */
    public void setApplicationId(long applicationId) {
        _relatedApplications.setApplicationId(applicationId);
    }

    /**
    * Returns the application id2 of this related applications.
    *
    * @return the application id2 of this related applications
    */
    public long getApplicationId2() {
        return _relatedApplications.getApplicationId2();
    }

    /**
    * Sets the application id2 of this related applications.
    *
    * @param applicationId2 the application id2 of this related applications
    */
    public void setApplicationId2(long applicationId2) {
        _relatedApplications.setApplicationId2(applicationId2);
    }

    public boolean isNew() {
        return _relatedApplications.isNew();
    }

    public void setNew(boolean n) {
        _relatedApplications.setNew(n);
    }

    public boolean isCachedModel() {
        return _relatedApplications.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _relatedApplications.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _relatedApplications.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _relatedApplications.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _relatedApplications.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _relatedApplications.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _relatedApplications.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RelatedApplicationsWrapper((RelatedApplications) _relatedApplications.clone());
    }

    public int compareTo(RelatedApplications relatedApplications) {
        return _relatedApplications.compareTo(relatedApplications);
    }

    @Override
    public int hashCode() {
        return _relatedApplications.hashCode();
    }

    public com.liferay.portal.model.CacheModel<RelatedApplications> toCacheModel() {
        return _relatedApplications.toCacheModel();
    }

    public RelatedApplications toEscapedModel() {
        return new RelatedApplicationsWrapper(_relatedApplications.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _relatedApplications.toString();
    }

    public java.lang.String toXmlString() {
        return _relatedApplications.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _relatedApplications.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public RelatedApplications getWrappedRelatedApplications() {
        return _relatedApplications;
    }

    public RelatedApplications getWrappedModel() {
        return _relatedApplications;
    }

    public void resetOriginalValues() {
        _relatedApplications.resetOriginalValues();
    }
}
