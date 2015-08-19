package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: RegionModel.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Region service. Represents a row in the &quot;mvp_Region&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.movepla.model.impl.RegionImpl}.
 * </p>
 *
 * @author jpa
 * @see Region
 * @see de.fraunhofer.fokus.movepla.model.impl.RegionImpl
 * @see de.fraunhofer.fokus.movepla.model.impl.RegionModelImpl
 * @generated
 */
public interface RegionModel extends BaseModel<Region> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a region model instance should use the {@link Region} interface instead.
     */

    /**
     * Returns the primary key of this region.
     *
     * @return the primary key of this region
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this region.
     *
     * @param primaryKey the primary key of this region
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the region ID of this region.
     *
     * @return the region ID of this region
     */
    public long getRegionId();

    /**
     * Sets the region ID of this region.
     *
     * @param regionId the region ID of this region
     */
    public void setRegionId(long regionId);

    /**
     * Returns the company ID of this region.
     *
     * @return the company ID of this region
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this region.
     *
     * @param companyId the company ID of this region
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this region.
     *
     * @return the user ID of this region
     */
    public long getUserId();

    /**
     * Sets the user ID of this region.
     *
     * @param userId the user ID of this region
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this region.
     *
     * @return the user uuid of this region
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this region.
     *
     * @param userUuid the user uuid of this region
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the create date of this region.
     *
     * @return the create date of this region
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this region.
     *
     * @param createDate the create date of this region
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this region.
     *
     * @return the modified date of this region
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this region.
     *
     * @param modifiedDate the modified date of this region
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the name of this region.
     *
     * @return the name of this region
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this region.
     *
     * @param name the name of this region
     */
    public void setName(String name);

    /**
     * Returns the ags of this region.
     *
     * @return the ags of this region
     */
    public int getAgs();

    /**
     * Sets the ags of this region.
     *
     * @param ags the ags of this region
     */
    public void setAgs(int ags);

    /**
     * Returns the coordniates_x of this region.
     *
     * @return the coordniates_x of this region
     */
    public double getCoordniates_x();

    /**
     * Sets the coordniates_x of this region.
     *
     * @param coordniates_x the coordniates_x of this region
     */
    public void setCoordniates_x(double coordniates_x);

    /**
     * Returns the coordniates_y of this region.
     *
     * @return the coordniates_y of this region
     */
    public double getCoordniates_y();

    /**
     * Sets the coordniates_y of this region.
     *
     * @param coordniates_y the coordniates_y of this region
     */
    public void setCoordniates_y(double coordniates_y);

    /**
     * Returns the parent region of this region.
     *
     * @return the parent region of this region
     */
    public long getParentRegion();

    /**
     * Sets the parent region of this region.
     *
     * @param parentRegion the parent region of this region
     */
    public void setParentRegion(long parentRegion);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Region region);

    public int hashCode();

    public CacheModel<Region> toCacheModel();

    public Region toEscapedModel();

    public String toString();

    public String toXmlString();
}