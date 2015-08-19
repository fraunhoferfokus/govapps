package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: MultiMediaPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchMultiMediaException;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl;
import de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl;
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
 * The persistence implementation for the multi media service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see MultiMediaPersistence
 * @see MultiMediaUtil
 * @generated
 */
public class MultiMediaPersistenceImpl extends BasePersistenceImpl<MultiMedia>
    implements MultiMediaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MultiMediaUtil} to access the multi media persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MultiMediaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            MultiMediaModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CA = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByca",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByca",
            new String[] { Long.class.getName(), Long.class.getName() },
            MultiMediaModelImpl.COMPANYID_COLUMN_BITMASK |
            MultiMediaModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CA = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByca",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAI = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycai",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAI = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycai",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            MultiMediaModelImpl.COMPANYID_COLUMN_BITMASK |
            MultiMediaModelImpl.APPLICATIONID_COLUMN_BITMASK |
            MultiMediaModelImpl.IMAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CAI = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycai",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APP = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapp",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapp",
            new String[] { Long.class.getName() },
            MultiMediaModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APP = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapp",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGE = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByimage",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGE = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByimage",
            new String[] { Long.class.getName() },
            MultiMediaModelImpl.IMAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_IMAGE = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByimage",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, MultiMediaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_MULTIMEDIA = "SELECT multiMedia FROM MultiMedia multiMedia";
    private static final String _SQL_SELECT_MULTIMEDIA_WHERE = "SELECT multiMedia FROM MultiMedia multiMedia WHERE ";
    private static final String _SQL_COUNT_MULTIMEDIA = "SELECT COUNT(multiMedia) FROM MultiMedia multiMedia";
    private static final String _SQL_COUNT_MULTIMEDIA_WHERE = "SELECT COUNT(multiMedia) FROM MultiMedia multiMedia WHERE ";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "multiMedia.companyId = ?";
    private static final String _FINDER_COLUMN_CA_COMPANYID_2 = "multiMedia.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CA_APPLICATIONID_2 = "multiMedia.applicationId = ?";
    private static final String _FINDER_COLUMN_CAI_COMPANYID_2 = "multiMedia.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CAI_APPLICATIONID_2 = "multiMedia.applicationId = ? AND ";
    private static final String _FINDER_COLUMN_CAI_IMAGEID_2 = "multiMedia.imageId = ?";
    private static final String _FINDER_COLUMN_APP_APPLICATIONID_2 = "multiMedia.applicationId = ?";
    private static final String _FINDER_COLUMN_IMAGE_IMAGEID_2 = "multiMedia.imageId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "multiMedia.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MultiMedia exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MultiMedia exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MultiMediaPersistenceImpl.class);
    private static MultiMedia _nullMultiMedia = new MultiMediaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<MultiMedia> toCacheModel() {
                return _nullMultiMediaCacheModel;
            }
        };

    private static CacheModel<MultiMedia> _nullMultiMediaCacheModel = new CacheModel<MultiMedia>() {
            public MultiMedia toEntityModel() {
                return _nullMultiMedia;
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
     * Caches the multi media in the entity cache if it is enabled.
     *
     * @param multiMedia the multi media
     */
    public void cacheResult(MultiMedia multiMedia) {
        EntityCacheUtil.putResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaImpl.class, multiMedia.getPrimaryKey(), multiMedia);

        multiMedia.resetOriginalValues();
    }

    /**
     * Caches the multi medias in the entity cache if it is enabled.
     *
     * @param multiMedias the multi medias
     */
    public void cacheResult(List<MultiMedia> multiMedias) {
        for (MultiMedia multiMedia : multiMedias) {
            if (EntityCacheUtil.getResult(
                        MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
                        MultiMediaImpl.class, multiMedia.getPrimaryKey()) == null) {
                cacheResult(multiMedia);
            } else {
                multiMedia.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all multi medias.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MultiMediaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MultiMediaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the multi media.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(MultiMedia multiMedia) {
        EntityCacheUtil.removeResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaImpl.class, multiMedia.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<MultiMedia> multiMedias) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (MultiMedia multiMedia : multiMedias) {
            EntityCacheUtil.removeResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
                MultiMediaImpl.class, multiMedia.getPrimaryKey());
        }
    }

    /**
     * Creates a new multi media with the primary key. Does not add the multi media to the database.
     *
     * @param multiMediaId the primary key for the new multi media
     * @return the new multi media
     */
    public MultiMedia create(long multiMediaId) {
        MultiMedia multiMedia = new MultiMediaImpl();

        multiMedia.setNew(true);
        multiMedia.setPrimaryKey(multiMediaId);

        return multiMedia;
    }

    /**
     * Removes the multi media with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param multiMediaId the primary key of the multi media
     * @return the multi media that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia remove(long multiMediaId)
        throws NoSuchMultiMediaException, SystemException {
        return remove(Long.valueOf(multiMediaId));
    }

    /**
     * Removes the multi media with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the multi media
     * @return the multi media that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MultiMedia remove(Serializable primaryKey)
        throws NoSuchMultiMediaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MultiMedia multiMedia = (MultiMedia) session.get(MultiMediaImpl.class,
                    primaryKey);

            if (multiMedia == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMultiMediaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(multiMedia);
        } catch (NoSuchMultiMediaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected MultiMedia removeImpl(MultiMedia multiMedia)
        throws SystemException {
        multiMedia = toUnwrappedModel(multiMedia);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, multiMedia);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(multiMedia);

        return multiMedia;
    }

    @Override
    public MultiMedia updateImpl(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia, boolean merge)
        throws SystemException {
        multiMedia = toUnwrappedModel(multiMedia);

        boolean isNew = multiMedia.isNew();

        MultiMediaModelImpl multiMediaModelImpl = (MultiMediaModelImpl) multiMedia;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, multiMedia, merge);

            multiMedia.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MultiMediaModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((multiMediaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((multiMediaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getOriginalCompanyId()),
                        Long.valueOf(multiMediaModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);

                args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getCompanyId()),
                        Long.valueOf(multiMediaModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);
            }

            if ((multiMediaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getOriginalCompanyId()),
                        Long.valueOf(multiMediaModelImpl.getOriginalApplicationId()),
                        Long.valueOf(multiMediaModelImpl.getOriginalImageId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAI, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAI,
                    args);

                args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getCompanyId()),
                        Long.valueOf(multiMediaModelImpl.getApplicationId()),
                        Long.valueOf(multiMediaModelImpl.getImageId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAI, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAI,
                    args);
            }

            if ((multiMediaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP,
                    args);

                args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP,
                    args);
            }

            if ((multiMediaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getOriginalImageId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGE,
                    args);

                args = new Object[] {
                        Long.valueOf(multiMediaModelImpl.getImageId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGE,
                    args);
            }
        }

        EntityCacheUtil.putResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            MultiMediaImpl.class, multiMedia.getPrimaryKey(), multiMedia);

        return multiMedia;
    }

    protected MultiMedia toUnwrappedModel(MultiMedia multiMedia) {
        if (multiMedia instanceof MultiMediaImpl) {
            return multiMedia;
        }

        MultiMediaImpl multiMediaImpl = new MultiMediaImpl();

        multiMediaImpl.setNew(multiMedia.isNew());
        multiMediaImpl.setPrimaryKey(multiMedia.getPrimaryKey());

        multiMediaImpl.setMultiMediaId(multiMedia.getMultiMediaId());
        multiMediaImpl.setCompanyId(multiMedia.getCompanyId());
        multiMediaImpl.setUserId(multiMedia.getUserId());
        multiMediaImpl.setCreateDate(multiMedia.getCreateDate());
        multiMediaImpl.setModifiedDate(multiMedia.getModifiedDate());
        multiMediaImpl.setName(multiMedia.getName());
        multiMediaImpl.setType(multiMedia.getType());
        multiMediaImpl.setImageId(multiMedia.getImageId());
        multiMediaImpl.setApplicationId(multiMedia.getApplicationId());

        return multiMediaImpl;
    }

    /**
     * Returns the multi media with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the multi media
     * @return the multi media
     * @throws com.liferay.portal.NoSuchModelException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MultiMedia findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the multi media with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchMultiMediaException} if it could not be found.
     *
     * @param multiMediaId the primary key of the multi media
     * @return the multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByPrimaryKey(long multiMediaId)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByPrimaryKey(multiMediaId);

        if (multiMedia == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + multiMediaId);
            }

            throw new NoSuchMultiMediaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                multiMediaId);
        }

        return multiMedia;
    }

    /**
     * Returns the multi media with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the multi media
     * @return the multi media, or <code>null</code> if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MultiMedia fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the multi media with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param multiMediaId the primary key of the multi media
     * @return the multi media, or <code>null</code> if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByPrimaryKey(long multiMediaId)
        throws SystemException {
        MultiMedia multiMedia = (MultiMedia) EntityCacheUtil.getResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
                MultiMediaImpl.class, multiMediaId);

        if (multiMedia == _nullMultiMedia) {
            return null;
        }

        if (multiMedia == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                multiMedia = (MultiMedia) session.get(MultiMediaImpl.class,
                        Long.valueOf(multiMediaId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (multiMedia != null) {
                    cacheResult(multiMedia);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
                        MultiMediaImpl.class, multiMediaId, _nullMultiMedia);
                }

                closeSession(session);
            }
        }

        return multiMedia;
    }

    /**
     * Returns all the multi medias where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the multi medias where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByc(long companyId, int start, int end,
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

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MultiMedia multiMedia : list) {
                if ((companyId != multiMedia.getCompanyId())) {
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

            query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

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

                list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Returns the first multi media in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByc_First(companyId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the first multi media in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<MultiMedia> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByc_Last(companyId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<MultiMedia> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63;.
     *
     * @param multiMediaId the primary key of the current multi media
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia[] findByc_PrevAndNext(long multiMediaId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = findByPrimaryKey(multiMediaId);

        Session session = null;

        try {
            session = openSession();

            MultiMedia[] array = new MultiMediaImpl[3];

            array[0] = getByc_PrevAndNext(session, multiMedia, companyId,
                    orderByComparator, true);

            array[1] = multiMedia;

            array[2] = getByc_PrevAndNext(session, multiMedia, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MultiMedia getByc_PrevAndNext(Session session,
        MultiMedia multiMedia, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(multiMedia);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MultiMedia> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the multi medias where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByca(long companyId, long applicationId)
        throws SystemException {
        return findByca(companyId, applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the multi medias where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByca(long companyId, long applicationId,
        int start, int end) throws SystemException {
        return findByca(companyId, applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByca(long companyId, long applicationId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MultiMedia multiMedia : list) {
                if ((companyId != multiMedia.getCompanyId()) ||
                        (applicationId != multiMedia.getApplicationId())) {
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

            query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

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

                list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByca_First(long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByca_First(companyId, applicationId,
                orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByca_First(long companyId, long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<MultiMedia> list = findByca(companyId, applicationId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByca_Last(long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByca_Last(companyId, applicationId,
                orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByca_Last(long companyId, long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByca(companyId, applicationId);

        List<MultiMedia> list = findByca(companyId, applicationId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param multiMediaId the primary key of the current multi media
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia[] findByca_PrevAndNext(long multiMediaId, long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = findByPrimaryKey(multiMediaId);

        Session session = null;

        try {
            session = openSession();

            MultiMedia[] array = new MultiMediaImpl[3];

            array[0] = getByca_PrevAndNext(session, multiMedia, companyId,
                    applicationId, orderByComparator, true);

            array[1] = multiMedia;

            array[2] = getByca_PrevAndNext(session, multiMedia, companyId,
                    applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MultiMedia getByca_PrevAndNext(Session session,
        MultiMedia multiMedia, long companyId, long applicationId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(multiMedia);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MultiMedia> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @return the matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findBycai(long companyId, long applicationId,
        long imageId) throws SystemException {
        return findBycai(companyId, applicationId, imageId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findBycai(long companyId, long applicationId,
        long imageId, int start, int end) throws SystemException {
        return findBycai(companyId, applicationId, imageId, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findBycai(long companyId, long applicationId,
        long imageId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAI;
            finderArgs = new Object[] { companyId, applicationId, imageId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAI;
            finderArgs = new Object[] {
                    companyId, applicationId, imageId,
                    
                    start, end, orderByComparator
                };
        }

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MultiMedia multiMedia : list) {
                if ((companyId != multiMedia.getCompanyId()) ||
                        (applicationId != multiMedia.getApplicationId()) ||
                        (imageId != multiMedia.getImageId())) {
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

            query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_CAI_COMPANYID_2);

            query.append(_FINDER_COLUMN_CAI_APPLICATIONID_2);

            query.append(_FINDER_COLUMN_CAI_IMAGEID_2);

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

                qPos.add(imageId);

                list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findBycai_First(long companyId, long applicationId,
        long imageId, OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchBycai_First(companyId, applicationId,
                imageId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(", imageId=");
        msg.append(imageId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchBycai_First(long companyId, long applicationId,
        long imageId, OrderByComparator orderByComparator)
        throws SystemException {
        List<MultiMedia> list = findBycai(companyId, applicationId, imageId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findBycai_Last(long companyId, long applicationId,
        long imageId, OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchBycai_Last(companyId, applicationId,
                imageId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(", imageId=");
        msg.append(imageId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchBycai_Last(long companyId, long applicationId,
        long imageId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBycai(companyId, applicationId, imageId);

        List<MultiMedia> list = findBycai(companyId, applicationId, imageId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param multiMediaId the primary key of the current multi media
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia[] findBycai_PrevAndNext(long multiMediaId,
        long companyId, long applicationId, long imageId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = findByPrimaryKey(multiMediaId);

        Session session = null;

        try {
            session = openSession();

            MultiMedia[] array = new MultiMediaImpl[3];

            array[0] = getBycai_PrevAndNext(session, multiMedia, companyId,
                    applicationId, imageId, orderByComparator, true);

            array[1] = multiMedia;

            array[2] = getBycai_PrevAndNext(session, multiMedia, companyId,
                    applicationId, imageId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MultiMedia getBycai_PrevAndNext(Session session,
        MultiMedia multiMedia, long companyId, long applicationId,
        long imageId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

        query.append(_FINDER_COLUMN_CAI_COMPANYID_2);

        query.append(_FINDER_COLUMN_CAI_APPLICATIONID_2);

        query.append(_FINDER_COLUMN_CAI_IMAGEID_2);

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

        qPos.add(imageId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(multiMedia);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MultiMedia> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the multi medias where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByapp(long applicationId)
        throws SystemException {
        return findByapp(applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the multi medias where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByapp(long applicationId, int start, int end)
        throws SystemException {
        return findByapp(applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByapp(long applicationId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP;
            finderArgs = new Object[] { applicationId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APP;
            finderArgs = new Object[] {
                    applicationId,
                    
                    start, end, orderByComparator
                };
        }

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MultiMedia multiMedia : list) {
                if ((applicationId != multiMedia.getApplicationId())) {
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

            query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_APP_APPLICATIONID_2);

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

                list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Returns the first multi media in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByapp_First(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByapp_First(applicationId,
                orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the first multi media in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByapp_First(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<MultiMedia> list = findByapp(applicationId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last multi media in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByapp_Last(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByapp_Last(applicationId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the last multi media in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByapp_Last(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByapp(applicationId);

        List<MultiMedia> list = findByapp(applicationId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the multi medias before and after the current multi media in the ordered set where applicationId = &#63;.
     *
     * @param multiMediaId the primary key of the current multi media
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia[] findByapp_PrevAndNext(long multiMediaId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = findByPrimaryKey(multiMediaId);

        Session session = null;

        try {
            session = openSession();

            MultiMedia[] array = new MultiMediaImpl[3];

            array[0] = getByapp_PrevAndNext(session, multiMedia, applicationId,
                    orderByComparator, true);

            array[1] = multiMedia;

            array[2] = getByapp_PrevAndNext(session, multiMedia, applicationId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MultiMedia getByapp_PrevAndNext(Session session,
        MultiMedia multiMedia, long applicationId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

        query.append(_FINDER_COLUMN_APP_APPLICATIONID_2);

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
            Object[] values = orderByComparator.getOrderByConditionValues(multiMedia);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MultiMedia> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the multi medias where imageId = &#63;.
     *
     * @param imageId the image ID
     * @return the matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByimage(long imageId) throws SystemException {
        return findByimage(imageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the multi medias where imageId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param imageId the image ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByimage(long imageId, int start, int end)
        throws SystemException {
        return findByimage(imageId, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias where imageId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param imageId the image ID
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findByimage(long imageId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGE;
            finderArgs = new Object[] { imageId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGE;
            finderArgs = new Object[] { imageId, start, end, orderByComparator };
        }

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MultiMedia multiMedia : list) {
                if ((imageId != multiMedia.getImageId())) {
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

            query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_IMAGE_IMAGEID_2);

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

                qPos.add(imageId);

                list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Returns the first multi media in the ordered set where imageId = &#63;.
     *
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByimage_First(long imageId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByimage_First(imageId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("imageId=");
        msg.append(imageId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the first multi media in the ordered set where imageId = &#63;.
     *
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByimage_First(long imageId,
        OrderByComparator orderByComparator) throws SystemException {
        List<MultiMedia> list = findByimage(imageId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last multi media in the ordered set where imageId = &#63;.
     *
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia findByimage_Last(long imageId,
        OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = fetchByimage_Last(imageId, orderByComparator);

        if (multiMedia != null) {
            return multiMedia;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("imageId=");
        msg.append(imageId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMultiMediaException(msg.toString());
    }

    /**
     * Returns the last multi media in the ordered set where imageId = &#63;.
     *
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia fetchByimage_Last(long imageId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByimage(imageId);

        List<MultiMedia> list = findByimage(imageId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the multi medias before and after the current multi media in the ordered set where imageId = &#63;.
     *
     * @param multiMediaId the primary key of the current multi media
     * @param imageId the image ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next multi media
     * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MultiMedia[] findByimage_PrevAndNext(long multiMediaId,
        long imageId, OrderByComparator orderByComparator)
        throws NoSuchMultiMediaException, SystemException {
        MultiMedia multiMedia = findByPrimaryKey(multiMediaId);

        Session session = null;

        try {
            session = openSession();

            MultiMedia[] array = new MultiMediaImpl[3];

            array[0] = getByimage_PrevAndNext(session, multiMedia, imageId,
                    orderByComparator, true);

            array[1] = multiMedia;

            array[2] = getByimage_PrevAndNext(session, multiMedia, imageId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MultiMedia getByimage_PrevAndNext(Session session,
        MultiMedia multiMedia, long imageId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MULTIMEDIA_WHERE);

        query.append(_FINDER_COLUMN_IMAGE_IMAGEID_2);

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

        qPos.add(imageId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(multiMedia);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MultiMedia> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the multi medias.
     *
     * @return the multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the multi medias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @return the range of multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of multi medias
     * @param end the upper bound of the range of multi medias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of multi medias
     * @throws SystemException if a system exception occurred
     */
    public List<MultiMedia> findAll(int start, int end,
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

        List<MultiMedia> list = (List<MultiMedia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MULTIMEDIA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MULTIMEDIA;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MultiMedia>) QueryUtil.list(q, getDialect(),
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
     * Removes all the multi medias where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (MultiMedia multiMedia : findByc(companyId)) {
            remove(multiMedia);
        }
    }

    /**
     * Removes all the multi medias where companyId = &#63; and applicationId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByca(long companyId, long applicationId)
        throws SystemException {
        for (MultiMedia multiMedia : findByca(companyId, applicationId)) {
            remove(multiMedia);
        }
    }

    /**
     * Removes all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @throws SystemException if a system exception occurred
     */
    public void removeBycai(long companyId, long applicationId, long imageId)
        throws SystemException {
        for (MultiMedia multiMedia : findBycai(companyId, applicationId, imageId)) {
            remove(multiMedia);
        }
    }

    /**
     * Removes all the multi medias where applicationId = &#63; from the database.
     *
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByapp(long applicationId) throws SystemException {
        for (MultiMedia multiMedia : findByapp(applicationId)) {
            remove(multiMedia);
        }
    }

    /**
     * Removes all the multi medias where imageId = &#63; from the database.
     *
     * @param imageId the image ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByimage(long imageId) throws SystemException {
        for (MultiMedia multiMedia : findByimage(imageId)) {
            remove(multiMedia);
        }
    }

    /**
     * Removes all the multi medias from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (MultiMedia multiMedia : findAll()) {
            remove(multiMedia);
        }
    }

    /**
     * Returns the number of multi medias where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MULTIMEDIA_WHERE);

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
     * Returns the number of multi medias where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the number of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countByca(long companyId, long applicationId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CA,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MULTIMEDIA_WHERE);

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
     * Returns the number of multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param imageId the image ID
     * @return the number of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countBycai(long companyId, long applicationId, long imageId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId, imageId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAI,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_CAI_COMPANYID_2);

            query.append(_FINDER_COLUMN_CAI_APPLICATIONID_2);

            query.append(_FINDER_COLUMN_CAI_IMAGEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(applicationId);

                qPos.add(imageId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAI, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of multi medias where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the number of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countByapp(long applicationId) throws SystemException {
        Object[] finderArgs = new Object[] { applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APP,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_APP_APPLICATIONID_2);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APP, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of multi medias where imageId = &#63;.
     *
     * @param imageId the image ID
     * @return the number of matching multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countByimage(long imageId) throws SystemException {
        Object[] finderArgs = new Object[] { imageId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IMAGE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MULTIMEDIA_WHERE);

            query.append(_FINDER_COLUMN_IMAGE_IMAGEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(imageId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of multi medias.
     *
     * @return the number of multi medias
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_MULTIMEDIA);

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
     * Initializes the multi media persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.MultiMedia")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MultiMedia>> listenersList = new ArrayList<ModelListener<MultiMedia>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MultiMedia>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MultiMediaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
