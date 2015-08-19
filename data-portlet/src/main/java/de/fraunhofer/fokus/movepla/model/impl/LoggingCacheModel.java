package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: LoggingCacheModel.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Logging;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Logging in entity cache.
 *
 * @author jpa
 * @see Logging
 * @generated
 */
public class LoggingCacheModel implements CacheModel<Logging>, Serializable {
    public long loggingId;
    public long createDate;
    public long modifiedDate;
    public Boolean isSimpleSearch;
    public String searchString;
    public String categoryIDString;
    public String regionIDString;
    public String entitlementIDString;
    public String targetOS;
    public int fee;
    public String targetCategory;
    public long passel;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{loggingId=");
        sb.append(loggingId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", isSimpleSearch=");
        sb.append(isSimpleSearch);
        sb.append(", searchString=");
        sb.append(searchString);
        sb.append(", categoryIDString=");
        sb.append(categoryIDString);
        sb.append(", regionIDString=");
        sb.append(regionIDString);
        sb.append(", entitlementIDString=");
        sb.append(entitlementIDString);
        sb.append(", targetOS=");
        sb.append(targetOS);
        sb.append(", fee=");
        sb.append(fee);
        sb.append(", targetCategory=");
        sb.append(targetCategory);
        sb.append(", passel=");
        sb.append(passel);
        sb.append("}");

        return sb.toString();
    }

    public Logging toEntityModel() {
        LoggingImpl loggingImpl = new LoggingImpl();

        loggingImpl.setLoggingId(loggingId);

        if (createDate == Long.MIN_VALUE) {
            loggingImpl.setCreateDate(null);
        } else {
            loggingImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            loggingImpl.setModifiedDate(null);
        } else {
            loggingImpl.setModifiedDate(new Date(modifiedDate));
        }

        loggingImpl.setIsSimpleSearch(isSimpleSearch);

        if (searchString == null) {
            loggingImpl.setSearchString(StringPool.BLANK);
        } else {
            loggingImpl.setSearchString(searchString);
        }

        if (categoryIDString == null) {
            loggingImpl.setCategoryIDString(StringPool.BLANK);
        } else {
            loggingImpl.setCategoryIDString(categoryIDString);
        }

        if (regionIDString == null) {
            loggingImpl.setRegionIDString(StringPool.BLANK);
        } else {
            loggingImpl.setRegionIDString(regionIDString);
        }

        if (entitlementIDString == null) {
            loggingImpl.setEntitlementIDString(StringPool.BLANK);
        } else {
            loggingImpl.setEntitlementIDString(entitlementIDString);
        }

        if (targetOS == null) {
            loggingImpl.setTargetOS(StringPool.BLANK);
        } else {
            loggingImpl.setTargetOS(targetOS);
        }

        loggingImpl.setFee(fee);

        if (targetCategory == null) {
            loggingImpl.setTargetCategory(StringPool.BLANK);
        } else {
            loggingImpl.setTargetCategory(targetCategory);
        }

        loggingImpl.setPassel(passel);

        loggingImpl.resetOriginalValues();

        return loggingImpl;
    }
}
