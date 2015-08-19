package de.fraunhofer.fokus.movepla.service.persistence;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsPersistence.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.RelatedApplications;

/**
 * The persistence interface for the related applications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jpa
 * @see RelatedApplicationsPersistenceImpl
 * @see RelatedApplicationsUtil
 * @generated
 */
public interface RelatedApplicationsPersistence extends BasePersistence<RelatedApplications> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RelatedApplicationsUtil} to access the related applications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the related applications in the entity cache if it is enabled.
    *
    * @param relatedApplications the related applications
    */
    public void cacheResult(
        de.fraunhofer.fokus.movepla.model.RelatedApplications relatedApplications);

    /**
    * Caches the related applicationses in the entity cache if it is enabled.
    *
    * @param relatedApplicationses the related applicationses
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> relatedApplicationses);

    /**
    * Creates a new related applications with the primary key. Does not add the related applications to the database.
    *
    * @param RelatedApplicationsID the primary key for the new related applications
    * @return the new related applications
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications create(
        long RelatedApplicationsID);

    /**
    * Removes the related applications with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications that was removed
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications remove(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    public de.fraunhofer.fokus.movepla.model.RelatedApplications updateImpl(
        de.fraunhofer.fokus.movepla.model.RelatedApplications relatedApplications,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the related applications with the primary key or throws a {@link de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException} if it could not be found.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByPrimaryKey(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the related applications with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param RelatedApplicationsID the primary key of the related applications
    * @return the related applications, or <code>null</code> if a related applications with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByPrimaryKey(
        long RelatedApplicationsID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the related applicationses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByc(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the first related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByc_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the last related applications in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByc_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByc_PrevAndNext(
        long RelatedApplicationsID, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns all the related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca(
        long companyId, long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca_First(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca_Last(
        long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByca_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns all the related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findByca2(
        long companyId, long applicationId2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByca2_First(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the first related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca2_First(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findByca2_Last(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the last related applications in the ordered set where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchByca2_Last(
        long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications[] findByca2_PrevAndNext(
        long RelatedApplicationsID, long companyId, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns all the related applicationses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findBya_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the first related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findBya_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the last related applications in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications[] findBya_PrevAndNext(
        long RelatedApplicationsID, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns all the related applicationses where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @return the matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findBya2(
        long applicationId2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findBya2_First(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the first related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya2_First(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications
    * @throws de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications findBya2_Last(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns the last related applications in the ordered set where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching related applications, or <code>null</code> if a matching related applications could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.RelatedApplications fetchBya2_Last(
        long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.movepla.model.RelatedApplications[] findBya2_PrevAndNext(
        long RelatedApplicationsID, long applicationId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException;

    /**
    * Returns all the related applicationses.
    *
    * @return the related applicationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.movepla.model.RelatedApplications> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses where companyId = &#63; and applicationId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses where companyId = &#63; and applicationId2 = &#63; from the database.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @throws SystemException if a system exception occurred
    */
    public void removeByca2(long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBya(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses where applicationId2 = &#63; from the database.
    *
    * @param applicationId2 the application id2
    * @throws SystemException if a system exception occurred
    */
    public void removeBya2(long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the related applicationses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countByc(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses where companyId = &#63; and applicationId = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId the application ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countByca(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses where companyId = &#63; and applicationId2 = &#63;.
    *
    * @param companyId the company ID
    * @param applicationId2 the application id2
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countByca2(long companyId, long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countBya(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses where applicationId2 = &#63;.
    *
    * @param applicationId2 the application id2
    * @return the number of matching related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countBya2(long applicationId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of related applicationses.
    *
    * @return the number of related applicationses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
