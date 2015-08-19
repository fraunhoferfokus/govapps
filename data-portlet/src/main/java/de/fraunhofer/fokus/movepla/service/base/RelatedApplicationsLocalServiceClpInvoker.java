package de.fraunhofer.fokus.movepla.service.base;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsLocalServiceClpInvoker.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalServiceUtil;

import java.util.Arrays;


public class RelatedApplicationsLocalServiceClpInvoker {
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

    public RelatedApplicationsLocalServiceClpInvoker() {
        _methodName0 = "addRelatedApplications";

        _methodParameterTypes0 = new String[] {
                "de.fraunhofer.fokus.movepla.model.RelatedApplications"
            };

        _methodName1 = "createRelatedApplications";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteRelatedApplications";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteRelatedApplications";

        _methodParameterTypes3 = new String[] {
                "de.fraunhofer.fokus.movepla.model.RelatedApplications"
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

        _methodName9 = "fetchRelatedApplications";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getRelatedApplications";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getRelatedApplicationses";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getRelatedApplicationsesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateRelatedApplications";

        _methodParameterTypes14 = new String[] {
                "de.fraunhofer.fokus.movepla.model.RelatedApplications"
            };

        _methodName15 = "updateRelatedApplications";

        _methodParameterTypes15 = new String[] {
                "de.fraunhofer.fokus.movepla.model.RelatedApplications",
                "boolean"
            };

        _methodName100 = "getBeanIdentifier";

        _methodParameterTypes100 = new String[] {  };

        _methodName101 = "setBeanIdentifier";

        _methodParameterTypes101 = new String[] { "java.lang.String" };

        _methodName106 = "createRelatedApplications";

        _methodParameterTypes106 = new String[] { "long", "long" };

        _methodName107 = "createRecursiveRelatedApplications";

        _methodParameterTypes107 = new String[] { "long", "long" };

        _methodName108 = "alreadyAreRelated";

        _methodParameterTypes108 = new String[] { "long", "long" };

        _methodName109 = "getRelAppIds";

        _methodParameterTypes109 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.addRelatedApplications((de.fraunhofer.fokus.movepla.model.RelatedApplications) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.createRelatedApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.deleteRelatedApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.deleteRelatedApplications((de.fraunhofer.fokus.movepla.model.RelatedApplications) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.fetchRelatedApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getRelatedApplications(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getRelatedApplicationses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getRelatedApplicationsesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.updateRelatedApplications((de.fraunhofer.fokus.movepla.model.RelatedApplications) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.updateRelatedApplications((de.fraunhofer.fokus.movepla.model.RelatedApplications) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            RelatedApplicationsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.createRelatedApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName107.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.createRecursiveRelatedApplications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName108.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.alreadyAreRelated(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName109.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
            return RelatedApplicationsLocalServiceUtil.getRelAppIds(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
