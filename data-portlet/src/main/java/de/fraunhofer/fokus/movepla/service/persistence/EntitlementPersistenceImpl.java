package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: EntitlementPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.movepla.NoSuchEntitlementException;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.impl.EntitlementImpl;
import de.fraunhofer.fokus.movepla.model.impl.EntitlementModelImpl;
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

/**
 * The persistence implementation for the entitlement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see EntitlementPersistence
 * @see EntitlementUtil
 * @generated
 */
public class EntitlementPersistenceImpl extends BasePersistenceImpl<Entitlement>
    implements EntitlementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EntitlementUtil} to access the entitlement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EntitlementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            EntitlementModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_APPLICATION_ENTITLEMENTS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.Application_EntitlementPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getApplication_Entitlements",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_APPLICATION_ENTITLEMENTS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_APPLICATION_ENTITLEMENTS_SIZE =
        new FinderPath(de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.Application_EntitlementPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getApplication_EntitlementsSize",
            new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_APPLICATION_ENTITLEMENTS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_APPLICATION_ENTITLEMENT = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.Application_EntitlementPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsApplication_Entitlement",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_ENTITLEMENT = "SELECT entitlement FROM Entitlement entitlement";
    private static final String _SQL_SELECT_ENTITLEMENT_WHERE = "SELECT entitlement FROM Entitlement entitlement WHERE ";
    private static final String _SQL_COUNT_ENTITLEMENT = "SELECT COUNT(entitlement) FROM Entitlement entitlement";
    private static final String _SQL_COUNT_ENTITLEMENT_WHERE = "SELECT COUNT(entitlement) FROM Entitlement entitlement WHERE ";
    private static final String _SQL_GETAPPLICATION_ENTITLEMENTS = "SELECT {mvp_Application_Entitlement.*} FROM mvp_Application_Entitlement INNER JOIN mvp_Entitlement ON (mvp_Entitlement.entitlementId = mvp_Application_Entitlement.entitlementId) WHERE (mvp_Entitlement.entitlementId = ?)";
    private static final String _SQL_GETAPPLICATION_ENTITLEMENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Entitlement WHERE entitlementId = ?";
    private static final String _SQL_CONTAINSAPPLICATION_ENTITLEMENT = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Entitlement WHERE entitlementId = ? AND applicationEntitlementID = ?";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "entitlement.companyId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "entitlement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Entitlement exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Entitlement exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EntitlementPersistenceImpl.class);
    private static Entitlement _nullEntitlement = new EntitlementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Entitlement> toCacheModel() {
                return _nullEntitlementCacheModel;
            }
        };

    private static CacheModel<Entitlement> _nullEntitlementCacheModel = new CacheModel<Entitlement>() {
            public Entitlement toEntityModel() {
                return _nullEntitlement;
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
    protected ContainsApplication_Entitlement containsApplication_Entitlement;

    /**
     * Caches the entitlement in the entity cache if it is enabled.
     *
     * @param entitlement the entitlement
     */
    public void cacheResult(Entitlement entitlement) {
        EntityCacheUtil.putResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementImpl.class, entitlement.getPrimaryKey(), entitlement);

        entitlement.resetOriginalValues();
    }

    /**
     * Caches the entitlements in the entity cache if it is enabled.
     *
     * @param entitlements the entitlements
     */
    public void cacheResult(List<Entitlement> entitlements) {
        for (Entitlement entitlement : entitlements) {
            if (EntityCacheUtil.getResult(
                        EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                        EntitlementImpl.class, entitlement.getPrimaryKey()) == null) {
                cacheResult(entitlement);
            } else {
                entitlement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all entitlements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EntitlementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EntitlementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the entitlement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Entitlement entitlement) {
        EntityCacheUtil.removeResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementImpl.class, entitlement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Entitlement> entitlements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Entitlement entitlement : entitlements) {
            EntityCacheUtil.removeResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                EntitlementImpl.class, entitlement.getPrimaryKey());
        }
    }

    /**
     * Creates a new entitlement with the primary key. Does not add the entitlement to the database.
     *
     * @param entitlementId the primary key for the new entitlement
     * @return the new entitlement
     */
    public Entitlement create(long entitlementId) {
        Entitlement entitlement = new EntitlementImpl();

        entitlement.setNew(true);
        entitlement.setPrimaryKey(entitlementId);

        return entitlement;
    }

    /**
     * Removes the entitlement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param entitlementId the primary key of the entitlement
     * @return the entitlement that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement remove(long entitlementId)
        throws NoSuchEntitlementException, SystemException {
        return remove(Long.valueOf(entitlementId));
    }

    /**
     * Removes the entitlement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the entitlement
     * @return the entitlement that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Entitlement remove(Serializable primaryKey)
        throws NoSuchEntitlementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Entitlement entitlement = (Entitlement) session.get(EntitlementImpl.class,
                    primaryKey);

            if (entitlement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEntitlementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(entitlement);
        } catch (NoSuchEntitlementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Entitlement removeImpl(Entitlement entitlement)
        throws SystemException {
        entitlement = toUnwrappedModel(entitlement);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, entitlement);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(entitlement);

        return entitlement;
    }

    @Override
    public Entitlement updateImpl(
        de.fraunhofer.fokus.movepla.model.Entitlement entitlement, boolean merge)
        throws SystemException {
        entitlement = toUnwrappedModel(entitlement);

        boolean isNew = entitlement.isNew();

        EntitlementModelImpl entitlementModelImpl = (EntitlementModelImpl) entitlement;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, entitlement, merge);

            entitlement.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EntitlementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((entitlementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(entitlementModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(entitlementModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            EntitlementImpl.class, entitlement.getPrimaryKey(), entitlement);

        return entitlement;
    }

    protected Entitlement toUnwrappedModel(Entitlement entitlement) {
        if (entitlement instanceof EntitlementImpl) {
            return entitlement;
        }

        EntitlementImpl entitlementImpl = new EntitlementImpl();

        entitlementImpl.setNew(entitlement.isNew());
        entitlementImpl.setPrimaryKey(entitlement.getPrimaryKey());

        entitlementImpl.setEntitlementId(entitlement.getEntitlementId());
        entitlementImpl.setCompanyId(entitlement.getCompanyId());
        entitlementImpl.setUserId(entitlement.getUserId());
        entitlementImpl.setCreateDate(entitlement.getCreateDate());
        entitlementImpl.setModifiedDate(entitlement.getModifiedDate());
        entitlementImpl.setEntitlementName(entitlement.getEntitlementName());
        entitlementImpl.setExplanation(entitlement.getExplanation());
        entitlementImpl.setEstimation(entitlement.getEstimation());

        return entitlementImpl;
    }

    /**
     * Returns the entitlement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the entitlement
     * @return the entitlement
     * @throws com.liferay.portal.NoSuchModelException if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Entitlement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the entitlement with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchEntitlementException} if it could not be found.
     *
     * @param entitlementId the primary key of the entitlement
     * @return the entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement findByPrimaryKey(long entitlementId)
        throws NoSuchEntitlementException, SystemException {
        Entitlement entitlement = fetchByPrimaryKey(entitlementId);

        if (entitlement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entitlementId);
            }

            throw new NoSuchEntitlementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                entitlementId);
        }

        return entitlement;
    }

    /**
     * Returns the entitlement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the entitlement
     * @return the entitlement, or <code>null</code> if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Entitlement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the entitlement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param entitlementId the primary key of the entitlement
     * @return the entitlement, or <code>null</code> if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement fetchByPrimaryKey(long entitlementId)
        throws SystemException {
        Entitlement entitlement = (Entitlement) EntityCacheUtil.getResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                EntitlementImpl.class, entitlementId);

        if (entitlement == _nullEntitlement) {
            return null;
        }

        if (entitlement == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                entitlement = (Entitlement) session.get(EntitlementImpl.class,
                        Long.valueOf(entitlementId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (entitlement != null) {
                    cacheResult(entitlement);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                        EntitlementImpl.class, entitlementId, _nullEntitlement);
                }

                closeSession(session);
            }
        }

        return entitlement;
    }

    /**
     * Returns all the entitlements where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the entitlements where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @return the range of matching entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the entitlements where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findByc(long companyId, int start, int end,
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

        List<Entitlement> list = (List<Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Entitlement entitlement : list) {
                if ((companyId != entitlement.getCompanyId())) {
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

            query.append(_SQL_SELECT_ENTITLEMENT_WHERE);

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

                list = (List<Entitlement>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a matching entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEntitlementException, SystemException {
        Entitlement entitlement = fetchByc_First(companyId, orderByComparator);

        if (entitlement != null) {
            return entitlement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEntitlementException(msg.toString());
    }

    /**
     * Returns the first entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching entitlement, or <code>null</code> if a matching entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Entitlement> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a matching entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEntitlementException, SystemException {
        Entitlement entitlement = fetchByc_Last(companyId, orderByComparator);

        if (entitlement != null) {
            return entitlement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEntitlementException(msg.toString());
    }

    /**
     * Returns the last entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching entitlement, or <code>null</code> if a matching entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Entitlement> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the entitlements before and after the current entitlement in the ordered set where companyId = &#63;.
     *
     * @param entitlementId the primary key of the current entitlement
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Entitlement[] findByc_PrevAndNext(long entitlementId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchEntitlementException, SystemException {
        Entitlement entitlement = findByPrimaryKey(entitlementId);

        Session session = null;

        try {
            session = openSession();

            Entitlement[] array = new EntitlementImpl[3];

            array[0] = getByc_PrevAndNext(session, entitlement, companyId,
                    orderByComparator, true);

            array[1] = entitlement;

            array[2] = getByc_PrevAndNext(session, entitlement, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Entitlement getByc_PrevAndNext(Session session,
        Entitlement entitlement, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ENTITLEMENT_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(entitlement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Entitlement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the entitlements.
     *
     * @return the entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the entitlements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @return the range of entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the entitlements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Entitlement> findAll(int start, int end,
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

        List<Entitlement> list = (List<Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ENTITLEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ENTITLEMENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Entitlement>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Entitlement>) QueryUtil.list(q, getDialect(),
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
     * Removes all the entitlements where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Entitlement entitlement : findByc(companyId)) {
            remove(entitlement);
        }
    }

    /**
     * Removes all the entitlements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Entitlement entitlement : findAll()) {
            remove(entitlement);
        }
    }

    /**
     * Returns the number of entitlements where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ENTITLEMENT_WHERE);

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
     * Returns the number of entitlements.
     *
     * @return the number of entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_ENTITLEMENT);

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
     * Returns all the application_ entitlements associated with the entitlement.
     *
     * @param pk the primary key of the entitlement
     * @return the application_ entitlements associated with the entitlement
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk) throws SystemException {
        return getApplication_Entitlements(pk, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the application_ entitlements associated with the entitlement.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the entitlement
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @return the range of application_ entitlements associated with the entitlement
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end) throws SystemException {
        return getApplication_Entitlements(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements associated with the entitlement.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the entitlement
     * @param start the lower bound of the range of entitlements
     * @param end the upper bound of the range of entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of application_ entitlements associated with the entitlement
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> list = (List<de.fraunhofer.fokus.movepla.model.Application_Entitlement>) FinderCacheUtil.getResult(FINDER_PATH_GET_APPLICATION_ENTITLEMENTS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETAPPLICATION_ENTITLEMENTS.concat(ORDER_BY_CLAUSE)
                                                          .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETAPPLICATION_ENTITLEMENTS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Application_Entitlement",
                    de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Application_Entitlement>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_APPLICATION_ENTITLEMENTS,
                        finderArgs);
                } else {
                    application_EntitlementPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_APPLICATION_ENTITLEMENTS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of application_ entitlements associated with the entitlement.
     *
     * @param pk the primary key of the entitlement
     * @return the number of application_ entitlements associated with the entitlement
     * @throws SystemException if a system exception occurred
     */
    public int getApplication_EntitlementsSize(long pk)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_APPLICATION_ENTITLEMENTS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETAPPLICATION_ENTITLEMENTSSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_APPLICATION_ENTITLEMENTS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the application_ entitlement is associated with the entitlement.
     *
     * @param pk the primary key of the entitlement
     * @param application_EntitlementPK the primary key of the application_ entitlement
     * @return <code>true</code> if the application_ entitlement is associated with the entitlement; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsApplication_Entitlement(long pk,
        long application_EntitlementPK) throws SystemException {
        Object[] finderArgs = new Object[] { pk, application_EntitlementPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_APPLICATION_ENTITLEMENT,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsApplication_Entitlement.contains(
                            pk, application_EntitlementPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_APPLICATION_ENTITLEMENT,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the entitlement has any application_ entitlements associated with it.
     *
     * @param pk the primary key of the entitlement to check for associations with application_ entitlements
     * @return <code>true</code> if the entitlement has any application_ entitlements associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsApplication_Entitlements(long pk)
        throws SystemException {
        if (getApplication_EntitlementsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the entitlement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Entitlement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Entitlement>> listenersList = new ArrayList<ModelListener<Entitlement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Entitlement>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsApplication_Entitlement = new ContainsApplication_Entitlement();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EntitlementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsApplication_Entitlement {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsApplication_Entitlement() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSAPPLICATION_ENTITLEMENT,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long entitlementId,
            long applicationEntitlementID) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(entitlementId),
                        new Long(applicationEntitlementID)
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
}
