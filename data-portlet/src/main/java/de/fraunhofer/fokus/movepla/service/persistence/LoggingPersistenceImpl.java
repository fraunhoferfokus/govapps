package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LoggingPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.movepla.NoSuchLoggingException;
import de.fraunhofer.fokus.movepla.model.Logging;
import de.fraunhofer.fokus.movepla.model.impl.LoggingImpl;
import de.fraunhofer.fokus.movepla.model.impl.LoggingModelImpl;
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
 * The persistence implementation for the logging service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LoggingPersistence
 * @see LoggingUtil
 * @generated
 */
public class LoggingPersistenceImpl extends BasePersistenceImpl<Logging>
    implements LoggingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LoggingUtil} to access the logging persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LoggingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByall",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName(), Integer.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByall",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName(), Integer.class.getName(),
                String.class.getName()
            },
            LoggingModelImpl.SEARCHSTRING_COLUMN_BITMASK |
            LoggingModelImpl.CATEGORYIDSTRING_COLUMN_BITMASK |
            LoggingModelImpl.REGIONIDSTRING_COLUMN_BITMASK |
            LoggingModelImpl.ENTITLEMENTIDSTRING_COLUMN_BITMASK |
            LoggingModelImpl.TARGETOS_COLUMN_BITMASK |
            LoggingModelImpl.FEE_COLUMN_BITMASK |
            LoggingModelImpl.TARGETCATEGORY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByall",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                String.class.getName(), Integer.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchString",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchString",
            new String[] { String.class.getName() },
            LoggingModelImpl.SEARCHSTRING_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHSTRING = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchString",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycategoryIDString",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBycategoryIDString", new String[] { String.class.getName() },
            LoggingModelImpl.CATEGORYIDSTRING_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYIDSTRING = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBycategoryIDString", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByregionIDString",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByregionIDString",
            new String[] { String.class.getName() },
            LoggingModelImpl.REGIONIDSTRING_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REGIONIDSTRING = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregionIDString",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByregionentitlementIDStringIDString",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByregionentitlementIDStringIDString",
            new String[] { String.class.getName() },
            LoggingModelImpl.ENTITLEMENTIDSTRING_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REGIONENTITLEMENTIDSTRINGIDSTRING =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByregionentitlementIDStringIDString",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETOS = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytargetOS",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETOS =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytargetOS",
            new String[] { String.class.getName() },
            LoggingModelImpl.TARGETOS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TARGETOS = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytargetOS",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FEE = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfee",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEE = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfee",
            new String[] { Integer.class.getName() },
            LoggingModelImpl.FEE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FEE = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfee",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETCATEGORY =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytargetCategory",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCATEGORY =
        new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytargetCategory",
            new String[] { String.class.getName() },
            LoggingModelImpl.TARGETCATEGORY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TARGETCATEGORY = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytargetCategory",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PASSEL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypassel",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PASSEL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBypassel",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, LoggingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LOGGING = "SELECT logging FROM Logging logging";
    private static final String _SQL_SELECT_LOGGING_WHERE = "SELECT logging FROM Logging logging WHERE ";
    private static final String _SQL_COUNT_LOGGING = "SELECT COUNT(logging) FROM Logging logging";
    private static final String _SQL_COUNT_LOGGING_WHERE = "SELECT COUNT(logging) FROM Logging logging WHERE ";
    private static final String _FINDER_COLUMN_ALL_SEARCHSTRING_1 = "logging.searchString IS NULL AND ";
    private static final String _FINDER_COLUMN_ALL_SEARCHSTRING_2 = "logging.searchString = ? AND ";
    private static final String _FINDER_COLUMN_ALL_SEARCHSTRING_3 = "(logging.searchString IS NULL OR logging.searchString = ?) AND ";
    private static final String _FINDER_COLUMN_ALL_CATEGORYIDSTRING_1 = "logging.categoryIDString IS NULL AND ";
    private static final String _FINDER_COLUMN_ALL_CATEGORYIDSTRING_2 = "logging.categoryIDString = ? AND ";
    private static final String _FINDER_COLUMN_ALL_CATEGORYIDSTRING_3 = "(logging.categoryIDString IS NULL OR logging.categoryIDString = ?) AND ";
    private static final String _FINDER_COLUMN_ALL_REGIONIDSTRING_1 = "logging.regionIDString IS NULL AND ";
    private static final String _FINDER_COLUMN_ALL_REGIONIDSTRING_2 = "logging.regionIDString = ? AND ";
    private static final String _FINDER_COLUMN_ALL_REGIONIDSTRING_3 = "(logging.regionIDString IS NULL OR logging.regionIDString = ?) AND ";
    private static final String _FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_1 = "logging.entitlementIDString IS NULL AND ";
    private static final String _FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_2 = "logging.entitlementIDString = ? AND ";
    private static final String _FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_3 = "(logging.entitlementIDString IS NULL OR logging.entitlementIDString = ?) AND ";
    private static final String _FINDER_COLUMN_ALL_TARGETOS_1 = "logging.targetOS IS NULL AND ";
    private static final String _FINDER_COLUMN_ALL_TARGETOS_2 = "logging.targetOS = ? AND ";
    private static final String _FINDER_COLUMN_ALL_TARGETOS_3 = "(logging.targetOS IS NULL OR logging.targetOS = ?) AND ";
    private static final String _FINDER_COLUMN_ALL_FEE_2 = "logging.fee = ? AND ";
    private static final String _FINDER_COLUMN_ALL_TARGETCATEGORY_1 = "logging.targetCategory IS NULL";
    private static final String _FINDER_COLUMN_ALL_TARGETCATEGORY_2 = "logging.targetCategory = ?";
    private static final String _FINDER_COLUMN_ALL_TARGETCATEGORY_3 = "(logging.targetCategory IS NULL OR logging.targetCategory = ?)";
    private static final String _FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_1 = "logging.searchString IS NULL";
    private static final String _FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_2 = "logging.searchString = ?";
    private static final String _FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_3 = "(logging.searchString IS NULL OR logging.searchString = ?)";
    private static final String _FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_1 =
        "logging.categoryIDString IS NULL";
    private static final String _FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_2 =
        "logging.categoryIDString = ?";
    private static final String _FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_3 =
        "(logging.categoryIDString IS NULL OR logging.categoryIDString = ?)";
    private static final String _FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_1 = "logging.regionIDString IS NULL";
    private static final String _FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_2 = "logging.regionIDString = ?";
    private static final String _FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_3 = "(logging.regionIDString IS NULL OR logging.regionIDString = ?)";
    private static final String _FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_1 =
        "logging.entitlementIDString IS NULL";
    private static final String _FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_2 =
        "logging.entitlementIDString = ?";
    private static final String _FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_3 =
        "(logging.entitlementIDString IS NULL OR logging.entitlementIDString = ?)";
    private static final String _FINDER_COLUMN_TARGETOS_TARGETOS_1 = "logging.targetOS IS NULL";
    private static final String _FINDER_COLUMN_TARGETOS_TARGETOS_2 = "logging.targetOS = ?";
    private static final String _FINDER_COLUMN_TARGETOS_TARGETOS_3 = "(logging.targetOS IS NULL OR logging.targetOS = ?)";
    private static final String _FINDER_COLUMN_FEE_FEE_2 = "logging.fee = ?";
    private static final String _FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_1 = "logging.targetCategory IS NULL";
    private static final String _FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_2 = "logging.targetCategory = ?";
    private static final String _FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_3 = "(logging.targetCategory IS NULL OR logging.targetCategory = ?)";
    private static final String _FINDER_COLUMN_PASSEL_PASSEL_2 = "logging.passel >= ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "logging.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Logging exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Logging exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LoggingPersistenceImpl.class);
    private static Logging _nullLogging = new LoggingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Logging> toCacheModel() {
                return _nullLoggingCacheModel;
            }
        };

    private static CacheModel<Logging> _nullLoggingCacheModel = new CacheModel<Logging>() {
            public Logging toEntityModel() {
                return _nullLogging;
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
     * Caches the logging in the entity cache if it is enabled.
     *
     * @param logging the logging
     */
    public void cacheResult(Logging logging) {
        EntityCacheUtil.putResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingImpl.class, logging.getPrimaryKey(), logging);

        logging.resetOriginalValues();
    }

    /**
     * Caches the loggings in the entity cache if it is enabled.
     *
     * @param loggings the loggings
     */
    public void cacheResult(List<Logging> loggings) {
        for (Logging logging : loggings) {
            if (EntityCacheUtil.getResult(
                        LoggingModelImpl.ENTITY_CACHE_ENABLED,
                        LoggingImpl.class, logging.getPrimaryKey()) == null) {
                cacheResult(logging);
            } else {
                logging.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all loggings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LoggingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LoggingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the logging.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Logging logging) {
        EntityCacheUtil.removeResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingImpl.class, logging.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Logging> loggings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Logging logging : loggings) {
            EntityCacheUtil.removeResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
                LoggingImpl.class, logging.getPrimaryKey());
        }
    }

    /**
     * Creates a new logging with the primary key. Does not add the logging to the database.
     *
     * @param loggingId the primary key for the new logging
     * @return the new logging
     */
    public Logging create(long loggingId) {
        Logging logging = new LoggingImpl();

        logging.setNew(true);
        logging.setPrimaryKey(loggingId);

        return logging;
    }

    /**
     * Removes the logging with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param loggingId the primary key of the logging
     * @return the logging that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging remove(long loggingId)
        throws NoSuchLoggingException, SystemException {
        return remove(Long.valueOf(loggingId));
    }

    /**
     * Removes the logging with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the logging
     * @return the logging that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Logging remove(Serializable primaryKey)
        throws NoSuchLoggingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Logging logging = (Logging) session.get(LoggingImpl.class,
                    primaryKey);

            if (logging == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLoggingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(logging);
        } catch (NoSuchLoggingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Logging removeImpl(Logging logging) throws SystemException {
        logging = toUnwrappedModel(logging);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, logging);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(logging);

        return logging;
    }

    @Override
    public Logging updateImpl(
        de.fraunhofer.fokus.movepla.model.Logging logging, boolean merge)
        throws SystemException {
        logging = toUnwrappedModel(logging);

        boolean isNew = logging.isNew();

        LoggingModelImpl loggingModelImpl = (LoggingModelImpl) logging;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, logging, merge);

            logging.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LoggingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalSearchString(),
                        
                        loggingModelImpl.getOriginalCategoryIDString(),
                        
                        loggingModelImpl.getOriginalRegionIDString(),
                        
                        loggingModelImpl.getOriginalEntitlementIDString(),
                        
                        loggingModelImpl.getOriginalTargetOS(),
                        Integer.valueOf(loggingModelImpl.getOriginalFee()),
                        
                        loggingModelImpl.getOriginalTargetCategory()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALL,
                    args);

                args = new Object[] {
                        loggingModelImpl.getSearchString(),
                        
                        loggingModelImpl.getCategoryIDString(),
                        
                        loggingModelImpl.getRegionIDString(),
                        
                        loggingModelImpl.getEntitlementIDString(),
                        
                        loggingModelImpl.getTargetOS(),
                        Integer.valueOf(loggingModelImpl.getFee()),
                        
                        loggingModelImpl.getTargetCategory()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALL,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHSTRING.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalSearchString()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHSTRING,
                    args);

                args = new Object[] { loggingModelImpl.getSearchString() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHSTRING,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDSTRING.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalCategoryIDString()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDSTRING,
                    args);

                args = new Object[] { loggingModelImpl.getCategoryIDString() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDSTRING,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONIDSTRING.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalRegionIDString()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONIDSTRING,
                    args);

                args = new Object[] { loggingModelImpl.getRegionIDString() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONIDSTRING,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalEntitlementIDString()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                    args);

                args = new Object[] { loggingModelImpl.getEntitlementIDString() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETOS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalTargetOS()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETOS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETOS,
                    args);

                args = new Object[] { loggingModelImpl.getTargetOS() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETOS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETOS,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Integer.valueOf(loggingModelImpl.getOriginalFee())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEE,
                    args);

                args = new Object[] { Integer.valueOf(loggingModelImpl.getFee()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEE,
                    args);
            }

            if ((loggingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCATEGORY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        loggingModelImpl.getOriginalTargetCategory()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCATEGORY,
                    args);

                args = new Object[] { loggingModelImpl.getTargetCategory() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCATEGORY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
            LoggingImpl.class, logging.getPrimaryKey(), logging);

        return logging;
    }

    protected Logging toUnwrappedModel(Logging logging) {
        if (logging instanceof LoggingImpl) {
            return logging;
        }

        LoggingImpl loggingImpl = new LoggingImpl();

        loggingImpl.setNew(logging.isNew());
        loggingImpl.setPrimaryKey(logging.getPrimaryKey());

        loggingImpl.setLoggingId(logging.getLoggingId());
        loggingImpl.setCreateDate(logging.getCreateDate());
        loggingImpl.setModifiedDate(logging.getModifiedDate());
        loggingImpl.setIsSimpleSearch(logging.getIsSimpleSearch());
        loggingImpl.setSearchString(logging.getSearchString());
        loggingImpl.setCategoryIDString(logging.getCategoryIDString());
        loggingImpl.setRegionIDString(logging.getRegionIDString());
        loggingImpl.setEntitlementIDString(logging.getEntitlementIDString());
        loggingImpl.setTargetOS(logging.getTargetOS());
        loggingImpl.setFee(logging.getFee());
        loggingImpl.setTargetCategory(logging.getTargetCategory());
        loggingImpl.setPassel(logging.getPassel());

        return loggingImpl;
    }

    /**
     * Returns the logging with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the logging
     * @return the logging
     * @throws com.liferay.portal.NoSuchModelException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Logging findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the logging with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLoggingException} if it could not be found.
     *
     * @param loggingId the primary key of the logging
     * @return the logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByPrimaryKey(long loggingId)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByPrimaryKey(loggingId);

        if (logging == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + loggingId);
            }

            throw new NoSuchLoggingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                loggingId);
        }

        return logging;
    }

    /**
     * Returns the logging with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the logging
     * @return the logging, or <code>null</code> if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Logging fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the logging with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param loggingId the primary key of the logging
     * @return the logging, or <code>null</code> if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByPrimaryKey(long loggingId) throws SystemException {
        Logging logging = (Logging) EntityCacheUtil.getResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
                LoggingImpl.class, loggingId);

        if (logging == _nullLogging) {
            return null;
        }

        if (logging == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                logging = (Logging) session.get(LoggingImpl.class,
                        Long.valueOf(loggingId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (logging != null) {
                    cacheResult(logging);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LoggingModelImpl.ENTITY_CACHE_ENABLED,
                        LoggingImpl.class, loggingId, _nullLogging);
                }

                closeSession(session);
            }
        }

        return logging;
    }

    /**
     * Returns all the loggings where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByall(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory) throws SystemException {
        return findByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByall(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, int start, int end) throws SystemException {
        return findByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByall(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALL;
            finderArgs = new Object[] {
                    searchString, categoryIDString, regionIDString,
                    entitlementIDString, targetOS, fee, targetCategory
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALL;
            finderArgs = new Object[] {
                    searchString, categoryIDString, regionIDString,
                    entitlementIDString, targetOS, fee, targetCategory,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(searchString, logging.getSearchString()) ||
                        !Validator.equals(categoryIDString,
                            logging.getCategoryIDString()) ||
                        !Validator.equals(regionIDString,
                            logging.getRegionIDString()) ||
                        !Validator.equals(entitlementIDString,
                            logging.getEntitlementIDString()) ||
                        !Validator.equals(targetOS, logging.getTargetOS()) ||
                        (fee != logging.getFee()) ||
                        !Validator.equals(targetCategory,
                            logging.getTargetCategory())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(9 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(8);
            }

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (searchString == null) {
                query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_1);
            } else {
                if (searchString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_2);
                }
            }

            if (categoryIDString == null) {
                query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_1);
            } else {
                if (categoryIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_2);
                }
            }

            if (regionIDString == null) {
                query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_1);
            } else {
                if (regionIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_2);
                }
            }

            if (entitlementIDString == null) {
                query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_1);
            } else {
                if (entitlementIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_2);
                }
            }

            if (targetOS == null) {
                query.append(_FINDER_COLUMN_ALL_TARGETOS_1);
            } else {
                if (targetOS.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_TARGETOS_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_TARGETOS_2);
                }
            }

            query.append(_FINDER_COLUMN_ALL_FEE_2);

            if (targetCategory == null) {
                query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_1);
            } else {
                if (targetCategory.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_2);
                }
            }

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

                if (searchString != null) {
                    qPos.add(searchString);
                }

                if (categoryIDString != null) {
                    qPos.add(categoryIDString);
                }

                if (regionIDString != null) {
                    qPos.add(regionIDString);
                }

                if (entitlementIDString != null) {
                    qPos.add(entitlementIDString);
                }

                if (targetOS != null) {
                    qPos.add(targetOS);
                }

                qPos.add(fee);

                if (targetCategory != null) {
                    qPos.add(targetCategory);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByall_First(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByall_First(searchString, categoryIDString,
                regionIDString, entitlementIDString, targetOS, fee,
                targetCategory, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(16);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchString=");
        msg.append(searchString);

        msg.append(", categoryIDString=");
        msg.append(categoryIDString);

        msg.append(", regionIDString=");
        msg.append(regionIDString);

        msg.append(", entitlementIDString=");
        msg.append(entitlementIDString);

        msg.append(", targetOS=");
        msg.append(targetOS);

        msg.append(", fee=");
        msg.append(fee);

        msg.append(", targetCategory=");
        msg.append(targetCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByall_First(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, OrderByComparator orderByComparator)
        throws SystemException {
        List<Logging> list = findByall(searchString, categoryIDString,
                regionIDString, entitlementIDString, targetOS, fee,
                targetCategory, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByall_Last(String searchString, String categoryIDString,
        String regionIDString, String entitlementIDString, String targetOS,
        int fee, String targetCategory, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByall_Last(searchString, categoryIDString,
                regionIDString, entitlementIDString, targetOS, fee,
                targetCategory, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(16);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchString=");
        msg.append(searchString);

        msg.append(", categoryIDString=");
        msg.append(categoryIDString);

        msg.append(", regionIDString=");
        msg.append(regionIDString);

        msg.append(", entitlementIDString=");
        msg.append(entitlementIDString);

        msg.append(", targetOS=");
        msg.append(targetOS);

        msg.append(", fee=");
        msg.append(fee);

        msg.append(", targetCategory=");
        msg.append(targetCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByall_Last(String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByall(searchString, categoryIDString, regionIDString,
                entitlementIDString, targetOS, fee, targetCategory);

        List<Logging> list = findByall(searchString, categoryIDString,
                regionIDString, entitlementIDString, targetOS, fee,
                targetCategory, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findByall_PrevAndNext(long loggingId, String searchString,
        String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getByall_PrevAndNext(session, logging, searchString,
                    categoryIDString, regionIDString, entitlementIDString,
                    targetOS, fee, targetCategory, orderByComparator, true);

            array[1] = logging;

            array[2] = getByall_PrevAndNext(session, logging, searchString,
                    categoryIDString, regionIDString, entitlementIDString,
                    targetOS, fee, targetCategory, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getByall_PrevAndNext(Session session, Logging logging,
        String searchString, String categoryIDString, String regionIDString,
        String entitlementIDString, String targetOS, int fee,
        String targetCategory, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (searchString == null) {
            query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_1);
        } else {
            if (searchString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_2);
            }
        }

        if (categoryIDString == null) {
            query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_1);
        } else {
            if (categoryIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_2);
            }
        }

        if (regionIDString == null) {
            query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_1);
        } else {
            if (regionIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_2);
            }
        }

        if (entitlementIDString == null) {
            query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_1);
        } else {
            if (entitlementIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_2);
            }
        }

        if (targetOS == null) {
            query.append(_FINDER_COLUMN_ALL_TARGETOS_1);
        } else {
            if (targetOS.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_TARGETOS_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_TARGETOS_2);
            }
        }

        query.append(_FINDER_COLUMN_ALL_FEE_2);

        if (targetCategory == null) {
            query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_1);
        } else {
            if (targetCategory.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_3);
            } else {
                query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_2);
            }
        }

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

        if (searchString != null) {
            qPos.add(searchString);
        }

        if (categoryIDString != null) {
            qPos.add(categoryIDString);
        }

        if (regionIDString != null) {
            qPos.add(regionIDString);
        }

        if (entitlementIDString != null) {
            qPos.add(entitlementIDString);
        }

        if (targetOS != null) {
            qPos.add(targetOS);
        }

        qPos.add(fee);

        if (targetCategory != null) {
            qPos.add(targetCategory);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where searchString = &#63;.
     *
     * @param searchString the search string
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBysearchString(String searchString)
        throws SystemException {
        return findBysearchString(searchString, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where searchString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param searchString the search string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBysearchString(String searchString, int start,
        int end) throws SystemException {
        return findBysearchString(searchString, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where searchString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param searchString the search string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBysearchString(String searchString, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHSTRING;
            finderArgs = new Object[] { searchString };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHSTRING;
            finderArgs = new Object[] {
                    searchString,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(searchString, logging.getSearchString())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (searchString == null) {
                query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_1);
            } else {
                if (searchString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_2);
                }
            }

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

                if (searchString != null) {
                    qPos.add(searchString);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where searchString = &#63;.
     *
     * @param searchString the search string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBysearchString_First(String searchString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBysearchString_First(searchString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchString=");
        msg.append(searchString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where searchString = &#63;.
     *
     * @param searchString the search string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBysearchString_First(String searchString,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findBysearchString(searchString, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where searchString = &#63;.
     *
     * @param searchString the search string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBysearchString_Last(String searchString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBysearchString_Last(searchString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchString=");
        msg.append(searchString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where searchString = &#63;.
     *
     * @param searchString the search string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBysearchString_Last(String searchString,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBysearchString(searchString);

        List<Logging> list = findBysearchString(searchString, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where searchString = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param searchString the search string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findBysearchString_PrevAndNext(long loggingId,
        String searchString, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getBysearchString_PrevAndNext(session, logging,
                    searchString, orderByComparator, true);

            array[1] = logging;

            array[2] = getBysearchString_PrevAndNext(session, logging,
                    searchString, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getBysearchString_PrevAndNext(Session session,
        Logging logging, String searchString,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (searchString == null) {
            query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_1);
        } else {
            if (searchString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_2);
            }
        }

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

        if (searchString != null) {
            qPos.add(searchString);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBycategoryIDString(String categoryIDString)
        throws SystemException {
        return findBycategoryIDString(categoryIDString, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where categoryIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param categoryIDString the category i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBycategoryIDString(String categoryIDString,
        int start, int end) throws SystemException {
        return findBycategoryIDString(categoryIDString, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where categoryIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param categoryIDString the category i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBycategoryIDString(String categoryIDString,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDSTRING;
            finderArgs = new Object[] { categoryIDString };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYIDSTRING;
            finderArgs = new Object[] {
                    categoryIDString,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(categoryIDString,
                            logging.getCategoryIDString())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (categoryIDString == null) {
                query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_1);
            } else {
                if (categoryIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_2);
                }
            }

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

                if (categoryIDString != null) {
                    qPos.add(categoryIDString);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBycategoryIDString_First(String categoryIDString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBycategoryIDString_First(categoryIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryIDString=");
        msg.append(categoryIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBycategoryIDString_First(String categoryIDString,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findBycategoryIDString(categoryIDString, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBycategoryIDString_Last(String categoryIDString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBycategoryIDString_Last(categoryIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryIDString=");
        msg.append(categoryIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBycategoryIDString_Last(String categoryIDString,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycategoryIDString(categoryIDString);

        List<Logging> list = findBycategoryIDString(categoryIDString,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where categoryIDString = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param categoryIDString the category i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findBycategoryIDString_PrevAndNext(long loggingId,
        String categoryIDString, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getBycategoryIDString_PrevAndNext(session, logging,
                    categoryIDString, orderByComparator, true);

            array[1] = logging;

            array[2] = getBycategoryIDString_PrevAndNext(session, logging,
                    categoryIDString, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getBycategoryIDString_PrevAndNext(Session session,
        Logging logging, String categoryIDString,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (categoryIDString == null) {
            query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_1);
        } else {
            if (categoryIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_2);
            }
        }

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

        if (categoryIDString != null) {
            qPos.add(categoryIDString);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionIDString(String regionIDString)
        throws SystemException {
        return findByregionIDString(regionIDString, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where regionIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param regionIDString the region i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionIDString(String regionIDString, int start,
        int end) throws SystemException {
        return findByregionIDString(regionIDString, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where regionIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param regionIDString the region i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionIDString(String regionIDString, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONIDSTRING;
            finderArgs = new Object[] { regionIDString };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONIDSTRING;
            finderArgs = new Object[] {
                    regionIDString,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(regionIDString,
                            logging.getRegionIDString())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (regionIDString == null) {
                query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_1);
            } else {
                if (regionIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_2);
                }
            }

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

                if (regionIDString != null) {
                    qPos.add(regionIDString);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByregionIDString_First(String regionIDString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByregionIDString_First(regionIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionIDString=");
        msg.append(regionIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByregionIDString_First(String regionIDString,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findByregionIDString(regionIDString, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByregionIDString_Last(String regionIDString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByregionIDString_Last(regionIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionIDString=");
        msg.append(regionIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByregionIDString_Last(String regionIDString,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByregionIDString(regionIDString);

        List<Logging> list = findByregionIDString(regionIDString, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where regionIDString = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param regionIDString the region i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findByregionIDString_PrevAndNext(long loggingId,
        String regionIDString, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getByregionIDString_PrevAndNext(session, logging,
                    regionIDString, orderByComparator, true);

            array[1] = logging;

            array[2] = getByregionIDString_PrevAndNext(session, logging,
                    regionIDString, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getByregionIDString_PrevAndNext(Session session,
        Logging logging, String regionIDString,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (regionIDString == null) {
            query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_1);
        } else {
            if (regionIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_2);
            }
        }

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

        if (regionIDString != null) {
            qPos.add(regionIDString);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionentitlementIDStringIDString(
        String entitlementIDString) throws SystemException {
        return findByregionentitlementIDStringIDString(entitlementIDString,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where entitlementIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param entitlementIDString the entitlement i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionentitlementIDStringIDString(
        String entitlementIDString, int start, int end)
        throws SystemException {
        return findByregionentitlementIDStringIDString(entitlementIDString,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where entitlementIDString = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param entitlementIDString the entitlement i d string
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByregionentitlementIDStringIDString(
        String entitlementIDString, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING;
            finderArgs = new Object[] { entitlementIDString };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONENTITLEMENTIDSTRINGIDSTRING;
            finderArgs = new Object[] {
                    entitlementIDString,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(entitlementIDString,
                            logging.getEntitlementIDString())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (entitlementIDString == null) {
                query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_1);
            } else {
                if (entitlementIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_2);
                }
            }

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

                if (entitlementIDString != null) {
                    qPos.add(entitlementIDString);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByregionentitlementIDStringIDString_First(
        String entitlementIDString, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByregionentitlementIDStringIDString_First(entitlementIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entitlementIDString=");
        msg.append(entitlementIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByregionentitlementIDStringIDString_First(
        String entitlementIDString, OrderByComparator orderByComparator)
        throws SystemException {
        List<Logging> list = findByregionentitlementIDStringIDString(entitlementIDString,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByregionentitlementIDStringIDString_Last(
        String entitlementIDString, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByregionentitlementIDStringIDString_Last(entitlementIDString,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entitlementIDString=");
        msg.append(entitlementIDString);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByregionentitlementIDStringIDString_Last(
        String entitlementIDString, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByregionentitlementIDStringIDString(entitlementIDString);

        List<Logging> list = findByregionentitlementIDStringIDString(entitlementIDString,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where entitlementIDString = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param entitlementIDString the entitlement i d string
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findByregionentitlementIDStringIDString_PrevAndNext(
        long loggingId, String entitlementIDString,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getByregionentitlementIDStringIDString_PrevAndNext(session,
                    logging, entitlementIDString, orderByComparator, true);

            array[1] = logging;

            array[2] = getByregionentitlementIDStringIDString_PrevAndNext(session,
                    logging, entitlementIDString, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getByregionentitlementIDStringIDString_PrevAndNext(
        Session session, Logging logging, String entitlementIDString,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (entitlementIDString == null) {
            query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_1);
        } else {
            if (entitlementIDString.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_3);
            } else {
                query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_2);
            }
        }

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

        if (entitlementIDString != null) {
            qPos.add(entitlementIDString);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetOS(String targetOS)
        throws SystemException {
        return findBytargetOS(targetOS, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the loggings where targetOS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param targetOS the target o s
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetOS(String targetOS, int start, int end)
        throws SystemException {
        return findBytargetOS(targetOS, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where targetOS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param targetOS the target o s
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetOS(String targetOS, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETOS;
            finderArgs = new Object[] { targetOS };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETOS;
            finderArgs = new Object[] { targetOS, start, end, orderByComparator };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(targetOS, logging.getTargetOS())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (targetOS == null) {
                query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_1);
            } else {
                if (targetOS.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_3);
                } else {
                    query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_2);
                }
            }

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

                if (targetOS != null) {
                    qPos.add(targetOS);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBytargetOS_First(String targetOS,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBytargetOS_First(targetOS, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("targetOS=");
        msg.append(targetOS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBytargetOS_First(String targetOS,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findBytargetOS(targetOS, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBytargetOS_Last(String targetOS,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBytargetOS_Last(targetOS, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("targetOS=");
        msg.append(targetOS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBytargetOS_Last(String targetOS,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytargetOS(targetOS);

        List<Logging> list = findBytargetOS(targetOS, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where targetOS = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param targetOS the target o s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findBytargetOS_PrevAndNext(long loggingId,
        String targetOS, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getBytargetOS_PrevAndNext(session, logging, targetOS,
                    orderByComparator, true);

            array[1] = logging;

            array[2] = getBytargetOS_PrevAndNext(session, logging, targetOS,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getBytargetOS_PrevAndNext(Session session,
        Logging logging, String targetOS, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (targetOS == null) {
            query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_1);
        } else {
            if (targetOS.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_3);
            } else {
                query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_2);
            }
        }

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

        if (targetOS != null) {
            qPos.add(targetOS);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where fee = &#63;.
     *
     * @param fee the fee
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByfee(int fee) throws SystemException {
        return findByfee(fee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where fee = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param fee the fee
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByfee(int fee, int start, int end)
        throws SystemException {
        return findByfee(fee, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where fee = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param fee the fee
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findByfee(int fee, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEE;
            finderArgs = new Object[] { fee };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FEE;
            finderArgs = new Object[] { fee, start, end, orderByComparator };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if ((fee != logging.getFee())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            query.append(_FINDER_COLUMN_FEE_FEE_2);

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

                qPos.add(fee);

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where fee = &#63;.
     *
     * @param fee the fee
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByfee_First(int fee, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByfee_First(fee, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("fee=");
        msg.append(fee);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where fee = &#63;.
     *
     * @param fee the fee
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByfee_First(int fee, OrderByComparator orderByComparator)
        throws SystemException {
        List<Logging> list = findByfee(fee, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where fee = &#63;.
     *
     * @param fee the fee
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findByfee_Last(int fee, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchByfee_Last(fee, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("fee=");
        msg.append(fee);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where fee = &#63;.
     *
     * @param fee the fee
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchByfee_Last(int fee, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByfee(fee);

        List<Logging> list = findByfee(fee, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where fee = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param fee the fee
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findByfee_PrevAndNext(long loggingId, int fee,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getByfee_PrevAndNext(session, logging, fee,
                    orderByComparator, true);

            array[1] = logging;

            array[2] = getByfee_PrevAndNext(session, logging, fee,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getByfee_PrevAndNext(Session session, Logging logging,
        int fee, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        query.append(_FINDER_COLUMN_FEE_FEE_2);

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

        qPos.add(fee);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetCategory(String targetCategory)
        throws SystemException {
        return findBytargetCategory(targetCategory, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where targetCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param targetCategory the target category
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetCategory(String targetCategory, int start,
        int end) throws SystemException {
        return findBytargetCategory(targetCategory, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where targetCategory = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param targetCategory the target category
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBytargetCategory(String targetCategory, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCATEGORY;
            finderArgs = new Object[] { targetCategory };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETCATEGORY;
            finderArgs = new Object[] {
                    targetCategory,
                    
                    start, end, orderByComparator
                };
        }

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if (!Validator.equals(targetCategory,
                            logging.getTargetCategory())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            if (targetCategory == null) {
                query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_1);
            } else {
                if (targetCategory.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_3);
                } else {
                    query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_2);
                }
            }

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

                if (targetCategory != null) {
                    qPos.add(targetCategory);
                }

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBytargetCategory_First(String targetCategory,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBytargetCategory_First(targetCategory,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("targetCategory=");
        msg.append(targetCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBytargetCategory_First(String targetCategory,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findBytargetCategory(targetCategory, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBytargetCategory_Last(String targetCategory,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBytargetCategory_Last(targetCategory,
                orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("targetCategory=");
        msg.append(targetCategory);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBytargetCategory_Last(String targetCategory,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytargetCategory(targetCategory);

        List<Logging> list = findBytargetCategory(targetCategory, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where targetCategory = &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param targetCategory the target category
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findBytargetCategory_PrevAndNext(long loggingId,
        String targetCategory, OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getBytargetCategory_PrevAndNext(session, logging,
                    targetCategory, orderByComparator, true);

            array[1] = logging;

            array[2] = getBytargetCategory_PrevAndNext(session, logging,
                    targetCategory, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getBytargetCategory_PrevAndNext(Session session,
        Logging logging, String targetCategory,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        if (targetCategory == null) {
            query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_1);
        } else {
            if (targetCategory.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_3);
            } else {
                query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_2);
            }
        }

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

        if (targetCategory != null) {
            qPos.add(targetCategory);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings where passel &ge; &#63;.
     *
     * @param passel the passel
     * @return the matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBypassel(long passel) throws SystemException {
        return findBypassel(passel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings where passel &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param passel the passel
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBypassel(long passel, int start, int end)
        throws SystemException {
        return findBypassel(passel, start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings where passel &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param passel the passel
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findBypassel(long passel, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PASSEL;
        finderArgs = new Object[] { passel, start, end, orderByComparator };

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Logging logging : list) {
                if ((passel != logging.getPassel())) {
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

            query.append(_SQL_SELECT_LOGGING_WHERE);

            query.append(_FINDER_COLUMN_PASSEL_PASSEL_2);

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

                qPos.add(passel);

                list = (List<Logging>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first logging in the ordered set where passel &ge; &#63;.
     *
     * @param passel the passel
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBypassel_First(long passel,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBypassel_First(passel, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("passel=");
        msg.append(passel);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the first logging in the ordered set where passel &ge; &#63;.
     *
     * @param passel the passel
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBypassel_First(long passel,
        OrderByComparator orderByComparator) throws SystemException {
        List<Logging> list = findBypassel(passel, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last logging in the ordered set where passel &ge; &#63;.
     *
     * @param passel the passel
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging findBypassel_Last(long passel,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = fetchBypassel_Last(passel, orderByComparator);

        if (logging != null) {
            return logging;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("passel=");
        msg.append(passel);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLoggingException(msg.toString());
    }

    /**
     * Returns the last logging in the ordered set where passel &ge; &#63;.
     *
     * @param passel the passel
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching logging, or <code>null</code> if a matching logging could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging fetchBypassel_Last(long passel,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBypassel(passel);

        List<Logging> list = findBypassel(passel, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the loggings before and after the current logging in the ordered set where passel &ge; &#63;.
     *
     * @param loggingId the primary key of the current logging
     * @param passel the passel
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next logging
     * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Logging[] findBypassel_PrevAndNext(long loggingId, long passel,
        OrderByComparator orderByComparator)
        throws NoSuchLoggingException, SystemException {
        Logging logging = findByPrimaryKey(loggingId);

        Session session = null;

        try {
            session = openSession();

            Logging[] array = new LoggingImpl[3];

            array[0] = getBypassel_PrevAndNext(session, logging, passel,
                    orderByComparator, true);

            array[1] = logging;

            array[2] = getBypassel_PrevAndNext(session, logging, passel,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Logging getBypassel_PrevAndNext(Session session, Logging logging,
        long passel, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LOGGING_WHERE);

        query.append(_FINDER_COLUMN_PASSEL_PASSEL_2);

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

        qPos.add(passel);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(logging);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Logging> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the loggings.
     *
     * @return the loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the loggings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @return the range of loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the loggings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of loggings
     * @param end the upper bound of the range of loggings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of loggings
     * @throws SystemException if a system exception occurred
     */
    public List<Logging> findAll(int start, int end,
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

        List<Logging> list = (List<Logging>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LOGGING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LOGGING;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Logging>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Logging>) QueryUtil.list(q, getDialect(),
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
     * Removes all the loggings where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63; from the database.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @throws SystemException if a system exception occurred
     */
    public void removeByall(String searchString, String categoryIDString,
        String regionIDString, String entitlementIDString, String targetOS,
        int fee, String targetCategory) throws SystemException {
        for (Logging logging : findByall(searchString, categoryIDString,
                regionIDString, entitlementIDString, targetOS, fee,
                targetCategory)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where searchString = &#63; from the database.
     *
     * @param searchString the search string
     * @throws SystemException if a system exception occurred
     */
    public void removeBysearchString(String searchString)
        throws SystemException {
        for (Logging logging : findBysearchString(searchString)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where categoryIDString = &#63; from the database.
     *
     * @param categoryIDString the category i d string
     * @throws SystemException if a system exception occurred
     */
    public void removeBycategoryIDString(String categoryIDString)
        throws SystemException {
        for (Logging logging : findBycategoryIDString(categoryIDString)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where regionIDString = &#63; from the database.
     *
     * @param regionIDString the region i d string
     * @throws SystemException if a system exception occurred
     */
    public void removeByregionIDString(String regionIDString)
        throws SystemException {
        for (Logging logging : findByregionIDString(regionIDString)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where entitlementIDString = &#63; from the database.
     *
     * @param entitlementIDString the entitlement i d string
     * @throws SystemException if a system exception occurred
     */
    public void removeByregionentitlementIDStringIDString(
        String entitlementIDString) throws SystemException {
        for (Logging logging : findByregionentitlementIDStringIDString(
                entitlementIDString)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where targetOS = &#63; from the database.
     *
     * @param targetOS the target o s
     * @throws SystemException if a system exception occurred
     */
    public void removeBytargetOS(String targetOS) throws SystemException {
        for (Logging logging : findBytargetOS(targetOS)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where fee = &#63; from the database.
     *
     * @param fee the fee
     * @throws SystemException if a system exception occurred
     */
    public void removeByfee(int fee) throws SystemException {
        for (Logging logging : findByfee(fee)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where targetCategory = &#63; from the database.
     *
     * @param targetCategory the target category
     * @throws SystemException if a system exception occurred
     */
    public void removeBytargetCategory(String targetCategory)
        throws SystemException {
        for (Logging logging : findBytargetCategory(targetCategory)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings where passel &ge; &#63; from the database.
     *
     * @param passel the passel
     * @throws SystemException if a system exception occurred
     */
    public void removeBypassel(long passel) throws SystemException {
        for (Logging logging : findBypassel(passel)) {
            remove(logging);
        }
    }

    /**
     * Removes all the loggings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Logging logging : findAll()) {
            remove(logging);
        }
    }

    /**
     * Returns the number of loggings where searchString = &#63; and categoryIDString = &#63; and regionIDString = &#63; and entitlementIDString = &#63; and targetOS = &#63; and fee = &#63; and targetCategory = &#63;.
     *
     * @param searchString the search string
     * @param categoryIDString the category i d string
     * @param regionIDString the region i d string
     * @param entitlementIDString the entitlement i d string
     * @param targetOS the target o s
     * @param fee the fee
     * @param targetCategory the target category
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countByall(String searchString, String categoryIDString,
        String regionIDString, String entitlementIDString, String targetOS,
        int fee, String targetCategory) throws SystemException {
        Object[] finderArgs = new Object[] {
                searchString, categoryIDString, regionIDString,
                entitlementIDString, targetOS, fee, targetCategory
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(8);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (searchString == null) {
                query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_1);
            } else {
                if (searchString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_SEARCHSTRING_2);
                }
            }

            if (categoryIDString == null) {
                query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_1);
            } else {
                if (categoryIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_CATEGORYIDSTRING_2);
                }
            }

            if (regionIDString == null) {
                query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_1);
            } else {
                if (regionIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_REGIONIDSTRING_2);
                }
            }

            if (entitlementIDString == null) {
                query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_1);
            } else {
                if (entitlementIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_ENTITLEMENTIDSTRING_2);
                }
            }

            if (targetOS == null) {
                query.append(_FINDER_COLUMN_ALL_TARGETOS_1);
            } else {
                if (targetOS.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_TARGETOS_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_TARGETOS_2);
                }
            }

            query.append(_FINDER_COLUMN_ALL_FEE_2);

            if (targetCategory == null) {
                query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_1);
            } else {
                if (targetCategory.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_3);
                } else {
                    query.append(_FINDER_COLUMN_ALL_TARGETCATEGORY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (searchString != null) {
                    qPos.add(searchString);
                }

                if (categoryIDString != null) {
                    qPos.add(categoryIDString);
                }

                if (regionIDString != null) {
                    qPos.add(regionIDString);
                }

                if (entitlementIDString != null) {
                    qPos.add(entitlementIDString);
                }

                if (targetOS != null) {
                    qPos.add(targetOS);
                }

                qPos.add(fee);

                if (targetCategory != null) {
                    qPos.add(targetCategory);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where searchString = &#63;.
     *
     * @param searchString the search string
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countBysearchString(String searchString)
        throws SystemException {
        Object[] finderArgs = new Object[] { searchString };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEARCHSTRING,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (searchString == null) {
                query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_1);
            } else {
                if (searchString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_SEARCHSTRING_SEARCHSTRING_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (searchString != null) {
                    qPos.add(searchString);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHSTRING,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where categoryIDString = &#63;.
     *
     * @param categoryIDString the category i d string
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countBycategoryIDString(String categoryIDString)
        throws SystemException {
        Object[] finderArgs = new Object[] { categoryIDString };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYIDSTRING,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (categoryIDString == null) {
                query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_1);
            } else {
                if (categoryIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_CATEGORYIDSTRING_CATEGORYIDSTRING_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (categoryIDString != null) {
                    qPos.add(categoryIDString);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYIDSTRING,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where regionIDString = &#63;.
     *
     * @param regionIDString the region i d string
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countByregionIDString(String regionIDString)
        throws SystemException {
        Object[] finderArgs = new Object[] { regionIDString };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REGIONIDSTRING,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (regionIDString == null) {
                query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_1);
            } else {
                if (regionIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONIDSTRING_REGIONIDSTRING_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (regionIDString != null) {
                    qPos.add(regionIDString);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONIDSTRING,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where entitlementIDString = &#63;.
     *
     * @param entitlementIDString the entitlement i d string
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countByregionentitlementIDStringIDString(
        String entitlementIDString) throws SystemException {
        Object[] finderArgs = new Object[] { entitlementIDString };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (entitlementIDString == null) {
                query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_1);
            } else {
                if (entitlementIDString.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_3);
                } else {
                    query.append(_FINDER_COLUMN_REGIONENTITLEMENTIDSTRINGIDSTRING_ENTITLEMENTIDSTRING_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (entitlementIDString != null) {
                    qPos.add(entitlementIDString);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONENTITLEMENTIDSTRINGIDSTRING,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where targetOS = &#63;.
     *
     * @param targetOS the target o s
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countBytargetOS(String targetOS) throws SystemException {
        Object[] finderArgs = new Object[] { targetOS };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TARGETOS,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (targetOS == null) {
                query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_1);
            } else {
                if (targetOS.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_3);
                } else {
                    query.append(_FINDER_COLUMN_TARGETOS_TARGETOS_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (targetOS != null) {
                    qPos.add(targetOS);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TARGETOS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where fee = &#63;.
     *
     * @param fee the fee
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countByfee(int fee) throws SystemException {
        Object[] finderArgs = new Object[] { fee };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FEE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            query.append(_FINDER_COLUMN_FEE_FEE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fee);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FEE, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where targetCategory = &#63;.
     *
     * @param targetCategory the target category
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countBytargetCategory(String targetCategory)
        throws SystemException {
        Object[] finderArgs = new Object[] { targetCategory };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TARGETCATEGORY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            if (targetCategory == null) {
                query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_1);
            } else {
                if (targetCategory.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_3);
                } else {
                    query.append(_FINDER_COLUMN_TARGETCATEGORY_TARGETCATEGORY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (targetCategory != null) {
                    qPos.add(targetCategory);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TARGETCATEGORY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings where passel &ge; &#63;.
     *
     * @param passel the passel
     * @return the number of matching loggings
     * @throws SystemException if a system exception occurred
     */
    public int countBypassel(long passel) throws SystemException {
        Object[] finderArgs = new Object[] { passel };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PASSEL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGGING_WHERE);

            query.append(_FINDER_COLUMN_PASSEL_PASSEL_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(passel);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PASSEL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of loggings.
     *
     * @return the number of loggings
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LOGGING);

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
     * Initializes the logging persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Logging")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Logging>> listenersList = new ArrayList<ModelListener<Logging>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Logging>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LoggingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
