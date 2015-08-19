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
 * $Id: LinkLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.service.base.LinkLocalServiceBaseImpl;

/**
 * The implementation of the link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.LinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.LinkLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.LinkLocalServiceUtil
 */
public class LinkLocalServiceImpl extends LinkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.LinkLocalServiceUtil} to access the link local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(LinkLocalServiceImpl.class);
	
	public Link addLink(Link link) throws SystemException {
		_log.debug("addLink");
		long linkId = CounterLocalServiceUtil.increment(Link.class.getName());
		Link model =  linkPersistence.create(linkId);
		model.setUserId(link.getUserId());
		model.setCompanyId(link.getCompanyId());
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		model.setApplicationId(link.getApplicationId());
		model.setDisplayName(link.getDisplayName());
		model.setType(link.getType());
		model.setUrl(link.getUrl());
		return linkPersistence.update(model, true);		
	}
	
	
	public Link updateLink(Link link) throws SystemException {
		Link model =  linkPersistence.fetchByPrimaryKey(link.getLinkId());
		model.setUserId(link.getUserId());
		model.setCompanyId(link.getCompanyId());
		model.setApplicationId(link.getApplicationId());
		model.setDisplayName(link.getDisplayName());
		model.setType(link.getType());
		model.setUrl(link.getUrl());
		model.setModifiedDate(new Date());
		return linkPersistence.update(model, true);		
	}
	
	
	public Link deleteLink(Link link) throws SystemException {
		linkPersistence.remove(link);
		return link;
	}
	
	
	public Link deleteLink(long linkId) throws SystemException {
		Link model =  linkPersistence.fetchByPrimaryKey(linkId);
		linkPersistence.remove(model);	
		return model;
	}
	
	
	public List<Link> findByc(long companyId) throws SystemException {
		return linkPersistence.findByc(companyId);		
	}
	
	public List<Link> findByca(long companyId, long applicationId) throws SystemException {
		return linkPersistence.findByca(companyId, applicationId);
	}
	
	public int countLinks(long companyId) throws SystemException {
		return linkPersistence.countByc(companyId);
	}	
	
	public List<Link> getByType(int type) throws SystemException {
		return linkPersistence.findBybyType(type);
	}
	
}
