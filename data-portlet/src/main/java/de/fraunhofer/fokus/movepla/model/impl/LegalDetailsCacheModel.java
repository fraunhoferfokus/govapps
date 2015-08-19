package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsCacheModel.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.movepla.model.LegalDetails;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LegalDetails in entity cache.
 *
 * @author jpa
 * @see LegalDetails
 * @generated
 */
public class LegalDetailsCacheModel implements CacheModel<LegalDetails>,
    Serializable {
    public long legalDetailsId;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String valueAddedTaxNo;
    public String registrationCourt;
    public String legalForm;
    public String address;
    public String telephone;
    public String email;
    public String URL;
    public String fax;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{legalDetailsId=");
        sb.append(legalDetailsId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", valueAddedTaxNo=");
        sb.append(valueAddedTaxNo);
        sb.append(", registrationCourt=");
        sb.append(registrationCourt);
        sb.append(", legalForm=");
        sb.append(legalForm);
        sb.append(", address=");
        sb.append(address);
        sb.append(", telephone=");
        sb.append(telephone);
        sb.append(", email=");
        sb.append(email);
        sb.append(", URL=");
        sb.append(URL);
        sb.append(", fax=");
        sb.append(fax);
        sb.append("}");

        return sb.toString();
    }

    public LegalDetails toEntityModel() {
        LegalDetailsImpl legalDetailsImpl = new LegalDetailsImpl();

        legalDetailsImpl.setLegalDetailsId(legalDetailsId);
        legalDetailsImpl.setCompanyId(companyId);
        legalDetailsImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            legalDetailsImpl.setCreateDate(null);
        } else {
            legalDetailsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            legalDetailsImpl.setModifiedDate(null);
        } else {
            legalDetailsImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            legalDetailsImpl.setName(StringPool.BLANK);
        } else {
            legalDetailsImpl.setName(name);
        }

        if (valueAddedTaxNo == null) {
            legalDetailsImpl.setValueAddedTaxNo(StringPool.BLANK);
        } else {
            legalDetailsImpl.setValueAddedTaxNo(valueAddedTaxNo);
        }

        if (registrationCourt == null) {
            legalDetailsImpl.setRegistrationCourt(StringPool.BLANK);
        } else {
            legalDetailsImpl.setRegistrationCourt(registrationCourt);
        }

        if (legalForm == null) {
            legalDetailsImpl.setLegalForm(StringPool.BLANK);
        } else {
            legalDetailsImpl.setLegalForm(legalForm);
        }

        if (address == null) {
            legalDetailsImpl.setAddress(StringPool.BLANK);
        } else {
            legalDetailsImpl.setAddress(address);
        }

        if (telephone == null) {
            legalDetailsImpl.setTelephone(StringPool.BLANK);
        } else {
            legalDetailsImpl.setTelephone(telephone);
        }

        if (email == null) {
            legalDetailsImpl.setEmail(StringPool.BLANK);
        } else {
            legalDetailsImpl.setEmail(email);
        }

        if (URL == null) {
            legalDetailsImpl.setURL(StringPool.BLANK);
        } else {
            legalDetailsImpl.setURL(URL);
        }

        if (fax == null) {
            legalDetailsImpl.setFax(StringPool.BLANK);
        } else {
            legalDetailsImpl.setFax(fax);
        }

        legalDetailsImpl.resetOriginalValues();

        return legalDetailsImpl;
    }
}
