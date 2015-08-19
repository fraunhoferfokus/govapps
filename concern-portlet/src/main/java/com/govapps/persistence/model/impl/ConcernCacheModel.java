package com.govapps.persistence.model.impl;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernCacheModel.java 566 2014-11-13 15:22:01Z sma $
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

import com.govapps.persistence.model.Concern;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Concern in entity cache.
 *
 * @author ekl
 * @see Concern
 * @generated
 */
public class ConcernCacheModel implements CacheModel<Concern>, Serializable {
    public long id;
    public long companyId;
    public long groupId;
    public String name;
    public String email;
    public String description;
    public String platforms;
    public long concern;
    public String region;
    public String category;
    public long createDate;
    public long supports;
    public int state;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{id=");
        sb.append(id);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", email=");
        sb.append(email);
        sb.append(", description=");
        sb.append(description);
        sb.append(", platforms=");
        sb.append(platforms);
        sb.append(", concern=");
        sb.append(concern);
        sb.append(", region=");
        sb.append(region);
        sb.append(", category=");
        sb.append(category);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", supports=");
        sb.append(supports);
        sb.append(", state=");
        sb.append(state);
        sb.append("}");

        return sb.toString();
    }

    public Concern toEntityModel() {
        ConcernImpl concernImpl = new ConcernImpl();

        concernImpl.setId(id);
        concernImpl.setCompanyId(companyId);
        concernImpl.setGroupId(groupId);

        if (name == null) {
            concernImpl.setName(StringPool.BLANK);
        } else {
            concernImpl.setName(name);
        }

        if (email == null) {
            concernImpl.setEmail(StringPool.BLANK);
        } else {
            concernImpl.setEmail(email);
        }

        if (description == null) {
            concernImpl.setDescription(StringPool.BLANK);
        } else {
            concernImpl.setDescription(description);
        }

        if (platforms == null) {
            concernImpl.setPlatforms(StringPool.BLANK);
        } else {
            concernImpl.setPlatforms(platforms);
        }

        concernImpl.setConcern(concern);

        if (region == null) {
            concernImpl.setRegion(StringPool.BLANK);
        } else {
            concernImpl.setRegion(region);
        }

        if (category == null) {
            concernImpl.setCategory(StringPool.BLANK);
        } else {
            concernImpl.setCategory(category);
        }

        if (createDate == Long.MIN_VALUE) {
            concernImpl.setCreateDate(null);
        } else {
            concernImpl.setCreateDate(new Date(createDate));
        }

        concernImpl.setSupports(supports);
        concernImpl.setState(state);

        concernImpl.resetOriginalValues();

        return concernImpl;
    }
}
