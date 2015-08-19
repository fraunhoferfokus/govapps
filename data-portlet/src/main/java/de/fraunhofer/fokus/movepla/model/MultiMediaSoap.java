package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: MultiMediaSoap.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is used by SOAP remote services, specifically {@link de.fraunhofer.fokus.movepla.service.http.MultiMediaServiceSoap}.
 *
 * @author    jpa
 * @see       de.fraunhofer.fokus.movepla.service.http.MultiMediaServiceSoap
 * @generated
 */
public class MultiMediaSoap implements Serializable {
    private long _multiMediaId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private int _type;
    private long _imageId;
    private long _applicationId;

    public MultiMediaSoap() {
    }

    public static MultiMediaSoap toSoapModel(MultiMedia model) {
        MultiMediaSoap soapModel = new MultiMediaSoap();

        soapModel.setMultiMediaId(model.getMultiMediaId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setType(model.getType());
        soapModel.setImageId(model.getImageId());
        soapModel.setApplicationId(model.getApplicationId());

        return soapModel;
    }

    public static MultiMediaSoap[] toSoapModels(MultiMedia[] models) {
        MultiMediaSoap[] soapModels = new MultiMediaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MultiMediaSoap[][] toSoapModels(MultiMedia[][] models) {
        MultiMediaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MultiMediaSoap[models.length][models[0].length];
        } else {
            soapModels = new MultiMediaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MultiMediaSoap[] toSoapModels(List<MultiMedia> models) {
        List<MultiMediaSoap> soapModels = new ArrayList<MultiMediaSoap>(models.size());

        for (MultiMedia model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MultiMediaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _multiMediaId;
    }

    public void setPrimaryKey(long pk) {
        setMultiMediaId(pk);
    }

    public long getMultiMediaId() {
        return _multiMediaId;
    }

    public void setMultiMediaId(long multiMediaId) {
        _multiMediaId = multiMediaId;
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

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }

    public long getImageId() {
        return _imageId;
    }

    public void setImageId(long imageId) {
        _imageId = imageId;
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }
}
