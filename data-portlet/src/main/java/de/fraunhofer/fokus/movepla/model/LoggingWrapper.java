package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LoggingWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Logging}.
 * </p>
 *
 * @author    jpa
 * @see       Logging
 * @generated
 */
public class LoggingWrapper implements Logging, ModelWrapper<Logging> {
    private Logging _logging;

    public LoggingWrapper(Logging logging) {
        _logging = logging;
    }

    public Class<?> getModelClass() {
        return Logging.class;
    }

    public String getModelClassName() {
        return Logging.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("loggingId", getLoggingId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("isSimpleSearch", getIsSimpleSearch());
        attributes.put("searchString", getSearchString());
        attributes.put("categoryIDString", getCategoryIDString());
        attributes.put("regionIDString", getRegionIDString());
        attributes.put("entitlementIDString", getEntitlementIDString());
        attributes.put("targetOS", getTargetOS());
        attributes.put("fee", getFee());
        attributes.put("targetCategory", getTargetCategory());
        attributes.put("passel", getPassel());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long loggingId = (Long) attributes.get("loggingId");

        if (loggingId != null) {
            setLoggingId(loggingId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Boolean isSimpleSearch = (Boolean) attributes.get("isSimpleSearch");

        if (isSimpleSearch != null) {
            setIsSimpleSearch(isSimpleSearch);
        }

        String searchString = (String) attributes.get("searchString");

        if (searchString != null) {
            setSearchString(searchString);
        }

        String categoryIDString = (String) attributes.get("categoryIDString");

        if (categoryIDString != null) {
            setCategoryIDString(categoryIDString);
        }

        String regionIDString = (String) attributes.get("regionIDString");

        if (regionIDString != null) {
            setRegionIDString(regionIDString);
        }

        String entitlementIDString = (String) attributes.get(
                "entitlementIDString");

        if (entitlementIDString != null) {
            setEntitlementIDString(entitlementIDString);
        }

        String targetOS = (String) attributes.get("targetOS");

        if (targetOS != null) {
            setTargetOS(targetOS);
        }

        Integer fee = (Integer) attributes.get("fee");

        if (fee != null) {
            setFee(fee);
        }

        String targetCategory = (String) attributes.get("targetCategory");

        if (targetCategory != null) {
            setTargetCategory(targetCategory);
        }

        Long passel = (Long) attributes.get("passel");

        if (passel != null) {
            setPassel(passel);
        }
    }

    /**
    * Returns the primary key of this logging.
    *
    * @return the primary key of this logging
    */
    public long getPrimaryKey() {
        return _logging.getPrimaryKey();
    }

    /**
    * Sets the primary key of this logging.
    *
    * @param primaryKey the primary key of this logging
    */
    public void setPrimaryKey(long primaryKey) {
        _logging.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the logging ID of this logging.
    *
    * @return the logging ID of this logging
    */
    public long getLoggingId() {
        return _logging.getLoggingId();
    }

    /**
    * Sets the logging ID of this logging.
    *
    * @param loggingId the logging ID of this logging
    */
    public void setLoggingId(long loggingId) {
        _logging.setLoggingId(loggingId);
    }

    /**
    * Returns the create date of this logging.
    *
    * @return the create date of this logging
    */
    public java.util.Date getCreateDate() {
        return _logging.getCreateDate();
    }

    /**
    * Sets the create date of this logging.
    *
    * @param createDate the create date of this logging
    */
    public void setCreateDate(java.util.Date createDate) {
        _logging.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this logging.
    *
    * @return the modified date of this logging
    */
    public java.util.Date getModifiedDate() {
        return _logging.getModifiedDate();
    }

    /**
    * Sets the modified date of this logging.
    *
    * @param modifiedDate the modified date of this logging
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _logging.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the is simple search of this logging.
    *
    * @return the is simple search of this logging
    */
    public java.lang.Boolean getIsSimpleSearch() {
        return _logging.getIsSimpleSearch();
    }

    /**
    * Sets the is simple search of this logging.
    *
    * @param isSimpleSearch the is simple search of this logging
    */
    public void setIsSimpleSearch(java.lang.Boolean isSimpleSearch) {
        _logging.setIsSimpleSearch(isSimpleSearch);
    }

    /**
    * Returns the search string of this logging.
    *
    * @return the search string of this logging
    */
    public java.lang.String getSearchString() {
        return _logging.getSearchString();
    }

    /**
    * Sets the search string of this logging.
    *
    * @param searchString the search string of this logging
    */
    public void setSearchString(java.lang.String searchString) {
        _logging.setSearchString(searchString);
    }

    /**
    * Returns the category i d string of this logging.
    *
    * @return the category i d string of this logging
    */
    public java.lang.String getCategoryIDString() {
        return _logging.getCategoryIDString();
    }

    /**
    * Sets the category i d string of this logging.
    *
    * @param categoryIDString the category i d string of this logging
    */
    public void setCategoryIDString(java.lang.String categoryIDString) {
        _logging.setCategoryIDString(categoryIDString);
    }

    /**
    * Returns the region i d string of this logging.
    *
    * @return the region i d string of this logging
    */
    public java.lang.String getRegionIDString() {
        return _logging.getRegionIDString();
    }

    /**
    * Sets the region i d string of this logging.
    *
    * @param regionIDString the region i d string of this logging
    */
    public void setRegionIDString(java.lang.String regionIDString) {
        _logging.setRegionIDString(regionIDString);
    }

    /**
    * Returns the entitlement i d string of this logging.
    *
    * @return the entitlement i d string of this logging
    */
    public java.lang.String getEntitlementIDString() {
        return _logging.getEntitlementIDString();
    }

    /**
    * Sets the entitlement i d string of this logging.
    *
    * @param entitlementIDString the entitlement i d string of this logging
    */
    public void setEntitlementIDString(java.lang.String entitlementIDString) {
        _logging.setEntitlementIDString(entitlementIDString);
    }

    /**
    * Returns the target o s of this logging.
    *
    * @return the target o s of this logging
    */
    public java.lang.String getTargetOS() {
        return _logging.getTargetOS();
    }

    /**
    * Sets the target o s of this logging.
    *
    * @param targetOS the target o s of this logging
    */
    public void setTargetOS(java.lang.String targetOS) {
        _logging.setTargetOS(targetOS);
    }

    /**
    * Returns the fee of this logging.
    *
    * @return the fee of this logging
    */
    public int getFee() {
        return _logging.getFee();
    }

    /**
    * Sets the fee of this logging.
    *
    * @param fee the fee of this logging
    */
    public void setFee(int fee) {
        _logging.setFee(fee);
    }

    /**
    * Returns the target category of this logging.
    *
    * @return the target category of this logging
    */
    public java.lang.String getTargetCategory() {
        return _logging.getTargetCategory();
    }

    /**
    * Sets the target category of this logging.
    *
    * @param targetCategory the target category of this logging
    */
    public void setTargetCategory(java.lang.String targetCategory) {
        _logging.setTargetCategory(targetCategory);
    }

    /**
    * Returns the passel of this logging.
    *
    * @return the passel of this logging
    */
    public long getPassel() {
        return _logging.getPassel();
    }

    /**
    * Sets the passel of this logging.
    *
    * @param passel the passel of this logging
    */
    public void setPassel(long passel) {
        _logging.setPassel(passel);
    }

    public boolean isNew() {
        return _logging.isNew();
    }

    public void setNew(boolean n) {
        _logging.setNew(n);
    }

    public boolean isCachedModel() {
        return _logging.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _logging.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _logging.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _logging.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _logging.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _logging.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _logging.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LoggingWrapper((Logging) _logging.clone());
    }

    public int compareTo(Logging logging) {
        return _logging.compareTo(logging);
    }

    @Override
    public int hashCode() {
        return _logging.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Logging> toCacheModel() {
        return _logging.toCacheModel();
    }

    public Logging toEscapedModel() {
        return new LoggingWrapper(_logging.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _logging.toString();
    }

    public java.lang.String toXmlString() {
        return _logging.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _logging.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Logging getWrappedLogging() {
        return _logging;
    }

    public Logging getWrappedModel() {
        return _logging;
    }

    public void resetOriginalValues() {
        _logging.resetOriginalValues();
    }
}
