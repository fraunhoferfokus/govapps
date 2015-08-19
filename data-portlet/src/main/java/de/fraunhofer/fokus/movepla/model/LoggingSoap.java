package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LoggingSoap.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is used by SOAP remote services.
 *
 * @author    jpa
 * @generated
 */
public class LoggingSoap implements Serializable {
    private long _loggingId;
    private Date _createDate;
    private Date _modifiedDate;
    private Boolean _isSimpleSearch;
    private String _searchString;
    private String _categoryIDString;
    private String _regionIDString;
    private String _entitlementIDString;
    private String _targetOS;
    private int _fee;
    private String _targetCategory;
    private long _passel;

    public LoggingSoap() {
    }

    public static LoggingSoap toSoapModel(Logging model) {
        LoggingSoap soapModel = new LoggingSoap();

        soapModel.setLoggingId(model.getLoggingId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setIsSimpleSearch(model.getIsSimpleSearch());
        soapModel.setSearchString(model.getSearchString());
        soapModel.setCategoryIDString(model.getCategoryIDString());
        soapModel.setRegionIDString(model.getRegionIDString());
        soapModel.setEntitlementIDString(model.getEntitlementIDString());
        soapModel.setTargetOS(model.getTargetOS());
        soapModel.setFee(model.getFee());
        soapModel.setTargetCategory(model.getTargetCategory());
        soapModel.setPassel(model.getPassel());

        return soapModel;
    }

    public static LoggingSoap[] toSoapModels(Logging[] models) {
        LoggingSoap[] soapModels = new LoggingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LoggingSoap[][] toSoapModels(Logging[][] models) {
        LoggingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LoggingSoap[models.length][models[0].length];
        } else {
            soapModels = new LoggingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LoggingSoap[] toSoapModels(List<Logging> models) {
        List<LoggingSoap> soapModels = new ArrayList<LoggingSoap>(models.size());

        for (Logging model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoggingSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _loggingId;
    }

    public void setPrimaryKey(long pk) {
        setLoggingId(pk);
    }

    public long getLoggingId() {
        return _loggingId;
    }

    public void setLoggingId(long loggingId) {
        _loggingId = loggingId;
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

    public Boolean getIsSimpleSearch() {
        return _isSimpleSearch;
    }

    public void setIsSimpleSearch(Boolean isSimpleSearch) {
        _isSimpleSearch = isSimpleSearch;
    }

    public String getSearchString() {
        return _searchString;
    }

    public void setSearchString(String searchString) {
        _searchString = searchString;
    }

    public String getCategoryIDString() {
        return _categoryIDString;
    }

    public void setCategoryIDString(String categoryIDString) {
        _categoryIDString = categoryIDString;
    }

    public String getRegionIDString() {
        return _regionIDString;
    }

    public void setRegionIDString(String regionIDString) {
        _regionIDString = regionIDString;
    }

    public String getEntitlementIDString() {
        return _entitlementIDString;
    }

    public void setEntitlementIDString(String entitlementIDString) {
        _entitlementIDString = entitlementIDString;
    }

    public String getTargetOS() {
        return _targetOS;
    }

    public void setTargetOS(String targetOS) {
        _targetOS = targetOS;
    }

    public int getFee() {
        return _fee;
    }

    public void setFee(int fee) {
        _fee = fee;
    }

    public String getTargetCategory() {
        return _targetCategory;
    }

    public void setTargetCategory(String targetCategory) {
        _targetCategory = targetCategory;
    }

    public long getPassel() {
        return _passel;
    }

    public void setPassel(long passel) {
        _passel = passel;
    }
}
