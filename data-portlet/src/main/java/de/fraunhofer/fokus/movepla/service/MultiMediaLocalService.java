package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: MultiMediaLocalService.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the multi media local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see MultiMediaLocalServiceUtil
 * @see de.fraunhofer.fokus.movepla.service.base.MultiMediaLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.MultiMediaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MultiMediaLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MultiMediaLocalServiceUtil} to access the multi media local service. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.MultiMediaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the multi media to the database. Also notifies the appropriate model listeners.
    *
    * @param multiMedia the multi media
    * @return the multi media that was added
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia addMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new multi media with the primary key. Does not add the multi media to the database.
    *
    * @param multiMediaId the primary key for the new multi media
    * @return the new multi media
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia createMultiMedia(
        long multiMediaId);

    /**
    * Deletes the multi media with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param multiMediaId the primary key of the multi media
    * @return the multi media that was removed
    * @throws PortalException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia deleteMultiMedia(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the multi media from the database. Also notifies the appropriate model listeners.
    *
    * @param multiMedia the multi media
    * @return the multi media that was removed
    * @throws PortalException
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia deleteMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public de.fraunhofer.fokus.movepla.model.MultiMedia fetchMultiMedia(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the multi media with the primary key.
    *
    * @param multiMediaId the primary key of the multi media
    * @return the multi media
    * @throws PortalException if a multi media with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public de.fraunhofer.fokus.movepla.model.MultiMedia getMultiMedia(
        long multiMediaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of multi medias.
    *
    * @return the number of multi medias
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMultiMediasCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the multi media in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param multiMedia the multi media
    * @return the multi media that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia updateMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the multi media in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param multiMedia the multi media
    * @param merge whether to merge the multi media with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the multi media that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.MultiMedia updateMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public de.fraunhofer.fokus.movepla.model.MultiMedia addMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public de.fraunhofer.fokus.movepla.model.MultiMedia updateMultiMedia(
        de.fraunhofer.fokus.movepla.model.MultiMedia multiMedia,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findBycai(
        long companyId, long applicationId, long imageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> findByImage(
        long imageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countMultiMedias(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
