package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: LoggingLocalServiceUtil.java 566 2014-11-13 15:22:01Z sma $
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
 * The utility for the logging local service. This utility wraps {@link de.fraunhofer.fokus.movepla.service.impl.LoggingLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see LoggingLocalService
 * @see de.fraunhofer.fokus.movepla.service.base.LoggingLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.LoggingLocalServiceImpl
 * @generated
 */
public class LoggingLocalServiceUtil {
    private static LoggingLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.LoggingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the logging to the database. Also notifies the appropriate model listeners.
    *
    * @param logging the logging
    * @return the logging that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging addLogging(
        de.fraunhofer.fokus.movepla.model.Logging logging)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLogging(logging);
    }

    /**
    * Creates a new logging with the primary key. Does not add the logging to the database.
    *
    * @param loggingId the primary key for the new logging
    * @return the new logging
    */
    public static de.fraunhofer.fokus.movepla.model.Logging createLogging(
        long loggingId) {
        return getService().createLogging(loggingId);
    }

    /**
    * Deletes the logging with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param loggingId the primary key of the logging
    * @return the logging that was removed
    * @throws PortalException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging deleteLogging(
        long loggingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLogging(loggingId);
    }

    /**
    * Deletes the logging from the database. Also notifies the appropriate model listeners.
    *
    * @param logging the logging
    * @return the logging that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging deleteLogging(
        de.fraunhofer.fokus.movepla.model.Logging logging)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLogging(logging);
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

    public static de.fraunhofer.fokus.movepla.model.Logging fetchLogging(
        long loggingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLogging(loggingId);
    }

    /**
    * Returns the logging with the primary key.
    *
    * @param loggingId the primary key of the logging
    * @return the logging
    * @throws PortalException if a logging with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging getLogging(
        long loggingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLogging(loggingId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the loggings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of loggings
    * @param end the upper bound of the range of loggings (not inclusive)
    * @return the range of loggings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLoggings(start, end);
    }

    /**
    * Returns the number of loggings.
    *
    * @return the number of loggings
    * @throws SystemException if a system exception occurred
    */
    public static int getLoggingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLoggingsCount();
    }

    /**
    * Updates the logging in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param logging the logging
    * @return the logging that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging updateLogging(
        de.fraunhofer.fokus.movepla.model.Logging logging)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLogging(logging);
    }

    /**
    * Updates the logging in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param logging the logging
    * @param merge whether to merge the logging with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the logging that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Logging updateLogging(
        de.fraunhofer.fokus.movepla.model.Logging logging, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLogging(logging, merge);
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

    public static void addSimpleLog(java.lang.String searchString) {
        getService().addSimpleLog(searchString);
    }

    public static void addComplexLog(java.lang.String searchString,
        java.lang.String categoryIDString, java.lang.String regionIDString,
        java.lang.String entitlementIDString, java.lang.String targetOS,
        int fee, java.lang.String targetCategory) {
        getService()
            .addComplexLog(searchString, categoryIDString, regionIDString,
            entitlementIDString, targetOS, fee, targetCategory);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getMostUsedSearchStringNotNull() {
        return getService().getMostUsedSearchStringNotNull();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getAllLoggings() {
        return getService().getAllLoggings();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getMostUsedSearchStringInclNull() {
        return getService().getMostUsedSearchStringInclNull();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggingsByCategories() {
        return getService().getLoggingsByCategories();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggingsByRegions() {
        return getService().getLoggingsByRegions();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggingsByMissingEntitlements() {
        return getService().getLoggingsByMissingEntitlements();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggingsByPlatforms() {
        return getService().getLoggingsByPlatforms();
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Logging> getLoggingsByTargetCategories() {
        return getService().getLoggingsByTargetCategories();
    }

    public static void clearService() {
        _service = null;
    }

    public static LoggingLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LoggingLocalService.class.getName());

            if (invokableLocalService instanceof LoggingLocalService) {
                _service = (LoggingLocalService) invokableLocalService;
            } else {
                _service = new LoggingLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LoggingLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LoggingLocalService service) {
    }
}
