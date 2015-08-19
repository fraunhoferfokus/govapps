package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LanguageClp.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.movepla.service.LanguageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LanguageClp extends BaseModelImpl<Language> implements Language {
    private long _LanguageId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _languageName;
    private String _languageAbbreviation;
    private BaseModel<?> _languageRemoteModel;

    public LanguageClp() {
    }

    public Class<?> getModelClass() {
        return Language.class;
    }

    public String getModelClassName() {
        return Language.class.getName();
    }

    public long getPrimaryKey() {
        return _LanguageId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLanguageId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_LanguageId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getLanguageId() {
        return _LanguageId;
    }

    public void setLanguageId(long LanguageId) {
        _LanguageId = LanguageId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getLanguageName() {
        return _languageName;
    }

    public void setLanguageName(String languageName) {
        _languageName = languageName;
    }

    public String getLanguageAbbreviation() {
        return _languageAbbreviation;
    }

    public void setLanguageAbbreviation(String languageAbbreviation) {
        _languageAbbreviation = languageAbbreviation;
    }

    public BaseModel<?> getLanguageRemoteModel() {
        return _languageRemoteModel;
    }

    public void setLanguageRemoteModel(BaseModel<?> languageRemoteModel) {
        _languageRemoteModel = languageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LanguageLocalServiceUtil.addLanguage(this);
        } else {
            LanguageLocalServiceUtil.updateLanguage(this);
        }
    }

    @Override
    public Language toEscapedModel() {
        return (Language) Proxy.newProxyInstance(Language.class.getClassLoader(),
            new Class[] { Language.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LanguageClp clone = new LanguageClp();

        clone.setLanguageId(getLanguageId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setLanguageName(getLanguageName());
        clone.setLanguageAbbreviation(getLanguageAbbreviation());

        return clone;
    }

    public int compareTo(Language language) {
        long primaryKey = language.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LanguageClp language = null;

        try {
            language = (LanguageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = language.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{LanguageId=");
        sb.append(getLanguageId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", languageName=");
        sb.append(getLanguageName());
        sb.append(", languageAbbreviation=");
        sb.append(getLanguageAbbreviation());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Language");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>LanguageId</column-name><column-value><![CDATA[");
        sb.append(getLanguageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>languageName</column-name><column-value><![CDATA[");
        sb.append(getLanguageName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>languageAbbreviation</column-name><column-value><![CDATA[");
        sb.append(getLanguageAbbreviation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
