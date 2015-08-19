package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: CategoryPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.movepla.NoSuchCategoryException;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.impl.CategoryImpl;
import de.fraunhofer.fokus.movepla.model.impl.CategoryModelImpl;
import de.fraunhofer.fokus.movepla.service.persistence.ApplicationPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.Application_EntitlementPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.CategoryPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.EntitlementPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LanguagePersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LegalDetailsPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LinkPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LoggingPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.MultiMediaPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.RegionPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.RelatedApplicationsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see CategoryPersistence
 * @see CategoryUtil
 * @generated
 */
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category>
    implements CategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CP = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycp",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycp",
            new String[] { Long.class.getName(), Long.class.getName() },
            CategoryModelImpl.COMPANYID_COLUMN_BITMASK |
            CategoryModelImpl.PARENTCATEGORY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CP = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycp",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORYNAME = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBycategoryName",
            new String[] { String.class.getName() },
            CategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycategoryName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_APPLICATIONS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl.class,
            CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "getApplications",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_APPLICATIONS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_APPLICATIONS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            Long.class,
            CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "getApplicationsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_APPLICATIONS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_APPLICATION = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            Boolean.class,
            CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "containsApplication",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM Category category";
    private static final String _SQL_SELECT_CATEGORY_WHERE = "SELECT category FROM Category category WHERE ";
    private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM Category category";
    private static final String _SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(category) FROM Category category WHERE ";
    private static final String _SQL_GETAPPLICATIONS = "SELECT {mvp_Application.*} FROM mvp_Application INNER JOIN mvp_Application_Category ON (mvp_Application_Category.applicationId = mvp_Application.applicationId) WHERE (mvp_Application_Category.categoryId = ?)";
    private static final String _SQL_GETAPPLICATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Category WHERE categoryId = ?";
    private static final String _SQL_CONTAINSAPPLICATION = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Category WHERE categoryId = ? AND applicationId = ?";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "category.companyId = ?";
    private static final String _FINDER_COLUMN_CP_COMPANYID_2 = "category.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CP_PARENTCATEGORY_2 = "category.parentCategory = ?";
    private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "category.categoryName IS NULL";
    private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "category.categoryName = ?";
    private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(category.categoryName IS NULL OR category.categoryName = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Category exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Category exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CategoryPersistenceImpl.class);
    private static Category _nullCategory = new CategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Category> toCacheModel() {
                return _nullCategoryCacheModel;
            }
        };

    private static CacheModel<Category> _nullCategoryCacheModel = new CacheModel<Category>() {
            public Category toEntityModel() {
                return _nullCategory;
            }
        };

    @BeanReference(type = ApplicationPersistence.class)
    protected ApplicationPersistence applicationPersistence;
    @BeanReference(type = Application_EntitlementPersistence.class)
    protected Application_EntitlementPersistence application_EntitlementPersistence;
    @BeanReference(type = CategoryPersistence.class)
    protected CategoryPersistence categoryPersistence;
    @BeanReference(type = EntitlementPersistence.class)
    protected EntitlementPersistence entitlementPersistence;
    @BeanReference(type = LanguagePersistence.class)
    protected LanguagePersistence languagePersistence;
    @BeanReference(type = LegalDetailsPersistence.class)
    protected LegalDetailsPersistence legalDetailsPersistence;
    @BeanReference(type = LinkPersistence.class)
    protected LinkPersistence linkPersistence;
    @BeanReference(type = LoggingPersistence.class)
    protected LoggingPersistence loggingPersistence;
    @BeanReference(type = MultiMediaPersistence.class)
    protected MultiMediaPersistence multiMediaPersistence;
    @BeanReference(type = RegionPersistence.class)
    protected RegionPersistence regionPersistence;
    @BeanReference(type = RelatedApplicationsPersistence.class)
    protected RelatedApplicationsPersistence relatedApplicationsPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    protected ContainsApplication containsApplication;
    protected AddApplication addApplication;
    protected ClearApplications clearApplications;
    protected RemoveApplication removeApplication;

    /**
     * Caches the category in the entity cache if it is enabled.
     *
     * @param category the category
     */
    public void cacheResult(Category category) {
        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
            new Object[] { category.getCategoryName() }, category);

        category.resetOriginalValues();
    }

    /**
     * Caches the categories in the entity cache if it is enabled.
     *
     * @param categories the categories
     */
    public void cacheResult(List<Category> categories) {
        for (Category category : categories) {
            if (EntityCacheUtil.getResult(
                        CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, category.getPrimaryKey()) == null) {
                cacheResult(category);
            } else {
                category.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Category category) {
        EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(category);
    }

    @Override
    public void clearCache(List<Category> categories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Category category : categories) {
            EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, category.getPrimaryKey());

            clearUniqueFindersCache(category);
        }
    }

    protected void clearUniqueFindersCache(Category category) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
            new Object[] { category.getCategoryName() });
    }

    /**
     * Creates a new category with the primary key. Does not add the category to the database.
     *
     * @param categoryId the primary key for the new category
     * @return the new category
     */
    public Category create(long categoryId) {
        Category category = new CategoryImpl();

        category.setNew(true);
        category.setPrimaryKey(categoryId);

        return category;
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param categoryId the primary key of the category
     * @return the category that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category remove(long categoryId)
        throws NoSuchCategoryException, SystemException {
        return remove(Long.valueOf(categoryId));
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the category
     * @return the category that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category remove(Serializable primaryKey)
        throws NoSuchCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Category category = (Category) session.get(CategoryImpl.class,
                    primaryKey);

            if (category == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(category);
        } catch (NoSuchCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Category removeImpl(Category category) throws SystemException {
        category = toUnwrappedModel(category);

        try {
            clearApplications.clear(category.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, category);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(category);

        return category;
    }

    @Override
    public Category updateImpl(
        de.fraunhofer.fokus.movepla.model.Category category, boolean merge)
        throws SystemException {
        category = toUnwrappedModel(category);

        boolean isNew = category.isNew();

        CategoryModelImpl categoryModelImpl = (CategoryModelImpl) category;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, category, merge);

            category.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((categoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(categoryModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(categoryModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((categoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(categoryModelImpl.getOriginalCompanyId()),
                        Long.valueOf(categoryModelImpl.getOriginalParentCategory())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP,
                    args);

                args = new Object[] {
                        Long.valueOf(categoryModelImpl.getCompanyId()),
                        Long.valueOf(categoryModelImpl.getParentCategory())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP,
                    args);
            }
        }

        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                new Object[] { category.getCategoryName() }, category);
        } else {
            if ((categoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        categoryModelImpl.getOriginalCategoryName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                    new Object[] { category.getCategoryName() }, category);
            }
        }

        return category;
    }

    protected Category toUnwrappedModel(Category category) {
        if (category instanceof CategoryImpl) {
            return category;
        }

        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setNew(category.isNew());
        categoryImpl.setPrimaryKey(category.getPrimaryKey());

        categoryImpl.setCategoryId(category.getCategoryId());
        categoryImpl.setCompanyId(category.getCompanyId());
        categoryImpl.setUserId(category.getUserId());
        categoryImpl.setCreateDate(category.getCreateDate());
        categoryImpl.setModifiedDate(category.getModifiedDate());
        categoryImpl.setCategoryName(category.getCategoryName());
        categoryImpl.setParentCategory(category.getParentCategory());

        return categoryImpl;
    }

    /**
     * Returns the category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category
     * @throws com.liferay.portal.NoSuchModelException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the category with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchCategoryException} if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findByPrimaryKey(long categoryId)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByPrimaryKey(categoryId);

        if (category == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
            }

            throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                categoryId);
        }

        return category;
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByPrimaryKey(long categoryId)
        throws SystemException {
        Category category = (Category) EntityCacheUtil.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, categoryId);

        if (category == _nullCategory) {
            return null;
        }

        if (category == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                category = (Category) session.get(CategoryImpl.class,
                        Long.valueOf(categoryId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (category != null) {
                    cacheResult(category);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, categoryId, _nullCategory);
                }

                closeSession(session);
            }
        }

        return category;
    }

    /**
     * Returns all the categories where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categories where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the categories where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findByc(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Category category : list) {
                if ((companyId != category.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_CATEGORY_WHERE);

            query.append(_FINDER_COLUMN_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<Category>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first category in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByc_First(companyId, orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the first category in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Category> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByc_Last(companyId, orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Category> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the categories before and after the current category in the ordered set where companyId = &#63;.
     *
     * @param categoryId the primary key of the current category
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category[] findByc_PrevAndNext(long categoryId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = findByPrimaryKey(categoryId);

        Session session = null;

        try {
            session = openSession();

            Category[] array = new CategoryImpl[3];

            array[0] = getByc_PrevAndNext(session, category, companyId,
                    orderByComparator, true);

            array[1] = category;

            array[2] = getByc_PrevAndNext(session, category, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Category getByc_PrevAndNext(Session session, Category category,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CATEGORY_WHERE);

        query.append(_FINDER_COLUMN_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(category);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Category> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the categories where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @return the matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findBycp(long companyId, long parentCategory)
        throws SystemException {
        return findBycp(companyId, parentCategory, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categories where companyId = &#63; and parentCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findBycp(long companyId, long parentCategory,
        int start, int end) throws SystemException {
        return findBycp(companyId, parentCategory, start, end, null);
    }

    /**
     * Returns an ordered range of all the categories where companyId = &#63; and parentCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findBycp(long companyId, long parentCategory,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP;
            finderArgs = new Object[] { companyId, parentCategory };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CP;
            finderArgs = new Object[] {
                    companyId, parentCategory,
                    
                    start, end, orderByComparator
                };
        }

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Category category : list) {
                if ((companyId != category.getCompanyId()) ||
                        (parentCategory != category.getParentCategory())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CP_PARENTCATEGORY_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(parentCategory);

                list = (List<Category>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first category in the ordered set where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findBycp_First(long companyId, long parentCategory,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchBycp_First(companyId, parentCategory,
                orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", parentCategory=");
        msg.append(parentCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the first category in the ordered set where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchBycp_First(long companyId, long parentCategory,
        OrderByComparator orderByComparator) throws SystemException {
        List<Category> list = findBycp(companyId, parentCategory, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findBycp_Last(long companyId, long parentCategory,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchBycp_Last(companyId, parentCategory,
                orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", parentCategory=");
        msg.append(parentCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchBycp_Last(long companyId, long parentCategory,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycp(companyId, parentCategory);

        List<Category> list = findBycp(companyId, parentCategory, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the categories before and after the current category in the ordered set where companyId = &#63; and parentCategory = &#63;.
     *
     * @param categoryId the primary key of the current category
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category[] findBycp_PrevAndNext(long categoryId, long companyId,
        long parentCategory, OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = findByPrimaryKey(categoryId);

        Session session = null;

        try {
            session = openSession();

            Category[] array = new CategoryImpl[3];

            array[0] = getBycp_PrevAndNext(session, category, companyId,
                    parentCategory, orderByComparator, true);

            array[1] = category;

            array[2] = getBycp_PrevAndNext(session, category, companyId,
                    parentCategory, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Category getBycp_PrevAndNext(Session session, Category category,
        long companyId, long parentCategory,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CATEGORY_WHERE);

        query.append(_FINDER_COLUMN_CP_COMPANYID_2);

        query.append(_FINDER_COLUMN_CP_PARENTCATEGORY_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(parentCategory);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(category);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Category> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the category where categoryName = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchCategoryException} if it could not be found.
     *
     * @param categoryName the category name
     * @return the matching category
     * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findBycategoryName(String categoryName)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchBycategoryName(categoryName);

        if (category == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("categoryName=");
            msg.append(categoryName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCategoryException(msg.toString());
        }

        return category;
    }

    /**
     * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param categoryName the category name
     * @return the matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchBycategoryName(String categoryName)
        throws SystemException {
        return fetchBycategoryName(categoryName, true);
    }

    /**
     * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param categoryName the category name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchBycategoryName(String categoryName,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { categoryName };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                    finderArgs, this);
        }

        if (result instanceof Category) {
            Category category = (Category) result;

            if (!Validator.equals(categoryName, category.getCategoryName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_CATEGORY_WHERE);

            if (categoryName == null) {
                query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
            } else {
                if (categoryName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (categoryName != null) {
                    qPos.add(categoryName);
                }

                List<Category> list = q.list();

                result = list;

                Category category = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                        finderArgs, list);
                } else {
                    category = list.get(0);

                    cacheResult(category);

                    if ((category.getCategoryName() == null) ||
                            !category.getCategoryName().equals(categoryName)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                            finderArgs, category);
                    }
                }

                return category;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Category) result;
            }
        }
    }

    /**
     * Returns all the categories.
     *
     * @return the categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CATEGORY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the categories where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Category category : findByc(companyId)) {
            remove(category);
        }
    }

    /**
     * Removes all the categories where companyId = &#63; and parentCategory = &#63; from the database.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @throws SystemException if a system exception occurred
     */
    public void removeBycp(long companyId, long parentCategory)
        throws SystemException {
        for (Category category : findBycp(companyId, parentCategory)) {
            remove(category);
        }
    }

    /**
     * Removes the category where categoryName = &#63; from the database.
     *
     * @param categoryName the category name
     * @return the category that was removed
     * @throws SystemException if a system exception occurred
     */
    public Category removeBycategoryName(String categoryName)
        throws NoSuchCategoryException, SystemException {
        Category category = findBycategoryName(categoryName);

        return remove(category);
    }

    /**
     * Removes all the categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Category category : findAll()) {
            remove(category);
        }
    }

    /**
     * Returns the number of categories where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching categories
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CATEGORY_WHERE);

            query.append(_FINDER_COLUMN_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of categories where companyId = &#63; and parentCategory = &#63;.
     *
     * @param companyId the company ID
     * @param parentCategory the parent category
     * @return the number of matching categories
     * @throws SystemException if a system exception occurred
     */
    public int countBycp(long companyId, long parentCategory)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, parentCategory };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CP,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CP_PARENTCATEGORY_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(parentCategory);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CP, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of categories where categoryName = &#63;.
     *
     * @param categoryName the category name
     * @return the number of matching categories
     * @throws SystemException if a system exception occurred
     */
    public int countBycategoryName(String categoryName)
        throws SystemException {
        Object[] finderArgs = new Object[] { categoryName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CATEGORY_WHERE);

            if (categoryName == null) {
                query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
            } else {
                if (categoryName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (categoryName != null) {
                    qPos.add(categoryName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of categories.
     *
     * @return the number of categories
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CATEGORY);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the applications associated with the category.
     *
     * @param pk the primary key of the category
     * @return the applications associated with the category
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws SystemException {
        return getApplications(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the applications associated with the category.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the category
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of applications associated with the category
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end) throws SystemException {
        return getApplications(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications associated with the category.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the category
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applications associated with the category
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Application> list = (List<de.fraunhofer.fokus.movepla.model.Application>) FinderCacheUtil.getResult(FINDER_PATH_GET_APPLICATIONS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETAPPLICATIONS.concat(ORDER_BY_CLAUSE)
                                              .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETAPPLICATIONS.concat(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ORDER_BY_SQL);
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Application",
                    de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Application>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_APPLICATIONS,
                        finderArgs);
                } else {
                    applicationPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_APPLICATIONS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of applications associated with the category.
     *
     * @param pk the primary key of the category
     * @return the number of applications associated with the category
     * @throws SystemException if a system exception occurred
     */
    public int getApplicationsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_APPLICATIONS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETAPPLICATIONSSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_APPLICATIONS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the application is associated with the category.
     *
     * @param pk the primary key of the category
     * @param applicationPK the primary key of the application
     * @return <code>true</code> if the application is associated with the category; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsApplication(long pk, long applicationPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, applicationPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_APPLICATION,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsApplication.contains(pk,
                            applicationPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_APPLICATION,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the category has any applications associated with it.
     *
     * @param pk the primary key of the category to check for associations with applications
     * @return <code>true</code> if the category has any applications associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsApplications(long pk) throws SystemException {
        if (getApplicationsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applicationPK the primary key of the application
     * @throws SystemException if a system exception occurred
     */
    public void addApplication(long pk, long applicationPK)
        throws SystemException {
        try {
            addApplication.add(pk, applicationPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param application the application
     * @throws SystemException if a system exception occurred
     */
    public void addApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws SystemException {
        try {
            addApplication.add(pk, application.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applicationPKs the primary keys of the applications
     * @throws SystemException if a system exception occurred
     */
    public void addApplications(long pk, long[] applicationPKs)
        throws SystemException {
        try {
            for (long applicationPK : applicationPKs) {
                addApplication.add(pk, applicationPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applications the applications
     * @throws SystemException if a system exception occurred
     */
    public void addApplications(long pk,
        List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                addApplication.add(pk, application.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Clears all associations between the category and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category to clear the associated applications from
     * @throws SystemException if a system exception occurred
     */
    public void clearApplications(long pk) throws SystemException {
        try {
            clearApplications.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applicationPK the primary key of the application
     * @throws SystemException if a system exception occurred
     */
    public void removeApplication(long pk, long applicationPK)
        throws SystemException {
        try {
            removeApplication.remove(pk, applicationPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param application the application
     * @throws SystemException if a system exception occurred
     */
    public void removeApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws SystemException {
        try {
            removeApplication.remove(pk, application.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applicationPKs the primary keys of the applications
     * @throws SystemException if a system exception occurred
     */
    public void removeApplications(long pk, long[] applicationPKs)
        throws SystemException {
        try {
            for (long applicationPK : applicationPKs) {
                removeApplication.remove(pk, applicationPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applications the applications
     * @throws SystemException if a system exception occurred
     */
    public void removeApplications(long pk,
        List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                removeApplication.remove(pk, application.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Sets the applications associated with the category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applicationPKs the primary keys of the applications to be associated with the category
     * @throws SystemException if a system exception occurred
     */
    public void setApplications(long pk, long[] applicationPKs)
        throws SystemException {
        try {
            Set<Long> applicationPKSet = SetUtil.fromArray(applicationPKs);

            List<de.fraunhofer.fokus.movepla.model.Application> applications = getApplications(pk);

            for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                if (!applicationPKSet.remove(application.getPrimaryKey())) {
                    removeApplication.remove(pk, application.getPrimaryKey());
                }
            }

            for (Long applicationPK : applicationPKSet) {
                addApplication.add(pk, applicationPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Sets the applications associated with the category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the category
     * @param applications the applications to be associated with the category
     * @throws SystemException if a system exception occurred
     */
    public void setApplications(long pk,
        List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws SystemException {
        try {
            long[] applicationPKs = new long[applications.size()];

            for (int i = 0; i < applications.size(); i++) {
                de.fraunhofer.fokus.movepla.model.Application application = applications.get(i);

                applicationPKs[i] = application.getPrimaryKey();
            }

            setApplications(pk, applicationPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CategoryModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Initializes the category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Category")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Category>> listenersList = new ArrayList<ModelListener<Category>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Category>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsApplication = new ContainsApplication();

        addApplication = new AddApplication();
        clearApplications = new ClearApplications();
        removeApplication = new RemoveApplication();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CategoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsApplication {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsApplication() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSAPPLICATION,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long categoryId, long applicationId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(categoryId), new Long(applicationId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }

    protected class AddApplication {
        private SqlUpdate _sqlUpdate;

        protected AddApplication() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO mvp_Application_Category (categoryId, applicationId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long categoryId, long applicationId)
            throws SystemException {
            if (!containsApplication.contains(categoryId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Category> listener : listeners) {
                    listener.onBeforeAddAssociation(categoryId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        Category.class.getName(), categoryId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(categoryId), new Long(applicationId)
                    });

                for (ModelListener<Category> listener : listeners) {
                    listener.onAfterAddAssociation(categoryId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterAddAssociation(applicationId,
                        Category.class.getName(), categoryId);
                }
            }
        }
    }

    protected class ClearApplications {
        private SqlUpdate _sqlUpdate;

        protected ClearApplications() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Category WHERE categoryId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long categoryId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                applicationPersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Application> applications = null;

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                applications = getApplications(categoryId);

                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Category> listener : listeners) {
                        listener.onBeforeRemoveAssociation(categoryId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onBeforeRemoveAssociation(application.getPrimaryKey(),
                            Category.class.getName(), categoryId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(categoryId) });

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Category> listener : listeners) {
                        listener.onAfterRemoveAssociation(categoryId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onAfterRemoveAssociation(application.getPrimaryKey(),
                            Category.class.getName(), categoryId);
                    }
                }
            }
        }
    }

    protected class RemoveApplication {
        private SqlUpdate _sqlUpdate;

        protected RemoveApplication() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Category WHERE categoryId = ? AND applicationId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long categoryId, long applicationId)
            throws SystemException {
            if (containsApplication.contains(categoryId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Category> listener : listeners) {
                    listener.onBeforeRemoveAssociation(categoryId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        Category.class.getName(), categoryId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(categoryId), new Long(applicationId)
                    });

                for (ModelListener<Category> listener : listeners) {
                    listener.onAfterRemoveAssociation(categoryId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        Category.class.getName(), categoryId);
                }
            }
        }
    }
}
