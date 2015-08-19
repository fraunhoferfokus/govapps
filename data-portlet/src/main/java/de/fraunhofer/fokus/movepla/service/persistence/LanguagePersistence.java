package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: LanguagePersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Language;

/**
 * The persistence interface for the language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see LanguagePersistenceImpl
 * @see LanguageUtil
 * @generated
 */
public interface LanguagePersistence extends BasePersistence<Language> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LanguageUtil} to access the language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the language in the entity cache if it is enabled.
    *
    * @param language the language
    */
    public void cacheResult(de.fraunhofer.fokus.movepla.model.Language language);

    /**
    * Caches the languages in the entity cache if it is enabled.
    *
    * @param languages the languages
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages);

    /**
    * Creates a new language with the primary key. Does not add the language to the database.
    *
    * @param LanguageId the primary key for the new language
    * @return the new language
    */
    public de.fraunhofer.fokus.movepla.model.Language create(long LanguageId);

    /**
    * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param LanguageId the primary key of the language
    * @return the language that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language remove(long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    public de.fraunhofer.fokus.movepla.model.Language updateImpl(
        de.fraunhofer.fokus.movepla.model.Language language, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the language with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
    *
    * @param LanguageId the primary key of the language
    * @return the language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language findByPrimaryKey(
        long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Returns the language with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param LanguageId the primary key of the language
    * @return the language, or <code>null</code> if a language with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language fetchByPrimaryKey(
        long LanguageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the languages where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching languages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Returns the first language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Returns the last language in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.Language[] findByc_PrevAndNext(
        long LanguageId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Returns the language where languageName = &#63; or throws a {@link de.fraunhofer.fokus.movepla.NoSuchLanguageException} if it could not be found.
    *
    * @param languageName the language name
    * @return the matching language
    * @throws de.fraunhofer.fokus.movepla.NoSuchLanguageException if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language findBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param languageName the language name
    * @return the matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language fetchBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the language where languageName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param languageName the language name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching language, or <code>null</code> if a matching language could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language fetchBylanguageName(
        java.lang.String languageName, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the languages.
    *
    * @return the languages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the languages where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the language where languageName = &#63; from the database.
    *
    * @param languageName the language name
    * @return the language that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Language removeBylanguageName(
        java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchLanguageException;

    /**
    * Removes all the languages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of languages where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching languages
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of languages where languageName = &#63;.
    *
    * @param languageName the language name
    * @return the number of matching languages
    * @throws SystemException if a system exception occurred
    */
    public int countBylanguageName(java.lang.String languageName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of languages.
    *
    * @return the number of languages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the applications associated with the language.
    *
    * @param pk the primary key of the language
    * @return the applications associated with the language
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications associated with the language.
    *
    * @param pk the primary key of the language
    * @return the number of applications associated with the language
    * @throws SystemException if a system exception occurred
    */
    public int getApplicationsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the application is associated with the language.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @return <code>true</code> if the application is associated with the language; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the language has any applications associated with it.
    *
    * @param pk the primary key of the language to check for associations with applications
    * @return <code>true</code> if the language has any applications associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public void addApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public void addApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public void addApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public void addApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the language and its applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language to clear the associated applications from
    * @throws SystemException if a system exception occurred
    */
    public void clearApplications(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPK the primary key of the application
    * @throws SystemException if a system exception occurred
    */
    public void removeApplication(long pk, long applicationPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the language and the application. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param application the application
    * @throws SystemException if a system exception occurred
    */
    public void removeApplication(long pk,
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications
    * @throws SystemException if a system exception occurred
    */
    public void removeApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the language and the applications. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications
    * @throws SystemException if a system exception occurred
    */
    public void removeApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applicationPKs the primary keys of the applications to be associated with the language
    * @throws SystemException if a system exception occurred
    */
    public void setApplications(long pk, long[] applicationPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the applications associated with the language, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the language
    * @param applications the applications to be associated with the language
    * @throws SystemException if a system exception occurred
    */
    public void setApplications(long pk,
        java.util.List<de.fraunhofer.fokus.movepla.model.Application> applications)
        throws com.liferay.portal.kernel.exception.SystemException;
}
