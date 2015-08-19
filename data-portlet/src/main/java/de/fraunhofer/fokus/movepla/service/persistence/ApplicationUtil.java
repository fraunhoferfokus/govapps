package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application;

import java.util.List;

/**
 * The persistence utility for the application service. This utility wraps {@link ApplicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see ApplicationPersistence
 * @see ApplicationPersistenceImpl
 * @generated
 */
public class ApplicationUtil {
    private static ApplicationPersistence _persistence;

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
    public static void clearCache(Application application) {
        getPersistence().clearCache(application);
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
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Application update(Application application, boolean merge)
        throws SystemException {
        return getPersistence().update(application, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Application update(Application application, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(application, merge, serviceContext);
    }

    /**
    * Caches the application in the entity cache if it is enabled.
    *
    * @param application the application
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.Application application) {
        getPersistence().cacheResult(application);
    }

    /**
    * Caches the applications in the entity cache if it is enabled.
    *
    * @param applications the applications
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications) {
        getPersistence().cacheResult(applications);
    }

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public static de.fraunhofer.fokus.movepla.model.Application create(
        long applicationId) {
        return getPersistence().create(applicationId);
    }

    /**
    * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application remove(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().remove(applicationId);
    }

    public static de.fraunhofer.fokus.movepla.model.Application updateImpl(
        de.fraunhofer.fokus.movepla.model.Application application, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(application, merge);
    }

    /**
    * Returns the application with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplicationException} if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application findByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findByPrimaryKey(applicationId);
    }

    /**
    * Returns the application with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application, or <code>null</code> if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(applicationId);
    }

    /**
    * Returns all the applications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findByc_PrevAndNext(
        long applicationId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByc_PrevAndNext(applicationId, companyId,
            orderByComparator);
    }

    /**
    * Returns all the applications where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycu(companyId, userId);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycu(companyId, userId, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycu(companyId, userId, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBycu_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycu_First(companyId, userId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchBycu_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycu_First(companyId, userId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBycu_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycu_Last(companyId, userId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchBycu_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycu_Last(companyId, userId, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBycu_PrevAndNext(
        long applicationId, long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycu_PrevAndNext(applicationId, companyId, userId,
            orderByComparator);
    }

    /**
    * Returns all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycl(companyId, lifeCycleStatus);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycl(companyId, lifeCycleStatus, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycl(companyId, lifeCycleStatus, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBycl_First(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycl_First(companyId, lifeCycleStatus, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchBycl_First(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycl_First(companyId, lifeCycleStatus,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBycl_Last(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycl_Last(companyId, lifeCycleStatus, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchBycl_Last(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycl_Last(companyId, lifeCycleStatus, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBycl_PrevAndNext(
        long applicationId, long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBycl_PrevAndNext(applicationId, companyId,
            lifeCycleStatus, orderByComparator);
    }

    /**
    * Returns all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByml(modifiedDate, lifeCycleStatus);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByml(modifiedDate, lifeCycleStatus, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByml(modifiedDate, lifeCycleStatus, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByml_First(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByml_First(modifiedDate, lifeCycleStatus,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchByml_First(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByml_First(modifiedDate, lifeCycleStatus,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByml_Last(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByml_Last(modifiedDate, lifeCycleStatus,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application fetchByml_Last(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByml_Last(modifiedDate, lifeCycleStatus,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findByml_PrevAndNext(
        long applicationId, java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByml_PrevAndNext(applicationId, modifiedDate,
            lifeCycleStatus, orderByComparator);
    }

    /**
    * Returns all the applications where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBym(modifiedDate);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBym(modifiedDate, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBym(modifiedDate, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBym_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findBym_First(modifiedDate, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBym_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBym_First(modifiedDate, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBym_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findBym_Last(modifiedDate, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBym_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBym_Last(modifiedDate, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBym_PrevAndNext(
        long applicationId, java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBym_PrevAndNext(applicationId, modifiedDate,
            orderByComparator);
    }

    /**
    * Returns all the applications where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBym2(modifiedDate);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBym2(modifiedDate, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBym2(modifiedDate, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBym2_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findBym2_First(modifiedDate, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBym2_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBym2_First(modifiedDate, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBym2_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence().findBym2_Last(modifiedDate, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBym2_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBym2_Last(modifiedDate, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBym2_PrevAndNext(
        long applicationId, java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBym2_PrevAndNext(applicationId, modifiedDate,
            orderByComparator);
    }

    /**
    * Returns all the applications where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBydetailsViewed(detailsViewed);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBydetailsViewed(detailsViewed, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBydetailsViewed(detailsViewed, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBydetailsViewed_First(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBydetailsViewed_First(detailsViewed, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBydetailsViewed_First(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydetailsViewed_First(detailsViewed, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBydetailsViewed_Last(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBydetailsViewed_Last(detailsViewed, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBydetailsViewed_Last(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydetailsViewed_Last(detailsViewed, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBydetailsViewed_PrevAndNext(
        long applicationId, long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBydetailsViewed_PrevAndNext(applicationId,
            detailsViewed, orderByComparator);
    }

    /**
    * Returns all the applications where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylinkClicked(linkClicked);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylinkClicked(linkClicked, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBylinkClicked(linkClicked, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBylinkClicked_First(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBylinkClicked_First(linkClicked, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBylinkClicked_First(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBylinkClicked_First(linkClicked, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findBylinkClicked_Last(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBylinkClicked_Last(linkClicked, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchBylinkClicked_Last(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBylinkClicked_Last(linkClicked, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findBylinkClicked_PrevAndNext(
        long applicationId, long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findBylinkClicked_PrevAndNext(applicationId, linkClicked,
            orderByComparator);
    }

    /**
    * Returns all the applications where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuseOpenData(useOpenData);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuseOpenData(useOpenData, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByuseOpenData(useOpenData, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByuseOpenData_First(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByuseOpenData_First(useOpenData, orderByComparator);
    }

    /**
    * Returns the first application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchByuseOpenData_First(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuseOpenData_First(useOpenData, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application findByuseOpenData_Last(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByuseOpenData_Last(useOpenData, orderByComparator);
    }

    /**
    * Returns the last application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application fetchByuseOpenData_Last(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuseOpenData_Last(useOpenData, orderByComparator);
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
    public static de.fraunhofer.fokus.movepla.model.Application[] findByuseOpenData_PrevAndNext(
        long applicationId, int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException {
        return getPersistence()
                   .findByuseOpenData_PrevAndNext(applicationId, useOpenData,
            orderByComparator);
    }

    /**
    * Returns all the applications.
    *
    * @return the applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the applications where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the applications where companyId = &#63; and userId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycu(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycu(companyId, userId);
    }

    /**
    * Removes all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63; from the database.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycl(long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycl(companyId, lifeCycleStatus);
    }

    /**
    * Removes all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByml(java.util.Date modifiedDate,
        int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByml(modifiedDate, lifeCycleStatus);
    }

    /**
    * Removes all the applications where modifiedDate &ge; &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @throws SystemException if a system exception occurred
    */
    public static void removeBym(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBym(modifiedDate);
    }

    /**
    * Removes all the applications where modifiedDate &lt; &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @throws SystemException if a system exception occurred
    */
    public static void removeBym2(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBym2(modifiedDate);
    }

    /**
    * Removes all the applications where detailsViewed &ge; &#63; from the database.
    *
    * @param detailsViewed the details viewed
    * @throws SystemException if a system exception occurred
    */
    public static void removeBydetailsViewed(long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBydetailsViewed(detailsViewed);
    }

    /**
    * Removes all the applications where linkClicked &ge; &#63; from the database.
    *
    * @param linkClicked the link clicked
    * @throws SystemException if a system exception occurred
    */
    public static void removeBylinkClicked(long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBylinkClicked(linkClicked);
    }

    /**
    * Removes all the applications where useOpenData = &#63; from the database.
    *
    * @param useOpenData the use open data
    * @throws SystemException if a system exception occurred
    */
    public static void removeByuseOpenData(int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByuseOpenData(useOpenData);
    }

    /**
    * Removes all the applications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of applications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of applications where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBycu(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycu(companyId, userId);
    }

    /**
    * Returns the number of applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBycl(long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycl(companyId, lifeCycleStatus);
    }

    /**
    * Returns the number of applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countByml(java.util.Date modifiedDate, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByml(modifiedDate, lifeCycleStatus);
    }

    /**
    * Returns the number of applications where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBym(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBym(modifiedDate);
    }

    /**
    * Returns the number of applications where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBym2(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBym2(modifiedDate);
    }

    /**
    * Returns the number of applications where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBydetailsViewed(long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBydetailsViewed(detailsViewed);
    }

    /**
    * Returns the number of applications where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countBylinkClicked(long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBylinkClicked(linkClicked);
    }

    /**
    * Returns the number of applications where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public static int countByuseOpenData(int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuseOpenData(useOpenData);
    }

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the categories associated with the application.
    *
    * @param pk the primary key of the application
    * @return the categories associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of categories associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of categories associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getCategoriesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategoriesSize(pk);
    }

    /**
    * Returns <code>true</code> if the category is associated with the application.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @return <code>true</code> if the category is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsCategory(pk, categoryPK);
    }

    /**
    * Returns <code>true</code> if the application has any categories associated with it.
    *
    * @param pk the primary key of the application to check for associations with categories
    * @return <code>true</code> if the application has any categories associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsCategories(pk);
    }

    /**
    * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public static void addCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategory(pk, categoryPK);
    }

    /**
    * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public static void addCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategory(pk, category);
    }

    /**
    * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public static void addCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategories(pk, categoryPKs);
    }

    /**
    * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public static void addCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategories(pk, categories);
    }

    /**
    * Clears all associations between the application and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated categories from
    * @throws SystemException if a system exception occurred
    */
    public static void clearCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearCategories(pk);
    }

    /**
    * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategory(pk, categoryPK);
    }

    /**
    * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategory(pk, category);
    }

    /**
    * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategories(pk, categoryPKs);
    }

    /**
    * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategories(pk, categories);
    }

    /**
    * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setCategories(pk, categoryPKs);
    }

    /**
    * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setCategories(pk, categories);
    }

    /**
    * Returns all the regions associated with the application.
    *
    * @param pk the primary key of the application
    * @return the regions associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRegions(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRegions(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRegions(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of regions associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of regions associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getRegionsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRegionsSize(pk);
    }

    /**
    * Returns <code>true</code> if the region is associated with the application.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @return <code>true</code> if the region is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsRegion(pk, regionPK);
    }

    /**
    * Returns <code>true</code> if the application has any regions associated with it.
    *
    * @param pk the primary key of the application to check for associations with regions
    * @return <code>true</code> if the application has any regions associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsRegions(pk);
    }

    /**
    * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public static void addRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addRegion(pk, regionPK);
    }

    /**
    * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public static void addRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addRegion(pk, region);
    }

    /**
    * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public static void addRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addRegions(pk, regionPKs);
    }

    /**
    * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public static void addRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addRegions(pk, regions);
    }

    /**
    * Clears all associations between the application and its regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated regions from
    * @throws SystemException if a system exception occurred
    */
    public static void clearRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearRegions(pk);
    }

    /**
    * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public static void removeRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeRegion(pk, regionPK);
    }

    /**
    * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public static void removeRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeRegion(pk, region);
    }

    /**
    * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public static void removeRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeRegions(pk, regionPKs);
    }

    /**
    * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public static void removeRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeRegions(pk, regions);
    }

    /**
    * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setRegions(pk, regionPKs);
    }

    /**
    * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setRegions(pk, regions);
    }

    /**
    * Returns all the links associated with the application.
    *
    * @param pk the primary key of the application
    * @return the links associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLinks(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLinks(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLinks(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of links associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of links associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getLinksSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLinksSize(pk);
    }

    /**
    * Returns <code>true</code> if the link is associated with the application.
    *
    * @param pk the primary key of the application
    * @param linkPK the primary key of the link
    * @return <code>true</code> if the link is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLink(long pk, long linkPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLink(pk, linkPK);
    }

    /**
    * Returns <code>true</code> if the application has any links associated with it.
    *
    * @param pk the primary key of the application to check for associations with links
    * @return <code>true</code> if the application has any links associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLinks(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLinks(pk);
    }

    /**
    * Returns all the multi medias associated with the application.
    *
    * @param pk the primary key of the application
    * @return the multi medias associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getMultiMedias(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getMultiMedias(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getMultiMedias(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of multi medias associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of multi medias associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getMultiMediasSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getMultiMediasSize(pk);
    }

    /**
    * Returns <code>true</code> if the multi media is associated with the application.
    *
    * @param pk the primary key of the application
    * @param multiMediaPK the primary key of the multi media
    * @return <code>true</code> if the multi media is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsMultiMedia(long pk, long multiMediaPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsMultiMedia(pk, multiMediaPK);
    }

    /**
    * Returns <code>true</code> if the application has any multi medias associated with it.
    *
    * @param pk the primary key of the application to check for associations with multi medias
    * @return <code>true</code> if the application has any multi medias associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsMultiMedias(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsMultiMedias(pk);
    }

    /**
    * Returns all the languages associated with the application.
    *
    * @param pk the primary key of the application
    * @return the languages associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLanguages(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLanguages(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLanguages(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of languages associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of languages associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getLanguagesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLanguagesSize(pk);
    }

    /**
    * Returns <code>true</code> if the language is associated with the application.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @return <code>true</code> if the language is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLanguage(pk, languagePK);
    }

    /**
    * Returns <code>true</code> if the application has any languages associated with it.
    *
    * @param pk the primary key of the application to check for associations with languages
    * @return <code>true</code> if the application has any languages associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLanguages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLanguages(pk);
    }

    /**
    * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @throws SystemException if a system exception occurred
    */
    public static void addLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLanguage(pk, languagePK);
    }

