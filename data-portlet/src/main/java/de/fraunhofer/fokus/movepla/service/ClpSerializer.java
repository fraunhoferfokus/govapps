package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: ClpSerializer.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import de.fraunhofer.fokus.movepla.model.ApplicationClp;
import de.fraunhofer.fokus.movepla.model.Application_EntitlementClp;
import de.fraunhofer.fokus.movepla.model.CategoryClp;
import de.fraunhofer.fokus.movepla.model.EntitlementClp;
import de.fraunhofer.fokus.movepla.model.LanguageClp;
import de.fraunhofer.fokus.movepla.model.LegalDetailsClp;
import de.fraunhofer.fokus.movepla.model.LinkClp;
import de.fraunhofer.fokus.movepla.model.LoggingClp;
import de.fraunhofer.fokus.movepla.model.MultiMediaClp;
import de.fraunhofer.fokus.movepla.model.RegionClp;
import de.fraunhofer.fokus.movepla.model.RelatedApplicationsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "VmAmG-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "VmAmG-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "VmAmG-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ApplicationClp.class.getName())) {
            return translateInputApplication(oldModel);
        }

        if (oldModelClassName.equals(Application_EntitlementClp.class.getName())) {
            return translateInputApplication_Entitlement(oldModel);
        }

        if (oldModelClassName.equals(CategoryClp.class.getName())) {
            return translateInputCategory(oldModel);
        }

        if (oldModelClassName.equals(EntitlementClp.class.getName())) {
            return translateInputEntitlement(oldModel);
        }

        if (oldModelClassName.equals(LanguageClp.class.getName())) {
            return translateInputLanguage(oldModel);
        }

        if (oldModelClassName.equals(LegalDetailsClp.class.getName())) {
            return translateInputLegalDetails(oldModel);
        }

        if (oldModelClassName.equals(LinkClp.class.getName())) {
            return translateInputLink(oldModel);
        }

        if (oldModelClassName.equals(LoggingClp.class.getName())) {
            return translateInputLogging(oldModel);
        }

        if (oldModelClassName.equals(MultiMediaClp.class.getName())) {
            return translateInputMultiMedia(oldModel);
        }

        if (oldModelClassName.equals(RegionClp.class.getName())) {
            return translateInputRegion(oldModel);
        }

        if (oldModelClassName.equals(RelatedApplicationsClp.class.getName())) {
            return translateInputRelatedApplications(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputApplication(BaseModel<?> oldModel) {
        ApplicationClp oldClpModel = (ApplicationClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getApplicationRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputApplication_Entitlement(
        BaseModel<?> oldModel) {
        Application_EntitlementClp oldClpModel = (Application_EntitlementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getApplication_EntitlementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCategory(BaseModel<?> oldModel) {
        CategoryClp oldClpModel = (CategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputEntitlement(BaseModel<?> oldModel) {
        EntitlementClp oldClpModel = (EntitlementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEntitlementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLanguage(BaseModel<?> oldModel) {
        LanguageClp oldClpModel = (LanguageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLanguageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLegalDetails(BaseModel<?> oldModel) {
        LegalDetailsClp oldClpModel = (LegalDetailsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLegalDetailsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLink(BaseModel<?> oldModel) {
        LinkClp oldClpModel = (LinkClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLinkRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLogging(BaseModel<?> oldModel) {
        LoggingClp oldClpModel = (LoggingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLoggingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMultiMedia(BaseModel<?> oldModel) {
        MultiMediaClp oldClpModel = (MultiMediaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMultiMediaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRegion(BaseModel<?> oldModel) {
        RegionClp oldClpModel = (RegionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRegionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRelatedApplications(
        BaseModel<?> oldModel) {
        RelatedApplicationsClp oldClpModel = (RelatedApplicationsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRelatedApplicationsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl")) {
            return translateOutputApplication(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl")) {
            return translateOutputApplication_Entitlement(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.CategoryImpl")) {
            return translateOutputCategory(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.EntitlementImpl")) {
            return translateOutputEntitlement(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.LanguageImpl")) {
            return translateOutputLanguage(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.LegalDetailsImpl")) {
            return translateOutputLegalDetails(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.LinkImpl")) {
            return translateOutputLink(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.LoggingImpl")) {
            return translateOutputLogging(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl")) {
            return translateOutputMultiMedia(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.RegionImpl")) {
            return translateOutputRegion(oldModel);
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.movepla.model.impl.RelatedApplicationsImpl")) {
            return translateOutputRelatedApplications(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchApplicationException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchApplicationException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchApplication_EntitlementException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchCategoryException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchCategoryException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchEntitlementException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchEntitlementException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchLanguageException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchLanguageException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchLegalDetailsException();
        }

        if (className.equals("de.fraunhofer.fokus.movepla.NoSuchLinkException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchLinkException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchLoggingException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchLoggingException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchMultiMediaException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchMultiMediaException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchRegionException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchRegionException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException")) {
            return new de.fraunhofer.fokus.movepla.NoSuchRelatedApplicationsException();
        }

        return throwable;
    }

    public static Object translateOutputApplication(BaseModel<?> oldModel) {
        ApplicationClp newModel = new ApplicationClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setApplicationRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputApplication_Entitlement(
        BaseModel<?> oldModel) {
        Application_EntitlementClp newModel = new Application_EntitlementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setApplication_EntitlementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCategory(BaseModel<?> oldModel) {
        CategoryClp newModel = new CategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCategoryRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputEntitlement(BaseModel<?> oldModel) {
        EntitlementClp newModel = new EntitlementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEntitlementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLanguage(BaseModel<?> oldModel) {
        LanguageClp newModel = new LanguageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLanguageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLegalDetails(BaseModel<?> oldModel) {
        LegalDetailsClp newModel = new LegalDetailsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLegalDetailsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLink(BaseModel<?> oldModel) {
        LinkClp newModel = new LinkClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLinkRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLogging(BaseModel<?> oldModel) {
        LoggingClp newModel = new LoggingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLoggingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMultiMedia(BaseModel<?> oldModel) {
        MultiMediaClp newModel = new MultiMediaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMultiMediaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRegion(BaseModel<?> oldModel) {
        RegionClp newModel = new RegionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRegionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRelatedApplications(
        BaseModel<?> oldModel) {
        RelatedApplicationsClp newModel = new RelatedApplicationsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRelatedApplicationsRemoteModel(oldModel);

        return newModel;
    }
}
