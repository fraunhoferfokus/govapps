package com.govapps.persistence.model;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernWrapper.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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
 * This class is a wrapper for {@link Concern}.
 * </p>
 *
 * @author    ekl
 * @see       Concern
 * @generated
 */
public class ConcernWrapper implements Concern, ModelWrapper<Concern> {
    private Concern _concern;

    public ConcernWrapper(Concern concern) {
        _concern = concern;
    }

    public Class<?> getModelClass() {
        return Concern.class;
    }

    public String getModelClassName() {
        return Concern.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("email", getEmail());
        attributes.put("description", getDescription());
        attributes.put("platforms", getPlatforms());
        attributes.put("concern", getConcern());
        attributes.put("region", getRegion());
        attributes.put("category", getCategory());
        attributes.put("createDate", getCreateDate());
        attributes.put("supports", getSupports());
        attributes.put("state", getState());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String platforms = (String) attributes.get("platforms");

        if (platforms != null) {
            setPlatforms(platforms);
        }

        Long concern = (Long) attributes.get("concern");

        if (concern != null) {
            setConcern(concern);
        }

        String region = (String) attributes.get("region");

        if (region != null) {
            setRegion(region);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Long supports = (Long) attributes.get("supports");

        if (supports != null) {
            setSupports(supports);
        }

        Integer state = (Integer) attributes.get("state");

        if (state != null) {
            setState(state);
        }
    }

    /**
    * Returns the primary key of this concern.
    *
    * @return the primary key of this concern
    */
    public long getPrimaryKey() {
        return _concern.getPrimaryKey();
    }

    /**
    * Sets the primary key of this concern.
    *
    * @param primaryKey the primary key of this concern
    */
    public void setPrimaryKey(long primaryKey) {
        _concern.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this concern.
    *
    * @return the ID of this concern
    */
    public long getId() {
        return _concern.getId();
    }

    /**
    * Sets the ID of this concern.
    *
    * @param id the ID of this concern
    */
    public void setId(long id) {
        _concern.setId(id);
    }

    /**
    * Returns the company ID of this concern.
    *
    * @return the company ID of this concern
    */
    public long getCompanyId() {
        return _concern.getCompanyId();
    }

    /**
    * Sets the company ID of this concern.
    *
    * @param companyId the company ID of this concern
    */
    public void setCompanyId(long companyId) {
        _concern.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this concern.
    *
    * @return the group ID of this concern
    */
    public long getGroupId() {
        return _concern.getGroupId();
    }

    /**
    * Sets the group ID of this concern.
    *
    * @param groupId the group ID of this concern
    */
    public void setGroupId(long groupId) {
        _concern.setGroupId(groupId);
    }

    /**
    * Returns the name of this concern.
    *
    * @return the name of this concern
    */
    public java.lang.String getName() {
        return _concern.getName();
    }

    /**
    * Sets the name of this concern.
    *
    * @param name the name of this concern
    */
    public void setName(java.lang.String name) {
        _concern.setName(name);
    }

    /**
    * Returns the email of this concern.
    *
    * @return the email of this concern
    */
    public java.lang.String getEmail() {
        return _concern.getEmail();
    }

    /**
    * Sets the email of this concern.
    *
    * @param email the email of this concern
    */
    public void setEmail(java.lang.String email) {
        _concern.setEmail(email);
    }

    /**
    * Returns the description of this concern.
    *
    * @return the description of this concern
    */
    public java.lang.String getDescription() {
        return _concern.getDescription();
    }

    /**
    * Sets the description of this concern.
    *
    * @param description the description of this concern
    */
    public void setDescription(java.lang.String description) {
        _concern.setDescription(description);
    }

    /**
    * Returns the platforms of this concern.
    *
    * @return the platforms of this concern
    */
    public java.lang.String getPlatforms() {
        return _concern.getPlatforms();
    }

    /**
    * Sets the platforms of this concern.
    *
    * @param platforms the platforms of this concern
    */
    public void setPlatforms(java.lang.String platforms) {
        _concern.setPlatforms(platforms);
    }

    /**
    * Returns the concern of this concern.
    *
    * @return the concern of this concern
    */
    public long getConcern() {
        return _concern.getConcern();
    }

    /**
    * Sets the concern of this concern.
    *
    * @param concern the concern of this concern
    */
    public void setConcern(long concern) {
        _concern.setConcern(concern);
    }

    /**
    * Returns the region of this concern.
    *
    * @return the region of this concern
    */
    public java.lang.String getRegion() {
        return _concern.getRegion();
    }

    /**
    * Sets the region of this concern.
    *
    * @param region the region of this concern
    */
    public void setRegion(java.lang.String region) {
        _concern.setRegion(region);
    }

    /**
    * Returns the category of this concern.
    *
    * @return the category of this concern
    */
    public java.lang.String getCategory() {
        return _concern.getCategory();
    }

    /**
    * Sets the category of this concern.
    *
    * @param category the category of this concern
    */
    public void setCategory(java.lang.String category) {
        _concern.setCategory(category);
    }

    /**
    * Returns the create date of this concern.
    *
    * @return the create date of this concern
    */
    public java.util.Date getCreateDate() {
        return _concern.getCreateDate();
    }

    /**
    * Sets the create date of this concern.
    *
    * @param createDate the create date of this concern
    */
    public void setCreateDate(java.util.Date createDate) {
        _concern.setCreateDate(createDate);
    }

    /**
    * Returns the supports of this concern.
    *
    * @return the supports of this concern
    */
    public long getSupports() {
        return _concern.getSupports();
    }

    /**
    * Sets the supports of this concern.
    *
    * @param supports the supports of this concern
    */
    public void setSupports(long supports) {
        _concern.setSupports(supports);
    }

    /**
    * Returns the state of this concern.
    *
    * @return the state of this concern
    */
    public int getState() {
        return _concern.getState();
    }

    /**
    * Sets the state of this concern.
    *
    * @param state the state of this concern
    */
    public void setState(int state) {
        _concern.setState(state);
    }

    public boolean isNew() {
        return _concern.isNew();
    }

    public void setNew(boolean n) {
        _concern.setNew(n);
    }

    public boolean isCachedModel() {
        return _concern.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _concern.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _concern.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _concern.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _concern.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _concern.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _concern.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ConcernWrapper((Concern) _concern.clone());
    }

    public int compareTo(Concern concern) {
        return _concern.compareTo(concern);
    }

    @Override
    public int hashCode() {
        return _concern.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Concern> toCacheModel() {
        return _concern.toCacheModel();
    }

    public Concern toEscapedModel() {
        return new ConcernWrapper(_concern.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _concern.toString();
    }

    public java.lang.String toXmlString() {
        return _concern.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _concern.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Concern getWrappedConcern() {
        return _concern;
    }

    public Concern getWrappedModel() {
        return _concern;
    }

    public void resetOriginalValues() {
        _concern.resetOriginalValues();
    }
}
