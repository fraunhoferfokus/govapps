package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException;
import de.fraunhofer.fokus.movepla.model.LegalDetails;
import de.fraunhofer.fokus.movepla.model.impl.LegalDetailsImpl;
import de.fraunhofer.fokus.movepla.model.impl.LegalDetailsModelImpl;
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
 * The persistence implementation for the legal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LegalDetailsPersistence
 * @see LegalDetailsUtil
 * @generated
 */
public class LegalDetailsPersistenceImpl extends BasePersistenceImpl<LegalDetails>
    implements LegalDetailsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LegalDetailsUtil} to access the legal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LegalDetailsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, LegalDetailsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, LegalDetailsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            LegalDetailsModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, LegalDetailsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, LegalDetailsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LEGALDETAILS = "SELECT legalDetails FROM LegalDetails legalDetails";
    private static final String _SQL_SELECT_LEGALDETAILS_WHERE = "SELECT legalDetails FROM LegalDetails legalDetails WHERE ";
    private static final String _SQL_COUNT_LEGALDETAILS = "SELECT COUNT(legalDetails) FROM LegalDetails legalDetails";
    private static final String _SQL_COUNT_LEGALDETAILS_WHERE = "SELECT COUNT(legalDetails) FROM LegalDetails legalDetails WHERE ";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "legalDetails.companyId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "legalDetails.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegalDetails exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegalDetails exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LegalDetailsPersistenceImpl.class);
    private static LegalDetails _nullLegalDetails = new LegalDetailsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LegalDetails> toCacheModel() {
                return _nullLegalDetailsCacheModel;
            }
        };

    private static CacheModel<LegalDetails> _nullLegalDetailsCacheModel = new CacheModel<LegalDetails>() {
            public LegalDetails toEntityModel() {
                return _nullLegalDetails;
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
     * Caches the legal details in the entity cache if it is enabled.
     *
     * @param legalDetails the legal details
     */
    public void cacheResult(LegalDetails legalDetails) {
        EntityCacheUtil.putResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsImpl.class, legalDetails.getPrimaryKey(), legalDetails);

        legalDetails.resetOriginalValues();
    }

    /**
     * Caches the legal detailses in the entity cache if it is enabled.
     *
     * @param legalDetailses the legal detailses
     */
    public void cacheResult(List<LegalDetails> legalDetailses) {
        for (LegalDetails legalDetails : legalDetailses) {
            if (EntityCacheUtil.getResult(
                        LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
                        LegalDetailsImpl.class, legalDetails.getPrimaryKey()) == null) {
                cacheResult(legalDetails);
            } else {
                legalDetails.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all legal detailses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LegalDetailsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LegalDetailsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the legal details.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LegalDetails legalDetails) {
        EntityCacheUtil.removeResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsImpl.class, legalDetails.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LegalDetails> legalDetailses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LegalDetails legalDetails : legalDetailses) {
            EntityCacheUtil.removeResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
                LegalDetailsImpl.class, legalDetails.getPrimaryKey());
        }
    }

    /**
     * Creates a new legal details with the primary key. Does not add the legal details to the database.
     *
     * @param legalDetailsId the primary key for the new legal details
     * @return the new legal details
     */
    public LegalDetails create(long legalDetailsId) {
        LegalDetails legalDetails = new LegalDetailsImpl();

        legalDetails.setNew(true);
        legalDetails.setPrimaryKey(legalDetailsId);

        return legalDetails;
    }

    /**
     * Removes the legal details with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param legalDetailsId the primary key of the legal details
     * @return the legal details that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails remove(long legalDetailsId)
        throws NoSuchLegalDetailsException, SystemException {
        return remove(Long.valueOf(legalDetailsId));
    }

    /**
     * Removes the legal details with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the legal details
     * @return the legal details that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LegalDetails remove(Serializable primaryKey)
        throws NoSuchLegalDetailsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LegalDetails legalDetails = (LegalDetails) session.get(LegalDetailsImpl.class,
                    primaryKey);

            if (legalDetails == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLegalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(legalDetails);
        } catch (NoSuchLegalDetailsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LegalDetails removeImpl(LegalDetails legalDetails)
        throws SystemException {
        legalDetails = toUnwrappedModel(legalDetails);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, legalDetails);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(legalDetails);

        return legalDetails;
    }

    @Override
    public LegalDetails updateImpl(
        de.fraunhofer.fokus.movepla.model.LegalDetails legalDetails,
        boolean merge) throws SystemException {
        legalDetails = toUnwrappedModel(legalDetails);

        boolean isNew = legalDetails.isNew();

        LegalDetailsModelImpl legalDetailsModelImpl = (LegalDetailsModelImpl) legalDetails;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, legalDetails, merge);

            legalDetails.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LegalDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((legalDetailsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(legalDetailsModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(legalDetailsModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
            LegalDetailsImpl.class, legalDetails.getPrimaryKey(), legalDetails);

        return legalDetails;
    }

    protected LegalDetails toUnwrappedModel(LegalDetails legalDetails) {
        if (legalDetails instanceof LegalDetailsImpl) {
            return legalDetails;
        }

        LegalDetailsImpl legalDetailsImpl = new LegalDetailsImpl();

        legalDetailsImpl.setNew(legalDetails.isNew());
        legalDetailsImpl.setPrimaryKey(legalDetails.getPrimaryKey());

        legalDetailsImpl.setLegalDetailsId(legalDetails.getLegalDetailsId());
        legalDetailsImpl.setCompanyId(legalDetails.getCompanyId());
        legalDetailsImpl.setUserId(legalDetails.getUserId());
        legalDetailsImpl.setCreateDate(legalDetails.getCreateDate());
        legalDetailsImpl.setModifiedDate(legalDetails.getModifiedDate());
        legalDetailsImpl.setName(legalDetails.getName());
        legalDetailsImpl.setValueAddedTaxNo(legalDetails.getValueAddedTaxNo());
        legalDetailsImpl.setRegistrationCourt(legalDetails.getRegistrationCourt());
        legalDetailsImpl.setLegalForm(legalDetails.getLegalForm());
        legalDetailsImpl.setAddress(legalDetails.getAddress());
        legalDetailsImpl.setTelephone(legalDetails.getTelephone());
        legalDetailsImpl.setEmail(legalDetails.getEmail());
        legalDetailsImpl.setURL(legalDetails.getURL());
        legalDetailsImpl.setFax(legalDetails.getFax());

        return legalDetailsImpl;
    }

    /**
     * Returns the legal details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the legal details
     * @return the legal details
     * @throws com.liferay.portal.NoSuchModelException if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LegalDetails findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the legal details with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException} if it could not be found.
     *
     * @param legalDetailsId the primary key of the legal details
     * @return the legal details
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails findByPrimaryKey(long legalDetailsId)
        throws NoSuchLegalDetailsException, SystemException {
        LegalDetails legalDetails = fetchByPrimaryKey(legalDetailsId);

        if (legalDetails == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + legalDetailsId);
            }

            throw new NoSuchLegalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                legalDetailsId);
        }

        return legalDetails;
    }

    /**
     * Returns the legal details with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the legal details
     * @return the legal details, or <code>null</code> if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LegalDetails fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the legal details with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param legalDetailsId the primary key of the legal details
     * @return the legal details, or <code>null</code> if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails fetchByPrimaryKey(long legalDetailsId)
        throws SystemException {
        LegalDetails legalDetails = (LegalDetails) EntityCacheUtil.getResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
                LegalDetailsImpl.class, legalDetailsId);

        if (legalDetails == _nullLegalDetails) {
            return null;
        }

        if (legalDetails == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                legalDetails = (LegalDetails) session.get(LegalDetailsImpl.class,
                        Long.valueOf(legalDetailsId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (legalDetails != null) {
                    cacheResult(legalDetails);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LegalDetailsModelImpl.ENTITY_CACHE_ENABLED,
                        LegalDetailsImpl.class, legalDetailsId,
                        _nullLegalDetails);
                }

                closeSession(session);
            }
        }

        return legalDetails;
    }

    /**
     * Returns all the legal detailses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the legal detailses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of legal detailses
     * @param end the upper bound of the range of legal detailses (not inclusive)
     * @return the range of matching legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the legal detailses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of legal detailses
     * @param end the upper bound of the range of legal detailses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findByc(long companyId, int start, int end,
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

        List<LegalDetails> list = (List<LegalDetails>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LegalDetails legalDetails : list) {
                if ((companyId != legalDetails.getCompanyId())) {
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

            query.append(_SQL_SELECT_LEGALDETAILS_WHERE);

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

                list = (List<LegalDetails>) QueryUtil.list(q, getDialect(),
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
     * Returns the first legal details in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching legal details
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a matching legal details could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLegalDetailsException, SystemException {
        LegalDetails legalDetails = fetchByc_First(companyId, orderByComparator);

        if (legalDetails != null) {
            return legalDetails;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLegalDetailsException(msg.toString());
    }

    /**
     * Returns the first legal details in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching legal details, or <code>null</code> if a matching legal details could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LegalDetails> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last legal details in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching legal details
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a matching legal details could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLegalDetailsException, SystemException {
        LegalDetails legalDetails = fetchByc_Last(companyId, orderByComparator);

        if (legalDetails != null) {
            return legalDetails;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLegalDetailsException(msg.toString());
    }

    /**
     * Returns the last legal details in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching legal details, or <code>null</code> if a matching legal details could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<LegalDetails> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the legal detailses before and after the current legal details in the ordered set where companyId = &#63;.
     *
     * @param legalDetailsId the primary key of the current legal details
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next legal details
     * @throws de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException if a legal details with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LegalDetails[] findByc_PrevAndNext(long legalDetailsId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchLegalDetailsException, SystemException {
        LegalDetails legalDetails = findByPrimaryKey(legalDetailsId);

        Session session = null;

        try {
            session = openSession();

            LegalDetails[] array = new LegalDetailsImpl[3];

            array[0] = getByc_PrevAndNext(session, legalDetails, companyId,
                    orderByComparator, true);

            array[1] = legalDetails;

            array[2] = getByc_PrevAndNext(session, legalDetails, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LegalDetails getByc_PrevAndNext(Session session,
        LegalDetails legalDetails, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LEGALDETAILS_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(legalDetails);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LegalDetails> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the legal detailses.
     *
     * @return the legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the legal detailses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of legal detailses
     * @param end the upper bound of the range of legal detailses (not inclusive)
     * @return the range of legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the legal detailses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of legal detailses
     * @param end the upper bound of the range of legal detailses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of legal detailses
     * @throws SystemException if a system exception occurred
     */
    public List<LegalDetails> findAll(int start, int end,
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

        List<LegalDetails> list = (List<LegalDetails>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LEGALDETAILS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LEGALDETAILS;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LegalDetails>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LegalDetails>) QueryUtil.list(q, getDialect(),
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
     * Removes all the legal detailses where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (LegalDetails legalDetails : findByc(companyId)) {
            remove(legalDetails);
        }
    }

    /**
     * Removes all the legal detailses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LegalDetails legalDetails : findAll()) {
            remove(legalDetails);
        }
    }

    /**
     * Returns the number of legal detailses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching legal detailses
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LEGALDETAILS_WHERE);

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
     * Returns the number of legal detailses.
     *
     * @return the number of legal detailses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LEGALDETAILS);

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
     * Initializes the legal details persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.LegalDetails")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LegalDetails>> listenersList = new ArrayList<ModelListener<LegalDetails>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LegalDetails>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LegalDetailsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
