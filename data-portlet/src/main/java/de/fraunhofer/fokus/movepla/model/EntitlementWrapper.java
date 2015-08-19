package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: EntitlementWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Entitlement}.
 * </p>
 *
 * @author    jpa
 * @see       Entitlement
 * @generated
 */
public class EntitlementWrapper implements Entitlement,
    ModelWrapper<Entitlement> {
    private Entitlement _entitlement;

    public EntitlementWrapper(Entitlement entitlement) {
        _entitlement = entitlement;
    }

    public Class<?> getModelClass() {
        return Entitlement.class;
    }

    public String getModelClassName() {
        return Entitlement.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entitlementId", getEntitlementId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("entitlementName", getEntitlementName());
        attributes.put("explanation", getExplanation());
        attributes.put("estimation", getEstimation());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long entitlementId = (Long) attributes.get("entitlementId");

        if (entitlementId != null) {
            setEntitlementId(entitlementId);
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

        String entitlementName = (String) attributes.get("entitlementName");

        if (entitlementName != null) {
            setEntitlementName(entitlementName);
        }

        String explanation = (String) attributes.get("explanation");

        if (explanation != null) {
            setExplanation(explanation);
        }

        String estimation = (String) attributes.get("estimation");

        if (estimation != null) {
            setEstimation(estimation);
        }
    }

    /**
    * Returns the primary key of this entitlement.
    *
    * @return the primary key of this entitlement
    */
    public long getPrimaryKey() {
        return _entitlement.getPrimaryKey();
    }

    /**
    * Sets the primary key of this entitlement.
    *
    * @param primaryKey the primary key of this entitlement
    */
    public void setPrimaryKey(long primaryKey) {
        _entitlement.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the entitlement ID of this entitlement.
    *
    * @return the entitlement ID of this entitlement
    */
    public long getEntitlementId() {
        return _entitlement.getEntitlementId();
    }

    /**
    * Sets the entitlement ID of this entitlement.
    *
    * @param entitlementId the entitlement ID of this entitlement
    */
    public void setEntitlementId(long entitlementId) {
        _entitlement.setEntitlementId(entitlementId);
    }

    /**
    * Returns the company ID of this entitlement.
    *
    * @return the company ID of this entitlement
    */
    public long getCompanyId() {
        return _entitlement.getCompanyId();
    }

    /**
    * Sets the company ID of this entitlement.
    *
    * @param companyId the company ID of this entitlement
    */
    public void setCompanyId(long companyId) {
        _entitlement.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this entitlement.
    *
    * @return the user ID of this entitlement
    */
    public long getUserId() {
        return _entitlement.getUserId();
    }

    /**
    * Sets the user ID of this entitlement.
    *
    * @param userId the user ID of this entitlement
    */
    public void setUserId(long userId) {
        _entitlement.setUserId(userId);
    }

    /**
    * Returns the user uuid of this entitlement.
    *
    * @return the user uuid of this entitlement
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entitlement.getUserUuid();
    }

    /**
    * Sets the user uuid of this entitlement.
    *
    * @param userUuid the user uuid of this entitlement
    */
    public void setUserUuid(java.lang.String userUuid) {
        _entitlement.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this entitlement.
    *
    * @return the create date of this entitlement
    */
    public java.util.Date getCreateDate() {
        return _entitlement.getCreateDate();
    }

    /**
    * Sets the create date of this entitlement.
    *
    * @param createDate the create date of this entitlement
    */
    public void setCreateDate(java.util.Date createDate) {
        _entitlement.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this entitlement.
    *
    * @return the modified date of this entitlement
    */
    public java.util.Date getModifiedDate() {
        return _entitlement.getModifiedDate();
    }

    /**
    * Sets the modified date of this entitlement.
    *
    * @param modifiedDate the modified date of this entitlement
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _entitlement.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the entitlement name of this entitlement.
    *
    * @return the entitlement name of this entitlement
    */
    public java.lang.String getEntitlementName() {
        return _entitlement.getEntitlementName();
    }

    /**
    * Sets the entitlement name of this entitlement.
    *
    * @param entitlementName the entitlement name of this entitlement
    */
    public void setEntitlementName(java.lang.String entitlementName) {
        _entitlement.setEntitlementName(entitlementName);
    }

    /**
    * Returns the explanation of this entitlement.
    *
    * @return the explanation of this entitlement
    */
    public java.lang.String getExplanation() {
        return _entitlement.getExplanation();
    }

    /**
    * Sets the explanation of this entitlement.
    *
    * @param explanation the explanation of this entitlement
    */
    public void setExplanation(java.lang.String explanation) {
        _entitlement.setExplanation(explanation);
    }

    /**
    * Returns the estimation of this entitlement.
    *
    * @return the estimation of this entitlement
    */
    public java.lang.String getEstimation() {
        return _entitlement.getEstimation();
    }

    /**
    * Sets the estimation of this entitlement.
    *
    * @param estimation the estimation of this entitlement
    */
    public void setEstimation(java.lang.String estimation) {
        _entitlement.setEstimation(estimation);
    }

    public boolean isNew() {
        return _entitlement.isNew();
    }

    public void setNew(boolean n) {
        _entitlement.setNew(n);
    }

    public boolean isCachedModel() {
        return _entitlement.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _entitlement.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _entitlement.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _entitlement.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _entitlement.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _entitlement.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _entitlement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EntitlementWrapper((Entitlement) _entitlement.clone());
    }

    public int compareTo(Entitlement entitlement) {
        return _entitlement.compareTo(entitlement);
    }

    @Override
    public int hashCode() {
        return _entitlement.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Entitlement> toCacheModel() {
        return _entitlement.toCacheModel();
    }

    public Entitlement toEscapedModel() {
        return new EntitlementWrapper(_entitlement.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _entitlement.toString();
    }

    public java.lang.String toXmlString() {
        return _entitlement.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _entitlement.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Entitlement getWrappedEntitlement() {
        return _entitlement;
    }

    public Entitlement getWrappedModel() {
        return _entitlement;
    }

    public void resetOriginalValues() {
        _entitlement.resetOriginalValues();
    }
}
