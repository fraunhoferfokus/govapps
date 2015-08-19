package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationLocalServiceWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link ApplicationLocalService}.
 * </p>
 *
 * @author    jpa
 * @see       ApplicationLocalService
 * @generated
 */
public class ApplicationLocalServiceWrapper implements ApplicationLocalService,
    ServiceWrapper<ApplicationLocalService> {
    private ApplicationLocalService _applicationLocalService;

    public ApplicationLocalServiceWrapper(
        ApplicationLocalService applicationLocalService) {
        _applicationLocalService = applicationLocalService;
    }

    /**
    * Adds the application to the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was added
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.addApplication(application);
    }

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public de.fraunhofer.fokus.movepla.model.Application createApplication(
        long applicationId) {
        return _applicationLocalService.createApplication(applicationId);
    }

    /**
    * Deletes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application deleteApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.deleteApplication(applicationId);
    }

    /**
    * Deletes the application from the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application deleteApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.deleteApplication(application);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _applicationLocalService.dynamicQuery();
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
        return _applicationLocalService.dynamicQuery(dynamicQuery);
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
        return _applicationLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _applicationLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _applicationLocalService.dynamicQueryCount(dynamicQuery);
    }

    public de.fraunhofer.fokus.movepla.model.Application fetchApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.fetchApplication(applicationId);
    }

    /**
    * Returns the application with the primary key.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application getApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplication(applicationId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the applications.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of applications
    * @param end the upper bound of the range of applications (not inclusive)
    * @return the range of applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplications(start, end);
    }

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public int getApplicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplicationsCount();
    }

    /**
    * Updates the application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.updateApplication(application);
    }

    /**
    * Updates the application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @param merge whether to merge the application with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the application that was updated
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.updateApplication(application, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _applicationLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _applicationLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _applicationLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public de.fraunhofer.fokus.movepla.model.Application clone(
        long oldApplicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.clone(oldApplicationId);
    }

    public de.fraunhofer.fokus.movepla.model.Application clone4NewVersion(
        long oldApplicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.clone4NewVersion(oldApplicationId);
    }

    public de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.addApplication(application, imageFile);
    }

    public de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.addApplication(application, imageFile,
            categories, languages, regions);
    }

    public void addCategories2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long[] categoryPks)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addCategories2Application(application,
            categoryPks);
    }

    public void addCategory2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addCategory2Application(application, categoryPK);
    }

    public void addLanguages2Application(long applicationId, long[] languagePks)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addLanguages2Application(applicationId,
            languagePks);
    }

    public void addLanguage2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addLanguage2Application(application, languagePK);
    }

    public void addRegion2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long[] regionPks)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addRegion2Application(application, regionPks);
    }

    public void addRegionApplication(
        de.fraunhofer.fokus.movepla.model.Application application, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.addRegionApplication(application, regionPK);
    }

    public void developerDeleteApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.developerDeleteApplication(application);
    }

    public void developerDeleteApplication(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.developerDeleteApplication(applicationId);
    }

    public void deleteApplication(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.deleteApplication(companyId, applicationId);
    }

    public void deleteOldApplication(long oldApplicationId,
        long newApplicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.deleteOldApplication(oldApplicationId,
            newApplicationId);
    }

    public de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.updateApplication(application, imageFile);
    }

    public de.fraunhofer.fokus.movepla.model.Application updateApplicationFileEntry(
        de.fraunhofer.fokus.movepla.model.Application application,
        com.liferay.portal.kernel.repository.model.FileEntry tempImageFileEntry)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.updateApplicationFileEntry(application,
            tempImageFileEntry);
    }

    public de.fraunhofer.fokus.movepla.model.Application developerUpdateApplicationFileEntry(
        de.fraunhofer.fokus.movepla.model.Application application,
        com.liferay.portal.kernel.repository.model.FileEntry tempImageFileEntry)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.developerUpdateApplicationFileEntry(application,
            tempImageFileEntry);
    }

    public int getApplicationsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplicationsCount(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplications(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplications(companyId, userId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsBycl(
        long companyId, int lifecyclestatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplicationsBycl(companyId,
            lifecyclestatus);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications4Verification(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplications4Verification(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getDeveloperApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getDeveloperApplications(companyId,
            userId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getCategories(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplicationEntitlements(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplicationEntitlements(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getLanguages(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getLinks(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getMultiMedias(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getRegions(applicationId);
    }

    public void clearCategories(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.clearCategories(applicationId);
    }

    public void clearRegions(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.clearRegions(applicationId);
    }

    public void clearLanguages(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.clearLanguages(applicationId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsAfter(
        int status, java.util.Date date)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getApplicationsAfter(status, date);
    }

    public java.util.List<java.util.List> getNewApplications(long companyId,
        int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getNewApplications(companyId, year,
            month, day, count);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsByCategories(
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> allCategories) {
        return _applicationLocalService.getApplicationsByCategories(allCategories);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsByRegions(
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> allRegions) {
        return _applicationLocalService.getApplicationsByRegions(allRegions);
    }

    public void updateStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.updateStatusString(companyId);
    }

    public void removeStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.removeStatusString(companyId);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getLinkDoubles()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getLinkDoubles();
    }

    public java.util.List<java.lang.Long> getRelatedApplications()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationLocalService.getRelatedApplications();
    }

    public void removeWhitespaceFromTargetOS()
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationLocalService.removeWhitespaceFromTargetOS();
    }

    public java.lang.String getUserEmailAddressByApplication(long applicationId) {
        return _applicationLocalService.getUserEmailAddressByApplication(applicationId);
    }

    public void grantGuestViewPermissions() {
        _applicationLocalService.grantGuestViewPermissions();
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications() {
        return _applicationLocalService.getMostViewdApplications();
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications(
        int end) {
        return _applicationLocalService.getMostViewdApplications(end);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications(
        int from, int end) {
        return _applicationLocalService.getMostViewdApplications(from, end);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications() {
        return _applicationLocalService.getMostClickedApplications();
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications(
        int end) {
        return _applicationLocalService.getMostClickedApplications(end);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications(
        int from, int end) {
        return _applicationLocalService.getMostClickedApplications(from, end);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ApplicationLocalService getWrappedApplicationLocalService() {
        return _applicationLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedApplicationLocalService(
        ApplicationLocalService applicationLocalService) {
        _applicationLocalService = applicationLocalService;
    }

    public ApplicationLocalService getWrappedService() {
        return _applicationLocalService;
    }

    public void setWrappedService(
        ApplicationLocalService applicationLocalService) {
        _applicationLocalService = applicationLocalService;
    }
}
