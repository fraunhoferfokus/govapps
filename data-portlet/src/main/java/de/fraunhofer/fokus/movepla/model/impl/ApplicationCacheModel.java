package de.fraunhofer.fokus.movepla.model.impl;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationCacheModel.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Application;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Application in entity cache.
 *
 * @author jpa
 * @see Application
 * @generated
 */
public class ApplicationCacheModel implements CacheModel<Application>,
    Serializable {
    public long applicationId;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public String version;
    public String versionInformation;
    public int size;
    public long firstPublishingDate;
    public long lastModifiedDate;
    public long logoImageId;
    public int fee;
    public String targetOS;
    public int minTargetOSVersion;
    public String targetCategory;
    public int lifeCycleStatus;
    public long verifiedDate;
    public String categoryString;
    public String regionString;
    public String lifeCycleStatusString;
    public String legalDetails;
    public String developer;
    public long detailsViewed;
    public long linkClicked;
    public int useOpenData;
    public String Sector;
    public String License;
    public String relatedApplicationId;
    public long newVersionId;
    public long oldVersionId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(65);

        sb.append("{applicationId=");
        sb.append(applicationId);
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
        sb.append(", description=");
        sb.append(description);
        sb.append(", version=");
        sb.append(version);
        sb.append(", versionInformation=");
        sb.append(versionInformation);
        sb.append(", size=");
        sb.append(size);
        sb.append(", firstPublishingDate=");
        sb.append(firstPublishingDate);
        sb.append(", lastModifiedDate=");
        sb.append(lastModifiedDate);
        sb.append(", logoImageId=");
        sb.append(logoImageId);
        sb.append(", fee=");
        sb.append(fee);
        sb.append(", targetOS=");
        sb.append(targetOS);
        sb.append(", minTargetOSVersion=");
        sb.append(minTargetOSVersion);
        sb.append(", targetCategory=");
        sb.append(targetCategory);
        sb.append(", lifeCycleStatus=");
        sb.append(lifeCycleStatus);
        sb.append(", verifiedDate=");
        sb.append(verifiedDate);
        sb.append(", categoryString=");
        sb.append(categoryString);
        sb.append(", regionString=");
        sb.append(regionString);
        sb.append(", lifeCycleStatusString=");
        sb.append(lifeCycleStatusString);
        sb.append(", legalDetails=");
        sb.append(legalDetails);
        sb.append(", developer=");
        sb.append(developer);
        sb.append(", detailsViewed=");
        sb.append(detailsViewed);
        sb.append(", linkClicked=");
        sb.append(linkClicked);
        sb.append(", useOpenData=");
        sb.append(useOpenData);
        sb.append(", Sector=");
        sb.append(Sector);
        sb.append(", License=");
        sb.append(License);
        sb.append(", relatedApplicationId=");
        sb.append(relatedApplicationId);
        sb.append(", newVersionId=");
        sb.append(newVersionId);
        sb.append(", oldVersionId=");
        sb.append(oldVersionId);
        sb.append("}");

        return sb.toString();
    }

    public Application toEntityModel() {
        ApplicationImpl applicationImpl = new ApplicationImpl();

        applicationImpl.setApplicationId(applicationId);
        applicationImpl.setCompanyId(companyId);
        applicationImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            applicationImpl.setCreateDate(null);
        } else {
            applicationImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            applicationImpl.setModifiedDate(null);
        } else {
            applicationImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            applicationImpl.setName(StringPool.BLANK);
        } else {
            applicationImpl.setName(name);
        }

        if (description == null) {
            applicationImpl.setDescription(StringPool.BLANK);
        } else {
            applicationImpl.setDescription(description);
        }

        if (version == null) {
            applicationImpl.setVersion(StringPool.BLANK);
        } else {
            applicationImpl.setVersion(version);
        }

        if (versionInformation == null) {
            applicationImpl.setVersionInformation(StringPool.BLANK);
        } else {
            applicationImpl.setVersionInformation(versionInformation);
        }

        applicationImpl.setSize(size);

        if (firstPublishingDate == Long.MIN_VALUE) {
            applicationImpl.setFirstPublishingDate(null);
        } else {
            applicationImpl.setFirstPublishingDate(new Date(firstPublishingDate));
        }

        if (lastModifiedDate == Long.MIN_VALUE) {
            applicationImpl.setLastModifiedDate(null);
        } else {
            applicationImpl.setLastModifiedDate(new Date(lastModifiedDate));
        }

        applicationImpl.setLogoImageId(logoImageId);
        applicationImpl.setFee(fee);

        if (targetOS == null) {
            applicationImpl.setTargetOS(StringPool.BLANK);
        } else {
            applicationImpl.setTargetOS(targetOS);
        }

        applicationImpl.setMinTargetOSVersion(minTargetOSVersion);

        if (targetCategory == null) {
            applicationImpl.setTargetCategory(StringPool.BLANK);
        } else {
            applicationImpl.setTargetCategory(targetCategory);
        }

        applicationImpl.setLifeCycleStatus(lifeCycleStatus);

        if (verifiedDate == Long.MIN_VALUE) {
            applicationImpl.setVerifiedDate(null);
        } else {
            applicationImpl.setVerifiedDate(new Date(verifiedDate));
        }

        if (categoryString == null) {
            applicationImpl.setCategoryString(StringPool.BLANK);
        } else {
            applicationImpl.setCategoryString(categoryString);
        }

        if (regionString == null) {
            applicationImpl.setRegionString(StringPool.BLANK);
        } else {
            applicationImpl.setRegionString(regionString);
        }

        if (lifeCycleStatusString == null) {
            applicationImpl.setLifeCycleStatusString(StringPool.BLANK);
        } else {
            applicationImpl.setLifeCycleStatusString(lifeCycleStatusString);
        }

        if (legalDetails == null) {
            applicationImpl.setLegalDetails(StringPool.BLANK);
        } else {
            applicationImpl.setLegalDetails(legalDetails);
        }

        if (developer == null) {
            applicationImpl.setDeveloper(StringPool.BLANK);
        } else {
            applicationImpl.setDeveloper(developer);
        }

        applicationImpl.setDetailsViewed(detailsViewed);
        applicationImpl.setLinkClicked(linkClicked);
        applicationImpl.setUseOpenData(useOpenData);

        if (Sector == null) {
            applicationImpl.setSector(StringPool.BLANK);
        } else {
            applicationImpl.setSector(Sector);
        }

        if (License == null) {
            applicationImpl.setLicense(StringPool.BLANK);
        } else {
            applicationImpl.setLicense(License);
        }

        if (relatedApplicationId == null) {
            applicationImpl.setRelatedApplicationId(StringPool.BLANK);
        } else {
            applicationImpl.setRelatedApplicationId(relatedApplicationId);
        }

        applicationImpl.setNewVersionId(newVersionId);
        applicationImpl.setOldVersionId(oldVersionId);

        applicationImpl.resetOriginalValues();

        return applicationImpl;
    }
}
