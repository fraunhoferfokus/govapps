package com.govapps.persistence.service.persistence;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernUtil.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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

import com.govapps.persistence.model.Concern;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the concern service. This utility wraps {@link ConcernPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ekl
 * @see ConcernPersistence
 * @see ConcernPersistenceImpl
 * @generated
 */
public class ConcernUtil {
    private static ConcernPersistence _persistence;

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
    public static void clearCache(Concern concern) {
        getPersistence().clearCache(concern);
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
    public static List<Concern> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Concern> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Concern> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Concern update(Concern concern, boolean merge)
        throws SystemException {
        return getPersistence().update(concern, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Concern update(Concern concern, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(concern, merge, serviceContext);
    }

    /**
    * Caches the concern in the entity cache if it is enabled.
    *
    * @param concern the concern
    */
    public static void cacheResult(
        com.govapps.persistence.model.Concern concern) {
        getPersistence().cacheResult(concern);
    }

    /**
    * Caches the concerns in the entity cache if it is enabled.
    *
    * @param concerns the concerns
    */
    public static void cacheResult(
        java.util.List<com.govapps.persistence.model.Concern> concerns) {
        getPersistence().cacheResult(concerns);
    }

    /**
    * Creates a new concern with the primary key. Does not add the concern to the database.
    *
    * @param id the primary key for the new concern
    * @return the new concern
    */
    public static com.govapps.persistence.model.Concern create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the concern with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the concern
    * @return the concern that was removed
    * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern remove(long id)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.govapps.persistence.model.Concern updateImpl(
        com.govapps.persistence.model.Concern concern, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(concern, merge);
    }

    /**
    * Returns the concern with the primary key or throws a {@link com.govapps.persistence.NoSuchConcernException} if it could not be found.
    *
    * @param id the primary key of the concern
    * @return the concern
    * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern findByPrimaryKey(
        long id)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the concern with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the concern
    * @return the concern, or <code>null</code> if a concern with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the concerns where state = &#63;.
    *
    * @param state the state
    * @return the matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByState(
        int state) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByState(state);
    }

    /**
    * Returns a range of all the concerns where state = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param state the state
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @return the range of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByState(
        int state, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByState(state, start, end);
    }

    /**
    * Returns an ordered range of all the concerns where state = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param state the state
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByState(
        int state, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByState(state, start, end, orderByComparator);
    }

    /**
    * Returns the first concern in the ordered set where state = &#63;.
    *
    * @param state the state
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching concern
    * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern findByState_First(
        int state,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByState_First(state, orderByComparator);
    }

    /**
    * Returns the first concern in the ordered set where state = &#63;.
    *
    * @param state the state
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching concern, or <code>null</code> if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern fetchByState_First(
        int state,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByState_First(state, orderByComparator);
    }

    /**
    * Returns the last concern in the ordered set where state = &#63;.
    *
    * @param state the state
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching concern
    * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern findByState_Last(
        int state,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByState_Last(state, orderByComparator);
    }

    /**
    * Returns the last concern in the ordered set where state = &#63;.
    *
    * @param state the state
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching concern, or <code>null</code> if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern fetchByState_Last(
        int state,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByState_Last(state, orderByComparator);
    }

    /**
    * Returns the concerns before and after the current concern in the ordered set where state = &#63;.
    *
    * @param id the primary key of the current concern
    * @param state the state
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next concern
    * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern[] findByState_PrevAndNext(
        long id, int state,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByState_PrevAndNext(id, state, orderByComparator);
    }

    /**
    * Returns all the concerns where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the concerns where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @return the range of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the concerns where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first concern in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching concern
    * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first concern in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching concern, or <code>null</code> if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last concern in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching concern
    * @throws com.govapps.persistence.NoSuchConcernException if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last concern in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching concern, or <code>null</code> if a matching concern could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the concerns before and after the current concern in the ordered set where companyId = &#63;.
    *
    * @param id the primary key of the current concern
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next concern
    * @throws com.govapps.persistence.NoSuchConcernException if a concern with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.govapps.persistence.model.Concern[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.govapps.persistence.NoSuchConcernException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(id, companyId, orderByComparator);
    }

    /**
    * Returns all the concerns.
    *
    * @return the concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the concerns.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @return the range of concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the concerns.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of concerns
    * @param end the upper bound of the range of concerns (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of concerns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.govapps.persistence.model.Concern> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the concerns where state = &#63; from the database.
    *
    * @param state the state
    * @throws SystemException if a system exception occurred
    */
    public static void removeByState(int state)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByState(state);
    }

    /**
    * Removes all the concerns where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Removes all the concerns from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of concerns where state = &#63;.
    *
    * @param state the state
    * @return the number of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static int countByState(int state)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByState(state);
    }

    /**
    * Returns the number of concerns where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching concerns
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the number of concerns.
    *
    * @return the number of concerns
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ConcernPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ConcernPersistence) PortletBeanLocatorUtil.locate(com.govapps.persistence.service.ClpSerializer.getServletContextName(),
                    ConcernPersistence.class.getName());

            ReferenceRegistry.registerReference(ConcernUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ConcernPersistence persistence) {
    }
}
