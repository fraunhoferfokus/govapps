package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LinkWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Link}.
 * </p>
 *
 * @author    jpa
 * @see       Link
 * @generated
 */
public class LinkWrapper implements Link, ModelWrapper<Link> {
    private Link _link;

    public LinkWrapper(Link link) {
        _link = link;
    }

    public Class<?> getModelClass() {
        return Link.class;
    }

    public String getModelClassName() {
        return Link.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("linkId", getLinkId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("displayName", getDisplayName());
        attributes.put("type", getType());
        attributes.put("url", getUrl());
        attributes.put("applicationId", getApplicationId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long linkId = (Long) attributes.get("linkId");

        if (linkId != null) {
            setLinkId(linkId);
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

        String displayName = (String) attributes.get("displayName");

        if (displayName != null) {
            setDisplayName(displayName);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }
    }

    /**
    * Returns the primary key of this link.
    *
    * @return the primary key of this link
    */
    public long getPrimaryKey() {
        return _link.getPrimaryKey();
    }

    /**
    * Sets the primary key of this link.
    *
    * @param primaryKey the primary key of this link
    */
    public void setPrimaryKey(long primaryKey) {
        _link.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the link ID of this link.
    *
    * @return the link ID of this link
    */
    public long getLinkId() {
        return _link.getLinkId();
    }

    /**
    * Sets the link ID of this link.
    *
    * @param linkId the link ID of this link
    */
    public void setLinkId(long linkId) {
        _link.setLinkId(linkId);
    }

    /**
    * Returns the company ID of this link.
    *
    * @return the company ID of this link
    */
    public long getCompanyId() {
        return _link.getCompanyId();
    }

    /**
    * Sets the company ID of this link.
    *
    * @param companyId the company ID of this link
    */
    public void setCompanyId(long companyId) {
        _link.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this link.
    *
    * @return the user ID of this link
    */
    public long getUserId() {
        return _link.getUserId();
    }

    /**
    * Sets the user ID of this link.
    *
    * @param userId the user ID of this link
    */
    public void setUserId(long userId) {
        _link.setUserId(userId);
    }

    /**
    * Returns the user uuid of this link.
    *
    * @return the user uuid of this link
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _link.getUserUuid();
    }

    /**
    * Sets the user uuid of this link.
    *
    * @param userUuid the user uuid of this link
    */
    public void setUserUuid(java.lang.String userUuid) {
        _link.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this link.
    *
    * @return the create date of this link
    */
    public java.util.Date getCreateDate() {
        return _link.getCreateDate();
    }

    /**
    * Sets the create date of this link.
    *
    * @param createDate the create date of this link
    */
    public void setCreateDate(java.util.Date createDate) {
        _link.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this link.
    *
    * @return the modified date of this link
    */
    public java.util.Date getModifiedDate() {
        return _link.getModifiedDate();
    }

    /**
    * Sets the modified date of this link.
    *
    * @param modifiedDate the modified date of this link
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _link.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the display name of this link.
    *
    * @return the display name of this link
    */
    public java.lang.String getDisplayName() {
        return _link.getDisplayName();
    }

    /**
    * Sets the display name of this link.
    *
    * @param displayName the display name of this link
    */
    public void setDisplayName(java.lang.String displayName) {
        _link.setDisplayName(displayName);
    }

    /**
    * Returns the type of this link.
    *
    * @return the type of this link
    */
    public int getType() {
        return _link.getType();
    }

    /**
    * Sets the type of this link.
    *
    * @param type the type of this link
    */
    public void setType(int type) {
        _link.setType(type);
    }

    /**
    * Returns the url of this link.
    *
    * @return the url of this link
    */
    public java.lang.String getUrl() {
        return _link.getUrl();
    }

    /**
    * Sets the url of this link.
    *
    * @param url the url of this link
    */
    public void setUrl(java.lang.String url) {
        _link.setUrl(url);
    }

    /**
    * Returns the application ID of this link.
    *
    * @return the application ID of this link
    */
    public long getApplicationId() {
        return _link.getApplicationId();
    }

    /**
    * Sets the application ID of this link.
    *
    * @param applicationId the application ID of this link
    */
    public void setApplicationId(long applicationId) {
        _link.setApplicationId(applicationId);
    }

    public boolean isNew() {
        return _link.isNew();
    }

    public void setNew(boolean n) {
        _link.setNew(n);
    }

    public boolean isCachedModel() {
        return _link.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _link.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _link.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _link.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _link.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _link.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _link.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LinkWrapper((Link) _link.clone());
    }

    public int compareTo(Link link) {
        return _link.compareTo(link);
    }

    @Override
    public int hashCode() {
        return _link.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Link> toCacheModel() {
        return _link.toCacheModel();
    }

    public Link toEscapedModel() {
        return new LinkWrapper(_link.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _link.toString();
    }

    public java.lang.String toXmlString() {
        return _link.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _link.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Link getWrappedLink() {
        return _link;
    }

    public Link getWrappedModel() {
        return _link;
    }

    public void resetOriginalValues() {
        _link.resetOriginalValues();
    }
}
