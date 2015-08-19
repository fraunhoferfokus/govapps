package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.RelatedApplications;

import java.util.List;

/**
 * The persistence utility for the related applications service. This utility wraps {@link RelatedApplicationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see RelatedApplicationsPersistence
 * @see RelatedApplicationsPersistenceImpl
 * @generated
 */
public class RelatedApplicationsUtil {
    private static RelatedApplicationsPersistence _persistence;

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
    public static void clearCache(RelatedApplications relatedApplications) {
        getPersistence().clearCache(relatedApplications);
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
    public static List<RelatedApplications> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<RelatedApplications> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<RelatedApplications> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static RelatedApplications update(
        RelatedApplications relatedApplications, boolean merge)
        throws SystemException {
        return getPersistence().update(relatedApplications, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static RelatedApplications update(
        RelatedApplications relatedApplications, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(relatedApplications, merge, serviceContext);
    }

    /**
    * Caches the related applications in the entity cache if it is enabled.
    *
    * @param relatedApplications the related applications
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.RelatedApplications relatedApplications) {
        getPersistence().cacheResult(relatedApplications);
    }

    /**
    * Caches the related applicationses in the entity cache if it is enabled.
    *
    * @param relatedApplicationses the related applicationses
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> relatedApplicationses) {
        getPersistence().cacheResult(relatedApplicationses);
    }

    /**
    * Creates a new related applications with the primary key. Does not add the related applications to the database.
    *
    * @param RelatedApplicationsID the primary key for the new related applications
    * @return the new related applications
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications create(
        long RelatedApplicationsID) {
        return getPersistence().create(RelatedApplicationsID);
    }

    /**
    * Removes the related applications with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications remove(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().remove(RelatedApplicationsID);
    }

    public static de.fraunhofer.fokus.movepla.model.RelatedApplications updateImpl(
        de.fraunhofer.fokus.movepla.model.RelatedApplications relatedApplications,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(relatedApplications, merge);
    }

    /**
    * Returns the related applications with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException} if it could not be found.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByPrimaryKey(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findByPrimaryKey(RelatedApplicationsID);
    }

    /**
    * Returns the related applications with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications, or <code>null</code> if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByPrimaryKey(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(RelatedApplicationsID);
    }

    /**
    * Returns all the related applicationses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

    /**
    * Returns a range of all the related applicationses where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63;.
    *
    * @param RelatedApplicationsID the primary key of the current related applications
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByc_PrevAndNext(
        long RelatedApplicationsID, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByc_PrevAndNext(RelatedApplicationsID, companyId,
            orderByComparator);
    }

    /**
    * Returns all the related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId);
    }

    /**
    * Returns a range of all the related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByca(companyId, applicationId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param RelatedApplicationsID the primary key of the current related applications
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByca_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca_PrevAndNext(RelatedApplicationsID, companyId,
            applicationId, orderByComparator);
    }

    /**
    * Returns all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca2(companyId, applicationId2);
    }

    /**
    * Returns a range of all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca2(companyId, applicationId2, start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByca2(companyId, applicationId2, start, end,
            orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByca2_First(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca2_First(companyId, applicationId2, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca2_First(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca2_First(companyId, applicationId2,
            orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findByca2_Last(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca2_Last(companyId, applicationId2, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca2_Last(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca2_Last(companyId, applicationId2, orderByComparator);
    }

    /**
    * Returns the related applicationses before and after the current related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param RelatedApplicationsID the primary key of the current related applications
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByca2_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findByca2_PrevAndNext(RelatedApplicationsID, companyId,
            applicationId2, orderByComparator);
    }

    /**
    * Returns all the related applicationses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBya(applicationId);
    }

    /**
    * Returns a range of all the related applicationses where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBya(applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBya(applicationId, start, end, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findBya_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findBya_First(applicationId, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBya_First(applicationId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findBya_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findBya_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBya_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the related applicationses before and after the current related applications in the ordered set where applicationId = &#63;.
    *
    * @param RelatedApplicationsID the primary key of the current related applications
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications[] findBya_PrevAndNext(
        long RelatedApplicationsID, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findBya_PrevAndNext(RelatedApplicationsID, applicationId,
            orderByComparator);
    }

    /**
    * Returns all the related applicationses where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBya2(applicationId2);
    }

    /**
    * Returns a range of all the related applicationses where applicationId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId2 the application id2
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBya2(applicationId2, start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses where applicationId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId2 the application id2
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBya2(applicationId2, start, end, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findBya2_First(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findBya2_First(applicationId2, orderByComparator);
    }

    /**
    * Returns the first related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya2_First(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBya2_First(applicationId2, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications findBya2_Last(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence().findBya2_Last(applicationId2, orderByComparator);
    }

    /**
    * Returns the last related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya2_Last(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBya2_Last(applicationId2, orderByComparator);
    }

    /**
    * Returns the related applicationses before and after the current related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param RelatedApplicationsID the primary key of the current related applications
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.RelatedApplications[] findBya2_PrevAndNext(
        long RelatedApplicationsID, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException {
        return getPersistence()
                   .findBya2_PrevAndNext(RelatedApplicationsID, applicationId2,
            orderByComparator);
    }

    /**
    * Returns all the related applicationses.
    *
    * @return the related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the related applicationses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @return the range of related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the related applicationses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of related applicationses
    * @param end the upper bound of the range of related applicationses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the related applicationses where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the related applicationses where companyId = &#63; and applicationId = &#63; from the database.
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
    * Removes all the related applicationses where companyId = &#63; and applicationId2 = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @throws SystemException if a system exception occurred
    */
    public static void removeByca2(long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByca2(companyId, applicationId2);
    }

    /**
    * Removes all the related applicationses where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBya(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBya(applicationId);
    }

    /**
    * Removes all the related applicationses where applicationId2 = &#63; from the database.
    *
    * @param applicationId2 the application id2
    * @throws SystemException if a system exception occurred
    */
    public static void removeBya2(long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBya2(applicationId2);
    }

    /**
    * Removes all the related applicationses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of related applicationses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByca(companyId, applicationId);
    }

    /**
    * Returns the number of related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countByca2(long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByca2(companyId, applicationId2);
    }

    /**
    * Returns the number of related applicationses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countBya(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBya(applicationId);
    }

    /**
    * Returns the number of related applicationses where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countBya2(long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBya2(applicationId2);
    }

    /**
    * Returns the number of related applicationses.
    *
    * @return the number of related applicationses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RelatedApplicationsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RelatedApplicationsPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    RelatedApplicationsPersistence.class.getName());

            ReferenceRegistry.registerReference(RelatedApplicationsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(RelatedApplicationsPersistence persistence) {
    }
}
