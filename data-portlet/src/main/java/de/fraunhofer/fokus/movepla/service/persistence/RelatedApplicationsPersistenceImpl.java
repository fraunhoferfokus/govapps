package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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

import de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;
import de.fraunhofer.fokus.movepla.model.RelatedApplications;
import de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl;
import de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl;
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
 * The persistence implementation for the related applications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see RelatedApplicationsPersistence
 * @see RelatedApplicationsUtil
 * @generated
 */
public class RelatedApplicationsPersistenceImpl extends BasePersistenceImpl<RelatedApplications>
    implements RelatedApplicationsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RelatedApplicationsUtil} to access the related applications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RelatedApplicationsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            RelatedApplicationsModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CA = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByca",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByca",
            new String[] { Long.class.getName(), Long.class.getName() },
            RelatedApplicationsModelImpl.COMPANYID_COLUMN_BITMASK |
            RelatedApplicationsModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CA = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByca",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CA2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByca2",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByca2",
            new String[] { Long.class.getName(), Long.class.getName() },
            RelatedApplicationsModelImpl.COMPANYID_COLUMN_BITMASK |
            RelatedApplicationsModelImpl.APPLICATIONID2_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CA2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByca2",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBya",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBya",
            new String[] { Long.class.getName() },
            RelatedApplicationsModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_A = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBya",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBya2",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBya2",
            new String[] { Long.class.getName() },
            RelatedApplicationsModelImpl.APPLICATIONID2_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_A2 = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBya2",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            RelatedApplicationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_RELATEDAPPLICATIONS = "SELECT relatedApplications FROM RelatedApplications relatedApplications";
    private static final String _SQL_SELECT_RELATEDAPPLICATIONS_WHERE = "SELECT relatedApplications FROM RelatedApplications relatedApplications WHERE ";
    private static final String _SQL_COUNT_RELATEDAPPLICATIONS = "SELECT COUNT(relatedApplications) FROM RelatedApplications relatedApplications";
    private static final String _SQL_COUNT_RELATEDAPPLICATIONS_WHERE = "SELECT COUNT(relatedApplications) FROM RelatedApplications relatedApplications WHERE ";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "relatedApplications.companyId = ?";
    private static final String _FINDER_COLUMN_CA_COMPANYID_2 = "relatedApplications.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CA_APPLICATIONID_2 = "relatedApplications.applicationId = ?";
    private static final String _FINDER_COLUMN_CA2_COMPANYID_2 = "relatedApplications.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CA2_APPLICATIONID2_2 = "relatedApplications.applicationId2 = ?";
    private static final String _FINDER_COLUMN_A_APPLICATIONID_2 = "relatedApplications.applicationId = ?";
    private static final String _FINDER_COLUMN_A2_APPLICATIONID2_2 = "relatedApplications.applicationId2 = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "relatedApplications.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RelatedApplications exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RelatedApplications exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RelatedApplicationsPersistenceImpl.class);
    private static RelatedApplications _nullRelatedApplications = new RelatedApplicationsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<RelatedApplications> toCacheModel() {
                return _nullRelatedApplicationsCacheModel;
            }
        };

    private static CacheModel<RelatedApplications> _nullRelatedApplicationsCacheModel =
        new CacheModel<RelatedApplications>() {
            public RelatedApplications toEntityModel() {
                return _nullRelatedApplications;
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

    /**
     * Caches the related applications in the entity cache if it is enabled.
     *
     * @param relatedApplications the related applications
     */
    public void cacheResult(RelatedApplications relatedApplications) {
        EntityCacheUtil.putResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsImpl.class, relatedApplications.getPrimaryKey(),
            relatedApplications);

        relatedApplications.resetOriginalValues();
    }

    /**
     * Caches the related applicationses in the entity cache if it is enabled.
     *
     * @param relatedApplicationses the related applicationses
     */
    public void cacheResult(List<RelatedApplications> relatedApplicationses) {
        for (RelatedApplications relatedApplications : relatedApplicationses) {
            if (EntityCacheUtil.getResult(
                        RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
                        RelatedApplicationsImpl.class,
                        relatedApplications.getPrimaryKey()) == null) {
                cacheResult(relatedApplications);
            } else {
                relatedApplications.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all related applicationses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RelatedApplicationsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RelatedApplicationsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the related applications.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(RelatedApplications relatedApplications) {
        EntityCacheUtil.removeResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsImpl.class, relatedApplications.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<RelatedApplications> relatedApplicationses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (RelatedApplications relatedApplications : relatedApplicationses) {
            EntityCacheUtil.removeResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
                RelatedApplicationsImpl.class,
                relatedApplications.getPrimaryKey());
        }
    }

    /**
     * Creates a new related applications with the primary key. Does not add the related applications to the database.
     *
     * @param RelatedApplicationsID the primary key for the new related applications
     * @return the new related applications
     */
    public RelatedApplications create(long RelatedApplicationsID) {
        RelatedApplications relatedApplications = new RelatedApplicationsImpl();

        relatedApplications.setNew(true);
        relatedApplications.setPrimaryKey(RelatedApplicationsID);

        return relatedApplications;
    }

    /**
     * Removes the related applications with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param RelatedApplicationsID the primary key of the related applications
     * @return the related applications that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications remove(long RelatedApplicationsID)
        throws NoSuchRelatedApplicationsException, SystemException {
        return remove(Long.valueOf(RelatedApplicationsID));
    }

    /**
     * Removes the related applications with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the related applications
     * @return the related applications that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RelatedApplications remove(Serializable primaryKey)
        throws NoSuchRelatedApplicationsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            RelatedApplications relatedApplications = (RelatedApplications) session.get(RelatedApplicationsImpl.class,
                    primaryKey);

            if (relatedApplications == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRelatedApplicationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(relatedApplications);
        } catch (NoSuchRelatedApplicationsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected RelatedApplications removeImpl(
        RelatedApplications relatedApplications) throws SystemException {
        relatedApplications = toUnwrappedModel(relatedApplications);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, relatedApplications);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(relatedApplications);

        return relatedApplications;
    }

    @Override
    public RelatedApplications updateImpl(
        de.fraunhofer.fokus.movepla.model.RelatedApplications relatedApplications,
        boolean merge) throws SystemException {
        relatedApplications = toUnwrappedModel(relatedApplications);

        boolean isNew = relatedApplications.isNew();

        RelatedApplicationsModelImpl relatedApplicationsModelImpl = (RelatedApplicationsModelImpl) relatedApplications;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, relatedApplications, merge);

            relatedApplications.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RelatedApplicationsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((relatedApplicationsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((relatedApplicationsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalCompanyId()),
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);

                args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getCompanyId()),
                        Long.valueOf(relatedApplicationsModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);
            }

            if ((relatedApplicationsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA2.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalCompanyId()),
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalApplicationId2())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA2,
                    args);

                args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getCompanyId()),
                        Long.valueOf(relatedApplicationsModelImpl.getApplicationId2())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA2,
                    args);
            }

            if ((relatedApplicationsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
                    args);

                args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
                    args);
            }

            if ((relatedApplicationsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A2.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getOriginalApplicationId2())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A2,
                    args);

                args = new Object[] {
                        Long.valueOf(relatedApplicationsModelImpl.getApplicationId2())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A2,
                    args);
            }
        }

        EntityCacheUtil.putResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            RelatedApplicationsImpl.class, relatedApplications.getPrimaryKey(),
            relatedApplications);

        return relatedApplications;
    }

    protected RelatedApplications toUnwrappedModel(
        RelatedApplications relatedApplications) {
        if (relatedApplications instanceof RelatedApplicationsImpl) {
            return relatedApplications;
        }

        RelatedApplicationsImpl relatedApplicationsImpl = new RelatedApplicationsImpl();

        relatedApplicationsImpl.setNew(relatedApplications.isNew());
        relatedApplicationsImpl.setPrimaryKey(relatedApplications.getPrimaryKey());

        relatedApplicationsImpl.setRelatedApplicationsID(relatedApplications.getRelatedApplicationsID());
        relatedApplicationsImpl.setCompanyId(relatedApplications.getCompanyId());
        relatedApplicationsImpl.setUserId(relatedApplications.getUserId());
        relatedApplicationsImpl.setCreateDate(relatedApplications.getCreateDate());
        relatedApplicationsImpl.setModifiedDate(relatedApplications.getModifiedDate());
        relatedApplicationsImpl.setApplicationId(relatedApplications.getApplicationId());
        relatedApplicationsImpl.setApplicationId2(relatedApplications.getApplicationId2());

        return relatedApplicationsImpl;
    }

    /**
     * Returns the related applications with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the related applications
     * @return the related applications
     * @throws com.liferay.portal.NoSuchModelException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RelatedApplications findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the related applications with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException} if it could not be found.
     *
     * @param RelatedApplicationsID the primary key of the related applications
     * @return the related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByPrimaryKey(long RelatedApplicationsID)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByPrimaryKey(RelatedApplicationsID);

        if (relatedApplications == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    RelatedApplicationsID);
            }

            throw new NoSuchRelatedApplicationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                RelatedApplicationsID);
        }

        return relatedApplications;
    }

    /**
     * Returns the related applications with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the related applications
     * @return the related applications, or <code>null</code> if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RelatedApplications fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the related applications with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param RelatedApplicationsID the primary key of the related applications
     * @return the related applications, or <code>null</code> if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByPrimaryKey(long RelatedApplicationsID)
        throws SystemException {
        RelatedApplications relatedApplications = (RelatedApplications) EntityCacheUtil.getResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
                RelatedApplicationsImpl.class, RelatedApplicationsID);

        if (relatedApplications == _nullRelatedApplications) {
            return null;
        }

        if (relatedApplications == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                relatedApplications = (RelatedApplications) session.get(RelatedApplicationsImpl.class,
                        Long.valueOf(RelatedApplicationsID));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (relatedApplications != null) {
                    cacheResult(relatedApplications);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
                        RelatedApplicationsImpl.class, RelatedApplicationsID,
                        _nullRelatedApplications);
                }

                closeSession(session);
            }
        }

        return relatedApplications;
    }

    /**
     * Returns all the related applicationses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByc(long companyId)
        throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the related applicationses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByc(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RelatedApplications relatedApplications : list) {
                if ((companyId != relatedApplications.getCompanyId())) {
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

            query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

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

                list = (List<RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first related applications in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByc_First(companyId,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the first related applications in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<RelatedApplications> list = findByc(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByc_Last(companyId,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<RelatedApplications> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63;.
     *
     * @param RelatedApplicationsID the primary key of the current related applications
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications[] findByc_PrevAndNext(
        long RelatedApplicationsID, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = findByPrimaryKey(RelatedApplicationsID);

        Session session = null;

        try {
            session = openSession();

            RelatedApplications[] array = new RelatedApplicationsImpl[3];

            array[0] = getByc_PrevAndNext(session, relatedApplications,
                    companyId, orderByComparator, true);

            array[1] = relatedApplications;

            array[2] = getByc_PrevAndNext(session, relatedApplications,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RelatedApplications getByc_PrevAndNext(Session session,
        RelatedApplications relatedApplications, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(relatedApplications);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RelatedApplications> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the related applicationses where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca(long companyId, long applicationId)
        throws SystemException {
        return findByca(companyId, applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the related applicationses where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca(long companyId,
        long applicationId, int start, int end) throws SystemException {
        return findByca(companyId, applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca(long companyId,
        long applicationId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA;
            finderArgs = new Object[] { companyId, applicationId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CA;
            finderArgs = new Object[] {
                    companyId, applicationId,
                    
                    start, end, orderByComparator
                };
        }

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RelatedApplications relatedApplications : list) {
                if ((companyId != relatedApplications.getCompanyId()) ||
                        (applicationId != relatedApplications.getApplicationId())) {
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

            query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_CA_COMPANYID_2);

            query.append(_FINDER_COLUMN_CA_APPLICATIONID_2);

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

                qPos.add(applicationId);

                list = (List<RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByca_First(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByca_First(companyId,
                applicationId, orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the first related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByca_First(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        List<RelatedApplications> list = findByca(companyId, applicationId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByca_Last(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByca_Last(companyId,
                applicationId, orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByca_Last(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByca(companyId, applicationId);

        List<RelatedApplications> list = findByca(companyId, applicationId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param RelatedApplicationsID the primary key of the current related applications
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications[] findByca_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = findByPrimaryKey(RelatedApplicationsID);

        Session session = null;

        try {
            session = openSession();

            RelatedApplications[] array = new RelatedApplicationsImpl[3];

            array[0] = getByca_PrevAndNext(session, relatedApplications,
                    companyId, applicationId, orderByComparator, true);

            array[1] = relatedApplications;

            array[2] = getByca_PrevAndNext(session, relatedApplications,
                    companyId, applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RelatedApplications getByca_PrevAndNext(Session session,
        RelatedApplications relatedApplications, long companyId,
        long applicationId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

        query.append(_FINDER_COLUMN_CA_COMPANYID_2);

        query.append(_FINDER_COLUMN_CA_APPLICATIONID_2);

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

        qPos.add(applicationId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(relatedApplications);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RelatedApplications> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @return the matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca2(long companyId,
        long applicationId2) throws SystemException {
        return findByca2(companyId, applicationId2, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca2(long companyId,
        long applicationId2, int start, int end) throws SystemException {
        return findByca2(companyId, applicationId2, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findByca2(long companyId,
        long applicationId2, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA2;
            finderArgs = new Object[] { companyId, applicationId2 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CA2;
            finderArgs = new Object[] {
                    companyId, applicationId2,
                    
                    start, end, orderByComparator
                };
        }

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RelatedApplications relatedApplications : list) {
                if ((companyId != relatedApplications.getCompanyId()) ||
                        (applicationId2 != relatedApplications.getApplicationId2())) {
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

            query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_CA2_COMPANYID_2);

            query.append(_FINDER_COLUMN_CA2_APPLICATIONID2_2);

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

                qPos.add(applicationId2);

                list = (List<RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByca2_First(long companyId,
        long applicationId2, OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByca2_First(companyId,
                applicationId2, orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId2=");
        msg.append(applicationId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the first related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByca2_First(long companyId,
        long applicationId2, OrderByComparator orderByComparator)
        throws SystemException {
        List<RelatedApplications> list = findByca2(companyId, applicationId2,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findByca2_Last(long companyId,
        long applicationId2, OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchByca2_Last(companyId,
                applicationId2, orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId2=");
        msg.append(applicationId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the last related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchByca2_Last(long companyId,
        long applicationId2, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByca2(companyId, applicationId2);

        List<RelatedApplications> list = findByca2(companyId, applicationId2,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param RelatedApplicationsID the primary key of the current related applications
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications[] findByca2_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId2,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = findByPrimaryKey(RelatedApplicationsID);

        Session session = null;

        try {
            session = openSession();

            RelatedApplications[] array = new RelatedApplicationsImpl[3];

            array[0] = getByca2_PrevAndNext(session, relatedApplications,
                    companyId, applicationId2, orderByComparator, true);

            array[1] = relatedApplications;

            array[2] = getByca2_PrevAndNext(session, relatedApplications,
                    companyId, applicationId2, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RelatedApplications getByca2_PrevAndNext(Session session,
        RelatedApplications relatedApplications, long companyId,
        long applicationId2, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

        query.append(_FINDER_COLUMN_CA2_COMPANYID_2);

        query.append(_FINDER_COLUMN_CA2_APPLICATIONID2_2);

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

        qPos.add(applicationId2);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(relatedApplications);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RelatedApplications> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the related applicationses where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya(long applicationId)
        throws SystemException {
        return findBya(applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the related applicationses where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya(long applicationId, int start,
        int end) throws SystemException {
        return findBya(applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya(long applicationId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A;
            finderArgs = new Object[] { applicationId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A;
            finderArgs = new Object[] {
                    applicationId,
                    
                    start, end, orderByComparator
                };
        }

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RelatedApplications relatedApplications : list) {
                if ((applicationId != relatedApplications.getApplicationId())) {
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

            query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_A_APPLICATIONID_2);

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

                qPos.add(applicationId);

                list = (List<RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first related applications in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findBya_First(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchBya_First(applicationId,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the first related applications in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchBya_First(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<RelatedApplications> list = findBya(applicationId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last related applications in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findBya_Last(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchBya_Last(applicationId,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the last related applications in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchBya_Last(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBya(applicationId);

        List<RelatedApplications> list = findBya(applicationId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the related applicationses before and after the current related applications in the ordered set where applicationId = &#63;.
     *
     * @param RelatedApplicationsID the primary key of the current related applications
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications[] findBya_PrevAndNext(
        long RelatedApplicationsID, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = findByPrimaryKey(RelatedApplicationsID);

        Session session = null;

        try {
            session = openSession();

            RelatedApplications[] array = new RelatedApplicationsImpl[3];

            array[0] = getBya_PrevAndNext(session, relatedApplications,
                    applicationId, orderByComparator, true);

            array[1] = relatedApplications;

            array[2] = getBya_PrevAndNext(session, relatedApplications,
                    applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RelatedApplications getBya_PrevAndNext(Session session,
        RelatedApplications relatedApplications, long applicationId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

        query.append(_FINDER_COLUMN_A_APPLICATIONID_2);

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

        qPos.add(applicationId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(relatedApplications);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RelatedApplications> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the related applicationses where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @return the matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya2(long applicationId2)
        throws SystemException {
        return findBya2(applicationId2, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the related applicationses where applicationId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId2 the application id2
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya2(long applicationId2, int start,
        int end) throws SystemException {
        return findBya2(applicationId2, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses where applicationId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId2 the application id2
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findBya2(long applicationId2, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A2;
            finderArgs = new Object[] { applicationId2 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A2;
            finderArgs = new Object[] {
                    applicationId2,
                    
                    start, end, orderByComparator
                };
        }

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (RelatedApplications relatedApplications : list) {
                if ((applicationId2 != relatedApplications.getApplicationId2())) {
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

            query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_A2_APPLICATIONID2_2);

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

                qPos.add(applicationId2);

                list = (List<RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first related applications in the ordered set where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findBya2_First(long applicationId2,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchBya2_First(applicationId2,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId2=");
        msg.append(applicationId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the first related applications in the ordered set where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchBya2_First(long applicationId2,
        OrderByComparator orderByComparator) throws SystemException {
        List<RelatedApplications> list = findBya2(applicationId2, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last related applications in the ordered set where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications findBya2_Last(long applicationId2,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = fetchBya2_Last(applicationId2,
                orderByComparator);

        if (relatedApplications != null) {
            return relatedApplications;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId2=");
        msg.append(applicationId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRelatedApplicationsException(msg.toString());
    }

    /**
     * Returns the last related applications in the ordered set where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications fetchBya2_Last(long applicationId2,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBya2(applicationId2);

        List<RelatedApplications> list = findBya2(applicationId2, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the related applicationses before and after the current related applications in the ordered set where applicationId2 = &#63;.
     *
     * @param RelatedApplicationsID the primary key of the current related applications
     * @param applicationId2 the application id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next related applications
     * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public RelatedApplications[] findBya2_PrevAndNext(
        long RelatedApplicationsID, long applicationId2,
        OrderByComparator orderByComparator)
        throws NoSuchRelatedApplicationsException, SystemException {
        RelatedApplications relatedApplications = findByPrimaryKey(RelatedApplicationsID);

        Session session = null;

        try {
            session = openSession();

            RelatedApplications[] array = new RelatedApplicationsImpl[3];

            array[0] = getBya2_PrevAndNext(session, relatedApplications,
                    applicationId2, orderByComparator, true);

            array[1] = relatedApplications;

            array[2] = getBya2_PrevAndNext(session, relatedApplications,
                    applicationId2, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected RelatedApplications getBya2_PrevAndNext(Session session,
        RelatedApplications relatedApplications, long applicationId2,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RELATEDAPPLICATIONS_WHERE);

        query.append(_FINDER_COLUMN_A2_APPLICATIONID2_2);

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

        qPos.add(applicationId2);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(relatedApplications);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<RelatedApplications> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the related applicationses.
     *
     * @return the related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the related applicationses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @return the range of related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of related applicationses
     * @param end the upper bound of the range of related applicationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of related applicationses
     * @throws SystemException if a system exception occurred
     */
    public List<RelatedApplications> findAll(int start, int end,
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

        List<RelatedApplications> list = (List<RelatedApplications>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_RELATEDAPPLICATIONS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_RELATEDAPPLICATIONS;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<RelatedApplications>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<RelatedApplications>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the related applicationses where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (RelatedApplications relatedApplications : findByc(companyId)) {
            remove(relatedApplications);
        }
    }

    /**
     * Removes all the related applicationses where companyId = &#63; and applicationId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByca(long companyId, long applicationId)
        throws SystemException {
        for (RelatedApplications relatedApplications : findByca(companyId,
                applicationId)) {
            remove(relatedApplications);
        }
    }

    /**
     * Removes all the related applicationses where companyId = &#63; and applicationId2 = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @throws SystemException if a system exception occurred
     */
    public void removeByca2(long companyId, long applicationId2)
        throws SystemException {
        for (RelatedApplications relatedApplications : findByca2(companyId,
                applicationId2)) {
            remove(relatedApplications);
        }
    }

    /**
     * Removes all the related applicationses where applicationId = &#63; from the database.
     *
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeBya(long applicationId) throws SystemException {
        for (RelatedApplications relatedApplications : findBya(applicationId)) {
            remove(relatedApplications);
        }
    }

    /**
     * Removes all the related applicationses where applicationId2 = &#63; from the database.
     *
     * @param applicationId2 the application id2
     * @throws SystemException if a system exception occurred
     */
    public void removeBya2(long applicationId2) throws SystemException {
        for (RelatedApplications relatedApplications : findBya2(applicationId2)) {
            remove(relatedApplications);
        }
    }

    /**
     * Removes all the related applicationses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (RelatedApplications relatedApplications : findAll()) {
            remove(relatedApplications);
        }
    }

    /**
     * Returns the number of related applicationses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RELATEDAPPLICATIONS_WHERE);

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
     * Returns the number of related applicationses where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the number of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countByca(long companyId, long applicationId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CA,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_CA_COMPANYID_2);

            query.append(_FINDER_COLUMN_CA_APPLICATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(applicationId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CA, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of related applicationses where companyId = &#63; and applicationId2 = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId2 the application id2
     * @return the number of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countByca2(long companyId, long applicationId2)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId2 };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CA2,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_CA2_COMPANYID_2);

            query.append(_FINDER_COLUMN_CA2_APPLICATIONID2_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(applicationId2);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CA2, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of related applicationses where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the number of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countBya(long applicationId) throws SystemException {
        Object[] finderArgs = new Object[] { applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_A_APPLICATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(applicationId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of related applicationses where applicationId2 = &#63;.
     *
     * @param applicationId2 the application id2
     * @return the number of matching related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countBya2(long applicationId2) throws SystemException {
        Object[] finderArgs = new Object[] { applicationId2 };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A2,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RELATEDAPPLICATIONS_WHERE);

            query.append(_FINDER_COLUMN_A2_APPLICATIONID2_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(applicationId2);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A2, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of related applicationses.
     *
     * @return the number of related applicationses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_RELATEDAPPLICATIONS);

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
     * Initializes the related applications persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.RelatedApplications")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<RelatedApplications>> listenersList = new ArrayList<ModelListener<RelatedApplications>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<RelatedApplications>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RelatedApplicationsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
