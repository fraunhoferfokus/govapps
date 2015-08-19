package de.fraunhofer.fokus.movepla.service.base;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationLocalServiceClpInvoker.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;

import java.util.Arrays;


public class ApplicationLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName106;
    private String[] _methodParameterTypes106;
    private String _methodName107;
    private String[] _methodParameterTypes107;
    private String _methodName108;
    private String[] _methodParameterTypes108;
    private String _methodName109;
    private String[] _methodParameterTypes109;
    private String _methodName110;
    private String[] _methodParameterTypes110;
    private String _methodName111;
    private String[] _methodParameterTypes111;
    private String _methodName112;
    private String[] _methodParameterTypes112;
    private String _methodName113;
    private String[] _methodParameterTypes113;
    private String _methodName114;
    private String[] _methodParameterTypes114;
    private String _methodName115;
    private String[] _methodParameterTypes115;
    private String _methodName116;
    private String[] _methodParameterTypes116;
    private String _methodName117;
    private String[] _methodParameterTypes117;
    private String _methodName118;
    private String[] _methodParameterTypes118;
    private String _methodName119;
    private String[] _methodParameterTypes119;
    private String _methodName120;
    private String[] _methodParameterTypes120;
    private String _methodName121;
    private String[] _methodParameterTypes121;
    private String _methodName122;
    private String[] _methodParameterTypes122;
    private String _methodName123;
    private String[] _methodParameterTypes123;
    private String _methodName126;
    private String[] _methodParameterTypes126;
    private String _methodName128;
    private String[] _methodParameterTypes128;
    private String _methodName129;
    private String[] _methodParameterTypes129;
    private String _methodName130;
    private String[] _methodParameterTypes130;
    private String _methodName131;
    private String[] _methodParameterTypes131;
    private String _methodName132;
    private String[] _methodParameterTypes132;
    private String _methodName133;
    private String[] _methodParameterTypes133;
    private String _methodName134;
    private String[] _methodParameterTypes134;
    private String _methodName135;
    private String[] _methodParameterTypes135;
    private String _methodName136;
    private String[] _methodParameterTypes136;
    private String _methodName137;
    private String[] _methodParameterTypes137;
    private String _methodName138;
    private String[] _methodParameterTypes138;
    private String _methodName139;
    private String[] _methodParameterTypes139;
    private String _methodName140;
    private String[] _methodParameterTypes140;
    private String _methodName141;
    private String[] _methodParameterTypes141;
    private String _methodName142;
    private String[] _methodParameterTypes142;
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;
    private String _methodName146;
    private String[] _methodParameterTypes146;
    private String _methodName147;
    private String[] _methodParameterTypes147;
    private String _methodName151;
    private String[] _methodParameterTypes151;
    private String _methodName152;
    private String[] _methodParameterTypes152;
    private String _methodName153;
    private String[] _methodParameterTypes153;
    private String _methodName154;
    private String[] _methodParameterTypes154;
    private String _methodName155;
    private String[] _methodParameterTypes155;
    private String _methodName156;
    private String[] _methodParameterTypes156;
    private String _methodName157;
    private String[] _methodParameterTypes157;
    private String _methodName158;
    private String[] _methodParameterTypes158;
    private String _methodName159;
    private String[] _methodParameterTypes159;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName162;
    private String[] _methodParameterTypes162;
    private String _methodName163;
    private String[] _methodParameterTypes163;

    public ApplicationLocalServiceClpInvoker() {
        _methodName0 = "addApplication";

        _methodParameterTypes0 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName1 = "createApplication";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteApplication";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteApplication";

        _methodParameterTypes3 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "fetchApplication";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getApplication";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getApplications";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getApplicationsCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateApplication";

        _methodParameterTypes14 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName15 = "updateApplication";

        _methodParameterTypes15 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "boolean"
            };

        _methodName100 = "getBeanIdentifier";

        _methodParameterTypes100 = new String[] {  };

        _methodName101 = "setBeanIdentifier";

        _methodParameterTypes101 = new String[] { "java.lang.String" };

        _methodName106 = "addApplication";

        _methodParameterTypes106 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName107 = "clone";

        _methodParameterTypes107 = new String[] { "long" };

        _methodName108 = "clone4NewVersion";

        _methodParameterTypes108 = new String[] { "long" };

        _methodName109 = "addApplication";

        _methodParameterTypes109 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "java.io.File"
            };

        _methodName110 = "addApplication";

        _methodParameterTypes110 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "java.io.File",
                "java.util.List", "java.util.List", "java.util.List"
            };

        _methodName111 = "addCategories2Application";

        _methodParameterTypes111 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "long[][]"
            };

        _methodName112 = "addCategory2Application";

        _methodParameterTypes112 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "long"
            };

        _methodName113 = "addLanguages2Application";

        _methodParameterTypes113 = new String[] { "long", "long[][]" };

        _methodName114 = "addLanguage2Application";

        _methodParameterTypes114 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "long"
            };

        _methodName115 = "addRegion2Application";

        _methodParameterTypes115 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "long[][]"
            };

        _methodName116 = "addRegionApplication";

        _methodParameterTypes116 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "long"
            };

        _methodName117 = "deleteApplication";

        _methodParameterTypes117 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName118 = "developerDeleteApplication";

        _methodParameterTypes118 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName119 = "developerDeleteApplication";

        _methodParameterTypes119 = new String[] { "long" };

        _methodName120 = "deleteApplication";

        _methodParameterTypes120 = new String[] { "long", "long" };

        _methodName121 = "deleteOldApplication";

        _methodParameterTypes121 = new String[] { "long", "long" };

        _methodName122 = "updateApplication";

        _methodParameterTypes122 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application", "java.io.File"
            };

        _methodName123 = "updateApplicationFileEntry";

        _methodParameterTypes123 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application",
                "com.liferay.portal.kernel.repository.model.FileEntry"
            };

        _methodName126 = "developerUpdateApplicationFileEntry";

        _methodParameterTypes126 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application",
                "com.liferay.portal.kernel.repository.model.FileEntry"
            };

        _methodName128 = "getApplicationsCount";

        _methodParameterTypes128 = new String[] { "long" };

        _methodName129 = "getApplications";

        _methodParameterTypes129 = new String[] { "long" };

        _methodName130 = "getApplications";

        _methodParameterTypes130 = new String[] { "long", "long" };

        _methodName131 = "getApplicationsBycl";

        _methodParameterTypes131 = new String[] { "long", "int" };

        _methodName132 = "getApplications4Verification";

        _methodParameterTypes132 = new String[] { "long" };

        _methodName133 = "getDeveloperApplications";

        _methodParameterTypes133 = new String[] { "long", "long" };

        _methodName134 = "getCategories";

        _methodParameterTypes134 = new String[] { "long" };

        _methodName135 = "getApplicationEntitlements";

        _methodParameterTypes135 = new String[] { "long" };

        _methodName136 = "getLanguages";

        _methodParameterTypes136 = new String[] { "long" };

        _methodName137 = "getLinks";

        _methodParameterTypes137 = new String[] { "long" };

        _methodName138 = "getMultiMedias";

        _methodParameterTypes138 = new String[] { "long" };

        _methodName139 = "getRegions";

        _methodParameterTypes139 = new String[] { "long" };

        _methodName140 = "clearCategories";

        _methodParameterTypes140 = new String[] { "long" };

        _methodName141 = "clearRegions";

        _methodParameterTypes141 = new String[] { "long" };

        _methodName142 = "clearLanguages";

        _methodParameterTypes142 = new String[] { "long" };

        _methodName144 = "getApplicationsAfter";

        _methodParameterTypes144 = new String[] { "int", "java.util.Date" };

        _methodName145 = "getNewApplications";

        _methodParameterTypes145 = new String[] {
                "long", "int", "int", "int", "int"
            };

        _methodName146 = "getApplicationsByCategories";

        _methodParameterTypes146 = new String[] { "java.util.List" };

        _methodName147 = "getApplicationsByRegions";

        _methodParameterTypes147 = new String[] { "java.util.List" };

        _methodName151 = "updateStatusString";

        _methodParameterTypes151 = new String[] { "long" };

        _methodName152 = "removeStatusString";

        _methodParameterTypes152 = new String[] { "long" };

        _methodName153 = "getLinkDoubles";

        _methodParameterTypes153 = new String[] {  };

        _methodName154 = "getRelatedApplications";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "removeWhitespaceFromTargetOS";

        _methodParameterTypes155 = new String[] {  };

        _methodName156 = "getUserEmailAddressByApplication";

        _methodParameterTypes156 = new String[] { "long" };

        _methodName157 = "grantGuestViewPermissions";

        _methodParameterTypes157 = new String[] {  };

        _methodName158 = "getMostViewdApplications";

        _methodParameterTypes158 = new String[] {  };

        _methodName159 = "getMostViewdApplications";

        _methodParameterTypes159 = new String[] { "int" };

        _methodName160 = "getMostViewdApplications";

        _methodParameterTypes160 = new String[] { "int", "int" };

        _methodName161 = "getMostClickedApplications";

        _methodParameterTypes161 = new String[] {  };

        _methodName162 = "getMostClickedApplications";

        _methodParameterTypes162 = new String[] { "int" };

        _methodName163 = "getMostClickedApplications";

        _methodParameterTypes163 = new String[] { "int", "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ApplicationLocalServiceUtil.addApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ApplicationLocalServiceUtil.createApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ApplicationLocalServiceUtil.deleteApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ApplicationLocalServiceUtil.deleteApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ApplicationLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ApplicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ApplicationLocalServiceUtil.fetchApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ApplicationLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ApplicationLocalServiceUtil.updateApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ApplicationLocalServiceUtil.updateApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return ApplicationLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            ApplicationLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return ApplicationLocalServiceUtil.addApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName107.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
            return ApplicationLocalServiceUtil.clone(((Long) arguments[0]).longValue());
        }

        if (_methodName108.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
            return ApplicationLocalServiceUtil.clone4NewVersion(((Long) arguments[0]).longValue());
        }

        if (_methodName109.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
            return ApplicationLocalServiceUtil.addApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (java.io.File) arguments[1]);
        }

        if (_methodName110.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
            return ApplicationLocalServiceUtil.addApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (java.io.File) arguments[1],
                (java.util.List<de.fraunhofer.fokus.movepla.model.Category>) arguments[2],
                (java.util.List<de.fraunhofer.fokus.movepla.model.Language>) arguments[3],
                (java.util.List<de.fraunhofer.fokus.movepla.model.Region>) arguments[4]);
        }

        if (_methodName111.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
            ApplicationLocalServiceUtil.addCategories2Application((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (long[]) arguments[1]);
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            ApplicationLocalServiceUtil.addCategory2Application((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName113.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
            ApplicationLocalServiceUtil.addLanguages2Application(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);
        }

        if (_methodName114.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
            ApplicationLocalServiceUtil.addLanguage2Application((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName115.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
            ApplicationLocalServiceUtil.addRegion2Application((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (long[]) arguments[1]);
        }

        if (_methodName116.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
            ApplicationLocalServiceUtil.addRegionApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName117.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
            return ApplicationLocalServiceUtil.deleteApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName118.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
            ApplicationLocalServiceUtil.developerDeleteApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName119.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
            ApplicationLocalServiceUtil.developerDeleteApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName120.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
            ApplicationLocalServiceUtil.deleteApplication(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName121.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
            ApplicationLocalServiceUtil.deleteOldApplication(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName122.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
            return ApplicationLocalServiceUtil.updateApplication((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (java.io.File) arguments[1]);
        }

        if (_methodName123.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
            return ApplicationLocalServiceUtil.updateApplicationFileEntry((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (com.liferay.portal.kernel.repository.model.FileEntry) arguments[1]);
        }

        if (_methodName126.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
            return ApplicationLocalServiceUtil.developerUpdateApplicationFileEntry((de.fraunhofer.fokus.movepla.model.Application) arguments[0],
                (com.liferay.portal.kernel.repository.model.FileEntry) arguments[1]);
        }

        if (_methodName128.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsCount(((Long) arguments[0]).longValue());
        }

        if (_methodName129.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName130.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName131.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsBycl(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName132.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplications4Verification(((Long) arguments[0]).longValue());
        }

        if (_methodName133.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
            return ApplicationLocalServiceUtil.getDeveloperApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName134.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
            return ApplicationLocalServiceUtil.getCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName135.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationEntitlements(((Long) arguments[0]).longValue());
        }

        if (_methodName136.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
            return ApplicationLocalServiceUtil.getLanguages(((Long) arguments[0]).longValue());
        }

        if (_methodName137.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
            return ApplicationLocalServiceUtil.getLinks(((Long) arguments[0]).longValue());
        }

        if (_methodName138.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMultiMedias(((Long) arguments[0]).longValue());
        }

        if (_methodName139.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
            return ApplicationLocalServiceUtil.getRegions(((Long) arguments[0]).longValue());
        }

        if (_methodName140.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
            ApplicationLocalServiceUtil.clearCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName141.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
            ApplicationLocalServiceUtil.clearRegions(((Long) arguments[0]).longValue());
        }

        if (_methodName142.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
            ApplicationLocalServiceUtil.clearLanguages(((Long) arguments[0]).longValue());
        }

        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsAfter(((Integer) arguments[0]).intValue(),
                (java.util.Date) arguments[1]);
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            return ApplicationLocalServiceUtil.getNewApplications(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName146.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsByCategories((java.util.List<de.fraunhofer.fokus.movepla.model.Category>) arguments[0]);
        }

        if (_methodName147.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
            return ApplicationLocalServiceUtil.getApplicationsByRegions((java.util.List<de.fraunhofer.fokus.movepla.model.Region>) arguments[0]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            ApplicationLocalServiceUtil.updateStatusString(((Long) arguments[0]).longValue());
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            ApplicationLocalServiceUtil.removeStatusString(((Long) arguments[0]).longValue());
        }

        if (_methodName153.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
            return ApplicationLocalServiceUtil.getLinkDoubles();
        }

        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return ApplicationLocalServiceUtil.getRelatedApplications();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            ApplicationLocalServiceUtil.removeWhitespaceFromTargetOS();
        }

        if (_methodName156.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
            return ApplicationLocalServiceUtil.getUserEmailAddressByApplication(((Long) arguments[0]).longValue());
        }

        if (_methodName157.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
            ApplicationLocalServiceUtil.grantGuestViewPermissions();
        }

        if (_methodName158.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostViewdApplications();
        }

        if (_methodName159.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostViewdApplications(((Integer) arguments[0]).intValue());
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostViewdApplications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostClickedApplications();
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostClickedApplications(((Integer) arguments[0]).intValue());
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return ApplicationLocalServiceUtil.getMostClickedApplications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
