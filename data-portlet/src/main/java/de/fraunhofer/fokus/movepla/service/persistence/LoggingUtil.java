package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LoggingUtil.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.movepla.model.Logging;

import java.util.List;

/**
 * The persistence utility for the logging service. This utility wraps {@link LoggingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LoggingPersistence
 * @see LoggingPersistenceImpl
 * @generated
 */
public class LoggingUtil {
    private static LoggingPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Logging logging) {
        getPersistence().clearCache(logging);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Logging> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Logging> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Logging> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Logging update(Logging logging, boolean merge)
        throws SystemException {
        return getPersistence().update(logging, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Logging update(Logging logging, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(logging, merge, serviceContext);
    }

    /**
    * Caches the logging in the entity cache if it is enabled.
    *
    * @param logging the logging
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.Logging logging) {
        getPersistence().cacheResult(logging);
    }

    /**
    * Caches the loggings in the entity cache if it is enabled.
    *
    * @param loggings the loggings
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Logging> loggings) {
        getPersistence().cacheResult(loggings);
    }

    /**
    * Creates a new logging with the primary key. Does not add the logging to the database.
    *
    * @param loggingId the primary key for the new logging
    * @return the new logging
    */
    public static de.fraunhofer.fokus.movepla.model.Logging create(
        long loggingId) {
        return getPersistence().create(loggingId);
    }

    /**
    * Removes the logging with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param loggingId the primary key of the logging
    * @return the logging that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging remove(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().remove(loggingId);
    }

    public static de.fraunhofer.fokus.movepla.model.Logging updateImpl(
        de.fraunhofer.fokus.movepla.model.Logging logging, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(logging, merge);
    }

    /**
    * Returns the logging with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLoggingException} if it could not be found.
    *
    * @param loggingId the primary key of the logging
    * @return the logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging findByPrimaryKey(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findByPrimaryKey(loggingId);
    }

    /**
    * Returns the logging with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param loggingId the primary key of the logging
    * @return the logging, or <code>null</code> if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByPrimaryKey(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(loggingId);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByall_First(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByall_First(searchString, categoryIDString,
            regionIDString, entitlementIDString, targetOS, fee, targetCategory,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByall_First(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByall_First(searchString, categoryIDString,
            regionIDString, entitlementIDString, targetOS, fee, targetCategory,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByall_Last(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByall_Last(searchString, categoryIDString,
            regionIDString, entitlementIDString, targetOS, fee, targetCategory,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByall_Last(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByall_Last(searchString, categoryIDString,
            regionIDString, entitlementIDString, targetOS, fee, targetCategory,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findByall_PrevAndNext(
        long loggingId, java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByall_PrevAndNext(loggingId, searchString,
            categoryIDString, regionIDString, entitlementIDString, targetOS,
            fee, targetCategory, orderByComparator);
    }

    /**
    * Returns all the loggings where searchString = &#63;.
    *
    * @param searchString the search string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBysearchString(searchString);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBysearchString(searchString, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBysearchString(searchString, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBysearchString_First(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBysearchString_First(searchString, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBysearchString_First(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBysearchString_First(searchString, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBysearchString_Last(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBysearchString_Last(searchString, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBysearchString_Last(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBysearchString_Last(searchString, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findBysearchString_PrevAndNext(
        long loggingId, java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBysearchString_PrevAndNext(loggingId, searchString,
            orderByComparator);
    }

    /**
    * Returns all the loggings where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycategoryIDString(categoryIDString);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycategoryIDString(categoryIDString, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycategoryIDString(categoryIDString, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBycategoryIDString_First(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBycategoryIDString_First(categoryIDString,
            orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBycategoryIDString_First(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycategoryIDString_First(categoryIDString,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBycategoryIDString_Last(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBycategoryIDString_Last(categoryIDString,
            orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBycategoryIDString_Last(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycategoryIDString_Last(categoryIDString,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findBycategoryIDString_PrevAndNext(
        long loggingId, java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBycategoryIDString_PrevAndNext(loggingId,
            categoryIDString, orderByComparator);
    }

    /**
    * Returns all the loggings where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregionIDString(regionIDString);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregionIDString(regionIDString, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregionIDString(regionIDString, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByregionIDString_First(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionIDString_First(regionIDString, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByregionIDString_First(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregionIDString_First(regionIDString,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByregionIDString_Last(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionIDString_Last(regionIDString, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByregionIDString_Last(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregionIDString_Last(regionIDString, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findByregionIDString_PrevAndNext(
        long loggingId, java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionIDString_PrevAndNext(loggingId, regionIDString,
            orderByComparator);
    }

    /**
    * Returns all the loggings where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString(entitlementIDString);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString(entitlementIDString,
            start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString(entitlementIDString,
            start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByregionentitlementIDStringIDString_First(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString_First(entitlementIDString,
            orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByregionentitlementIDStringIDString_First(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregionentitlementIDStringIDString_First(entitlementIDString,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByregionentitlementIDStringIDString_Last(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString_Last(entitlementIDString,
            orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByregionentitlementIDStringIDString_Last(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregionentitlementIDStringIDString_Last(entitlementIDString,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findByregionentitlementIDStringIDString_PrevAndNext(
        long loggingId, java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByregionentitlementIDStringIDString_PrevAndNext(loggingId,
            entitlementIDString, orderByComparator);
    }

    /**
    * Returns all the loggings where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytargetOS(targetOS);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytargetOS(targetOS, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBytargetOS(targetOS, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBytargetOS_First(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findBytargetOS_First(targetOS, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBytargetOS_First(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBytargetOS_First(targetOS, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBytargetOS_Last(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findBytargetOS_Last(targetOS, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBytargetOS_Last(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytargetOS_Last(targetOS, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findBytargetOS_PrevAndNext(
        long loggingId, java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBytargetOS_PrevAndNext(loggingId, targetOS,
            orderByComparator);
    }

    /**
    * Returns all the loggings where fee = &#63;.
    *
    * @param fee the fee
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByfee(fee);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByfee(fee, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByfee(fee, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByfee_First(
        int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findByfee_First(fee, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByfee_First(
        int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByfee_First(fee, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findByfee_Last(
        int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findByfee_Last(fee, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchByfee_Last(
        int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByfee_Last(fee, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findByfee_PrevAndNext(
        long loggingId, int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findByfee_PrevAndNext(loggingId, fee, orderByComparator);
    }

    /**
    * Returns all the loggings where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytargetCategory(targetCategory);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytargetCategory(targetCategory, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBytargetCategory(targetCategory, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBytargetCategory_First(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBytargetCategory_First(targetCategory, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBytargetCategory_First(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBytargetCategory_First(targetCategory,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBytargetCategory_Last(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBytargetCategory_Last(targetCategory, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBytargetCategory_Last(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBytargetCategory_Last(targetCategory, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findBytargetCategory_PrevAndNext(
        long loggingId, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBytargetCategory_PrevAndNext(loggingId, targetCategory,
            orderByComparator);
    }

    /**
    * Returns all the loggings where passel &ge; &#63;.
    *
    * @param passel the passel
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBypassel(passel);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBypassel(passel, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBypassel(passel, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBypassel_First(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findBypassel_First(passel, orderByComparator);
    }

    /**
    * Returns the first logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBypassel_First(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBypassel_First(passel, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging findBypassel_Last(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence().findBypassel_Last(passel, orderByComparator);
    }

    /**
    * Returns the last logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging fetchBypassel_Last(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBypassel_Last(passel, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Logging[] findBypassel_PrevAndNext(
        long loggingId, long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException {
        return getPersistence()
                   .findBypassel_PrevAndNext(loggingId, passel,
            orderByComparator);
    }

    /**
    * Returns all the loggings.
    *
    * @return the loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
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
    public static void removeByall(java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory);
    }

    /**
    * Removes all the loggings where searchString = &#63; from the database.
    *
    * @param searchString the search string
    * @throws SystemException if a system exception occurred
    */
    public static void removeBysearchString(java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBysearchString(searchString);
    }

    /**
    * Removes all the loggings where categoryIDString = &#63; from the database.
    *
    * @param categoryIDString the category i d string
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycategoryIDString(
        java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycategoryIDString(categoryIDString);
    }

    /**
    * Removes all the loggings where regionIDString = &#63; from the database.
    *
    * @param regionIDString the region i d string
    * @throws SystemException if a system exception occurred
    */
    public static void removeByregionIDString(java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByregionIDString(regionIDString);
    }

    /**
    * Removes all the loggings where entitlementIDString = &#63; from the database.
    *
    * @param entitlementIDString the entitlement i d string
    * @throws SystemException if a system exception occurred
    */
    public static void removeByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByregionentitlementIDStringIDString(entitlementIDString);
    }

    /**
    * Removes all the loggings where targetOS = &#63; from the database.
    *
    * @param targetOS the target o s
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytargetOS(java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytargetOS(targetOS);
    }

    /**
    * Removes all the loggings where fee = &#63; from the database.
    *
    * @param fee the fee
    * @throws SystemException if a system exception occurred
    */
    public static void removeByfee(int fee)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByfee(fee);
    }

    /**
    * Removes all the loggings where targetCategory = &#63; from the database.
    *
    * @param targetCategory the target category
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytargetCategory(java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytargetCategory(targetCategory);
    }

    /**
    * Removes all the loggings where passel &ge; &#63; from the database.
    *
    * @param passel the passel
    * @throws SystemException if a system exception occurred
    */
    public static void removeBypassel(long passel)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBypassel(passel);
    }

    /**
    * Removes all the loggings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
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
    public static int countByall(java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByall(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory);
    }

    /**
    * Returns the number of loggings where searchString = &#63;.
    *
    * @param searchString the search string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countBysearchString(java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBysearchString(searchString);
    }

    /**
    * Returns the number of loggings where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countBycategoryIDString(java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycategoryIDString(categoryIDString);
    }

    /**
    * Returns the number of loggings where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countByregionIDString(java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByregionIDString(regionIDString);
    }

    /**
    * Returns the number of loggings where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByregionentitlementIDStringIDString(entitlementIDString);
    }

    /**
    * Returns the number of loggings where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countBytargetOS(java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytargetOS(targetOS);
    }

    /**
    * Returns the number of loggings where fee = &#63;.
    *
    * @param fee the fee
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countByfee(int fee)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByfee(fee);
    }

    /**
    * Returns the number of loggings where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countBytargetCategory(java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytargetCategory(targetCategory);
    }

    /**
    * Returns the number of loggings where passel &ge; &#63;.
    *
    * @param passel the passel
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countBypassel(long passel)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBypassel(passel);
    }

    /**
    * Returns the number of loggings.
    *
    * @return the number of loggings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LoggingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LoggingPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    LoggingPersistence.class.getName());

            ReferenceRegistry.registerReference(LoggingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LoggingPersistence persistence) {
    }
}
