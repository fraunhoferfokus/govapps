package de.fraunhofer.fokus.movepla.service.http;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationServiceSoap.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link de.fraunhofer.fokus.movepla.model.ApplicationSoap}.
 * If the method in the service utility returns a
 * {@link de.fraunhofer.fokus.movepla.model.Application}, that is translated to a
 * {@link de.fraunhofer.fokus.movepla.model.ApplicationSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    jpa
 * @see       ApplicationServiceHttp
 * @see       de.fraunhofer.fokus.movepla.model.ApplicationSoap
 * @see       de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil
 * @generated
 */
public class ApplicationServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ApplicationServiceSoap.class);

    public static int getApplicationsCount(long companyId)
        throws RemoteException {
        try {
            int returnValue = ApplicationServiceUtil.getApplicationsCount(companyId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getApplicationsCount() throws RemoteException {
        try {
            int returnValue = ApplicationServiceUtil.getApplicationsCount();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.List[] getNewApplications2(long companyId,
        int year, int month, int day, int count) throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.getNewApplications2(companyId,
                    year, month, day, count);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.List[] getNewApplications(long companyId, int year,
        int month, int day, int count) throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.getNewApplications(companyId,
                    year, month, day, count);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static de.fraunhofer.fokus.movepla.model.ApplicationSoap[] getApplications(
        long companyId) throws RemoteException {
        try {
            java.util.List<de.fraunhofer.fokus.movepla.model.Application> returnValue =
                ApplicationServiceUtil.getApplications(companyId);

            return de.fraunhofer.fokus.movepla.model.ApplicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static de.fraunhofer.fokus.movepla.model.ApplicationSoap[] getApplications(
        long companyId, long userId) throws RemoteException {
        try {
            java.util.List<de.fraunhofer.fokus.movepla.model.Application> returnValue =
                ApplicationServiceUtil.getApplications(companyId, userId);

            return de.fraunhofer.fokus.movepla.model.ApplicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.List[] searchApplications(long companyId,
        java.lang.String keywords) throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.searchApplications(companyId,
                    keywords);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

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
    public static java.util.List[] getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es,
        java.lang.String tc, int od) throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.getFullSearchApplications(co,
                    ke, ca, re, ap, to, fe, es, tc, od);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.List[] getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es)
        throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.getFullSearchApplications(co,
                    ke, ca, re, ap, to, fe, es);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

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
    public static java.util.List[] complexSearchApplications(long co,
        java.lang.String op, java.lang.String kop, java.lang.String ke,
        java.lang.String cop, java.lang.String ca, java.lang.String rop,
        java.lang.String re, java.lang.String ap, java.lang.String top,
        java.lang.String to, int fe, int es, java.lang.String sop,
        java.lang.String tc) throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.complexSearchApplications(co,
                    op, kop, ke, cop, ca, rop, re, ap, top, to, fe, es, sop, tc);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.List[] getSimilarApplications(long companyId,
        long applicationId, boolean byCategory, boolean byRegion)
        throws RemoteException {
        try {
            java.util.List<java.util.List> returnValue = ApplicationServiceUtil.getSimilarApplications(companyId,
                    applicationId, byCategory, byRegion);

            return returnValue.toArray(new java.util.List[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static de.fraunhofer.fokus.movepla.model.ApplicationSoap[] getApplicationsFromSamePublisher(
        long companyId, long userId) throws RemoteException {
        try {
            java.util.List<de.fraunhofer.fokus.movepla.model.Application> returnValue =
                ApplicationServiceUtil.getApplicationsFromSamePublisher(companyId,
                    userId);

            return de.fraunhofer.fokus.movepla.model.ApplicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getIconURL(long applicationId)
        throws RemoteException {
        try {
            java.lang.String returnValue = ApplicationServiceUtil.getIconURL(applicationId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String[] getImageURLs(long applicationId)
        throws RemoteException {
        try {
            java.util.List<java.lang.String> returnValue = ApplicationServiceUtil.getImageURLs(applicationId);

            return returnValue.toArray(new java.lang.String[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String[] getExternImageURLs(
        de.fraunhofer.fokus.movepla.model.ApplicationSoap application)
        throws RemoteException {
        try {
            java.util.List<java.lang.String> returnValue = ApplicationServiceUtil.getExternImageURLs(de.fraunhofer.fokus.movepla.model.impl.ApplicationModelImpl.toModel(
                        application));

            return returnValue.toArray(new java.lang.String[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.Vector<java.lang.Object> getApplicationDetailsEI(
        long applicationId) throws RemoteException {
        try {
            java.util.Vector<java.lang.Object> returnValue = ApplicationServiceUtil.getApplicationDetailsEI(applicationId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.Vector<java.lang.Object> getApplicationDetailsEIS(
        long applicationId) throws RemoteException {
        try {
            java.util.Vector<java.lang.Object> returnValue = ApplicationServiceUtil.getApplicationDetailsEIS(applicationId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.Vector<java.lang.Object> getFullApplicationDetailsEISCRLLA(
        long applicationId) throws RemoteException {
        try {
            java.util.Vector<java.lang.Object> returnValue = ApplicationServiceUtil.getFullApplicationDetailsEISCRLLA(applicationId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void updateStatusString(long companyId)
        throws RemoteException {
        try {
            ApplicationServiceUtil.updateStatusString(companyId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static de.fraunhofer.fokus.movepla.model.ApplicationSoap[] getLinkDoubles()
        throws RemoteException {
        try {
            java.util.List<de.fraunhofer.fokus.movepla.model.Application> returnValue =
                ApplicationServiceUtil.getLinkDoubles();

            return de.fraunhofer.fokus.movepla.model.ApplicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.Long[] getRelatedApplications()
        throws RemoteException {
        try {
            java.util.List<java.lang.Long> returnValue = ApplicationServiceUtil.getRelatedApplications();

            return returnValue.toArray(new java.lang.Long[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void removeWhitespaceFromTargetOS() throws RemoteException {
        try {
            ApplicationServiceUtil.removeWhitespaceFromTargetOS();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String[] getAllApplicationNames()
        throws RemoteException {
        try {
            java.util.List<java.lang.String> returnValue = ApplicationServiceUtil.getAllApplicationNames();

            return returnValue.toArray(new java.lang.String[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void clickApplicationLink(long applicationId)
        throws RemoteException {
        try {
            ApplicationServiceUtil.clickApplicationLink(applicationId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
