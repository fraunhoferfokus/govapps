package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LanguageUtil.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Language;

import java.util.List;

/**
 * The persistence utility for the language service. This utility wraps {@link LanguagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LanguagePersistence
 * @see LanguagePersistenceImpl
 * @generated
 */
public class LanguageUtil {
    private static LanguagePersistence _persistence;

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
    public static void clearCache(Language language) {
        getPersistence().clearCache(language);
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
    public static List<Language> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Language> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Language> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Language update(Language language, boolean merge)
        throws SystemException {
        return getPersistence().update(language, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Language update(Language language, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(language, merge, serviceContext);
    }

    /**
    * Caches the language in the entity cache if it is enabled.
    *
    * @param language the language
    */
    public static void cacheResult(
        de.fraunhofer.fokus.movepla.model.Language language) {
        getPersistence().cacheResult(language);
    }

    /**
    * Caches the languages in the entity cache if it is enabled.
    *
    * @param languages the languages
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages) {
        getPersistence().cacheResult(languages);
    }

    /**
    * Creates a new language with the primary key. Does not add the language to the database.
    *
    * @param LanguageId the primary key for the new language
    * @return the new language
    */
    public static de.fraunhofer.fokus.movepla.model.Language create(
        long LanguageId) {
        return getPersistence().create(LanguageId);
    }

    /**
    * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param LanguageId the primary key of the language
    * @return the language that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language remove(
        long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().remove(LanguageId);
    }

    public static de.fraunhofer.fokus.movepla.model.Language updateImpl(
        de.fraunhofer.fokus.movepla.model.Language language, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(language, merge);
    }

    /**
    * Returns the language with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
    *
    * @param LanguageId the primary key of the language
    * @return the language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language findByPrimaryKey(
        long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().findByPrimaryKey(LanguageId);
    }

    /**
    * Returns the language with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param LanguageId the primary key of the language
    * @return the language, or <code>null</code> if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language fetchByPrimaryKey(
        long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(LanguageId);
    }

    /**
    * Returns all the languages where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId);
    }

    /**
    * Returns a range of all the languages where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @return the range of matching languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the languages where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByc(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().findByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the first language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_First(companyId, orderByComparator);
    }

    /**
    * Returns the last language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().findByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByc_Last(companyId, orderByComparator);
    }

    /**
    * Returns the languages before and after the current language in the ordered set where companyId = &#63;.
    *
    * @param LanguageId the primary key of the current language
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language[] findByc_PrevAndNext(
        long LanguageId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence()
                   .findByc_PrevAndNext(LanguageId, companyId, orderByComparator);
    }

    /**
    * Returns the language where languageName = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
    *
    * @param languageName the language name
    * @return the matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language findBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().findBylanguageName(languageName);
    }

    /**
    * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param languageName the language name
    * @return the matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language fetchBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBylanguageName(languageName);
    }

    /**
    * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param languageName the language name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language fetchBylanguageName(
        java.lang.String languageName, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBylanguageName(languageName, retrieveFromCache);
    }

    /**
    * Returns all the languages.
    *
    * @return the languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the languages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @return the range of languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the languages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of languages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the languages where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByc(companyId);
    }

    /**
    * Removes the language where languageName = &#63; from the database.
    *
    * @param languageName the language name
    * @return the language that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Language removeBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException {
        return getPersistence().removeBylanguageName(languageName);
    }

    /**
    * Removes all the languages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of languages where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching languages
    * @throws SystemException if a system exception occurred
    */
    public static int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByc(companyId);
    }

    /**
    * Returns the number of languages where languageName = &#63;.
    *
    * @param languageName the language name
    * @return the number of matching languages
    * @throws SystemException if a system exception occurred
    */
    public static int countBylanguageName(java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBylanguageName(languageName);
    }

    /**
    * Returns the number of languages.
    *
    * @return the number of languages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the applications associated with the language.
    *
    * @param pk the primary key of the language
    * @return the applications associated with the language
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplications(pk);
    }

    /**
    * Returns a range of all the applications associated with the language.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the language
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @return the range of applications associated with the language
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplications(pk, start, end);
    }

    /**
    * Returns an ordered range of all the applications associated with the language.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the language
    * @param start the lower bound of the range of languages
    * @param end the upper bound of the range of languages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of applications associated with the language
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
    * Returns the number of applications associated with the language.
    *
    * @param pk the primary key of the language
    * @return the number of applications associated with the language
    * @throws SystemException if a system exception occurred
    */
    public static int getApplicationsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getApplicationsSize(pk);
    }

    /**
    * Returns <code>true</code> if the application is associated with the language.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @return <code>true</code> if the application is associated with the language; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsApplication(pk, applicationPK);
    }

    /**
    * Returns <code>true</code> if the language has any applications associated with it.
    *
    * @param pk the primary key of the language to check for associations with applications
    * @return <code>true</code> if the language has any applications associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsApplications(pk);
    }

    /**
    * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public static void addApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplication(pk, applicationPK);
    }

    /**
    * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public static void addApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplication(pk, application);
    }

    /**
    * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public static void addApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplications(pk, applicationPKs);
    }

    /**
    * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public static void addApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addApplications(pk, applications);
    }

    /**
    * Clears all associations between the language and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language to clear the associated applications from
    * @throws SystemException if a system exception occurred
    */
    public static void clearApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearApplications(pk);
    }

    /**
    * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplication(pk, applicationPK);
    }

    /**
    * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplication(pk, application);
    }

    /**
    * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplications(pk, applicationPKs);
    }

    /**
    * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public static void removeApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeApplications(pk, applications);
    }

    /**
    * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications to be associated with the language
    * @throws SystemException if a system exception occurred
    */
    public static void setApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setApplications(pk, applicationPKs);
    }

    /**
    * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications to be associated with the language
    * @throws SystemException if a system exception occurred
    */
    public static void setApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setApplications(pk, applications);
    }

    public static LanguagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LanguagePersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.movepla.service.ClpSerializer.getServletContextName(),
                    LanguagePersistence.class.getName());

            ReferenceRegistry.registerReference(LanguageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LanguagePersistence persistence) {
    }
}
