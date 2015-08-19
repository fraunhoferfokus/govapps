package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationSoap.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is used by SOAP remote services, specifically {@link de.fraunhofer.fokus.movepla.service.http.ApplicationServiceSoap}.
 *
 * @author    jpa
 * @see       de.fraunhofer.fokus.movepla.service.http.ApplicationServiceSoap
 * @generated
 */
public class ApplicationSoap implements Serializable {
    private long _applicationId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _version;
    private String _versionInformation;
    private int _size;
    private Date _firstPublishingDate;
    private Date _lastModifiedDate;
    private long _logoImageId;
    private int _fee;
    private String _targetOS;
    private int _minTargetOSVersion;
    private String _targetCategory;
    private int _lifeCycleStatus;
    private Date _verifiedDate;
    private String _categoryString;
    private String _regionString;
    private String _lifeCycleStatusString;
    private String _legalDetails;
    private String _developer;
    private long _detailsViewed;
    private long _linkClicked;
    private int _useOpenData;
    private String _Sector;
    private String _License;
    private String _relatedApplicationId;
    private long _newVersionId;
    private long _oldVersionId;

    public ApplicationSoap() {
    }

    public static ApplicationSoap toSoapModel(Application model) {
        ApplicationSoap soapModel = new ApplicationSoap();

        soapModel.setApplicationId(model.getApplicationId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setVersion(model.getVersion());
        soapModel.setVersionInformation(model.getVersionInformation());
        soapModel.setSize(model.getSize());
        soapModel.setFirstPublishingDate(model.getFirstPublishingDate());
        soapModel.setLastModifiedDate(model.getLastModifiedDate());
        soapModel.setLogoImageId(model.getLogoImageId());
        soapModel.setFee(model.getFee());
        soapModel.setTargetOS(model.getTargetOS());
        soapModel.setMinTargetOSVersion(model.getMinTargetOSVersion());
        soapModel.setTargetCategory(model.getTargetCategory());
        soapModel.setLifeCycleStatus(model.getLifeCycleStatus());
        soapModel.setVerifiedDate(model.getVerifiedDate());
        soapModel.setCategoryString(model.getCategoryString());
        soapModel.setRegionString(model.getRegionString());
        soapModel.setLifeCycleStatusString(model.getLifeCycleStatusString());
        soapModel.setLegalDetails(model.getLegalDetails());
        soapModel.setDeveloper(model.getDeveloper());
        soapModel.setDetailsViewed(model.getDetailsViewed());
        soapModel.setLinkClicked(model.getLinkClicked());
        soapModel.setUseOpenData(model.getUseOpenData());
        soapModel.setSector(model.getSector());
        soapModel.setLicense(model.getLicense());
        soapModel.setRelatedApplicationId(model.getRelatedApplicationId());
        soapModel.setNewVersionId(model.getNewVersionId());
        soapModel.setOldVersionId(model.getOldVersionId());

        return soapModel;
    }

    public static ApplicationSoap[] toSoapModels(Application[] models) {
        ApplicationSoap[] soapModels = new ApplicationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ApplicationSoap[][] toSoapModels(Application[][] models) {
        ApplicationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ApplicationSoap[models.length][models[0].length];
        } else {
            soapModels = new ApplicationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ApplicationSoap[] toSoapModels(List<Application> models) {
        List<ApplicationSoap> soapModels = new ArrayList<ApplicationSoap>(models.size());

        for (Application model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ApplicationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _applicationId;
    }

    public void setPrimaryKey(long pk) {
        setApplicationId(pk);
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
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

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        _version = version;
    }

    public String getVersionInformation() {
        return _versionInformation;
    }

    public void setVersionInformation(String versionInformation) {
        _versionInformation = versionInformation;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }

    public Date getFirstPublishingDate() {
        return _firstPublishingDate;
    }

    public void setFirstPublishingDate(Date firstPublishingDate) {
        _firstPublishingDate = firstPublishingDate;
    }

    public Date getLastModifiedDate() {
        return _lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        _lastModifiedDate = lastModifiedDate;
    }

    public long getLogoImageId() {
        return _logoImageId;
    }

    public void setLogoImageId(long logoImageId) {
        _logoImageId = logoImageId;
    }

    public int getFee() {
        return _fee;
    }

    public void setFee(int fee) {
        _fee = fee;
    }

    public String getTargetOS() {
        return _targetOS;
    }

    public void setTargetOS(String targetOS) {
        _targetOS = targetOS;
    }

    public int getMinTargetOSVersion() {
        return _minTargetOSVersion;
    }

    public void setMinTargetOSVersion(int minTargetOSVersion) {
        _minTargetOSVersion = minTargetOSVersion;
    }

    public String getTargetCategory() {
        return _targetCategory;
    }

    public void setTargetCategory(String targetCategory) {
        _targetCategory = targetCategory;
    }

    public int getLifeCycleStatus() {
        return _lifeCycleStatus;
    }

    public void setLifeCycleStatus(int lifeCycleStatus) {
        _lifeCycleStatus = lifeCycleStatus;
    }

    public Date getVerifiedDate() {
        return _verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        _verifiedDate = verifiedDate;
    }

    public String getCategoryString() {
        return _categoryString;
    }

    public void setCategoryString(String categoryString) {
        _categoryString = categoryString;
    }

    public String getRegionString() {
        return _regionString;
    }

    public void setRegionString(String regionString) {
        _regionString = regionString;
    }

    public String getLifeCycleStatusString() {
        return _lifeCycleStatusString;
    }

    public void setLifeCycleStatusString(String lifeCycleStatusString) {
        _lifeCycleStatusString = lifeCycleStatusString;
    }

    public String getLegalDetails() {
        return _legalDetails;
    }

    public void setLegalDetails(String legalDetails) {
        _legalDetails = legalDetails;
    }

    public String getDeveloper() {
        return _developer;
    }

    public void setDeveloper(String developer) {
        _developer = developer;
    }

    public long getDetailsViewed() {
        return _detailsViewed;
    }

    public void setDetailsViewed(long detailsViewed) {
        _detailsViewed = detailsViewed;
    }

    public long getLinkClicked() {
        return _linkClicked;
    }

    public void setLinkClicked(long linkClicked) {
        _linkClicked = linkClicked;
    }

    public int getUseOpenData() {
        return _useOpenData;
    }

    public void setUseOpenData(int useOpenData) {
        _useOpenData = useOpenData;
    }

    public String getSector() {
        return _Sector;
    }

    public void setSector(String Sector) {
        _Sector = Sector;
    }

    public String getLicense() {
        return _License;
    }

    public void setLicense(String License) {
        _License = License;
    }

    public String getRelatedApplicationId() {
        return _relatedApplicationId;
    }

    public void setRelatedApplicationId(String relatedApplicationId) {
        _relatedApplicationId = relatedApplicationId;
    }

    public long getNewVersionId() {
        return _newVersionId;
    }

    public void setNewVersionId(long newVersionId) {
        _newVersionId = newVersionId;
    }

    public long getOldVersionId() {
        return _oldVersionId;
    }

    public void setOldVersionId(long oldVersionId) {
        _oldVersionId = oldVersionId;
    }
}
