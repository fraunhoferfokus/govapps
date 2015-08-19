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
 * $Id: ApplicationLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;


import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import de.fraunhofer.fokus.movepla.Constants;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.model.RelatedApplications;
import de.fraunhofer.fokus.movepla.model.impl.LinkImpl;
import de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl;
import de.fraunhofer.fokus.movepla.portlets.AppConstants;
import de.fraunhofer.fokus.movepla.portlets.E_Stati;
import de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.LinkLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.MultiMediaLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.base.ApplicationLocalServiceBaseImpl;
//import java.util.Calendar;
//import com.liferay.portal.service.ServiceContextFactory;
//import com.liferay.portlet.documentlibrary.model.DLFileEntry;
//import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
//import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
//import de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl;
import de.fraunhofer.fokus.movepla.util.CustomComparatorUtil;

/**
 * The implementation of the application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.ApplicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.ApplicationLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil
 */
public class ApplicationLocalServiceImpl extends ApplicationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil} to access the application local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(ApplicationLocalServiceImpl.class);

	
	public Application addApplication(Application application) throws SystemException {
		try {
		long applicationID = CounterLocalServiceUtil.increment(Application.class.getName());
		
		_log.debug("addApplication:applicationID: " + applicationID);
		_log.debug("application.getCompanyId(): " + application.getCompanyId());
		_log.debug("application.getDescription(): " + application.getDescription());
		_log.debug("application.getFee(): " + application.getFee());
		_log.debug("application.getTargetOS(): " + application.getTargetOS());
		_log.debug("application.getTargetCategory(): " + application.getTargetCategory());
		_log.debug("application.getLegalDetails(): " + application.getLegalDetails());
		_log.debug("application.getDeveloper(): " + application.getDeveloper());
		_log.debug("application.getMinTargetOSVersion(): " + application.getMinTargetOSVersion());
		_log.debug("application.getName(): " + application.getName());
		_log.debug("application.getSize(): " + application.getSize());
		_log.debug("application.getUserId(): " + application.getUserId());
		_log.debug("application.getVersion(): " + application.getVersion());
		_log.debug("application.getVersionInformation(): " + application.getVersionInformation());

		Application model =  applicationPersistence.create(applicationID);
		model.setCompanyId(application.getCompanyId());
		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setLifeCycleStatus(Constants.APPLICATION_STATUS_SUBMITTED);
//		model.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");
		model.setLogoImageId(application.getLogoImageId());
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
//		model.setVerifiedDate(application.getVerifiedDate());
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());

		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());
		model.setLegalDetails(application.getLegalDetails());
		
        if (application.getUseOpenData() == 1) {
        	model.setUseOpenData(application.getUseOpenData());
        	model.setLicense(application.getLicense());
        	model.setSector(application.getSector());
        }

		
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.reindex(model);
        Application res = applicationPersistence.update(model, true);	
		_log.debug("getApplicationId: " +res.getApplicationId());
		_log.debug("getCompanyId: " +res.getCompanyId());
		return res;
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			_log.info("application.getCompanyId(): " + application.getCompanyId());
			_log.info("application.getDescription(): " + application.getDescription());
			_log.info("application.getFee(): " + application.getFee());
			_log.info("application.getTargetOS(): " + application.getTargetOS());
			_log.info("application.getTargetCategory(): " + application.getTargetCategory());
			_log.info("application.getLegalDetails(): " + application.getLegalDetails());
			_log.info("application.getDeveloper(): " + application.getDeveloper());
			_log.info("application.getMinTargetOSVersion(): " + application.getMinTargetOSVersion());
			_log.info("application.getName(): " + application.getName());
			_log.info("application.getSize(): " + application.getSize());
			_log.info("application.getUserId(): " + application.getUserId());
			_log.info("application.getVersion(): " + application.getVersion());
			_log.info("application.getVersionInformation(): " + application.getVersionInformation());
			e.printStackTrace();
		}
		return null;        
	}
	
	public Application clone(long oldApplicationId) throws SystemException {
		try {
			_log.debug("clone::oldApplicationId: " + oldApplicationId);
			long newApplicationId = CounterLocalServiceUtil.increment(Application.class.getName());
			Application model =  applicationPersistence.create(newApplicationId);
//			Application model =  new ApplicationImpl();

			Application application = applicationPersistence.fetchByPrimaryKey(oldApplicationId);

			model.setCompanyId(application.getCompanyId());
			model.setCreateDate(new Date());
			model.setDescription(application.getDescription());
			model.setFee(application.getFee());
			model.setLifeCycleStatus(Constants.APPLICATION_STATUS_SUBMITTED);
//			model.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");
			model.setLogoImageId(application.getLogoImageId());
			model.setMinTargetOSVersion(application.getMinTargetOSVersion());
			model.setModifiedDate(new Date());
			model.setName(application.getName());
			model.setSize(application.getSize());
			model.setUserId(application.getUserId());
//			model.setVerifiedDate(application.getVerifiedDate());
			model.setVersion(application.getVersion());
			model.setVersionInformation(application.getVersionInformation());

			model.setRegionString(application.getRegionString());
			model.setCategoryString(application.getCategoryString());
			
			model.setTargetCategory(application.getTargetCategory());
			model.setTargetOS(application.getTargetOS());
			model.setDeveloper(application.getDeveloper());
			model.setFirstPublishingDate(application.getFirstPublishingDate());
			model.setLastModifiedDate(application.getLastModifiedDate());
			model.setLegalDetails(application.getLegalDetails());
			_log.debug("application.getRelatedApplicationId(): " + application.getRelatedApplicationId());
					
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RelatedApplications.class);
			Criterion criterion = null;
			
			criterion = RestrictionsFactoryUtil.eq("applicationId", oldApplicationId);
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("applicationId2", oldApplicationId));
			
			dynamicQuery.add(criterion);
						
			List<RelatedApplications> relatedApplications = RelatedApplicationsLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			if (relatedApplications.size() == 0) {
				RelatedApplications _relatedApplications =  RelatedApplicationsLocalServiceUtil.createRelatedApplications(oldApplicationId, newApplicationId);								
			}

			
			
			if (application.getRelatedApplicationId().length() == 0 ) {
				model.setRelatedApplicationId(String.valueOf(oldApplicationId));
				application.setRelatedApplicationId(String.valueOf(newApplicationId));
		        applicationPersistence.update(application, true);
			} else {
				String relatedApplicationIdsString  = application.getRelatedApplicationId();
				String [] relatedApplicationIds = relatedApplicationIdsString.split(";");
				long [] relatedApplicationIdsLong = new long[relatedApplicationIds.length];

				for (int i = 0; i<relatedApplicationIds.length; i++) {
					relatedApplicationIdsLong[i] = Long.parseLong(relatedApplicationIds[i]);
					Application app = applicationLocalService.getApplication(Long.parseLong(relatedApplicationIds[i]));
					app.setRelatedApplicationId(app.getRelatedApplicationId() + ";" + String.valueOf(newApplicationId));
			        applicationPersistence.update(app, true);
				}
				
				application.setRelatedApplicationId(relatedApplicationIdsString + ";" + String.valueOf(newApplicationId));
		        applicationPersistence.update(application, true);

		        relatedApplicationIdsString  += ";" + String.valueOf(oldApplicationId);				
				model.setRelatedApplicationId(relatedApplicationIdsString);
			}
			_log.debug("model.getRelatedApplicationId(): " + model.getRelatedApplicationId());
			
			List<Application_Entitlement> applicationEntitlements =  applicationPersistence.getApplication_Entitlements(oldApplicationId);
			for (Application_Entitlement ae : applicationEntitlements) {
				application_EntitlementLocalService.addApplication_Entitlement(ae.getUserId(), ae.getCompanyId(), newApplicationId, ae.getEntitlementId(), ae.getName(), ae.getMotivation());
			}
			
			List<Link> applicationLinks =  applicationPersistence.getLinks(oldApplicationId);
			for (Link oldLink : applicationLinks) {
				Link link = new LinkImpl();
				link.setApplicationId(newApplicationId);
				link.setCompanyId(oldLink.getCompanyId());
				link.setDisplayName(oldLink.getDisplayName());
				link.setType(oldLink.getType());
				link.setUrl(oldLink.getUrl());
				link.setUserId(oldLink.getUserId());				
				LinkLocalServiceUtil.addLink(link);
			}

			List <MultiMedia> medias = applicationPersistence.getMultiMedias(oldApplicationId);
			for (MultiMedia media : medias) {
				MultiMedia multiMedia = new MultiMediaImpl();
				multiMedia.setApplicationId(newApplicationId);
				multiMedia.setCompanyId(media.getCompanyId());
				multiMedia.setImageId(media.getImageId());
				multiMedia.setName(media.getName());
				multiMedia.setType(media.getType());
				multiMedia.setUserId(media.getUserId());
				MultiMediaLocalServiceUtil.addMultiMedia(multiMedia);
			}
			
			
			applicationPersistence.setCategories(newApplicationId, applicationPersistence.getCategories(oldApplicationId));
			applicationPersistence.setLanguages(newApplicationId, applicationPersistence.getLanguages(oldApplicationId));
			applicationPersistence.setRegions(newApplicationId, applicationPersistence.getRegions(oldApplicationId));

	        // Indexer
	        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	        indexer.reindex(model);
	        Application res = applicationPersistence.update(model, true);	
			_log.debug("getApplicationId: " +res.getApplicationId());
			_log.debug("getCompanyId: " +res.getCompanyId());
			return res;
			
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;        
	}	
		

	
	public Application clone4NewVersion(long oldApplicationId) throws SystemException {
		try {
			_log.debug("clone4NewVersion::oldApplicationId: " + oldApplicationId);
			long newApplicationId = CounterLocalServiceUtil.increment(Application.class.getName());
			_log.debug("clone4NewVersion::newApplicationId: " + newApplicationId);
			Application newApplication =  applicationPersistence.create(newApplicationId);
//			Application model =  new ApplicationImpl();

			Application oldApplication = applicationPersistence.fetchByPrimaryKey(oldApplicationId);

			newApplication.setCompanyId(oldApplication.getCompanyId());
			newApplication.setCreateDate(oldApplication.getCreateDate());
			newApplication.setDescription(oldApplication.getDescription());
			newApplication.setFee(oldApplication.getFee());
//			model.setLifeCycleStatus(application.getLifeCycleStatus());
			newApplication.setLifeCycleStatus(-3);
			newApplication.setLogoImageId(oldApplication.getLogoImageId());
			newApplication.setMinTargetOSVersion(oldApplication.getMinTargetOSVersion());
			newApplication.setModifiedDate(oldApplication.getModifiedDate());
			newApplication.setName(oldApplication.getName());
			newApplication.setSize(oldApplication.getSize());
			newApplication.setUserId(oldApplication.getUserId());
//			model.setVerifiedDate(application.getVerifiedDate());
			newApplication.setVersion(oldApplication.getVersion());
			newApplication.setVersionInformation(oldApplication.getVersionInformation());

			newApplication.setRegionString(oldApplication.getRegionString());
			newApplication.setCategoryString(oldApplication.getCategoryString());
			
			newApplication.setTargetCategory(oldApplication.getTargetCategory());
			newApplication.setTargetOS(oldApplication.getTargetOS());
			newApplication.setDeveloper(oldApplication.getDeveloper());
			newApplication.setFirstPublishingDate(oldApplication.getFirstPublishingDate());
			newApplication.setLastModifiedDate(oldApplication.getLastModifiedDate());
			newApplication.setLegalDetails(oldApplication.getLegalDetails());
			_log.debug("application.getRelatedApplicationId(): " + oldApplication.getRelatedApplicationId());
			newApplication.setRelatedApplicationId(oldApplication.getRelatedApplicationId());
			
			newApplication.setOldVersionId(oldApplicationId);
			
			
			oldApplication.setNewVersionId(newApplicationId);
			oldApplication.setLifeCycleStatus(6);
	        applicationPersistence.update(oldApplication, true);
	        
			List<Application_Entitlement> applicationEntitlements =  applicationPersistence.getApplication_Entitlements(oldApplicationId);
			for (Application_Entitlement ae : applicationEntitlements) {
				application_EntitlementLocalService.addApplication_Entitlement(ae.getUserId(), ae.getCompanyId(), newApplicationId, ae.getEntitlementId(), ae.getName(), ae.getMotivation());
			}
			
			List<Link> applicationLinks =  applicationPersistence.getLinks(oldApplicationId);
			for (Link oldLink : applicationLinks) {
				Link link = new LinkImpl();
				link.setApplicationId(newApplicationId);
				link.setCompanyId(oldLink.getCompanyId());
				link.setDisplayName(oldLink.getDisplayName());
				link.setType(oldLink.getType());
				link.setUrl(oldLink.getUrl());
				link.setUserId(oldLink.getUserId());				
				LinkLocalServiceUtil.addLink(link);
			}

			List <MultiMedia> medias = applicationPersistence.getMultiMedias(oldApplicationId);
			for (MultiMedia media : medias) {
				MultiMedia multiMedia = new MultiMediaImpl();
				multiMedia.setApplicationId(newApplicationId);
				multiMedia.setCompanyId(media.getCompanyId());
				multiMedia.setImageId(media.getImageId());
				multiMedia.setName(media.getName());
				multiMedia.setType(media.getType());
				multiMedia.setUserId(media.getUserId());
				MultiMediaLocalServiceUtil.addMultiMedia(multiMedia);
			}
			
			
			applicationPersistence.setCategories(newApplicationId, applicationPersistence.getCategories(oldApplicationId));
			applicationPersistence.setLanguages(newApplicationId, applicationPersistence.getLanguages(oldApplicationId));
			applicationPersistence.setRegions(newApplicationId, applicationPersistence.getRegions(oldApplicationId));

	        // Indexer
	        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	        indexer.reindex(newApplication);
	        Application res = applicationPersistence.update(newApplication, true);	
			_log.debug("getApplicationId: " +res.getApplicationId());
			_log.debug("getCompanyId: " +res.getCompanyId());
			return res;
			
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;        
	}		
	
	
	public Application addApplication(Application application, File imageFile) throws SystemException, PortalException {
		try {
		long applicationID = CounterLocalServiceUtil.increment(Application.class.getName());

		Application model =  applicationPersistence.create(applicationID);
		model.setCompanyId(application.getCompanyId());
		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setLifeCycleStatus(Constants.APPLICATION_STATUS_SUBMITTED);
//		model.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");

		try {
			_log.debug("imageFile.getName(): " + imageFile.getName());
			byte[] imageBytes = null;
			imageBytes = FileUtil.getBytes(imageFile);
			if(imageBytes!=null) {
				_log.debug("addApplication::imageBytes.length: "  + imageBytes.length);
					if (imageBytes.length > 0) {
						model.setLogoImageId(counterLocalService.increment());
						saveImages(model.getLogoImageId(), imageFile, imageBytes);
				}
			
			} else {
				_log.debug("addApplication::imageBytes == null! ");				
			}
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
//		model.setVerifiedDate(application.getVerifiedDate());
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());

		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());
		model.setLegalDetails(application.getLegalDetails());
		
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.reindex(model);
        Application res = applicationPersistence.update(model, true);	
		_log.debug("getApplicationId: " +res.getApplicationId());
		_log.debug("getCompanyId: " +res.getCompanyId());
		return res;
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;        
	}
	
	
	public Application addApplication(Application application, 
			File imageFile, 
			List<Category> categories,
			List<Language> languages,
			List<Region> regions) throws SystemException, PortalException {
		try {
		long applicationID = CounterLocalServiceUtil.increment(Application.class.getName());

		Application model =  applicationPersistence.create(applicationID);
		model.setCompanyId(application.getCompanyId());
		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());
		model.setLifeCycleStatus(Constants.APPLICATION_STATUS_SUBMITTED);
//		model.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");
		try {
			_log.debug("imageFile.getName(): " + imageFile.getName());
			byte[] imageBytes = null;
			imageBytes = FileUtil.getBytes(imageFile);			
			_log.debug("addApplication::imageBytes.length: "  + imageBytes.length);
			if (imageBytes.length > 0) {
				model.setLogoImageId(counterLocalService.increment());
				saveImages(model.getLogoImageId(), imageFile, imageBytes);				
			}
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
		}
		_log.debug("addApplication::model.getLogoImageId(): "  + model.getLogoImageId());
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
//		model.setVerifiedDate(application.getVerifiedDate());
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());
		
		Application _app =  applicationPersistence.update(model, true);
		applicationPersistence.addCategories(_app.getApplicationId(), categories);
		applicationPersistence.addLanguages(_app.getApplicationId(), languages);
		applicationPersistence.addRegions(_app.getApplicationId(), regions);
		
		return _app;
		} catch (Exception e) {
			_log.debug("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;		
	}
	
	public void addCategories2Application(Application application, long[] categoryPks) throws SystemException {
		_log.debug("categoryPks: " + categoryPks.length);
		applicationPersistence.addCategories(application.getApplicationId(), categoryPks);
		
		try {
			_log.debug("application: " + application.getName());
			String categoryString = application.getCategoryString(); 
			for (int i=0; i<categoryPks.length; i++) {
				long categoryId = categoryPks[i];
				if (categoryId != 0) {
					Category category = categoryLocalService.getCategory(categoryId);
					String categoryName =  category.getCategoryName();
					if (categoryString.length() == 0 ) {
						categoryString = categoryName;
					} else {
						categoryString = categoryString +", " + categoryName;				
					}					
				}
			}
			_log.debug("categoryString: " + categoryString);
			application.setCategoryString(categoryString);
			applicationPersistence.update(application, true);
			_log.debug("application.getLogoImageId(): " + application.getLogoImageId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
	}	
	
	public void addCategory2Application(Application application, long categoryPK) throws SystemException {
		applicationPersistence.addCategory(application.getApplicationId(), categoryPK);		
		try {
			_log.debug("application: " + application.getName());
			String categoryString = application.getCategoryString(); 
			Category category = categoryLocalService.getCategory(categoryPK);
			String categoryName =  category.getCategoryName();
			if (categoryString.length() == 0 ) {
				categoryString = categoryName;
			} else {
				categoryString = categoryString +", " + categoryName;				
			}
			_log.debug("categoryString: " + categoryString);
			application.setCategoryString(categoryString);
			applicationPersistence.update(application, true);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}	

	
	public void addLanguages2Application(long applicationId, long[] languagePks) throws SystemException {
		applicationPersistence.addLanguages(applicationId, languagePks);		
		
	}	
	
	public void addLanguage2Application(Application application, long languagePK) throws SystemException {
		applicationPersistence.addLanguage(application.getApplicationId(), languagePK);		
		
	}	

	public void addRegion2Application(Application application, long[] regionPks) throws SystemException {
		_log.debug("regionPks: " + regionPks.length);
		applicationPersistence.addRegions(application.getApplicationId(), regionPks);		
		try {
//			Application application = applicationPersistence.fetchByPrimaryKey(applicationId);
			String regionString = application.getRegionString();
			for (int i=0; i<regionPks.length; i++) {
				long regionId = regionPks[i];
				if (regionId != 0) {
					Region region = regionLocalService.getRegion(regionId);
					String regionName =  region.getName();
					if (regionString.length() == 0 ) {
						regionString = regionName;
					} else {
						regionString = regionString +", " + regionName;				
					}					
				}
			}
			_log.debug("regionString: " + regionString);
			application.setRegionString(regionString);
			applicationPersistence.update(application, true);
			
			
		} catch (PortalException e) {
			e.printStackTrace();
		}		
	}	

	public void addRegionApplication(Application application, long regionPK) throws SystemException {
		applicationPersistence.addRegion(application.getApplicationId(), regionPK);
		try {
//			Application application = applicationPersistence.fetchByPrimaryKey(applicationId);
			String regionString = application.getRegionString();
			Region region = regionLocalService.getRegion(regionPK);
			String regionName =  region.getName();
			if (regionString.length() == 0 ) {
				regionString = regionName;
			} else {
				regionString = regionString +", " + regionName;				
			}
			application.setRegionString(regionString);
			applicationPersistence.update(application, true);
		} catch (PortalException e) {
			e.printStackTrace();
		}		
	}	
	
	public Application deleteApplication(Application application) throws SystemException {
		_log.debug("deleteApplication: " + application.getApplicationId());
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        try {
			indexer.delete(application);
		} catch (SearchException e) {
			e.printStackTrace();
		}
		applicationPersistence.remove(application);	
        return application;
	}
	
	public void developerDeleteApplication(Application application) throws SystemException {
		_log.debug("deleteApplication: " + application.getApplicationId());
		if (application.getLifeCycleStatus() >= 4) {
			Application newApp = clone4NewVersion(application.getApplicationId());
		}
		application.setLifeCycleStatus(Constants.APPLICATION_STATUS_DELETED);
//		application.setLifeCycleStatusString("gelöscht - warten auf Freigabe");
		applicationPersistence.update(application, true);
	}
	
	public void developerDeleteApplication(long applicationId) throws SystemException {
		_log.debug("developerDeleteApplication: " + applicationId);
		Application application = applicationPersistence.fetchByPrimaryKey(applicationId);
		developerDeleteApplication(application);
	}
/*	
	public void developerUpdateApplicationStatus(Application application) throws SystemException {
		developerUpdateApplicationStatus(application.getApplicationId());
	}

	public void developerUpdateApplicationStatus(long applicationId) throws SystemException {
		_log.debug("developerUpdateApplicationStatus: " + applicationId);
		Application application = applicationPersistence.fetchByPrimaryKey(applicationId);
		application.setLifeCycleStatus(Constants.APPLICATION_STATUS_RESUBMITTED);
//		application.setLifeCycleStatusString("geändert - warten auf Freigabe");
		applicationPersistence.update(application, true);
	}
*/
	public void deleteApplication(long companyId, long applicationId) throws SystemException, PortalException {
		_log.debug("deleteApplication: " + applicationId);
		Application application = applicationPersistence.fetchByPrimaryKey(applicationId);
		
//		applicationPersistence.clearCategories(applicationId);
//		applicationPersistence.clearLanguages(applicationId);
//		applicationPersistence.clearRegions(applicationId);
		
		List<MultiMedia> multiMedias = multiMediaPersistence.findByapp(applicationId);
		for (MultiMedia multiMedia: multiMedias) {
			MultiMediaLocalServiceUtil.deleteMultiMedia(multiMedia);
		}
		
		List<Link> links = linkPersistence.findByapp(applicationId);
		for (Link link: links) {
			linkPersistence.remove(link);
		}
		
		List<Application_Entitlement> applicationEntitlements = application_EntitlementPersistence.findByca(companyId, applicationId);
		for (Application_Entitlement applicationEntitlement: applicationEntitlements) {
			application_EntitlementPersistence.remove(applicationEntitlement);
		}
		
		String relatedApplicationId = application.getRelatedApplicationId();
		if (relatedApplicationId.length() > 0) {
			String [] relatedApplicationIds = relatedApplicationId.split(";");
			long [] relatedApplicationIdsLong = new long[relatedApplicationIds.length];

			for (int i = 0; i<relatedApplicationIds.length; i++) {
				relatedApplicationIdsLong[i] = Long.parseLong(relatedApplicationIds[i]);
				Application app = applicationLocalService.getApplication(Long.parseLong(relatedApplicationIds[i]));
				String oldRelatedApplicationString = app.getRelatedApplicationId();
				String newRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, String.valueOf(applicationId));
				app.setRelatedApplicationId(newRelatedApplicationString);
		        applicationPersistence.update(app, true);
			}			
		}
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.delete(application);
		applicationPersistence.remove(application);
        
	}
	

	public void deleteOldApplication(long oldApplicationId, long newApplicationId) throws SystemException, PortalException {
		_log.debug("deleteOldApplication(long " + oldApplicationId +", long " + newApplicationId + ")");
		Application oldApplication = applicationPersistence.fetchByPrimaryKey(oldApplicationId);
		Application newApplication = applicationPersistence.fetchByPrimaryKey(newApplicationId);
		
//		applicationPersistence.clearCategories(applicationId);
//		applicationPersistence.clearLanguages(applicationId);
//		applicationPersistence.clearRegions(applicationId);
		
		List<MultiMedia> multiMedias = multiMediaPersistence.findByapp(oldApplicationId);
		for (MultiMedia multiMedia: multiMedias) {
			MultiMediaLocalServiceUtil.deleteMultiMedia(multiMedia);
		}
		
		List<Link> links = linkPersistence.findByapp(oldApplicationId);
		for (Link link: links) {
			linkPersistence.remove(link);
		}
		
		List<Application_Entitlement> applicationEntitlements = application_EntitlementPersistence.findByca(10154, oldApplicationId);
		for (Application_Entitlement applicationEntitlement: applicationEntitlements) {
			application_EntitlementPersistence.remove(applicationEntitlement);
		}
		
		String relatedApplicationId = oldApplication.getRelatedApplicationId();
		
		newApplication.setRelatedApplicationId(relatedApplicationId);
        applicationPersistence.update(newApplication, true);
		
		if (relatedApplicationId.length() > 0) {
			String [] relatedApplicationIds = relatedApplicationId.split(";");
			long [] relatedApplicationIdsLong = new long[relatedApplicationIds.length];

			for (int i = 0; i<relatedApplicationIds.length; i++) {
				relatedApplicationIdsLong[i] = Long.parseLong(relatedApplicationIds[i]);
				Application app = applicationLocalService.getApplication(Long.parseLong(relatedApplicationIds[i]));
				String oldRelatedApplicationString = app.getRelatedApplicationId();
				String newRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, String.valueOf(oldApplicationId));
				if (newRelatedApplicationString.length() > 0) {
					newRelatedApplicationString = newRelatedApplicationString + ";" + String.valueOf(newApplicationId);
				} else {
					newRelatedApplicationString = String.valueOf(newApplicationId);
				}
				app.setRelatedApplicationId(newRelatedApplicationString);
		        applicationPersistence.update(app, true);
		        
		        long new_AppId = 0;
		        new_AppId = app.getNewVersionId();
		        if (new_AppId > 0) {
		        	Application newApp = applicationLocalService.getApplication(new_AppId);
					String newAppOldRelatedApplicationString = newApp.getRelatedApplicationId();
					String newAppNewRelatedApplicationString = replaceRelatedIds(newAppOldRelatedApplicationString, String.valueOf(oldApplicationId));
					if (newAppNewRelatedApplicationString.length() > 0) {
						newAppNewRelatedApplicationString = newAppNewRelatedApplicationString + ";" + String.valueOf(newApplicationId);
					} else {
						newAppNewRelatedApplicationString = String.valueOf(newApplicationId);
					}
					newApp.setRelatedApplicationId(newAppNewRelatedApplicationString);
			        applicationPersistence.update(newApp, true);		        	
		        }
			}
		}
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.delete(oldApplication);
		applicationPersistence.remove(oldApplication);   
	}
	
	
	public Application updateApplication(Application application, File imageFile) throws SystemException, PortalException {
		
		Application model =  applicationPersistence.fetchByPrimaryKey(application.getApplicationId());
		model.setCompanyId(application.getCompanyId());
//		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());
		model.setLifeCycleStatus(application.getLifeCycleStatus());
//		model.setLifeCycleStatusString("geändert - warten auf Freigabe");

		try {
			_log.debug("imageFile.getName(): " + imageFile.getName());
			byte[] imageBytes = null;
			imageBytes = FileUtil.getBytes(imageFile);		
			
			if(imageBytes!=null) {
				_log.debug("updateApplication::imageBytes.length: "  + imageBytes.length);
				if (imageBytes.length > 0) {
					model.setLogoImageId(counterLocalService.increment());
					saveImages(model.getLogoImageId(), imageFile, imageBytes);				
				} else {
					_log.debug("updateApplication::imageBytes.length == 0");
					_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
//					model.setLogoImageId(model.getLogoImageId());
				} 
			} else {
				_log.debug("updateApplication::imageBytes == null! ");	
				_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
//				model.setLogoImageId(model.getLogoImageId());
			}
		} catch (Exception e) {
			_log.debug(e.getMessage());
		}
		_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
		if (application.getLifeCycleStatus() >= Constants.APPLICATION_STATUS_VERIFIED ) {
			model.setVerifiedDate(application.getVerifiedDate());			
		}
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());
		model.setLegalDetails(application.getLegalDetails());
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.reindex(model);
		model = applicationPersistence.update(model, true);
		_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
		return model;			
	}
	
	
	public Application updateApplicationFileEntry(Application application, FileEntry tempImageFileEntry) throws SystemException, PortalException {
		
		Application model =  applicationPersistence.fetchByPrimaryKey(application.getApplicationId());
		model.setCompanyId(application.getCompanyId());
//		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());

		model.setLifeCycleStatus(application.getLifeCycleStatus());

		if(tempImageFileEntry!=null) {
			model.setLogoImageId(tempImageFileEntry.getFileEntryId());
		}
		_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
		if (application.getLifeCycleStatus() >= Constants.APPLICATION_STATUS_VERIFIED ) {
			model.setVerifiedDate(application.getVerifiedDate());			
		}
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());
		model.setLegalDetails(application.getLegalDetails());
		
		// setRelatedApplicationId
		String oldRelatedApplicationIdsString = model.getRelatedApplicationId().trim();
		String newRelatedApplicationIdsString = application.getRelatedApplicationId().trim();
		_log.debug("oldRelatedApplicationIds: "+ oldRelatedApplicationIdsString);
		_log.debug("newRelatedApplicationIds: "+ newRelatedApplicationIdsString);
	
		String[]  oldRelatedApplicationIdsArray = oldRelatedApplicationIdsString.split(";");
		String[]  newRelatedApplicationIdsArray = newRelatedApplicationIdsString.split(";");
		
		_log.debug("oldRelatedApplicationIdsArray.length: "+ oldRelatedApplicationIdsArray.length);
		_log.debug("newRelatedApplicationIdsArray.length: "+ newRelatedApplicationIdsArray.length);
			
		Vector<String> oldRelatedApplicationIdsVector = new Vector<String>();
		Vector<String> newRelatedApplicationIdsVector = new Vector<String>();
		Vector<String> removeRelatedApplicationIdsVector = new Vector<String>();
			
		HashSet<String> maximumRelatedApplicationIdsSet = new HashSet<String>();
		HashSet<String> procesedRelatedApplicationIdsSet = new HashSet<String>();
		procesedRelatedApplicationIdsSet.add(String.valueOf(application.getApplicationId()));
		maximumRelatedApplicationIdsSet.add(String.valueOf(application.getApplicationId()));
			
		if (oldRelatedApplicationIdsArray.length > 0) {
			for (int i=0; i<oldRelatedApplicationIdsArray.length; i++) {
				if (oldRelatedApplicationIdsArray[i].length() > 0) {
					oldRelatedApplicationIdsVector.add(oldRelatedApplicationIdsArray[i]);
					maximumRelatedApplicationIdsSet.add(oldRelatedApplicationIdsArray[i]);
				}
			}
		}
		if (newRelatedApplicationIdsArray.length > 0) {
			for (int i=0; i<newRelatedApplicationIdsArray.length; i++) {
				if (newRelatedApplicationIdsArray[i].length() > 0) {
					newRelatedApplicationIdsVector.add(newRelatedApplicationIdsArray[i]);
					maximumRelatedApplicationIdsSet.add(newRelatedApplicationIdsArray[i]);
				}
			}
		}
		maximumRelatedApplicationIdsSet = getMaximumRelatedApplicationIdsSet(maximumRelatedApplicationIdsSet, procesedRelatedApplicationIdsSet); 
		_log.debug("maximumRelatedApplicationIdsSet.size(): "+ maximumRelatedApplicationIdsSet.size());
		for (String oldRelatedApplicationId: oldRelatedApplicationIdsVector) {
			if (newRelatedApplicationIdsVector.contains(oldRelatedApplicationId)) {
				// do nothing
			} else {
				removeRelatedApplicationIdsVector.add(oldRelatedApplicationId);
			}				
		}

		for (String id: maximumRelatedApplicationIdsSet) {
			setRelatedIds(Long.parseLong(id), maximumRelatedApplicationIdsSet);
		}
		model.setRelatedApplicationId(setRelatedIds(application.getApplicationId(), maximumRelatedApplicationIdsSet));
						
		_log.debug("removeRelatedApplicationIdsVector.size(): "+ removeRelatedApplicationIdsVector.size());
		for (String removeRelatedApplicationId: removeRelatedApplicationIdsVector) {
			_log.debug("removeRelatedApplicationId: " + removeRelatedApplicationId);
			removeRelatedApplicationId2(Long.parseLong(removeRelatedApplicationId), String.valueOf(application.getApplicationId()));
			model.setRelatedApplicationId(removeRelatedApplicationId(application.getApplicationId(), removeRelatedApplicationId));
		}
		
       	model.setUseOpenData(application.getUseOpenData());
       	model.setLicense(application.getLicense());
       	model.setSector(application.getSector());
		
        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.reindex(model);
        Application result = applicationPersistence.update(model, true);
		return result;		
	}
	
	
	private String setRelatedIds(long id, HashSet<String> maximumRelatedApplicationIdsSet) throws SystemException {
//		_log.debug("id: "+ id);
		Application model =  applicationPersistence.fetchByPrimaryKey(id);
		String reIds = "";
		for (String _id: maximumRelatedApplicationIdsSet) {
			if (! _id.equalsIgnoreCase(String.valueOf(id)) ) {
				if (reIds.length() == 0) {
					reIds = _id;
				} else {
					reIds += ";" +_id;
				}
			}
		}
//		_log.debug("reIds: "+ reIds);
		model.setRelatedApplicationId(reIds);
		applicationPersistence.update(model, true);
		return reIds;
	}
	
	
	private HashSet<String> getMaximumRelatedApplicationIdsSet(HashSet<String> maximumRelatedApplicationIdsSet, HashSet<String> procesedRelatedApplicationIdsSet) throws NumberFormatException, SystemException {
		_log.debug("maximumRelatedApplicationIdsSet.size(): "+ maximumRelatedApplicationIdsSet.size());
		_log.debug("procesedRelatedApplicationIdsSet.size(): "+ procesedRelatedApplicationIdsSet.size());
		
		for (String applicationId: maximumRelatedApplicationIdsSet) {
			_log.debug("maximumRelatedApplicationIdsSet: "+ applicationId);
		}		
		
		for (String applicationId: procesedRelatedApplicationIdsSet) {
			_log.debug("procesedRelatedApplicationIdsSet: "+ applicationId);
		}
		
		for (String applicationId: maximumRelatedApplicationIdsSet) {
			if (procesedRelatedApplicationIdsSet.contains(applicationId)) {
				continue;
			} else {
				procesedRelatedApplicationIdsSet.add(applicationId);
				Application model =  applicationPersistence.fetchByPrimaryKey(Long.parseLong(applicationId));
				String relIds = model.getRelatedApplicationId();
				if (relIds.length() > 0) {
					_log.debug("relIds: "+ relIds);
					String[] reIdsArray = relIds.split(";");
					_log.debug("reIdsArray.length: "+ reIdsArray.length);
					for(int i=0; i<reIdsArray.length; i++) {
						maximumRelatedApplicationIdsSet.add(reIdsArray[i]);
						maximumRelatedApplicationIdsSet = getMaximumRelatedApplicationIdsSet(maximumRelatedApplicationIdsSet, procesedRelatedApplicationIdsSet);
					}	
					
				}
			}
		}
		return maximumRelatedApplicationIdsSet;
	}
	
