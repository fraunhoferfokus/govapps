package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link LegalDetails}.
 * </p>
 *
 * @author    jpa
 * @see       LegalDetails
 * @generated
 */
public class LegalDetailsWrapper implements LegalDetails,
    ModelWrapper<LegalDetails> {
    private LegalDetails _legalDetails;

    public LegalDetailsWrapper(LegalDetails legalDetails) {
        _legalDetails = legalDetails;
    }

    public Class<?> getModelClass() {
        return LegalDetails.class;
    }

    public String getModelClassName() {
        return LegalDetails.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("legalDetailsId", getLegalDetailsId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("valueAddedTaxNo", getValueAddedTaxNo());
        attributes.put("registrationCourt", getRegistrationCourt());
        attributes.put("legalForm", getLegalForm());
        attributes.put("address", getAddress());
        attributes.put("telephone", getTelephone());
        attributes.put("email", getEmail());
        attributes.put("URL", getURL());
        attributes.put("fax", getFax());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long legalDetailsId = (Long) attributes.get("legalDetailsId");

        if (legalDetailsId != null) {
            setLegalDetailsId(legalDetailsId);
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

        String valueAddedTaxNo = (String) attributes.get("valueAddedTaxNo");

        if (valueAddedTaxNo != null) {
            setValueAddedTaxNo(valueAddedTaxNo);
        }

        String registrationCourt = (String) attributes.get("registrationCourt");

        if (registrationCourt != null) {
            setRegistrationCourt(registrationCourt);
        }

        String legalForm = (String) attributes.get("legalForm");

        if (legalForm != null) {
            setLegalForm(legalForm);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        String telephone = (String) attributes.get("telephone");

        if (telephone != null) {
            setTelephone(telephone);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String URL = (String) attributes.get("URL");

        if (URL != null) {
            setURL(URL);
        }

        String fax = (String) attributes.get("fax");

        if (fax != null) {
            setFax(fax);
        }
    }

    /**
    * Returns the primary key of this legal details.
    *
    * @return the primary key of this legal details
    */
    public long getPrimaryKey() {
        return _legalDetails.getPrimaryKey();
    }

    /**
    * Sets the primary key of this legal details.
    *
    * @param primaryKey the primary key of this legal details
    */
    public void setPrimaryKey(long primaryKey) {
        _legalDetails.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the legal details ID of this legal details.
    *
    * @return the legal details ID of this legal details
    */
    public long getLegalDetailsId() {
        return _legalDetails.getLegalDetailsId();
    }

    /**
    * Sets the legal details ID of this legal details.
    *
    * @param legalDetailsId the legal details ID of this legal details
    */
    public void setLegalDetailsId(long legalDetailsId) {
        _legalDetails.setLegalDetailsId(legalDetailsId);
    }

    /**
    * Returns the company ID of this legal details.
    *
    * @return the company ID of this legal details
    */
    public long getCompanyId() {
        return _legalDetails.getCompanyId();
    }

    /**
    * Sets the company ID of this legal details.
    *
    * @param companyId the company ID of this legal details
    */
    public void setCompanyId(long companyId) {
        _legalDetails.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this legal details.
    *
    * @return the user ID of this legal details
    */
    public long getUserId() {
        return _legalDetails.getUserId();
    }

    /**
    * Sets the user ID of this legal details.
    *
    * @param userId the user ID of this legal details
    */
    public void setUserId(long userId) {
        _legalDetails.setUserId(userId);
    }

    /**
    * Returns the user uuid of this legal details.
    *
    * @return the user uuid of this legal details
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _legalDetails.getUserUuid();
    }

    /**
    * Sets the user uuid of this legal details.
    *
    * @param userUuid the user uuid of this legal details
    */
    public void setUserUuid(java.lang.String userUuid) {
        _legalDetails.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this legal details.
    *
    * @return the create date of this legal details
    */
    public java.util.Date getCreateDate() {
        return _legalDetails.getCreateDate();
    }

    /**
    * Sets the create date of this legal details.
    *
    * @param createDate the create date of this legal details
    */
    public void setCreateDate(java.util.Date createDate) {
        _legalDetails.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this legal details.
    *
    * @return the modified date of this legal details
    */
    public java.util.Date getModifiedDate() {
        return _legalDetails.getModifiedDate();
    }

    /**
    * Sets the modified date of this legal details.
    *
    * @param modifiedDate the modified date of this legal details
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _legalDetails.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this legal details.
    *
    * @return the name of this legal details
    */
    public java.lang.String getName() {
        return _legalDetails.getName();
    }

    /**
    * Sets the name of this legal details.
    *
    * @param name the name of this legal details
    */
    public void setName(java.lang.String name) {
        _legalDetails.setName(name);
    }

    /**
    * Returns the value added tax no of this legal details.
    *
    * @return the value added tax no of this legal details
    */
    public java.lang.String getValueAddedTaxNo() {
        return _legalDetails.getValueAddedTaxNo();
    }

    /**
    * Sets the value added tax no of this legal details.
    *
    * @param valueAddedTaxNo the value added tax no of this legal details
    */
    public void setValueAddedTaxNo(java.lang.String valueAddedTaxNo) {
        _legalDetails.setValueAddedTaxNo(valueAddedTaxNo);
    }

    /**
    * Returns the registration court of this legal details.
    *
    * @return the registration court of this legal details
    */
    public java.lang.String getRegistrationCourt() {
        return _legalDetails.getRegistrationCourt();
    }

    /**
    * Sets the registration court of this legal details.
    *
    * @param registrationCourt the registration court of this legal details
    */
    public void setRegistrationCourt(java.lang.String registrationCourt) {
        _legalDetails.setRegistrationCourt(registrationCourt);
    }

    /**
    * Returns the legal form of this legal details.
    *
    * @return the legal form of this legal details
    */
    public java.lang.String getLegalForm() {
        return _legalDetails.getLegalForm();
    }

    /**
    * Sets the legal form of this legal details.
    *
    * @param legalForm the legal form of this legal details
    */
    public void setLegalForm(java.lang.String legalForm) {
        _legalDetails.setLegalForm(legalForm);
    }

    /**
    * Returns the address of this legal details.
    *
    * @return the address of this legal details
    */
    public java.lang.String getAddress() {
        return _legalDetails.getAddress();
    }

    /**
    * Sets the address of this legal details.
    *
    * @param address the address of this legal details
    */
    public void setAddress(java.lang.String address) {
        _legalDetails.setAddress(address);
    }

    /**
    * Returns the telephone of this legal details.
    *
    * @return the telephone of this legal details
    */
    public java.lang.String getTelephone() {
        return _legalDetails.getTelephone();
    }

    /**
    * Sets the telephone of this legal details.
    *
    * @param telephone the telephone of this legal details
    */
    public void setTelephone(java.lang.String telephone) {
        _legalDetails.setTelephone(telephone);
    }

    /**
    * Returns the email of this legal details.
    *
    * @return the email of this legal details
    */
    public java.lang.String getEmail() {
        return _legalDetails.getEmail();
    }

    /**
    * Sets the email of this legal details.
    *
    * @param email the email of this legal details
    */
    public void setEmail(java.lang.String email) {
        _legalDetails.setEmail(email);
    }

    /**
    * Returns the u r l of this legal details.
    *
    * @return the u r l of this legal details
    */
    public java.lang.String getURL() {
        return _legalDetails.getURL();
    }

    /**
    * Sets the u r l of this legal details.
    *
    * @param URL the u r l of this legal details
    */
    public void setURL(java.lang.String URL) {
        _legalDetails.setURL(URL);
    }

    /**
    * Returns the fax of this legal details.
    *
    * @return the fax of this legal details
    */
    public java.lang.String getFax() {
        return _legalDetails.getFax();
    }

    /**
    * Sets the fax of this legal details.
    *
    * @param fax the fax of this legal details
    */
    public void setFax(java.lang.String fax) {
        _legalDetails.setFax(fax);
    }

    public boolean isNew() {
        return _legalDetails.isNew();
    }

    public void setNew(boolean n) {
        _legalDetails.setNew(n);
    }

    public boolean isCachedModel() {
        return _legalDetails.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _legalDetails.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _legalDetails.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _legalDetails.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _legalDetails.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _legalDetails.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _legalDetails.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LegalDetailsWrapper((LegalDetails) _legalDetails.clone());
    }

    public int compareTo(LegalDetails legalDetails) {
        return _legalDetails.compareTo(legalDetails);
    }

    @Override
    public int hashCode() {
        return _legalDetails.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LegalDetails> toCacheModel() {
        return _legalDetails.toCacheModel();
    }

    public LegalDetails toEscapedModel() {
        return new LegalDetailsWrapper(_legalDetails.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _legalDetails.toString();
    }

    public java.lang.String toXmlString() {
        return _legalDetails.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _legalDetails.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public LegalDetails getWrappedLegalDetails() {
        return _legalDetails;
    }

    public LegalDetails getWrappedModel() {
        return _legalDetails;
    }

    public void resetOriginalValues() {
        _legalDetails.resetOriginalValues();
    }
}
