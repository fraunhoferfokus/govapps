package de.fraunhofer.fokus.movepla.service.base;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationServiceClpInvoker.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil;

import java.util.Arrays;


public class ApplicationServiceClpInvoker {
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName90;
    private String[] _methodParameterTypes90;
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;
    private String _methodName94;
    private String[] _methodParameterTypes94;
    private String _methodName95;
    private String[] _methodParameterTypes95;
    private String _methodName96;
    private String[] _methodParameterTypes96;
    private String _methodName97;
    private String[] _methodParameterTypes97;
    private String _methodName98;
    private String[] _methodParameterTypes98;
    private String _methodName110;
    private String[] _methodParameterTypes110;
    private String _methodName111;
    private String[] _methodParameterTypes111;
    private String _methodName112;
    private String[] _methodParameterTypes112;
    private String _methodName113;
    private String[] _methodParameterTypes113;
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
    private String _methodName122;
    private String[] _methodParameterTypes122;
    private String _methodName123;
    private String[] _methodParameterTypes123;
    private String _methodName124;
    private String[] _methodParameterTypes124;
    private String _methodName125;
    private String[] _methodParameterTypes125;
    private String _methodName126;
    private String[] _methodParameterTypes126;
    private String _methodName127;
    private String[] _methodParameterTypes127;

    public ApplicationServiceClpInvoker() {
        _methodName84 = "getBeanIdentifier";

        _methodParameterTypes84 = new String[] {  };

        _methodName85 = "setBeanIdentifier";

        _methodParameterTypes85 = new String[] { "java.lang.String" };

        _methodName90 = "getApplicationsCount";

        _methodParameterTypes90 = new String[] { "long" };

        _methodName91 = "getApplicationsCount";

        _methodParameterTypes91 = new String[] {  };

        _methodName92 = "getNewApplications2";

        _methodParameterTypes92 = new String[] {
                "long", "int", "int", "int", "int"
            };

        _methodName93 = "getNewApplications";

        _methodParameterTypes93 = new String[] {
                "long", "int", "int", "int", "int"
            };

        _methodName94 = "getApplications";

        _methodParameterTypes94 = new String[] { "long" };

        _methodName95 = "getApplications";

        _methodParameterTypes95 = new String[] { "long", "long" };

        _methodName96 = "searchApplications";

        _methodParameterTypes96 = new String[] { "long", "java.lang.String" };

        _methodName97 = "getFullSearchApplications";

        _methodParameterTypes97 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "int", "int", "java.lang.String", "int"
            };

        _methodName98 = "getFullSearchApplications";

        _methodParameterTypes98 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "int", "int"
            };

        _methodName110 = "complexSearchApplications";

        _methodParameterTypes110 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "int", "int",
                "java.lang.String", "java.lang.String"
            };

        _methodName111 = "getSimilarApplications";

        _methodParameterTypes111 = new String[] {
                "long", "long", "boolean", "boolean"
            };

        _methodName112 = "getApplicationsFromSamePublisher";

        _methodParameterTypes112 = new String[] { "long", "long" };

        _methodName113 = "getIconURL";

        _methodParameterTypes113 = new String[] { "long" };

        _methodName115 = "getImageURLs";

        _methodParameterTypes115 = new String[] { "long" };

        _methodName116 = "getExternImageURLs";

        _methodParameterTypes116 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName117 = "getApplicationDetailsEI";

        _methodParameterTypes117 = new String[] { "long" };

        _methodName118 = "getApplicationDetailsEIS";

        _methodParameterTypes118 = new String[] { "long" };

        _methodName119 = "getFullApplicationDetailsEISCRLLA";

        _methodParameterTypes119 = new String[] { "long" };

        _methodName122 = "updateStatusString";

        _methodParameterTypes122 = new String[] { "long" };

        _methodName123 = "getLinkDoubles";

        _methodParameterTypes123 = new String[] {  };

        _methodName124 = "getRelatedApplications";

        _methodParameterTypes124 = new String[] {  };

        _methodName125 = "removeWhitespaceFromTargetOS";

        _methodParameterTypes125 = new String[] {  };

        _methodName126 = "getAllApplicationNames";

        _methodParameterTypes126 = new String[] {  };

        _methodName127 = "clickApplicationLink";

        _methodParameterTypes127 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return ApplicationServiceUtil.getBeanIdentifier();
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            ApplicationServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return ApplicationServiceUtil.getApplicationsCount(((Long) arguments[0]).longValue());
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            return ApplicationServiceUtil.getApplicationsCount();
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            return ApplicationServiceUtil.getNewApplications2(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            return ApplicationServiceUtil.getNewApplications(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName94.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
            return ApplicationServiceUtil.getApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName95.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
            return ApplicationServiceUtil.getApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName96.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
            return ApplicationServiceUtil.searchApplications(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName97.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
            return ApplicationServiceUtil.getFullSearchApplications(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Integer) arguments[6]).intValue(),
                ((Integer) arguments[7]).intValue(),
                (java.lang.String) arguments[8],
                ((Integer) arguments[9]).intValue());
        }

        if (_methodName98.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
            return ApplicationServiceUtil.getFullSearchApplications(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Integer) arguments[6]).intValue(),
                ((Integer) arguments[7]).intValue());
        }

        if (_methodName110.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
            return ApplicationServiceUtil.complexSearchApplications(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                (java.lang.String) arguments[10],
                ((Integer) arguments[11]).intValue(),
                ((Integer) arguments[12]).intValue(),
                (java.lang.String) arguments[13],
                (java.lang.String) arguments[14]);
        }

        if (_methodName111.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
            return ApplicationServiceUtil.getSimilarApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Boolean) arguments[2]).booleanValue(),
                ((Boolean) arguments[3]).booleanValue());
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            return ApplicationServiceUtil.getApplicationsFromSamePublisher(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName113.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
            return ApplicationServiceUtil.getIconURL(((Long) arguments[0]).longValue());
        }

        if (_methodName115.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
            return ApplicationServiceUtil.getImageURLs(((Long) arguments[0]).longValue());
        }

        if (_methodName116.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
            return ApplicationServiceUtil.getExternImageURLs((de.fraunhofer.fokus.movepla.model.Application) arguments[0]);
        }

        if (_methodName117.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
            return ApplicationServiceUtil.getApplicationDetailsEI(((Long) arguments[0]).longValue());
        }

        if (_methodName118.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
            return ApplicationServiceUtil.getApplicationDetailsEIS(((Long) arguments[0]).longValue());
        }

        if (_methodName119.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
            return ApplicationServiceUtil.getFullApplicationDetailsEISCRLLA(((Long) arguments[0]).longValue());
        }

        if (_methodName122.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
            ApplicationServiceUtil.updateStatusString(((Long) arguments[0]).longValue());
        }

        if (_methodName123.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
            return ApplicationServiceUtil.getLinkDoubles();
        }

        if (_methodName124.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
            return ApplicationServiceUtil.getRelatedApplications();
        }

        if (_methodName125.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
            ApplicationServiceUtil.removeWhitespaceFromTargetOS();
        }

        if (_methodName126.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
            return ApplicationServiceUtil.getAllApplicationNames();
        }

        if (_methodName127.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
            ApplicationServiceUtil.clickApplicationLink(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
