package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application;

/**
 * The persistence interface for the application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see ApplicationPersistenceImpl
 * @see ApplicationUtil
 * @generated
 */
public interface ApplicationPersistence extends BasePersistence<Application> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApplicationUtil} to access the application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the application in the entity cache if it is enabled.
    *
    * @param application the application
    */
    public void cacheResult(
        de.fraunhofer.fokus.movepla.model.Application application);

    /**
    * Caches the applications in the entity cache if it is enabled.
    *
    * @param applications the applications
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications);

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public de.fraunhofer.fokus.movepla.model.Application create(
        long applicationId);

    /**
    * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application remove(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    public de.fraunhofer.fokus.movepla.model.Application updateImpl(
        de.fraunhofer.fokus.movepla.model.Application application, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplicationException} if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the application with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application, or <code>null</code> if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the applications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findByc_PrevAndNext(
        long applicationId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycu(
        long companyId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findBycu_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBycu_First(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findBycu_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBycu_Last(
        long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBycu_PrevAndNext(
        long applicationId, long companyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBycl(
        long companyId, int lifeCycleStatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findBycl_First(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBycl_First(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findBycl_Last(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBycl_Last(
        long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBycl_PrevAndNext(
        long applicationId, long companyId, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByml(
        java.util.Date modifiedDate, int lifeCycleStatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findByml_First(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByml_First(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application findByml_Last(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByml_Last(
        java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findByml_PrevAndNext(
        long applicationId, java.util.Date modifiedDate, int lifeCycleStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym(
        java.util.Date modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBym_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBym_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBym_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBym_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBym_PrevAndNext(
        long applicationId, java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBym2(
        java.util.Date modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBym2_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBym2_First(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBym2_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBym2_Last(
        java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBym2_PrevAndNext(
        long applicationId, java.util.Date modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBydetailsViewed(
        long detailsViewed, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBydetailsViewed_First(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBydetailsViewed_First(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBydetailsViewed_Last(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBydetailsViewed_Last(
        long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBydetailsViewed_PrevAndNext(
        long applicationId, long detailsViewed,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findBylinkClicked(
        long linkClicked, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBylinkClicked_First(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBylinkClicked_First(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findBylinkClicked_Last(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchBylinkClicked_Last(
        long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findBylinkClicked_PrevAndNext(
        long applicationId, long linkClicked,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @return the matching applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findByuseOpenData(
        int useOpenData, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findByuseOpenData_First(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the first application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByuseOpenData_First(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplicationException if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application findByuseOpenData_Last(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns the last application in the ordered set where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application, or <code>null</code> if a matching application could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application fetchByuseOpenData_Last(
        int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Application[] findByuseOpenData_PrevAndNext(
        long applicationId, int useOpenData,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplicationException;

    /**
    * Returns all the applications.
    *
    * @return the applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where companyId = &#63; and userId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBycu(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where companyId = &#63; and lifeCycleStatus &ge; &#63; from the database.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @throws SystemException if a system exception occurred
    */
    public void removeBycl(long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @throws SystemException if a system exception occurred
    */
    public void removeByml(java.util.Date modifiedDate, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where modifiedDate &ge; &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @throws SystemException if a system exception occurred
    */
    public void removeBym(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where modifiedDate &lt; &#63; from the database.
    *
    * @param modifiedDate the modified date
    * @throws SystemException if a system exception occurred
    */
    public void removeBym2(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where detailsViewed &ge; &#63; from the database.
    *
    * @param detailsViewed the details viewed
    * @throws SystemException if a system exception occurred
    */
    public void removeBydetailsViewed(long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where linkClicked &ge; &#63; from the database.
    *
    * @param linkClicked the link clicked
    * @throws SystemException if a system exception occurred
    */
    public void removeBylinkClicked(long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications where useOpenData = &#63; from the database.
    *
    * @param useOpenData the use open data
    * @throws SystemException if a system exception occurred
    */
    public void removeByuseOpenData(int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where companyId = &#63; and userId = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBycu(long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where companyId = &#63; and lifeCycleStatus &ge; &#63;.
    *
    * @param companyId the company ID
    * @param lifeCycleStatus the life cycle status
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBycl(long companyId, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where modifiedDate &ge; &#63; and lifeCycleStatus = &#63;.
    *
    * @param modifiedDate the modified date
    * @param lifeCycleStatus the life cycle status
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countByml(java.util.Date modifiedDate, int lifeCycleStatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where modifiedDate &ge; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBym(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where modifiedDate &lt; &#63;.
    *
    * @param modifiedDate the modified date
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBym2(java.util.Date modifiedDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where detailsViewed &ge; &#63;.
    *
    * @param detailsViewed the details viewed
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBydetailsViewed(long detailsViewed)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where linkClicked &ge; &#63;.
    *
    * @param linkClicked the link clicked
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countBylinkClicked(long linkClicked)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications where useOpenData = &#63;.
    *
    * @param useOpenData the use open data
    * @return the number of matching applications
    * @throws SystemException if a system exception occurred
    */
    public int countByuseOpenData(int useOpenData)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categories associated with the application.
    *
    * @param pk the primary key of the application
    * @return the categories associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of categories associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getCategoriesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the category is associated with the application.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @return <code>true</code> if the category is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any categories associated with it.
    *
    * @param pk the primary key of the application to check for associations with categories
    * @return <code>true</code> if the application has any categories associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public void addCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public void addCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public void addCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public void addCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the application and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated categories from
    * @throws SystemException if a system exception occurred
    */
    public void clearCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public void removeCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public void removeCategory(long pk,
        de.fraunhofer.fokus.movepla.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public void removeCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public void removeCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categoryPKs the primary keys of the categories to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the categories associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param categories the categories to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setCategories(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the regions associated with the application.
    *
    * @param pk the primary key of the application
    * @return the regions associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of regions associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of regions associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getRegionsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the region is associated with the application.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @return <code>true</code> if the region is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any regions associated with it.
    *
    * @param pk the primary key of the application to check for associations with regions
    * @return <code>true</code> if the application has any regions associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public void addRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public void addRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public void addRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public void addRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the application and its regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated regions from
    * @throws SystemException if a system exception occurred
    */
    public void clearRegions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPK the primary key of the region
    * @throws SystemException if a system exception occurred
    */
    public void removeRegion(long pk, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the region. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param region the region
    * @throws SystemException if a system exception occurred
    */
    public void removeRegion(long pk,
        de.fraunhofer.fokus.movepla.model.Region region)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions
    * @throws SystemException if a system exception occurred
    */
    public void removeRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the regions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions
    * @throws SystemException if a system exception occurred
    */
    public void removeRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regionPKs the primary keys of the regions to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setRegions(long pk, long[] regionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the regions associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param regions the regions to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setRegions(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the links associated with the application.
    *
    * @param pk the primary key of the application
    * @return the links associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of links associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of links associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getLinksSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the link is associated with the application.
    *
    * @param pk the primary key of the application
    * @param linkPK the primary key of the link
    * @return <code>true</code> if the link is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLink(long pk, long linkPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any links associated with it.
    *
    * @param pk the primary key of the application to check for associations with links
    * @return <code>true</code> if the application has any links associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLinks(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the multi medias associated with the application.
    *
    * @param pk the primary key of the application
    * @return the multi medias associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of multi medias associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of multi medias associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getMultiMediasSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the multi media is associated with the application.
    *
    * @param pk the primary key of the application
    * @param multiMediaPK the primary key of the multi media
    * @return <code>true</code> if the multi media is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsMultiMedia(long pk, long multiMediaPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any multi medias associated with it.
    *
    * @param pk the primary key of the application to check for associations with multi medias
    * @return <code>true</code> if the application has any multi medias associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsMultiMedias(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the languages associated with the application.
    *
    * @param pk the primary key of the application
    * @return the languages associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of languages associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of languages associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getLanguagesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the language is associated with the application.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @return <code>true</code> if the language is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any languages associated with it.
    *
    * @param pk the primary key of the application to check for associations with languages
    * @return <code>true</code> if the application has any languages associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLanguages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @throws SystemException if a system exception occurred
    */
    public void addLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param language the language
    * @throws SystemException if a system exception occurred
    */
    public void addLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages
    * @throws SystemException if a system exception occurred
    */
    public void addLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages
    * @throws SystemException if a system exception occurred
    */
    public void addLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the application and its languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application to clear the associated languages from
    * @throws SystemException if a system exception occurred
    */
    public void clearLanguages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePK the primary key of the language
    * @throws SystemException if a system exception occurred
    */
    public void removeLanguage(long pk, long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the language. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param language the language
    * @throws SystemException if a system exception occurred
    */
    public void removeLanguage(long pk,
        de.fraunhofer.fokus.movepla.model.Language language)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages
    * @throws SystemException if a system exception occurred
    */
    public void removeLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the application and the languages. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages
    * @throws SystemException if a system exception occurred
    */
    public void removeLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languagePKs the primary keys of the languages to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setLanguages(long pk, long[] languagePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the languages associated with the application, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the application
    * @param languages the languages to be associated with the application
    * @throws SystemException if a system exception occurred
    */
    public void setLanguages(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the application_ entitlements associated with the application.
    *
    * @param pk the primary key of the application
    * @return the application_ entitlements associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of application_ entitlements associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getApplication_EntitlementsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application_ entitlement is associated with the application.
    *
    * @param pk the primary key of the application
    * @param application_EntitlementPK the primary key of the application_ entitlement
    * @return <code>true</code> if the application_ entitlement is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication_Entitlement(long pk,
        long application_EntitlementPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any application_ entitlements associated with it.
    *
    * @param pk the primary key of the application to check for associations with application_ entitlements
    * @return <code>true</code> if the application has any application_ entitlements associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication_Entitlements(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the related applicationses associated with the application.
    *
    * @param pk the primary key of the application
    * @return the related applicationses associated with the application
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> getRelatedApplicationses(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses associated with the application.
    *
    * @param pk the primary key of the application
    * @return the number of related applicationses associated with the application
    * @throws SystemException if a system exception occurred
    */
    public int getRelatedApplicationsesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the related applications is associated with the application.
    *
    * @param pk the primary key of the application
    * @param relatedApplicationsPK the primary key of the related applications
    * @return <code>true</code> if the related applications is associated with the application; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRelatedApplications(long pk,
        long relatedApplicationsPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application has any related applicationses associated with it.
    *
    * @param pk the primary key of the application to check for associations with related applicationses
    * @return <code>true</code> if the application has any related applicationses associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRelatedApplicationses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
