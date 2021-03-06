package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LoggingModel.java 566 2014-11-13 15:22:01Z sma $
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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Logging service. Represents a row in the &quot;mvp_Logging&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.movepla.model.impl.LoggingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.movepla.model.impl.LoggingImpl}.
 * </p>
 *
 * @author jpa
 * @see Logging
 * @see de.fraunhofer.fokus.movepla.model.impl.LoggingImpl
 * @see de.fraunhofer.fokus.movepla.model.impl.LoggingModelImpl
 * @generated
 */
public interface LoggingModel extends BaseModel<Logging> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a logging model instance should use the {@link Logging} interface instead.
     */

    /**
     * Returns the primary key of this logging.
     *
     * @return the primary key of this logging
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this logging.
     *
     * @param primaryKey the primary key of this logging
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the logging ID of this logging.
     *
     * @return the logging ID of this logging
     */
    public long getLoggingId();

    /**
     * Sets the logging ID of this logging.
     *
     * @param loggingId the logging ID of this logging
     */
    public void setLoggingId(long loggingId);

    /**
     * Returns the create date of this logging.
     *
     * @return the create date of this logging
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this logging.
     *
     * @param createDate the create date of this logging
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this logging.
     *
     * @return the modified date of this logging
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this logging.
     *
     * @param modifiedDate the modified date of this logging
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the is simple search of this logging.
     *
     * @return the is simple search of this logging
     */
    public Boolean getIsSimpleSearch();

    /**
     * Sets the is simple search of this logging.
     *
     * @param isSimpleSearch the is simple search of this logging
     */
    public void setIsSimpleSearch(Boolean isSimpleSearch);

    /**
     * Returns the search string of this logging.
     *
     * @return the search string of this logging
     */
    @AutoEscape
    public String getSearchString();

    /**
     * Sets the search string of this logging.
     *
     * @param searchString the search string of this logging
     */
    public void setSearchString(String searchString);

    /**
     * Returns the category i d string of this logging.
     *
     * @return the category i d string of this logging
     */
    @AutoEscape
    public String getCategoryIDString();

    /**
     * Sets the category i d string of this logging.
     *
     * @param categoryIDString the category i d string of this logging
     */
    public void setCategoryIDString(String categoryIDString);

    /**
     * Returns the region i d string of this logging.
     *
     * @return the region i d string of this logging
     */
    @AutoEscape
    public String getRegionIDString();

    /**
     * Sets the region i d string of this logging.
     *
     * @param regionIDString the region i d string of this logging
     */
    public void setRegionIDString(String regionIDString);

    /**
     * Returns the entitlement i d string of this logging.
     *
     * @return the entitlement i d string of this logging
     */
    @AutoEscape
    public String getEntitlementIDString();

    /**
     * Sets the entitlement i d string of this logging.
     *
     * @param entitlementIDString the entitlement i d string of this logging
     */
    public void setEntitlementIDString(String entitlementIDString);

    /**
     * Returns the target o s of this logging.
     *
     * @return the target o s of this logging
     */
    @AutoEscape
    public String getTargetOS();

    /**
     * Sets the target o s of this logging.
     *
     * @param targetOS the target o s of this logging
     */
    public void setTargetOS(String targetOS);

    /**
     * Returns the fee of this logging.
     *
     * @return the fee of this logging
     */
    public int getFee();

    /**
     * Sets the fee of this logging.
     *
     * @param fee the fee of this logging
     */
    public void setFee(int fee);

    /**
     * Returns the target category of this logging.
     *
     * @return the target category of this logging
     */
    @AutoEscape
    public String getTargetCategory();

    /**
     * Sets the target category of this logging.
     *
     * @param targetCategory the target category of this logging
     */
    public void setTargetCategory(String targetCategory);

    /**
     * Returns the passel of this logging.
     *
     * @return the passel of this logging
     */
    public long getPassel();

    /**
     * Sets the passel of this logging.
     *
     * @param passel the passel of this logging
     */
    public void setPassel(long passel);

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

    public int compareTo(Logging logging);

    public int hashCode();

    public CacheModel<Logging> toCacheModel();

    public Logging toEscapedModel();

    public String toString();

    public String toXmlString();
}
