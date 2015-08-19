package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: EntitlementPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Entitlement;

/**
 * The persistence interface for the entitlement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see EntitlementPersistenceImpl
 * @see EntitlementUtil
 * @generated
 */
public interface EntitlementPersistence extends BasePersistence<Entitlement> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EntitlementUtil} to access the entitlement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the entitlement in the entity cache if it is enabled.
    *
    * @param entitlement the entitlement
    */
    public void cacheResult(
        de.fraunhofer.fokus.movepla.model.Entitlement entitlement);

    /**
    * Caches the entitlements in the entity cache if it is enabled.
    *
    * @param entitlements the entitlements
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> entitlements);

    /**
    * Creates a new entitlement with the primary key. Does not add the entitlement to the database.
    *
    * @param entitlementId the primary key for the new entitlement
    * @return the new entitlement
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement create(
        long entitlementId);

    /**
    * Removes the entitlement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entitlementId the primary key of the entitlement
    * @return the entitlement that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement remove(
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchEntitlementException;

    public de.fraunhofer.fokus.movepla.model.Entitlement updateImpl(
        de.fraunhofer.fokus.movepla.model.Entitlement entitlement, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entitlement with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchEntitlementException} if it could not be found.
    *
    * @param entitlementId the primary key of the entitlement
    * @return the entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement findByPrimaryKey(
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchEntitlementException;

    /**
    * Returns the entitlement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entitlementId the primary key of the entitlement
    * @return the entitlement, or <code>null</code> if a entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement fetchByPrimaryKey(
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entitlements where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @return the range of matching entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entitlements where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a matching entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchEntitlementException;

    /**
    * Returns the first entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entitlement, or <code>null</code> if a matching entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a matching entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchEntitlementException;

    /**
    * Returns the last entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entitlement, or <code>null</code> if a matching entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entitlements before and after the current entitlement in the ordered set where companyId = &#63;.
    *
    * @param entitlementId the primary key of the current entitlement
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchEntitlementException if a entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Entitlement[] findByc_PrevAndNext(
        long entitlementId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchEntitlementException;

    /**
    * Returns all the entitlements.
    *
    * @return the entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entitlements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @return the range of entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entitlements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Entitlement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the entitlements where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the entitlements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entitlements.
    *
    * @return the number of entitlements
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the application_ entitlements associated with the entitlement.
    *
    * @param pk the primary key of the entitlement
    * @return the application_ entitlements associated with the entitlement
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the application_ entitlements associated with the entitlement.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the entitlement
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @return the range of application_ entitlements associated with the entitlement
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the application_ entitlements associated with the entitlement.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the entitlement
    * @param start the lower bound of the range of entitlements
    * @param end the upper bound of the range of entitlements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of application_ entitlements associated with the entitlement
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application_ entitlements associated with the entitlement.
    *
    * @param pk the primary key of the entitlement
    * @return the number of application_ entitlements associated with the entitlement
    * @throws SystemException if a system exception occurred
    */
    public int getApplication_EntitlementsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application_ entitlement is associated with the entitlement.
    *
    * @param pk the primary key of the entitlement
    * @param application_EntitlementPK the primary key of the application_ entitlement
    * @return <code>true</code> if the application_ entitlement is associated with the entitlement; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication_Entitlement(long pk,
        long application_EntitlementPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the entitlement has any application_ entitlements associated with it.
    *
    * @param pk the primary key of the entitlement to check for associations with application_ entitlements
    * @return <code>true</code> if the entitlement has any application_ entitlements associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication_Entitlements(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
