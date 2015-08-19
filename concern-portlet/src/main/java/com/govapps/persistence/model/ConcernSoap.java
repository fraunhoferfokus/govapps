package com.govapps.persistence.model;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernSoap.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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
 * This class is used by SOAP remote services, specifically {@link com.govapps.persistence.service.http.ConcernServiceSoap}.
 *
 * @author    ekl
 * @see       com.govapps.persistence.service.http.ConcernServiceSoap
 * @generated
 */
public class ConcernSoap implements Serializable {
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _email;
    private String _description;
    private String _platforms;
    private long _concern;
    private String _region;
    private String _category;
    private Date _createDate;
    private long _supports;
    private int _state;

    public ConcernSoap() {
    }

    public static ConcernSoap toSoapModel(Concern model) {
        ConcernSoap soapModel = new ConcernSoap();

        soapModel.setId(model.getId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setName(model.getName());
        soapModel.setEmail(model.getEmail());
        soapModel.setDescription(model.getDescription());
        soapModel.setPlatforms(model.getPlatforms());
        soapModel.setConcern(model.getConcern());
        soapModel.setRegion(model.getRegion());
        soapModel.setCategory(model.getCategory());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setSupports(model.getSupports());
        soapModel.setState(model.getState());

        return soapModel;
    }

    public static ConcernSoap[] toSoapModels(Concern[] models) {
        ConcernSoap[] soapModels = new ConcernSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ConcernSoap[][] toSoapModels(Concern[][] models) {
        ConcernSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ConcernSoap[models.length][models[0].length];
        } else {
            soapModels = new ConcernSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ConcernSoap[] toSoapModels(List<Concern> models) {
        List<ConcernSoap> soapModels = new ArrayList<ConcernSoap>(models.size());

        for (Concern model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ConcernSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getPlatforms() {
        return _platforms;
    }

    public void setPlatforms(String platforms) {
        _platforms = platforms;
    }

    public long getConcern() {
        return _concern;
    }

    public void setConcern(long concern) {
        _concern = concern;
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String region) {
        _region = region;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getSupports() {
        return _supports;
    }

    public void setSupports(long supports) {
        _supports = supports;
    }

    public int getState() {
        return _state;
    }

    public void setState(int state) {
        _state = state;
    }
}
