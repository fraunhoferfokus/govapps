package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationLocalServiceUtil.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the application local service. This utility wraps {@link de.fraunhofer.fokus.movepla.service.impl.ApplicationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see ApplicationLocalService
 * @see de.fraunhofer.fokus.movepla.service.base.ApplicationLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.ApplicationLocalServiceImpl
 * @generated
 */
public class ApplicationLocalServiceUtil {
    private static ApplicationLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.ApplicationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the application to the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addApplication(application);
    }

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public static de.fraunhofer.fokus.movepla.model.Application createApplication(
        long applicationId) {
        return getService().createApplication(applicationId);
    }

    /**
    * Deletes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application deleteApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplication(applicationId);
    }

    /**
    * Deletes the application from the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application deleteApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplication(application);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static de.fraunhofer.fokus.movepla.model.Application fetchApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchApplication(applicationId);
    }

    /**
    * Returns the application with the primary key.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application getApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication(applicationId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplications(start, end);
    }

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public static int getApplicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationsCount();
    }

    /**
    * Updates the application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplication(application);
    }

    /**
    * Updates the application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @param merge whether to merge the application with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the application that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplication(application, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static de.fraunhofer.fokus.movepla.model.Application clone(
        long oldApplicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().clone(oldApplicationId);
    }

    public static de.fraunhofer.fokus.movepla.model.Application clone4NewVersion(
        long oldApplicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().clone4NewVersion(oldApplicationId);
    }

    public static de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addApplication(application, imageFile);
    }

    public static de.fraunhofer.fokus.movepla.model.Application addApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile,
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> categories,
        java.util.List<de.fraunhofer.fokus.movepla.model.Language> languages,
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> regions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addApplication(application, imageFile, categories,
            languages, regions);
    }

    public static void addCategories2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long[] categoryPks)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addCategories2Application(application, categoryPks);
    }

    public static void addCategory2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addCategory2Application(application, categoryPK);
    }

    public static void addLanguages2Application(long applicationId,
        long[] languagePks)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addLanguages2Application(applicationId, languagePks);
    }

    public static void addLanguage2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long languagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addLanguage2Application(application, languagePK);
    }

    public static void addRegion2Application(
        de.fraunhofer.fokus.movepla.model.Application application,
        long[] regionPks)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addRegion2Application(application, regionPks);
    }

    public static void addRegionApplication(
        de.fraunhofer.fokus.movepla.model.Application application, long regionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addRegionApplication(application, regionPK);
    }

    public static void developerDeleteApplication(
        de.fraunhofer.fokus.movepla.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().developerDeleteApplication(application);
    }

    public static void developerDeleteApplication(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().developerDeleteApplication(applicationId);
    }

    public static void deleteApplication(long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteApplication(companyId, applicationId);
    }

    public static void deleteOldApplication(long oldApplicationId,
        long newApplicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteOldApplication(oldApplicationId, newApplicationId);
    }

    public static de.fraunhofer.fokus.movepla.model.Application updateApplication(
        de.fraunhofer.fokus.movepla.model.Application application,
        java.io.File imageFile)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplication(application, imageFile);
    }

    public static de.fraunhofer.fokus.movepla.model.Application updateApplicationFileEntry(
        de.fraunhofer.fokus.movepla.model.Application application,
        com.liferay.portal.kernel.repository.model.FileEntry tempImageFileEntry)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateApplicationFileEntry(application, tempImageFileEntry);
    }

    public static de.fraunhofer.fokus.movepla.model.Application developerUpdateApplicationFileEntry(
        de.fraunhofer.fokus.movepla.model.Application application,
        com.liferay.portal.kernel.repository.model.FileEntry tempImageFileEntry)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .developerUpdateApplicationFileEntry(application,
            tempImageFileEntry);
    }

    public static int getApplicationsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationsCount(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplications(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplications(companyId, userId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsBycl(
        long companyId, int lifecyclestatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationsBycl(companyId, lifecyclestatus);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications4Verification(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplications4Verification(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getDeveloperApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDeveloperApplications(companyId, userId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Category> getCategories(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategories(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplicationEntitlements(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationEntitlements(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Language> getLanguages(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLanguages(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Link> getLinks(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLinks(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.MultiMedia> getMultiMedias(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMultiMedias(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Region> getRegions(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRegions(applicationId);
    }

    public static void clearCategories(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearCategories(applicationId);
    }

    public static void clearRegions(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearRegions(applicationId);
    }

    public static void clearLanguages(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearLanguages(applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsAfter(
        int status, java.util.Date date)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationsAfter(status, date);
    }

    public static java.util.List<java.util.List> getNewApplications(
        long companyId, int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getNewApplications(companyId, year, month, day, count);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsByCategories(
        java.util.List<de.fraunhofer.fokus.movepla.model.Category> allCategories) {
        return getService().getApplicationsByCategories(allCategories);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsByRegions(
        java.util.List<de.fraunhofer.fokus.movepla.model.Region> allRegions) {
        return getService().getApplicationsByRegions(allRegions);
    }

    public static void updateStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().updateStatusString(companyId);
    }

    public static void removeStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeStatusString(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getLinkDoubles()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLinkDoubles();
    }

    public static java.util.List<java.lang.Long> getRelatedApplications()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRelatedApplications();
    }

    public static void removeWhitespaceFromTargetOS()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeWhitespaceFromTargetOS();
    }

    public static java.lang.String getUserEmailAddressByApplication(
        long applicationId) {
        return getService().getUserEmailAddressByApplication(applicationId);
    }

    public static void grantGuestViewPermissions() {
        getService().grantGuestViewPermissions();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications() {
        return getService().getMostViewdApplications();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications(
        int end) {
        return getService().getMostViewdApplications(end);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostViewdApplications(
        int from, int end) {
        return getService().getMostViewdApplications(from, end);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications() {
        return getService().getMostClickedApplications();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications(
        int end) {
        return getService().getMostClickedApplications(end);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application> getMostClickedApplications(
        int from, int end) {
        return getService().getMostClickedApplications(from, end);
    }

    public static void clearService() {
        _service = null;
    }

    public static ApplicationLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ApplicationLocalService.class.getName());

            if (invokableLocalService instanceof ApplicationLocalService) {
                _service = (ApplicationLocalService) invokableLocalService;
            } else {
                _service = new ApplicationLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ApplicationLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ApplicationLocalService service) {
    }
}
