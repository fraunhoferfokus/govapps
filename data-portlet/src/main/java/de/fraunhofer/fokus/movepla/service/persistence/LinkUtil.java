package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LinkUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Link;

import java.util.List;

/**
 * The persistence utility for the link service. This utility wraps {@link LinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LinkPersistence
 * @see LinkPersistenceImpl
 * @generated
 */
public class LinkUtil {
    private static LinkPersistence _persistence;

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
    public static void clearCache(Link link) {
        getPersistence().clearCache(link);
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
    public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Link update(Link link, boolean merge)
        throws SystemException {
        return getPersistence().update(link, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Link update(Link link, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(link, merge, serviceContext);
    }

    /**
    * Caches the link in the entity cache if it is enabled.
    *
    * @param link the link
    */
    public static void cacheResult(de.fraunhofer.fokus.movepla.model.Link link) {
        getPersistence().cacheResult(link);
    }

    /**
    * Caches the links in the entity cache if it is enabled.
    *
    * @param links the links
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Link> links) {
        getPersistence().cacheResult(links);
    }

    /**
    * Creates a new link with the primary key. Does not add the link to the database.
    *
    * @param linkId the primary key for the new link
    * @return the new link
    */
    public static de.fraunhofer.fokus.movepla.model.Link create(long linkId) {
        return getPersistence().create(linkId);
    }

    /**
    * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param linkId the primary key of the link
    * @return the link that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link remove(long linkId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().remove(linkId);
    }

    public static de.fraunhofer.fokus.movepla.model.Link updateImpl(
        de.fraunhofer.fokus.movepla.model.Link link, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(link, merge);
    }

    /**
    * Returns the link with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLinkException} if it could not be found.
    *
    * @param linkId the primary key of the link
    * @return the link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByPrimaryKey(
        long linkId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findByPrimaryKey(linkId);
    }

    /**
    * Returns the link with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param linkId the primary key of the link
    * @return the link, or <code>null</code> if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByPrimaryKey(
        long linkId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(linkId);
    }

    /**
    * Returns all the links where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

    /**
    * Returns a range of all the links where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @return the range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the links where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the links before and after the current link in the ordered set where companyId = &#63;.
    *
    * @param linkId the primary key of the current link
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link[] findByc_PrevAndNext(
        long linkId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findByc_PrevAndNext(linkId, companyId, orderByComparator);
    }

    /**
    * Returns all the links where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId);
    }

    /**
    * Returns a range of all the links where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @return the range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByca(companyId, applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the links where companyId = &#63; and applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByca(companyId, applicationId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_First(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByca_Last(companyId, applicationId, orderByComparator);
    }

    /**
    * Returns the links before and after the current link in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param linkId the primary key of the current link
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link[] findByca_PrevAndNext(
        long linkId, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findByca_PrevAndNext(linkId, companyId, applicationId,
            orderByComparator);
    }

    /**
    * Returns all the links where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByapp(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByapp(applicationId);
    }

    /**
    * Returns a range of all the links where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @return the range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByapp(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByapp(applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the links where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByapp(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByapp(applicationId, start, end, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByapp_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findByapp_First(applicationId, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByapp_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByapp_First(applicationId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findByapp_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findByapp_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchByapp_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByapp_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the links before and after the current link in the ordered set where applicationId = &#63;.
    *
    * @param linkId the primary key of the current link
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link[] findByapp_PrevAndNext(
        long linkId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findByapp_PrevAndNext(linkId, applicationId,
            orderByComparator);
    }

    /**
    * Returns all the links where type = &#63;.
    *
    * @param type the type
    * @return the matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findBybyType(
        int type) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBybyType(type);
    }

    /**
    * Returns a range of all the links where type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param type the type
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @return the range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findBybyType(
        int type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBybyType(type, start, end);
    }

    /**
    * Returns an ordered range of all the links where type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param type the type
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findBybyType(
        int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBybyType(type, start, end, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findBybyType_First(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findBybyType_First(type, orderByComparator);
    }

    /**
    * Returns the first link in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchBybyType_First(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBybyType_First(type, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link findBybyType_Last(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence().findBybyType_Last(type, orderByComparator);
    }

    /**
    * Returns the last link in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching link, or <code>null</code> if a matching link could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link fetchBybyType_Last(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBybyType_Last(type, orderByComparator);
    }

    /**
    * Returns the links before and after the current link in the ordered set where type = &#63;.
    *
    * @param linkId the primary key of the current link
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next link
    * @throws de.fraunhofer.fokus.movepla.NoSuchLinkException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Link[] findBybyType_PrevAndNext(
        long linkId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLinkException {
        return getPersistence()
                   .findBybyType_PrevAndNext(linkId, type, orderByComparator);
    }

    /**
    * Returns all the links.
    *
    * @return the links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @return the range of links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of links
    * @param end the upper bound of the range of links (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the links where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the links where companyId = &#63; and applicationId = &#63; from the database.
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
    * Removes all the links where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByapp(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByapp(applicationId);
    }

    /**
    * Removes all the links where type = &#63; from the database.
    *
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public static void removeBybyType(int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBybyType(type);
    }

    /**
    * Removes all the links from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of links where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching links
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of links where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching links
    * @throws SystemException if a system exception occurred
    */
    public static int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByca(companyId, applicationId);
    }

    /**
    * Returns the number of links where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching links
    * @throws SystemException if a system exception occurred
    */
    public static int countByapp(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByapp(applicationId);
    }

    /**
    * Returns the number of links where type = &#63;.
    *
    * @param type the type
    * @return the number of matching links
    * @throws SystemException if a system exception occurred
    */
    public static int countBybyType(int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBybyType(type);
    }

    /**
    * Returns the number of links.
    *
    * @return the number of links
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LinkPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LinkPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    LinkPersistence.class.getName());

            ReferenceRegistry.registerReference(LinkUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LinkPersistence persistence) {
    }
}
