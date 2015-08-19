package com.govapps.persistence.model;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernClp.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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

import com.govapps.persistence.service.ConcernLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ConcernClp extends BaseModelImpl<Concern> implements Concern {
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _email;
    private String _description;
    private String _platforms;
    private long _concern;
    private String _region;
    private String _category;
    private Date _createDate;
    private long _supports;
    private int _state;
    private BaseModel<?> _concernRemoteModel;

    public ConcernClp() {
    }

    public Class<?> getModelClass() {
        return Concern.class;
    }

    public String getModelClassName() {
        return Concern.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("email", getEmail());
        attributes.put("description", getDescription());
        attributes.put("platforms", getPlatforms());
        attributes.put("concern", getConcern());
        attributes.put("region", getRegion());
        attributes.put("category", getCategory());
        attributes.put("createDate", getCreateDate());
        attributes.put("supports", getSupports());
        attributes.put("state", getState());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String platforms = (String) attributes.get("platforms");

        if (platforms != null) {
            setPlatforms(platforms);
        }

        Long concern = (Long) attributes.get("concern");

        if (concern != null) {
            setConcern(concern);
        }

        String region = (String) attributes.get("region");

        if (region != null) {
            setRegion(region);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Long supports = (Long) attributes.get("supports");

        if (supports != null) {
            setSupports(supports);
        }

        Integer state = (Integer) attributes.get("state");

        if (state != null) {
            setState(state);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getPlatforms() {
        return _platforms;
    }

    public void setPlatforms(String platforms) {
        _platforms = platforms;
    }

    public long getConcern() {
        return _concern;
    }

    public void setConcern(long concern) {
        _concern = concern;
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String region) {
        _region = region;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getSupports() {
        return _supports;
    }

    public void setSupports(long supports) {
        _supports = supports;
    }

    public int getState() {
        return _state;
    }

    public void setState(int state) {
        _state = state;
    }

    public BaseModel<?> getConcernRemoteModel() {
        return _concernRemoteModel;
    }

    public void setConcernRemoteModel(BaseModel<?> concernRemoteModel) {
        _concernRemoteModel = concernRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ConcernLocalServiceUtil.addConcern(this);
        } else {
            ConcernLocalServiceUtil.updateConcern(this);
        }
    }

    @Override
    public Concern toEscapedModel() {
        return (Concern) Proxy.newProxyInstance(Concern.class.getClassLoader(),
            new Class[] { Concern.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ConcernClp clone = new ConcernClp();

        clone.setId(getId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setName(getName());
        clone.setEmail(getEmail());
        clone.setDescription(getDescription());
        clone.setPlatforms(getPlatforms());
        clone.setConcern(getConcern());
        clone.setRegion(getRegion());
        clone.setCategory(getCategory());
        clone.setCreateDate(getCreateDate());
        clone.setSupports(getSupports());
        clone.setState(getState());

        return clone;
    }

    public int compareTo(Concern concern) {
        int value = 0;

        if (getSupports() < concern.getSupports()) {
            value = -1;
        } else if (getSupports() > concern.getSupports()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ConcernClp concern = null;

        try {
            concern = (ConcernClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = concern.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", platforms=");
        sb.append(getPlatforms());
        sb.append(", concern=");
        sb.append(getConcern());
        sb.append(", region=");
        sb.append(getRegion());
        sb.append(", category=");
        sb.append(getCategory());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", supports=");
        sb.append(getSupports());
        sb.append(", state=");
        sb.append(getState());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("com.govapps.persistence.model.Concern");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>platforms</column-name><column-value><![CDATA[");
        sb.append(getPlatforms());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>concern</column-name><column-value><![CDATA[");
        sb.append(getConcern());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>region</column-name><column-value><![CDATA[");
        sb.append(getRegion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>category</column-name><column-value><![CDATA[");
        sb.append(getCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>supports</column-name><column-value><![CDATA[");
        sb.append(getSupports());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>state</column-name><column-value><![CDATA[");
        sb.append(getState());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
