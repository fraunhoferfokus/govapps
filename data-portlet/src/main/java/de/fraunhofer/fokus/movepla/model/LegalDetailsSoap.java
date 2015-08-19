package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsSoap.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is used by SOAP remote services, specifically {@link de.fraunhofer.fokus.movepla.service.http.LegalDetailsServiceSoap}.
 *
 * @author    jpa
 * @see       de.fraunhofer.fokus.movepla.service.http.LegalDetailsServiceSoap
 * @generated
 */
public class LegalDetailsSoap implements Serializable {
    private long _legalDetailsId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _valueAddedTaxNo;
    private String _registrationCourt;
    private String _legalForm;
    private String _address;
    private String _telephone;
    private String _email;
    private String _URL;
    private String _fax;

    public LegalDetailsSoap() {
    }

    public static LegalDetailsSoap toSoapModel(LegalDetails model) {
        LegalDetailsSoap soapModel = new LegalDetailsSoap();

        soapModel.setLegalDetailsId(model.getLegalDetailsId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setValueAddedTaxNo(model.getValueAddedTaxNo());
        soapModel.setRegistrationCourt(model.getRegistrationCourt());
        soapModel.setLegalForm(model.getLegalForm());
        soapModel.setAddress(model.getAddress());
        soapModel.setTelephone(model.getTelephone());
        soapModel.setEmail(model.getEmail());
        soapModel.setURL(model.getURL());
        soapModel.setFax(model.getFax());

        return soapModel;
    }

    public static LegalDetailsSoap[] toSoapModels(LegalDetails[] models) {
        LegalDetailsSoap[] soapModels = new LegalDetailsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LegalDetailsSoap[][] toSoapModels(LegalDetails[][] models) {
        LegalDetailsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LegalDetailsSoap[models.length][models[0].length];
        } else {
            soapModels = new LegalDetailsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LegalDetailsSoap[] toSoapModels(List<LegalDetails> models) {
        List<LegalDetailsSoap> soapModels = new ArrayList<LegalDetailsSoap>(models.size());

        for (LegalDetails model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LegalDetailsSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _legalDetailsId;
    }

    public void setPrimaryKey(long pk) {
        setLegalDetailsId(pk);
    }

    public long getLegalDetailsId() {
        return _legalDetailsId;
    }

    public void setLegalDetailsId(long legalDetailsId) {
        _legalDetailsId = legalDetailsId;
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

    public String getValueAddedTaxNo() {
        return _valueAddedTaxNo;
    }

    public void setValueAddedTaxNo(String valueAddedTaxNo) {
        _valueAddedTaxNo = valueAddedTaxNo;
    }

    public String getRegistrationCourt() {
        return _registrationCourt;
    }

    public void setRegistrationCourt(String registrationCourt) {
        _registrationCourt = registrationCourt;
    }

    public String getLegalForm() {
        return _legalForm;
    }

    public void setLegalForm(String legalForm) {
        _legalForm = legalForm;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getURL() {
        return _URL;
    }

    public void setURL(String URL) {
        _URL = URL;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }
}
