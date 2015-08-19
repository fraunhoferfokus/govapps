package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LanguageModel.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Language service. Represents a row in the &quot;mvp_Language&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.movepla.model.impl.LanguageImpl}.
 * </p>
 *
 * @author jpa
 * @see Language
 * @see de.fraunhofer.fokus.movepla.model.impl.LanguageImpl
 * @see de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl
 * @generated
 */
public interface LanguageModel extends BaseModel<Language> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a language model instance should use the {@link Language} interface instead.
     */

    /**
     * Returns the primary key of this language.
     *
     * @return the primary key of this language
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this language.
     *
     * @param primaryKey the primary key of this language
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the language ID of this language.
     *
     * @return the language ID of this language
     */
    public long getLanguageId();

    /**
     * Sets the language ID of this language.
     *
     * @param LanguageId the language ID of this language
     */
    public void setLanguageId(long LanguageId);

    /**
     * Returns the company ID of this language.
     *
     * @return the company ID of this language
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this language.
     *
     * @param companyId the company ID of this language
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this language.
     *
     * @return the user ID of this language
     */
    public long getUserId();

    /**
     * Sets the user ID of this language.
     *
     * @param userId the user ID of this language
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this language.
     *
     * @return the user uuid of this language
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this language.
     *
     * @param userUuid the user uuid of this language
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the create date of this language.
     *
     * @return the create date of this language
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this language.
     *
     * @param createDate the create date of this language
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this language.
     *
     * @return the modified date of this language
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this language.
     *
     * @param modifiedDate the modified date of this language
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the language name of this language.
     *
     * @return the language name of this language
     */
    @AutoEscape
    public String getLanguageName();

    /**
     * Sets the language name of this language.
     *
     * @param languageName the language name of this language
     */
    public void setLanguageName(String languageName);

    /**
     * Returns the language abbreviation of this language.
     *
     * @return the language abbreviation of this language
     */
    @AutoEscape
    public String getLanguageAbbreviation();

    /**
     * Sets the language abbreviation of this language.
     *
     * @param languageAbbreviation the language abbreviation of this language
     */
    public void setLanguageAbbreviation(String languageAbbreviation);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Language language);

    public int hashCode();

    public CacheModel<Language> toCacheModel();

    public Language toEscapedModel();

    public String toString();

    public String toXmlString();
}