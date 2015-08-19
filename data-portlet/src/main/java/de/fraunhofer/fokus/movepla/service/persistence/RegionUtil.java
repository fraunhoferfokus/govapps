package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: RegionUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Region;

import java.util.List;

/**
 * The persistence utility for the region service. This utility wraps {@link RegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see RegionPersistence
 * @see RegionPersistenceImpl
 * @generated
 */
public class RegionUtil {
    private static RegionPersistence _persistence;

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
    public static void clearCache(Region region) {
        getPersistence().clearCache(region);
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
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Region update(Region region, boolean merge)
        throws SystemException {
        return getPersistence().update(region, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Region update(Region region, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(region, merge, serviceContext);
    }

    /**
    * Caches the region in the entity cache if it is enabled.
    *
    * @param region the region
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.Region region) {
        getPersistence().cacheResult(region);
    }

    /**
    * Caches the regions in the entity cache if it is enabled.
    *
    * @param regions the regions
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions) {
        getPersistence().cacheResult(regions);
    }

    /**
    * Creates a new region with the primary key. Does not add the region to the database.
    *
    * @param regionId the primary key for the new region
    * @return the new region
    */
    public static de.fraunhofer.fokus.movepla.model.Region create(long regionId) {
        return getPersistence().create(regionId);
    }

    /**
    * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param regionId the primary key of the region
    * @return the region that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region remove(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().remove(regionId);
    }

    public static de.fraunhofer.fokus.movepla.model.Region updateImpl(
        de.fraunhofer.fokus.movepla.model.Region region, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(region, merge);
    }

    /**
    * Returns the region with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRegionException} if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findByPrimaryKey(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().findByPrimaryKey(regionId);
    }

    /**
    * Returns the region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param regionId the primary key of the region
    * @return the region, or <code>null</code> if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchByPrimaryKey(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(regionId);
    }

    /**
    * Returns all the regions where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

    /**
    * Returns a range of all the regions where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the regions where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where companyId = &#63;.
    *
    * @param regionId the primary key of the current region
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region[] findByc_PrevAndNext(
        long regionId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence()
                   .findByc_PrevAndNext(regionId, companyId, orderByComparator);
    }

    /**
    * Returns all the regions where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @return the matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findBycp(
        long companyId, long parentRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycp(companyId, parentRegion);
    }

    /**
    * Returns a range of all the regions where companyId = &#63; and parentRegion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findBycp(
        long companyId, long parentRegion, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycp(companyId, parentRegion, start, end);
    }

    /**
    * Returns an ordered range of all the regions where companyId = &#63; and parentRegion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findBycp(
        long companyId, long parentRegion, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycp(companyId, parentRegion, start, end,
            orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findBycp_First(
        long companyId, long parentRegion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence()
                   .findBycp_First(companyId, parentRegion, orderByComparator);
    }

    /**
    * Returns the first region in the ordered set where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchBycp_First(
        long companyId, long parentRegion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycp_First(companyId, parentRegion, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findBycp_Last(
        long companyId, long parentRegion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence()
                   .findBycp_Last(companyId, parentRegion, orderByComparator);
    }

    /**
    * Returns the last region in the ordered set where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchBycp_Last(
        long companyId, long parentRegion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycp_Last(companyId, parentRegion, orderByComparator);
    }

    /**
    * Returns the regions before and after the current region in the ordered set where companyId = &#63; and parentRegion = &#63;.
    *
    * @param regionId the primary key of the current region
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region[] findBycp_PrevAndNext(
        long regionId, long companyId, long parentRegion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence()
                   .findBycp_PrevAndNext(regionId, companyId, parentRegion,
            orderByComparator);
    }

    /**
    * Returns the region where name = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRegionException} if it could not be found.
    *
    * @param name the name
    * @return the matching region
    * @throws de.fraunhofer.fokus.movepla.NoSuchRegionException if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region findByregionName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().findByregionName(name);
    }

    /**
    * Returns the region where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchByregionName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByregionName(name);
    }

    /**
    * Returns the region where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching region, or <code>null</code> if a matching region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region fetchByregionName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByregionName(name, retrieveFromCache);
    }

    /**
    * Returns all the regions.
    *
    * @return the regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the regions where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes all the regions where companyId = &#63; and parentRegion = &#63; from the database.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycp(long companyId, long parentRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycp(companyId, parentRegion);
    }

    /**
    * Removes the region where name = &#63; from the database.
    *
    * @param name the name
    * @return the region that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Region removeByregionName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRegionException {
        return getPersistence().removeByregionName(name);
    }

    /**
    * Removes all the regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of regions where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of regions where companyId = &#63; and parentRegion = &#63;.
    *
    * @param companyId the company ID
    * @param parentRegion the parent region
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countBycp(long companyId, long parentRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycp(companyId, parentRegion);
    }

    /**
    * Returns the number of regions where name = &#63;.
    *
    * @param name the name
    * @return the number of matching regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByregionName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByregionName(name);
    }

    /**
    * Returns the number of regions.
    *
    * @return the number of regions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the applications associated with the region.
    *
    * @param pk the primary key of the region
    * @return the applications associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplications(pk);
    }

    /**
    * Returns a range of all the applications associated with the region.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @return the range of applications associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplications(pk, start, end);
    }

    /**
    * Returns an ordered range of all the applications associated with the region.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the region
    * @param start the lower bound of the range of regions
    * @param end the upper bound of the range of regions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of applications associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getApplications(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of applications associated with the region.
    *
    * @param pk the primary key of the region
    * @return the number of applications associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static int getApplicationsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplicationsSize(pk);
    }

    /**
    * Returns <code>true</code> if the application is associated with the region.
    *
    * @param pk the primary key of the region
    * @param applicationPK the primary key of the application
    * @return <code>true</code> if the application is associated with the region; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsApplication(pk, applicationPK);
    }

    /**
    * Returns <code>true</code> if the region has any applications associated with it.
    *
    * @param pk the primary key of the region to check for associations with applications
    * @return <code>true</code> if the region has any applications associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsApplications(pk);
    }

    /**
    * Adds an association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public static void addApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplication(pk, applicationPK);
    }

    /**
    * Adds an association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public static void addApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplication(pk, application);
    }

    /**
    * Adds an association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public static void addApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplications(pk, applicationPKs);
    }

    /**
    * Adds an association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public static void addApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplications(pk, applications);
    }

    /**
    * Clears all associations between the region and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region to clear the associated applications from
    * @throws SystemException if a system exception occurred
    */
    public static void clearApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearApplications(pk);
    }

    /**
    * Removes the association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplication(pk, applicationPK);
    }

    /**
    * Removes the association between the region and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplication(pk, application);
    }

    /**
    * Removes the association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplications(pk, applicationPKs);
    }

    /**
    * Removes the association between the region and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplications(pk, applications);
    }

    /**
    * Sets the applications associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applicationPKs the primary keys of the applications to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static void setApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setApplications(pk, applicationPKs);
    }

    /**
    * Sets the applications associated with the region, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the region
    * @param applications the applications to be associated with the region
    * @throws SystemException if a system exception occurred
    */
    public static void setApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setApplications(pk, applications);
    }

    public static RegionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RegionPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    RegionPersistence.class.getName());

            ReferenceRegistry.registerReference(RegionUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(RegionPersistence persistence) {
    }
}
