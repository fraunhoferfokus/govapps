package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application_Entitlement;

import java.util.List;

/**
 * The persistence utility for the application_ entitlement service. This utility wraps {@link Application_EntitlementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see Application_EntitlementPersistence
 * @see Application_EntitlementPersistenceImpl
 * @generated
 */
public class Application_EntitlementUtil {
    private static Application_EntitlementPersistence _persistence;

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
    public static void clearCache(
        Application_Entitlement application_Entitlement) {
        getPersistence().clearCache(application_Entitlement);
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
    public static List<Application_Entitlement> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Application_Entitlement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Application_Entitlement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Application_Entitlement update(
        Application_Entitlement application_Entitlement, boolean merge)
        throws SystemException {
        return getPersistence().update(application_Entitlement, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Application_Entitlement update(
        Application_Entitlement application_Entitlement, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(application_Entitlement, merge, serviceContext);
    }

    /**
    * Caches the application_ entitlement in the entity cache if it is enabled.
    *
    * @param application_Entitlement the application_ entitlement
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement) {
        getPersistence().cacheResult(application_Entitlement);
    }

    /**
    * Caches the application_ entitlements in the entity cache if it is enabled.
    *
    * @param application_Entitlements the application_ entitlements
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> application_Entitlements) {
        getPersistence().cacheResult(application_Entitlements);
    }

    /**
    * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
    *
    * @param applicationEntitlementID the primary key for the new application_ entitlement
    * @return the new application_ entitlement
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement create(
        long applicationEntitlementID) {
        return getPersistence().create(applicationEntitlementID);
    }

    /**
    * Removes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement remove(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence().remove(applicationEntitlementID);
    }

    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement updateImpl(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(application_Entitlement, merge);
    }

    /**
    * Returns the application_ entitlement with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException} if it could not be found.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByPrimaryKey(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence().findByPrimaryKey(applicationEntitlementID);
    }

    /**
    * Returns the application_ entitlement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement, or <code>null</code> if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByPrimaryKey(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(applicationEntitlementID);
    }

    /**
    * Returns all the application_ entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement
    * @throws de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByc_PrevAndNext(
        long applicationEntitlementID, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByc_PrevAndNext(applicationEntitlementID, companyId,
            orderByComparator);
    }

    /**
    * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId, start, end);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByca(companyId, applicationId, start, end,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_First(companyId, applicationId, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_Last(companyId, applicationId, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByca_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByca_PrevAndNext(applicationEntitlementID, companyId,
            applicationId, orderByComparator);
    }

    /**
    * Returns all the application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByce(companyId, entitlementId);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByce(companyId, entitlementId, start, end);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByce(companyId, entitlementId, start, end,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByce_First(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByce_First(companyId, entitlementId, orderByComparator);
    }

    /**
    * Returns the first application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByce_First(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByce_First(companyId, entitlementId, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findByce_Last(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByce_Last(companyId, entitlementId, orderByComparator);
    }

    /**
    * Returns the last application_ entitlement in the ordered set where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application_ entitlement, or <code>null</code> if a matching application_ entitlement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchByce_Last(
        long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByce_Last(companyId, entitlementId, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findByce_PrevAndNext(
        long applicationEntitlementID, long companyId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findByce_PrevAndNext(applicationEntitlementID, companyId,
            entitlementId, orderByComparator);
    }

    /**
    * Returns all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @return the matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycae(companyId, applicationId, entitlementId);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycae(companyId, applicationId, entitlementId, start,
            end);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycae(companyId, applicationId, entitlementId, start,
            end, orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findBycae_First(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findBycae_First(companyId, applicationId, entitlementId,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchBycae_First(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycae_First(companyId, applicationId, entitlementId,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement findBycae_Last(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findBycae_Last(companyId, applicationId, entitlementId,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchBycae_Last(
        long companyId, long applicationId, long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycae_Last(companyId, applicationId, entitlementId,
            orderByComparator);
    }

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
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement[] findBycae_PrevAndNext(
        long applicationEntitlementID, long companyId, long applicationId,
        long entitlementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException {
        return getPersistence()
                   .findBycae_PrevAndNext(applicationEntitlementID, companyId,
            applicationId, entitlementId, orderByComparator);
    }

    /**
    * Returns all the application_ entitlements.
    *
    * @return the application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the application_ entitlements where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByca(companyId, applicationId);
    }

    /**
    * Removes all the application_ entitlements where companyId = &#63; and entitlementId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByce(long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByce(companyId, entitlementId);
    }

    /**
    * Removes all the application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycae(long companyId, long applicationId,
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycae(companyId, applicationId, entitlementId);
    }

    /**
    * Removes all the application_ entitlements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of application_ entitlements where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByca(companyId, applicationId);
    }

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param entitlementId the entitlement ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int countByce(long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByce(companyId, entitlementId);
    }

    /**
    * Returns the number of application_ entitlements where companyId = &#63; and applicationId = &#63; and entitlementId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param entitlementId the entitlement ID
    * @return the number of matching application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int countBycae(long companyId, long applicationId,
        long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBycae(companyId, applicationId, entitlementId);
    }

    /**
    * Returns the number of application_ entitlements.
    *
    * @return the number of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static Application_EntitlementPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (Application_EntitlementPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    Application_EntitlementPersistence.class.getName());

            ReferenceRegistry.registerReference(Application_EntitlementUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(Application_EntitlementPersistence persistence) {
    }
}
