/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.fraunhofer.fokus.movepla.service.impl;

/*
 * #%L
 * govapps_data
 * $Id: LegalDetailsLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.movepla.model.LegalDetails;
import de.fraunhofer.fokus.movepla.service.base.LegalDetailsLocalServiceBaseImpl;

/**
 * The implementation of the legal details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.LegalDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.LegalDetailsLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.LegalDetailsLocalServiceUtil
 */
public class LegalDetailsLocalServiceImpl extends LegalDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.LegalDetailsLocalServiceUtil} to access the legal details local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(LegalDetailsLocalServiceImpl.class);
	
	public LegalDetails addLegalDetails(LegalDetails legalDetails) throws SystemException {
		_log.debug("addLegalDetails");
		long legalDetailsId = CounterLocalServiceUtil.increment(LegalDetails.class.getName());
		LegalDetails model =  legalDetailsPersistence.create(legalDetailsId);
		model.setAddress(legalDetails.getAddress());
		model.setEmail(legalDetails.getEmail());
		model.setUserId(legalDetails.getUserId());
		model.setCompanyId(legalDetails.getCompanyId());
		model.setCreateDate(new Date());
		model.setFax(legalDetails.getFax());
		model.setTelephone(legalDetails.getTelephone());
		model.setURL(legalDetails.getURL());
		model.setValueAddedTaxNo(legalDetails.getValueAddedTaxNo());
		return legalDetailsPersistence.update(model, true);		
	}
	
	
	public LegalDetails updateLegalDetails(LegalDetails legalDetails) throws SystemException {
		LegalDetails model =  legalDetailsPersistence.fetchByPrimaryKey(legalDetails.getLegalDetailsId());
		model.setAddress(legalDetails.getAddress());
		model.setEmail(legalDetails.getEmail());
		model.setFax(legalDetails.getFax());
		model.setTelephone(legalDetails.getTelephone());
		model.setURL(legalDetails.getURL());
		model.setValueAddedTaxNo(legalDetails.getValueAddedTaxNo());
		model.setUserId(legalDetails.getUserId());
		model.setCompanyId(legalDetails.getCompanyId());
		model.setModifiedDate(new Date());
		return legalDetailsPersistence.update(model, true);		
	}
	
	
	public LegalDetails deleteLegalDetails(LegalDetails legalDetails) throws SystemException {
		legalDetailsPersistence.remove(legalDetails);
		return legalDetails;
	}
	
	
	public LegalDetails deleteLegalDetails(long legalDetailsId) throws SystemException {
		LegalDetails model =  legalDetailsPersistence.fetchByPrimaryKey(legalDetailsId);
		legalDetailsPersistence.remove(model);		
		return model;
	}
	
	
	public List<LegalDetails> findByc(long companyId) throws SystemException {
		return legalDetailsPersistence.findByc(companyId);		
	}
	
	
	public int countLegalDetails(long companyId) throws SystemException {
		return legalDetailsPersistence.countByc(companyId);
	}	
	
}
