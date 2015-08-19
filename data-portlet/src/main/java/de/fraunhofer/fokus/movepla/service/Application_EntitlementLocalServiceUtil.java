package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementLocalServiceUtil.java 566 2014-11-13 15:22:01Z sma $
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
 * The utility for the application_ entitlement local service. This utility wraps {@link de.fraunhofer.fokus.movepla.service.impl.Application_EntitlementLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see Application_EntitlementLocalService
 * @see de.fraunhofer.fokus.movepla.service.base.Application_EntitlementLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.Application_EntitlementLocalServiceImpl
 * @generated
 */
public class Application_EntitlementLocalServiceUtil {
    private static Application_EntitlementLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.Application_EntitlementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the application_ entitlement to the database. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement addApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addApplication_Entitlement(application_Entitlement);
    }

    /**
    * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
    *
    * @param applicationEntitlementID the primary key for the new application_ entitlement
    * @return the new application_ entitlement
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement createApplication_Entitlement(
        long applicationEntitlementID) {
        return getService()
                   .createApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Deletes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws PortalException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement deleteApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Deletes the application_ entitlement from the database. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement deleteApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteApplication_Entitlement(application_Entitlement);
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

    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement fetchApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .fetchApplication_Entitlement(applicationEntitlementID);
    }

    /**
    * Returns the application_ entitlement with the primary key.
    *
    * @param applicationEntitlementID the primary key of the application_ entitlement
    * @return the application_ entitlement
    * @throws PortalException if a application_ entitlement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement getApplication_Entitlement(
        long applicationEntitlementID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication_Entitlement(applicationEntitlementID);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication_Entitlements(start, end);
    }

    /**
    * Returns the number of application_ entitlements.
    *
    * @return the number of application_ entitlements
    * @throws SystemException if a system exception occurred
    */
    public static int getApplication_EntitlementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication_EntitlementsCount();
    }

    /**
    * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @return the application_ entitlement that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateApplication_Entitlement(application_Entitlement);
    }

    /**
    * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application_Entitlement the application_ entitlement
    * @param merge whether to merge the application_ entitlement with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the application_ entitlement that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        de.fraunhofer.fokus.movepla.model.Application_Entitlement application_Entitlement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateApplication_Entitlement(application_Entitlement, merge);
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

    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement addApplication_Entitlement(
        long userId, long companyId, long applicationId, long entitlementId,
        java.lang.String name, java.lang.String motivation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addApplication_Entitlement(userId, companyId,
            applicationId, entitlementId, name, motivation);
    }

    public static void deleteApplication_EntitlementById(
        long application_EntitlementId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteApplication_EntitlementById(application_EntitlementId);
    }

    public static int getApplication_EntitlementsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication_EntitlementsCount(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> getApplication_Entitlements(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication_Entitlements(companyId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByca(
        long companyId, long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByca(companyId, applicationId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findByce(
        long companyId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByce(companyId, entitlementId);
    }

    public static java.util.List<de.fraunhofer.fokus.movepla.model.Application_Entitlement> findBycae(
        long companyId, long applicationId, long entitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBycae(companyId, applicationId, entitlementId);
    }

    public static de.fraunhofer.fokus.movepla.model.Application_Entitlement updateApplication_Entitlement(
        long userId, long companyId, long applicationId, long entitlementId,
        java.lang.String name, java.lang.String motivation,
        long application_EntitlementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateApplication_Entitlement(userId, companyId,
            applicationId, entitlementId, name, motivation,
            application_EntitlementId);
    }

    public static void clearService() {
        _service = null;
    }

    public static Application_EntitlementLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Application_EntitlementLocalService.class.getName());

            if (invokableLocalService instanceof Application_EntitlementLocalService) {
                _service = (Application_EntitlementLocalService) invokableLocalService;
            } else {
                _service = new Application_EntitlementLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(Application_EntitlementLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(Application_EntitlementLocalService service) {
    }
}
