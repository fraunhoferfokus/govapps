package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementSoap.java 566 2014-11-13 15:22:01Z sma $
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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.fraunhofer.fokus.movepla.service.http.Application_EntitlementServiceSoap}.
 *
 * @author    jpa
 * @see       de.fraunhofer.fokus.movepla.service.http.Application_EntitlementServiceSoap
 * @generated
 */
public class Application_EntitlementSoap implements Serializable {
    private long _applicationEntitlementID;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _motivation;
    private long _applicationId;
    private long _entitlementId;

    public Application_EntitlementSoap() {
    }

    public static Application_EntitlementSoap toSoapModel(
        Application_Entitlement model) {
        Application_EntitlementSoap soapModel = new Application_EntitlementSoap();

        soapModel.setApplicationEntitlementID(model.getApplicationEntitlementID());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setMotivation(model.getMotivation());
        soapModel.setApplicationId(model.getApplicationId());
        soapModel.setEntitlementId(model.getEntitlementId());

        return soapModel;
    }

    public static Application_EntitlementSoap[] toSoapModels(
        Application_Entitlement[] models) {
        Application_EntitlementSoap[] soapModels = new Application_EntitlementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static Application_EntitlementSoap[][] toSoapModels(
        Application_Entitlement[][] models) {
        Application_EntitlementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new Application_EntitlementSoap[models.length][models[0].length];
        } else {
            soapModels = new Application_EntitlementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static Application_EntitlementSoap[] toSoapModels(
        List<Application_Entitlement> models) {
        List<Application_EntitlementSoap> soapModels = new ArrayList<Application_EntitlementSoap>(models.size());

        for (Application_Entitlement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new Application_EntitlementSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _applicationEntitlementID;
    }

    public void setPrimaryKey(long pk) {
        setApplicationEntitlementID(pk);
    }

    public long getApplicationEntitlementID() {
        return _applicationEntitlementID;
    }

    public void setApplicationEntitlementID(long applicationEntitlementID) {
        _applicationEntitlementID = applicationEntitlementID;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getMotivation() {
        return _motivation;
    }

    public void setMotivation(String motivation) {
        _motivation = motivation;
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    public long getEntitlementId() {
        return _entitlementId;
    }

    public void setEntitlementId(long entitlementId) {
        _entitlementId = entitlementId;
    }
}
