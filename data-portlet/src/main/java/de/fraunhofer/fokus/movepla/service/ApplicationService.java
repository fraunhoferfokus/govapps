package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationService.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the application remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see ApplicationServiceUtil
 * @see de.fraunhofer.fokus.movepla.service.base.ApplicationServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.impl.ApplicationServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ApplicationService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApplicationServiceUtil} to access the application remote service. Add custom service methods to {@link de.fraunhofer.fokus.movepla.service.impl.ApplicationServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getApplicationsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getApplicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> getNewApplications2(long companyId,
        int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> getNewApplications(long companyId,
        int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> searchApplications(long companyId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    /**
    * search Applications with several aspects: categories, regions, entitlements, costs, platforms,  targetCategory
    *  all aspects are connected by AND
    *  all aspects are internally connected by AND
    *
    * @param co companyId default: (10154)
    * @param ke keywords may be 'null', '', 'searchString', 'two searchStrings', ...
    * @param ca required CategoryIds may be '', '1_2_3', ...
    * @param re required RegionIds may be '', '1_2_3', ...
    * @param ap allowed ApplicationEntitlementIds may be '', '1_2_3_4_5_6', ...
    * @param to required TargetOS may be '', iOS', 'iOS_Android_Windows', ...
    * @param fe required fee may be   0 -> kostenlos, 1 -> kostenpflichtig, else (z.B. 2) : alle
    * @param es  search single entitlement may be   0 -> get all apps with at least this entitlement, else (z.B. 2) : alle
    * @param tc  targetCategory may be   "", "Smartphone", "Tablet" or "Smartphone_Tablet"
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es,
        java.lang.String tc, int od)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    /**
    * search Applications with several aspects: categories, regions, entitlement, costs, platforms
    *  all aspects are connected by AND
    *  all aspects are internally connected by AND
    *
    * @param co companyId default: (10154)
    * @param op boolean operator for different aspects: may be 'AND' or  'OR' ==>  categories AND regions AND ...   ;categories OR regions OR ....
    * @param kop boolean operator for keywords: may be 'AND' or  'OR' ==>  searchString1 AND searchString2 AND ...    ;searchString1 OR searchString2 OR ....
    * @param ke keywords may be 'null', '', 'searchString', 'two searchStrings', ...
    * @param cop boolean operator for categories: may be 'AND' or  'OR' ==>  categoryID1 AND categoryID2 AND ...    ;categoryID1 OR categoryID2 OR ....
    * @param ca CategoryIds may be '', '1_2_3', ...
    * @param rop boolean operator for regions: may be 'AND' or  'OR' ==>  regionID1 AND regionID2 AND ...    ;regionyID1 OR regionID2 OR ....
    * @param re RegionIds may be '', '1_2_3', ...
    * @param ap allowed ApplicationEntitlementIds may be '', '1_2_3_4_5_6', ...
    * @param top boolean operator for TargetOS: may be 'AND' or  'OR' ==>  iOS AND Android AND ...    ;iOS OR Android OR ....
    * @param to required TargetOS may be '', iOS', 'iOS_Android_Windows', ...
    * @param fe required fee may be   0 -> kostenlos, 1 -> kostenpflichtig, else (z.B. 2) : alle
    * @param es  search single entitlement may be   0 -> get all apps with at least this entitlement, else (z.B. 2) : alle
    */
    public java.util.List<java.util.List> complexSearchApplications(long co,
        java.lang.String op, java.lang.String kop, java.lang.String ke,
        java.lang.String cop, java.lang.String ca, java.lang.String rop,
        java.lang.String re, java.lang.String ap, java.lang.String top,
        java.lang.String to, int fe, int es, java.lang.String sop,
        java.lang.String tc)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.util.List> getSimilarApplications(
        long companyId, long applicationId, boolean byCategory, boolean byRegion);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsFromSamePublisher(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getIconURL(long applicationId)
        throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.String> getImageURLs(long applicationId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.String> getExternImageURLs(
        de.fraunhofer.fokus.movepla.model.Application application);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Vector<java.lang.Object> getApplicationDetailsEI(
        long applicationId) throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Vector<java.lang.Object> getApplicationDetailsEIS(
        long applicationId) throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Vector<java.lang.Object> getFullApplicationDetailsEISCRLLA(
        long applicationId) throws java.lang.Exception;

    public void updateStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getLinkDoubles()
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.Long> getRelatedApplications()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void removeWhitespaceFromTargetOS()
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.String> getAllApplicationNames()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void clickApplicationLink(long applicationId);
}
