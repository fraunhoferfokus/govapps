package de.fraunhofer.fokus.movepla.model;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsModel.java 566 2014-11-13 15:22:01Z sma $
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
 * The base model interface for the LegalDetails service. Represents a row in the &quot;mvp_LegalDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.movepla.model.impl.LegalDetailsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.movepla.model.impl.LegalDetailsImpl}.
 * </p>
 *
 * @author jpa
 * @see LegalDetails
 * @see de.fraunhofer.fokus.movepla.model.impl.LegalDetailsImpl
 * @see de.fraunhofer.fokus.movepla.model.impl.LegalDetailsModelImpl
 * @generated
 */
public interface LegalDetailsModel extends BaseModel<LegalDetails> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a legal details model instance should use the {@link LegalDetails} interface instead.
     */

    /**
     * Returns the primary key of this legal details.
     *
     * @return the primary key of this legal details
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this legal details.
     *
     * @param primaryKey the primary key of this legal details
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the legal details ID of this legal details.
     *
     * @return the legal details ID of this legal details
     */
    public long getLegalDetailsId();

    /**
     * Sets the legal details ID of this legal details.
     *
     * @param legalDetailsId the legal details ID of this legal details
     */
    public void setLegalDetailsId(long legalDetailsId);

    /**
     * Returns the company ID of this legal details.
     *
     * @return the company ID of this legal details
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this legal details.
     *
     * @param companyId the company ID of this legal details
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this legal details.
     *
     * @return the user ID of this legal details
     */
    public long getUserId();

    /**
     * Sets the user ID of this legal details.
     *
     * @param userId the user ID of this legal details
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this legal details.
     *
     * @return the user uuid of this legal details
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this legal details.
     *
     * @param userUuid the user uuid of this legal details
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the create date of this legal details.
     *
     * @return the create date of this legal details
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this legal details.
     *
     * @param createDate the create date of this legal details
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this legal details.
     *
     * @return the modified date of this legal details
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this legal details.
     *
     * @param modifiedDate the modified date of this legal details
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the name of this legal details.
     *
     * @return the name of this legal details
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this legal details.
     *
     * @param name the name of this legal details
     */
    public void setName(String name);

    /**
     * Returns the value added tax no of this legal details.
     *
     * @return the value added tax no of this legal details
     */
    @AutoEscape
    public String getValueAddedTaxNo();

    /**
     * Sets the value added tax no of this legal details.
     *
     * @param valueAddedTaxNo the value added tax no of this legal details
     */
    public void setValueAddedTaxNo(String valueAddedTaxNo);

    /**
     * Returns the registration court of this legal details.
     *
     * @return the registration court of this legal details
     */
    @AutoEscape
    public String getRegistrationCourt();

    /**
     * Sets the registration court of this legal details.
     *
     * @param registrationCourt the registration court of this legal details
     */
    public void setRegistrationCourt(String registrationCourt);

    /**
     * Returns the legal form of this legal details.
     *
     * @return the legal form of this legal details
     */
    @AutoEscape
    public String getLegalForm();

    /**
     * Sets the legal form of this legal details.
     *
     * @param legalForm the legal form of this legal details
     */
    public void setLegalForm(String legalForm);

    /**
     * Returns the address of this legal details.
     *
     * @return the address of this legal details
     */
    @AutoEscape
    public String getAddress();

    /**
     * Sets the address of this legal details.
     *
     * @param address the address of this legal details
     */
    public void setAddress(String address);

    /**
     * Returns the telephone of this legal details.
     *
     * @return the telephone of this legal details
     */
    @AutoEscape
    public String getTelephone();

    /**
     * Sets the telephone of this legal details.
     *
     * @param telephone the telephone of this legal details
     */
    public void setTelephone(String telephone);

    /**
     * Returns the email of this legal details.
     *
     * @return the email of this legal details
     */
    @AutoEscape
    public String getEmail();

    /**
     * Sets the email of this legal details.
     *
     * @param email the email of this legal details
     */
    public void setEmail(String email);

    /**
     * Returns the u r l of this legal details.
     *
     * @return the u r l of this legal details
     */
    @AutoEscape
    public String getURL();

    /**
     * Sets the u r l of this legal details.
     *
     * @param URL the u r l of this legal details
     */
    public void setURL(String URL);

    /**
     * Returns the fax of this legal details.
     *
     * @return the fax of this legal details
     */
    @AutoEscape
    public String getFax();

    /**
     * Sets the fax of this legal details.
     *
     * @param fax the fax of this legal details
     */
    public void setFax(String fax);

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

    public int compareTo(LegalDetails legalDetails);

    public int hashCode();

    public CacheModel<LegalDetails> toCacheModel();

    public LegalDetails toEscapedModel();

    public String toString();

    public String toXmlString();
}
