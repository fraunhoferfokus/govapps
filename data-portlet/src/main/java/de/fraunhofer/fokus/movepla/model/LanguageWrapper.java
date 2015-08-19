package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LanguageWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Language}.
 * </p>
 *
 * @author    jpa
 * @see       Language
 * @generated
 */
public class LanguageWrapper implements Language, ModelWrapper<Language> {
    private Language _language;

    public LanguageWrapper(Language language) {
        _language = language;
    }

    public Class<?> getModelClass() {
        return Language.class;
    }

    public String getModelClassName() {
        return Language.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("LanguageId", getLanguageId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("languageName", getLanguageName());
        attributes.put("languageAbbreviation", getLanguageAbbreviation());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long LanguageId = (Long) attributes.get("LanguageId");

        if (LanguageId != null) {
            setLanguageId(LanguageId);
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

        String languageName = (String) attributes.get("languageName");

        if (languageName != null) {
            setLanguageName(languageName);
        }

        String languageAbbreviation = (String) attributes.get(
                "languageAbbreviation");

        if (languageAbbreviation != null) {
            setLanguageAbbreviation(languageAbbreviation);
        }
    }

    /**
    * Returns the primary key of this language.
    *
    * @return the primary key of this language
    */
    public long getPrimaryKey() {
        return _language.getPrimaryKey();
    }

    /**
    * Sets the primary key of this language.
    *
    * @param primaryKey the primary key of this language
    */
    public void setPrimaryKey(long primaryKey) {
        _language.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the language ID of this language.
    *
    * @return the language ID of this language
    */
    public long getLanguageId() {
        return _language.getLanguageId();
    }

    /**
    * Sets the language ID of this language.
    *
    * @param LanguageId the language ID of this language
    */
    public void setLanguageId(long LanguageId) {
        _language.setLanguageId(LanguageId);
    }

    /**
    * Returns the company ID of this language.
    *
    * @return the company ID of this language
    */
    public long getCompanyId() {
        return _language.getCompanyId();
    }

    /**
    * Sets the company ID of this language.
    *
    * @param companyId the company ID of this language
    */
    public void setCompanyId(long companyId) {
        _language.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this language.
    *
    * @return the user ID of this language
    */
    public long getUserId() {
        return _language.getUserId();
    }

    /**
    * Sets the user ID of this language.
    *
    * @param userId the user ID of this language
    */
    public void setUserId(long userId) {
        _language.setUserId(userId);
    }

    /**
    * Returns the user uuid of this language.
    *
    * @return the user uuid of this language
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _language.getUserUuid();
    }

    /**
    * Sets the user uuid of this language.
    *
    * @param userUuid the user uuid of this language
    */
    public void setUserUuid(java.lang.String userUuid) {
        _language.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this language.
    *
    * @return the create date of this language
    */
    public java.util.Date getCreateDate() {
        return _language.getCreateDate();
    }

    /**
    * Sets the create date of this language.
    *
    * @param createDate the create date of this language
    */
    public void setCreateDate(java.util.Date createDate) {
        _language.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this language.
    *
    * @return the modified date of this language
    */
    public java.util.Date getModifiedDate() {
        return _language.getModifiedDate();
    }

    /**
    * Sets the modified date of this language.
    *
    * @param modifiedDate the modified date of this language
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _language.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the language name of this language.
    *
    * @return the language name of this language
    */
    public java.lang.String getLanguageName() {
        return _language.getLanguageName();
    }

    /**
    * Sets the language name of this language.
    *
    * @param languageName the language name of this language
    */
    public void setLanguageName(java.lang.String languageName) {
        _language.setLanguageName(languageName);
    }

    /**
    * Returns the language abbreviation of this language.
    *
    * @return the language abbreviation of this language
    */
    public java.lang.String getLanguageAbbreviation() {
        return _language.getLanguageAbbreviation();
    }

    /**
    * Sets the language abbreviation of this language.
    *
    * @param languageAbbreviation the language abbreviation of this language
    */
    public void setLanguageAbbreviation(java.lang.String languageAbbreviation) {
        _language.setLanguageAbbreviation(languageAbbreviation);
    }

    public boolean isNew() {
        return _language.isNew();
    }

    public void setNew(boolean n) {
        _language.setNew(n);
    }

    public boolean isCachedModel() {
        return _language.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _language.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _language.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _language.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _language.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _language.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _language.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LanguageWrapper((Language) _language.clone());
    }

    public int compareTo(Language language) {
        return _language.compareTo(language);
    }

    @Override
    public int hashCode() {
        return _language.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Language> toCacheModel() {
        return _language.toCacheModel();
    }

    public Language toEscapedModel() {
        return new LanguageWrapper(_language.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _language.toString();
    }

    public java.lang.String toXmlString() {
        return _language.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _language.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Language getWrappedLanguage() {
        return _language;
    }

    public Language getWrappedModel() {
        return _language;
    }

    public void resetOriginalValues() {
        _language.resetOriginalValues();
    }
}
