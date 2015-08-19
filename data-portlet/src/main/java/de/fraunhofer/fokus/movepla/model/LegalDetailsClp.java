package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.LegalDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LegalDetailsClp extends BaseModelImpl<LegalDetails>
    implements LegalDetails {
    private long _legalDetailsId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _valueAddedTaxNo;
    private String _registrationCourt;
    private String _legalForm;
    private String _address;
    private String _telephone;
    private String _email;
    private String _URL;
    private String _fax;
    private BaseModel<?> _legalDetailsRemoteModel;

    public LegalDetailsClp() {
    }

    public Class<?> getModelClass() {
        return LegalDetails.class;
    }

    public String getModelClassName() {
        return LegalDetails.class.getName();
    }

    public long getPrimaryKey() {
        return _legalDetailsId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLegalDetailsId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_legalDetailsId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getLegalDetailsId() {
        return _legalDetailsId;
    }

    public void setLegalDetailsId(long legalDetailsId) {
        _legalDetailsId = legalDetailsId;
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getValueAddedTaxNo() {
        return _valueAddedTaxNo;
    }

    public void setValueAddedTaxNo(String valueAddedTaxNo) {
        _valueAddedTaxNo = valueAddedTaxNo;
    }

    public String getRegistrationCourt() {
        return _registrationCourt;
    }

    public void setRegistrationCourt(String registrationCourt) {
        _registrationCourt = registrationCourt;
    }

    public String getLegalForm() {
        return _legalForm;
    }

    public void setLegalForm(String legalForm) {
        _legalForm = legalForm;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getURL() {
        return _URL;
    }

    public void setURL(String URL) {
        _URL = URL;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    public BaseModel<?> getLegalDetailsRemoteModel() {
        return _legalDetailsRemoteModel;
    }

    public void setLegalDetailsRemoteModel(BaseModel<?> legalDetailsRemoteModel) {
        _legalDetailsRemoteModel = legalDetailsRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LegalDetailsLocalServiceUtil.addLegalDetails(this);
        } else {
            LegalDetailsLocalServiceUtil.updateLegalDetails(this);
        }
    }

    @Override
    public LegalDetails toEscapedModel() {
        return (LegalDetails) Proxy.newProxyInstance(LegalDetails.class.getClassLoader(),
            new Class[] { LegalDetails.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LegalDetailsClp clone = new LegalDetailsClp();

        clone.setLegalDetailsId(getLegalDetailsId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setValueAddedTaxNo(getValueAddedTaxNo());
        clone.setRegistrationCourt(getRegistrationCourt());
        clone.setLegalForm(getLegalForm());
        clone.setAddress(getAddress());
        clone.setTelephone(getTelephone());
        clone.setEmail(getEmail());
        clone.setURL(getURL());
        clone.setFax(getFax());

        return clone;
    }

    public int compareTo(LegalDetails legalDetails) {
        long primaryKey = legalDetails.getPrimaryKey();

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

        LegalDetailsClp legalDetails = null;

        try {
            legalDetails = (LegalDetailsClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = legalDetails.getPrimaryKey();

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
        StringBundler sb = new StringBundler(29);

        sb.append("{legalDetailsId=");
        sb.append(getLegalDetailsId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", valueAddedTaxNo=");
        sb.append(getValueAddedTaxNo());
        sb.append(", registrationCourt=");
        sb.append(getRegistrationCourt());
        sb.append(", legalForm=");
        sb.append(getLegalForm());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append(", telephone=");
        sb.append(getTelephone());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", URL=");
        sb.append(getURL());
        sb.append(", fax=");
        sb.append(getFax());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.LegalDetails");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>legalDetailsId</column-name><column-value><![CDATA[");
        sb.append(getLegalDetailsId());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>valueAddedTaxNo</column-name><column-value><![CDATA[");
        sb.append(getValueAddedTaxNo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registrationCourt</column-name><column-value><![CDATA[");
        sb.append(getRegistrationCourt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legalForm</column-name><column-value><![CDATA[");
        sb.append(getLegalForm());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telephone</column-name><column-value><![CDATA[");
        sb.append(getTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>URL</column-name><column-value><![CDATA[");
        sb.append(getURL());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fax</column-name><column-value><![CDATA[");
        sb.append(getFax());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
