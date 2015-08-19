package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Application_Entitlement}.
 * </p>
 *
 * @author    jpa
 * @see       Application_Entitlement
 * @generated
 */
public class Application_EntitlementWrapper implements Application_Entitlement,
    ModelWrapper<Application_Entitlement> {
    private Application_Entitlement _application_Entitlement;

    public Application_EntitlementWrapper(
        Application_Entitlement application_Entitlement) {
        _application_Entitlement = application_Entitlement;
    }

    public Class<?> getModelClass() {
        return Application_Entitlement.class;
    }

    public String getModelClassName() {
        return Application_Entitlement.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicationEntitlementID", getApplicationEntitlementID());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("motivation", getMotivation());
        attributes.put("applicationId", getApplicationId());
        attributes.put("entitlementId", getEntitlementId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicationEntitlementID = (Long) attributes.get(
                "applicationEntitlementID");

        if (applicationEntitlementID != null) {
            setApplicationEntitlementID(applicationEntitlementID);
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

        String motivation = (String) attributes.get("motivation");

        if (motivation != null) {
            setMotivation(motivation);
        }

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        Long entitlementId = (Long) attributes.get("entitlementId");

        if (entitlementId != null) {
            setEntitlementId(entitlementId);
        }
    }

    /**
    * Returns the primary key of this application_ entitlement.
    *
    * @return the primary key of this application_ entitlement
    */
    public long getPrimaryKey() {
        return _application_Entitlement.getPrimaryKey();
    }

    /**
    * Sets the primary key of this application_ entitlement.
    *
    * @param primaryKey the primary key of this application_ entitlement
    */
    public void setPrimaryKey(long primaryKey) {
        _application_Entitlement.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the application entitlement i d of this application_ entitlement.
    *
    * @return the application entitlement i d of this application_ entitlement
    */
    public long getApplicationEntitlementID() {
        return _application_Entitlement.getApplicationEntitlementID();
    }

    /**
    * Sets the application entitlement i d of this application_ entitlement.
    *
    * @param applicationEntitlementID the application entitlement i d of this application_ entitlement
    */
    public void setApplicationEntitlementID(long applicationEntitlementID) {
        _application_Entitlement.setApplicationEntitlementID(applicationEntitlementID);
    }

    /**
    * Returns the company ID of this application_ entitlement.
    *
    * @return the company ID of this application_ entitlement
    */
    public long getCompanyId() {
        return _application_Entitlement.getCompanyId();
    }

    /**
    * Sets the company ID of this application_ entitlement.
    *
    * @param companyId the company ID of this application_ entitlement
    */
    public void setCompanyId(long companyId) {
        _application_Entitlement.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this application_ entitlement.
    *
    * @return the user ID of this application_ entitlement
    */
    public long getUserId() {
        return _application_Entitlement.getUserId();
    }

    /**
    * Sets the user ID of this application_ entitlement.
    *
    * @param userId the user ID of this application_ entitlement
    */
    public void setUserId(long userId) {
        _application_Entitlement.setUserId(userId);
    }

    /**
    * Returns the user uuid of this application_ entitlement.
    *
    * @return the user uuid of this application_ entitlement
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_Entitlement.getUserUuid();
    }

    /**
    * Sets the user uuid of this application_ entitlement.
    *
    * @param userUuid the user uuid of this application_ entitlement
    */
    public void setUserUuid(java.lang.String userUuid) {
        _application_Entitlement.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this application_ entitlement.
    *
    * @return the create date of this application_ entitlement
    */
    public java.util.Date getCreateDate() {
        return _application_Entitlement.getCreateDate();
    }

    /**
    * Sets the create date of this application_ entitlement.
    *
    * @param createDate the create date of this application_ entitlement
    */
    public void setCreateDate(java.util.Date createDate) {
        _application_Entitlement.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this application_ entitlement.
    *
    * @return the modified date of this application_ entitlement
    */
    public java.util.Date getModifiedDate() {
        return _application_Entitlement.getModifiedDate();
    }

    /**
    * Sets the modified date of this application_ entitlement.
    *
    * @param modifiedDate the modified date of this application_ entitlement
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _application_Entitlement.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this application_ entitlement.
    *
    * @return the name of this application_ entitlement
    */
    public java.lang.String getName() {
        return _application_Entitlement.getName();
    }

    /**
    * Sets the name of this application_ entitlement.
    *
    * @param name the name of this application_ entitlement
    */
    public void setName(java.lang.String name) {
        _application_Entitlement.setName(name);
    }

    /**
    * Returns the motivation of this application_ entitlement.
    *
    * @return the motivation of this application_ entitlement
    */
    public java.lang.String getMotivation() {
        return _application_Entitlement.getMotivation();
    }

    /**
    * Sets the motivation of this application_ entitlement.
    *
    * @param motivation the motivation of this application_ entitlement
    */
    public void setMotivation(java.lang.String motivation) {
        _application_Entitlement.setMotivation(motivation);
    }

    /**
    * Returns the application ID of this application_ entitlement.
    *
    * @return the application ID of this application_ entitlement
    */
    public long getApplicationId() {
        return _application_Entitlement.getApplicationId();
    }

    /**
    * Sets the application ID of this application_ entitlement.
    *
    * @param applicationId the application ID of this application_ entitlement
    */
    public void setApplicationId(long applicationId) {
        _application_Entitlement.setApplicationId(applicationId);
    }

    /**
    * Returns the entitlement ID of this application_ entitlement.
    *
    * @return the entitlement ID of this application_ entitlement
    */
    public long getEntitlementId() {
        return _application_Entitlement.getEntitlementId();
    }

    /**
    * Sets the entitlement ID of this application_ entitlement.
    *
    * @param entitlementId the entitlement ID of this application_ entitlement
    */
    public void setEntitlementId(long entitlementId) {
        _application_Entitlement.setEntitlementId(entitlementId);
    }

    public boolean isNew() {
        return _application_Entitlement.isNew();
    }

    public void setNew(boolean n) {
        _application_Entitlement.setNew(n);
    }

    public boolean isCachedModel() {
        return _application_Entitlement.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _application_Entitlement.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _application_Entitlement.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _application_Entitlement.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _application_Entitlement.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _application_Entitlement.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _application_Entitlement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new Application_EntitlementWrapper((Application_Entitlement) _application_Entitlement.clone());
    }

    public int compareTo(Application_Entitlement application_Entitlement) {
        return _application_Entitlement.compareTo(application_Entitlement);
    }

    @Override
    public int hashCode() {
        return _application_Entitlement.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Application_Entitlement> toCacheModel() {
        return _application_Entitlement.toCacheModel();
    }

    public Application_Entitlement toEscapedModel() {
        return new Application_EntitlementWrapper(_application_Entitlement.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _application_Entitlement.toString();
    }

    public java.lang.String toXmlString() {
        return _application_Entitlement.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _application_Entitlement.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Application_Entitlement getWrappedApplication_Entitlement() {
        return _application_Entitlement;
    }

    public Application_Entitlement getWrappedModel() {
        return _application_Entitlement;
    }

    public void resetOriginalValues() {
        _application_Entitlement.resetOriginalValues();
    }
}
