package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: CategoryPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see CategoryPersistenceImpl
 * @see CategoryUtil
 * @generated
 */
public interface CategoryPersistence extends BasePersistence<Category> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the category in the entity cache if it is enabled.
    *
    * @param category the category
    */
    public void cacheResult(de.fraunhofer.fokus.movepla.model.Category category);

    /**
    * Caches the categories in the entity cache if it is enabled.
    *
    * @param categories the categories
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories);

    /**
    * Creates a new category with the primary key. Does not add the category to the database.
    *
    * @param categoryId the primary key for the new category
    * @return the new category
    */
    public de.fraunhofer.fokus.movepla.model.Category create(long categoryId);

    /**
    * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param categoryId the primary key of the category
    * @return the category that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category remove(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    public de.fraunhofer.fokus.movepla.model.Category updateImpl(
        de.fraunhofer.fokus.movepla.model.Category category, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the category with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchCategoryException} if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findByPrimaryKey(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category, or <code>null</code> if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchByPrimaryKey(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categories where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the categories where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the categories where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first category in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the first category in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last category in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the last category in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the categories before and after the current category in the ordered set where companyId = &#63;.
    *
    * @param categoryId the primary key of the current category
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category[] findByc_PrevAndNext(
        long categoryId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns all the categories where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @return the matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findBycp(
        long companyId, long parentCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the categories where companyId = &#63; and parentCategory = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findBycp(
        long companyId, long parentCategory, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the categories where companyId = &#63; and parentCategory = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findBycp(
        long companyId, long parentCategory, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first category in the ordered set where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findBycp_First(
        long companyId, long parentCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the first category in the ordered set where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchBycp_First(
        long companyId, long parentCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last category in the ordered set where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findBycp_Last(
        long companyId, long parentCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the last category in the ordered set where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchBycp_Last(
        long companyId, long parentCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the categories before and after the current category in the ordered set where companyId = &#63; and parentCategory = &#63;.
    *
    * @param categoryId the primary key of the current category
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category[] findBycp_PrevAndNext(
        long categoryId, long companyId, long parentCategory,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the category where categoryName = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchCategoryException} if it could not be found.
    *
    * @param categoryName the category name
    * @return the matching category
    * @throws de.fraunhofer.fokus.movepla.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category findBycategoryName(
        java.lang.String categoryName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param categoryName the category name
    * @return the matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchBycategoryName(
        java.lang.String categoryName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param categoryName the category name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category fetchBycategoryName(
        java.lang.String categoryName, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categories.
    *
    * @return the categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the categories where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the categories where companyId = &#63; and parentCategory = &#63; from the database.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @throws SystemException if a system exception occurred
    */
    public void removeBycp(long companyId, long parentCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the category where categoryName = &#63; from the database.
    *
    * @param categoryName the category name
    * @return the category that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Category removeBycategoryName(
        java.lang.String categoryName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchCategoryException;

    /**
    * Removes all the categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching categories
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories where companyId = &#63; and parentCategory = &#63;.
    *
    * @param companyId the company ID
    * @param parentCategory the parent category
    * @return the number of matching categories
    * @throws SystemException if a system exception occurred
    */
    public int countBycp(long companyId, long parentCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories where categoryName = &#63;.
    *
    * @param categoryName the category name
    * @return the number of matching categories
    * @throws SystemException if a system exception occurred
    */
    public int countBycategoryName(java.lang.String categoryName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories.
    *
    * @return the number of categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the applications associated with the category.
    *
    * @param pk the primary key of the category
    * @return the applications associated with the category
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the applications associated with the category.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the category
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of applications associated with the category
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the applications associated with the category.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the category
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of applications associated with the category
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications associated with the category.
    *
    * @param pk the primary key of the category
    * @return the number of applications associated with the category
    * @throws SystemException if a system exception occurred
    */
    public int getApplicationsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application is associated with the category.
    *
    * @param pk the primary key of the category
    * @param applicationPK the primary key of the application
    * @return <code>true</code> if the application is associated with the category; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the category has any applications associated with it.
    *
    * @param pk the primary key of the category to check for associations with applications
    * @return <code>true</code> if the category has any applications associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public void addApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public void addApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public void addApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public void addApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the category and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category to clear the associated applications from
    * @throws SystemException if a system exception occurred
    */
    public void clearApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public void removeApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the category and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public void removeApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public void removeApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the category and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public void removeApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the applications associated with the category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applicationPKs the primary keys of the applications to be associated with the category
    * @throws SystemException if a system exception occurred
    */
    public void setApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the applications associated with the category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the category
    * @param applications the applications to be associated with the category
    * @throws SystemException if a system exception occurred
    */
    public void setApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;
}
