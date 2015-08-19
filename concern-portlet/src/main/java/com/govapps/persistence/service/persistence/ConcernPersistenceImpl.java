package com.govapps.persistence.service.persistence;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import com.govapps.persistence.NoSuchConcernException;
import com.govapps.persistence.model.Concern;
import com.govapps.persistence.model.impl.ConcernImpl;
import com.govapps.persistence.model.impl.ConcernModelImpl;
import com.govapps.persistence.service.persistence.ConcernPersistence;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the concern service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ekl
 * @see ConcernPersistence
 * @see ConcernUtil
 * @generated
 */
public class ConcernPersistenceImpl extends BasePersistenceImpl<Concern>
    implements ConcernPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ConcernUtil} to access the concern persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ConcernImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATE = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByState",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATE = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByState",
            new String[] { Integer.class.getName() },
            ConcernModelImpl.STATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATE = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByState",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ConcernModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, ConcernImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CONCERN = "SELECT concern FROM Concern concern";
    private static final String _SQL_SELECT_CONCERN_WHERE = "SELECT concern FROM Concern concern WHERE ";
    private static final String _SQL_COUNT_CONCERN = "SELECT COUNT(concern) FROM Concern concern";
    private static final String _SQL_COUNT_CONCERN_WHERE = "SELECT COUNT(concern) FROM Concern concern WHERE ";
    private static final String _FINDER_COLUMN_STATE_STATE_2 = "concern.state = ?";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "concern.companyId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "concern.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Concern exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Concern exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ConcernPersistenceImpl.class);
    private static Concern _nullConcern = new ConcernImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Concern> toCacheModel() {
                return _nullConcernCacheModel;
            }
        };

    private static CacheModel<Concern> _nullConcernCacheModel = new CacheModel<Concern>() {
            public Concern toEntityModel() {
                return _nullConcern;
            }
        };

    @BeanReference(type = ConcernPersistence.class)
    protected ConcernPersistence concernPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the concern in the entity cache if it is enabled.
     *
     * @param concern the concern
     */
    public void cacheResult(Concern concern) {
        EntityCacheUtil.putResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernImpl.class, concern.getPrimaryKey(), concern);

        concern.resetOriginalValues();
    }

    /**
     * Caches the concerns in the entity cache if it is enabled.
     *
     * @param concerns the concerns
     */
    public void cacheResult(List<Concern> concerns) {
        for (Concern concern : concerns) {
            if (EntityCacheUtil.getResult(
                        ConcernModelImpl.ENTITY_CACHE_ENABLED,
                        ConcernImpl.class, concern.getPrimaryKey()) == null) {
                cacheResult(concern);
            } else {
                concern.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all concerns.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ConcernImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ConcernImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the concern.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Concern concern) {
        EntityCacheUtil.removeResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernImpl.class, concern.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Concern> concerns) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Concern concern : concerns) {
            EntityCacheUtil.removeResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
                ConcernImpl.class, concern.getPrimaryKey());
        }
    }

    /**
     * Creates a new concern with the primary key. Does not add the concern to the database.
     *
     * @param id the primary key for the new concern
     * @return the new concern
     */
    public Concern create(long id) {
        Concern concern = new ConcernImpl();

        concern.setNew(true);
        concern.setPrimaryKey(id);

        return concern;
    }

    /**
     * Removes the concern with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the concern
     * @return the concern that was removed
     * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern remove(long id)
        throws NoSuchConcernException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the concern with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the concern
     * @return the concern that was removed
     * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Concern remove(Serializable primaryKey)
        throws NoSuchConcernException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Concern concern = (Concern) session.get(ConcernImpl.class,
                    primaryKey);

            if (concern == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchConcernException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(concern);
        } catch (NoSuchConcernException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Concern removeImpl(Concern concern) throws SystemException {
        concern = toUnwrappedModel(concern);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, concern);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(concern);

        return concern;
    }

    @Override
    public Concern updateImpl(com.govapps.persistence.model.Concern concern,
        boolean merge) throws SystemException {
        concern = toUnwrappedModel(concern);

        boolean isNew = concern.isNew();

        ConcernModelImpl concernModelImpl = (ConcernModelImpl) concern;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, concern, merge);

            concern.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ConcernModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((concernModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Integer.valueOf(concernModelImpl.getOriginalState())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATE,
                    args);

                args = new Object[] { Integer.valueOf(concernModelImpl.getState()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATE,
                    args);
            }

            if ((concernModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(concernModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] {
                        Long.valueOf(concernModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
            ConcernImpl.class, concern.getPrimaryKey(), concern);

        return concern;
    }

    protected Concern toUnwrappedModel(Concern concern) {
        if (concern instanceof ConcernImpl) {
            return concern;
        }

        ConcernImpl concernImpl = new ConcernImpl();

        concernImpl.setNew(concern.isNew());
        concernImpl.setPrimaryKey(concern.getPrimaryKey());

        concernImpl.setId(concern.getId());
        concernImpl.setCompanyId(concern.getCompanyId());
        concernImpl.setGroupId(concern.getGroupId());
        concernImpl.setName(concern.getName());
        concernImpl.setEmail(concern.getEmail());
        concernImpl.setDescription(concern.getDescription());
        concernImpl.setPlatforms(concern.getPlatforms());
        concernImpl.setConcern(concern.getConcern());
        concernImpl.setRegion(concern.getRegion());
        concernImpl.setCategory(concern.getCategory());
        concernImpl.setCreateDate(concern.getCreateDate());
        concernImpl.setSupports(concern.getSupports());
        concernImpl.setState(concern.getState());

        return concernImpl;
    }

    /**
     * Returns the concern with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the concern
     * @return the concern
     * @throws com.liferay.portal.NoSuchModelException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Concern findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the concern with the primary key or throws a {@link com.govapps.persistence.NoSuchConcernException} if it could not be found.
     *
     * @param id the primary key of the concern
     * @return the concern
     * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern findByPrimaryKey(long id)
        throws NoSuchConcernException, SystemException {
        Concern concern = fetchByPrimaryKey(id);

        if (concern == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchConcernException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return concern;
    }

    /**
     * Returns the concern with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the concern
     * @return the concern, or <code>null</code> if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Concern fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the concern with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the concern
     * @return the concern, or <code>null</code> if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern fetchByPrimaryKey(long id) throws SystemException {
        Concern concern = (Concern) EntityCacheUtil.getResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
                ConcernImpl.class, id);

        if (concern == _nullConcern) {
            return null;
        }

        if (concern == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                concern = (Concern) session.get(ConcernImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (concern != null) {
                    cacheResult(concern);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ConcernModelImpl.ENTITY_CACHE_ENABLED,
                        ConcernImpl.class, id, _nullConcern);
                }

                closeSession(session);
            }
        }

        return concern;
    }

    /**
     * Returns all the concerns where state = &#63;.
     *
     * @param state the state
     * @return the matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByState(int state) throws SystemException {
        return findByState(state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the concerns where state = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param state the state
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @return the range of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByState(int state, int start, int end)
        throws SystemException {
        return findByState(state, start, end, null);
    }

    /**
     * Returns an ordered range of all the concerns where state = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param state the state
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByState(int state, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATE;
            finderArgs = new Object[] { state };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATE;
            finderArgs = new Object[] { state, start, end, orderByComparator };
        }

        List<Concern> list = (List<Concern>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Concern concern : list) {
                if ((state != concern.getState())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONCERN_WHERE);

            query.append(_FINDER_COLUMN_STATE_STATE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ConcernModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(state);

                list = (List<Concern>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first concern in the ordered set where state = &#63;.
     *
     * @param state the state
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching concern
     * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern findByState_First(int state,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = fetchByState_First(state, orderByComparator);

        if (concern != null) {
            return concern;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("state=");
        msg.append(state);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConcernException(msg.toString());
    }

    /**
     * Returns the first concern in the ordered set where state = &#63;.
     *
     * @param state the state
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching concern, or <code>null</code> if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern fetchByState_First(int state,
        OrderByComparator orderByComparator) throws SystemException {
        List<Concern> list = findByState(state, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last concern in the ordered set where state = &#63;.
     *
     * @param state the state
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching concern
     * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern findByState_Last(int state,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = fetchByState_Last(state, orderByComparator);

        if (concern != null) {
            return concern;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("state=");
        msg.append(state);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConcernException(msg.toString());
    }

    /**
     * Returns the last concern in the ordered set where state = &#63;.
     *
     * @param state the state
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching concern, or <code>null</code> if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern fetchByState_Last(int state,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByState(state);

        List<Concern> list = findByState(state, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the concerns before and after the current concern in the ordered set where state = &#63;.
     *
     * @param id the primary key of the current concern
     * @param state the state
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next concern
     * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern[] findByState_PrevAndNext(long id, int state,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Concern[] array = new ConcernImpl[3];

            array[0] = getByState_PrevAndNext(session, concern, state,
                    orderByComparator, true);

            array[1] = concern;

            array[2] = getByState_PrevAndNext(session, concern, state,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Concern getByState_PrevAndNext(Session session, Concern concern,
        int state, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONCERN_WHERE);

        query.append(_FINDER_COLUMN_STATE_STATE_2);

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
        else {
            query.append(ConcernModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(state);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(concern);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Concern> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the concerns where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the concerns where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @return the range of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the concerns where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Concern> list = (List<Concern>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Concern concern : list) {
                if ((companyId != concern.getCompanyId())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONCERN_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ConcernModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<Concern>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first concern in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching concern
     * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = fetchByCompanyId_First(companyId, orderByComparator);

        if (concern != null) {
            return concern;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConcernException(msg.toString());
    }

    /**
     * Returns the first concern in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching concern, or <code>null</code> if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Concern> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last concern in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching concern
     * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = fetchByCompanyId_Last(companyId, orderByComparator);

        if (concern != null) {
            return concern;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConcernException(msg.toString());
    }

    /**
     * Returns the last concern in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching concern, or <code>null</code> if a matching concern could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        List<Concern> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the concerns before and after the current concern in the ordered set where companyId = &#63;.
     *
     * @param id the primary key of the current concern
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next concern
     * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern[] findByCompanyId_PrevAndNext(long id, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchConcernException, SystemException {
        Concern concern = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Concern[] array = new ConcernImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, concern, companyId,
                    orderByComparator, true);

            array[1] = concern;

            array[2] = getByCompanyId_PrevAndNext(session, concern, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Concern getByCompanyId_PrevAndNext(Session session,
        Concern concern, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONCERN_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
        else {
            query.append(ConcernModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(concern);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Concern> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the concerns.
     *
     * @return the concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the concerns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @return the range of concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the concerns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> findAll(int start, int end,
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

        List<Concern> list = (List<Concern>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONCERN);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONCERN.concat(ConcernModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Concern>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Concern>) QueryUtil.list(q, getDialect(),
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
     * Removes all the concerns where state = &#63; from the database.
     *
     * @param state the state
     * @throws SystemException if a system exception occurred
     */
    public void removeByState(int state) throws SystemException {
        for (Concern concern : findByState(state)) {
            remove(concern);
        }
    }

    /**
     * Removes all the concerns where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Concern concern : findByCompanyId(companyId)) {
            remove(concern);
        }
    }

    /**
     * Removes all the concerns from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Concern concern : findAll()) {
            remove(concern);
        }
    }

    /**
     * Returns the number of concerns where state = &#63;.
     *
     * @param state the state
     * @return the number of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public int countByState(int state) throws SystemException {
        Object[] finderArgs = new Object[] { state };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONCERN_WHERE);

            query.append(_FINDER_COLUMN_STATE_STATE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(state);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of concerns where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching concerns
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONCERN_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of concerns.
     *
     * @return the number of concerns
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONCERN);

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
     * Initializes the concern persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.govapps.persistence.model.Concern")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Concern>> listenersList = new ArrayList<ModelListener<Concern>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Concern>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ConcernImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
