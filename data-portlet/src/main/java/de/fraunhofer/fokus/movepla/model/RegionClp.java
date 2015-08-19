package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: RegionClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class RegionClp extends BaseModelImpl<Region> implements Region {
    private long _regionId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private int _ags;
    private double _coordniates_x;
    private double _coordniates_y;
    private long _parentRegion;
    private BaseModel<?> _regionRemoteModel;

    public RegionClp() {
    }

    public Class<?> getModelClass() {
        return Region.class;
    }

    public String getModelClassName() {
        return Region.class.getName();
    }

    public long getPrimaryKey() {
        return _regionId;
    }

    public void setPrimaryKey(long primaryKey) {
        setRegionId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_regionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("regionId", getRegionId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("ags", getAgs());
        attributes.put("coordniates_x", getCoordniates_x());
        attributes.put("coordniates_y", getCoordniates_y());
        attributes.put("parentRegion", getParentRegion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
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

        Integer ags = (Integer) attributes.get("ags");

        if (ags != null) {
            setAgs(ags);
        }

        Double coordniates_x = (Double) attributes.get("coordniates_x");

        if (coordniates_x != null) {
            setCoordniates_x(coordniates_x);
        }

        Double coordniates_y = (Double) attributes.get("coordniates_y");

        if (coordniates_y != null) {
            setCoordniates_y(coordniates_y);
        }

        Long parentRegion = (Long) attributes.get("parentRegion");

        if (parentRegion != null) {
            setParentRegion(parentRegion);
        }
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
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

    public int getAgs() {
        return _ags;
    }

    public void setAgs(int ags) {
        _ags = ags;
    }

    public double getCoordniates_x() {
        return _coordniates_x;
    }

    public void setCoordniates_x(double coordniates_x) {
        _coordniates_x = coordniates_x;
    }

    public double getCoordniates_y() {
        return _coordniates_y;
    }

    public void setCoordniates_y(double coordniates_y) {
        _coordniates_y = coordniates_y;
    }

    public long getParentRegion() {
        return _parentRegion;
    }

    public void setParentRegion(long parentRegion) {
        _parentRegion = parentRegion;
    }

    public BaseModel<?> getRegionRemoteModel() {
        return _regionRemoteModel;
    }

    public void setRegionRemoteModel(BaseModel<?> regionRemoteModel) {
        _regionRemoteModel = regionRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            RegionLocalServiceUtil.addRegion(this);
        } else {
            RegionLocalServiceUtil.updateRegion(this);
        }
    }

    @Override
    public Region toEscapedModel() {
        return (Region) Proxy.newProxyInstance(Region.class.getClassLoader(),
            new Class[] { Region.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RegionClp clone = new RegionClp();

        clone.setRegionId(getRegionId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setAgs(getAgs());
        clone.setCoordniates_x(getCoordniates_x());
        clone.setCoordniates_y(getCoordniates_y());
        clone.setParentRegion(getParentRegion());

        return clone;
    }

    public int compareTo(Region region) {
        long primaryKey = region.getPrimaryKey();

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

        RegionClp region = null;

        try {
            region = (RegionClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = region.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{regionId=");
        sb.append(getRegionId());
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
        sb.append(", ags=");
        sb.append(getAgs());
        sb.append(", coordniates_x=");
        sb.append(getCoordniates_x());
        sb.append(", coordniates_y=");
        sb.append(getCoordniates_y());
        sb.append(", parentRegion=");
        sb.append(getParentRegion());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Region");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
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
            "<column><column-name>ags</column-name><column-value><![CDATA[");
        sb.append(getAgs());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>coordniates_x</column-name><column-value><![CDATA[");
        sb.append(getCoordniates_x());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>coordniates_y</column-name><column-value><![CDATA[");
        sb.append(getCoordniates_y());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentRegion</column-name><column-value><![CDATA[");
        sb.append(getParentRegion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
