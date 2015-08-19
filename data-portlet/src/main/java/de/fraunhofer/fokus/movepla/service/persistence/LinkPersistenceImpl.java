package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LinkPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchLinkException;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.impl.LinkImpl;
import de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl;
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
 * The persistence implementation for the link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LinkPersistence
 * @see LinkUtil
 * @generated
 */
public class LinkPersistenceImpl extends BasePersistenceImpl<Link>
    implements LinkPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LinkUtil} to access the link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LinkImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            LinkModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CA = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByca",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByca",
            new String[] { Long.class.getName(), Long.class.getName() },
            LinkModelImpl.COMPANYID_COLUMN_BITMASK |
            LinkModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CA = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByca",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APP = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapp",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapp",
            new String[] { Long.class.getName() },
            LinkModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APP = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapp",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTYPE = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyType",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPE =
        new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyType",
            new String[] { Integer.class.getName() },
            LinkModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BYTYPE = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyType",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LINK = "SELECT link FROM Link link";
    private static final String _SQL_SELECT_LINK_WHERE = "SELECT link FROM Link link WHERE ";
    private static final String _SQL_COUNT_LINK = "SELECT COUNT(link) FROM Link link";
    private static final String _SQL_COUNT_LINK_WHERE = "SELECT COUNT(link) FROM Link link WHERE ";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "link.companyId = ?";
    private static final String _FINDER_COLUMN_CA_COMPANYID_2 = "link.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CA_APPLICATIONID_2 = "link.applicationId = ?";
    private static final String _FINDER_COLUMN_APP_APPLICATIONID_2 = "link.applicationId = ?";
    private static final String _FINDER_COLUMN_BYTYPE_TYPE_2 = "link.type = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "link.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Link exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Link exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LinkPersistenceImpl.class);
    private static Link _nullLink = new LinkImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Link> toCacheModel() {
                return _nullLinkCacheModel;
            }
        };

    private static CacheModel<Link> _nullLinkCacheModel = new CacheModel<Link>() {
            public Link toEntityModel() {
                return _nullLink;
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
     * Caches the link in the entity cache if it is enabled.
     *
     * @param link the link
     */
    public void cacheResult(Link link) {
        EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkImpl.class, link.getPrimaryKey(), link);

        link.resetOriginalValues();
    }

    /**
     * Caches the links in the entity cache if it is enabled.
     *
     * @param links the links
     */
    public void cacheResult(List<Link> links) {
        for (Link link : links) {
            if (EntityCacheUtil.getResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
                        LinkImpl.class, link.getPrimaryKey()) == null) {
                cacheResult(link);
            } else {
                link.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all links.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LinkImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LinkImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the link.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Link link) {
        EntityCacheUtil.removeResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkImpl.class, link.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Link> links) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Link link : links) {
            EntityCacheUtil.removeResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
                LinkImpl.class, link.getPrimaryKey());
        }
    }

    /**
     * Creates a new link with the primary key. Does not add the link to the database.
     *
     * @param linkId the primary key for the new link
     * @return the new link
     */
    public Link create(long linkId) {
        Link link = new LinkImpl();

        link.setNew(true);
        link.setPrimaryKey(linkId);

        return link;
    }

    /**
     * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param linkId the primary key of the link
     * @return the link that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link remove(long linkId) throws NoSuchLinkException, SystemException {
        return remove(Long.valueOf(linkId));
    }

    /**
     * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the link
     * @return the link that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Link remove(Serializable primaryKey)
        throws NoSuchLinkException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Link link = (Link) session.get(LinkImpl.class, primaryKey);

            if (link == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(link);
        } catch (NoSuchLinkException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Link removeImpl(Link link) throws SystemException {
        link = toUnwrappedModel(link);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, link);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(link);

        return link;
    }

    @Override
    public Link updateImpl(de.fraunhofer.fokus.movepla.model.Link link,
        boolean merge) throws SystemException {
        link = toUnwrappedModel(link);

        boolean isNew = link.isNew();

        LinkModelImpl linkModelImpl = (LinkModelImpl) link;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, link, merge);

            link.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LinkModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((linkModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(linkModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] { Long.valueOf(linkModelImpl.getCompanyId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((linkModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(linkModelImpl.getOriginalCompanyId()),
                        Long.valueOf(linkModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);

                args = new Object[] {
                        Long.valueOf(linkModelImpl.getCompanyId()),
                        Long.valueOf(linkModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CA, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CA,
                    args);
            }

            if ((linkModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(linkModelImpl.getOriginalApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP,
                    args);

                args = new Object[] {
                        Long.valueOf(linkModelImpl.getApplicationId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APP,
                    args);
            }

            if ((linkModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Integer.valueOf(linkModelImpl.getOriginalType())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPE,
                    args);

                args = new Object[] { Integer.valueOf(linkModelImpl.getType()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPE,
                    args);
            }
        }

        EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
            LinkImpl.class, link.getPrimaryKey(), link);

        return link;
    }

    protected Link toUnwrappedModel(Link link) {
        if (link instanceof LinkImpl) {
            return link;
        }

        LinkImpl linkImpl = new LinkImpl();

        linkImpl.setNew(link.isNew());
        linkImpl.setPrimaryKey(link.getPrimaryKey());

        linkImpl.setLinkId(link.getLinkId());
        linkImpl.setCompanyId(link.getCompanyId());
        linkImpl.setUserId(link.getUserId());
        linkImpl.setCreateDate(link.getCreateDate());
        linkImpl.setModifiedDate(link.getModifiedDate());
        linkImpl.setDisplayName(link.getDisplayName());
        linkImpl.setType(link.getType());
        linkImpl.setUrl(link.getUrl());
        linkImpl.setApplicationId(link.getApplicationId());

        return linkImpl;
    }

    /**
     * Returns the link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the link
     * @return the link
     * @throws com.liferay.portal.NoSuchModelException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Link findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the link with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLinkException} if it could not be found.
     *
     * @param linkId the primary key of the link
     * @return the link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByPrimaryKey(long linkId)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByPrimaryKey(linkId);

        if (link == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkId);
            }

            throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                linkId);
        }

        return link;
    }

    /**
     * Returns the link with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the link
     * @return the link, or <code>null</code> if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Link fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the link with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param linkId the primary key of the link
     * @return the link, or <code>null</code> if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByPrimaryKey(long linkId) throws SystemException {
        Link link = (Link) EntityCacheUtil.getResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
                LinkImpl.class, linkId);

        if (link == _nullLink) {
            return null;
        }

        if (link == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                link = (Link) session.get(LinkImpl.class, Long.valueOf(linkId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (link != null) {
                    cacheResult(link);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
                        LinkImpl.class, linkId, _nullLink);
                }

                closeSession(session);
            }
        }

        return link;
    }

    /**
     * Returns all the links where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the links where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @return the range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the links where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByc(long companyId, int start, int end,
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

        List<Link> list = (List<Link>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Link link : list) {
                if ((companyId != link.getCompanyId())) {
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

            query.append(_SQL_SELECT_LINK_WHERE);

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

                list = (List<Link>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first link in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByc_First(companyId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the first link in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Link> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last link in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByc_Last(long companyId, OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByc_Last(companyId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the last link in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Link> list = findByc(companyId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the links before and after the current link in the ordered set where companyId = &#63;.
     *
     * @param linkId the primary key of the current link
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link[] findByc_PrevAndNext(long linkId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = findByPrimaryKey(linkId);

        Session session = null;

        try {
            session = openSession();

            Link[] array = new LinkImpl[3];

            array[0] = getByc_PrevAndNext(session, link, companyId,
                    orderByComparator, true);

            array[1] = link;

            array[2] = getByc_PrevAndNext(session, link, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Link getByc_PrevAndNext(Session session, Link link,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LINK_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(link);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Link> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the links where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByca(long companyId, long applicationId)
        throws SystemException {
        return findByca(companyId, applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the links where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @return the range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByca(long companyId, long applicationId, int start,
        int end) throws SystemException {
        return findByca(companyId, applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the links where companyId = &#63; and applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByca(long companyId, long applicationId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<Link> list = (List<Link>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Link link : list) {
                if ((companyId != link.getCompanyId()) ||
                        (applicationId != link.getApplicationId())) {
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

            query.append(_SQL_SELECT_LINK_WHERE);

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

                list = (List<Link>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first link in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByca_First(long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByca_First(companyId, applicationId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the first link in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByca_First(long companyId, long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Link> list = findByca(companyId, applicationId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last link in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByca_Last(long companyId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByca_Last(companyId, applicationId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the last link in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByca_Last(long companyId, long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByca(companyId, applicationId);

        List<Link> list = findByca(companyId, applicationId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the links before and after the current link in the ordered set where companyId = &#63; and applicationId = &#63;.
     *
     * @param linkId the primary key of the current link
     * @param companyId the company ID
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link[] findByca_PrevAndNext(long linkId, long companyId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = findByPrimaryKey(linkId);

        Session session = null;

        try {
            session = openSession();

            Link[] array = new LinkImpl[3];

            array[0] = getByca_PrevAndNext(session, link, companyId,
                    applicationId, orderByComparator, true);

            array[1] = link;

            array[2] = getByca_PrevAndNext(session, link, companyId,
                    applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Link getByca_PrevAndNext(Session session, Link link,
        long companyId, long applicationId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LINK_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(link);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Link> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the links where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByapp(long applicationId) throws SystemException {
        return findByapp(applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the links where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @return the range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByapp(long applicationId, int start, int end)
        throws SystemException {
        return findByapp(applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the links where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findByapp(long applicationId, int start, int end,
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

        List<Link> list = (List<Link>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Link link : list) {
                if ((applicationId != link.getApplicationId())) {
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

            query.append(_SQL_SELECT_LINK_WHERE);

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

                list = (List<Link>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first link in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByapp_First(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByapp_First(applicationId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the first link in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByapp_First(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Link> list = findByapp(applicationId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last link in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findByapp_Last(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchByapp_Last(applicationId, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the last link in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchByapp_Last(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByapp(applicationId);

        List<Link> list = findByapp(applicationId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the links before and after the current link in the ordered set where applicationId = &#63;.
     *
     * @param linkId the primary key of the current link
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link[] findByapp_PrevAndNext(long linkId, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = findByPrimaryKey(linkId);

        Session session = null;

        try {
            session = openSession();

            Link[] array = new LinkImpl[3];

            array[0] = getByapp_PrevAndNext(session, link, applicationId,
                    orderByComparator, true);

            array[1] = link;

            array[2] = getByapp_PrevAndNext(session, link, applicationId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Link getByapp_PrevAndNext(Session session, Link link,
        long applicationId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LINK_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(link);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Link> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the links where type = &#63;.
     *
     * @param type the type
     * @return the matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findBybyType(int type) throws SystemException {
        return findBybyType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the links where type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param type the type
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @return the range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findBybyType(int type, int start, int end)
        throws SystemException {
        return findBybyType(type, start, end, null);
    }

    /**
     * Returns an ordered range of all the links where type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param type the type
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findBybyType(int type, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPE;
            finderArgs = new Object[] { type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTYPE;
            finderArgs = new Object[] { type, start, end, orderByComparator };
        }

        List<Link> list = (List<Link>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Link link : list) {
                if ((type != link.getType())) {
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

            query.append(_SQL_SELECT_LINK_WHERE);

            query.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

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

                qPos.add(type);

                list = (List<Link>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first link in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findBybyType_First(int type, OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchBybyType_First(type, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the first link in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchBybyType_First(int type,
        OrderByComparator orderByComparator) throws SystemException {
        List<Link> list = findBybyType(type, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last link in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link findBybyType_Last(int type, OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = fetchBybyType_Last(type, orderByComparator);

        if (link != null) {
            return link;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLinkException(msg.toString());
    }

    /**
     * Returns the last link in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching link, or <code>null</code> if a matching link could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link fetchBybyType_Last(int type, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBybyType(type);

        List<Link> list = findBybyType(type, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the links before and after the current link in the ordered set where type = &#63;.
     *
     * @param linkId the primary key of the current link
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next link
     * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Link[] findBybyType_PrevAndNext(long linkId, int type,
        OrderByComparator orderByComparator)
        throws NoSuchLinkException, SystemException {
        Link link = findByPrimaryKey(linkId);

        Session session = null;

        try {
            session = openSession();

            Link[] array = new LinkImpl[3];

            array[0] = getBybyType_PrevAndNext(session, link, type,
                    orderByComparator, true);

            array[1] = link;

            array[2] = getBybyType_PrevAndNext(session, link, type,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Link getBybyType_PrevAndNext(Session session, Link link,
        int type, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LINK_WHERE);

        query.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

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

        qPos.add(type);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(link);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Link> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the links.
     *
     * @return the links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the links.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @return the range of links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the links.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of links
     * @param end the upper bound of the range of links (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of links
     * @throws SystemException if a system exception occurred
     */
    public List<Link> findAll(int start, int end,
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

        List<Link> list = (List<Link>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LINK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LINK;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Link>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Link>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the links where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Link link : findByc(companyId)) {
            remove(link);
        }
    }

    /**
     * Removes all the links where companyId = &#63; and applicationId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByca(long companyId, long applicationId)
        throws SystemException {
        for (Link link : findByca(companyId, applicationId)) {
            remove(link);
        }
    }

    /**
     * Removes all the links where applicationId = &#63; from the database.
     *
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByapp(long applicationId) throws SystemException {
        for (Link link : findByapp(applicationId)) {
            remove(link);
        }
    }

    /**
     * Removes all the links where type = &#63; from the database.
     *
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    public void removeBybyType(int type) throws SystemException {
        for (Link link : findBybyType(type)) {
            remove(link);
        }
    }

    /**
     * Removes all the links from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Link link : findAll()) {
            remove(link);
        }
    }

    /**
     * Returns the number of links where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching links
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LINK_WHERE);

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
     * Returns the number of links where companyId = &#63; and applicationId = &#63;.
     *
     * @param companyId the company ID
     * @param applicationId the application ID
     * @return the number of matching links
     * @throws SystemException if a system exception occurred
     */
    public int countByca(long companyId, long applicationId)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CA,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LINK_WHERE);

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
     * Returns the number of links where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the number of matching links
     * @throws SystemException if a system exception occurred
     */
    public int countByapp(long applicationId) throws SystemException {
        Object[] finderArgs = new Object[] { applicationId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APP,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LINK_WHERE);

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
     * Returns the number of links where type = &#63;.
     *
     * @param type the type
     * @return the number of matching links
     * @throws SystemException if a system exception occurred
     */
    public int countBybyType(int type) throws SystemException {
        Object[] finderArgs = new Object[] { type };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYTYPE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LINK_WHERE);

            query.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYTYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of links.
     *
     * @return the number of links
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LINK);

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
     * Initializes the link persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Link")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Link>> listenersList = new ArrayList<ModelListener<Link>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Link>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LinkImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
