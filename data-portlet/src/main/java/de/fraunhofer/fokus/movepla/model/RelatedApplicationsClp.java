package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class RelatedApplicationsClp extends BaseModelImpl<RelatedApplications>
    implements RelatedApplications {
    private long _RelatedApplicationsID;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private long _applicationId;
    private long _applicationId2;
    private BaseModel<?> _relatedApplicationsRemoteModel;

    public RelatedApplicationsClp() {
    }

    public Class<?> getModelClass() {
        return RelatedApplications.class;
    }

    public String getModelClassName() {
        return RelatedApplications.class.getName();
    }

    public long getPrimaryKey() {
        return _RelatedApplicationsID;
    }

    public void setPrimaryKey(long primaryKey) {
        setRelatedApplicationsID(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_RelatedApplicationsID);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("RelatedApplicationsID", getRelatedApplicationsID());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("applicationId", getApplicationId());
        attributes.put("applicationId2", getApplicationId2());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long RelatedApplicationsID = (Long) attributes.get(
                "RelatedApplicationsID");

        if (RelatedApplicationsID != null) {
            setRelatedApplicationsID(RelatedApplicationsID);
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

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        Long applicationId2 = (Long) attributes.get("applicationId2");

        if (applicationId2 != null) {
            setApplicationId2(applicationId2);
        }
    }

    public long getRelatedApplicationsID() {
        return _RelatedApplicationsID;
    }

    public void setRelatedApplicationsID(long RelatedApplicationsID) {
        _RelatedApplicationsID = RelatedApplicationsID;
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

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    public long getApplicationId2() {
        return _applicationId2;
    }

    public void setApplicationId2(long applicationId2) {
        _applicationId2 = applicationId2;
    }

    public BaseModel<?> getRelatedApplicationsRemoteModel() {
        return _relatedApplicationsRemoteModel;
    }

    public void setRelatedApplicationsRemoteModel(
        BaseModel<?> relatedApplicationsRemoteModel) {
        _relatedApplicationsRemoteModel = relatedApplicationsRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            RelatedApplicationsLocalServiceUtil.addRelatedApplications(this);
        } else {
            RelatedApplicationsLocalServiceUtil.updateRelatedApplications(this);
        }
    }

    @Override
    public RelatedApplications toEscapedModel() {
        return (RelatedApplications) Proxy.newProxyInstance(RelatedApplications.class.getClassLoader(),
            new Class[] { RelatedApplications.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RelatedApplicationsClp clone = new RelatedApplicationsClp();

        clone.setRelatedApplicationsID(getRelatedApplicationsID());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setApplicationId(getApplicationId());
        clone.setApplicationId2(getApplicationId2());

        return clone;
    }

    public int compareTo(RelatedApplications relatedApplications) {
        long primaryKey = relatedApplications.getPrimaryKey();

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

        RelatedApplicationsClp relatedApplications = null;

        try {
            relatedApplications = (RelatedApplicationsClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = relatedApplications.getPrimaryKey();

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

        sb.append("{RelatedApplicationsID=");
        sb.append(getRelatedApplicationsID());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", applicationId=");
        sb.append(getApplicationId());
        sb.append(", applicationId2=");
        sb.append(getApplicationId2());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.RelatedApplications");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>RelatedApplicationsID</column-name><column-value><![CDATA[");
        sb.append(getRelatedApplicationsID());
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
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationId2</column-name><column-value><![CDATA[");
        sb.append(getApplicationId2());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
