package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: EntitlementSoap.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is used by SOAP remote services, specifically {@link de.fraunhofer.fokus.movepla.service.http.EntitlementServiceSoap}.
 *
 * @author    jpa
 * @see       de.fraunhofer.fokus.movepla.service.http.EntitlementServiceSoap
 * @generated
 */
public class EntitlementSoap implements Serializable {
    private long _entitlementId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _entitlementName;
    private String _explanation;
    private String _estimation;

    public EntitlementSoap() {
    }

    public static EntitlementSoap toSoapModel(Entitlement model) {
        EntitlementSoap soapModel = new EntitlementSoap();

        soapModel.setEntitlementId(model.getEntitlementId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setEntitlementName(model.getEntitlementName());
        soapModel.setExplanation(model.getExplanation());
        soapModel.setEstimation(model.getEstimation());

        return soapModel;
    }

    public static EntitlementSoap[] toSoapModels(Entitlement[] models) {
        EntitlementSoap[] soapModels = new EntitlementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EntitlementSoap[][] toSoapModels(Entitlement[][] models) {
        EntitlementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EntitlementSoap[models.length][models[0].length];
        } else {
            soapModels = new EntitlementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EntitlementSoap[] toSoapModels(List<Entitlement> models) {
        List<EntitlementSoap> soapModels = new ArrayList<EntitlementSoap>(models.size());

        for (Entitlement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EntitlementSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _entitlementId;
    }

    public void setPrimaryKey(long pk) {
        setEntitlementId(pk);
    }

    public long getEntitlementId() {
        return _entitlementId;
    }

    public void setEntitlementId(long entitlementId) {
        _entitlementId = entitlementId;
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

    public String getEntitlementName() {
        return _entitlementName;
    }

    public void setEntitlementName(String entitlementName) {
        _entitlementName = entitlementName;
    }

    public String getExplanation() {
        return _explanation;
    }

    public void setExplanation(String explanation) {
        _explanation = explanation;
    }

    public String getEstimation() {
        return _estimation;
    }

    public void setEstimation(String estimation) {
        _estimation = estimation;
    }
}