/*	
	public Application developerUpdateApplication(Application application, File imageFile) throws SystemException, PortalException {
		if (application.getLifeCycleStatus() != Constants.APPLICATION_STATUS_OLD_VERIFIED ) {
			application.setLifeCycleStatus(Constants.APPLICATION_STATUS_RESUBMITTED);
		}
//		application.setLifeCycleStatusString("geändert - warten auf Freigabe");
		return updateApplication(application, imageFile);	
	}
*/	
	public Application developerUpdateApplicationFileEntry(Application application, FileEntry tempImageFileEntry) throws SystemException, PortalException {
		_log.debug("application.getLifeCycleStatus(): "+ application.getLifeCycleStatus());
		Application newApp = null;
		if (tempImageFileEntry != null) {
			_log.debug("tempImageFileEntry.getFileEntryId(): "+ tempImageFileEntry.getFileEntryId());
		}
		
		if (application.getLifeCycleStatus() == 4) {
			newApp = clone4NewVersion(application.getApplicationId());
		} else {
			newApp = application;
		}
		if (newApp.getLifeCycleStatus() != Constants.APPLICATION_STATUS_OLD_VERIFIED ) {
			application.setLifeCycleStatus(Constants.APPLICATION_STATUS_RESUBMITTED);
		}
//		application.setLifeCycleStatusString("geändert - warten auf Freigabe");
		
		return updateApplicationFileEntryWithOutRelIds(newApp.getApplicationId(), application, tempImageFileEntry);	
	}
	
	
	
	private Application updateApplicationFileEntryWithOutRelIds(long newApplicationId, Application application, FileEntry tempImageFileEntry) throws SystemException, PortalException {
		
		Application model =  applicationPersistence.fetchByPrimaryKey(newApplicationId);
		model.setCompanyId(application.getCompanyId());
//		model.setCreateDate(new Date());
		model.setDescription(application.getDescription());
		model.setFee(application.getFee());
		model.setTargetCategory(application.getTargetCategory());
		model.setDeveloper(application.getDeveloper());
		model.setFirstPublishingDate(application.getFirstPublishingDate());
		model.setLastModifiedDate(application.getLastModifiedDate());

//		model.setLifeCycleStatus(application.getLifeCycleStatus());

		if(tempImageFileEntry!=null) {
			model.setLogoImageId(tempImageFileEntry.getFileEntryId());
		}
		_log.debug("model.getLogoImageId(): "+ model.getLogoImageId());
		model.setMinTargetOSVersion(application.getMinTargetOSVersion());
		model.setModifiedDate(new Date());
		model.setName(application.getName());
		model.setSize(application.getSize());
		model.setTargetOS(application.getTargetOS());
		model.setUserId(application.getUserId());
		if (application.getLifeCycleStatus() >= Constants.APPLICATION_STATUS_VERIFIED ) {
			model.setVerifiedDate(application.getVerifiedDate());			
		}
		model.setVersion(application.getVersion());
		model.setVersionInformation(application.getVersionInformation());
		model.setLegalDetails(application.getLegalDetails());
		model.setRelatedApplicationId(application.getRelatedApplicationId());
				
       	model.setUseOpenData(application.getUseOpenData());
       	model.setLicense(application.getLicense());
       	model.setSector(application.getSector());

        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
        indexer.reindex(model);
        Application result = applicationPersistence.update(model, true);
		return result;		
	}
		
	
	
	public int getApplicationsCount(long companyId) throws SystemException {
		return applicationPersistence.countByc(companyId);
	}
	
	
	public List<Application> getApplications(long companyId) throws SystemException {
		List<Application> result = new ArrayList<Application>();
//		return applicationPersistence.findByc(companyId);
		List<Application> allApps = applicationPersistence.findAll();
		for (Application application: allApps) {
			if (application.getLifeCycleStatus() != E_Stati.APPLICATION_STATUS_OLD_VERIFIED.getIntStatus() ) {
				result.add(application);
			}
		}
		return result;
	}
	
	public List<Application> getApplications(long companyId, long userId) throws SystemException {
		return applicationPersistence.findBycu(companyId, userId);
	}
	
	public List<Application> getApplicationsBycl(long companyId, int lifecyclestatus) throws SystemException {
		return applicationPersistence.findBycl(companyId, lifecyclestatus);
	}

	public List<Application> getApplications4Verification(long companyId) throws SystemException {
		List<Application> result = new ArrayList<Application>();
		List<Application> allApps = applicationPersistence.findAll();
		for (Application application: allApps) {
			if (application.getLifeCycleStatus() < E_Stati.APPLICATION_STATUS_VERIFIED.getIntStatus() ) {
				result.add(application);
			}
		}
		return result; //applicationPersistence.findBycl(companyId, 4);
	}

	public List<Application> getDeveloperApplications(long companyId, long userId) throws SystemException {
		List<Application> result = new ArrayList<Application>();
		List<Application> tmpList = applicationPersistence.findBycu(companyId, userId);
		
 		// hide apps with status "deleted", "old_verified" 
		for (Application app : tmpList) {
			if (app.getLifeCycleStatus() != E_Stati.APPLICATION_STATUS_DELETED.getIntStatus() && app.getLifeCycleStatus() != E_Stati.APPLICATION_STATUS_OLD_VERIFIED.getIntStatus()) {
				result.add(app);
			}
		}
		return result;
		

 		// also show apps with status "deleted" 
//		return tmpList;
	}
	
	
	public List<Category> getCategories(long applicationId) throws SystemException {
//		_log.debug("getCategories::applicationId: " + applicationId);
		return applicationPersistence.getCategories(applicationId);
	}
	
	
	public List<Application_Entitlement> getApplicationEntitlements(long applicationId) throws SystemException {
		return applicationPersistence.getApplication_Entitlements(applicationId);
	}
	
	public List<Language> getLanguages(long applicationId) throws SystemException {
		return applicationPersistence.getLanguages(applicationId);
	}

	public List<Link> getLinks(long applicationId) throws SystemException {
		return applicationPersistence.getLinks(applicationId);
	}
	
	public List<MultiMedia> getMultiMedias(long applicationId) throws SystemException {
		return applicationPersistence.getMultiMedias(applicationId);
	}

	public List<Region> getRegions(long applicationId) throws SystemException {
		return applicationPersistence.getRegions(applicationId);
	}
	
	public void clearCategories(long applicationId) throws SystemException {
		applicationPersistence.clearCategories(applicationId);
	}
	
	public void clearRegions(long applicationId) throws SystemException {
		applicationPersistence.clearRegions(applicationId);
	}

	public void clearLanguages(long applicationId) throws SystemException {
		applicationPersistence.clearLanguages(applicationId);
	}

	protected void saveImages(long imageId, File imageFile,	byte[] imageBytes) throws PortalException, SystemException {
		_log.debug("imageId: " + imageId);
		_log.debug("imageFile.getName(): " + imageFile.getName());
		_log.debug("imageBytes.length: " + imageBytes.length);
		if ((imageFile != null) && (imageBytes != null)) {
			ImageLocalServiceUtil.updateImage(imageId, imageBytes);
		}
	}
	
	
	public List<Application> getApplicationsAfter(int status, Date date) throws SystemException {
		List<Application> result  = new LinkedList<Application>();
		
		result = applicationPersistence.findByml(date, status);
		
		return result;
	}
	
	public List<List> getNewApplications(long companyId, int year, int month, int day, int count) throws SystemException {	
	
		List<List> result  = new ArrayList<List>();
		
		Date modifiedDate = PortalUtil.getDate(month, day, year);
		Date now = new Date();

		List<Application> applications = applicationPersistence.findAll();
		List<Application> applications2 = new ArrayList<Application>();
		for (Application app: applications) {
			applications2.add(app);
		}
		
		OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator("modifiedDate",  "desc");
		
        Collections.sort(applications2, orderByComparator);
        applications2 = applications2.subList(0, count);
		
		for (Application application: applications2) {
			if (application.getLifeCycleStatus() >= 4) {
				List toAdd = new ArrayList();
				toAdd.add(application);
						
				DLFileEntry fe;
				try {
					fe = DLFileEntryLocalServiceUtil.getDLFileEntry(application.getLogoImageId());
					String iconUrl = "http://localhost/documents/10180/0/" + 
						HttpUtil.encodeURL(HtmlUtil.unescape(fe.getTitle())) + 
						StringPool.SLASH + 
						fe.getUuid() +
						"?version=" + fe.getVersion() +
						"&t=" + fe.getModifiedDate().getTime() +
						"&imageThumbnail=1";
							
					toAdd.add(iconUrl);
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
						
				result.add(toAdd);				
			}
		}			
		return result;		
	}

	

	
	public List<Application> getApplicationsByCategories(List<Category> allCategories) {
		List<Application> applicationResultList = new ArrayList<Application>();

		try {
//			applicationResultList = applicationPersistence.findBycategory(allCategories);
			
			for (Category category: allCategories) {
				List<Application> applicationsList = CategoryLocalServiceUtil.getApplications(category.getCategoryId());
				for (Application application: applicationsList) {
					if (applicationPersistence.getCategories(application.getApplicationId()).containsAll(allCategories)) {
						applicationResultList.add(application);
					}
				}
			}
			
		} catch (SystemException se) {
			_log.debug(se.getMessage());
			
		}
		return applicationResultList;
	}
	
	public List<Application> getApplicationsByRegions(List<Region> allRegions) {
		List<Application> applicationResultList = new ArrayList<Application>();
		try {
			// wenn eine App mehrere Regionen hat, werden nur andere Apps gefunden die mindestens diese mehreren Regionen auch haben
/*
			for (Region region: allRegions) {
				List<Application> applicationsList = RegionLocalServiceUtil.getApplications(region.getRegionId());
				for (Application application: applicationsList) {
					if (applicationPersistence.getRegions(application.getApplicationId()).containsAll(allRegions)) {
						applicationResultList.add(application);
					}
				}
			}
*/			
			// wenn eine app mehrere Regionen hat, werden ALLE andere Apps gefunden die mindestens eine dieser Regionen auch haben
			
			for (Region region: allRegions) {
				List<Application> applicationsList = RegionLocalServiceUtil.getApplications(region.getRegionId());
				for (Application application: applicationsList) {
					if (applicationResultList.contains(application)) {
						// do nothing
					} else {
						applicationResultList.add(application);						
					}
				}
			}

			
		} catch (SystemException se) {
			_log.debug(se.getMessage());
			
		}
		return applicationResultList;		
	}
	

	private String  removeRelatedApplicationId(long applicationId, String removeApplicationId) throws SystemException {
	    _log.debug("removeRelatedApplicationId::applicationId: " + applicationId);
	    _log.debug("removeRelatedApplicationId::removeApplicationId: " + removeApplicationId);
		Application model =  applicationPersistence.fetchByPrimaryKey(applicationId);
		String oldRelatedApplicationString = model.getRelatedApplicationId();
		String newRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, removeApplicationId);
		model.setRelatedApplicationId(newRelatedApplicationString);
        applicationPersistence.update(model, true);
        return newRelatedApplicationString;
	}

	
	private String removeRelatedApplicationId2(long applicationId, String removeApplicationId) throws SystemException {
	    _log.debug("removeRelatedApplicationId2::applicationId: " + applicationId);
	    _log.debug("removeRelatedApplicationId2::removeApplicationId: " + removeApplicationId);
		Application model =  applicationPersistence.fetchByPrimaryKey(applicationId);
		String oldRelatedApplicationString = model.getRelatedApplicationId();
		String newRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, removeApplicationId);
		model.setRelatedApplicationId(newRelatedApplicationString);
        applicationPersistence.update(model, true);
        
        String[] relatedApplicationArray = newRelatedApplicationString.split(";");
        for (int i=0; i<relatedApplicationArray.length; i++) {
        	if (relatedApplicationArray[i].length() > 0 ) {
                removeRelatedApplicationId(Long.parseLong(relatedApplicationArray[i]), removeApplicationId);
        	}        	
        }
        
        
        return newRelatedApplicationString;
	}
	
