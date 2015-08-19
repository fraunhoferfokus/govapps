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
 * $Id: OGPD_EntityLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import de.fraunhofer.fokus.movepla.Constants;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.portlets.AppConstants;
import de.fraunhofer.fokus.movepla.service.base.OGPD_EntityLocalServiceBaseImpl;
import de.fraunhofer.fokus.movepla.util.CustomComparatorUtil;

/**
 * The implementation of the o g p d_ entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.OGPD_EntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.OGPD_EntityLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.OGPD_EntityLocalServiceUtil
 */
public class OGPD_EntityLocalServiceImpl extends OGPD_EntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.OGPD_EntityLocalServiceUtil} to access the o g p d_ entity local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(OGPD_EntityLocalServiceImpl.class);
	
	
	public JSONArray getOGPD_Entities() {
//		JSONFactoryUtil _jsonFactoryUtil = new JSONFactoryUtil();
		JSONArray result = JSONFactoryUtil.createJSONArray();
		try {			
			
			List<Application> apps = applicationPersistence.findByuseOpenData(Constants.USE_OPEN_DATA);
			for (Application app: apps) {

				List<Link> links = applicationPersistence.getLinks(app.getApplicationId());
				String url = "";
				for (Link link: links) {
					if (link.getType() == Constants.TARGET_LINK) {
						url = link.getUrl();
					}
				}
				_log.debug("url: " + url);

				JSONObject _ogpd_Entity = JSONFactoryUtil.createJSONObject();

				_ogpd_Entity.put("name", "govapps_" + String.valueOf(app.getApplicationId()));
				_ogpd_Entity.put("title", app.getName());
				_ogpd_Entity.put("author", app.getLegalDetails());
				_ogpd_Entity.put("notes", app.getDescription());

				String categoryString = app.getCategoryString();
				String[] categoryArray = categoryString.split(",");
				
				JSONArray groups = JSONFactoryUtil.createJSONArray();
				for (int i=0; i<categoryArray.length ; i++) {
					groups.put(categoryArray[i].trim());
				}				
				_ogpd_Entity.put("groups", groups);
				_ogpd_Entity.put("type", "app");
				
				JSONArray resources = JSONFactoryUtil.createJSONArray();
				JSONObject resource = JSONFactoryUtil.createJSONObject();
				resource.put("url", url);
				resource.put("format", "application/octet-stream");
				resources.put(resource);
				_ogpd_Entity.put("resources", resources);
				
				_ogpd_Entity.put("license_id", app.getLicense());
								
				JSONObject extra = JSONFactoryUtil.createJSONObject();				
				
				JSONArray dates = JSONFactoryUtil.createJSONArray();
				JSONObject date = JSONFactoryUtil.createJSONObject();
				date.put("role", "erstellt");
				date.put("date", app.getCreateDate());				
				dates.put(date);
				extra.put("dates", dates);

				JSONObject terms_of_use = JSONFactoryUtil.createJSONObject();				
				extra.put("terms_of_use", terms_of_use);
				
				
				extra.put("used_datasets", getUsedDatasets(app));
				extra.put("sector", app.getSector());
				JSONArray images = 	getExternImageURLs(app);
				if (app.getLogoImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(app.getLogoImageId());
					images.put("http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}				
				extra.put("images", images);
				extra.put("ogd_version", "v1.0");
				
				
				_ogpd_Entity.put("extras", extra);
				result.put(_ogpd_Entity);								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	private JSONArray getUsedDatasets (Application application) {
		JSONArray result = JSONFactoryUtil.createJSONArray();		
		try {
			List<Link> allLinks = applicationLocalService.getLinks(application.getApplicationId());
			_log.debug("allLinks.size(): " + allLinks.size());
			for (Link link : allLinks) {
				_log.debug("link.getLinkId(): " + link.getLinkId());
				if (link.getType() == Constants.OPENDATA) {
					result.put(link.getUrl());
				}
			}
		} catch (SystemException se) {
			_log.error(se.getMessage());		
		}
		return result;
	}
	
	
	private JSONArray getExternImageURLs(Application application) {
		JSONArray result = JSONFactoryUtil.createJSONArray();		
		try {
			List<MultiMedia> allMultiMedias = applicationLocalService.getMultiMedias(application.getApplicationId());
			_log.debug("allMultiMedias.size(): " + allMultiMedias.size());
			for (MultiMedia multiMedia : allMultiMedias) {
				_log.debug("multiMedia.getImageId(): " + multiMedia.getImageId());
				if (multiMedia.getImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(multiMedia.getImageId());
					result.put("http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}
			}
		} catch (SystemException se) {
			_log.error(se.getMessage());		
		} catch (PortalException pe) {
			_log.error(pe.getMessage());				
		}
		return result;		
	}	
	
	
	public JSONArray getRegionEntitiesForWidget(String regionID) {
		JSONArray result = JSONFactoryUtil.createJSONArray();
		try {
			long regionId = 1;
			if (regionID.trim().length() > 0) {
				regionId = Long.valueOf(regionID);
			}
			List<Application> apps = regionLocalService.getApplications(regionId);
			for (Application app: apps) {

				JSONObject _ogpd_Entity = JSONFactoryUtil.createJSONObject();

				_ogpd_Entity.put("id", app.getApplicationId());
				_ogpd_Entity.put("name", app.getName());
				_ogpd_Entity.put("beschreibung", app.getDescription());

				if (app.getLogoImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(app.getLogoImageId());
					_ogpd_Entity.put("icon", "http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}				
				_ogpd_Entity.put("plattform", app.getTargetOS());
				result.put(_ogpd_Entity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

	public JSONArray getRegionEntitiesForWidgetParamFirst(String regionID, String name) {
		JSONArray result = JSONFactoryUtil.createJSONArray();
		JSONArray tmpArray = JSONFactoryUtil.createJSONArray();
		try {
			long regionId = 1;
			if (regionID.trim().length() > 0) {
				regionId = Long.valueOf(regionID);
			}
			List<Application> apps = new ArrayList<Application>();
			regionLocalService.getApplications(regionId);
			apps.addAll(regionLocalService.getApplications(regionId));
		    String orderByCol = "name";
		    String orderByType = "asc";

		    OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator(orderByCol, orderByType);        
			Collections.sort(apps, orderByComparator);

			for (Application app: apps) {

				JSONObject _ogpd_Entity = JSONFactoryUtil.createJSONObject();

				_ogpd_Entity.put("id", app.getApplicationId());
				_ogpd_Entity.put("name", app.getName());
				_ogpd_Entity.put("beschreibung", app.getDescription());

				if (app.getLogoImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(app.getLogoImageId());
					_ogpd_Entity.put("icon", "http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}				
				_ogpd_Entity.put("plattform", app.getTargetOS());

				if (app.getName().toLowerCase().contains(name.trim().toLowerCase())) {
					result.put(_ogpd_Entity);
				} else {
					tmpArray.put(_ogpd_Entity);
				}
			}
			
			for (int i=0; i<tmpArray.length(); i++) {
				JSONObject _ogpd_Entity = tmpArray.getJSONObject(i);
				result.put(_ogpd_Entity);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public JSONArray getOpenDataEntitiesForWidget() {
		JSONArray result = JSONFactoryUtil.createJSONArray();
		try {
			List<Application> apps = applicationPersistence.findByuseOpenData(Constants.USE_OPEN_DATA);
			for (Application app: apps) {

				JSONObject _ogpd_Entity = JSONFactoryUtil.createJSONObject();

				_ogpd_Entity.put("id", app.getApplicationId());
				_ogpd_Entity.put("name", app.getName());
				_ogpd_Entity.put("beschreibung", app.getDescription());

				if (app.getLogoImageId() != 0) {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(app.getLogoImageId());
					_ogpd_Entity.put("icon", "http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
				}				
				_ogpd_Entity.put("plattform", app.getTargetOS());
				result.put(_ogpd_Entity);								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
}
