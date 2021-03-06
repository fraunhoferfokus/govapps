package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: RelatedApplicationsCacheModel.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.movepla.model.RelatedApplications;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RelatedApplications in entity cache.
 *
 * @author jpa
 * @see RelatedApplications
 * @generated
 */
public class RelatedApplicationsCacheModel implements CacheModel<RelatedApplications>,
    Serializable {
    public long RelatedApplicationsID;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public long applicationId;
    public long applicationId2;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{RelatedApplicationsID=");
        sb.append(RelatedApplicationsID);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", applicationId=");
        sb.append(applicationId);
        sb.append(", applicationId2=");
        sb.append(applicationId2);
        sb.append("}");

        return sb.toString();
    }

    public RelatedApplications toEntityModel() {
        RelatedApplicationsImpl relatedApplicationsImpl = new RelatedApplicationsImpl();

        relatedApplicationsImpl.setRelatedApplicationsID(RelatedApplicationsID);
        relatedApplicationsImpl.setCompanyId(companyId);
        relatedApplicationsImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            relatedApplicationsImpl.setCreateDate(null);
        } else {
            relatedApplicationsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            relatedApplicationsImpl.setModifiedDate(null);
        } else {
            relatedApplicationsImpl.setModifiedDate(new Date(modifiedDate));
        }

        relatedApplicationsImpl.setApplicationId(applicationId);
        relatedApplicationsImpl.setApplicationId2(applicationId2);

        relatedApplicationsImpl.resetOriginalValues();

        return relatedApplicationsImpl;
    }
}
