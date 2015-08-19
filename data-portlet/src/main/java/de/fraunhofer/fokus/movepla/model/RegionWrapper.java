package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: RegionWrapper.java 566 2014-11-13 15:22:01Z sma $
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
 * This class is a wrapper for {@link Region}.
 * </p>
 *
 * @author    jpa
 * @see       Region
 * @generated
 */
public class RegionWrapper implements Region, ModelWrapper<Region> {
    private Region _region;

    public RegionWrapper(Region region) {
        _region = region;
    }

    public Class<?> getModelClass() {
        return Region.class;
    }

    public String getModelClassName() {
        return Region.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("regionId", getRegionId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("ags", getAgs());
        attributes.put("coordniates_x", getCoordniates_x());
        attributes.put("coordniates_y", getCoordniates_y());
        attributes.put("parentRegion", getParentRegion());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
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

        Integer ags = (Integer) attributes.get("ags");

        if (ags != null) {
            setAgs(ags);
        }

        Double coordniates_x = (Double) attributes.get("coordniates_x");

        if (coordniates_x != null) {
            setCoordniates_x(coordniates_x);
        }

        Double coordniates_y = (Double) attributes.get("coordniates_y");

        if (coordniates_y != null) {
            setCoordniates_y(coordniates_y);
        }

        Long parentRegion = (Long) attributes.get("parentRegion");

        if (parentRegion != null) {
            setParentRegion(parentRegion);
        }
    }

    /**
    * Returns the primary key of this region.
    *
    * @return the primary key of this region
    */
    public long getPrimaryKey() {
        return _region.getPrimaryKey();
    }

    /**
    * Sets the primary key of this region.
    *
    * @param primaryKey the primary key of this region
    */
    public void setPrimaryKey(long primaryKey) {
        _region.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the region ID of this region.
    *
    * @return the region ID of this region
    */
    public long getRegionId() {
        return _region.getRegionId();
    }

    /**
    * Sets the region ID of this region.
    *
    * @param regionId the region ID of this region
    */
    public void setRegionId(long regionId) {
        _region.setRegionId(regionId);
    }

    /**
    * Returns the company ID of this region.
    *
    * @return the company ID of this region
    */
    public long getCompanyId() {
        return _region.getCompanyId();
    }

    /**
    * Sets the company ID of this region.
    *
    * @param companyId the company ID of this region
    */
    public void setCompanyId(long companyId) {
        _region.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this region.
    *
    * @return the user ID of this region
    */
    public long getUserId() {
        return _region.getUserId();
    }

    /**
    * Sets the user ID of this region.
    *
    * @param userId the user ID of this region
    */
    public void setUserId(long userId) {
        _region.setUserId(userId);
    }

    /**
    * Returns the user uuid of this region.
    *
    * @return the user uuid of this region
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _region.getUserUuid();
    }

    /**
    * Sets the user uuid of this region.
    *
    * @param userUuid the user uuid of this region
    */
    public void setUserUuid(java.lang.String userUuid) {
        _region.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this region.
    *
    * @return the create date of this region
    */
    public java.util.Date getCreateDate() {
        return _region.getCreateDate();
    }

    /**
    * Sets the create date of this region.
    *
    * @param createDate the create date of this region
    */
    public void setCreateDate(java.util.Date createDate) {
        _region.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this region.
    *
    * @return the modified date of this region
    */
    public java.util.Date getModifiedDate() {
        return _region.getModifiedDate();
    }

    /**
    * Sets the modified date of this region.
    *
    * @param modifiedDate the modified date of this region
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _region.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this region.
    *
    * @return the name of this region
    */
    public java.lang.String getName() {
        return _region.getName();
    }

    /**
    * Sets the name of this region.
    *
    * @param name the name of this region
    */
    public void setName(java.lang.String name) {
        _region.setName(name);
    }

    /**
    * Returns the ags of this region.
    *
    * @return the ags of this region
    */
    public int getAgs() {
        return _region.getAgs();
    }

    /**
    * Sets the ags of this region.
    *
    * @param ags the ags of this region
    */
    public void setAgs(int ags) {
        _region.setAgs(ags);
    }

    /**
    * Returns the coordniates_x of this region.
    *
    * @return the coordniates_x of this region
    */
    public double getCoordniates_x() {
        return _region.getCoordniates_x();
    }

    /**
    * Sets the coordniates_x of this region.
    *
    * @param coordniates_x the coordniates_x of this region
    */
    public void setCoordniates_x(double coordniates_x) {
        _region.setCoordniates_x(coordniates_x);
    }

    /**
    * Returns the coordniates_y of this region.
    *
    * @return the coordniates_y of this region
    */
    public double getCoordniates_y() {
        return _region.getCoordniates_y();
    }

    /**
    * Sets the coordniates_y of this region.
    *
    * @param coordniates_y the coordniates_y of this region
    */
    public void setCoordniates_y(double coordniates_y) {
        _region.setCoordniates_y(coordniates_y);
    }

    /**
    * Returns the parent region of this region.
    *
    * @return the parent region of this region
    */
    public long getParentRegion() {
        return _region.getParentRegion();
    }

    /**
    * Sets the parent region of this region.
    *
    * @param parentRegion the parent region of this region
    */
    public void setParentRegion(long parentRegion) {
        _region.setParentRegion(parentRegion);
    }

    public boolean isNew() {
        return _region.isNew();
    }

    public void setNew(boolean n) {
        _region.setNew(n);
    }

    public boolean isCachedModel() {
        return _region.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _region.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _region.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _region.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _region.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _region.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _region.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RegionWrapper((Region) _region.clone());
    }

    public int compareTo(Region region) {
        return _region.compareTo(region);
    }

    @Override
    public int hashCode() {
        return _region.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Region> toCacheModel() {
        return _region.toCacheModel();
    }

    public Region toEscapedModel() {
        return new RegionWrapper(_region.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _region.toString();
    }

    public java.lang.String toXmlString() {
        return _region.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _region.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Region getWrappedRegion() {
        return _region;
    }

    public Region getWrappedModel() {
        return _region;
    }

    public void resetOriginalValues() {
        _region.resetOriginalValues();
    }
}
