package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: CategoryModelImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.CategoryModel;
import de.fraunhofer.fokus.movepla.model.CategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Category service. Represents a row in the &quot;mvp_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.fraunhofer.fokus.movepla.model.CategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryImpl}.
 * </p>
 *
 * @author jpa
 * @see CategoryImpl
 * @see de.fraunhofer.fokus.movepla.model.Category
 * @see de.fraunhofer.fokus.movepla.model.CategoryModel
 * @generated
 */
@JSON(strict = true)
public class CategoryModelImpl extends BaseModelImpl<Category>
    implements CategoryModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a category model instance should use the {@link de.fraunhofer.fokus.movepla.model.Category} interface instead.
     */
    public static final String TABLE_NAME = "mvp_Category";
    public static final Object[][] TABLE_COLUMNS = {
            { "categoryId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "categoryName", Types.VARCHAR },
            { "parentCategory", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table mvp_Category (categoryId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,categoryName VARCHAR(75) null,parentCategory LONG)";
    public static final String TABLE_SQL_DROP = "drop table mvp_Category";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.de.fraunhofer.fokus.movepla.model.Category"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.de.fraunhofer.fokus.movepla.model.Category"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.de.fraunhofer.fokus.movepla.model.Category"),
            true);
    public static long CATEGORYNAME_COLUMN_BITMASK = 1L;
    public static long COMPANYID_COLUMN_BITMASK = 2L;
    public static long PARENTCATEGORY_COLUMN_BITMASK = 4L;
    public static final String MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME = "mvp_Application_Category";
    public static final Object[][] MAPPING_TABLE_MVP_APPLICATION_CATEGORY_COLUMNS =
        {
            { "categoryId", Types.BIGINT },
            { "applicationId", Types.BIGINT }
        };
    public static final String MAPPING_TABLE_MVP_APPLICATION_CATEGORY_SQL_CREATE =
        "create table mvp_Application_Category (categoryId LONG not null,applicationId LONG not null,primary key (categoryId, applicationId))";
    public static final boolean FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.mvp_Application_Category"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.de.fraunhofer.fokus.movepla.model.Category"));
    private static ClassLoader _classLoader = Category.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            Category.class
        };
    private long _categoryId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _categoryName;
    private String _originalCategoryName;
    private long _parentCategory;
    private long _originalParentCategory;
    private boolean _setOriginalParentCategory;
    private long _columnBitmask;
    private Category _escapedModelProxy;

    public CategoryModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Category toModel(CategorySoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Category model = new CategoryImpl();

        model.setCategoryId(soapModel.getCategoryId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setCategoryName(soapModel.getCategoryName());
        model.setParentCategory(soapModel.getParentCategory());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Category> toModels(CategorySoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Category> models = new ArrayList<Category>(soapModels.length);

        for (CategorySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long primaryKey) {
        setCategoryId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_categoryId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return Category.class;
    }

    public String getModelClassName() {
        return Category.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("categoryId", getCategoryId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("categoryName", getCategoryName());
        attributes.put("parentCategory", getParentCategory());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
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

        String categoryName = (String) attributes.get("categoryName");

        if (categoryName != null) {
            setCategoryName(categoryName);
        }

        Long parentCategory = (Long) attributes.get("parentCategory");

        if (parentCategory != null) {
            setParentCategory(parentCategory);
        }
    }

    @JSON
    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
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

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    public String getCategoryName() {
        if (_categoryName == null) {
            return StringPool.BLANK;
        } else {
            return _categoryName;
        }
    }

    public void setCategoryName(String categoryName) {
        _columnBitmask |= CATEGORYNAME_COLUMN_BITMASK;

        if (_originalCategoryName == null) {
            _originalCategoryName = _categoryName;
        }

        _categoryName = categoryName;
    }

    public String getOriginalCategoryName() {
        return GetterUtil.getString(_originalCategoryName);
    }

    @JSON
    public long getParentCategory() {
        return _parentCategory;
    }

    public void setParentCategory(long parentCategory) {
        _columnBitmask |= PARENTCATEGORY_COLUMN_BITMASK;

        if (!_setOriginalParentCategory) {
            _setOriginalParentCategory = true;

            _originalParentCategory = _parentCategory;
        }

        _parentCategory = parentCategory;
    }

    public long getOriginalParentCategory() {
        return _originalParentCategory;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Category.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Category toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (Category) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setCategoryId(getCategoryId());
        categoryImpl.setCompanyId(getCompanyId());
        categoryImpl.setUserId(getUserId());
        categoryImpl.setCreateDate(getCreateDate());
        categoryImpl.setModifiedDate(getModifiedDate());
        categoryImpl.setCategoryName(getCategoryName());
        categoryImpl.setParentCategory(getParentCategory());

        categoryImpl.resetOriginalValues();

        return categoryImpl;
    }

    public int compareTo(Category category) {
        long primaryKey = category.getPrimaryKey();

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

        Category category = null;

        try {
            category = (Category) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = category.getPrimaryKey();

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
        CategoryModelImpl categoryModelImpl = this;

        categoryModelImpl._originalCompanyId = categoryModelImpl._companyId;

        categoryModelImpl._setOriginalCompanyId = false;

        categoryModelImpl._originalCategoryName = categoryModelImpl._categoryName;

        categoryModelImpl._originalParentCategory = categoryModelImpl._parentCategory;

        categoryModelImpl._setOriginalParentCategory = false;

        categoryModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Category> toCacheModel() {
        CategoryCacheModel categoryCacheModel = new CategoryCacheModel();

        categoryCacheModel.categoryId = getCategoryId();

        categoryCacheModel.companyId = getCompanyId();

        categoryCacheModel.userId = getUserId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            categoryCacheModel.createDate = createDate.getTime();
        } else {
            categoryCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            categoryCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            categoryCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        categoryCacheModel.categoryName = getCategoryName();

        String categoryName = categoryCacheModel.categoryName;

        if ((categoryName != null) && (categoryName.length() == 0)) {
            categoryCacheModel.categoryName = null;
        }

        categoryCacheModel.parentCategory = getParentCategory();

        return categoryCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{categoryId=");
        sb.append(getCategoryId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", categoryName=");
        sb.append(getCategoryName());
        sb.append(", parentCategory=");
        sb.append(getParentCategory());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Category");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
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
            "<column><column-name>categoryName</column-name><column-value><![CDATA[");
        sb.append(getCategoryName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentCategory</column-name><column-value><![CDATA[");
        sb.append(getParentCategory());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}