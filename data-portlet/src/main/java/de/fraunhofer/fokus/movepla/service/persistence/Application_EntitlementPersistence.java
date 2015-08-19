package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application_Entitlement;

/**
 * The persistence interface for the application_ entitlement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see Application_EntitlementPersistenceImpl
 * @see Application_EntitlementUtil
 * @generated
 */
public interface Application_EntitlementPersistence extends BasePersistence<Application_Entitlement> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link Application_EntitlementUtil} to access the application_ entitlement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the application_ entitlement in the entity cache if it is enabled.
    *
    * @param application_Entitlement the application_ entitlement
    */
    public void cacheResult(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement);

    /**
    * Caches the application_ entitlements in the entity cache if it is enabled.
    *
    * @param application_Entitlements the application_ entitlements
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> application_Entitlements);

    /**
    * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
    *
    * @param applicationEntitlementID the primary key for the new application_ entitlement
    * @return the new application_ entitlement
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement create(
        long applicationEntitlementID);

    /**
    * Removes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement remove(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    public de.fraunhofer.fokus.movepla.model.Application_Entitlement updateImpl(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application_ entitlement with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException} if it could not be found.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByPrimaryKey(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the application_ entitlement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement, or <code>null</code> if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByPrimaryKey(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the application_ entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param applicationEntitlementID the primary key of the current application_ entitlement
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByc_PrevAndNext(
        long applicationEntitlementID, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param applicationEntitlementID the primary key of the current application_ entitlement
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByca_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByce_First(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByce_First(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findByce_Last(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByce_Last(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param applicationEntitlementID the primary key of the current application_ entitlement
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByce_PrevAndNext(
        long applicationEntitlementID, long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findBycae_First(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchBycae_First(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement findBycae_Last(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchBycae_Last(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application_ entitlements before and after the current application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param applicationEntitlementID the primary key of the current application_ entitlement
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findBycae_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException;

    /**
    * Returns all the application_ entitlements.
    *
    * @return the application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application_ entitlements where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application_ entitlements where companyId = &#63; and entitlementId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByce(long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBycae(long companyId, long applicationId,
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application_ entitlements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countByce(long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countBycae(long companyId, long applicationId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements.
    *
    * @return the number of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