    /**
    * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param language the language
    * @throws SystemException if a system exception occurred
    */
    public static void addLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLanguage(pk, language);
    }

    /**
    * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages
    * @throws SystemException if a system exception occurred
    */
    public static void addLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLanguages(pk, languagePKs);
    }

    /**
    * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages
    * @throws SystemException if a system exception occurred
    */
    public static void addLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLanguages(pk, languages);
    }

    /**
    * Clears all associations between the application and its languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated languages from
    * @throws SystemException if a system exception occurred
    */
    public static void clearLanguages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearLanguages(pk);
    }

    /**
    * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @throws SystemException if a system exception occurred
    */
    public static void removeLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLanguage(pk, languagePK);
    }

    /**
    * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param language the language
    * @throws SystemException if a system exception occurred
    */
    public static void removeLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLanguage(pk, language);
    }

    /**
    * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages
    * @throws SystemException if a system exception occurred
    */
    public static void removeLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLanguages(pk, languagePKs);
    }

    /**
    * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages
    * @throws SystemException if a system exception occurred
    */
    public static void removeLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLanguages(pk, languages);
    }

    /**
    * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setLanguages(pk, languagePKs);
    }

    /**
    * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static void setLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setLanguages(pk, languages);
    }

    /**
    * Returns all the application_ entitlements associated with the application.
    *
    * @param pk the primary key of the application
    * @return the application_ entitlements associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplication_Entitlements(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplication_Entitlements(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getApplication_Entitlements(pk, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of application_ entitlements associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of application_ entitlements associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getApplication_EntitlementsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplication_EntitlementsSize(pk);
    }

    /**
    * Returns <code>true</code> if the application_ entitlement is associated with the application.
    *
    * @param pk the primary key of the application
    * @param application_EntitlementPK the primary key of the application_ entitlement
    * @return <code>true</code> if the application_ entitlement is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplication_Entitlement(long pk,
        long application_EntitlementPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .containsApplication_Entitlement(pk,
            application_EntitlementPK);
    }

    /**
    * Returns <code>true</code> if the application has any application_ entitlements associated with it.
    *
    * @param pk the primary key of the application to check for associations with application_ entitlements
    * @return <code>true</code> if the application has any application_ entitlements associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplication_Entitlements(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsApplication_Entitlements(pk);
    }

    /**
    * Returns all the related applicationses associated with the application.
    *
    * @param pk the primary key of the application
    * @return the related applicationses associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRelatedApplicationses(pk);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRelatedApplicationses(pk, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getRelatedApplicationses(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of related applicationses associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of related applicationses associated with the application
    * @throws SystemException if a system exception occurred
    */
    public static int getRelatedApplicationsesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRelatedApplicationsesSize(pk);
    }

    /**
    * Returns <code>true</code> if the related applications is associated with the application.
    *
    * @param pk the primary key of the application
    * @param relatedApplicationsPK the primary key of the related applications
    * @return <code>true</code> if the related applications is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRelatedApplications(long pk,
        long relatedApplicationsPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .containsRelatedApplications(pk, relatedApplicationsPK);
    }

    /**
    * Returns <code>true</code> if the application has any related applicationses associated with it.
    *
    * @param pk the primary key of the application to check for associations with related applicationses
    * @return <code>true</code> if the application has any related applicationses associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRelatedApplicationses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsRelatedApplicationses(pk);
    }

    public static ApplicationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ApplicationPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    ApplicationPersistence.class.getName());

            ReferenceRegistry.registerReference(ApplicationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ApplicationPersistence persistence) {
    }
}
