package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: LinkLocalServiceWrapper.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LinkLocalService}.
 * </p>
 *
 * @author    jpa
 * @see       LinkLocalService
 * @generated
 */
public class LinkLocalServiceWrapper implements LinkLocalService,
    ServiceWrapper<LinkLocalService> {
    private LinkLocalService _linkLocalService;

    public LinkLocalServiceWrapper(LinkLocalService linkLocalService) {
        _linkLocalService = linkLocalService;
    }

    /**
    * Adds the link to the database. Also notifies the appropriate model listeners.
    *
    * @param link the link
    * @return the link that was added
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link addLink(
        de.fraunhofer.fokus.movepla.model.Link link)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.addLink(link);
    }

    /**
    * Creates a new link with the primary key. Does not add the link to the database.
    *
    * @param linkId the primary key for the new link
    * @return the new link
    */
    public de.fraunhofer.fokus.movepla.model.Link createLink(long linkId) {
        return _linkLocalService.createLink(linkId);
    }

    /**
    * Deletes the link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param linkId the primary key of the link
    * @return the link that was removed
    * @throws PortalException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link deleteLink(long linkId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.deleteLink(linkId);
    }

    /**
    * Deletes the link from the database. Also notifies the appropriate model listeners.
    *
    * @param link the link
    * @return the link that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link deleteLink(
        de.fraunhofer.fokus.movepla.model.Link link)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.deleteLink(link);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _linkLocalService.dynamicQuery();
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.dynamicQuery(dynamicQuery);
    }

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
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.dynamicQuery(dynamicQuery, start, end);
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.dynamicQueryCount(dynamicQuery);
    }

    public de.fraunhofer.fokus.movepla.model.Link fetchLink(long linkId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.fetchLink(linkId);
    }

    /**
    * Returns the link with the primary key.
    *
    * @param linkId the primary key of the link
    * @return the link
    * @throws PortalException if a link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link getLink(long linkId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.getLink(linkId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.getLinks(start, end);
    }

    /**
    * Returns the number of links.
    *
    * @return the number of links
    * @throws SystemException if a system exception occurred
    */
    public int getLinksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.getLinksCount();
    }

    /**
    * Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param link the link
    * @return the link that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link updateLink(
        de.fraunhofer.fokus.movepla.model.Link link)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.updateLink(link);
    }

    /**
    * Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param link the link
    * @param merge whether to merge the link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the link that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Link updateLink(
        de.fraunhofer.fokus.movepla.model.Link link, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.updateLink(link, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _linkLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _linkLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _linkLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.findByc(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.findByca(companyId, applicationId);
    }

    public int countLinks(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.countLinks(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getByType(
        int type) throws com.liferay.portal.kernel.exception.SystemException {
        return _linkLocalService.getByType(type);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LinkLocalService getWrappedLinkLocalService() {
        return _linkLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLinkLocalService(LinkLocalService linkLocalService) {
        _linkLocalService = linkLocalService;
    }

    public LinkLocalService getWrappedService() {
        return _linkLocalService;
    }

    public void setWrappedService(LinkLocalService linkLocalService) {
        _linkLocalService = linkLocalService;
    }
}
