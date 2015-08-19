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
 * $Id: MultiMediaLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import java.io.File;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.service.base.MultiMediaLocalServiceBaseImpl;

/**
 * The implementation of the multi media local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.MultiMediaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.MultiMediaLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.MultiMediaLocalServiceUtil
 */
public class MultiMediaLocalServiceImpl extends MultiMediaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.MultiMediaLocalServiceUtil} to access the multi media local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(MultiMediaLocalServiceImpl.class);
	
	public MultiMedia addMultiMedia(MultiMedia multiMedia) throws SystemException {
		try {
			_log.debug(multiMedia.getUserId());
			_log.debug(multiMedia.getImageId());

			long multiMediaId = CounterLocalServiceUtil.increment(MultiMedia.class.getName());
			MultiMedia model =  multiMediaPersistence.create(multiMediaId);
			model.setUserId(multiMedia.getUserId());
			model.setCompanyId(multiMedia.getCompanyId());
			model.setCreateDate(new Date());
			model.setModifiedDate(new Date());
			model.setApplicationId(multiMedia.getApplicationId());
			model.setName(multiMedia.getName());
			model.setType(multiMedia.getType());
			model.setImageId(multiMedia.getImageId());
			return multiMediaPersistence.update(model, true);
		} catch (Exception e) {
			_log.info(e.toString());
		}
		return null;
	}

	
	public MultiMedia addMultiMedia(MultiMedia multiMedia, File imageFile) throws SystemException, PortalException {
		long multiMediaId = CounterLocalServiceUtil.increment(MultiMedia.class.getName());
		MultiMedia model =  multiMediaPersistence.create(multiMediaId);
		model.setUserId(multiMedia.getUserId());
		model.setCompanyId(multiMedia.getCompanyId());
		model.setCreateDate(new Date());
		model.setModifiedDate(new Date());
		model.setApplicationId(multiMedia.getApplicationId());
		model.setName(multiMedia.getName());
		model.setType(multiMedia.getType());
		try {
			
//			DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, imageFile, serviceContext);
//			DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, imageFile.getName(), mimeType, title, description, changeLog, imageFile, serviceContext);
			byte[] imageBytes = null;
			imageBytes = FileUtil.getBytes(imageFile);
			model.setImageId(counterLocalService.increment());
			_log.debug("addLink::imageBytes.length: "  + imageBytes.length);
			saveImages(model.getImageId(), imageFile, imageBytes);
		} catch (Exception e) {
			_log.info(e.toString());
		}
		return multiMediaPersistence.update(model, true);
	}
	
	
	public MultiMedia updateMultiMedia(MultiMedia multiMedia, File imageFile) throws SystemException {
		MultiMedia model =  multiMediaPersistence.fetchByPrimaryKey(multiMedia.getMultiMediaId());
		model.setUserId(multiMedia.getUserId());
		model.setCompanyId(multiMedia.getCompanyId());
		model.setApplicationId(multiMedia.getApplicationId());
		model.setType(multiMedia.getType());
		model.setModifiedDate(new Date());
		try {
			byte[] imageBytes = null;
			imageBytes = FileUtil.getBytes(imageFile);
			model.setImageId(counterLocalService.increment());
			_log.debug("addLink::imageBytes.length: "  + imageBytes.length);
			_log.debug("imageFile.getName(): "  + imageFile.getName());
			model.setName(imageFile.getName());
			
			saveImages(model.getImageId(), imageFile, imageBytes);
		} catch (Exception e) {
			_log.info(e.toString());
		}
		return multiMediaPersistence.update(model, true);		
	}
	
	
	public MultiMedia deleteMultiMedia(MultiMedia multiMedia) throws SystemException, PortalException {
		try {
			_log.debug("deleteMultiMedia::ImageId: " + multiMedia.getImageId());
			
			_log.debug("deleteFileEntries: " + multiMediaPersistence.findByimage(multiMedia.getImageId()).size() );
			if (multiMediaPersistence.findByimage(multiMedia.getImageId()).size() == 1) {
				DLAppLocalServiceUtil.deleteFileEntry(multiMedia.getImageId());
			}
//			Image image = ImageLocalServiceUtil.fetchImage(multiMedia.getImageId());
//			ImageLocalServiceUtil.deleteImage(image);
//			ImageLocalServiceUtil.deleteImage(multiMedia.getImageId());
			multiMediaPersistence.remove(multiMedia);
			
//			Image image = getImage(imageId);

//			imagePersistence.remove( multiMedia.getImageId());

//			Hook hook =  com.liferay.portal.image.HookFactory.getInstance();

//			hook.deleteImage(image);

		} catch (Exception e) {
			_log.info(e.toString());
		}
		return multiMedia;
	}
	
	
	public MultiMedia deleteMultiMedia(long multiMediaId) throws SystemException, PortalException {
		try {
			MultiMedia model =  multiMediaPersistence.fetchByPrimaryKey(multiMediaId);
			_log.debug("deleteMultiMedia::ImageId: " + model.getImageId());
			if (multiMediaPersistence.findByimage(model.getImageId()).size() ==1) {
				DLAppLocalServiceUtil.deleteFileEntry(model.getImageId());
			}
//			Image image = ImageLocalServiceUtil.fetchImage(model.getImageId());
//			ImageLocalServiceUtil.deleteImage(model.getImageId());
//			ImageLocalServiceUtil.deleteImage(image);
			multiMediaPersistence.remove(model);		
			return model;
		} catch (Exception e) {
			_log.info(e.toString());
		}
		return null;
	}
	
	
	public List<MultiMedia> findByc(long companyId) throws SystemException {
		return multiMediaPersistence.findByc(companyId);		
	}
	
	public List<MultiMedia> findByca(long companyId, long applicationId) throws SystemException {
		return multiMediaPersistence.findByca(companyId, applicationId);		
	}

	public List<MultiMedia> findBycai(long companyId, long applicationId, long imageId) throws SystemException {
		return multiMediaPersistence.findBycai(companyId, applicationId, imageId);		
	}
	
	public List<MultiMedia> findByImage(long imageId) throws SystemException {
		return multiMediaPersistence.findByimage(imageId);		
	}
	

	public int countMultiMedias(long companyId) throws SystemException {
		return multiMediaPersistence.countByc(companyId);
	}
	
//	IGImage addImage = IGImageLocalServiceUtil.addImage(userId, folderId, imageName, description, file, contentType, new ServiceContext());
	
	protected void saveImages(long imageId, File imageFile,	byte[] imageBytes) throws PortalException, SystemException {
		if ((imageFile != null) && (imageBytes != null)) {
			ImageLocalServiceUtil.updateImage(imageId, imageBytes);
		}
	}	
}
