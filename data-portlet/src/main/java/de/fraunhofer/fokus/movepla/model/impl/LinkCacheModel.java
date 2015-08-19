package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: LinkCacheModel.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Link;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Link in entity cache.
 *
 * @author jpa
 * @see Link
 * @generated
 */
public class LinkCacheModel implements CacheModel<Link>, Serializable {
    public long linkId;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String displayName;
    public int type;
    public String url;
    public long applicationId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{linkId=");
        sb.append(linkId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", displayName=");
        sb.append(displayName);
        sb.append(", type=");
        sb.append(type);
        sb.append(", url=");
        sb.append(url);
        sb.append(", applicationId=");
        sb.append(applicationId);
        sb.append("}");

        return sb.toString();
    }

    public Link toEntityModel() {
        LinkImpl linkImpl = new LinkImpl();

        linkImpl.setLinkId(linkId);
        linkImpl.setCompanyId(companyId);
        linkImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            linkImpl.setCreateDate(null);
        } else {
            linkImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            linkImpl.setModifiedDate(null);
        } else {
            linkImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (displayName == null) {
            linkImpl.setDisplayName(StringPool.BLANK);
        } else {
            linkImpl.setDisplayName(displayName);
        }

        linkImpl.setType(type);

        if (url == null) {
            linkImpl.setUrl(StringPool.BLANK);
        } else {
            linkImpl.setUrl(url);
        }

        linkImpl.setApplicationId(applicationId);

        linkImpl.resetOriginalValues();

        return linkImpl;
    }
}
