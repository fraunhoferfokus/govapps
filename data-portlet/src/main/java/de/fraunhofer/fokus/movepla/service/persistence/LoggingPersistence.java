package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LoggingPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.movepla.model.Logging;

/**
 * The persistence interface for the logging service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LoggingPersistenceImpl
 * @see LoggingUtil
 * @generated
 */
public interface LoggingPersistence extends BasePersistence<Logging> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LoggingUtil} to access the logging persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the logging in the entity cache if it is enabled.
    *
    * @param logging the logging
    */
    public void cacheResult(de.fraunhofer.fokus.movepla.model.Logging logging);

    /**
    * Caches the loggings in the entity cache if it is enabled.
    *
    * @param loggings the loggings
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Logging> loggings);

    /**
    * Creates a new logging with the primary key. Does not add the logging to the database.
    *
    * @param loggingId the primary key for the new logging
    * @return the new logging
    */
    public de.fraunhofer.fokus.movepla.model.Logging create(long loggingId);

    /**
    * Removes the logging with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param loggingId the primary key of the logging
    * @return the logging that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging remove(long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    public de.fraunhofer.fokus.movepla.model.Logging updateImpl(
        de.fraunhofer.fokus.movepla.model.Logging logging, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the logging with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLoggingException} if it could not be found.
    *
    * @param loggingId the primary key of the logging
    * @return the logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByPrimaryKey(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the logging with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param loggingId the primary key of the logging
    * @return the logging, or <code>null</code> if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByPrimaryKey(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByall(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging findByall_First(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

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
    public de.fraunhofer.fokus.movepla.model.Logging fetchByall_First(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging findByall_Last(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

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
    public de.fraunhofer.fokus.movepla.model.Logging fetchByall_Last(
        java.lang.String searchString, java.lang.String categoryIDString,
        java.lang.String regionIDString, java.lang.String entitlementIDString,
        java.lang.String targetOS, int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findByall_PrevAndNext(
        long loggingId, java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where searchString = &#63;.
    *
    * @param searchString the search string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBysearchString(
        java.lang.String searchString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBysearchString_First(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBysearchString_First(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBysearchString_Last(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where searchString = &#63;.
    *
    * @param searchString the search string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBysearchString_Last(
        java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findBysearchString_PrevAndNext(
        long loggingId, java.lang.String searchString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBycategoryIDString(
        java.lang.String categoryIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBycategoryIDString_First(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBycategoryIDString_First(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBycategoryIDString_Last(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBycategoryIDString_Last(
        java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findBycategoryIDString_PrevAndNext(
        long loggingId, java.lang.String categoryIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionIDString(
        java.lang.String regionIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByregionIDString_First(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByregionIDString_First(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByregionIDString_Last(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByregionIDString_Last(
        java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findByregionIDString_PrevAndNext(
        long loggingId, java.lang.String regionIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByregionentitlementIDStringIDString_First(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByregionentitlementIDStringIDString_First(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByregionentitlementIDStringIDString_Last(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByregionentitlementIDStringIDString_Last(
        java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findByregionentitlementIDStringIDString_PrevAndNext(
        long loggingId, java.lang.String entitlementIDString,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetOS(
        java.lang.String targetOS, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBytargetOS_First(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBytargetOS_First(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBytargetOS_Last(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBytargetOS_Last(
        java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findBytargetOS_PrevAndNext(
        long loggingId, java.lang.String targetOS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where fee = &#63;.
    *
    * @param fee the fee
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findByfee(
        int fee, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByfee_First(int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByfee_First(int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findByfee_Last(int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where fee = &#63;.
    *
    * @param fee the fee
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchByfee_Last(int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findByfee_PrevAndNext(
        long loggingId, int fee,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBytargetCategory(
        java.lang.String targetCategory, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBytargetCategory_First(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBytargetCategory_First(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBytargetCategory_Last(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBytargetCategory_Last(
        java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findBytargetCategory_PrevAndNext(
        long loggingId, java.lang.String targetCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings where passel &ge; &#63;.
    *
    * @param passel the passel
    * @return the matching loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findBypassel(
        long passel, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBypassel_First(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the first logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBypassel_First(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging
    * @throws de.fraunhofer.fokus.movepla.NoSuchLoggingException if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging findBypassel_Last(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns the last logging in the ordered set where passel &ge; &#63;.
    *
    * @param passel the passel
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching logging, or <code>null</code> if a matching logging could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Logging fetchBypassel_Last(
        long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Logging[] findBypassel_PrevAndNext(
        long loggingId, long passel,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLoggingException;

    /**
    * Returns all the loggings.
    *
    * @return the loggings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Logging> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public void removeByall(java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where searchString = &#63; from the database.
    *
    * @param searchString the search string
    * @throws SystemException if a system exception occurred
    */
    public void removeBysearchString(java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where categoryIDString = &#63; from the database.
    *
    * @param categoryIDString the category i d string
    * @throws SystemException if a system exception occurred
    */
    public void removeBycategoryIDString(java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where regionIDString = &#63; from the database.
    *
    * @param regionIDString the region i d string
    * @throws SystemException if a system exception occurred
    */
    public void removeByregionIDString(java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where entitlementIDString = &#63; from the database.
    *
    * @param entitlementIDString the entitlement i d string
    * @throws SystemException if a system exception occurred
    */
    public void removeByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where targetOS = &#63; from the database.
    *
    * @param targetOS the target o s
    * @throws SystemException if a system exception occurred
    */
    public void removeBytargetOS(java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where fee = &#63; from the database.
    *
    * @param fee the fee
    * @throws SystemException if a system exception occurred
    */
    public void removeByfee(int fee)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where targetCategory = &#63; from the database.
    *
    * @param targetCategory the target category
    * @throws SystemException if a system exception occurred
    */
    public void removeBytargetCategory(java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings where passel &ge; &#63; from the database.
    *
    * @param passel the passel
    * @throws SystemException if a system exception occurred
    */
    public void removeBypassel(long passel)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the loggings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public int countByall(java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where searchString = &#63;.
    *
    * @param searchString the search string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countBysearchString(java.lang.String searchString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where categoryIDString = &#63;.
    *
    * @param categoryIDString the category i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countBycategoryIDString(java.lang.String categoryIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where regionIDString = &#63;.
    *
    * @param regionIDString the region i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countByregionIDString(java.lang.String regionIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where entitlementIDString = &#63;.
    *
    * @param entitlementIDString the entitlement i d string
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countByregionentitlementIDStringIDString(
        java.lang.String entitlementIDString)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where targetOS = &#63;.
    *
    * @param targetOS the target o s
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countBytargetOS(java.lang.String targetOS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where fee = &#63;.
    *
    * @param fee the fee
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countByfee(int fee)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where targetCategory = &#63;.
    *
    * @param targetCategory the target category
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countBytargetCategory(java.lang.String targetCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings where passel &ge; &#63;.
    *
    * @param passel the passel
    * @return the number of matching loggings
    * @throws SystemException if a system exception occurred
    */
    public int countBypassel(long passel)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of loggings.
    *
    * @return the number of loggings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
