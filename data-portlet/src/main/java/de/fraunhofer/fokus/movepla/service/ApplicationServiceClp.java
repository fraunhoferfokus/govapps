package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationServiceClp.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.service.InvokableService;


public class ApplicationServiceClp implements ApplicationService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;

    public ApplicationServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getApplicationsCount";

        _methodParameterTypes3 = new String[] { "long" };

        _methodName4 = "getApplicationsCount";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "getNewApplications2";

        _methodParameterTypes5 = new String[] { "long", "int", "int", "int", "int" };

        _methodName6 = "getNewApplications";

        _methodParameterTypes6 = new String[] { "long", "int", "int", "int", "int" };

        _methodName7 = "getApplications";

        _methodParameterTypes7 = new String[] { "long" };

        _methodName8 = "getApplications";

        _methodParameterTypes8 = new String[] { "long", "long" };

        _methodName9 = "searchApplications";

        _methodParameterTypes9 = new String[] { "long", "java.lang.String" };

        _methodName10 = "getFullSearchApplications";

        _methodParameterTypes10 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "int", "int", "java.lang.String", "int"
            };

        _methodName11 = "getFullSearchApplications";

        _methodParameterTypes11 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "int", "int"
            };

        _methodName12 = "complexSearchApplications";

        _methodParameterTypes12 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "int", "int",
                "java.lang.String", "java.lang.String"
            };

        _methodName13 = "getSimilarApplications";

        _methodParameterTypes13 = new String[] {
                "long", "long", "boolean", "boolean"
            };

        _methodName14 = "getApplicationsFromSamePublisher";

        _methodParameterTypes14 = new String[] { "long", "long" };

        _methodName15 = "getIconURL";

        _methodParameterTypes15 = new String[] { "long" };

        _methodName16 = "getImageURLs";

        _methodParameterTypes16 = new String[] { "long" };

        _methodName17 = "getExternImageURLs";

        _methodParameterTypes17 = new String[] {
                "de.fraunhofer.fokus.movepla.model.Application"
            };

        _methodName18 = "getApplicationDetailsEI";

        _methodParameterTypes18 = new String[] { "long" };

        _methodName19 = "getApplicationDetailsEIS";

        _methodParameterTypes19 = new String[] { "long" };

        _methodName20 = "getFullApplicationDetailsEISCRLLA";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "updateStatusString";

        _methodParameterTypes21 = new String[] { "long" };

        _methodName22 = "getLinkDoubles";

        _methodParameterTypes22 = new String[] {  };

        _methodName23 = "getRelatedApplications";

        _methodParameterTypes23 = new String[] {  };

        _methodName24 = "removeWhitespaceFromTargetOS";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "getAllApplicationNames";

        _methodParameterTypes25 = new String[] {  };

        _methodName26 = "clickApplicationLink";

        _methodParameterTypes26 = new String[] { "long" };
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    public int getApplicationsCount(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public int getApplicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public java.util.List<java.util.List> getNewApplications2(long companyId,
        int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { companyId, year, month, day, count });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> getNewApplications(long companyId,
        int year, int month, int day, int count)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] { companyId, year, month, day, count });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.movepla.model.Application>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplications(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8, new Object[] { companyId, userId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.movepla.model.Application>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> searchApplications(long companyId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        companyId,
                        
                    ClpSerializer.translateInput(keywords)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es,
        java.lang.String tc, int od)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] {
                        co,
                        
                    ClpSerializer.translateInput(ke),
                        
                    ClpSerializer.translateInput(ca),
                        
                    ClpSerializer.translateInput(re),
                        
                    ClpSerializer.translateInput(ap),
                        
                    ClpSerializer.translateInput(to),
                        
                    fe,
                        
                    es,
                        
                    ClpSerializer.translateInput(tc),
                        
                    od
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> getFullSearchApplications(long co,
        java.lang.String ke, java.lang.String ca, java.lang.String re,
        java.lang.String ap, java.lang.String to, int fe, int es)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] {
                        co,
                        
                    ClpSerializer.translateInput(ke),
                        
                    ClpSerializer.translateInput(ca),
                        
                    ClpSerializer.translateInput(re),
                        
                    ClpSerializer.translateInput(ap),
                        
                    ClpSerializer.translateInput(to),
                        
                    fe,
                        
                    es
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> complexSearchApplications(long co,
        java.lang.String op, java.lang.String kop, java.lang.String ke,
        java.lang.String cop, java.lang.String ca, java.lang.String rop,
        java.lang.String re, java.lang.String ap, java.lang.String top,
        java.lang.String to, int fe, int es, java.lang.String sop,
        java.lang.String tc)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] {
                        co,
                        
                    ClpSerializer.translateInput(op),
                        
                    ClpSerializer.translateInput(kop),
                        
                    ClpSerializer.translateInput(ke),
                        
                    ClpSerializer.translateInput(cop),
                        
                    ClpSerializer.translateInput(ca),
                        
                    ClpSerializer.translateInput(rop),
                        
                    ClpSerializer.translateInput(re),
                        
                    ClpSerializer.translateInput(ap),
                        
                    ClpSerializer.translateInput(top),
                        
                    ClpSerializer.translateInput(to),
                        
                    fe,
                        
                    es,
                        
                    ClpSerializer.translateInput(sop),
                        
                    ClpSerializer.translateInput(tc)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.util.List> getSimilarApplications(
        long companyId, long applicationId, boolean byCategory, boolean byRegion) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] { companyId, applicationId, byCategory, byRegion });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.util.List>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getApplicationsFromSamePublisher(
        long companyId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName14,
                    _methodParameterTypes14, new Object[] { companyId, userId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.movepla.model.Application>) ClpSerializer.translateOutput(returnObj);
    }

    public java.lang.String getIconURL(long applicationId)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName15,
                    _methodParameterTypes15, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.lang.String> getImageURLs(long applicationId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName16,
                    _methodParameterTypes16, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.String>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.lang.String> getExternImageURLs(
        de.fraunhofer.fokus.movepla.model.Application application) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName17,
                    _methodParameterTypes17,
                    new Object[] { ClpSerializer.translateInput(application) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.String>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.Vector<java.lang.Object> getApplicationDetailsEI(
        long applicationId) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName18,
                    _methodParameterTypes18, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Vector<java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.Vector<java.lang.Object> getApplicationDetailsEIS(
        long applicationId) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName19,
                    _methodParameterTypes19, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Vector<java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.Vector<java.lang.Object> getFullApplicationDetailsEISCRLLA(
        long applicationId) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName20,
                    _methodParameterTypes20, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Vector<java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    public void updateStatusString(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName21,
                _methodParameterTypes21, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<de.fraunhofer.fokus.movepla.model.Application> getLinkDoubles()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName22,
                    _methodParameterTypes22, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.movepla.model.Application>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<java.lang.Long> getRelatedApplications()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName23,
                    _methodParameterTypes23, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.Long>) ClpSerializer.translateOutput(returnObj);
    }

    public void removeWhitespaceFromTargetOS()
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName24,
                _methodParameterTypes24, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<java.lang.String> getAllApplicationNames()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName25,
                    _methodParameterTypes25, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.String>) ClpSerializer.translateOutput(returnObj);
    }

    public void clickApplicationLink(long applicationId) {
        try {
            _invokableService.invokeMethod(_methodName26,
                _methodParameterTypes26, new Object[] { applicationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
