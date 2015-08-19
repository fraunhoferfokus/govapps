package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LanguagePersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.NoSuchLanguageException;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.impl.LanguageImpl;
import de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl;
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
 * The persistence implementation for the language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LanguagePersistence
 * @see LanguageUtil
 * @generated
 */
public class LanguagePersistenceImpl extends BasePersistenceImpl<Language>
    implements LanguagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LanguageUtil} to access the language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LanguageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            LanguageModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_LANGUAGENAME = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBylanguageName",
            new String[] { String.class.getName() },
            LanguageModelImpl.LANGUAGENAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGENAME = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylanguageName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_APPLICATIONS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl.class,
            LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "getApplications",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_APPLICATIONS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_APPLICATIONS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            Long.class,
            LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "getApplicationsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_APPLICATIONS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_APPLICATION = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            LanguageModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            Boolean.class,
            LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "containsApplication",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_LANGUAGE = "SELECT language FROM Language language";
    private static final String _SQL_SELECT_LANGUAGE_WHERE = "SELECT language FROM Language language WHERE ";
    private static final String _SQL_COUNT_LANGUAGE = "SELECT COUNT(language) FROM Language language";
    private static final String _SQL_COUNT_LANGUAGE_WHERE = "SELECT COUNT(language) FROM Language language WHERE ";
    private static final String _SQL_GETAPPLICATIONS = "SELECT {mvp_Application.*} FROM mvp_Application INNER JOIN mvp_Application_Language ON (mvp_Application_Language.applicationId = mvp_Application.applicationId) WHERE (mvp_Application_Language.LanguageId = ?)";
    private static final String _SQL_GETAPPLICATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Language WHERE LanguageId = ?";
    private static final String _SQL_CONTAINSAPPLICATION = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Language WHERE LanguageId = ? AND applicationId = ?";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "language.companyId = ?";
    private static final String _FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_1 = "language.languageName IS NULL";
    private static final String _FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_2 = "language.languageName = ?";
    private static final String _FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_3 = "(language.languageName IS NULL OR language.languageName = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "language.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Language exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Language exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LanguagePersistenceImpl.class);
    private static Language _nullLanguage = new LanguageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Language> toCacheModel() {
                return _nullLanguageCacheModel;
            }
        };

    private static CacheModel<Language> _nullLanguageCacheModel = new CacheModel<Language>() {
            public Language toEntityModel() {
                return _nullLanguage;
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
     * Caches the language in the entity cache if it is enabled.
     *
     * @param language the language
     */
    public void cacheResult(Language language) {
        EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageImpl.class, language.getPrimaryKey(), language);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
            new Object[] { language.getLanguageName() }, language);

        language.resetOriginalValues();
    }

    /**
     * Caches the languages in the entity cache if it is enabled.
     *
     * @param languages the languages
     */
    public void cacheResult(List<Language> languages) {
        for (Language language : languages) {
            if (EntityCacheUtil.getResult(
                        LanguageModelImpl.ENTITY_CACHE_ENABLED,
                        LanguageImpl.class, language.getPrimaryKey()) == null) {
                cacheResult(language);
            } else {
                language.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all languages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LanguageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LanguageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the language.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Language language) {
        EntityCacheUtil.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageImpl.class, language.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(language);
    }

    @Override
    public void clearCache(List<Language> languages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Language language : languages) {
            EntityCacheUtil.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
                LanguageImpl.class, language.getPrimaryKey());

            clearUniqueFindersCache(language);
        }
    }

    protected void clearUniqueFindersCache(Language language) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
            new Object[] { language.getLanguageName() });
    }

    /**
     * Creates a new language with the primary key. Does not add the language to the database.
     *
     * @param LanguageId the primary key for the new language
     * @return the new language
     */
    public Language create(long LanguageId) {
        Language language = new LanguageImpl();

        language.setNew(true);
        language.setPrimaryKey(LanguageId);

        return language;
    }

    /**
     * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param LanguageId the primary key of the language
     * @return the language that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language remove(long LanguageId)
        throws NoSuchLanguageException, SystemException {
        return remove(Long.valueOf(LanguageId));
    }

    /**
     * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the language
     * @return the language that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Language remove(Serializable primaryKey)
        throws NoSuchLanguageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Language language = (Language) session.get(LanguageImpl.class,
                    primaryKey);

            if (language == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(language);
        } catch (NoSuchLanguageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Language removeImpl(Language language) throws SystemException {
        language = toUnwrappedModel(language);

        try {
            clearApplications.clear(language.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, language);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(language);

        return language;
    }

    @Override
    public Language updateImpl(
        de.fraunhofer.fokus.movepla.model.Language language, boolean merge)
        throws SystemException {
        language = toUnwrappedModel(language);

        boolean isNew = language.isNew();

        LanguageModelImpl languageModelImpl = (LanguageModelImpl) language;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, language, merge);

            language.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LanguageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((languageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(languageModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(languageModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
            LanguageImpl.class, language.getPrimaryKey(), language);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                new Object[] { language.getLanguageName() }, language);
        } else {
            if ((languageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_LANGUAGENAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        languageModelImpl.getOriginalLanguageName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGENAME,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                    new Object[] { language.getLanguageName() }, language);
            }
        }

        return language;
    }

    protected Language toUnwrappedModel(Language language) {
        if (language instanceof LanguageImpl) {
            return language;
        }

        LanguageImpl languageImpl = new LanguageImpl();

        languageImpl.setNew(language.isNew());
        languageImpl.setPrimaryKey(language.getPrimaryKey());

        languageImpl.setLanguageId(language.getLanguageId());
        languageImpl.setCompanyId(language.getCompanyId());
        languageImpl.setUserId(language.getUserId());
        languageImpl.setCreateDate(language.getCreateDate());
        languageImpl.setModifiedDate(language.getModifiedDate());
        languageImpl.setLanguageName(language.getLanguageName());
        languageImpl.setLanguageAbbreviation(language.getLanguageAbbreviation());

        return languageImpl;
    }

    /**
     * Returns the language with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the language
     * @return the language
     * @throws com.liferay.portal.NoSuchModelException if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Language findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the language with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
     *
     * @param LanguageId the primary key of the language
     * @return the language
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language findByPrimaryKey(long LanguageId)
        throws NoSuchLanguageException, SystemException {
        Language language = fetchByPrimaryKey(LanguageId);

        if (language == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + LanguageId);
            }

            throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                LanguageId);
        }

        return language;
    }

    /**
     * Returns the language with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the language
     * @return the language, or <code>null</code> if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Language fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the language with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param LanguageId the primary key of the language
     * @return the language, or <code>null</code> if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language fetchByPrimaryKey(long LanguageId)
        throws SystemException {
        Language language = (Language) EntityCacheUtil.getResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
                LanguageImpl.class, LanguageId);

        if (language == _nullLanguage) {
            return null;
        }

        if (language == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                language = (Language) session.get(LanguageImpl.class,
                        Long.valueOf(LanguageId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (language != null) {
                    cacheResult(language);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
                        LanguageImpl.class, LanguageId, _nullLanguage);
                }

                closeSession(session);
            }
        }

        return language;
    }

    /**
     * Returns all the languages where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the languages where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @return the range of matching languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the languages where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findByc(long companyId, int start, int end,
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

        List<Language> list = (List<Language>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Language language : list) {
                if ((companyId != language.getCompanyId())) {
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

            query.append(_SQL_SELECT_LANGUAGE_WHERE);

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

                list = (List<Language>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first language in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching language
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLanguageException, SystemException {
        Language language = fetchByc_First(companyId, orderByComparator);

        if (language != null) {
            return language;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLanguageException(msg.toString());
    }

    /**
     * Returns the first language in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching language, or <code>null</code> if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Language> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last language in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching language
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLanguageException, SystemException {
        Language language = fetchByc_Last(companyId, orderByComparator);

        if (language != null) {
            return language;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLanguageException(msg.toString());
    }

    /**
     * Returns the last language in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching language, or <code>null</code> if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Language> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the languages before and after the current language in the ordered set where companyId = &#63;.
     *
     * @param LanguageId the primary key of the current language
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next language
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language[] findByc_PrevAndNext(long LanguageId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchLanguageException, SystemException {
        Language language = findByPrimaryKey(LanguageId);

        Session session = null;

        try {
            session = openSession();

            Language[] array = new LanguageImpl[3];

            array[0] = getByc_PrevAndNext(session, language, companyId,
                    orderByComparator, true);

            array[1] = language;

            array[2] = getByc_PrevAndNext(session, language, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Language getByc_PrevAndNext(Session session, Language language,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LANGUAGE_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(language);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Language> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the language where languageName = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
     *
     * @param languageName the language name
     * @return the matching language
     * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language findBylanguageName(String languageName)
        throws NoSuchLanguageException, SystemException {
        Language language = fetchBylanguageName(languageName);

        if (language == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("languageName=");
            msg.append(languageName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLanguageException(msg.toString());
        }

        return language;
    }

    /**
     * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param languageName the language name
     * @return the matching language, or <code>null</code> if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language fetchBylanguageName(String languageName)
        throws SystemException {
        return fetchBylanguageName(languageName, true);
    }

    /**
     * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param languageName the language name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching language, or <code>null</code> if a matching language could not be found
     * @throws SystemException if a system exception occurred
     */
    public Language fetchBylanguageName(String languageName,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { languageName };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                    finderArgs, this);
        }

        if (result instanceof Language) {
            Language language = (Language) result;

            if (!Validator.equals(languageName, language.getLanguageName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LANGUAGE_WHERE);

            if (languageName == null) {
                query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_1);
            } else {
                if (languageName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_3);
                } else {
                    query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (languageName != null) {
                    qPos.add(languageName);
                }

                List<Language> list = q.list();

                result = list;

                Language language = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                        finderArgs, list);
                } else {
                    language = list.get(0);

                    cacheResult(language);

                    if ((language.getLanguageName() == null) ||
                            !language.getLanguageName().equals(languageName)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                            finderArgs, language);
                    }
                }

                return language;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LANGUAGENAME,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Language) result;
            }
        }
    }

    /**
     * Returns all the languages.
     *
     * @return the languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the languages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @return the range of languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the languages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of languages
     * @throws SystemException if a system exception occurred
     */
    public List<Language> findAll(int start, int end,
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

        List<Language> list = (List<Language>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LANGUAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LANGUAGE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Language>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Language>) QueryUtil.list(q, getDialect(),
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
     * Removes all the languages where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Language language : findByc(companyId)) {
            remove(language);
        }
    }

    /**
     * Removes the language where languageName = &#63; from the database.
     *
     * @param languageName the language name
     * @return the language that was removed
     * @throws SystemException if a system exception occurred
     */
    public Language removeBylanguageName(String languageName)
        throws NoSuchLanguageException, SystemException {
        Language language = findBylanguageName(languageName);

        return remove(language);
    }

    /**
     * Removes all the languages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Language language : findAll()) {
            remove(language);
        }
    }

    /**
     * Returns the number of languages where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching languages
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LANGUAGE_WHERE);

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
     * Returns the number of languages where languageName = &#63;.
     *
     * @param languageName the language name
     * @return the number of matching languages
     * @throws SystemException if a system exception occurred
     */
    public int countBylanguageName(String languageName)
        throws SystemException {
        Object[] finderArgs = new Object[] { languageName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LANGUAGENAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LANGUAGE_WHERE);

            if (languageName == null) {
                query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_1);
            } else {
                if (languageName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_3);
                } else {
                    query.append(_FINDER_COLUMN_LANGUAGENAME_LANGUAGENAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (languageName != null) {
                    qPos.add(languageName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LANGUAGENAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of languages.
     *
     * @return the number of languages
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LANGUAGE);

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
     * Returns all the applications associated with the language.
     *
     * @param pk the primary key of the language
     * @return the applications associated with the language
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws SystemException {
        return getApplications(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the applications associated with the language.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the language
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @return the range of applications associated with the language
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end) throws SystemException {
        return getApplications(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications associated with the language.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the language
     * @param start the lower bound of the range of languages
     * @param end the upper bound of the range of languages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applications associated with the language
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
     * Returns the number of applications associated with the language.
     *
     * @param pk the primary key of the language
     * @return the number of applications associated with the language
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
     * Returns <code>true</code> if the application is associated with the language.
     *
     * @param pk the primary key of the language
     * @param applicationPK the primary key of the application
     * @return <code>true</code> if the application is associated with the language; <code>false</code> otherwise
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
     * Returns <code>true</code> if the language has any applications associated with it.
     *
     * @param pk the primary key of the language to check for associations with applications
     * @return <code>true</code> if the language has any applications associated with it; <code>false</code> otherwise
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
     * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Clears all associations between the language and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language to clear the associated applications from
     * @throws SystemException if a system exception occurred
     */
    public void clearApplications(long pk) throws SystemException {
        try {
            clearApplications.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
     * @param applicationPKs the primary keys of the applications to be associated with the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the language
     * @param applications the applications to be associated with the language
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
            FinderCacheUtil.clearCache(LanguageModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Initializes the language persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Language")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Language>> listenersList = new ArrayList<ModelListener<Language>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Language>) InstanceFactory.newInstance(
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
        EntityCacheUtil.removeCache(LanguageImpl.class.getName());
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

        protected boolean contains(long LanguageId, long applicationId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(LanguageId), new Long(applicationId)
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
                    "INSERT INTO mvp_Application_Language (LanguageId, applicationId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long LanguageId, long applicationId)
            throws SystemException {
            if (!containsApplication.contains(LanguageId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Language> listener : listeners) {
                    listener.onBeforeAddAssociation(LanguageId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        Language.class.getName(), LanguageId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(LanguageId), new Long(applicationId)
                    });

                for (ModelListener<Language> listener : listeners) {
                    listener.onAfterAddAssociation(LanguageId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterAddAssociation(applicationId,
                        Language.class.getName(), LanguageId);
                }
            }
        }
    }

    protected class ClearApplications {
        private SqlUpdate _sqlUpdate;

        protected ClearApplications() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Language WHERE LanguageId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long LanguageId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                applicationPersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Application> applications = null;

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                applications = getApplications(LanguageId);

                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Language> listener : listeners) {
                        listener.onBeforeRemoveAssociation(LanguageId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onBeforeRemoveAssociation(application.getPrimaryKey(),
                            Language.class.getName(), LanguageId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(LanguageId) });

            if ((listeners.length > 0) || (applicationListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Application application : applications) {
                    for (ModelListener<Language> listener : listeners) {
                        listener.onAfterRemoveAssociation(LanguageId,
                            de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                            application.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                        listener.onAfterRemoveAssociation(application.getPrimaryKey(),
                            Language.class.getName(), LanguageId);
                    }
                }
            }
        }
    }

    protected class RemoveApplication {
        private SqlUpdate _sqlUpdate;

        protected RemoveApplication() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Language WHERE LanguageId = ? AND applicationId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long LanguageId, long applicationId)
            throws SystemException {
            if (containsApplication.contains(LanguageId, applicationId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Application>[] applicationListeners =
                    applicationPersistence.getListeners();

                for (ModelListener<Language> listener : listeners) {
                    listener.onBeforeRemoveAssociation(LanguageId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        Language.class.getName(), LanguageId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(LanguageId), new Long(applicationId)
                    });

                for (ModelListener<Language> listener : listeners) {
                    listener.onAfterRemoveAssociation(LanguageId,
                        de.fraunhofer.fokus.movepla.model.Application.class.getName(),
                        applicationId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Application> listener : applicationListeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        Language.class.getName(), LanguageId);
                }
            }
        }
    }
}
