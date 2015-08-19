package com.govapps.persistence.model.impl;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernModelImpl.java 566 2014-11-13 15:22:01Z sma $
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

import com.govapps.persistence.model.Concern;
import com.govapps.persistence.model.ConcernModel;
import com.govapps.persistence.model.ConcernSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Concern service. Represents a row in the &quot;CONC_Concern&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.govapps.persistence.model.ConcernModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConcernImpl}.
 * </p>
 *
 * @author ekl
 * @see ConcernImpl
 * @see com.govapps.persistence.model.Concern
 * @see com.govapps.persistence.model.ConcernModel
 * @generated
 */
@JSON(strict = true)
public class ConcernModelImpl extends BaseModelImpl<Concern>
    implements ConcernModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a concern model instance should use the {@link com.govapps.persistence.model.Concern} interface instead.
     */
    public static final String TABLE_NAME = "CONC_Concern";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "email", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "platforms", Types.VARCHAR },
            { "concern", Types.BIGINT },
            { "region", Types.VARCHAR },
            { "category", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "supports", Types.BIGINT },
            { "state_", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table CONC_Concern (id_ LONG not null primary key,companyId LONG,groupId LONG,name VARCHAR(75) null,email VARCHAR(75) null,description VARCHAR(75) null,platforms VARCHAR(75) null,concern LONG,region VARCHAR(75) null,category VARCHAR(75) null,createDate DATE null,supports LONG,state_ INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table CONC_Concern";
    public static final String ORDER_BY_JPQL = " ORDER BY concern.supports ASC";
    public static final String ORDER_BY_SQL = " ORDER BY CONC_Concern.supports ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.govapps.persistence.model.Concern"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.govapps.persistence.model.Concern"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.govapps.persistence.model.Concern"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long STATE_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.govapps.persistence.model.Concern"));
    private static ClassLoader _classLoader = Concern.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            Concern.class
        };
    private long _id;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
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
    private int _originalState;
    private boolean _setOriginalState;
    private long _columnBitmask;
    private Concern _escapedModelProxy;

    public ConcernModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Concern toModel(ConcernSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Concern model = new ConcernImpl();

        model.setId(soapModel.getId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setGroupId(soapModel.getGroupId());
        model.setName(soapModel.getName());
        model.setEmail(soapModel.getEmail());
        model.setDescription(soapModel.getDescription());
        model.setPlatforms(soapModel.getPlatforms());
        model.setConcern(soapModel.getConcern());
        model.setRegion(soapModel.getRegion());
        model.setCategory(soapModel.getCategory());
        model.setCreateDate(soapModel.getCreateDate());
        model.setSupports(soapModel.getSupports());
        model.setState(soapModel.getState());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Concern> toModels(ConcernSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Concern> models = new ArrayList<Concern>(soapModels.length);

        for (ConcernSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    public Class<?> getModelClass() {
        return Concern.class;
    }

    public String getModelClassName() {
        return Concern.class.getName();
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

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @JSON
    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    @JSON
    public String getEmail() {
        if (_email == null) {
            return StringPool.BLANK;
        } else {
            return _email;
        }
    }

    public void setEmail(String email) {
        _email = email;
    }

    @JSON
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    public String getPlatforms() {
        if (_platforms == null) {
            return StringPool.BLANK;
        } else {
            return _platforms;
        }
    }

    public void setPlatforms(String platforms) {
        _platforms = platforms;
    }

    @JSON
    public long getConcern() {
        return _concern;
    }

    public void setConcern(long concern) {
        _concern = concern;
    }

    @JSON
    public String getRegion() {
        if (_region == null) {
            return StringPool.BLANK;
        } else {
            return _region;
        }
    }

    public void setRegion(String region) {
        _region = region;
    }

    @JSON
    public String getCategory() {
        if (_category == null) {
            return StringPool.BLANK;
        } else {
            return _category;
        }
    }

    public void setCategory(String category) {
        _category = category;
    }

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    public long getSupports() {
        return _supports;
    }

    public void setSupports(long supports) {
        _columnBitmask = -1L;

        _supports = supports;
    }

    @JSON
    public int getState() {
        return _state;
    }

    public void setState(int state) {
        _columnBitmask |= STATE_COLUMN_BITMASK;

        if (!_setOriginalState) {
            _setOriginalState = true;

            _originalState = _state;
        }

        _state = state;
    }

    public int getOriginalState() {
        return _originalState;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Concern.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Concern toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (Concern) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ConcernImpl concernImpl = new ConcernImpl();

        concernImpl.setId(getId());
        concernImpl.setCompanyId(getCompanyId());
        concernImpl.setGroupId(getGroupId());
        concernImpl.setName(getName());
        concernImpl.setEmail(getEmail());
        concernImpl.setDescription(getDescription());
        concernImpl.setPlatforms(getPlatforms());
        concernImpl.setConcern(getConcern());
        concernImpl.setRegion(getRegion());
        concernImpl.setCategory(getCategory());
        concernImpl.setCreateDate(getCreateDate());
        concernImpl.setSupports(getSupports());
        concernImpl.setState(getState());

        concernImpl.resetOriginalValues();

        return concernImpl;
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

        Concern concern = null;

        try {
            concern = (Concern) obj;
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
    public void resetOriginalValues() {
        ConcernModelImpl concernModelImpl = this;

        concernModelImpl._originalCompanyId = concernModelImpl._companyId;

        concernModelImpl._setOriginalCompanyId = false;

        concernModelImpl._originalState = concernModelImpl._state;

        concernModelImpl._setOriginalState = false;

        concernModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Concern> toCacheModel() {
        ConcernCacheModel concernCacheModel = new ConcernCacheModel();

        concernCacheModel.id = getId();

        concernCacheModel.companyId = getCompanyId();

        concernCacheModel.groupId = getGroupId();

        concernCacheModel.name = getName();

        String name = concernCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            concernCacheModel.name = null;
        }

        concernCacheModel.email = getEmail();

        String email = concernCacheModel.email;

        if ((email != null) && (email.length() == 0)) {
            concernCacheModel.email = null;
        }

        concernCacheModel.description = getDescription();

        String description = concernCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            concernCacheModel.description = null;
        }

        concernCacheModel.platforms = getPlatforms();

        String platforms = concernCacheModel.platforms;

        if ((platforms != null) && (platforms.length() == 0)) {
            concernCacheModel.platforms = null;
        }

        concernCacheModel.concern = getConcern();

        concernCacheModel.region = getRegion();

        String region = concernCacheModel.region;

        if ((region != null) && (region.length() == 0)) {
            concernCacheModel.region = null;
        }

        concernCacheModel.category = getCategory();

        String category = concernCacheModel.category;

        if ((category != null) && (category.length() == 0)) {
            concernCacheModel.category = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            concernCacheModel.createDate = createDate.getTime();
        } else {
            concernCacheModel.createDate = Long.MIN_VALUE;
        }

        concernCacheModel.supports = getSupports();

        concernCacheModel.state = getState();

        return concernCacheModel;
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
