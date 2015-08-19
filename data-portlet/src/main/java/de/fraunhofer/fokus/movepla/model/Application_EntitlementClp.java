package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Application_EntitlementClp extends BaseModelImpl<Application_Entitlement>
    implements Application_Entitlement {
    private long _applicationEntitlementID;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _motivation;
    private long _applicationId;
    private long _entitlementId;
    private BaseModel<?> _application_EntitlementRemoteModel;

    public Application_EntitlementClp() {
    }

    public Class<?> getModelClass() {
        return Application_Entitlement.class;
    }

    public String getModelClassName() {
        return Application_Entitlement.class.getName();
    }

    public long getPrimaryKey() {
        return _applicationEntitlementID;
    }

    public void setPrimaryKey(long primaryKey) {
        setApplicationEntitlementID(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_applicationEntitlementID);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getApplicationEntitlementID() {
        return _applicationEntitlementID;
    }

    public void setApplicationEntitlementID(long applicationEntitlementID) {
        _applicationEntitlementID = applicationEntitlementID;
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

    public String getMotivation() {
        return _motivation;
    }

    public void setMotivation(String motivation) {
        _motivation = motivation;
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    public long getEntitlementId() {
        return _entitlementId;
    }

    public void setEntitlementId(long entitlementId) {
        _entitlementId = entitlementId;
    }

    public BaseModel<?> getApplication_EntitlementRemoteModel() {
        return _application_EntitlementRemoteModel;
    }

    public void setApplication_EntitlementRemoteModel(
        BaseModel<?> application_EntitlementRemoteModel) {
        _application_EntitlementRemoteModel = application_EntitlementRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            Application_EntitlementLocalServiceUtil.addApplication_Entitlement(this);
        } else {
            Application_EntitlementLocalServiceUtil.updateApplication_Entitlement(this);
        }
    }

    @Override
    public Application_Entitlement toEscapedModel() {
        return (Application_Entitlement) Proxy.newProxyInstance(Application_Entitlement.class.getClassLoader(),
            new Class[] { Application_Entitlement.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        Application_EntitlementClp clone = new Application_EntitlementClp();

        clone.setApplicationEntitlementID(getApplicationEntitlementID());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setMotivation(getMotivation());
        clone.setApplicationId(getApplicationId());
        clone.setEntitlementId(getEntitlementId());

        return clone;
    }

    public int compareTo(Application_Entitlement application_Entitlement) {
        long primaryKey = application_Entitlement.getPrimaryKey();

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

        Application_EntitlementClp application_Entitlement = null;

        try {
            application_Entitlement = (Application_EntitlementClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = application_Entitlement.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{applicationEntitlementID=");
        sb.append(getApplicationEntitlementID());
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
        sb.append(", motivation=");
        sb.append(getMotivation());
        sb.append(", applicationId=");
        sb.append(getApplicationId());
        sb.append(", entitlementId=");
        sb.append(getEntitlementId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Application_Entitlement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationEntitlementID</column-name><column-value><![CDATA[");
        sb.append(getApplicationEntitlementID());
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
            "<column><column-name>motivation</column-name><column-value><![CDATA[");
        sb.append(getMotivation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entitlementId</column-name><column-value><![CDATA[");
        sb.append(getEntitlementId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