/*	
	private void addRelatedApplicationId(long applicationId, String newRelatedApplicationId) throws SystemException {
		Application model =  applicationPersistence.fetchByPrimaryKey(applicationId);
		String oldRelatedApplicationString = model.getRelatedApplicationId();
		String newRelatedApplicationString = model.getRelatedApplicationId();
		
//		oldRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, String.valueOf(applicationId));
//	    _log.debug("oldRelatedApplicationString: " + oldRelatedApplicationString);

		if (oldRelatedApplicationString.contains(";" + newRelatedApplicationId + ";") || 
				oldRelatedApplicationString.matches("([^\\s]*;" + newRelatedApplicationId+")") || 
				oldRelatedApplicationString.matches("(^" + newRelatedApplicationId + ";[^\\s]*)" ) || 
				oldRelatedApplicationString.equalsIgnoreCase(newRelatedApplicationId)) {
			// do nothing
			 
		} else {
			if (newRelatedApplicationString.length() == 0) {
				newRelatedApplicationString = newRelatedApplicationId;
			} else {
				newRelatedApplicationString += ";" + newRelatedApplicationId;				
			}
			
			model.setRelatedApplicationId(newRelatedApplicationString);
	        applicationPersistence.update(model, true);		
		}
	}
*/
	
/*	
	private String addRelatedIds(String relatedApplicationIds, String newRelatedApplicationId) throws SystemException {

		if (relatedApplicationIds.contains(";" + newRelatedApplicationId + ";") || 
				relatedApplicationIds.matches("([^\\s]*;" + newRelatedApplicationId+")") || 
				relatedApplicationIds.matches("(^" + newRelatedApplicationId + ";[^\\s]*)" ) || 
				relatedApplicationIds.equalsIgnoreCase(newRelatedApplicationId)) {
			// do nothing
			 
		} else {
			if (relatedApplicationIds.length() == 0) {
				relatedApplicationIds = newRelatedApplicationId;
			} else {
				relatedApplicationIds += ";" + newRelatedApplicationId;				
			}
		}
        return relatedApplicationIds;		
	}
*/
/*	
	private void setRelatedApplicationId(long applicationId, String newApplicationId, String relatedApplicationIds) throws SystemException {
		Application model =  applicationPersistence.fetchByPrimaryKey(applicationId);
		relatedApplicationIds = replaceRelatedIds(relatedApplicationIds, String.valueOf(applicationId));
		relatedApplicationIds = addRelatedIds(relatedApplicationIds, newApplicationId);
		model.setRelatedApplicationId(relatedApplicationIds);
		applicationPersistence.update(model, true);		
	}
*/
/*
	private void addRelatedApplicationId2(long applicationId, String oldRelatedApplicationId, String newRelatedApplicationId) throws SystemException {
		Application model =  applicationPersistence.fetchByPrimaryKey(applicationId);
		String oldRelatedApplicationString = model.getRelatedApplicationId();
		String newRelatedApplicationString = model.getRelatedApplicationId();
		
		oldRelatedApplicationString = replaceRelatedIds(oldRelatedApplicationString, oldRelatedApplicationId);
	    _log.debug("oldRelatedApplicationString: " + oldRelatedApplicationString);

		if (oldRelatedApplicationString.contains(";" + newRelatedApplicationId + ";") || 
				oldRelatedApplicationString.matches("([^\\s]*;" + newRelatedApplicationId+")") || 
				oldRelatedApplicationString.matches("(^" + newRelatedApplicationId + ";[^\\s]*)" ) || 
				oldRelatedApplicationString.equalsIgnoreCase(newRelatedApplicationId)) {
			// do nothing
			 
		} else {
			if (newRelatedApplicationString.length() == 0) {
				newRelatedApplicationString = newRelatedApplicationId;
			} else {
				newRelatedApplicationString += ";" + newRelatedApplicationId;				
			}
			
			String[] oldRelatedApplicationIdsArray = oldRelatedApplicationString.split(";");
			for (int i=0; i<oldRelatedApplicationIdsArray.length; i++) {
				addRelatedApplicationId2(Long.parseLong(oldRelatedApplicationIdsArray[i]), oldRelatedApplicationId, newRelatedApplicationId);
			}
			
			model.setRelatedApplicationId(newRelatedApplicationString);
	        applicationPersistence.update(model, true);		
		}
	}
*/
	
	private static String replaceRelatedIds(String myString, String patt) {
	    _log.debug("Ids before: " + myString);
	    _log.debug("replace: " + patt);
				
		if (myString.contains(";" + patt + ";")) {
			_log.debug("contains(;" + patt + ";)" );
			return myString.replace(";" + patt, "");
			
		} else if (myString.matches("([^\\s]*;" + patt+")")) {;
		_log.debug("contains(;"  + patt + "EOL)");			
			return myString.replace(";" + patt, "");
			
		} else if (myString.matches("(^" + patt + ";[^\\s]*)" )) {
			_log.debug("contains(" + patt + ";)");
			return myString.replace(patt + ";", "");
			
		} else  if (myString.equalsIgnoreCase(patt)) {
			_log.debug("equalsIgnoreCase(" + patt + ")" );
			return myString.replace(patt, "");			
		}
		return myString;
	}
	
	public void updateStatusString(long companyId) throws SystemException {
		List<Application> apps =  applicationPersistence.findByc(companyId);
		
		for (Application app : apps) {
			if (app.getLifeCycleStatus() == 0) {
				app.setLifeCycleStatus(1);
//				app.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");
				applicationPersistence.update(app, true);
			}			
			if (app.getLifeCycleStatus() == 1 || app.getLifeCycleStatus() == 0) {
//				app.setLifeCycleStatusString("neu erstellt - warten auf Freigabe");
				applicationPersistence.update(app, true);
			}			
			if (app.getLifeCycleStatus() == 2) {
//				app.setLifeCycleStatusString("gelöscht - warten auf Freigabe");
				applicationPersistence.update(app, true);
			}
			if (app.getLifeCycleStatus() == 3) {
//				app.setLifeCycleStatusString("geändert - warten auf Freigabe");
				applicationPersistence.update(app, true);
			}
			if (app.getLifeCycleStatus() == 4) {
//				app.setLifeCycleStatusString("freigegeben");
				applicationPersistence.update(app, true);
			}
			if (app.getLifeCycleStatus() == 5) {
//				app.setLifeCycleStatusString("freigegeben und zertifiziert");
				applicationPersistence.update(app, true);
			}
		}
	}
	
	public void removeStatusString(long companyId) throws SystemException {
		List<Application> apps =  applicationPersistence.findByc(companyId);		
		for (Application app : apps) {
			app.setLifeCycleStatusString("");
		}
	}
	
	
	public List<Application> getLinkDoubles() throws SystemException {
		List<Application> applicationsWithDoubles = new ArrayList<Application>();
		List<Application> allApplications = applicationPersistence.findAll();
		for (Application application: allApplications) {
			_log.info("application: " + application.getApplicationId() );
			List<Link> allLinks  = applicationPersistence.getLinks(application.getApplicationId());
			if (allLinks.size() > 4 ) {
				_log.info("too many Links: " + application.getApplicationId() + ", " + allLinks.size() );
			}
			Set<Integer> allLinkTypes = new HashSet<Integer>();
			for (Link link : allLinks) {
				_log.info("link.getLinkId(): " + link.getLinkId() );
				if (allLinkTypes.contains(link.getType())) {
					_log.info("applicationsWithDoubles: " + application.getApplicationId() );
					applicationsWithDoubles.add(application);
					continue;
				} else {
					allLinkTypes.add(link.getType());
				}				
			}			
		}
		return applicationsWithDoubles;
	}

	public List<Long> getRelatedApplications() throws SystemException {
		List<Long> relatedApplications = new ArrayList<Long>();
		List<Application> allApplications = applicationPersistence.findAll();
		for (Application application: allApplications) {
			_log.info("application: " + application.getApplicationId() );
			if (application.getRelatedApplicationId().length() > 1) {
				_log.info("relatedApplications: " + application.getApplicationId() );
				relatedApplications.add(application.getApplicationId());
			}
		}
		return relatedApplications;
	}
	
	public void removeWhitespaceFromTargetOS() throws SystemException {
		List<Application> allApplications = applicationPersistence.findAll();
		for (Application application: allApplications) {
			String targetOS = application.getTargetOS().trim(); 
			if (targetOS.equals("IOS")) {
				_log.info("application: IOS " + application.getApplicationId() );
				targetOS = "iOS";
			}
			application.setTargetOS(targetOS);
			applicationPersistence.update(application, true);
		}
	}
	
	
	public String getUserEmailAddressByApplication(long applicationId)  {
		_log.debug("getUserEmailAddressByApplication applicationId: " + applicationId);
		try {
		Application application = applicationLocalService.getApplication(applicationId);
		_log.debug(UserLocalServiceUtil.getUserById(application.getUserId()).getEmailAddress());
		return UserLocalServiceUtil.getUserById(application.getUserId()).getEmailAddress();
		} catch (SystemException e) {
			_log.debug("SystemException: " +e.getMessage());
			e.printStackTrace();
		} catch (PrincipalException e) {
			_log.debug("PrincipalException: " + e.getMessage());
//			e.printStackTrace();
		} catch (PortalException e) {
			_log.debug("PortalException: " + e.getMessage());
			e.printStackTrace();
		}
		return "Error: no-Emailadress";
	}
	
	public void grantGuestViewPermissions() {
		try {
			List<Application> allApplications = applicationPersistence.findAll();
			for (Application application : allApplications) {
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(application.getLogoImageId());
				String[] groupPermissions = new String[1];
				String[] guestPermissions = new String[1];
				
					DLFileEntryLocalServiceUtil.addFileEntryResources(fe, groupPermissions, guestPermissions);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	public List<Application> getMostViewdApplications() {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("detailsViewed", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("detailsViewed");
			dynamicQuery.addOrder(defaultOrder); 
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Application> getMostViewdApplications(int end) {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("detailsViewed", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("detailsViewed");
			dynamicQuery.addOrder(defaultOrder); 
			dynamicQuery.setLimit(0, end);
			
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Application> getMostViewdApplications(int from, int end) {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("detailsViewed", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("detailsViewed");
			dynamicQuery.addOrder(defaultOrder); 
			dynamicQuery.setLimit(from, end);
			
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Application> getMostClickedApplications() {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("linkClicked", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("linkClicked");
			dynamicQuery.addOrder(defaultOrder); 
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Application> getMostClickedApplications(int end) {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("linkClicked", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("linkClicked");
			dynamicQuery.addOrder(defaultOrder); 
			dynamicQuery.setLimit(0, end);
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Application> getMostClickedApplications(int from, int end) {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			
			Criterion criterion = RestrictionsFactoryUtil.gt("linkClicked", new Long(0));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("linkClicked");
			dynamicQuery.addOrder(defaultOrder); 
			dynamicQuery.setLimit(0, end);
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*	
	public List<Application> getOpenDataApps() {
		List<Application> result = new ArrayList<Application>();
		try {			
			
			/ *
			// 	public static final int OPENDATA				  	= 7;
			List<Link> linksList = linkPersistence.findBybyType(Constants.OPENDATA);
			for (Link link : linksList) {
				Application app = applicationPersistence.fetchByPrimaryKey(link.getApplicationId());
				if (result.contains(app)) {					
				} else {
					result.add(app);
				}
			}
			* /
			result = applicationPersistence.findByuseOpenData(Constants.USE_OPEN_DATA);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
*/
	
/*	
	private List<String> getExternImageURLs(Application application) {
		List<String> result = new ArrayList<String>();		
		try {
			List<MultiMedia> allMultiMedias = applicationLocalService.getMultiMedias(application.getApplicationId());
			_log.info("allMultiMedias.size(): " + allMultiMedias.size());
			for (MultiMedia multiMedia : allMultiMedias) {
				_log.info("multiMedia.getImageId(): " + multiMedia.getImageId());
				if (multiMedia.getImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(multiMedia.getImageId());
					result.add("http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}
			}
		} catch (SystemException se) {
			_log.error(se.getMessage());		
		} catch (PortalException pe) {
			_log.error(pe.getMessage());				
		}
		return result;		
	}	
*/	
}
