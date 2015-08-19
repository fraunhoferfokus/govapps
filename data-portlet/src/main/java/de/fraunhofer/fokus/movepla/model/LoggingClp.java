package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LoggingClp.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.LoggingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LoggingClp extends BaseModelImpl<Logging> implements Logging {
    private long _loggingId;
    private Date _createDate;
    private Date _modifiedDate;
    private Boolean _isSimpleSearch;
    private String _searchString;
    private String _categoryIDString;
    private String _regionIDString;
    private String _entitlementIDString;
    private String _targetOS;
    private int _fee;
    private String _targetCategory;
    private long _passel;
    private BaseModel<?> _loggingRemoteModel;

    public LoggingClp() {
    }

    public Class<?> getModelClass() {
        return Logging.class;
    }

    public String getModelClassName() {
        return Logging.class.getName();
    }

    public long getPrimaryKey() {
        return _loggingId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLoggingId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_loggingId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("loggingId", getLoggingId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("isSimpleSearch", getIsSimpleSearch());
        attributes.put("searchString", getSearchString());
        attributes.put("categoryIDString", getCategoryIDString());
        attributes.put("regionIDString", getRegionIDString());
        attributes.put("entitlementIDString", getEntitlementIDString());
        attributes.put("targetOS", getTargetOS());
        attributes.put("fee", getFee());
        attributes.put("targetCategory", getTargetCategory());
        attributes.put("passel", getPassel());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long loggingId = (Long) attributes.get("loggingId");

        if (loggingId != null) {
            setLoggingId(loggingId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Boolean isSimpleSearch = (Boolean) attributes.get("isSimpleSearch");

        if (isSimpleSearch != null) {
            setIsSimpleSearch(isSimpleSearch);
        }

        String searchString = (String) attributes.get("searchString");

        if (searchString != null) {
            setSearchString(searchString);
        }

        String categoryIDString = (String) attributes.get("categoryIDString");

        if (categoryIDString != null) {
            setCategoryIDString(categoryIDString);
        }

        String regionIDString = (String) attributes.get("regionIDString");

        if (regionIDString != null) {
            setRegionIDString(regionIDString);
        }

        String entitlementIDString = (String) attributes.get(
                "entitlementIDString");

        if (entitlementIDString != null) {
            setEntitlementIDString(entitlementIDString);
        }

        String targetOS = (String) attributes.get("targetOS");

        if (targetOS != null) {
            setTargetOS(targetOS);
        }

        Integer fee = (Integer) attributes.get("fee");

        if (fee != null) {
            setFee(fee);
        }

        String targetCategory = (String) attributes.get("targetCategory");

        if (targetCategory != null) {
            setTargetCategory(targetCategory);
        }

        Long passel = (Long) attributes.get("passel");

        if (passel != null) {
            setPassel(passel);
        }
    }

    public long getLoggingId() {
        return _loggingId;
    }

    public void setLoggingId(long loggingId) {
        _loggingId = loggingId;
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

    public Boolean getIsSimpleSearch() {
        return _isSimpleSearch;
    }

    public void setIsSimpleSearch(Boolean isSimpleSearch) {
        _isSimpleSearch = isSimpleSearch;
    }

    public String getSearchString() {
        return _searchString;
    }

    public void setSearchString(String searchString) {
        _searchString = searchString;
    }

    public String getCategoryIDString() {
        return _categoryIDString;
    }

    public void setCategoryIDString(String categoryIDString) {
        _categoryIDString = categoryIDString;
    }

    public String getRegionIDString() {
        return _regionIDString;
    }

    public void setRegionIDString(String regionIDString) {
        _regionIDString = regionIDString;
    }

    public String getEntitlementIDString() {
        return _entitlementIDString;
    }

    public void setEntitlementIDString(String entitlementIDString) {
        _entitlementIDString = entitlementIDString;
    }

    public String getTargetOS() {
        return _targetOS;
    }

    public void setTargetOS(String targetOS) {
        _targetOS = targetOS;
    }

    public int getFee() {
        return _fee;
    }

    public void setFee(int fee) {
        _fee = fee;
    }

    public String getTargetCategory() {
        return _targetCategory;
    }

    public void setTargetCategory(String targetCategory) {
        _targetCategory = targetCategory;
    }

    public long getPassel() {
        return _passel;
    }

    public void setPassel(long passel) {
        _passel = passel;
    }

    public BaseModel<?> getLoggingRemoteModel() {
        return _loggingRemoteModel;
    }

    public void setLoggingRemoteModel(BaseModel<?> loggingRemoteModel) {
        _loggingRemoteModel = loggingRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LoggingLocalServiceUtil.addLogging(this);
        } else {
            LoggingLocalServiceUtil.updateLogging(this);
        }
    }

    @Override
    public Logging toEscapedModel() {
        return (Logging) Proxy.newProxyInstance(Logging.class.getClassLoader(),
            new Class[] { Logging.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LoggingClp clone = new LoggingClp();

        clone.setLoggingId(getLoggingId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setIsSimpleSearch(getIsSimpleSearch());
        clone.setSearchString(getSearchString());
        clone.setCategoryIDString(getCategoryIDString());
        clone.setRegionIDString(getRegionIDString());
        clone.setEntitlementIDString(getEntitlementIDString());
        clone.setTargetOS(getTargetOS());
        clone.setFee(getFee());
        clone.setTargetCategory(getTargetCategory());
        clone.setPassel(getPassel());

        return clone;
    }

    public int compareTo(Logging logging) {
        long primaryKey = logging.getPrimaryKey();

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

        LoggingClp logging = null;

        try {
            logging = (LoggingClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = logging.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{loggingId=");
        sb.append(getLoggingId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", isSimpleSearch=");
        sb.append(getIsSimpleSearch());
        sb.append(", searchString=");
        sb.append(getSearchString());
        sb.append(", categoryIDString=");
        sb.append(getCategoryIDString());
        sb.append(", regionIDString=");
        sb.append(getRegionIDString());
        sb.append(", entitlementIDString=");
        sb.append(getEntitlementIDString());
        sb.append(", targetOS=");
        sb.append(getTargetOS());
        sb.append(", fee=");
        sb.append(getFee());
        sb.append(", targetCategory=");
        sb.append(getTargetCategory());
        sb.append(", passel=");
        sb.append(getPassel());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Logging");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>loggingId</column-name><column-value><![CDATA[");
        sb.append(getLoggingId());
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
            "<column><column-name>isSimpleSearch</column-name><column-value><![CDATA[");
        sb.append(getIsSimpleSearch());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>searchString</column-name><column-value><![CDATA[");
        sb.append(getSearchString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryIDString</column-name><column-value><![CDATA[");
        sb.append(getCategoryIDString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionIDString</column-name><column-value><![CDATA[");
        sb.append(getRegionIDString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entitlementIDString</column-name><column-value><![CDATA[");
        sb.append(getEntitlementIDString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetOS</column-name><column-value><![CDATA[");
        sb.append(getTargetOS());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fee</column-name><column-value><![CDATA[");
        sb.append(getFee());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetCategory</column-name><column-value><![CDATA[");
        sb.append(getTargetCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>passel</column-name><column-value><![CDATA[");
        sb.append(getPassel());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
