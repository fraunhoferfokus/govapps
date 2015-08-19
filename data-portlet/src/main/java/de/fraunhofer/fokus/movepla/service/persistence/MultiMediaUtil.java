package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: MultiMediaUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.MultiMedia;

import java.util.List;

/**
 * The persistence utility for the multi media service. This utility wraps {@link MultiMediaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see MultiMediaPersistence
 * @see MultiMediaPersistenceImpl
 * @generated
 */
public class MultiMediaUtil {
    private static MultiMediaPersistence _persistence;

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
    public static void clearCache(MultiMedia multiMedia) {
        getPersistence().clearCache(multiMedia);
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
    public static List<MultiMedia> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<MultiMedia> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<MultiMedia> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static MultiMedia update(MultiMedia multiMedia, boolean merge)
        throws SystemException {
        return getPersistence().update(multiMedia, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static MultiMedia update(MultiMedia multiMedia, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(multiMedia, merge, serviceContext);
    }

    /**
    * Caches the multi media in the entity cache if it is enabled.
    *
    * @param multiMedia the multi media
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia) {
        getPersistence().cacheResult(multiMedia);
    }

    /**
    * Caches the multi medias in the entity cache if it is enabled.
    *
    * @param multiMedias the multi medias
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> multiMedias) {
        getPersistence().cacheResult(multiMedias);
    }

    /**
    * Creates a new multi media with the primary key. Does not add the multi media to the database.
    *
    * @param multiMediaId the primary key for the new multi media
    * @return the new multi media
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia create(
        long multiMediaId) {
        return getPersistence().create(multiMediaId);
    }

    /**
    * Removes the multi media with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param multiMediaId the primary key of the multi media
    * @return the multi media that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia remove(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().remove(multiMediaId);
    }

    public static de.fraunhofer.fokus.movepla.model.MultiMedia updateImpl(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(multiMedia, merge);
    }

    /**
    * Returns the multi media with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchMultiMediaException} if it could not be found.
    *
    * @param multiMediaId the primary key of the multi media
    * @return the multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByPrimaryKey(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByPrimaryKey(multiMediaId);
    }

    /**
    * Returns the multi media with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param multiMediaId the primary key of the multi media
    * @return the multi media, or <code>null</code> if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByPrimaryKey(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(multiMediaId);
    }

    /**
    * Returns all the multi medias where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

    /**
    * Returns a range of all the multi medias where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the multi medias where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63;.
    *
    * @param multiMediaId the primary key of the current multi media
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia[] findByc_PrevAndNext(
        long multiMediaId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByc_PrevAndNext(multiMediaId, companyId,
            orderByComparator);
    }

    /**
    * Returns all the multi medias where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId);
    }

    /**
    * Returns a range of all the multi medias where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the multi medias where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByca(companyId, applicationId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param multiMediaId the primary key of the current multi media
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia[] findByca_PrevAndNext(
        long multiMediaId, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByca_PrevAndNext(multiMediaId, companyId,
            applicationId, orderByComparator);
    }

    /**
    * Returns all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @return the matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findBycai(
        long companyId, long applicationId, long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycai(companyId, applicationId, imageId);
    }

    /**
    * Returns a range of all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findBycai(
        long companyId, long applicationId, long imageId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycai(companyId, applicationId, imageId, start, end);
    }

    /**
    * Returns an ordered range of all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findBycai(
        long companyId, long applicationId, long imageId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycai(companyId, applicationId, imageId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findBycai_First(
        long companyId, long applicationId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findBycai_First(companyId, applicationId, imageId,
            orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchBycai_First(
        long companyId, long applicationId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycai_First(companyId, applicationId, imageId,
            orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findBycai_Last(
        long companyId, long applicationId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findBycai_Last(companyId, applicationId, imageId,
            orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchBycai_Last(
        long companyId, long applicationId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycai_Last(companyId, applicationId, imageId,
            orderByComparator);
    }

    /**
    * Returns the multi medias before and after the current multi media in the ordered set where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param multiMediaId the primary key of the current multi media
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia[] findBycai_PrevAndNext(
        long multiMediaId, long companyId, long applicationId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findBycai_PrevAndNext(multiMediaId, companyId,
            applicationId, imageId, orderByComparator);
    }

    /**
    * Returns all the multi medias where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByapp(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByapp(applicationId);
    }

    /**
    * Returns a range of all the multi medias where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByapp(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByapp(applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the multi medias where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByapp(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByapp(applicationId, start, end, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByapp_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByapp_First(applicationId, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByapp_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByapp_First(applicationId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByapp_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByapp_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByapp_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByapp_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the multi medias before and after the current multi media in the ordered set where applicationId = &#63;.
    *
    * @param multiMediaId the primary key of the current multi media
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia[] findByapp_PrevAndNext(
        long multiMediaId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByapp_PrevAndNext(multiMediaId, applicationId,
            orderByComparator);
    }

    /**
    * Returns all the multi medias where imageId = &#63;.
    *
    * @param imageId the image ID
    * @return the matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByimage(
        long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByimage(imageId);
    }

    /**
    * Returns a range of all the multi medias where imageId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param imageId the image ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByimage(
        long imageId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByimage(imageId, start, end);
    }

    /**
    * Returns an ordered range of all the multi medias where imageId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param imageId the image ID
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByimage(
        long imageId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByimage(imageId, start, end, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where imageId = &#63;.
    *
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByimage_First(
        long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByimage_First(imageId, orderByComparator);
    }

    /**
    * Returns the first multi media in the ordered set where imageId = &#63;.
    *
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByimage_First(
        long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByimage_First(imageId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where imageId = &#63;.
    *
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia findByimage_Last(
        long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence().findByimage_Last(imageId, orderByComparator);
    }

    /**
    * Returns the last multi media in the ordered set where imageId = &#63;.
    *
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching multi media, or <code>null</code> if a matching multi media could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia fetchByimage_Last(
        long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByimage_Last(imageId, orderByComparator);
    }

    /**
    * Returns the multi medias before and after the current multi media in the ordered set where imageId = &#63;.
    *
    * @param multiMediaId the primary key of the current multi media
    * @param imageId the image ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next multi media
    * @throws de.fraunhofer.fokus.movepla.NoSuchMultiMediaException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.MultiMedia[] findByimage_PrevAndNext(
        long multiMediaId, long imageId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchMultiMediaException {
        return getPersistence()
                   .findByimage_PrevAndNext(multiMediaId, imageId,
            orderByComparator);
    }

    /**
    * Returns all the multi medias.
    *
    * @return the multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the multi medias.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @return the range of multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the multi medias.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of multi medias
    * @param end the upper bound of the range of multi medias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of multi medias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the multi medias where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the multi medias where companyId = &#63; and applicationId = &#63; from the database.
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
    * Removes all the multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycai(long companyId, long applicationId,
        long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycai(companyId, applicationId, imageId);
    }

    /**
    * Removes all the multi medias where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByapp(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByapp(applicationId);
    }

    /**
    * Removes all the multi medias where imageId = &#63; from the database.
    *
    * @param imageId the image ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByimage(long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByimage(imageId);
    }

    /**
    * Removes all the multi medias from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of multi medias where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of multi medias where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByca(companyId, applicationId);
    }

    /**
    * Returns the number of multi medias where companyId = &#63; and applicationId = &#63; and imageId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param imageId the image ID
    * @return the number of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countBycai(long companyId, long applicationId,
        long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycai(companyId, applicationId, imageId);
    }

    /**
    * Returns the number of multi medias where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countByapp(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByapp(applicationId);
    }

    /**
    * Returns the number of multi medias where imageId = &#63;.
    *
    * @param imageId the image ID
    * @return the number of matching multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countByimage(long imageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByimage(imageId);
    }

    /**
    * Returns the number of multi medias.
    *
    * @return the number of multi medias
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MultiMediaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MultiMediaPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    MultiMediaPersistence.class.getName());

            ReferenceRegistry.registerReference(MultiMediaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(MultiMediaPersistence persistence) {
    }
}
