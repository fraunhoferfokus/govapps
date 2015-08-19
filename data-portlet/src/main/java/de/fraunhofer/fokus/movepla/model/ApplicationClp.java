package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationClp.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ApplicationClp extends BaseModelImpl<Application>
    implements Application {
    private long _applicationId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
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
    private BaseModel<?> _applicationRemoteModel;

    public ApplicationClp() {
    }

    public Class<?> getModelClass() {
        return Application.class;
    }

    public String getModelClassName() {
        return Application.class.getName();
    }

    public long getPrimaryKey() {
        return _applicationId;
    }

    public void setPrimaryKey(long primaryKey) {
        setApplicationId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_applicationId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
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

    public BaseModel<?> getApplicationRemoteModel() {
        return _applicationRemoteModel;
    }

    public void setApplicationRemoteModel(BaseModel<?> applicationRemoteModel) {
        _applicationRemoteModel = applicationRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ApplicationLocalServiceUtil.addApplication(this);
        } else {
            ApplicationLocalServiceUtil.updateApplication(this);
        }
    }

    @Override
    public Application toEscapedModel() {
        return (Application) Proxy.newProxyInstance(Application.class.getClassLoader(),
            new Class[] { Application.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ApplicationClp clone = new ApplicationClp();

        clone.setApplicationId(getApplicationId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setVersion(getVersion());
        clone.setVersionInformation(getVersionInformation());
        clone.setSize(getSize());
        clone.setFirstPublishingDate(getFirstPublishingDate());
        clone.setLastModifiedDate(getLastModifiedDate());
        clone.setLogoImageId(getLogoImageId());
        clone.setFee(getFee());
        clone.setTargetOS(getTargetOS());
        clone.setMinTargetOSVersion(getMinTargetOSVersion());
        clone.setTargetCategory(getTargetCategory());
        clone.setLifeCycleStatus(getLifeCycleStatus());
        clone.setVerifiedDate(getVerifiedDate());
        clone.setCategoryString(getCategoryString());
        clone.setRegionString(getRegionString());
        clone.setLifeCycleStatusString(getLifeCycleStatusString());
        clone.setLegalDetails(getLegalDetails());
        clone.setDeveloper(getDeveloper());
        clone.setDetailsViewed(getDetailsViewed());
        clone.setLinkClicked(getLinkClicked());
        clone.setUseOpenData(getUseOpenData());
        clone.setSector(getSector());
        clone.setLicense(getLicense());
        clone.setRelatedApplicationId(getRelatedApplicationId());
        clone.setNewVersionId(getNewVersionId());
        clone.setOldVersionId(getOldVersionId());

        return clone;
    }

    public int compareTo(Application application) {
        int value = 0;

        value = getName().compareTo(application.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ApplicationClp application = null;

        try {
            application = (ApplicationClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = application.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(65);

        sb.append("{applicationId=");
        sb.append(getApplicationId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", versionInformation=");
        sb.append(getVersionInformation());
        sb.append(", size=");
        sb.append(getSize());
        sb.append(", firstPublishingDate=");
        sb.append(getFirstPublishingDate());
        sb.append(", lastModifiedDate=");
        sb.append(getLastModifiedDate());
        sb.append(", logoImageId=");
        sb.append(getLogoImageId());
        sb.append(", fee=");
        sb.append(getFee());
        sb.append(", targetOS=");
        sb.append(getTargetOS());
        sb.append(", minTargetOSVersion=");
        sb.append(getMinTargetOSVersion());
        sb.append(", targetCategory=");
        sb.append(getTargetCategory());
        sb.append(", lifeCycleStatus=");
        sb.append(getLifeCycleStatus());
        sb.append(", verifiedDate=");
        sb.append(getVerifiedDate());
        sb.append(", categoryString=");
        sb.append(getCategoryString());
        sb.append(", regionString=");
        sb.append(getRegionString());
        sb.append(", lifeCycleStatusString=");
        sb.append(getLifeCycleStatusString());
        sb.append(", legalDetails=");
        sb.append(getLegalDetails());
        sb.append(", developer=");
        sb.append(getDeveloper());
        sb.append(", detailsViewed=");
        sb.append(getDetailsViewed());
        sb.append(", linkClicked=");
        sb.append(getLinkClicked());
        sb.append(", useOpenData=");
        sb.append(getUseOpenData());
        sb.append(", Sector=");
        sb.append(getSector());
        sb.append(", License=");
        sb.append(getLicense());
        sb.append(", relatedApplicationId=");
        sb.append(getRelatedApplicationId());
        sb.append(", newVersionId=");
        sb.append(getNewVersionId());
        sb.append(", oldVersionId=");
        sb.append(getOldVersionId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(100);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.movepla.model.Application");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>versionInformation</column-name><column-value><![CDATA[");
        sb.append(getVersionInformation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>size</column-name><column-value><![CDATA[");
        sb.append(getSize());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstPublishingDate</column-name><column-value><![CDATA[");
        sb.append(getFirstPublishingDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
        sb.append(getLastModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logoImageId</column-name><column-value><![CDATA[");
        sb.append(getLogoImageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fee</column-name><column-value><![CDATA[");
        sb.append(getFee());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetOS</column-name><column-value><![CDATA[");
        sb.append(getTargetOS());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>minTargetOSVersion</column-name><column-value><![CDATA[");
        sb.append(getMinTargetOSVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetCategory</column-name><column-value><![CDATA[");
        sb.append(getTargetCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lifeCycleStatus</column-name><column-value><![CDATA[");
        sb.append(getLifeCycleStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verifiedDate</column-name><column-value><![CDATA[");
        sb.append(getVerifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryString</column-name><column-value><![CDATA[");
        sb.append(getCategoryString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionString</column-name><column-value><![CDATA[");
        sb.append(getRegionString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lifeCycleStatusString</column-name><column-value><![CDATA[");
        sb.append(getLifeCycleStatusString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legalDetails</column-name><column-value><![CDATA[");
        sb.append(getLegalDetails());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>developer</column-name><column-value><![CDATA[");
        sb.append(getDeveloper());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>detailsViewed</column-name><column-value><![CDATA[");
        sb.append(getDetailsViewed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>linkClicked</column-name><column-value><![CDATA[");
        sb.append(getLinkClicked());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>useOpenData</column-name><column-value><![CDATA[");
        sb.append(getUseOpenData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>Sector</column-name><column-value><![CDATA[");
        sb.append(getSector());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>License</column-name><column-value><![CDATA[");
        sb.append(getLicense());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>relatedApplicationId</column-name><column-value><![CDATA[");
        sb.append(getRelatedApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>newVersionId</column-name><column-value><![CDATA[");
        sb.append(getNewVersionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>oldVersionId</column-name><column-value><![CDATA[");
        sb.append(getOldVersionId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
