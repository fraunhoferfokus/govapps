package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationPersistenceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import de.fraunhofer.fokus.movepla.NoSuchApplicationException;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl;
import de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl;
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
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see ApplicationPersistence
 * @see ApplicationUtil
 * @generated
 */
public class ApplicationPersistenceImpl extends BasePersistenceImpl<Application>
    implements ApplicationPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ApplicationUtil} to access the application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ApplicationImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc",
            new String[] { Long.class.getName() },
            ApplicationModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CU = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycu",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CU = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycu",
            new String[] { Long.class.getName(), Long.class.getName() },
            ApplicationModelImpl.COMPANYID_COLUMN_BITMASK |
            ApplicationModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CU = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycu",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycl",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBycl",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ML = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByml",
            new String[] {
                Date.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ML = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByml",
            new String[] { Date.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBym",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_M = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBym",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M2 = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBym2",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_M2 = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBym2",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DETAILSVIEWED =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydetailsViewed",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DETAILSVIEWED =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBydetailsViewed",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKCLICKED =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylinkClicked",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LINKCLICKED =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBylinkClicked",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USEOPENDATA =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuseOpenData",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEOPENDATA =
        new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuseOpenData",
            new String[] { Integer.class.getName() },
            ApplicationModelImpl.USEOPENDATA_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USEOPENDATA = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuseOpenData",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_CATEGORIES = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            de.fraunhofer.fokus.movepla.model.impl.CategoryImpl.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "getCategories",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_CATEGORIES.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_CATEGORIES_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            Long.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "getCategoriesSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_CATEGORIES_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_CATEGORY = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_CATEGORY,
            Boolean.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME,
            "containsCategory",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_REGIONS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            de.fraunhofer.fokus.movepla.model.impl.RegionImpl.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "getRegions",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_REGIONS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_REGIONS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            Long.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "getRegionsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_REGIONS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_REGION = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_REGION,
            Boolean.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME,
            "containsRegion",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_LINKS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.LinkPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getLinks",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_LINKS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_LINKS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.LinkPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getLinksSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_LINKS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_LINK = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.LinkImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.LinkPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsLink",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_MULTIMEDIAS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.MultiMediaPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getMultiMedias",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_MULTIMEDIAS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_MULTIMEDIAS_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.MultiMediaPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getMultiMediasSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_MULTIMEDIAS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_MULTIMEDIA = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.MultiMediaPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsMultiMedia",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_LANGUAGES = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            de.fraunhofer.fokus.movepla.model.impl.LanguageImpl.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "getLanguages",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_LANGUAGES.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_LANGUAGES_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            Long.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "getLanguagesSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_LANGUAGES_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_LANGUAGE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.LanguageModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED_MVP_APPLICATION_LANGUAGE,
            Boolean.class,
            ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME,
            "containsLanguage",
            new String[] { Long.class.getName(), Long.class.getName() });
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
    public static final FinderPath FINDER_PATH_GET_RELATEDAPPLICATIONSES = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.RelatedApplicationsPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getRelatedApplicationses",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_RELATEDAPPLICATIONSES.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_RELATEDAPPLICATIONSES_SIZE = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.RelatedApplicationsPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getRelatedApplicationsesSize",
            new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_RELATEDAPPLICATIONSES_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_RELATEDAPPLICATIONS = new FinderPath(de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.ENTITY_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsModelImpl.FINDER_CACHE_ENABLED,
            de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl.class,
            de.fraunhofer.fokus.movepla.service.persistence.RelatedApplicationsPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsRelatedApplications",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_APPLICATION = "SELECT application FROM Application application";
    private static final String _SQL_SELECT_APPLICATION_WHERE = "SELECT application FROM Application application WHERE ";
    private static final String _SQL_COUNT_APPLICATION = "SELECT COUNT(application) FROM Application application";
    private static final String _SQL_COUNT_APPLICATION_WHERE = "SELECT COUNT(application) FROM Application application WHERE ";
    private static final String _SQL_GETCATEGORIES = "SELECT {mvp_Category.*} FROM mvp_Category INNER JOIN mvp_Application_Category ON (mvp_Application_Category.categoryId = mvp_Category.categoryId) WHERE (mvp_Application_Category.applicationId = ?)";
    private static final String _SQL_GETCATEGORIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Category WHERE applicationId = ?";
    private static final String _SQL_CONTAINSCATEGORY = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Category WHERE applicationId = ? AND categoryId = ?";
    private static final String _SQL_GETREGIONS = "SELECT {mvp_Region.*} FROM mvp_Region INNER JOIN mvp_Application_Region ON (mvp_Application_Region.regionId = mvp_Region.regionId) WHERE (mvp_Application_Region.applicationId = ?)";
    private static final String _SQL_GETREGIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Region WHERE applicationId = ?";
    private static final String _SQL_CONTAINSREGION = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Region WHERE applicationId = ? AND regionId = ?";
    private static final String _SQL_GETLINKS = "SELECT {mvp_Link.*} FROM mvp_Link INNER JOIN mvp_Application ON (mvp_Application.applicationId = mvp_Link.applicationId) WHERE (mvp_Application.applicationId = ?)";
    private static final String _SQL_GETLINKSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Link WHERE applicationId = ?";
    private static final String _SQL_CONTAINSLINK = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Link WHERE applicationId = ? AND linkId = ?";
    private static final String _SQL_GETMULTIMEDIAS = "SELECT {mvp_MultiMedia.*} FROM mvp_MultiMedia INNER JOIN mvp_Application ON (mvp_Application.applicationId = mvp_MultiMedia.applicationId) WHERE (mvp_Application.applicationId = ?)";
    private static final String _SQL_GETMULTIMEDIASSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_MultiMedia WHERE applicationId = ?";
    private static final String _SQL_CONTAINSMULTIMEDIA = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_MultiMedia WHERE applicationId = ? AND multiMediaId = ?";
    private static final String _SQL_GETLANGUAGES = "SELECT {mvp_Language.*} FROM mvp_Language INNER JOIN mvp_Application_Language ON (mvp_Application_Language.LanguageId = mvp_Language.LanguageId) WHERE (mvp_Application_Language.applicationId = ?)";
    private static final String _SQL_GETLANGUAGESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Language WHERE applicationId = ?";
    private static final String _SQL_CONTAINSLANGUAGE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Language WHERE applicationId = ? AND LanguageId = ?";
    private static final String _SQL_GETAPPLICATION_ENTITLEMENTS = "SELECT {mvp_Application_Entitlement.*} FROM mvp_Application_Entitlement INNER JOIN mvp_Application ON (mvp_Application.applicationId = mvp_Application_Entitlement.applicationId) WHERE (mvp_Application.applicationId = ?)";
    private static final String _SQL_GETAPPLICATION_ENTITLEMENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Entitlement WHERE applicationId = ?";
    private static final String _SQL_CONTAINSAPPLICATION_ENTITLEMENT = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_Application_Entitlement WHERE applicationId = ? AND applicationEntitlementID = ?";
    private static final String _SQL_GETRELATEDAPPLICATIONSES = "SELECT {mvp_RelatedApplications.*} FROM mvp_RelatedApplications INNER JOIN mvp_Application ON (mvp_Application.applicationId = mvp_RelatedApplications.applicationId) WHERE (mvp_Application.applicationId = ?)";
    private static final String _SQL_GETRELATEDAPPLICATIONSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_RelatedApplications WHERE applicationId = ?";
    private static final String _SQL_CONTAINSRELATEDAPPLICATIONS = "SELECT COUNT(*) AS COUNT_VALUE FROM mvp_RelatedApplications WHERE applicationId = ? AND RelatedApplicationsID = ?";
    private static final String _FINDER_COLUMN_C_COMPANYID_2 = "application.companyId = ?";
    private static final String _FINDER_COLUMN_CU_COMPANYID_2 = "application.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CU_USERID_2 = "application.userId = ?";
    private static final String _FINDER_COLUMN_CL_COMPANYID_2 = "application.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CL_LIFECYCLESTATUS_2 = "application.lifeCycleStatus >= ?";
    private static final String _FINDER_COLUMN_ML_MODIFIEDDATE_1 = "application.modifiedDate >= NULL AND ";
    private static final String _FINDER_COLUMN_ML_MODIFIEDDATE_2 = "application.modifiedDate >= ? AND ";
    private static final String _FINDER_COLUMN_ML_LIFECYCLESTATUS_2 = "application.lifeCycleStatus = ?";
    private static final String _FINDER_COLUMN_M_MODIFIEDDATE_1 = "application.modifiedDate >= NULL";
    private static final String _FINDER_COLUMN_M_MODIFIEDDATE_2 = "application.modifiedDate >= ?";
    private static final String _FINDER_COLUMN_M2_MODIFIEDDATE_1 = "application.modifiedDate < NULL";
    private static final String _FINDER_COLUMN_M2_MODIFIEDDATE_2 = "application.modifiedDate < ?";
    private static final String _FINDER_COLUMN_DETAILSVIEWED_DETAILSVIEWED_2 = "application.detailsViewed >= ?";
    private static final String _FINDER_COLUMN_LINKCLICKED_LINKCLICKED_2 = "application.linkClicked >= ?";
    private static final String _FINDER_COLUMN_USEOPENDATA_USEOPENDATA_2 = "application.useOpenData = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "application.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Application exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Application exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ApplicationPersistenceImpl.class);
    private static Application _nullApplication = new ApplicationImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Application> toCacheModel() {
                return _nullApplicationCacheModel;
            }
        };

    private static CacheModel<Application> _nullApplicationCacheModel = new CacheModel<Application>() {
            public Application toEntityModel() {
                return _nullApplication;
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
    protected ContainsCategory containsCategory;
    protected AddCategory addCategory;
    protected ClearCategories clearCategories;
    protected RemoveCategory removeCategory;
    protected ContainsRegion containsRegion;
    protected AddRegion addRegion;
    protected ClearRegions clearRegions;
    protected RemoveRegion removeRegion;
    protected ContainsLink containsLink;
    protected ContainsMultiMedia containsMultiMedia;
    protected ContainsLanguage containsLanguage;
    protected AddLanguage addLanguage;
    protected ClearLanguages clearLanguages;
    protected RemoveLanguage removeLanguage;
    protected ContainsApplication_Entitlement containsApplication_Entitlement;
    protected ContainsRelatedApplications containsRelatedApplications;

    /**
     * Caches the application in the entity cache if it is enabled.
     *
     * @param application the application
     */
    public void cacheResult(Application application) {
        EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey(), application);

        application.resetOriginalValues();
    }

    /**
     * Caches the applications in the entity cache if it is enabled.
     *
     * @param applications the applications
     */
    public void cacheResult(List<Application> applications) {
        for (Application application : applications) {
            if (EntityCacheUtil.getResult(
                        ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationImpl.class, application.getPrimaryKey()) == null) {
                cacheResult(application);
            } else {
                application.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all applications.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ApplicationImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ApplicationImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the application.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Application application) {
        EntityCacheUtil.removeResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Application> applications) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Application application : applications) {
            EntityCacheUtil.removeResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationImpl.class, application.getPrimaryKey());
        }
    }

    /**
     * Creates a new application with the primary key. Does not add the application to the database.
     *
     * @param applicationId the primary key for the new application
     * @return the new application
     */
    public Application create(long applicationId) {
        Application application = new ApplicationImpl();

        application.setNew(true);
        application.setPrimaryKey(applicationId);

        return application;
    }

    /**
     * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicationId the primary key of the application
     * @return the application that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application remove(long applicationId)
        throws NoSuchApplicationException, SystemException {
        return remove(Long.valueOf(applicationId));
    }

    /**
     * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the application
     * @return the application that was removed
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application remove(Serializable primaryKey)
        throws NoSuchApplicationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Application application = (Application) session.get(ApplicationImpl.class,
                    primaryKey);

            if (application == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(application);
        } catch (NoSuchApplicationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Application removeImpl(Application application)
        throws SystemException {
        application = toUnwrappedModel(application);

        try {
            clearCategories.clear(application.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }

        try {
            clearRegions.clear(application.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }

        try {
            clearLanguages.clear(application.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, application);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(application);

        return application;
    }

    @Override
    public Application updateImpl(
        de.fraunhofer.fokus.movepla.model.Application application, boolean merge)
        throws SystemException {
        application = toUnwrappedModel(application);

        boolean isNew = application.isNew();

        ApplicationModelImpl applicationModelImpl = (ApplicationModelImpl) application;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, application, merge);

            application.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ApplicationModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((applicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(applicationModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);

                args = new Object[] {
                        Long.valueOf(applicationModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C,
                    args);
            }

            if ((applicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CU.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(applicationModelImpl.getOriginalCompanyId()),
                        Long.valueOf(applicationModelImpl.getOriginalUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CU, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CU,
                    args);

                args = new Object[] {
                        Long.valueOf(applicationModelImpl.getCompanyId()),
                        Long.valueOf(applicationModelImpl.getUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CU, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CU,
                    args);
            }

            if ((applicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEOPENDATA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Integer.valueOf(applicationModelImpl.getOriginalUseOpenData())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEOPENDATA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEOPENDATA,
                    args);

                args = new Object[] {
                        Integer.valueOf(applicationModelImpl.getUseOpenData())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEOPENDATA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEOPENDATA,
                    args);
            }
        }

        EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey(), application);

        return application;
    }

    protected Application toUnwrappedModel(Application application) {
        if (application instanceof ApplicationImpl) {
            return application;
        }

        ApplicationImpl applicationImpl = new ApplicationImpl();

        applicationImpl.setNew(application.isNew());
        applicationImpl.setPrimaryKey(application.getPrimaryKey());

        applicationImpl.setApplicationId(application.getApplicationId());
        applicationImpl.setCompanyId(application.getCompanyId());
        applicationImpl.setUserId(application.getUserId());
        applicationImpl.setCreateDate(application.getCreateDate());
        applicationImpl.setModifiedDate(application.getModifiedDate());
        applicationImpl.setName(application.getName());
        applicationImpl.setDescription(application.getDescription());
        applicationImpl.setVersion(application.getVersion());
        applicationImpl.setVersionInformation(application.getVersionInformation());
        applicationImpl.setSize(application.getSize());
        applicationImpl.setFirstPublishingDate(application.getFirstPublishingDate());
        applicationImpl.setLastModifiedDate(application.getLastModifiedDate());
        applicationImpl.setLogoImageId(application.getLogoImageId());
        applicationImpl.setFee(application.getFee());
        applicationImpl.setTargetOS(application.getTargetOS());
        applicationImpl.setMinTargetOSVersion(application.getMinTargetOSVersion());
        applicationImpl.setTargetCategory(application.getTargetCategory());
        applicationImpl.setLifeCycleStatus(application.getLifeCycleStatus());
        applicationImpl.setVerifiedDate(application.getVerifiedDate());
        applicationImpl.setCategoryString(application.getCategoryString());
        applicationImpl.setRegionString(application.getRegionString());
        applicationImpl.setLifeCycleStatusString(application.getLifeCycleStatusString());
        applicationImpl.setLegalDetails(application.getLegalDetails());
        applicationImpl.setDeveloper(application.getDeveloper());
        applicationImpl.setDetailsViewed(application.getDetailsViewed());
        applicationImpl.setLinkClicked(application.getLinkClicked());
        applicationImpl.setUseOpenData(application.getUseOpenData());
        applicationImpl.setSector(application.getSector());
        applicationImpl.setLicense(application.getLicense());
        applicationImpl.setRelatedApplicationId(application.getRelatedApplicationId());
        applicationImpl.setNewVersionId(application.getNewVersionId());
        applicationImpl.setOldVersionId(application.getOldVersionId());

        return applicationImpl;
    }

    /**
     * Returns the application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the application
     * @return the application
     * @throws com.liferay.portal.NoSuchModelException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the application with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplicationException} if it could not be found.
     *
     * @param applicationId the primary key of the application
     * @return the application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByPrimaryKey(long applicationId)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByPrimaryKey(applicationId);

        if (application == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + applicationId);
            }

            throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                applicationId);
        }

        return application;
    }

    /**
     * Returns the application with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the application
     * @return the application, or <code>null</code> if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the application with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param applicationId the primary key of the application
     * @return the application, or <code>null</code> if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByPrimaryKey(long applicationId)
        throws SystemException {
        Application application = (Application) EntityCacheUtil.getResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationImpl.class, applicationId);

        if (application == _nullApplication) {
            return null;
        }

        if (application == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                application = (Application) session.get(ApplicationImpl.class,
                        Long.valueOf(applicationId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (application != null) {
                    cacheResult(application);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationImpl.class, applicationId, _nullApplication);
                }

                closeSession(session);
            }
        }

        return application;
    }

    /**
     * Returns all the applications where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByc(long companyId) throws SystemException {
        return findByc(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByc(long companyId, int start, int end)
        throws SystemException {
        return findByc(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByc(long companyId, int start, int end,
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

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((companyId != application.getCompanyId())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByc_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByc_First(companyId, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByc_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findByc(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByc_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByc_Last(companyId, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByc_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByc(companyId);

        List<Application> list = findByc(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where companyId = &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findByc_PrevAndNext(long applicationId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getByc_PrevAndNext(session, application, companyId,
                    orderByComparator, true);

            array[1] = application;

            array[2] = getByc_PrevAndNext(session, application, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getByc_PrevAndNext(Session session,
        Application application, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

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
        else {
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycu(long companyId, long userId)
        throws SystemException {
        return findBycu(companyId, userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where companyId = &#63; and userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycu(long companyId, long userId, int start,
        int end) throws SystemException {
        return findBycu(companyId, userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where companyId = &#63; and userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycu(long companyId, long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CU;
            finderArgs = new Object[] { companyId, userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CU;
            finderArgs = new Object[] {
                    companyId, userId,
                    
                    start, end, orderByComparator
                };
        }

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((companyId != application.getCompanyId()) ||
                        (userId != application.getUserId())) {
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
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_CU_COMPANYID_2);

            query.append(_FINDER_COLUMN_CU_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBycu_First(long companyId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBycu_First(companyId, userId,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBycu_First(long companyId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBycu(companyId, userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBycu_Last(long companyId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBycu_Last(companyId, userId,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBycu_Last(long companyId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycu(companyId, userId);

        List<Application> list = findBycu(companyId, userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBycu_PrevAndNext(long applicationId,
        long companyId, long userId, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBycu_PrevAndNext(session, application, companyId,
                    userId, orderByComparator, true);

            array[1] = application;

            array[2] = getBycu_PrevAndNext(session, application, companyId,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBycu_PrevAndNext(Session session,
        Application application, long companyId, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        query.append(_FINDER_COLUMN_CU_COMPANYID_2);

        query.append(_FINDER_COLUMN_CU_USERID_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycl(long companyId, int lifeCycleStatus)
        throws SystemException {
        return findBycl(companyId, lifeCycleStatus, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycl(long companyId, int lifeCycleStatus,
        int start, int end) throws SystemException {
        return findBycl(companyId, lifeCycleStatus, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBycl(long companyId, int lifeCycleStatus,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CL;
        finderArgs = new Object[] {
                companyId, lifeCycleStatus,
                
                start, end, orderByComparator
            };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((companyId != application.getCompanyId()) ||
                        (lifeCycleStatus != application.getLifeCycleStatus())) {
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
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_CL_COMPANYID_2);

            query.append(_FINDER_COLUMN_CL_LIFECYCLESTATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(lifeCycleStatus);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBycl_First(long companyId, int lifeCycleStatus,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBycl_First(companyId, lifeCycleStatus,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", lifeCycleStatus=");
        msg.append(lifeCycleStatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBycl_First(long companyId, int lifeCycleStatus,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBycl(companyId, lifeCycleStatus, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBycl_Last(long companyId, int lifeCycleStatus,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBycl_Last(companyId, lifeCycleStatus,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", lifeCycleStatus=");
        msg.append(lifeCycleStatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBycl_Last(long companyId, int lifeCycleStatus,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycl(companyId, lifeCycleStatus);

        List<Application> list = findBycl(companyId, lifeCycleStatus,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBycl_PrevAndNext(long applicationId,
        long companyId, int lifeCycleStatus, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBycl_PrevAndNext(session, application, companyId,
                    lifeCycleStatus, orderByComparator, true);

            array[1] = application;

            array[2] = getBycl_PrevAndNext(session, application, companyId,
                    lifeCycleStatus, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBycl_PrevAndNext(Session session,
        Application application, long companyId, int lifeCycleStatus,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        query.append(_FINDER_COLUMN_CL_COMPANYID_2);

        query.append(_FINDER_COLUMN_CL_LIFECYCLESTATUS_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(lifeCycleStatus);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByml(Date modifiedDate, int lifeCycleStatus)
        throws SystemException {
        return findByml(modifiedDate, lifeCycleStatus, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByml(Date modifiedDate, int lifeCycleStatus,
        int start, int end) throws SystemException {
        return findByml(modifiedDate, lifeCycleStatus, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByml(Date modifiedDate, int lifeCycleStatus,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ML;
        finderArgs = new Object[] {
                modifiedDate, lifeCycleStatus,
                
                start, end, orderByComparator
            };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if (!Validator.equals(modifiedDate,
                            application.getModifiedDate()) ||
                        (lifeCycleStatus != application.getLifeCycleStatus())) {
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
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_2);
            }

            query.append(_FINDER_COLUMN_ML_LIFECYCLESTATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                qPos.add(lifeCycleStatus);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByml_First(Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByml_First(modifiedDate,
                lifeCycleStatus, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(", lifeCycleStatus=");
        msg.append(lifeCycleStatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByml_First(Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findByml(modifiedDate, lifeCycleStatus, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByml_Last(Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByml_Last(modifiedDate, lifeCycleStatus,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(", lifeCycleStatus=");
        msg.append(lifeCycleStatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByml_Last(Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByml(modifiedDate, lifeCycleStatus);

        List<Application> list = findByml(modifiedDate, lifeCycleStatus,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findByml_PrevAndNext(long applicationId,
        Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getByml_PrevAndNext(session, application, modifiedDate,
                    lifeCycleStatus, orderByComparator, true);

            array[1] = application;

            array[2] = getByml_PrevAndNext(session, application, modifiedDate,
                    lifeCycleStatus, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getByml_PrevAndNext(Session session,
        Application application, Date modifiedDate, int lifeCycleStatus,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        if (modifiedDate == null) {
            query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_1);
        } else {
            query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_2);
        }

        query.append(_FINDER_COLUMN_ML_LIFECYCLESTATUS_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (modifiedDate != null) {
            qPos.add(CalendarUtil.getTimestamp(modifiedDate));
        }

        qPos.add(lifeCycleStatus);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym(Date modifiedDate)
        throws SystemException {
        return findBym(modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where modifiedDate &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym(Date modifiedDate, int start, int end)
        throws SystemException {
        return findBym(modifiedDate, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where modifiedDate &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym(Date modifiedDate, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M;
        finderArgs = new Object[] { modifiedDate, start, end, orderByComparator };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if (!Validator.equals(modifiedDate,
                            application.getModifiedDate())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_M_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_M_MODIFIEDDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBym_First(Date modifiedDate,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBym_First(modifiedDate, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBym_First(Date modifiedDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBym(modifiedDate, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBym_Last(Date modifiedDate,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBym_Last(modifiedDate, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBym_Last(Date modifiedDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBym(modifiedDate);

        List<Application> list = findBym(modifiedDate, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where modifiedDate &ge; &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBym_PrevAndNext(long applicationId,
        Date modifiedDate, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBym_PrevAndNext(session, application, modifiedDate,
                    orderByComparator, true);

            array[1] = application;

            array[2] = getBym_PrevAndNext(session, application, modifiedDate,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBym_PrevAndNext(Session session,
        Application application, Date modifiedDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        if (modifiedDate == null) {
            query.append(_FINDER_COLUMN_M_MODIFIEDDATE_1);
        } else {
            query.append(_FINDER_COLUMN_M_MODIFIEDDATE_2);
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
        else {
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (modifiedDate != null) {
            qPos.add(CalendarUtil.getTimestamp(modifiedDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym2(Date modifiedDate)
        throws SystemException {
        return findBym2(modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where modifiedDate &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym2(Date modifiedDate, int start, int end)
        throws SystemException {
        return findBym2(modifiedDate, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where modifiedDate &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param modifiedDate the modified date
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBym2(Date modifiedDate, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M2;
        finderArgs = new Object[] { modifiedDate, start, end, orderByComparator };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if (!Validator.equals(modifiedDate,
                            application.getModifiedDate())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBym2_First(Date modifiedDate,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBym2_First(modifiedDate,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBym2_First(Date modifiedDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBym2(modifiedDate, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBym2_Last(Date modifiedDate,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBym2_Last(modifiedDate, orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modifiedDate=");
        msg.append(modifiedDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBym2_Last(Date modifiedDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBym2(modifiedDate);

        List<Application> list = findBym2(modifiedDate, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where modifiedDate &lt; &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param modifiedDate the modified date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBym2_PrevAndNext(long applicationId,
        Date modifiedDate, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBym2_PrevAndNext(session, application, modifiedDate,
                    orderByComparator, true);

            array[1] = application;

            array[2] = getBym2_PrevAndNext(session, application, modifiedDate,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBym2_PrevAndNext(Session session,
        Application application, Date modifiedDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        if (modifiedDate == null) {
            query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_1);
        } else {
            query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_2);
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
        else {
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (modifiedDate != null) {
            qPos.add(CalendarUtil.getTimestamp(modifiedDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBydetailsViewed(long detailsViewed)
        throws SystemException {
        return findBydetailsViewed(detailsViewed, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where detailsViewed &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param detailsViewed the details viewed
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBydetailsViewed(long detailsViewed, int start,
        int end) throws SystemException {
        return findBydetailsViewed(detailsViewed, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where detailsViewed &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param detailsViewed the details viewed
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBydetailsViewed(long detailsViewed, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DETAILSVIEWED;
        finderArgs = new Object[] { detailsViewed, start, end, orderByComparator };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((detailsViewed != application.getDetailsViewed())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_DETAILSVIEWED_DETAILSVIEWED_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(detailsViewed);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBydetailsViewed_First(long detailsViewed,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBydetailsViewed_First(detailsViewed,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("detailsViewed=");
        msg.append(detailsViewed);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBydetailsViewed_First(long detailsViewed,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBydetailsViewed(detailsViewed, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBydetailsViewed_Last(long detailsViewed,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBydetailsViewed_Last(detailsViewed,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("detailsViewed=");
        msg.append(detailsViewed);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBydetailsViewed_Last(long detailsViewed,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBydetailsViewed(detailsViewed);

        List<Application> list = findBydetailsViewed(detailsViewed, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where detailsViewed &ge; &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param detailsViewed the details viewed
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBydetailsViewed_PrevAndNext(long applicationId,
        long detailsViewed, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBydetailsViewed_PrevAndNext(session, application,
                    detailsViewed, orderByComparator, true);

            array[1] = application;

            array[2] = getBydetailsViewed_PrevAndNext(session, application,
                    detailsViewed, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBydetailsViewed_PrevAndNext(Session session,
        Application application, long detailsViewed,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        query.append(_FINDER_COLUMN_DETAILSVIEWED_DETAILSVIEWED_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(detailsViewed);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBylinkClicked(long linkClicked)
        throws SystemException {
        return findBylinkClicked(linkClicked, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where linkClicked &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param linkClicked the link clicked
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBylinkClicked(long linkClicked, int start,
        int end) throws SystemException {
        return findBylinkClicked(linkClicked, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where linkClicked &ge; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param linkClicked the link clicked
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findBylinkClicked(long linkClicked, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKCLICKED;
        finderArgs = new Object[] { linkClicked, start, end, orderByComparator };

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((linkClicked != application.getLinkClicked())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_LINKCLICKED_LINKCLICKED_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(linkClicked);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBylinkClicked_First(long linkClicked,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBylinkClicked_First(linkClicked,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("linkClicked=");
        msg.append(linkClicked);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBylinkClicked_First(long linkClicked,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findBylinkClicked(linkClicked, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findBylinkClicked_Last(long linkClicked,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchBylinkClicked_Last(linkClicked,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("linkClicked=");
        msg.append(linkClicked);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchBylinkClicked_Last(long linkClicked,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBylinkClicked(linkClicked);

        List<Application> list = findBylinkClicked(linkClicked, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where linkClicked &ge; &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param linkClicked the link clicked
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findBylinkClicked_PrevAndNext(long applicationId,
        long linkClicked, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getBylinkClicked_PrevAndNext(session, application,
                    linkClicked, orderByComparator, true);

            array[1] = application;

            array[2] = getBylinkClicked_PrevAndNext(session, application,
                    linkClicked, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getBylinkClicked_PrevAndNext(Session session,
        Application application, long linkClicked,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        query.append(_FINDER_COLUMN_LINKCLICKED_LINKCLICKED_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(linkClicked);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @return the matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByuseOpenData(int useOpenData)
        throws SystemException {
        return findByuseOpenData(useOpenData, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications where useOpenData = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param useOpenData the use open data
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByuseOpenData(int useOpenData, int start,
        int end) throws SystemException {
        return findByuseOpenData(useOpenData, start, end, null);
    }

    /**
     * Returns an ordered range of all the applications where useOpenData = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param useOpenData the use open data
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findByuseOpenData(int useOpenData, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEOPENDATA;
            finderArgs = new Object[] { useOpenData };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USEOPENDATA;
            finderArgs = new Object[] { useOpenData, start, end, orderByComparator };
        }

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Application application : list) {
                if ((useOpenData != application.getUseOpenData())) {
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

            query.append(_SQL_SELECT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_USEOPENDATA_USEOPENDATA_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(useOpenData);

                list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Returns the first application in the ordered set where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByuseOpenData_First(int useOpenData,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByuseOpenData_First(useOpenData,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("useOpenData=");
        msg.append(useOpenData);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the first application in the ordered set where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByuseOpenData_First(int useOpenData,
        OrderByComparator orderByComparator) throws SystemException {
        List<Application> list = findByuseOpenData(useOpenData, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application in the ordered set where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application findByuseOpenData_Last(int useOpenData,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByuseOpenData_Last(useOpenData,
                orderByComparator);

        if (application != null) {
            return application;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("useOpenData=");
        msg.append(useOpenData);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationException(msg.toString());
    }

    /**
     * Returns the last application in the ordered set where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application, or <code>null</code> if a matching application could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application fetchByuseOpenData_Last(int useOpenData,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByuseOpenData(useOpenData);

        List<Application> list = findByuseOpenData(useOpenData, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applications before and after the current application in the ordered set where useOpenData = &#63;.
     *
     * @param applicationId the primary key of the current application
     * @param useOpenData the use open data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application
     * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application[] findByuseOpenData_PrevAndNext(long applicationId,
        int useOpenData, OrderByComparator orderByComparator)
        throws NoSuchApplicationException, SystemException {
        Application application = findByPrimaryKey(applicationId);

        Session session = null;

        try {
            session = openSession();

            Application[] array = new ApplicationImpl[3];

            array[0] = getByuseOpenData_PrevAndNext(session, application,
                    useOpenData, orderByComparator, true);

            array[1] = application;

            array[2] = getByuseOpenData_PrevAndNext(session, application,
                    useOpenData, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Application getByuseOpenData_PrevAndNext(Session session,
        Application application, int useOpenData,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATION_WHERE);

        query.append(_FINDER_COLUMN_USEOPENDATA_USEOPENDATA_2);

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
            query.append(ApplicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(useOpenData);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(application);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Application> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applications.
     *
     * @return the applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the applications.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applications
     * @throws SystemException if a system exception occurred
     */
    public List<Application> findAll(int start, int end,
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

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPLICATION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPLICATION.concat(ApplicationModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Application>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Removes all the applications where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByc(long companyId) throws SystemException {
        for (Application application : findByc(companyId)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where companyId = &#63; and userId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    public void removeBycu(long companyId, long userId)
        throws SystemException {
        for (Application application : findBycu(companyId, userId)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63; from the database.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @throws SystemException if a system exception occurred
     */
    public void removeBycl(long companyId, int lifeCycleStatus)
        throws SystemException {
        for (Application application : findBycl(companyId, lifeCycleStatus)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63; from the database.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @throws SystemException if a system exception occurred
     */
    public void removeByml(Date modifiedDate, int lifeCycleStatus)
        throws SystemException {
        for (Application application : findByml(modifiedDate, lifeCycleStatus)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where modifiedDate &ge; &#63; from the database.
     *
     * @param modifiedDate the modified date
     * @throws SystemException if a system exception occurred
     */
    public void removeBym(Date modifiedDate) throws SystemException {
        for (Application application : findBym(modifiedDate)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where modifiedDate &lt; &#63; from the database.
     *
     * @param modifiedDate the modified date
     * @throws SystemException if a system exception occurred
     */
    public void removeBym2(Date modifiedDate) throws SystemException {
        for (Application application : findBym2(modifiedDate)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where detailsViewed &ge; &#63; from the database.
     *
     * @param detailsViewed the details viewed
     * @throws SystemException if a system exception occurred
     */
    public void removeBydetailsViewed(long detailsViewed)
        throws SystemException {
        for (Application application : findBydetailsViewed(detailsViewed)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where linkClicked &ge; &#63; from the database.
     *
     * @param linkClicked the link clicked
     * @throws SystemException if a system exception occurred
     */
    public void removeBylinkClicked(long linkClicked) throws SystemException {
        for (Application application : findBylinkClicked(linkClicked)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications where useOpenData = &#63; from the database.
     *
     * @param useOpenData the use open data
     * @throws SystemException if a system exception occurred
     */
    public void removeByuseOpenData(int useOpenData) throws SystemException {
        for (Application application : findByuseOpenData(useOpenData)) {
            remove(application);
        }
    }

    /**
     * Removes all the applications from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Application application : findAll()) {
            remove(application);
        }
    }

    /**
     * Returns the number of applications where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countByc(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

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
     * Returns the number of applications where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBycu(long companyId, long userId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId, userId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CU,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_CU_COMPANYID_2);

            query.append(_FINDER_COLUMN_CU_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CU, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
     *
     * @param companyId the company ID
     * @param lifeCycleStatus the life cycle status
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBycl(long companyId, int lifeCycleStatus)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, lifeCycleStatus };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_CL_COMPANYID_2);

            query.append(_FINDER_COLUMN_CL_LIFECYCLESTATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(lifeCycleStatus);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
     *
     * @param modifiedDate the modified date
     * @param lifeCycleStatus the life cycle status
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countByml(Date modifiedDate, int lifeCycleStatus)
        throws SystemException {
        Object[] finderArgs = new Object[] { modifiedDate, lifeCycleStatus };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ML,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_ML_MODIFIEDDATE_2);
            }

            query.append(_FINDER_COLUMN_ML_LIFECYCLESTATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                qPos.add(lifeCycleStatus);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ML,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where modifiedDate &ge; &#63;.
     *
     * @param modifiedDate the modified date
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBym(Date modifiedDate) throws SystemException {
        Object[] finderArgs = new Object[] { modifiedDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_M,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_M_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_M_MODIFIEDDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_M,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where modifiedDate &lt; &#63;.
     *
     * @param modifiedDate the modified date
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBym2(Date modifiedDate) throws SystemException {
        Object[] finderArgs = new Object[] { modifiedDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_M2,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            if (modifiedDate == null) {
                query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_M2_MODIFIEDDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (modifiedDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(modifiedDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_M2,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where detailsViewed &ge; &#63;.
     *
     * @param detailsViewed the details viewed
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBydetailsViewed(long detailsViewed)
        throws SystemException {
        Object[] finderArgs = new Object[] { detailsViewed };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_DETAILSVIEWED,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_DETAILSVIEWED_DETAILSVIEWED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(detailsViewed);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_DETAILSVIEWED,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where linkClicked &ge; &#63;.
     *
     * @param linkClicked the link clicked
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countBylinkClicked(long linkClicked) throws SystemException {
        Object[] finderArgs = new Object[] { linkClicked };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_LINKCLICKED,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_LINKCLICKED_LINKCLICKED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(linkClicked);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_LINKCLICKED,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications where useOpenData = &#63;.
     *
     * @param useOpenData the use open data
     * @return the number of matching applications
     * @throws SystemException if a system exception occurred
     */
    public int countByuseOpenData(int useOpenData) throws SystemException {
        Object[] finderArgs = new Object[] { useOpenData };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USEOPENDATA,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICATION_WHERE);

            query.append(_FINDER_COLUMN_USEOPENDATA_USEOPENDATA_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(useOpenData);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USEOPENDATA,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applications.
     *
     * @return the number of applications
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_APPLICATION);

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
     * Returns all the categories associated with the application.
     *
     * @param pk the primary key of the application
     * @return the categories associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk) throws SystemException {
        return getCategories(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the categories associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of categories associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end) throws SystemException {
        return getCategories(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the categories associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of categories associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Category> list = (List<de.fraunhofer.fokus.movepla.model.Category>) FinderCacheUtil.getResult(FINDER_PATH_GET_CATEGORIES,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETCATEGORIES.concat(ORDER_BY_CLAUSE)
                                            .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETCATEGORIES;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Category",
                    de.fraunhofer.fokus.movepla.model.impl.CategoryImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Category>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_CATEGORIES,
                        finderArgs);
                } else {
                    categoryPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_CATEGORIES,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of categories associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of categories associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getCategoriesSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_CATEGORIES_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETCATEGORIESSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_CATEGORIES_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the category is associated with the application.
     *
     * @param pk the primary key of the application
     * @param categoryPK the primary key of the category
     * @return <code>true</code> if the category is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsCategory(long pk, long categoryPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, categoryPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CATEGORY,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsCategory.contains(pk, categoryPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CATEGORY,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any categories associated with it.
     *
     * @param pk the primary key of the application to check for associations with categories
     * @return <code>true</code> if the application has any categories associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsCategories(long pk) throws SystemException {
        if (getCategoriesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categoryPK the primary key of the category
     * @throws SystemException if a system exception occurred
     */
    public void addCategory(long pk, long categoryPK) throws SystemException {
        try {
            addCategory.add(pk, categoryPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param category the category
     * @throws SystemException if a system exception occurred
     */
    public void addCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws SystemException {
        try {
            addCategory.add(pk, category.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categoryPKs the primary keys of the categories
     * @throws SystemException if a system exception occurred
     */
    public void addCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            for (long categoryPK : categoryPKs) {
                addCategory.add(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categories the categories
     * @throws SystemException if a system exception occurred
     */
    public void addCategories(long pk,
        List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Category category : categories) {
                addCategory.add(pk, category.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Clears all associations between the application and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application to clear the associated categories from
     * @throws SystemException if a system exception occurred
     */
    public void clearCategories(long pk) throws SystemException {
        try {
            clearCategories.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categoryPK the primary key of the category
     * @throws SystemException if a system exception occurred
     */
    public void removeCategory(long pk, long categoryPK)
        throws SystemException {
        try {
            removeCategory.remove(pk, categoryPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param category the category
     * @throws SystemException if a system exception occurred
     */
    public void removeCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws SystemException {
        try {
            removeCategory.remove(pk, category.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categoryPKs the primary keys of the categories
     * @throws SystemException if a system exception occurred
     */
    public void removeCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            for (long categoryPK : categoryPKs) {
                removeCategory.remove(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categories the categories
     * @throws SystemException if a system exception occurred
     */
    public void removeCategories(long pk,
        List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Category category : categories) {
                removeCategory.remove(pk, category.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categoryPKs the primary keys of the categories to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            Set<Long> categoryPKSet = SetUtil.fromArray(categoryPKs);

            List<de.fraunhofer.fokus.movepla.model.Category> categories = getCategories(pk);

            for (de.fraunhofer.fokus.movepla.model.Category category : categories) {
                if (!categoryPKSet.remove(category.getPrimaryKey())) {
                    removeCategory.remove(pk, category.getPrimaryKey());
                }
            }

            for (Long categoryPK : categoryPKSet) {
                addCategory.add(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param categories the categories to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setCategories(long pk,
        List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws SystemException {
        try {
            long[] categoryPKs = new long[categories.size()];

            for (int i = 0; i < categories.size(); i++) {
                de.fraunhofer.fokus.movepla.model.Category category = categories.get(i);

                categoryPKs[i] = category.getPrimaryKey();
            }

            setCategories(pk, categoryPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_CATEGORY_NAME);
        }
    }

    /**
     * Returns all the regions associated with the application.
     *
     * @param pk the primary key of the application
     * @return the regions associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Region> getRegions(long pk)
        throws SystemException {
        return getRegions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the regions associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of regions associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Region> getRegions(long pk,
        int start, int end) throws SystemException {
        return getRegions(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the regions associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of regions associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Region> getRegions(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Region> list = (List<de.fraunhofer.fokus.movepla.model.Region>) FinderCacheUtil.getResult(FINDER_PATH_GET_REGIONS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETREGIONS.concat(ORDER_BY_CLAUSE)
                                         .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETREGIONS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Region",
                    de.fraunhofer.fokus.movepla.model.impl.RegionImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Region>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_REGIONS,
                        finderArgs);
                } else {
                    regionPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_REGIONS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of regions associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of regions associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getRegionsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_REGIONS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETREGIONSSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_REGIONS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the region is associated with the application.
     *
     * @param pk the primary key of the application
     * @param regionPK the primary key of the region
     * @return <code>true</code> if the region is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRegion(long pk, long regionPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, regionPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_REGION,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsRegion.contains(pk, regionPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_REGION,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any regions associated with it.
     *
     * @param pk the primary key of the application to check for associations with regions
     * @return <code>true</code> if the application has any regions associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRegions(long pk) throws SystemException {
        if (getRegionsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regionPK the primary key of the region
     * @throws SystemException if a system exception occurred
     */
    public void addRegion(long pk, long regionPK) throws SystemException {
        try {
            addRegion.add(pk, regionPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param region the region
     * @throws SystemException if a system exception occurred
     */
    public void addRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws SystemException {
        try {
            addRegion.add(pk, region.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regionPKs the primary keys of the regions
     * @throws SystemException if a system exception occurred
     */
    public void addRegions(long pk, long[] regionPKs) throws SystemException {
        try {
            for (long regionPK : regionPKs) {
                addRegion.add(pk, regionPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regions the regions
     * @throws SystemException if a system exception occurred
     */
    public void addRegions(long pk,
        List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Region region : regions) {
                addRegion.add(pk, region.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Clears all associations between the application and its regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application to clear the associated regions from
     * @throws SystemException if a system exception occurred
     */
    public void clearRegions(long pk) throws SystemException {
        try {
            clearRegions.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regionPK the primary key of the region
     * @throws SystemException if a system exception occurred
     */
    public void removeRegion(long pk, long regionPK) throws SystemException {
        try {
            removeRegion.remove(pk, regionPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param region the region
     * @throws SystemException if a system exception occurred
     */
    public void removeRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws SystemException {
        try {
            removeRegion.remove(pk, region.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regionPKs the primary keys of the regions
     * @throws SystemException if a system exception occurred
     */
    public void removeRegions(long pk, long[] regionPKs)
        throws SystemException {
        try {
            for (long regionPK : regionPKs) {
                removeRegion.remove(pk, regionPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regions the regions
     * @throws SystemException if a system exception occurred
     */
    public void removeRegions(long pk,
        List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Region region : regions) {
                removeRegion.remove(pk, region.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regionPKs the primary keys of the regions to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setRegions(long pk, long[] regionPKs) throws SystemException {
        try {
            Set<Long> regionPKSet = SetUtil.fromArray(regionPKs);

            List<de.fraunhofer.fokus.movepla.model.Region> regions = getRegions(pk);

            for (de.fraunhofer.fokus.movepla.model.Region region : regions) {
                if (!regionPKSet.remove(region.getPrimaryKey())) {
                    removeRegion.remove(pk, region.getPrimaryKey());
                }
            }

            for (Long regionPK : regionPKSet) {
                addRegion.add(pk, regionPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param regions the regions to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setRegions(long pk,
        List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws SystemException {
        try {
            long[] regionPKs = new long[regions.size()];

            for (int i = 0; i < regions.size(); i++) {
                de.fraunhofer.fokus.movepla.model.Region region = regions.get(i);

                regionPKs[i] = region.getPrimaryKey();
            }

            setRegions(pk, regionPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_REGION_NAME);
        }
    }

    /**
     * Returns all the links associated with the application.
     *
     * @param pk the primary key of the application
     * @return the links associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Link> getLinks(long pk)
        throws SystemException {
        return getLinks(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the links associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of links associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Link> getLinks(long pk,
        int start, int end) throws SystemException {
        return getLinks(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the links associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of links associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Link> getLinks(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Link> list = (List<de.fraunhofer.fokus.movepla.model.Link>) FinderCacheUtil.getResult(FINDER_PATH_GET_LINKS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETLINKS.concat(ORDER_BY_CLAUSE)
                                       .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETLINKS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Link",
                    de.fraunhofer.fokus.movepla.model.impl.LinkImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Link>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_LINKS,
                        finderArgs);
                } else {
                    linkPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_LINKS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of links associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of links associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getLinksSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_LINKS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETLINKSSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_LINKS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the link is associated with the application.
     *
     * @param pk the primary key of the application
     * @param linkPK the primary key of the link
     * @return <code>true</code> if the link is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLink(long pk, long linkPK) throws SystemException {
        Object[] finderArgs = new Object[] { pk, linkPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LINK,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsLink.contains(pk, linkPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LINK,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any links associated with it.
     *
     * @param pk the primary key of the application to check for associations with links
     * @return <code>true</code> if the application has any links associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLinks(long pk) throws SystemException {
        if (getLinksSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns all the multi medias associated with the application.
     *
     * @param pk the primary key of the application
     * @return the multi medias associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk) throws SystemException {
        return getMultiMedias(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the multi medias associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of multi medias associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end) throws SystemException {
        return getMultiMedias(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the multi medias associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of multi medias associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.MultiMedia> list = (List<de.fraunhofer.fokus.movepla.model.MultiMedia>) FinderCacheUtil.getResult(FINDER_PATH_GET_MULTIMEDIAS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETMULTIMEDIAS.concat(ORDER_BY_CLAUSE)
                                             .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETMULTIMEDIAS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_MultiMedia",
                    de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.MultiMedia>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_MULTIMEDIAS,
                        finderArgs);
                } else {
                    multiMediaPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_MULTIMEDIAS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of multi medias associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of multi medias associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getMultiMediasSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_MULTIMEDIAS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETMULTIMEDIASSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_MULTIMEDIAS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the multi media is associated with the application.
     *
     * @param pk the primary key of the application
     * @param multiMediaPK the primary key of the multi media
     * @return <code>true</code> if the multi media is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsMultiMedia(long pk, long multiMediaPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, multiMediaPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_MULTIMEDIA,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsMultiMedia.contains(pk,
                            multiMediaPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_MULTIMEDIA,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any multi medias associated with it.
     *
     * @param pk the primary key of the application to check for associations with multi medias
     * @return <code>true</code> if the application has any multi medias associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsMultiMedias(long pk) throws SystemException {
        if (getMultiMediasSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns all the languages associated with the application.
     *
     * @param pk the primary key of the application
     * @return the languages associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk) throws SystemException {
        return getLanguages(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the languages associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of languages associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end) throws SystemException {
        return getLanguages(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the languages associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of languages associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.Language> list = (List<de.fraunhofer.fokus.movepla.model.Language>) FinderCacheUtil.getResult(FINDER_PATH_GET_LANGUAGES,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETLANGUAGES.concat(ORDER_BY_CLAUSE)
                                           .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETLANGUAGES;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_Language",
                    de.fraunhofer.fokus.movepla.model.impl.LanguageImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.Language>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_LANGUAGES,
                        finderArgs);
                } else {
                    languagePersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_LANGUAGES,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of languages associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of languages associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getLanguagesSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_LANGUAGES_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETLANGUAGESSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_LANGUAGES_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the language is associated with the application.
     *
     * @param pk the primary key of the application
     * @param languagePK the primary key of the language
     * @return <code>true</code> if the language is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLanguage(long pk, long languagePK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, languagePK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LANGUAGE,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsLanguage.contains(pk, languagePK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LANGUAGE,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any languages associated with it.
     *
     * @param pk the primary key of the application to check for associations with languages
     * @return <code>true</code> if the application has any languages associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLanguages(long pk) throws SystemException {
        if (getLanguagesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languagePK the primary key of the language
     * @throws SystemException if a system exception occurred
     */
    public void addLanguage(long pk, long languagePK) throws SystemException {
        try {
            addLanguage.add(pk, languagePK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param language the language
     * @throws SystemException if a system exception occurred
     */
    public void addLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws SystemException {
        try {
            addLanguage.add(pk, language.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languagePKs the primary keys of the languages
     * @throws SystemException if a system exception occurred
     */
    public void addLanguages(long pk, long[] languagePKs)
        throws SystemException {
        try {
            for (long languagePK : languagePKs) {
                addLanguage.add(pk, languagePK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languages the languages
     * @throws SystemException if a system exception occurred
     */
    public void addLanguages(long pk,
        List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Language language : languages) {
                addLanguage.add(pk, language.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Clears all associations between the application and its languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application to clear the associated languages from
     * @throws SystemException if a system exception occurred
     */
    public void clearLanguages(long pk) throws SystemException {
        try {
            clearLanguages.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languagePK the primary key of the language
     * @throws SystemException if a system exception occurred
     */
    public void removeLanguage(long pk, long languagePK)
        throws SystemException {
        try {
            removeLanguage.remove(pk, languagePK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param language the language
     * @throws SystemException if a system exception occurred
     */
    public void removeLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws SystemException {
        try {
            removeLanguage.remove(pk, language.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languagePKs the primary keys of the languages
     * @throws SystemException if a system exception occurred
     */
    public void removeLanguages(long pk, long[] languagePKs)
        throws SystemException {
        try {
            for (long languagePK : languagePKs) {
                removeLanguage.remove(pk, languagePK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languages the languages
     * @throws SystemException if a system exception occurred
     */
    public void removeLanguages(long pk,
        List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws SystemException {
        try {
            for (de.fraunhofer.fokus.movepla.model.Language language : languages) {
                removeLanguage.remove(pk, language.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languagePKs the primary keys of the languages to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setLanguages(long pk, long[] languagePKs)
        throws SystemException {
        try {
            Set<Long> languagePKSet = SetUtil.fromArray(languagePKs);

            List<de.fraunhofer.fokus.movepla.model.Language> languages = getLanguages(pk);

            for (de.fraunhofer.fokus.movepla.model.Language language : languages) {
                if (!languagePKSet.remove(language.getPrimaryKey())) {
                    removeLanguage.remove(pk, language.getPrimaryKey());
                }
            }

            for (Long languagePK : languagePKSet) {
                addLanguage.add(pk, languagePK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the application
     * @param languages the languages to be associated with the application
     * @throws SystemException if a system exception occurred
     */
    public void setLanguages(long pk,
        List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws SystemException {
        try {
            long[] languagePKs = new long[languages.size()];

            for (int i = 0; i < languages.size(); i++) {
                de.fraunhofer.fokus.movepla.model.Language language = languages.get(i);

                languagePKs[i] = language.getPrimaryKey();
            }

            setLanguages(pk, languagePKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ApplicationModelImpl.MAPPING_TABLE_MVP_APPLICATION_LANGUAGE_NAME);
        }
    }

    /**
     * Returns all the application_ entitlements associated with the application.
     *
     * @param pk the primary key of the application
     * @return the application_ entitlements associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk) throws SystemException {
        return getApplication_Entitlements(pk, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the application_ entitlements associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of application_ entitlements associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end) throws SystemException {
        return getApplication_Entitlements(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the application_ entitlements associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of application_ entitlements associated with the application
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
     * Returns the number of application_ entitlements associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of application_ entitlements associated with the application
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
     * Returns <code>true</code> if the application_ entitlement is associated with the application.
     *
     * @param pk the primary key of the application
     * @param application_EntitlementPK the primary key of the application_ entitlement
     * @return <code>true</code> if the application_ entitlement is associated with the application; <code>false</code> otherwise
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
     * Returns <code>true</code> if the application has any application_ entitlements associated with it.
     *
     * @param pk the primary key of the application to check for associations with application_ entitlements
     * @return <code>true</code> if the application has any application_ entitlements associated with it; <code>false</code> otherwise
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
     * Returns all the related applicationses associated with the application.
     *
     * @param pk the primary key of the application
     * @return the related applicationses associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk) throws SystemException {
        return getRelatedApplicationses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the related applicationses associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of related applicationses associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end) throws SystemException {
        return getRelatedApplicationses(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the related applicationses associated with the application.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the application
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of related applicationses associated with the application
     * @throws SystemException if a system exception occurred
     */
    public List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<de.fraunhofer.fokus.movepla.model.RelatedApplications> list = (List<de.fraunhofer.fokus.movepla.model.RelatedApplications>) FinderCacheUtil.getResult(FINDER_PATH_GET_RELATEDAPPLICATIONSES,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETRELATEDAPPLICATIONSES.concat(ORDER_BY_CLAUSE)
                                                       .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETRELATEDAPPLICATIONSES;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("mvp_RelatedApplications",
                    de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<de.fraunhofer.fokus.movepla.model.RelatedApplications>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_RELATEDAPPLICATIONSES,
                        finderArgs);
                } else {
                    relatedApplicationsPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_RELATEDAPPLICATIONSES,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of related applicationses associated with the application.
     *
     * @param pk the primary key of the application
     * @return the number of related applicationses associated with the application
     * @throws SystemException if a system exception occurred
     */
    public int getRelatedApplicationsesSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_RELATEDAPPLICATIONSES_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETRELATEDAPPLICATIONSESSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_RELATEDAPPLICATIONSES_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the related applications is associated with the application.
     *
     * @param pk the primary key of the application
     * @param relatedApplicationsPK the primary key of the related applications
     * @return <code>true</code> if the related applications is associated with the application; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRelatedApplications(long pk,
        long relatedApplicationsPK) throws SystemException {
        Object[] finderArgs = new Object[] { pk, relatedApplicationsPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_RELATEDAPPLICATIONS,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsRelatedApplications.contains(
                            pk, relatedApplicationsPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_RELATEDAPPLICATIONS,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the application has any related applicationses associated with it.
     *
     * @param pk the primary key of the application to check for associations with related applicationses
     * @return <code>true</code> if the application has any related applicationses associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRelatedApplicationses(long pk)
        throws SystemException {
        if (getRelatedApplicationsesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the application persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.movepla.model.Application")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Application>> listenersList = new ArrayList<ModelListener<Application>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Application>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsCategory = new ContainsCategory();

        addCategory = new AddCategory();
        clearCategories = new ClearCategories();
        removeCategory = new RemoveCategory();

        containsRegion = new ContainsRegion();

        addRegion = new AddRegion();
        clearRegions = new ClearRegions();
        removeRegion = new RemoveRegion();

        containsLink = new ContainsLink();

        containsMultiMedia = new ContainsMultiMedia();

        containsLanguage = new ContainsLanguage();

        addLanguage = new AddLanguage();
        clearLanguages = new ClearLanguages();
        removeLanguage = new RemoveLanguage();

        containsApplication_Entitlement = new ContainsApplication_Entitlement();

        containsRelatedApplications = new ContainsRelatedApplications();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ApplicationImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsCategory {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsCategory() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSCATEGORY,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId, long categoryId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(categoryId)
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

    protected class AddCategory {
        private SqlUpdate _sqlUpdate;

        protected AddCategory() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO mvp_Application_Category (applicationId, categoryId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long applicationId, long categoryId)
            throws SystemException {
            if (!containsCategory.contains(applicationId, categoryId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Category>[] categoryListeners =
                    categoryPersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                    listener.onBeforeAddAssociation(categoryId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(categoryId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                    listener.onAfterAddAssociation(categoryId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ClearCategories {
        private SqlUpdate _sqlUpdate;

        protected ClearCategories() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Category WHERE applicationId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long applicationId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Category>[] categoryListeners =
                categoryPersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Category> categories = null;

            if ((listeners.length > 0) || (categoryListeners.length > 0)) {
                categories = getCategories(applicationId);

                for (de.fraunhofer.fokus.movepla.model.Category category : categories) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onBeforeRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                            category.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                        listener.onBeforeRemoveAssociation(category.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(applicationId) });

            if ((listeners.length > 0) || (categoryListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Category category : categories) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onAfterRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                            category.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                        listener.onAfterRemoveAssociation(category.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }
        }
    }

    protected class RemoveCategory {
        private SqlUpdate _sqlUpdate;

        protected RemoveCategory() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Category WHERE applicationId = ? AND categoryId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long applicationId, long categoryId)
            throws SystemException {
            if (containsCategory.contains(applicationId, categoryId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Category>[] categoryListeners =
                    categoryPersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                    listener.onBeforeRemoveAssociation(categoryId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(categoryId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Category> listener : categoryListeners) {
                    listener.onAfterRemoveAssociation(categoryId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ContainsRegion {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsRegion() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSREGION,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId, long regionId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(regionId)
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

    protected class AddRegion {
        private SqlUpdate _sqlUpdate;

        protected AddRegion() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO mvp_Application_Region (applicationId, regionId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long applicationId, long regionId)
            throws SystemException {
            if (!containsRegion.contains(applicationId, regionId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Region>[] regionListeners =
                    regionPersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                        regionId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                    listener.onBeforeAddAssociation(regionId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(regionId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                        regionId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                    listener.onAfterAddAssociation(regionId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ClearRegions {
        private SqlUpdate _sqlUpdate;

        protected ClearRegions() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Region WHERE applicationId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long applicationId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Region>[] regionListeners =
                regionPersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Region> regions = null;

            if ((listeners.length > 0) || (regionListeners.length > 0)) {
                regions = getRegions(applicationId);

                for (de.fraunhofer.fokus.movepla.model.Region region : regions) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onBeforeRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                            region.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                        listener.onBeforeRemoveAssociation(region.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(applicationId) });

            if ((listeners.length > 0) || (regionListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Region region : regions) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onAfterRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                            region.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                        listener.onAfterRemoveAssociation(region.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }
        }
    }

    protected class RemoveRegion {
        private SqlUpdate _sqlUpdate;

        protected RemoveRegion() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Region WHERE applicationId = ? AND regionId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long applicationId, long regionId)
            throws SystemException {
            if (containsRegion.contains(applicationId, regionId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Region>[] regionListeners =
                    regionPersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                        regionId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                    listener.onBeforeRemoveAssociation(regionId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(regionId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Region.class.getName(),
                        regionId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Region> listener : regionListeners) {
                    listener.onAfterRemoveAssociation(regionId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ContainsLink {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsLink() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSLINK,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId, long linkId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(linkId)
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

    protected class ContainsMultiMedia {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsMultiMedia() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSMULTIMEDIA,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId, long multiMediaId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(multiMediaId)
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

    protected class ContainsLanguage {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsLanguage() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSLANGUAGE,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId, long LanguageId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(LanguageId)
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

    protected class AddLanguage {
        private SqlUpdate _sqlUpdate;

        protected AddLanguage() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO mvp_Application_Language (applicationId, LanguageId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long applicationId, long LanguageId)
            throws SystemException {
            if (!containsLanguage.contains(applicationId, LanguageId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Language>[] languageListeners =
                    languagePersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                        LanguageId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                    listener.onBeforeAddAssociation(LanguageId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(LanguageId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterAddAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                        LanguageId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                    listener.onAfterAddAssociation(LanguageId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ClearLanguages {
        private SqlUpdate _sqlUpdate;

        protected ClearLanguages() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Language WHERE applicationId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long applicationId) throws SystemException {
            ModelListener<de.fraunhofer.fokus.movepla.model.Language>[] languageListeners =
                languagePersistence.getListeners();

            List<de.fraunhofer.fokus.movepla.model.Language> languages = null;

            if ((listeners.length > 0) || (languageListeners.length > 0)) {
                languages = getLanguages(applicationId);

                for (de.fraunhofer.fokus.movepla.model.Language language : languages) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onBeforeRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                            language.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                        listener.onBeforeRemoveAssociation(language.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(applicationId) });

            if ((listeners.length > 0) || (languageListeners.length > 0)) {
                for (de.fraunhofer.fokus.movepla.model.Language language : languages) {
                    for (ModelListener<Application> listener : listeners) {
                        listener.onAfterRemoveAssociation(applicationId,
                            de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                            language.getPrimaryKey());
                    }

                    for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                        listener.onAfterRemoveAssociation(language.getPrimaryKey(),
                            Application.class.getName(), applicationId);
                    }
                }
            }
        }
    }

    protected class RemoveLanguage {
        private SqlUpdate _sqlUpdate;

        protected RemoveLanguage() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM mvp_Application_Language WHERE applicationId = ? AND LanguageId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long applicationId, long LanguageId)
            throws SystemException {
            if (containsLanguage.contains(applicationId, LanguageId)) {
                ModelListener<de.fraunhofer.fokus.movepla.model.Language>[] languageListeners =
                    languagePersistence.getListeners();

                for (ModelListener<Application> listener : listeners) {
                    listener.onBeforeRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                        LanguageId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                    listener.onBeforeRemoveAssociation(LanguageId,
                        Application.class.getName(), applicationId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(applicationId), new Long(LanguageId)
                    });

                for (ModelListener<Application> listener : listeners) {
                    listener.onAfterRemoveAssociation(applicationId,
                        de.fraunhofer.fokus.movepla.model.Language.class.getName(),
                        LanguageId);
                }

                for (ModelListener<de.fraunhofer.fokus.movepla.model.Language> listener : languageListeners) {
                    listener.onAfterRemoveAssociation(LanguageId,
                        Application.class.getName(), applicationId);
                }
            }
        }
    }

    protected class ContainsApplication_Entitlement {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsApplication_Entitlement() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSAPPLICATION_ENTITLEMENT,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId,
            long applicationEntitlementID) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId),
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

    protected class ContainsRelatedApplications {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsRelatedApplications() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRELATEDAPPLICATIONS,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long applicationId,
            long RelatedApplicationsID) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(applicationId), new Long(RelatedApplicationsID)
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
