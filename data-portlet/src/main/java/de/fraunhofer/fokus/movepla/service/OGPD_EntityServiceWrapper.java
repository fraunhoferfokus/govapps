package de.fraunhofer.fokus.movepla.service;

/*
 * #%L
 * govapps_data
 * $Id: OGPD_EntityServiceWrapper.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link OGPD_EntityService}.
 * </p>
 *
 * @author    jpa
 * @see       OGPD_EntityService
 * @generated
 */
public class OGPD_EntityServiceWrapper implements OGPD_EntityService,
    ServiceWrapper<OGPD_EntityService> {
    private OGPD_EntityService _ogpd_EntityService;

    public OGPD_EntityServiceWrapper(OGPD_EntityService ogpd_EntityService) {
        _ogpd_EntityService = ogpd_EntityService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _ogpd_EntityService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ogpd_EntityService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ogpd_EntityService.invokeMethod(name, parameterTypes, arguments);
    }

    public com.liferay.portal.kernel.json.JSONArray getAllEntities() {
        return _ogpd_EntityService.getAllEntities();
    }

    public com.liferay.portal.kernel.json.JSONArray getRegionEntitiesForWidget(
        java.lang.String regionID) {
        return _ogpd_EntityService.getRegionEntitiesForWidget(regionID);
    }

    public com.liferay.portal.kernel.json.JSONArray getRegionEntitiesForWidgetParamFirst(
        java.lang.String regionID, java.lang.String name) {
        return _ogpd_EntityService.getRegionEntitiesForWidgetParamFirst(regionID,
            name);
    }

    public com.liferay.portal.kernel.json.JSONArray getOpenDataEntitiesForWidget() {
        return _ogpd_EntityService.getOpenDataEntitiesForWidget();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public OGPD_EntityService getWrappedOGPD_EntityService() {
        return _ogpd_EntityService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedOGPD_EntityService(
        OGPD_EntityService ogpd_EntityService) {
        _ogpd_EntityService = ogpd_EntityService;
    }

    public OGPD_EntityService getWrappedService() {
        return _ogpd_EntityService;
    }

    public void setWrappedService(OGPD_EntityService ogpd_EntityService) {
        _ogpd_EntityService = ogpd_EntityService;
    }
}
