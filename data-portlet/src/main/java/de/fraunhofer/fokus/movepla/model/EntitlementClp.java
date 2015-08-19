package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: EntitlementClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EntitlementClp extends BaseModelImpl<Entitlement>
    implements Entitlement {
    private long _entitlementId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _entitlementName;
    private String _explanation;
    private String _estimation;
    private BaseModel<?> _entitlementRemoteModel;

    public EntitlementClp() {
    }

    public Class<?> getModelClass() {
        return Entitlement.class;
    }

    public String getModelClassName() {
        return Entitlement.class.getName();
    }

    public long getPrimaryKey() {
        return _entitlementId;
    }

    public void setPrimaryKey(long primaryKey) {
        setEntitlementId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_entitlementId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getEntitlementId() {
        return _entitlementId;
    }

    public void setEntitlementId(long entitlementId) {
        _entitlementId = entitlementId;
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

    public String getEntitlementName() {
        return _entitlementName;
    }

    public void setEntitlementName(String entitlementName) {
        _entitlementName = entitlementName;
    }

    public String getExplanation() {
        return _explanation;
    }

    public void setExplanation(String explanation) {
        _explanation = explanation;
    }

    public String getEstimation() {
        return _estimation;
    }

    public void setEstimation(String estimation) {
        _estimation = estimation;
    }

    public BaseModel<?> getEntitlementRemoteModel() {
        return _entitlementRemoteModel;
    }

    public void setEntitlementRemoteModel(BaseModel<?> entitlementRemoteModel) {
        _entitlementRemoteModel = entitlementRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            EntitlementLocalServiceUtil.addEntitlement(this);
        } else {
            EntitlementLocalServiceUtil.updateEntitlement(this);
        }
    }

    @Override
    public Entitlement toEscapedModel() {
        return (Entitlement) Proxy.newProxyInstance(Entitlement.class.getClassLoader(),
            new Class[] { Entitlement.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EntitlementClp clone = new EntitlementClp();

        clone.setEntitlementId(getEntitlementId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setEntitlementName(getEntitlementName());
        clone.setExplanation(getExplanation());
        clone.setEstimation(getEstimation());

        return clone;
    }

    public int compareTo(Entitlement entitlement) {
        long primaryKey = entitlement.getPrimaryKey();

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

        EntitlementClp entitlement = null;

        try {
            entitlement = (EntitlementClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = entitlement.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{entitlementId=");
        sb.append(getEntitlementId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", entitlementName=");
        sb.append(getEntitlementName());
        sb.append(", explanation=");
        sb.append(getExplanation());
        sb.append(", estimation=");
        sb.append(getEstimation());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Entitlement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entitlementId</column-name><column-value><![CDATA[");
        sb.append(getEntitlementId());
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
            "<column><column-name>entitlementName</column-name><column-value><![CDATA[");
        sb.append(getEntitlementName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>explanation</column-name><column-value><![CDATA[");
        sb.append(getExplanation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>estimation</column-name><column-value><![CDATA[");
        sb.append(getEstimation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
