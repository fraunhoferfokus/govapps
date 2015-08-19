package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationWrapper.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Application}.
 * </p>
 *
 * @author    jpa
 * @see       Application
 * @generated
 */
public class ApplicationWrapper implements Application,
    ModelWrapper<Application> {
    private Application _application;

    public ApplicationWrapper(Application application) {
        _application = application;
    }

    public Class<?> getModelClass() {
        return Application.class;
    }

    public String getModelClassName() {
        return Application.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicationId", getApplicationId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("version", getVersion());
        attributes.put("versionInformation", getVersionInformation());
        attributes.put("size", getSize());
        attributes.put("firstPublishingDate", getFirstPublishingDate());
        attributes.put("lastModifiedDate", getLastModifiedDate());
        attributes.put("logoImageId", getLogoImageId());
        attributes.put("fee", getFee());
        attributes.put("targetOS", getTargetOS());
        attributes.put("minTargetOSVersion", getMinTargetOSVersion());
        attributes.put("targetCategory", getTargetCategory());
        attributes.put("lifeCycleStatus", getLifeCycleStatus());
        attributes.put("verifiedDate", getVerifiedDate());
        attributes.put("categoryString", getCategoryString());
        attributes.put("regionString", getRegionString());
        attributes.put("lifeCycleStatusString", getLifeCycleStatusString());
        attributes.put("legalDetails", getLegalDetails());
        attributes.put("developer", getDeveloper());
        attributes.put("detailsViewed", getDetailsViewed());
        attributes.put("linkClicked", getLinkClicked());
        attributes.put("useOpenData", getUseOpenData());
        attributes.put("Sector", getSector());
        attributes.put("License", getLicense());
        attributes.put("relatedApplicationId", getRelatedApplicationId());
        attributes.put("newVersionId", getNewVersionId());
        attributes.put("oldVersionId", getOldVersionId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String version = (String) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        String versionInformation = (String) attributes.get(
                "versionInformation");

        if (versionInformation != null) {
            setVersionInformation(versionInformation);
        }

        Integer size = (Integer) attributes.get("size");

        if (size != null) {
            setSize(size);
        }

        Date firstPublishingDate = (Date) attributes.get("firstPublishingDate");

        if (firstPublishingDate != null) {
            setFirstPublishingDate(firstPublishingDate);
        }

        Date lastModifiedDate = (Date) attributes.get("lastModifiedDate");

        if (lastModifiedDate != null) {
            setLastModifiedDate(lastModifiedDate);
        }

        Long logoImageId = (Long) attributes.get("logoImageId");

        if (logoImageId != null) {
            setLogoImageId(logoImageId);
        }

        Integer fee = (Integer) attributes.get("fee");

        if (fee != null) {
            setFee(fee);
        }

        String targetOS = (String) attributes.get("targetOS");

        if (targetOS != null) {
            setTargetOS(targetOS);
        }

        Integer minTargetOSVersion = (Integer) attributes.get(
                "minTargetOSVersion");

        if (minTargetOSVersion != null) {
            setMinTargetOSVersion(minTargetOSVersion);
        }

        String targetCategory = (String) attributes.get("targetCategory");

        if (targetCategory != null) {
            setTargetCategory(targetCategory);
        }

        Integer lifeCycleStatus = (Integer) attributes.get("lifeCycleStatus");

        if (lifeCycleStatus != null) {
            setLifeCycleStatus(lifeCycleStatus);
        }

        Date verifiedDate = (Date) attributes.get("verifiedDate");

        if (verifiedDate != null) {
            setVerifiedDate(verifiedDate);
        }

        String categoryString = (String) attributes.get("categoryString");

        if (categoryString != null) {
            setCategoryString(categoryString);
        }

        String regionString = (String) attributes.get("regionString");

        if (regionString != null) {
            setRegionString(regionString);
        }

        String lifeCycleStatusString = (String) attributes.get(
                "lifeCycleStatusString");

        if (lifeCycleStatusString != null) {
            setLifeCycleStatusString(lifeCycleStatusString);
        }

        String legalDetails = (String) attributes.get("legalDetails");

        if (legalDetails != null) {
            setLegalDetails(legalDetails);
        }

        String developer = (String) attributes.get("developer");

        if (developer != null) {
            setDeveloper(developer);
        }

        Long detailsViewed = (Long) attributes.get("detailsViewed");

        if (detailsViewed != null) {
            setDetailsViewed(detailsViewed);
        }

        Long linkClicked = (Long) attributes.get("linkClicked");

        if (linkClicked != null) {
            setLinkClicked(linkClicked);
        }

        Integer useOpenData = (Integer) attributes.get("useOpenData");

        if (useOpenData != null) {
            setUseOpenData(useOpenData);
        }

        String Sector = (String) attributes.get("Sector");

        if (Sector != null) {
            setSector(Sector);
        }

        String License = (String) attributes.get("License");

        if (License != null) {
            setLicense(License);
        }

        String relatedApplicationId = (String) attributes.get(
                "relatedApplicationId");

        if (relatedApplicationId != null) {
            setRelatedApplicationId(relatedApplicationId);
        }

        Long newVersionId = (Long) attributes.get("newVersionId");

        if (newVersionId != null) {
            setNewVersionId(newVersionId);
        }

        Long oldVersionId = (Long) attributes.get("oldVersionId");

        if (oldVersionId != null) {
            setOldVersionId(oldVersionId);
        }
    }

    /**
    * Returns the primary key of this application.
    *
    * @return the primary key of this application
    */
    public long getPrimaryKey() {
        return _application.getPrimaryKey();
    }

    /**
    * Sets the primary key of this application.
    *
    * @param primaryKey the primary key of this application
    */
    public void setPrimaryKey(long primaryKey) {
        _application.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the application ID of this application.
    *
    * @return the application ID of this application
    */
    public long getApplicationId() {
        return _application.getApplicationId();
    }

    /**
    * Sets the application ID of this application.
    *
    * @param applicationId the application ID of this application
    */
    public void setApplicationId(long applicationId) {
        _application.setApplicationId(applicationId);
    }

    /**
    * Returns the company ID of this application.
    *
    * @return the company ID of this application
    */
    public long getCompanyId() {
        return _application.getCompanyId();
    }

    /**
    * Sets the company ID of this application.
    *
    * @param companyId the company ID of this application
    */
    public void setCompanyId(long companyId) {
        _application.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this application.
    *
    * @return the user ID of this application
    */
    public long getUserId() {
        return _application.getUserId();
    }

    /**
    * Sets the user ID of this application.
    *
    * @param userId the user ID of this application
    */
    public void setUserId(long userId) {
        _application.setUserId(userId);
    }

    /**
    * Returns the user uuid of this application.
    *
    * @return the user uuid of this application
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application.getUserUuid();
    }

    /**
    * Sets the user uuid of this application.
    *
    * @param userUuid the user uuid of this application
    */
    public void setUserUuid(java.lang.String userUuid) {
        _application.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this application.
    *
    * @return the create date of this application
    */
    public java.util.Date getCreateDate() {
        return _application.getCreateDate();
    }

    /**
    * Sets the create date of this application.
    *
    * @param createDate the create date of this application
    */
    public void setCreateDate(java.util.Date createDate) {
        _application.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this application.
    *
    * @return the modified date of this application
    */
    public java.util.Date getModifiedDate() {
        return _application.getModifiedDate();
    }

    /**
    * Sets the modified date of this application.
    *
    * @param modifiedDate the modified date of this application
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _application.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this application.
    *
    * @return the name of this application
    */
    public java.lang.String getName() {
        return _application.getName();
    }

    /**
    * Sets the name of this application.
    *
    * @param name the name of this application
    */
    public void setName(java.lang.String name) {
        _application.setName(name);
    }

    /**
    * Returns the description of this application.
    *
    * @return the description of this application
    */
    public java.lang.String getDescription() {
        return _application.getDescription();
    }

    /**
    * Sets the description of this application.
    *
    * @param description the description of this application
    */
    public void setDescription(java.lang.String description) {
        _application.setDescription(description);
    }

    /**
    * Returns the version of this application.
    *
    * @return the version of this application
    */
    public java.lang.String getVersion() {
        return _application.getVersion();
    }

    /**
    * Sets the version of this application.
    *
    * @param version the version of this application
    */
    public void setVersion(java.lang.String version) {
        _application.setVersion(version);
    }

    /**
    * Returns the version information of this application.
    *
    * @return the version information of this application
    */
    public java.lang.String getVersionInformation() {
        return _application.getVersionInformation();
    }

    /**
    * Sets the version information of this application.
    *
    * @param versionInformation the version information of this application
    */
    public void setVersionInformation(java.lang.String versionInformation) {
        _application.setVersionInformation(versionInformation);
    }

    /**
    * Returns the size of this application.
    *
    * @return the size of this application
    */
    public int getSize() {
        return _application.getSize();
    }

    /**
    * Sets the size of this application.
    *
    * @param size the size of this application
    */
    public void setSize(int size) {
        _application.setSize(size);
    }

    /**
    * Returns the first publishing date of this application.
    *
    * @return the first publishing date of this application
    */
    public java.util.Date getFirstPublishingDate() {
        return _application.getFirstPublishingDate();
    }

    /**
    * Sets the first publishing date of this application.
    *
    * @param firstPublishingDate the first publishing date of this application
    */
    public void setFirstPublishingDate(java.util.Date firstPublishingDate) {
        _application.setFirstPublishingDate(firstPublishingDate);
    }

    /**
    * Returns the last modified date of this application.
    *
    * @return the last modified date of this application
    */
    public java.util.Date getLastModifiedDate() {
        return _application.getLastModifiedDate();
    }

    /**
    * Sets the last modified date of this application.
    *
    * @param lastModifiedDate the last modified date of this application
    */
    public void setLastModifiedDate(java.util.Date lastModifiedDate) {
        _application.setLastModifiedDate(lastModifiedDate);
    }

    /**
    * Returns the logo image ID of this application.
    *
    * @return the logo image ID of this application
    */
    public long getLogoImageId() {
        return _application.getLogoImageId();
    }

    /**
    * Sets the logo image ID of this application.
    *
    * @param logoImageId the logo image ID of this application
    */
    public void setLogoImageId(long logoImageId) {
        _application.setLogoImageId(logoImageId);
    }

    /**
    * Returns the fee of this application.
    *
    * @return the fee of this application
    */
    public int getFee() {
        return _application.getFee();
    }

    /**
    * Sets the fee of this application.
    *
    * @param fee the fee of this application
    */
    public void setFee(int fee) {
        _application.setFee(fee);
    }

    /**
    * Returns the target o s of this application.
    *
    * @return the target o s of this application
    */
    public java.lang.String getTargetOS() {
        return _application.getTargetOS();
    }

    /**
    * Sets the target o s of this application.
    *
    * @param targetOS the target o s of this application
    */
    public void setTargetOS(java.lang.String targetOS) {
        _application.setTargetOS(targetOS);
    }

    /**
    * Returns the min target o s version of this application.
    *
    * @return the min target o s version of this application
    */
    public int getMinTargetOSVersion() {
        return _application.getMinTargetOSVersion();
    }

    /**
    * Sets the min target o s version of this application.
    *
    * @param minTargetOSVersion the min target o s version of this application
    */
    public void setMinTargetOSVersion(int minTargetOSVersion) {
        _application.setMinTargetOSVersion(minTargetOSVersion);
    }

    /**
    * Returns the target category of this application.
    *
    * @return the target category of this application
    */
    public java.lang.String getTargetCategory() {
        return _application.getTargetCategory();
    }

    /**
    * Sets the target category of this application.
    *
    * @param targetCategory the target category of this application
    */
    public void setTargetCategory(java.lang.String targetCategory) {
        _application.setTargetCategory(targetCategory);
    }

    /**
    * Returns the life cycle status of this application.
    *
    * @return the life cycle status of this application
    */
    public int getLifeCycleStatus() {
        return _application.getLifeCycleStatus();
    }

    /**
    * Sets the life cycle status of this application.
    *
    * @param lifeCycleStatus the life cycle status of this application
    */
    public void setLifeCycleStatus(int lifeCycleStatus) {
        _application.setLifeCycleStatus(lifeCycleStatus);
    }

    /**
    * Returns the verified date of this application.
    *
    * @return the verified date of this application
    */
    public java.util.Date getVerifiedDate() {
        return _application.getVerifiedDate();
    }

    /**
    * Sets the verified date of this application.
    *
    * @param verifiedDate the verified date of this application
    */
    public void setVerifiedDate(java.util.Date verifiedDate) {
        _application.setVerifiedDate(verifiedDate);
    }

    /**
    * Returns the category string of this application.
    *
    * @return the category string of this application
    */
    public java.lang.String getCategoryString() {
        return _application.getCategoryString();
    }

    /**
    * Sets the category string of this application.
    *
    * @param categoryString the category string of this application
    */
    public void setCategoryString(java.lang.String categoryString) {
        _application.setCategoryString(categoryString);
    }

    /**
    * Returns the region string of this application.
    *
    * @return the region string of this application
    */
    public java.lang.String getRegionString() {
        return _application.getRegionString();
    }

    /**
    * Sets the region string of this application.
    *
    * @param regionString the region string of this application
    */
    public void setRegionString(java.lang.String regionString) {
        _application.setRegionString(regionString);
    }

    /**
    * Returns the life cycle status string of this application.
    *
    * @return the life cycle status string of this application
    */
    public java.lang.String getLifeCycleStatusString() {
        return _application.getLifeCycleStatusString();
    }

    /**
    * Sets the life cycle status string of this application.
    *
    * @param lifeCycleStatusString the life cycle status string of this application
    */
    public void setLifeCycleStatusString(java.lang.String lifeCycleStatusString) {
        _application.setLifeCycleStatusString(lifeCycleStatusString);
    }

    /**
    * Returns the legal details of this application.
    *
    * @return the legal details of this application
    */
    public java.lang.String getLegalDetails() {
        return _application.getLegalDetails();
    }

    /**
    * Sets the legal details of this application.
    *
    * @param legalDetails the legal details of this application
    */
    public void setLegalDetails(java.lang.String legalDetails) {
        _application.setLegalDetails(legalDetails);
    }

    /**
    * Returns the developer of this application.
    *
    * @return the developer of this application
    */
    public java.lang.String getDeveloper() {
        return _application.getDeveloper();
    }

    /**
    * Sets the developer of this application.
    *
    * @param developer the developer of this application
    */
    public void setDeveloper(java.lang.String developer) {
        _application.setDeveloper(developer);
    }

    /**
    * Returns the details viewed of this application.
    *
    * @return the details viewed of this application
    */
    public long getDetailsViewed() {
        return _application.getDetailsViewed();
    }

    /**
    * Sets the details viewed of this application.
    *
    * @param detailsViewed the details viewed of this application
    */
    public void setDetailsViewed(long detailsViewed) {
        _application.setDetailsViewed(detailsViewed);
    }

    /**
    * Returns the link clicked of this application.
    *
    * @return the link clicked of this application
    */
    public long getLinkClicked() {
        return _application.getLinkClicked();
    }

    /**
    * Sets the link clicked of this application.
    *
    * @param linkClicked the link clicked of this application
    */
    public void setLinkClicked(long linkClicked) {
        _application.setLinkClicked(linkClicked);
    }

    /**
    * Returns the use open data of this application.
    *
    * @return the use open data of this application
    */
    public int getUseOpenData() {
        return _application.getUseOpenData();
    }

    /**
    * Sets the use open data of this application.
    *
    * @param useOpenData the use open data of this application
    */
    public void setUseOpenData(int useOpenData) {
        _application.setUseOpenData(useOpenData);
    }

    /**
    * Returns the sector of this application.
    *
    * @return the sector of this application
    */
    public java.lang.String getSector() {
        return _application.getSector();
    }

    /**
    * Sets the sector of this application.
    *
    * @param Sector the sector of this application
    */
    public void setSector(java.lang.String Sector) {
        _application.setSector(Sector);
    }

    /**
    * Returns the license of this application.
    *
    * @return the license of this application
    */
    public java.lang.String getLicense() {
        return _application.getLicense();
    }

    /**
    * Sets the license of this application.
    *
    * @param License the license of this application
    */
    public void setLicense(java.lang.String License) {
        _application.setLicense(License);
    }

    /**
    * Returns the related application ID of this application.
    *
    * @return the related application ID of this application
    */
    public java.lang.String getRelatedApplicationId() {
        return _application.getRelatedApplicationId();
    }

    /**
    * Sets the related application ID of this application.
    *
    * @param relatedApplicationId the related application ID of this application
    */
    public void setRelatedApplicationId(java.lang.String relatedApplicationId) {
        _application.setRelatedApplicationId(relatedApplicationId);
    }

    /**
    * Returns the new version ID of this application.
    *
    * @return the new version ID of this application
    */
    public long getNewVersionId() {
        return _application.getNewVersionId();
    }

    /**
    * Sets the new version ID of this application.
    *
    * @param newVersionId the new version ID of this application
    */
    public void setNewVersionId(long newVersionId) {
        _application.setNewVersionId(newVersionId);
    }

    /**
    * Returns the old version ID of this application.
    *
    * @return the old version ID of this application
    */
    public long getOldVersionId() {
        return _application.getOldVersionId();
    }

    /**
    * Sets the old version ID of this application.
    *
    * @param oldVersionId the old version ID of this application
    */
    public void setOldVersionId(long oldVersionId) {
        _application.setOldVersionId(oldVersionId);
    }

    public boolean isNew() {
        return _application.isNew();
    }

    public void setNew(boolean n) {
        _application.setNew(n);
    }

    public boolean isCachedModel() {
        return _application.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _application.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _application.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _application.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _application.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _application.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _application.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ApplicationWrapper((Application) _application.clone());
    }

    public int compareTo(Application application) {
        return _application.compareTo(application);
    }

    @Override
    public int hashCode() {
        return _application.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Application> toCacheModel() {
        return _application.toCacheModel();
    }

    public Application toEscapedModel() {
        return new ApplicationWrapper(_application.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _application.toString();
    }

    public java.lang.String toXmlString() {
        return _application.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _application.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Application getWrappedApplication() {
        return _application;
    }

    public Application getWrappedModel() {
        return _application;
    }

    public void resetOriginalValues() {
        _application.resetOriginalValues();
    }
}
