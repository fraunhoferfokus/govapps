package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: RegionPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchRegionException;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.model.impl.RegionImpl;
import de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl;
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
 * The persistence implementation for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see RegionPersistence
 * @see RegionUtil
 * @generated
 */
public class RegionPersistenceImpl extends BasePersistenceImpl<Region>
    implements RegionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RegionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            RegionModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CP = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycp",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycp",
            new String[] { Long.class.getName(), Long.class.getName() },
            RegionModelImpl.COMPANYID_COLUMN_BITMASK |
            RegionModelImpl.PARENTREGION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CP = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycp",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_REGIONNAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByregionName",
            new String[] { String.class.getName() },
            RegionModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REGIONNAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregionName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_APPLICATIONS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl.class,
            RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "getApplications",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_APPLICATIONS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_APPLICATIONS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            Long.class,
            RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "getApplicationsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_APPLICATIONS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_APPLICATION = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            RegionModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            Boolean.class,
            RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "containsApplication",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_REGION = "SELECT region FROM Region region";
    private static final String _SQL_SELECT_REGION_WHERE = "SELECT region FROM Region region WHERE ";
    private static final String _SQL_COUNT_REGION = "SELECT COUNT(region) FROM Region region";
    private static final String _SQL_COUNT_REGION_WHERE = "SELECT COUNT(region) FROM Region region WHERE ";
    private static final String _SQL_GETAPPLICATIONS = "SELECT {mvp_Application.*} FROM mvp_Application INNER JOIN mvp_Application_Region ON (mvp_Application_Region.applicationId = mvp_Application.applicationId) WHERE (mvp_Application_Region.regionId = ?)";
    private static final String _SQL_GETAPPLICATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Region WHERE regionId = ?";
    private static final String _SQL_CONTAINSAPPLICATION = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Region WHERE regionId = ? AND applicationId = ?";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "region.companyId = ?";
    private static final String _FINDER_COLUMN_CP_COMPANYID_2 = "region.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CP_PARENTREGION_2 = "region.parentRegion = ?";
    private static final String _FINDER_COLUMN_REGIONNAME_NAME_1 = "region.name IS NULL";
    private static final String _FINDER_COLUMN_REGIONNAME_NAME_2 = "region.name = ?";
    private static final String _FINDER_COLUMN_REGIONNAME_NAME_3 = "(region.name IS NULL OR region.name = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "region.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Region exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Region exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RegionPersistenceImpl.class);
    private static Region _nullRegion = new RegionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Region> toCacheModel() {
                return _nullRegionCacheModel;
            }
        };

    private static CacheModel<Region> _nullRegionCacheModel = new CacheModel<Region>() {
            public Region toEntityModel() {
                return _nullRegion;
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
     * Caches the region in the entity cache if it is enabled.
     *
     * @param region the region
     */
    public void cacheResult(Region region) {
        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONNAME,
            new Object[] { region.getName() }, region);

        region.resetOriginalValues();
    }

    /**
     * Caches the regions in the entity cache if it is enabled.
     *
     * @param regions the regions
     */
    public void cacheResult(List<Region> regions) {
        for (Region region : regions) {
            if (EntityCacheUtil.getResult(
                        RegionModelImpl.ENTITY_CACHE_ENABLED, RegionImpl.class,
                        region.getPrimaryKey()) == null) {
                cacheResult(region);
            } else {
                region.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all regions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RegionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RegionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the region.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Region region) {
        EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(region);
    }

    @Override
    public void clearCache(List<Region> regions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Region region : regions) {
            EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, region.getPrimaryKey());

            clearUniqueFindersCache(region);
        }
    }

    protected void clearUniqueFindersCache(Region region) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONNAME,
            new Object[] { region.getName() });
    }

    /**
     * Creates a new region with the primary key. Does not add the region to the database.
     *
     * @param regionId the primary key for the new region
     * @return the new region
     */
    public Region create(long regionId) {
        Region region = new RegionImpl();

        region.setNew(true);
        region.setPrimaryKey(regionId);

        return region;
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param regionId the primary key of the region
     * @return the region that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region remove(long regionId)
        throws NoSuchRegionException, SystemException {
        return remove(Long.valueOf(regionId));
    }

    /**
     * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the region
     * @return the region that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region remove(Serializable primaryKey)
        throws NoSuchRegionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Region region = (Region) session.get(RegionImpl.class, primaryKey);

            if (region == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(region);
        } catch (NoSuchRegionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Region removeImpl(Region region) throws SystemException {
        region = toUnwrappedModel(region);

        try {
            clearApplications.clear(region.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, region);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(region);

        return region;
    }

    @Override
    public Region updateImpl(de.fraunhofer.fokus.movepla.model.Region region,
        boolean merge) throws SystemException {
        region = toUnwrappedModel(region);

        boolean isNew = region.isNew();

        RegionModelImpl regionModelImpl = (RegionModelImpl) region;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, region, merge);

            region.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RegionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(regionModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] { Long.valueOf(regionModelImpl.getCompanyId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(regionModelImpl.getOriginalCompanyId()),
                        Long.valueOf(regionModelImpl.getOriginalParentRegion())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP,
                    args);

                args = new Object[] {
                        Long.valueOf(regionModelImpl.getCompanyId()),
                        Long.valueOf(regionModelImpl.getParentRegion())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP,
                    args);
            }
        }

        EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
            RegionImpl.class, region.getPrimaryKey(), region);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                new Object[] { region.getName() }, region);
        } else {
            if ((regionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_REGIONNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { regionModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONNAME,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                    new Object[] { region.getName() }, region);
            }
        }

        return region;
    }

    protected Region toUnwrappedModel(Region region) {
        if (region instanceof RegionImpl) {
            return region;
        }

        RegionImpl regionImpl = new RegionImpl();

        regionImpl.setNew(region.isNew());
        regionImpl.setPrimaryKey(region.getPrimaryKey());

        regionImpl.setRegionId(region.getRegionId());
        regionImpl.setCompanyId(region.getCompanyId());
        regionImpl.setUserId(region.getUserId());
        regionImpl.setCreateDate(region.getCreateDate());
        regionImpl.setModifiedDate(region.getModifiedDate());
        regionImpl.setName(region.getName());
        regionImpl.setAgs(region.getAgs());
        regionImpl.setCoordniates_x(region.getCoordniates_x());
        regionImpl.setCoordniates_y(region.getCoordniates_y());
        regionImpl.setParentRegion(region.getParentRegion());

        return regionImpl;
    }

    /**
     * Returns the region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region
     * @throws com.liferay.portal.NoSuchModelException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the region with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRegionException} if it could not be found.
     *
     * @param regionId the primary key of the region
     * @return the region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findByPrimaryKey(long regionId)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByPrimaryKey(regionId);

        if (region == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + regionId);
            }

            throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                regionId);
        }

        return region;
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Region fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param regionId the primary key of the region
     * @return the region, or <code>null</code> if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchByPrimaryKey(long regionId) throws SystemException {
        Region region = (Region) EntityCacheUtil.getResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                RegionImpl.class, regionId);

        if (region == _nullRegion) {
            return null;
        }

        if (region == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                region = (Region) session.get(RegionImpl.class,
                        Long.valueOf(regionId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (region != null) {
                    cacheResult(region);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
                        RegionImpl.class, regionId, _nullRegion);
                }

                closeSession(session);
            }
        }

        return region;
    }

    /**
     * Returns all the regions where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the regions where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @return the range of matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the regions where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findByc(long companyId, int start, int end,
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

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if ((companyId != region.getCompanyId())) {
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

            query.append(_SQL_SELECT_REGION_WHERE);

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

                list = (List<Region>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first region in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByc_First(companyId, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last region in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByc_Last(companyId, orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Region> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the regions before and after the current region in the ordered set where companyId = &#63;.
     *
     * @param regionId the primary key of the current region
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region[] findByc_PrevAndNext(long regionId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(regionId);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getByc_PrevAndNext(session, region, companyId,
                    orderByComparator, true);

            array[1] = region;

            array[2] = getByc_PrevAndNext(session, region, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getByc_PrevAndNext(Session session, Region region,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the regions where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @return the matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findBycp(long companyId, long parentRegion)
        throws SystemException {
        return findBycp(companyId, parentRegion, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the regions where companyId = &#63; and parentRegion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @return the range of matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findBycp(long companyId, long parentRegion, int start,
        int end) throws SystemException {
        return findBycp(companyId, parentRegion, start, end, null);
    }

    /**
     * Returns an ordered range of all the regions where companyId = &#63; and parentRegion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findBycp(long companyId, long parentRegion, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CP;
            finderArgs = new Object[] { companyId, parentRegion };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CP;
            finderArgs = new Object[] {
                    companyId, parentRegion,
                    
                    start, end, orderByComparator
                };
        }

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Region region : list) {
                if ((companyId != region.getCompanyId()) ||
                        (parentRegion != region.getParentRegion())) {
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

            query.append(_SQL_SELECT_REGION_WHERE);

            query.append(_FINDER_COLUMN_CP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CP_PARENTREGION_2);

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

                qPos.add(parentRegion);

                list = (List<Region>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first region in the ordered set where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findBycp_First(long companyId, long parentRegion,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchBycp_First(companyId, parentRegion,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", parentRegion=");
        msg.append(parentRegion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the first region in the ordered set where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchBycp_First(long companyId, long parentRegion,
        OrderByComparator orderByComparator) throws SystemException {
        List<Region> list = findBycp(companyId, parentRegion, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last region in the ordered set where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findBycp_Last(long companyId, long parentRegion,
        OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = fetchBycp_Last(companyId, parentRegion,
                orderByComparator);

        if (region != null) {
            return region;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", parentRegion=");
        msg.append(parentRegion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRegionException(msg.toString());
    }

    /**
     * Returns the last region in the ordered set where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchBycp_Last(long companyId, long parentRegion,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycp(companyId, parentRegion);

        List<Region> list = findBycp(companyId, parentRegion, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the regions before and after the current region in the ordered set where companyId = &#63; and parentRegion = &#63;.
     *
     * @param regionId the primary key of the current region
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region[] findBycp_PrevAndNext(long regionId, long companyId,
        long parentRegion, OrderByComparator orderByComparator)
        throws NoSuchRegionException, SystemException {
        Region region = findByPrimaryKey(regionId);

        Session session = null;

        try {
            session = openSession();

            Region[] array = new RegionImpl[3];

            array[0] = getBycp_PrevAndNext(session, region, companyId,
                    parentRegion, orderByComparator, true);

            array[1] = region;

            array[2] = getBycp_PrevAndNext(session, region, companyId,
                    parentRegion, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Region getBycp_PrevAndNext(Session session, Region region,
        long companyId, long parentRegion, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REGION_WHERE);

        query.append(_FINDER_COLUMN_CP_COMPANYID_2);

        query.append(_FINDER_COLUMN_CP_PARENTREGION_2);

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

        qPos.add(parentRegion);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(region);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Region> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the region where name = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRegionException} if it could not be found.
     *
     * @param name the name
     * @return the matching region
     * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region findByregionName(String name)
        throws NoSuchRegionException, SystemException {
        Region region = fetchByregionName(name);

        if (region == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRegionException(msg.toString());
        }

        return region;
    }

    /**
     * Returns the region where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchByregionName(String name) throws SystemException {
        return fetchByregionName(name, true);
    }

    /**
     * Returns the region where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching region, or <code>null</code> if a matching region could not be found
     * @throws SystemException if a system exception occurred
     */
    public Region fetchByregionName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                    finderArgs, this);
        }

        if (result instanceof Region) {
            Region region = (Region) result;

            if (!Validator.equals(name, region.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_REGION_WHERE);

            if (name == null) {
                query.append(_FINDER_COLUMN_REGIONNAME_NAME_1);
            } else {
                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONNAME_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONNAME_NAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (name != null) {
                    qPos.add(name);
                }

                List<Region> list = q.list();

                result = list;

                Region region = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                        finderArgs, list);
                } else {
                    region = list.get(0);

                    cacheResult(region);

                    if ((region.getName() == null) ||
                            !region.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                            finderArgs, region);
                    }
                }

                return region;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONNAME,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Region) result;
            }
        }
    }

    /**
     * Returns all the regions.
     *
     * @return the regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the regions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @return the range of regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the regions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of regions
     * @throws SystemException if a system exception occurred
     */
    public List<Region> findAll(int start, int end,
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

        List<Region> list = (List<Region>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REGION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REGION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Region>) QueryUtil.list(q, getDialect(),
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
     * Removes all the regions where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Region region : findByc(companyId)) {
            remove(region);
        }
    }

    /**
     * Removes all the regions where companyId = &#63; and parentRegion = &#63; from the database.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @throws SystemException if a system exception occurred
     */
    public void removeBycp(long companyId, long parentRegion)
        throws SystemException {
        for (Region region : findBycp(companyId, parentRegion)) {
            remove(region);
        }
    }

    /**
     * Removes the region where name = &#63; from the database.
     *
     * @param name the name
     * @return the region that was removed
     * @throws SystemException if a system exception occurred
     */
    public Region removeByregionName(String name)
        throws NoSuchRegionException, SystemException {
        Region region = findByregionName(name);

        return remove(region);
    }

    /**
     * Removes all the regions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Region region : findAll()) {
            remove(region);
        }
    }

    /**
     * Returns the number of regions where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching regions
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_REGION_WHERE);

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
     * Returns the number of regions where companyId = &#63; and parentRegion = &#63;.
     *
     * @param companyId the company ID
     * @param parentRegion the parent region
     * @return the number of matching regions
     * @throws SystemException if a system exception occurred
     */
    public int countBycp(long companyId, long parentRegion)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, parentRegion };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CP,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_REGION_WHERE);

            query.append(_FINDER_COLUMN_CP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CP_PARENTREGION_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(parentRegion);

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
     * Returns the number of regions where name = &#63;.
     *
     * @param name the name
     * @return the number of matching regions
     * @throws SystemException if a system exception occurred
     */
    public int countByregionName(String name) throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REGIONNAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_REGION_WHERE);

            if (name == null) {
                query.append(_FINDER_COLUMN_REGIONNAME_NAME_1);
            } else {
                if (name.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONNAME_NAME_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONNAME_NAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (name != null) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of regions.
     *
     * @return the number of regions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_REGION);

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
     * Returns all the applications associated with the region.
     *
     * @param pk the primary key of the region
     * @return the applications associated with the region
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws SystemException {
        return getApplications(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the applications associated with the region.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the region
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @return the range of applications associated with the region
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end) throws SystemException {
        return getApplications(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications associated with the region.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the region
     * @param start the lower bound of the range of regions
     * @param end the upper bound of the range of regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applications associated with the region
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
     * Returns the number of applications associated with the region.
     *
     * @param pk the primary key of the region
     * @return the number of applications associated with the region
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
     * Returns <code>true</code> if the application is associated with the region.
     *
     * @param pk the primary key of the region
     * @param applicationPK the primary key of the application
     * @return <code>true</code> if the application is associated with the region; <code>false</code> otherwise
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
     * Returns <code>true</code> if the region has any applications associated with it.
     *
     * @param pk the primary key of the region to check for associations with applications
     * @return <code>true</code> if the region has any applications associated with it; <code>false</code> otherwise
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
     * Adds an association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Clears all associations between the region and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region to clear the associated applications from
     * @throws SystemException if a system exception occurred
     */
    public void clearApplications(long pk) throws SystemException {
        try {
            clearApplications.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Sets the applications associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param applicationPKs the primary keys of the applications to be associated with the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Sets the applications associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the region
     * @param applications the applications to be associated with the region
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
            FinderCacheUtil.clearCache(RegionModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Initializes the region persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Region")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Region>> listenersList = new ArrayList<ModelListener<Region>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Region>) InstanceFactory.newInstance(
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
        EntityCacheUtil.removeCache(RegionImpl.class.getName());
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

        protected boolean contains(long regionId, long applicationId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(regionId), new Long(applicationId)
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
                    "INSERT INTO mvp_Application_Region (regionId, applicationId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long regionId, long applicationId)
            throws SystemException {
            if (!containsApplication.contains(regionId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Region> listener : listeners) {
                    listener.onBeforeAddAssociation(regionId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        Region.class.getName(), regionId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(regionId), new Long(applicationId)
                    });

                for (ModelListener<Region> listener : listeners) {
                    listener.onAfterAddAssociation(regionId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterAddAssociation(applicationId,
                        Region.class.getName(), regionId);
                }
            }
        }
    }

    protected class ClearApplications {
        private SqlUpdate _sqlUpdate;

        protected ClearApplications() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Region WHERE regionId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long regionId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                applicationPersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Application> applications = null;

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                applications = getApplications(regionId);

                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Region> listener : listeners) {
                        listener.onBeforeRemoveAssociation(regionId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onBeforeRemoveAssociation(application.getPrimaryKey(),
                            Region.class.getName(), regionId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(regionId) });

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Region> listener : listeners) {
                        listener.onAfterRemoveAssociation(regionId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onAfterRemoveAssociation(application.getPrimaryKey(),
                            Region.class.getName(), regionId);
                    }
                }
            }
        }
    }

    protected class RemoveApplication {
        private SqlUpdate _sqlUpdate;

        protected RemoveApplication() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Region WHERE regionId = ? AND applicationId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long regionId, long applicationId)
            throws SystemException {
            if (containsApplication.contains(regionId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Region> listener : listeners) {
                    listener.onBeforeRemoveAssociation(regionId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        Region.class.getName(), regionId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(regionId), new Long(applicationId)
                    });

                for (ModelListener<Region> listener : listeners) {
                    listener.onAfterRemoveAssociation(regionId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        Region.class.getName(), regionId);
                }
            }
        }
    }
}
