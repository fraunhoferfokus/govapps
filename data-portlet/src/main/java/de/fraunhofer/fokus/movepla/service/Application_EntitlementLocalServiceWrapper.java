package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementLocalServiceWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Application_EntitlementLocalService}.
 * </p>
 *
 * @author    jpa
 * @see       Application_EntitlementLocalService
 * @generated
 */
public class Application_EntitlementLocalServiceWrapper
    implements Application_EntitlementLocalService,
        ServiceWrapper<Application_EntitlementLocalService> {
    private Application_EntitlementLocalService _application_EntitlementLocalService;

    public Application_EntitlementLocalServiceWrapper(
        Application_EntitlementLocalService application_EntitlementLocalService) {
        _application_EntitlementLocalService = application_EntitlementLocalService;
    }

    /**
    * Adds the application_ entitlement to the database. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was added
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement addApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.addApplication_Entitlement(application_Entitlement);
    }

    /**
    * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
    *
    * @param applicationEntitlementID the primary key for the new application_ entitlement
    * @return the new application_ entitlement
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement createApplication_Entitlement(
        long applicationEntitlementID) {
        return _application_EntitlementLocalService.createApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Deletes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws PortalException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement deleteApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.deleteApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Deletes the application_ entitlement from the database. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement deleteApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.deleteApplication_Entitlement(application_Entitlement);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _application_EntitlementLocalService.dynamicQuery();
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
        return _application_EntitlementLocalService.dynamicQuery(dynamicQuery);
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
        return _application_EntitlementLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _application_EntitlementLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _application_EntitlementLocalService.dynamicQueryCount(dynamicQuery);
    }

    public de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.fetchApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Returns the application_ entitlement with the primary key.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement
    * @throws PortalException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement getApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getApplication_Entitlement(applicationEntitlementID);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the application_ entitlements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of application_ entitlements
    * @param end the upper bound of the range of application_ entitlements (not inclusive)
    * @return the range of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getApplication_Entitlements(start,
            end);
    }

    /**
    * Returns the number of application_ entitlements.
    *
    * @return the number of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public int getApplication_EntitlementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getApplication_EntitlementsCount();
    }

    /**
    * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.updateApplication_Entitlement(application_Entitlement);
    }

    /**
    * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @param merge whether to merge the application_ entitlement with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the application_ entitlement that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.updateApplication_Entitlement(application_Entitlement,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _application_EntitlementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _application_EntitlementLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _application_EntitlementLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public de.fraunhofer.fokus.movepla.model.Application_Entitlement addApplication_Entitlement(
        long userId, long companyId, long applicationId, long entitlementId,
        java.lang.String name, java.lang.String motivation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.addApplication_Entitlement(userId,
            companyId, applicationId, entitlementId, name, motivation);
    }

    public void deleteApplication_EntitlementById(
        long application_EntitlementId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _application_EntitlementLocalService.deleteApplication_EntitlementById(application_EntitlementId);
    }

    public int getApplication_EntitlementsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getApplication_EntitlementsCount(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.getApplication_Entitlements(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.findByca(companyId,
            applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.findByce(companyId,
            entitlementId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.findBycae(companyId,
            applicationId, entitlementId);
    }

    public de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        long userId, long companyId, long applicationId, long entitlementId,
        java.lang.String name, java.lang.String motivation,
        long application_EntitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application_EntitlementLocalService.updateApplication_Entitlement(userId,
            companyId, applicationId, entitlementId, name, motivation,
            application_EntitlementId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public Application_EntitlementLocalService getWrappedApplication_EntitlementLocalService() {
        return _application_EntitlementLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedApplication_EntitlementLocalService(
        Application_EntitlementLocalService application_EntitlementLocalService) {
        _application_EntitlementLocalService = application_EntitlementLocalService;
    }

    public Application_EntitlementLocalService getWrappedService() {
        return _application_EntitlementLocalService;
    }

    public void setWrappedService(
        Application_EntitlementLocalService application_EntitlementLocalService) {
        _application_EntitlementLocalService = application_EntitlementLocalService;
    }
}
