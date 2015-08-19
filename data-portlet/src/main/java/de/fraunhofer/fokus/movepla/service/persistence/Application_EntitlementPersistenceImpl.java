package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl;
import de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementModelImpl;
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
 * The persistence implementation for the application_ entitlement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see Application_EntitlementPersistence
 * @see Application_EntitlementUtil
 * @generated
 */
public class Application_EntitlementPersistenceImpl extends BasePersistenceImpl<Application_Entitlement>
    implements Application_EntitlementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link Application_EntitlementUtil} to access the application_ entitlement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = Application_EntitlementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            Application_EntitlementModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CA = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByca",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByca",
            new String[] { Long.class.getName(), Long.class.getName() },
            Application_EntitlementModelImpl.COMPANYID_COLUMN_BITMASK |
            Application_EntitlementModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CA = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByca",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByce",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByce",
            new String[] { Long.class.getName(), Long.class.getName() },
            Application_EntitlementModelImpl.COMPANYID_COLUMN_BITMASK |
            Application_EntitlementModelImpl.ENTITLEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByce",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycae",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycae",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            Application_EntitlementModelImpl.COMPANYID_COLUMN_BITMASK |
            Application_EntitlementModelImpl.APPLICATIONID_COLUMN_BITMASK |
            Application_EntitlementModelImpl.ENTITLEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CAE = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycae",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_APPLICATION_ENTITLEMENT = "SELECT application_Entitlement FROM Application_Entitlement application_Entitlement";
    private static final String _SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE = "SELECT application_Entitlement FROM Application_Entitlement application_Entitlement WHERE ";
    private static final String _SQL_COUNT_APPLICATION_ENTITLEMENT = "SELECT COUNT(application_Entitlement) FROM Application_Entitlement application_Entitlement";
    private static final String _SQL_COUNT_APPLICATION_ENTITLEMENT_WHERE = "SELECT COUNT(application_Entitlement) FROM Application_Entitlement application_Entitlement WHERE ";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "application_Entitlement.companyId = ?";
    private static final String _FINDER_COLUMN_CA_COMPANYID_2 = "application_Entitlement.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CA_APPLICATIONID_2 = "application_Entitlement.applicationId = ?";
    private static final String _FINDER_COLUMN_CE_COMPANYID_2 = "application_Entitlement.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CE_ENTITLEMENTID_2 = "application_Entitlement.entitlementId = ?";
    private static final String _FINDER_COLUMN_CAE_COMPANYID_2 = "application_Entitlement.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CAE_APPLICATIONID_2 = "application_Entitlement.applicationId = ? AND ";
    private static final String _FINDER_COLUMN_CAE_ENTITLEMENTID_2 = "application_Entitlement.entitlementId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "application_Entitlement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Application_Entitlement exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Application_Entitlement exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(Application_EntitlementPersistenceImpl.class);
    private static Application_Entitlement _nullApplication_Entitlement = new Application_EntitlementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Application_Entitlement> toCacheModel() {
                return _nullApplication_EntitlementCacheModel;
            }
        };

    private static CacheModel<Application_Entitlement> _nullApplication_EntitlementCacheModel =
        new CacheModel<Application_Entitlement>() {
            public Application_Entitlement toEntityModel() {
                return _nullApplication_Entitlement;
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
     * Caches the application_ entitlement in the entity cache if it is enabled.
     *
     * @param application_Entitlement the application_ entitlement
     */
    public void cacheResult(Application_Entitlement application_Entitlement) {
        EntityCacheUtil.putResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            application_Entitlement.getPrimaryKey(), application_Entitlement);

        application_Entitlement.resetOriginalValues();
    }

    /**
     * Caches the application_ entitlements in the entity cache if it is enabled.
     *
     * @param application_Entitlements the application_ entitlements
     */
    public void cacheResult(
        List<Application_Entitlement> application_Entitlements) {
        for (Application_Entitlement application_Entitlement : application_Entitlements) {
            if (EntityCacheUtil.getResult(
                        Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                        Application_EntitlementImpl.class,
                        application_Entitlement.getPrimaryKey()) == null) {
                cacheResult(application_Entitlement);
            } else {
                application_Entitlement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all application_ entitlements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(Application_EntitlementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(Application_EntitlementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the application_ entitlement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Application_Entitlement application_Entitlement) {
        EntityCacheUtil.removeResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            application_Entitlement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<Application_Entitlement> application_Entitlements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Application_Entitlement application_Entitlement : application_Entitlements) {
            EntityCacheUtil.removeResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                Application_EntitlementImpl.class,
                application_Entitlement.getPrimaryKey());
        }
    }

    /**
     * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
     *
     * @param applicationEntitlementID the primary key for the new application_ entitlement
     * @return the new application_ entitlement
     */
    public Application_Entitlement create(long applicationEntitlementID) {
        Application_Entitlement application_Entitlement = new Application_EntitlementImpl();

        application_Entitlement.setNew(true);
        application_Entitlement.setPrimaryKey(applicationEntitlementID);

        return application_Entitlement;
    }

    /**
     * Removes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicationEntitlementID the primary key of the application_ entitlement
     * @return the application_ entitlement that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement remove(long applicationEntitlementID)
        throws NoSuchApplication_EntitlementException, SystemException {
        return remove(Long.valueOf(applicationEntitlementID));
    }

    /**
     * Removes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the application_ entitlement
     * @return the application_ entitlement that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application_Entitlement remove(Serializable primaryKey)
        throws NoSuchApplication_EntitlementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Application_Entitlement application_Entitlement = (Application_Entitlement) session.get(Application_EntitlementImpl.class,
                    primaryKey);

            if (application_Entitlement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApplication_EntitlementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(application_Entitlement);
        } catch (NoSuchApplication_EntitlementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Application_Entitlement removeImpl(
        Application_Entitlement application_Entitlement)
        throws SystemException {
        application_Entitlement = toUnwrappedModel(application_Entitlement);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, application_Entitlement);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(application_Entitlement);

        return application_Entitlement;
    }

    @Override
    public Application_Entitlement updateImpl(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement,
        boolean merge) throws SystemException {
        application_Entitlement = toUnwrappedModel(application_Entitlement);

        boolean isNew = application_Entitlement.isNew();

        Application_EntitlementModelImpl application_EntitlementModelImpl = (Application_EntitlementModelImpl) application_Entitlement;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, application_Entitlement, merge);

            application_Entitlement.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !Application_EntitlementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((application_EntitlementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((application_EntitlementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getOriginalCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);

                args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);
            }

            if ((application_EntitlementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getOriginalCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getOriginalEntitlementId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CE,
                    args);

                args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getEntitlementId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CE,
                    args);
            }

            if ((application_EntitlementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getOriginalCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getOriginalApplicationId()),
                        Long.valueOf(application_EntitlementModelImpl.getOriginalEntitlementId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAE,
                    args);

                args = new Object[] {
                        Long.valueOf(application_EntitlementModelImpl.getCompanyId()),
                        Long.valueOf(application_EntitlementModelImpl.getApplicationId()),
                        Long.valueOf(application_EntitlementModelImpl.getEntitlementId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAE,
                    args);
            }
        }

        EntityCacheUtil.putResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
            Application_EntitlementImpl.class,
            application_Entitlement.getPrimaryKey(), application_Entitlement);

        return application_Entitlement;
    }

    protected Application_Entitlement toUnwrappedModel(
        Application_Entitlement application_Entitlement) {
        if (application_Entitlement instanceof Application_EntitlementImpl) {
            return application_Entitlement;
        }

        Application_EntitlementImpl application_EntitlementImpl = new Application_EntitlementImpl();

        application_EntitlementImpl.setNew(application_Entitlement.isNew());
        application_EntitlementImpl.setPrimaryKey(application_Entitlement.getPrimaryKey());

        application_EntitlementImpl.setApplicationEntitlementID(application_Entitlement.getApplicationEntitlementID());
        application_EntitlementImpl.setCompanyId(application_Entitlement.getCompanyId());
        application_EntitlementImpl.setUserId(application_Entitlement.getUserId());
        application_EntitlementImpl.setCreateDate(application_Entitlement.getCreateDate());
        application_EntitlementImpl.setModifiedDate(application_Entitlement.getModifiedDate());
        application_EntitlementImpl.setName(application_Entitlement.getName());
        application_EntitlementImpl.setMotivation(application_Entitlement.getMotivation());
        application_EntitlementImpl.setApplicationId(application_Entitlement.getApplicationId());
        application_EntitlementImpl.setEntitlementId(application_Entitlement.getEntitlementId());

        return application_EntitlementImpl;
    }

    /**
     * Returns the application_ entitlement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the application_ entitlement
     * @return the application_ entitlement
     * @throws com.liferay.portal.NoSuchModelException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application_Entitlement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the application_ entitlement with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException} if it could not be found.
     *
     * @param applicationEntitlementID the primary key of the application_ entitlement
     * @return the application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByPrimaryKey(
        long applicationEntitlementID)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByPrimaryKey(applicationEntitlementID);

        if (application_Entitlement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    applicationEntitlementID);
            }

            throw new NoSuchApplication_EntitlementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                applicationEntitlementID);
        }

        return application_Entitlement;
    }

    /**
     * Returns the application_ entitlement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the application_ entitlement
     * @return the application_ entitlement, or <code>null</code> if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application_Entitlement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the application_ entitlement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param applicationEntitlementID the primary key of the application_ entitlement
     * @return the application_ entitlement, or <code>null</code> if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByPrimaryKey(
        long applicationEntitlementID) throws SystemException {
        Application_Entitlement application_Entitlement = (Application_Entitlement) EntityCacheUtil.getResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                Application_EntitlementImpl.class, applicationEntitlementID);

        if (application_Entitlement == _nullApplication_Entitlement) {
            return null;
        }

        if (application_Entitlement == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                application_Entitlement = (Application_Entitlement) session.get(Application_EntitlementImpl.class,
                        Long.valueOf(applicationEntitlementID));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (application_Entitlement != null) {
                    cacheResult(application_Entitlement);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(Application_EntitlementModelImpl.ENTITY_CACHE_ENABLED,
                        Application_EntitlementImpl.class,
                        applicationEntitlementID, _nullApplication_Entitlement);
                }

                closeSession(session);
            }
        }

        return application_Entitlement;
    }

    /**
     * Returns all the application_ entitlements where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByc(long companyId)
        throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application_ entitlements where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByc(long companyId, int start,
        int end) throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByc(long companyId, int start,
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

        List<Application_Entitlement> list = (List<Application_Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application_Entitlement application_Entitlement : list) {
                if ((companyId != application_Entitlement.getCompanyId())) {
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

            query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

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

                list = (List<Application_Entitlement>) QueryUtil.list(q,
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
     * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByc_First(companyId,
                orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application_Entitlement> list = findByc(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByc_Last(companyId,
                orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Application_Entitlement> list = findByc(companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63;.
     *
     * @param applicationEntitlementID the primary key of the current application_ entitlement
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement[] findByc_PrevAndNext(
        long applicationEntitlementID, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = findByPrimaryKey(applicationEntitlementID);

        Session session = null;

        try {
            session = openSession();

            Application_Entitlement[] array = new Application_EntitlementImpl[3];

            array[0] = getByc_PrevAndNext(session, application_Entitlement,
                    companyId, orderByComparator, true);

            array[1] = application_Entitlement;

            array[2] = getByc_PrevAndNext(session, application_Entitlement,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application_Entitlement getByc_PrevAndNext(Session session,
        Application_Entitlement application_Entitlement, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(application_Entitlement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application_Entitlement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByca(long companyId,
        long applicationId) throws SystemException {
        return findByca(companyId, applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByca(long companyId,
        long applicationId, int start, int end) throws SystemException {
        return findByca(companyId, applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByca(long companyId,
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

        List<Application_Entitlement> list = (List<Application_Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application_Entitlement application_Entitlement : list) {
                if ((companyId != application_Entitlement.getCompanyId()) ||
                        (applicationId != application_Entitlement.getApplicationId())) {
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

            query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

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

                list = (List<Application_Entitlement>) QueryUtil.list(q,
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
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByca_First(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByca_First(companyId,
                applicationId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByca_First(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Application_Entitlement> list = findByca(companyId, applicationId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByca_Last(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByca_Last(companyId,
                applicationId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByca_Last(long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByca(companyId, applicationId);

        List<Application_Entitlement> list = findByca(companyId, applicationId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param applicationEntitlementID the primary key of the current application_ entitlement
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement[] findByca_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = findByPrimaryKey(applicationEntitlementID);

        Session session = null;

        try {
            session = openSession();

            Application_Entitlement[] array = new Application_EntitlementImpl[3];

            array[0] = getByca_PrevAndNext(session, application_Entitlement,
                    companyId, applicationId, orderByComparator, true);

            array[1] = application_Entitlement;

            array[2] = getByca_PrevAndNext(session, application_Entitlement,
                    companyId, applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application_Entitlement getByca_PrevAndNext(Session session,
        Application_Entitlement application_Entitlement, long companyId,
        long applicationId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(application_Entitlement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application_Entitlement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @return the matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByce(long companyId,
        long entitlementId) throws SystemException {
        return findByce(companyId, entitlementId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByce(long companyId,
        long entitlementId, int start, int end) throws SystemException {
        return findByce(companyId, entitlementId, start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findByce(long companyId,
        long entitlementId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CE;
            finderArgs = new Object[] { companyId, entitlementId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CE;
            finderArgs = new Object[] {
                    companyId, entitlementId,
                    
                    start, end, orderByComparator
                };
        }

        List<Application_Entitlement> list = (List<Application_Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application_Entitlement application_Entitlement : list) {
                if ((companyId != application_Entitlement.getCompanyId()) ||
                        (entitlementId != application_Entitlement.getEntitlementId())) {
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

            query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

            query.append(_FINDER_COLUMN_CE_COMPANYID_2);

            query.append(_FINDER_COLUMN_CE_ENTITLEMENTID_2);

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

                qPos.add(entitlementId);

                list = (List<Application_Entitlement>) QueryUtil.list(q,
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
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByce_First(long companyId,
        long entitlementId, OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByce_First(companyId,
                entitlementId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", entitlementId=");
        msg.append(entitlementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByce_First(long companyId,
        long entitlementId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Application_Entitlement> list = findByce(companyId, entitlementId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findByce_Last(long companyId,
        long entitlementId, OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchByce_Last(companyId,
                entitlementId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", entitlementId=");
        msg.append(entitlementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchByce_Last(long companyId,
        long entitlementId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByce(companyId, entitlementId);

        List<Application_Entitlement> list = findByce(companyId, entitlementId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
     *
     * @param applicationEntitlementID the primary key of the current application_ entitlement
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement[] findByce_PrevAndNext(
        long applicationEntitlementID, long companyId, long entitlementId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = findByPrimaryKey(applicationEntitlementID);

        Session session = null;

        try {
            session = openSession();

            Application_Entitlement[] array = new Application_EntitlementImpl[3];

            array[0] = getByce_PrevAndNext(session, application_Entitlement,
                    companyId, entitlementId, orderByComparator, true);

            array[1] = application_Entitlement;

            array[2] = getByce_PrevAndNext(session, application_Entitlement,
                    companyId, entitlementId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application_Entitlement getByce_PrevAndNext(Session session,
        Application_Entitlement application_Entitlement, long companyId,
        long entitlementId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

        query.append(_FINDER_COLUMN_CE_COMPANYID_2);

        query.append(_FINDER_COLUMN_CE_ENTITLEMENTID_2);

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

        qPos.add(entitlementId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application_Entitlement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application_Entitlement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @return the matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findBycae(long companyId,
        long applicationId, long entitlementId) throws SystemException {
        return findBycae(companyId, applicationId, entitlementId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findBycae(long companyId,
        long applicationId, long entitlementId, int start, int end)
        throws SystemException {
        return findBycae(companyId, applicationId, entitlementId, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findBycae(long companyId,
        long applicationId, long entitlementId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAE;
            finderArgs = new Object[] { companyId, applicationId, entitlementId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAE;
            finderArgs = new Object[] {
                    companyId, applicationId, entitlementId,
                    
                    start, end, orderByComparator
                };
        }

        List<Application_Entitlement> list = (List<Application_Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application_Entitlement application_Entitlement : list) {
                if ((companyId != application_Entitlement.getCompanyId()) ||
                        (applicationId != application_Entitlement.getApplicationId()) ||
                        (entitlementId != application_Entitlement.getEntitlementId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

            query.append(_FINDER_COLUMN_CAE_COMPANYID_2);

            query.append(_FINDER_COLUMN_CAE_APPLICATIONID_2);

            query.append(_FINDER_COLUMN_CAE_ENTITLEMENTID_2);

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

                qPos.add(entitlementId);

                list = (List<Application_Entitlement>) QueryUtil.list(q,
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
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findBycae_First(long companyId,
        long applicationId, long entitlementId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchBycae_First(companyId,
                applicationId, entitlementId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(", entitlementId=");
        msg.append(entitlementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchBycae_First(long companyId,
        long applicationId, long entitlementId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application_Entitlement> list = findBycae(companyId,
                applicationId, entitlementId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement findBycae_Last(long companyId,
        long applicationId, long entitlementId,
        OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = fetchBycae_Last(companyId,
                applicationId, entitlementId, orderByComparator);

        if (application_Entitlement != null) {
            return application_Entitlement;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(", entitlementId=");
        msg.append(entitlementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplication_EntitlementException(msg.toString());
    }

    /**
     * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement fetchBycae_Last(long companyId,
        long applicationId, long entitlementId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycae(companyId, applicationId, entitlementId);

        List<Application_Entitlement> list = findBycae(companyId,
                applicationId, entitlementId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param applicationEntitlementID the primary key of the current application_ entitlement
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application_ entitlement
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement[] findBycae_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        long entitlementId, OrderByComparator orderByComparator)
        throws NoSuchApplication_EntitlementException, SystemException {
        Application_Entitlement application_Entitlement = findByPrimaryKey(applicationEntitlementID);

        Session session = null;

        try {
            session = openSession();

            Application_Entitlement[] array = new Application_EntitlementImpl[3];

            array[0] = getBycae_PrevAndNext(session, application_Entitlement,
                    companyId, applicationId, entitlementId, orderByComparator,
                    true);

            array[1] = application_Entitlement;

            array[2] = getBycae_PrevAndNext(session, application_Entitlement,
                    companyId, applicationId, entitlementId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application_Entitlement getBycae_PrevAndNext(Session session,
        Application_Entitlement application_Entitlement, long companyId,
        long applicationId, long entitlementId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT_WHERE);

        query.append(_FINDER_COLUMN_CAE_COMPANYID_2);

        query.append(_FINDER_COLUMN_CAE_APPLICATIONID_2);

        query.append(_FINDER_COLUMN_CAE_ENTITLEMENTID_2);

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

        qPos.add(entitlementId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application_Entitlement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application_Entitlement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the application_ entitlements.
     *
     * @return the application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application_ entitlements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> findAll(int start, int end,
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

        List<Application_Entitlement> list = (List<Application_Entitlement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPLICATION_ENTITLEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPLICATION_ENTITLEMENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Application_Entitlement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Application_Entitlement>) QueryUtil.list(q,
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
     * Removes all the application_ entitlements where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Application_Entitlement application_Entitlement : findByc(
                companyId)) {
            remove(application_Entitlement);
        }
    }

    /**
     * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByca(long companyId, long applicationId)
        throws SystemException {
        for (Application_Entitlement application_Entitlement : findByca(
                companyId, applicationId)) {
            remove(application_Entitlement);
        }
    }

    /**
     * Removes all the application_ entitlements where companyId = &#63; and entitlementId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByce(long companyId, long entitlementId)
        throws SystemException {
        for (Application_Entitlement application_Entitlement : findByce(
                companyId, entitlementId)) {
            remove(application_Entitlement);
        }
    }

    /**
     * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @throws SystemException if a system exception occurred
     */
    public void removeBycae(long companyId, long applicationId,
        long entitlementId) throws SystemException {
        for (Application_Entitlement application_Entitlement : findBycae(
                companyId, applicationId, entitlementId)) {
            remove(application_Entitlement);
        }
    }

    /**
     * Removes all the application_ entitlements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Application_Entitlement application_Entitlement : findAll()) {
            remove(application_Entitlement);
        }
    }

    /**
     * Returns the number of application_ entitlements where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_ENTITLEMENT_WHERE);

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
     * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the number of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countByca(long companyId, long applicationId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CA,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_APPLICATION_ENTITLEMENT_WHERE);

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
     * Returns the number of application_ entitlements where companyId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param entitlementId the entitlement ID
     * @return the number of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countByce(long companyId, long entitlementId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, entitlementId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_APPLICATION_ENTITLEMENT_WHERE);

            query.append(_FINDER_COLUMN_CE_COMPANYID_2);

            query.append(_FINDER_COLUMN_CE_ENTITLEMENTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(entitlementId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CE, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param entitlementId the entitlement ID
     * @return the number of matching application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countBycae(long companyId, long applicationId, long entitlementId)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                companyId, applicationId, entitlementId
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_APPLICATION_ENTITLEMENT_WHERE);

            query.append(_FINDER_COLUMN_CAE_COMPANYID_2);

            query.append(_FINDER_COLUMN_CAE_APPLICATIONID_2);

            query.append(_FINDER_COLUMN_CAE_ENTITLEMENTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(applicationId);

                qPos.add(entitlementId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAE, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of application_ entitlements.
     *
     * @return the number of application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_APPLICATION_ENTITLEMENT);

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
     * Initializes the application_ entitlement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Application_Entitlement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Application_Entitlement>> listenersList = new ArrayList<ModelListener<Application_Entitlement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Application_Entitlement>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(Application_EntitlementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
