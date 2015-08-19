package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsLocalServiceUtil.java 566 2014-11-13 15:22:01Z sma $
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
 * The utility for the legal details local service. This utility wraps {@link de.fraunhofer.fokus.movepla.service.impl.LegalDetailsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see LegalDetailsLocalService
 * @see de.fraunhofer.fokus.movepla.service.base.LegalDetailsLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.LegalDetailsLocalServiceImpl
 * @generated
 */
public class LegalDetailsLocalServiceUtil {
    private static LegalDetailsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.LegalDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the legal details to the database. Also notifies the appropriate model listeners.
    *
    * @param legalDetails the legal details
    * @return the legal details that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails addLegalDetails(
        de.fraunhofer.fokus.movepla.model.LegalDetails legalDetails)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLegalDetails(legalDetails);
    }

    /**
    * Creates a new legal details with the primary key. Does not add the legal details to the database.
    *
    * @param legalDetailsId the primary key for the new legal details
    * @return the new legal details
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails createLegalDetails(
        long legalDetailsId) {
        return getService().createLegalDetails(legalDetailsId);
    }

    /**
    * Deletes the legal details with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param legalDetailsId the primary key of the legal details
    * @return the legal details that was removed
    * @throws PortalException if a legal details with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails deleteLegalDetails(
        long legalDetailsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLegalDetails(legalDetailsId);
    }

    /**
    * Deletes the legal details from the database. Also notifies the appropriate model listeners.
    *
    * @param legalDetails the legal details
    * @return the legal details that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails deleteLegalDetails(
        de.fraunhofer.fokus.movepla.model.LegalDetails legalDetails)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLegalDetails(legalDetails);
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

    public static de.fraunhofer.fokus.movepla.model.LegalDetails fetchLegalDetails(
        long legalDetailsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLegalDetails(legalDetailsId);
    }

    /**
    * Returns the legal details with the primary key.
    *
    * @param legalDetailsId the primary key of the legal details
    * @return the legal details
    * @throws PortalException if a legal details with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails getLegalDetails(
        long legalDetailsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLegalDetails(legalDetailsId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the legal detailses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of legal detailses
    * @param end the upper bound of the range of legal detailses (not inclusive)
    * @return the range of legal detailses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.movepla.model.LegalDetails> getLegalDetailses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLegalDetailses(start, end);
    }

    /**
    * Returns the number of legal detailses.
    *
    * @return the number of legal detailses
    * @throws SystemException if a system exception occurred
    */
    public static int getLegalDetailsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLegalDetailsesCount();
    }

    /**
    * Updates the legal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param legalDetails the legal details
    * @return the legal details that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails updateLegalDetails(
        de.fraunhofer.fokus.movepla.model.LegalDetails legalDetails)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLegalDetails(legalDetails);
    }

    /**
    * Updates the legal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param legalDetails the legal details
    * @param merge whether to merge the legal details with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the legal details that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.movepla.model.LegalDetails updateLegalDetails(
        de.fraunhofer.fokus.movepla.model.LegalDetails legalDetails,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLegalDetails(legalDetails, merge);
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

    public static java.util.List<de.fraunhofer.fokus.movepla.model.LegalDetails> findByc(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByc(companyId);
    }

    public static int countLegalDetails(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countLegalDetails(companyId);
    }

    public static void clearService() {
        _service = null;
    }

    public static LegalDetailsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LegalDetailsLocalService.class.getName());

            if (invokableLocalService instanceof LegalDetailsLocalService) {
                _service = (LegalDetailsLocalService) invokableLocalService;
            } else {
                _service = new LegalDetailsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LegalDetailsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LegalDetailsLocalService service) {
    }
}
