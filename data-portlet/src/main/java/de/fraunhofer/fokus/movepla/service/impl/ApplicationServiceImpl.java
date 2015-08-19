package de.fraunhofer.fokus.movepla.service.impl;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import de.fraunhofer.fokus.movepla.Constants;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.portlets.AppConstants;
import de.fraunhofer.fokus.movepla.portlets.E_Stati;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.LoggingLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.base.ApplicationServiceBaseImpl;
import de.fraunhofer.fokus.movepla.util.AppClickedLog;
import de.fraunhofer.fokus.movepla.util.AppDetailsLog;
import de.fraunhofer.fokus.movepla.util.CustomComparatorUtil;
import de.fraunhofer.fokus.movepla.util.SearchLog;
import de.fraunhofer.fokus.movepla.util.SimpleSearchLog;
/**
 * The implementation of the application remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.ApplicationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.ApplicationServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil
 */
public class ApplicationServiceImpl extends ApplicationServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.ApplicationServiceUtil} to access the application remote service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(ApplicationServiceImpl.class);

	
	public int getApplicationsCount(long companyId) throws SystemException {
		return applicationLocalService.getApplicationsCount(companyId);
	}
		
	
	public int getApplicationsCount() throws SystemException, PrincipalException {
		_log.debug("getApplicationsCount: ");
//		PermissionChecker pc = getPermissionChecker();
//		_log.debug("userId: " + pc.getUserId());
//		_log.debug("getCompanyId: " + pc.getCompanyId());
		return applicationLocalService.getApplicationsCount(10154);
	}
	
	
	public List<List> getNewApplications2(long companyId, int year, int month, int day, int count) throws SystemException {	
		_log.debug(companyId + " | " + year + " | " + month  + " | " +  day  + " | " +  count);
		return applicationLocalService.getNewApplications(companyId, year, month, day, count);		
	}
	
	
	public List<List> getNewApplications(long companyId, int year, int month, int day, int count) throws SystemException {	
		_log.debug("getNewApplications2: ");
		List<List> result  = new ArrayList<List>();
		try {
			Date modifiedDate = PortalUtil.getDate(month, day, year);
			Date now = new Date();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Application.class);
			Criterion criterion = null;
			
			criterion = RestrictionsFactoryUtil.between("modifiedDate",modifiedDate,now);

			dynamicQuery.add(criterion);
			dynamicQuery.add(PropertyFactoryUtil.forName("lifeCycleStatus").eq(E_Stati.APPLICATION_STATUS_VERIFIED.getIntStatus()));
			
			Order defaultOrder = OrderFactoryUtil.desc("modifiedDate");
			dynamicQuery.addOrder(defaultOrder); 
					
			dynamicQuery.setLimit(0, count);
			
			List<Application> applications = ApplicationLocalServiceUtil.dynamicQuery(dynamicQuery);
			
		
			for (Application application: applications) {
				List toAdd = new ArrayList();
				toAdd.add(application);
							
				if (application.getLogoImageId() != 0) {
					DLFileEntry fe;
					fe = DLFileEntryLocalServiceUtil.getDLFileEntry(application.getLogoImageId());
								//String iconUrl = "http://localhost/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true);
					String iconUrl = "http://localhost/documents/10180/0/" + 
						HttpUtil.encodeURL(HtmlUtil.unescape(fe.getTitle())) + 
						StringPool.SLASH + 
						fe.getUuid() +
						"?version=" + fe.getVersion() +
						"&t=" + fe.getModifiedDate().getTime() +
						"&imageThumbnail=1";
									
					toAdd.add(iconUrl);
				}
						
				result.add(toAdd);				
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return result;		
	}
	
	
	public List<Application> getApplications(long companyId) throws SystemException {
		return applicationLocalService.getApplications(companyId);		
	}
	

	public List<Application> getApplications(long companyId, long userId) throws SystemException {
		return applicationLocalService.getApplications(companyId, userId);		
	}

	
	public  List<List> searchApplications(long companyId, String keywords) throws SystemException, SearchException {
		_log.debug("searchApplications keywords: " + keywords);
//		_log.info(companyId + " | " + keywords);
//		SimpleSearchLog.log(companyId, keywords);
		LoggingLocalServiceUtil.addSimpleLog(keywords);
		
		List<List> applicationResultList = new ArrayList<List>();

        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	    
        SearchContext searchContext = new SearchContext();
        if (keywords == null || keywords.equalsIgnoreCase("null")) {
        	searchContext.setKeywords(" ");        	
        } else {
        	searchContext.setKeywords(keywords.toLowerCase());
        }
        QueryConfig queryConfig = new QueryConfig();
        queryConfig.setHighlightEnabled(false);
        queryConfig.setScoreEnabled(false);
        searchContext.setQueryConfig(queryConfig);
        
        searchContext.setCompanyId(companyId);
        
	     Hits results = indexer.search(searchContext);
		_log.debug("results: " + results.getLength());

		
		if (results.getLength() == 0) {
	        searchContext.setKeywords(keywords.toLowerCase() + "*");			
		     results = indexer.search(searchContext);
			_log.debug("results: " + results.getLength());			
		}
		
		if (results.getLength() == 0) {
	        searchContext.setKeywords(keywords.toLowerCase() + "~");			
		     results = indexer.search(searchContext);
			_log.debug("results: " + results.getLength());			
		}

		if (results.getLength() == 0) {
	        searchContext.setKeywords(keywords.toLowerCase() + "~0.1");			
		     results = indexer.search(searchContext);
			_log.debug("results: " + results.getLength());			
		}

		_log.debug("results.getQuery().toString(): " + results.getQuery().toString());
		_log.debug("results.getSearchTime(): " + results.getSearchTime());
		_log.debug("results.getScores().length: " + results.getScores().length);
				
		for (int i=0; i<results.getLength(); i++) {
            Document doc = results.doc(i);
            
            
            long applicationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
//    		_log.debug("applicationId: " + applicationId);

            Application _application = null;

            try {
            	_application = applicationLocalService.getApplication(applicationId);
            	if (_application.getLifeCycleStatus() >= 4) {
            		List result= new ArrayList();
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String categoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			categoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String regionIds="";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			regionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(categoryIds);
        			result.add(regionIds);
        			applicationResultList.add(result);
//            		applicationResultList.put(_application, new ArrayList<Application_Entitlement>());
//            		applicationResultList.put(_application, applicationLocalService.getApplicationEntitlements(applicationId));
//            		_log.debug("lifecycle for applicationId: " + applicationId+" is ok and added to result list");
            	} else {
            		_log.debug("lifecycle status for applicationId: " + applicationId+" is too low; status: "+_application.getLifeCycleStatus());
            	}
            	
            }
            catch (Exception e) {
           		_log.warn(e.getMessage());
            }
        }
        return applicationResultList;
	}

//  getFullSearchApplications(companyId: 10154, keywords: null, requiredCategoryIds: , requiredRegionIds: , requiredApplicationEntitlementIds: 1_2_3_4_5_6, requiredTargetOS: , fee: 0)
//	 getFullSearchApplications(companyId: 10154, keywords: null, requiredCategoryIds: , requiredRegionIds: , requiredApplicationEntitlementIds: 1_2_3_4_5_6, requiredTargetOS: webapp_android_ios_windows, fee: -1)
	/**
	 *  search Applications with several aspects: categories, regions, entitlements, costs, platforms,  targetCategory
	 *  all aspects are connected by AND
	 *  all aspects are internally connected by AND  
	 *  
	 *  @param co companyId default: (10154)
	 *  @param ke keywords may be 'null', '', 'searchString', 'two searchStrings', ... 
	 *  @param ca required CategoryIds may be '', '1_2_3', ... 
	 *  @param re required RegionIds may be '', '1_2_3', ... 
	 *  @param ap allowed ApplicationEntitlementIds may be '', '1_2_3_4_5_6', ... 
	 *  @param to required TargetOS may be '', iOS', 'iOS_Android_Windows', ... 
	 *  @param fe required fee may be   0 -> kostenlos, 1 -> kostenpflichtig, else (z.B. 2) : alle
	 *  @param es  search single entitlement may be   0 -> get all apps with at least this entitlement, else (z.B. 2) : alle
	 *  @param tc  targetCategory may be   "", "Smartphone", "Tablet" or "Smartphone_Tablet" 
 
	 */
	public List<List> getFullSearchApplications(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es,
			String tc,
			int od
			) throws SystemException, SearchException {

		_log.debug("getFullSearchApplications(companyId co: " + co +
			", keywords ke: " + ke +
		    ", requiredCategoryIds ca: " + ca + 
		    ", requiredRegionIds re: " + re +
			", allowedApplicationEntitlementIds ap: " + ap + 
			", requiredTargetOS to: " + to + 
			", fee fe: " + fe  +
			", es: " + es + ", tc: " + tc + ", od: " + od    
			+ ")");
	    
//		_log.info(co + " | " + ke + " | " + ca + " | " + re + " | " + ap + " | " + to + " | " + fe  + " | " + es + " | " +  tc);
//		SearchLog.log(co, ke, ca, re, ap, to, fe, es, tc);
		LoggingLocalServiceUtil.addComplexLog(ke, ca.replace("_", ";"), re.replace("_", ";"), ap.replace("_", ";"), to.replace("_", ";"), fe, tc.replace("_", ";"));

        if (ke != null && ! ke.equalsIgnoreCase("null")) {
        	return getFullSearchApplicationsIndex(co, ke, ca, re, ap, to, fe, es, tc, od);
        } else {
        	List<List> resultList = getFullSearchApplicationsList(co, ke, ca, re, ap, to, fe, es, tc, od);
/*        	
// 			if resultList.size() < threshold ==> add apps for bundesrepublik 
        	int threshold = 3;
        	String bundesRepRegionId = "1";
    		_log.debug("resultList.size(): " + resultList.size());
        	if (resultList.size() < threshold && re.length() > 0 && !  containsIdString(re, bundesRepRegionId, "_")) {
            	List<List> bundesRepResultList = getFullSearchApplicationsList(co, ke, ca, bundesRepRegionId, ap, to, fe, es, tc);
        		_log.debug("bundesRepResultList.size(): " + bundesRepResultList.size());
            	resultList.addAll(bundesRepResultList);
        		_log.debug("resultList.size(): " + resultList.size());
        	}
*/        	
        	return resultList;
        }
	}
	

	public List<List> getFullSearchApplications(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es
			) throws SystemException, SearchException {

		_log.debug("getFullSearchApplications(companyId co: " + co +
			", keywords ke: " + ke +
		    ", requiredCategoryIds ca: " + ca + 
		    ", requiredRegionIds re: " + re +
			", allowedApplicationEntitlementIds ap: " + ap + 
			", requiredTargetOS to: " + to + 
			", fee fe: " + fe  +
			", es: " + es   
			+ ")");
	    
//		_log.info(co + " | " + ke + " | " + ca + " | " + re + " | " + ap + " | " + to + " | " + fe  + " | " + es);
	    
		LoggingLocalServiceUtil.addComplexLog(ke, ca.replace("_", ";"), re.replace("_", ";"), ap.replace("_", ";"), to.replace("_", ";"), fe, "");

		if (ke != null && ! ke.equalsIgnoreCase("null")) {
        	return getFullSearchApplicationsIndex(co, ke, ca, re, ap, to, fe, es);
        } else {
        	int threshold = 3;
        	List<List> resultList = getFullSearchApplicationsList(co, ke, ca, re, ap, to, fe, es);
/*        	
// 			if resultList.size() < threshold ==> add apps for bundesrepublik 
        	String bundesRepRegionId = "1";
    		_log.debug("resultList.size(): " + resultList.size());
        	if (resultList.size() < threshold && re.length() > 0 && ! containsIdString(re, bundesRepRegionId, "_")) {
            	List<List> bundesRepResultList = getFullSearchApplicationsList(co, ke, ca, bundesRepRegionId, ap, to, fe, es);
        		_log.debug("bundesRepResultList.size(): " + bundesRepResultList.size());
            	resultList.addAll(bundesRepResultList);
        		_log.debug("resultList.size(): " + resultList.size());
        	}
*/        	
        	return resultList;
        }
	}

	
	private List<List> getFullSearchApplicationsIndex(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es,
			String tc,
			int od
			) throws SystemException, SearchException {

	    
//		List<Vector<Object> applicationResultList = new ArrayList<Vector<Object>();
		List<List> applicationResultList = new ArrayList<List>();
		
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	    
        SearchContext searchContext = new SearchContext();
        
//        searchContext.setKeywords("title:\"" + ke + "\" OR description:\"" + ke + "\" OR regions:\"" + ke + "\" OR categoryString:\"" + ke + "\" OR targetOS:\"" + ke + "\"" );        	
        String Keywords = "(title:\"" + ke + "\" OR description:\"" + ke +"\")";
        
//        searchContext.setKeywords("(title:\"" + ke + "\" OR description:\"" + ke +")");       
        
        
//        searchContext.setKeywords(ke.toLowerCase());
        
        // categories
		String catString = "";
        if (ca != "" ) {
			try {
	        	String[] caIds = ca.split("_");
				_log.debug("caIds: " + caIds.length);
	        	
	        	boolean isFirst = true;
    			Category category;
	        	for (int i=0; i< caIds.length; i++ ) {
						category = CategoryLocalServiceUtil.getCategory(Long.parseLong(caIds[i]));
						_log.debug("category.getCategoryName(): " + category.getCategoryName());
		    			if (isFirst) {
		    				catString = " AND (categoryString:\"" + category.getCategoryName() +"\"";
		    				isFirst = false;
		    			} else {
		    				catString += " OR categoryString:\"" + category.getCategoryName() +"\"";
		    			}
	        	}
				catString += " ) ";
				_log.debug("catString: " + catString);
	        	
//				searchContext.setKeywords(catString);
				
				
			} catch (NumberFormatException | PortalException e) {
				e.printStackTrace();
			}
        }
        
        Keywords = Keywords + catString;

        
        // regions
		String regString = "";
        if (re != "" ) {
			try {
	        	String[] reIds = re.split("_");
				_log.debug("reIds: " + reIds.length);
	        	
	        	boolean isFirst = true;
    			Region region;
	        	for (int i=0; i< reIds.length; i++ ) {
	        		region = RegionLocalServiceUtil.getRegion(Long.parseLong(reIds[i]));
						_log.debug("region.getName(): " + region.getName());
		    			if (isFirst) {
		    				regString = " AND (regions:\"" + region.getName() +"\"";
		    				isFirst = false;
		    			} else {
		    				regString += " OR regions:\"" + region.getName() +"\"";
		    			}
	        	}
	        	regString += " ) ";
				_log.debug("regString: " + regString);				
			} catch (NumberFormatException | PortalException e) {
				e.printStackTrace();
			}
        }
        Keywords = Keywords + regString;        
        
        
        // targetOS
        // komplex: app:tos -> related apps:tos => "provided"  target OS
        // 										os: "required"  target OS
                
        
		_log.debug("Keywords: " + Keywords);
		searchContext.setKeywords(Keywords);
        
        QueryConfig queryConfig = new QueryConfig();
        queryConfig.setHighlightEnabled(false);
        queryConfig.setScoreEnabled(true);
        searchContext.setQueryConfig(queryConfig);
        
        searchContext.setCompanyId(co);
        
	     Hits results = indexer.search(searchContext);
		_log.debug("results: " + results.getLength());
		
		_log.debug("results.getQuery().toString(): " + results.getQuery().toString());
		_log.debug("results.getSearchTime(): " + results.getSearchTime());

		if (results.getLength() == 0) {
			if ( ! ke.endsWith("*") && ! ke.equalsIgnoreCase("null")) {
		        searchContext.setKeywords(ke.toLowerCase() + "*");			
			     results = indexer.search(searchContext);
				_log.debug("keywords: " + ke.toLowerCase() + "*" + " results: " + results.getLength());			
			}
		}		
		if (results.getLength() == 0) {
	        searchContext.setKeywords(ke.toLowerCase() + "~");			
		     results = indexer.search(searchContext);
			_log.debug("keywords: " + ke.toLowerCase() + "~" + " results: " + results.getLength());			
		}

		if (results.getLength() == 0) {
	        searchContext.setKeywords(ke.toLowerCase() + "~0.1");			
		     results = indexer.search(searchContext);
			_log.debug("keywords: " + ke.toLowerCase() + "~0.1" + " results: " + results.getLength());			
		}
		

        Application _application = null;

        
        for (int i=0; i<results.getLength(); i++) {
            
            Document doc = results.doc(i);
            long applicationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
//    		_log.debug("applicationId: " + applicationId);

            boolean passedLifeCycleStatusFilter = false;
//            boolean passedCategoryFilter = false; 
//            boolean passedRegionFilter = false; 
            boolean passedApplicationEntitlementFilter = false; 
            boolean passedTargetOSFilter = false; 
            boolean passedFeeFilter = false; 
            boolean passedTargetCategoryFilter = false;                		
            boolean passedOpenDataFilter = false;                		
            
            try {
            	_application = applicationLocalService.getApplication(applicationId);
            	

            	// Filter - LifeCycleStatus
            	if (_application.getLifeCycleStatus() >= 4) {
            		passedLifeCycleStatusFilter = true;
            	}
               	if (!passedLifeCycleStatusFilter) {
               		_log.debug("FAILED LifeCycleStatusFilter: " + applicationId);
               		continue;
               	}
/*            	
            	// Filter - Category            	
            	if (ca != null && ca.length()>0) {
            		passedCategoryFilter = filterCategory(_application, ca, "AND");
            	} else {
            		passedCategoryFilter = true;            		            		
            	}            	
            	if (!passedCategoryFilter) {
            		_log.debug("FAILED CategoryFilter: " + applicationId);
            		continue;
            	}
*/
            	
/*               	
            	// Filter - Region            	
            	if (re != null && re.length()>0) {
            		passedRegionFilter = filterRegion(_application, re, "AND");            		
            	} else {
            		passedRegionFilter = true;            		            		
            	}
            	if (!passedRegionFilter) {
            		_log.debug("FAILED RegionFilter: " + applicationId);
            		continue;
            	}
*/
            	// Filter - Application_Entitlement  
            	passedApplicationEntitlementFilter = filterEntitlement(_application, es, ap);           	
            	
            	if (!passedApplicationEntitlementFilter) {
            		_log.debug("FAILED passedApplicationEntitlementFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	
            	// Filter - targetOS
            	passedTargetOSFilter = filterOS(_application, to, "AND");            		
            	if (!passedTargetOSFilter) {
            		_log.debug("FAILED passedTargetOSFilter: " + applicationId);
            		continue;
            	}

            	passedFeeFilter = filterFee(_application, fe);
            	if (!passedFeeFilter) {
            		_log.debug("FAILED FeeFilter! applicationId: " + applicationId);
            		continue;
            	}

            	passedTargetCategoryFilter = filterTargetCategory(_application, tc, "AND");
            	if (!passedTargetCategoryFilter) {
            		_log.debug("FAILED TargetCategoryFilter! applicationId: " + applicationId);
            		continue;
            	}

            	// Filter - openData
            	passedOpenDataFilter = filterOpenData(_application, od);            		
            	if (!passedOpenDataFilter) {
            		_log.debug("FAILED passedOpenDataFilter: " + applicationId);
            		continue;
            	}

            	
        		// add _application to applicationResultList
//            	if (passedLifeCycleStatusFilter && passedCategoryFilter && passedRegionFilter && passedApplicationEntitlementFilter && passedTargetOSFilter && passedFeeFilter && passedTargetCategoryFilter && passedOpenDataFilter) {
            	if (passedLifeCycleStatusFilter && passedApplicationEntitlementFilter && passedTargetOSFilter && passedFeeFilter && passedTargetCategoryFilter && passedOpenDataFilter) {
            		List<Object> result = new ArrayList();
            		
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String theCategoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			theCategoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String theRegionIds = "";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			theRegionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
//        			result.add(_application);
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(theCategoryIds);
        			result.add(theRegionIds);
        			applicationResultList.add(result);        			
            	} else {
//            		_log.debug("failed app with id: " + applicationId);            		
            	}
            }
            catch (Exception e) {
            	_log.debug(e.getMessage());
            }
        }
        return applicationResultList;
	}
	

	private List<List> getFullSearchApplicationsIndex(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es
			) throws SystemException, SearchException {

	    
//		List<Vector<Object> applicationResultList = new ArrayList<Vector<Object>();
		List<List> applicationResultList = new ArrayList<List>();
		
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	    
        SearchContext searchContext = new SearchContext();
        searchContext.setKeywords("title:\"" + ke + "\" OR description:\"" + ke + "\" OR regions:\"" + ke + "\" OR categoryString:\"" + ke + "\" OR targetOS:\"" + ke + "\"" );        	
//        searchContext.setKeywords(ke.toLowerCase());
        QueryConfig queryConfig = new QueryConfig();
        queryConfig.setHighlightEnabled(false);
        queryConfig.setScoreEnabled(true);
        searchContext.setQueryConfig(queryConfig);
        
        searchContext.setCompanyId(co);
        
	     Hits results = indexer.search(searchContext);
		_log.debug("results: " + results.getLength());
		
		_log.debug("results.getQuery().toString(): " + results.getQuery().toString());
		_log.debug("results.getSearchTime(): " + results.getSearchTime());

		if (results.getLength() == 0) {
			if ( ! ke.endsWith("*") && ! ke.equalsIgnoreCase("null")) {
		        searchContext.setKeywords(ke.toLowerCase() + "*");			
			     results = indexer.search(searchContext);
				_log.debug("keywords: " + ke.toLowerCase() + "*" + " results: " + results.getLength());			
			}
		}		
		if (results.getLength() == 0) {
	        searchContext.setKeywords(ke.toLowerCase() + "~");			
		     results = indexer.search(searchContext);
			_log.debug("keywords: " + ke.toLowerCase() + "~" + " results: " + results.getLength());			
		}

		if (results.getLength() == 0) {
	        searchContext.setKeywords(ke.toLowerCase() + "~0.1");			
		     results = indexer.search(searchContext);
			_log.debug("keywords: " + ke.toLowerCase() + "~0.1" + " results: " + results.getLength());			
		}
		

        Application _application = null;

        
        for (int i=0; i<results.getLength(); i++) {
            
            Document doc = results.doc(i);
            long applicationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
//    		_log.debug("applicationId: " + applicationId);

            boolean passedLifeCycleStatusFilter = false;
            boolean passedCategoryFilter = false; 
            boolean passedRegionFilter = false; 
            boolean passedApplicationEntitlementFilter = false; 
            boolean passedTargetOSFilter = false; 
            boolean passedFeeFilter = false; 
            
            try {
            	_application = applicationLocalService.getApplication(applicationId);
            	

            	// Filter - LifeCycleStatus
            	if (_application.getLifeCycleStatus() >= 4) {
            		passedLifeCycleStatusFilter = true;
            	}
               	if (!passedLifeCycleStatusFilter) {
               		_log.debug("FAILED LifeCycleStatusFilter: " + applicationId);
               		continue;
               	}
            	
            	// Filter - Category            	
            	if (ca != null && ca.length()>0) {
            		passedCategoryFilter = filterCategory(_application, ca, "AND");
            	} else {
            		passedCategoryFilter = true;            		            		
            	}            	
            	if (!passedCategoryFilter) {
            		_log.debug("FAILED CategoryFilter: " + applicationId);
            		continue;
            	}

            	
            	// Filter - Region            	
            	if (re != null && re.length()>0) {
            		passedRegionFilter = filterRegion(_application, re, "AND");            		
            	} else {
            		passedRegionFilter = true;            		            		
            	}
            	if (!passedRegionFilter) {
            		_log.debug("FAILED RegionFilter: " + applicationId);
            		continue;
            	}

            	// Filter - Application_Entitlement  
            	passedApplicationEntitlementFilter = filterEntitlement(_application, es, ap);           	
            	
            	if (!passedApplicationEntitlementFilter) {
            		_log.debug("FAILED passedApplicationEntitlementFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	
            	// Filter - targetOS
            	passedTargetOSFilter = filterOS(_application, to, "AND");            		
            	if (!passedTargetOSFilter) {
            		_log.debug("FAILED passedTargetOSFilter: " + applicationId);
            		continue;
            	}

            	passedFeeFilter = filterFee(_application, fe);
            	if (!passedFeeFilter) {
            		_log.debug("FAILED FeeFilter! applicationId: " + applicationId);
            		continue;
            	}

            	
        		// add _application to applicationResultList
            	if (passedLifeCycleStatusFilter && passedCategoryFilter && passedRegionFilter && passedApplicationEntitlementFilter && passedTargetOSFilter && passedFeeFilter) {
            		List result = new ArrayList();
            		
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String theCategoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			theCategoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String theRegionIds = "";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			theRegionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
//        			result.add(_application);
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(theCategoryIds);
        			result.add(theRegionIds);
        			applicationResultList.add(result);        			
            	} else {
//            		_log.debug("failed app with id: " + applicationId);            		
            	}
            }
            catch (Exception e) {
            	_log.debug(e.getMessage());
            }
        }
        return applicationResultList;
	}

	
	private List<List> getFullSearchApplicationsList(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es,
			String tc,
			int od
			) throws SystemException, SearchException {

	    
//		List<Vector<Object> applicationResultList = new ArrayList<Vector<Object>();
		List<List> applicationResultList = new ArrayList<List>();
		
		
		List<Application> allApps = new ArrayList<Application>();
        
//   		_log.debug("re: " + re);
		// single region request => list apps with less regions first
		if (re != null && re.length() > 0 ) {
			List<Application> tmpAppList = applicationLocalService.getApplicationsBycl(10154, 4);
//       		_log.debug("tmpAppList" + tmpAppList.size());
			allApps.addAll(tmpAppList);
//			OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator("regionLength",  "asc");
			OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator("regionLength",  "desc");
	        Collections.sort(allApps, orderByComparator);
//       		_log.debug("allApps" + allApps.size());
		} else {
			allApps = applicationLocalService.getApplicationsBycl(10154, 4);
		}
		
        for (Application _application: allApps) {
            
            long applicationId = _application.getApplicationId();

            boolean passedLifeCycleStatusFilter = false;
            boolean passedCategoryFilter = false; 
            boolean passedRegionFilter = false; 
            boolean passedApplicationEntitlementFilter = false; 
            boolean passedTargetOSFilter = false; 
            boolean passedFeeFilter = false; 
            boolean passedTargetCategoryFilter = false; 
            boolean passedOpenDataFilter = false; 

            try {

            	// Filter - LifeCycleStatus
            	if (_application.getLifeCycleStatus() >= 4) {
            		passedLifeCycleStatusFilter = true;
            	}
               	if (!passedLifeCycleStatusFilter) {
               		_log.debug("FAILED LifeCycleStatusFilter: " + applicationId);
               		continue;
               	}
            	
            	// Filter - Category            	
            	if (ca != null && ca.length()>0) {
            		passedCategoryFilter = filterCategory(_application, ca, "AND");
            	} else {
            		passedCategoryFilter = true;            		            		
            	}            	
            	if (!passedCategoryFilter) {
            		_log.debug("FAILED CategoryFilter: " + applicationId);
            		continue;
            	}

            	
            	// Filter - Region            	
            	if (re != null && re.length()>0) {
            		passedRegionFilter = filterRegion(_application, re, "AND");            		
            	} else {
            		passedRegionFilter = true;            		            		
            	}
            	if (!passedRegionFilter) {
            		_log.debug("FAILED RegionFilter: " + applicationId);
            		continue;
            	} else {
            		_log.debug("applicationId: " + applicationId);            		
            		_log.debug("_application.getRegionString(): " + _application.getRegionString());            		
            	}

            	// Filter - Application_Entitlement  
            	passedApplicationEntitlementFilter = filterEntitlement(_application, es, ap);           	
            	
            	if (!passedApplicationEntitlementFilter) {
            		_log.debug("FAILED passedApplicationEntitlementFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	
            	// Filter - targetOS
            	passedTargetOSFilter = filterOS(_application, to, "AND");            		
            	if (!passedTargetOSFilter) {
            		_log.debug("FAILED passedTargetOSFilter: " + applicationId);
            		continue;
            	}

            	passedFeeFilter = filterFee(_application, fe);
            	if (!passedFeeFilter) {
            		_log.debug("FAILED FeeFilter! applicationId: " + applicationId);
            		continue;
            	}

            	passedTargetCategoryFilter = filterTargetCategory(_application, tc, "AND");
            	if (!passedTargetCategoryFilter) {
            		_log.debug("FAILED TargetCategoryFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	passedOpenDataFilter = filterOpenData(_application, od);
            	if (!passedOpenDataFilter) {
            		_log.debug("FAILED OpenDataFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	
        		// add _application to applicationResultList
            	if (passedLifeCycleStatusFilter && passedCategoryFilter && passedRegionFilter && passedApplicationEntitlementFilter && passedTargetOSFilter && passedFeeFilter && passedTargetCategoryFilter && passedOpenDataFilter) {
            		List result = new ArrayList();
            		
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String theCategoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			theCategoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String theRegionIds = "";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			theRegionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
//        			result.add(_application);
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(theCategoryIds);
        			result.add(theRegionIds);
        			applicationResultList.add(result);        			
            	} else {
//            		_log.debug("failed app with id: " + applicationId);            		
            	}
            }
            catch (Exception e) {
            	_log.debug(e.getMessage());
            }
        }
        return applicationResultList;
	}
	
	
	private List<List> getFullSearchApplicationsList(
			long co, 
			String ke, 
			String ca, 
			String re, 
			String ap, 
			String to, 
			int fe,
			int es
			) throws SystemException, SearchException {

	    
//		List<Vector<Object> applicationResultList = new ArrayList<Vector<Object>();
		List<List> applicationResultList = new ArrayList<List>();
		
		List<Application> allApps = new ArrayList<Application>();
		if (re != null && re.length() > 0 ) {
			List<Application> tmpAppList = applicationLocalService.getApplicationsBycl(10154, 4);
//       		_log.debug("tmpAppList" + tmpAppList.size());
			allApps.addAll(tmpAppList);
			OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator("regionLength",  "desc");
//	        Collections.sort(allApps, orderByComparator);
//       		_log.debug("allApps" + allApps.size());
		} else {
			allApps = applicationLocalService.getApplicationsBycl(10154, 4);
		}
        
        for (Application _application: allApps) {
            
            long applicationId = _application.getApplicationId();

            boolean passedLifeCycleStatusFilter = false;
            boolean passedCategoryFilter = false; 
            boolean passedRegionFilter = false; 
            boolean passedApplicationEntitlementFilter = false; 
            boolean passedTargetOSFilter = false; 
            boolean passedFeeFilter = false; 

            try {

            	// Filter - LifeCycleStatus
            	if (_application.getLifeCycleStatus() >= 4) {
            		passedLifeCycleStatusFilter = true;
            	}
               	if (!passedLifeCycleStatusFilter) {
               		_log.debug("FAILED LifeCycleStatusFilter: " + applicationId);
               		continue;
               	}
            	
            	// Filter - Category            	
            	if (ca != null && ca.length()>0) {
            		passedCategoryFilter = filterCategory(_application, ca, "AND");
            	} else {
            		passedCategoryFilter = true;            		            		
            	}            	
            	if (!passedCategoryFilter) {
            		_log.debug("FAILED CategoryFilter: " + applicationId);
            		continue;
            	}

            	
            	// Filter - Region            	
            	if (re != null && re.length()>0) {
            		passedRegionFilter = filterRegion(_application, re, "AND");            		
            	} else {
            		passedRegionFilter = true;            		            		
            	}
            	if (!passedRegionFilter) {
            		_log.debug("FAILED RegionFilter: " + applicationId);
            		continue;
            	}

            	// Filter - Application_Entitlement  
            	passedApplicationEntitlementFilter = filterEntitlement(_application, es, ap);           	
            	
            	if (!passedApplicationEntitlementFilter) {
            		_log.debug("FAILED passedApplicationEntitlementFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
            	
            	// Filter - targetOS
            	passedTargetOSFilter = filterOS(_application, to, "AND");            		
            	if (!passedTargetOSFilter) {
            		_log.debug("FAILED passedTargetOSFilter: " + applicationId);
            		continue;
            	}

            	passedFeeFilter = filterFee(_application, fe);
            	if (!passedFeeFilter) {
            		_log.debug("FAILED FeeFilter! applicationId: " + applicationId);
            		continue;
            	}
            	
        		// add _application to applicationResultList
            	if (passedLifeCycleStatusFilter && passedCategoryFilter && passedRegionFilter && passedApplicationEntitlementFilter && passedTargetOSFilter && passedFeeFilter) {
            		List result = new ArrayList();
            		
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String theCategoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			theCategoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String theRegionIds = "";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			theRegionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
//        			result.add(_application);
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(theCategoryIds);
        			result.add(theRegionIds);
        			applicationResultList.add(result);        			
            	} else {
//            		_log.debug("failed app with id: " + applicationId);            		
            	}
            }
            catch (Exception e) {
            	_log.debug(e.getMessage());
            }
        }
        return applicationResultList;
	}	
	
	private boolean filterCategory(Application application, String categories, String operator) throws SystemException, NumberFormatException, PortalException {
		List <Category> categoryList = new ArrayList<Category>();
    	List <Category> providedCategories = applicationLocalService.getCategories(application.getApplicationId());
		String[] categoryIdStrings = categories.split("_");            		
		for(int j=0; j<categoryIdStrings.length; j++) {
			Category category = CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryIdStrings[j]));
			categoryList.add(category);
		}
		if (operator.equalsIgnoreCase("AND")) { 
			return providedCategories.containsAll(categoryList);
    	} else {
    		for (Category _category : categoryList) {
    			if (providedCategories.contains(_category)) {
    				return true;
    			}    			
    		}
    		return false;
    	} 
	}

	
	private boolean filterRegion(Application application, String regions, String operator) throws SystemException, NumberFormatException, PortalException {
		List <Region> regionList = new ArrayList<Region>();
    	List <Region> providedRegions = applicationLocalService.getRegions(application.getApplicationId());
		String[] regionIdStrings = regions.split("_");
		for (int j = 0; j< regionIdStrings.length; j++) {
			Region region = RegionLocalServiceUtil.getRegion(Long.parseLong(regionIdStrings[j]));
			regionList.add(region);
		}
		if (operator.equalsIgnoreCase("AND")) {
			return providedRegions.containsAll(regionList);
    	} else {
    		for (Region _region : regionList) {
    			if (providedRegions.contains(_region)) {
    				return true;
    			}
    		}
    		return false;
    	}
	}
	
	
	// 	allowedApplicationEntitlementIds 1_2_3_4_5_6 ==>  	
	private boolean filterEntitlement(Application application, int singleEntitlement, String entitlements) throws SystemException {
		List<Long> allowedApplicationEntitlementIDList = new ArrayList<Long>();
		List<Long> providedApplicationEntitlementIDList = new ArrayList<Long>();
        List<Application_Entitlement> providedApplicationEntitlements = applicationLocalService.getApplicationEntitlements(application.getApplicationId());

		// singleEntitlement==0, UND entitlements=entilementID ==>  alle Apps die mindestens diese EINE Berechtigung (ap) benötigen
    	if (singleEntitlement == 0) {
    		for (int j = 0; j< providedApplicationEntitlements.size(); j++) {
    			providedApplicationEntitlementIDList.add(providedApplicationEntitlements.get(j).getEntitlementId());
    		}
    		// Alle Apps die mindestens diese EINE Berechtigung (ap) benötigen
    		return providedApplicationEntitlementIDList.contains(Long.parseLong(entitlements));
    		
    		
    	} else {

    		// app needs no entitlements -> always pass the entitlementFilter
    		if (providedApplicationEntitlements.isEmpty()) { 	
        		_log.debug("providedApplicationEntitlements.isEmpty()");            		
    			return true;
    		}
    		
    		// mindestens 1 Berechtigung erlaubt
        	if (entitlements != null && entitlements.length()>0) {
        		
        		String[] entIdStrings = entitlements.split("_");
        		
        		for (int j = 0; j< entIdStrings.length; j++) {
        			allowedApplicationEntitlementIDList.add(Long.parseLong(entIdStrings[j]));
        		}

        		for (int j = 0; j< providedApplicationEntitlements.size(); j++) {
        			providedApplicationEntitlementIDList.add(providedApplicationEntitlements.get(j).getEntitlementId());
        		}        		
        		return allowedApplicationEntitlementIDList.containsAll(providedApplicationEntitlementIDList);

//            		passedApplicationEntitlementFilter = providedApplicationEntitlementIDList.containsAll(allowedApplicationEntitlementIDList);
        	        	
    		// no entitlements allowed => pass the filter if no entitlements are required/provided by the app
        	} else {
        		_log.debug("entitlements: " + entitlements + " ==> providedApplicationEntitlements.isEmpty(): " + providedApplicationEntitlements.isEmpty());            		
        		return providedApplicationEntitlements.isEmpty();
        	}
    	}
		
	}
	
	
	// parameter os may contain multiple TargetOS e.g.: 	    - ""
	//                                                          - "iOS"
	// 															- "iOS_Windows"
	// 														    - "iOS_Android_Windows"
	private boolean filterOS(Application application, String os, String operator) throws NumberFormatException, PortalException, SystemException {
    	if (os != null && os.length()>0) {
    		
    		String[] requiredPlatforms = os.split("_");
			String _appdTargetOs = application.getTargetOS().toLowerCase().trim();
    		
			_log.debug("requiredPlatforms#: " + requiredPlatforms.length);
			// multiple requiredTargetOS -> look for related apps with requiredTargetOS 
			if (requiredPlatforms.length > 1) {
				
		        List<String> requiredTargetOSList = new ArrayList<String>();
		        
        		for(int k=0; k<requiredPlatforms.length;k++) {
        			requiredTargetOSList.add(requiredPlatforms[k].toLowerCase().trim());	            			
        		}
		        
		        List<String> providedTargetOSList = new ArrayList<String>();
		        
		        String[] relatedApplicationIdsStringArray = application.getRelatedApplicationId().split(";");

				providedTargetOSList.add(_appdTargetOs);
				
        		for(int k=0; k<relatedApplicationIdsStringArray.length;k++) {
        			providedTargetOSList.add(applicationLocalService.getApplication(Long.parseLong(relatedApplicationIdsStringArray[k])).getTargetOS().toLowerCase().trim());
        		}
        		
        		if (operator.equalsIgnoreCase("AND")) {
        			return providedTargetOSList.containsAll(requiredTargetOSList);
        		} else {
        			for (String targetOS: requiredTargetOSList) {
        				if (providedTargetOSList.contains(targetOS)) {
        					return true;
        				}
        			}
        		}
//   				passedTargetOSFilter = requiredTargetOSList.containsAll(providedTargetOSList);
			} else {
				// only 1 requiredTargetOS
				return os.trim().toLowerCase().equalsIgnoreCase(_appdTargetOs);        				
			}
			// TargetOS = ""
    	} else {
    		if (operator.equalsIgnoreCase("AND")) {
        		return true;
    		} else {
    			return false;            			
    		}
    	}
    	return false;    			
	}
	

	// Filter - fee
	// 0 -> nur kostenlos
	// 1 -> nur kostenpflichtig
	// else (z.B. 2, -1) : alle
	private boolean filterFee(Application application, int fee) throws SystemException, PortalException {
		
    	if (fee == 0 && application.getFee() != 0) {
   			return false;
    	}
   		if (fee == 1 && application.getFee() == 0) {
			return false;
    	}
   		if (fee == -1) {
			return true;
    	}
		return true;
	}
	
	
	//"smartphone" oder "tablet" oder "smartphone_tablet"
	private boolean filterTargetCategory(Application application, String targetCategory, String operator) throws SystemException, PortalException {
		String[] requiredTargetCategory = targetCategory.split("_");
		// "smartphone" oder "tablet" 
		if (targetCategory.equalsIgnoreCase("") || targetCategory.isEmpty() || targetCategory == null) {
			return true;
		}
		if (requiredTargetCategory.length ==1 ) {
        	_log.debug("application.getTargetCategory(): " + application.getTargetCategory());
        	_log.debug("requiredTargetCategory[0]: " + requiredTargetCategory[0]);
			return application.getTargetCategory().contains(requiredTargetCategory[0]);
			// smartphone_tablet
		} else {
			if (operator.equalsIgnoreCase("AND")) { 
				String os = application.getTargetOS();
				String relAppIds = application.getRelatedApplicationId();
				
				String reqTC = "";
				
				if (application.getTargetCategory().equalsIgnoreCase("Tablet")) {
					reqTC = "Smartphone";
				}  else {
					if (application.getTargetCategory().equalsIgnoreCase("Smartphone")) {
						reqTC = "Tablet";
					} else {
						return true;
					}
				}
				
				String[] relAppIdsArray = relAppIds.split("_");
				for (int i=0; i<relAppIdsArray.length; i++) {
					String provTC = applicationLocalService.getApplication(Long.parseLong(relAppIdsArray[i])).getTargetCategory();
					if (provTC.contains(reqTC) && applicationLocalService.getApplication(Long.parseLong(relAppIdsArray[i])).getTargetOS().equals(os)) {
						return true;
					}
				}
				// smartphone OR table =>  
			} else {
				return true;				
			}
		}
		return false;
	}
	
	
	// Filter - openData
	// 1 -> use open data
	// else (z.B. 2, -1) : alle
	private boolean filterOpenData(Application application, int od) throws SystemException, PortalException {
		
   		if (od == 1 && application.getUseOpenData() != 1) {
			return false;
    	}
		return true;
	}


	/**
	 *  search Applications with several aspects: categories, regions, entitlement, costs, platforms
	 *  all aspects are connected by AND
	 *  all aspects are internally connected by AND  
	 *  
	 *  @param co companyId default: (10154)
	 *  @param op boolean operator for different aspects: may be 'AND' or  'OR' ==>  categories AND regions AND ...   ;categories OR regions OR .... 
	 *  @param kop boolean operator for keywords: may be 'AND' or  'OR' ==>  searchString1 AND searchString2 AND ...    ;searchString1 OR searchString2 OR .... 
	 *  @param ke keywords may be 'null', '', 'searchString', 'two searchStrings', ... 
	 *  @param cop boolean operator for categories: may be 'AND' or  'OR' ==>  categoryID1 AND categoryID2 AND ...    ;categoryID1 OR categoryID2 OR .... 
	 *  @param ca CategoryIds may be '', '1_2_3', ... 
	 *  @param rop boolean operator for regions: may be 'AND' or  'OR' ==>  regionID1 AND regionID2 AND ...    ;regionyID1 OR regionID2 OR .... 
	 *  @param re RegionIds may be '', '1_2_3', ... 
	 *  @param ap allowed ApplicationEntitlementIds may be '', '1_2_3_4_5_6', ... 
	 *  @param top boolean operator for TargetOS: may be 'AND' or  'OR' ==>  iOS AND Android AND ...    ;iOS OR Android OR .... 
	 *  @param to required TargetOS may be '', iOS', 'iOS_Android_Windows', ... 
	 *  @param fe required fee may be   0 -> kostenlos, 1 -> kostenpflichtig, else (z.B. 2) : alle
	 *  @param es  search single entitlement may be   0 -> get all apps with at least this entitlement, else (z.B. 2) : alle
 
	 */
	public List<List> complexSearchApplications(
			long co,
			String op, 
			String kop,
			String ke, 
			String cop, 
			String ca, 
			String rop,
			String re, 
			String ap, 
			String top, 
			String to, 
			int fe,
			int es,
			String sop, 			
			String tc
			) throws SystemException, SearchException {

		 _log.debug("getFullSearchApplications(companyId co: " + co +
			", OPERATOR op: " + op +
			", OPERATOR kop: " + kop +
			", keywords ke: " + ke +
			", OPERATOR cop: " + cop +
		    ", CategoryIds ca: " + ca + 
			", OPERATOR rop: " + rop +
		    ", RegionIds re: " + re +
			", allowedApplicationEntitlementIds ap: " + ap + 
			", OPERATOR top: " + top +
			", TargetOS to: " + to + 
			", fee fe: " + fe  +
			", es: " + es +", sop: " + sop +", tc: " + tc  
			+ ")");
	    
		_log.debug(co + " | " + op + " | " +  kop + " | " + ke + " | " +  cop + " | " + ca + " | " +  rop + " | " + re + " | " + ap + " | " +  top + " | " + to + " | " + fe  + " | " + es +  sop + " | " + tc);
		
		List<List> applicationResultList = new ArrayList<List>();
		
		if ( !( op.equalsIgnoreCase("AND") ||  op.equalsIgnoreCase("OR")) ||
  		     !(kop.equalsIgnoreCase("AND") || kop.equalsIgnoreCase("OR")) ||
  		     !(cop.equalsIgnoreCase("AND") || cop.equalsIgnoreCase("OR")) ||
  		     !(rop.equalsIgnoreCase("AND") || rop.equalsIgnoreCase("OR")) ||
  		     !(top.equalsIgnoreCase("AND") || top.equalsIgnoreCase("OR")) ||
  		     !(sop.equalsIgnoreCase("AND") || sop.equalsIgnoreCase("OR")) 
  		     ) {
			return  applicationResultList;
		}
		
        Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);
	    
        SearchContext searchContext = new SearchContext();
        searchContext.setKeywords("title:\"" + ke + "\" OR description:\"" + ke + "\" OR regions:\"" + ke + "\" OR categoryString:\"" + ke + "\" OR targetOS:\"" + ke + "\"" );
        QueryConfig queryConfig = new QueryConfig();
        queryConfig.setHighlightEnabled(false);
        queryConfig.setScoreEnabled(true);
        searchContext.setQueryConfig(queryConfig);
               
        searchContext.setCompanyId(co);
        
        Hits results = indexer.search(searchContext);
		_log.debug(ke + " -> results: " + results.getLength());
			
		
        Application _application = null;
        
        for (int i=0; i<results.getLength(); i++) {
            
            Document doc = results.doc(i);
            long applicationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
//    		_log.debug("applicationId: " + applicationId);

            boolean passedLifeCycleStatusFilter = false;
            boolean passedCategoryFilter = false; 
            boolean passedRegionFilter = false; 
            boolean passedApplicationEntitlementFilter = false; 
            boolean passedTargetOSFilter = false; 
            boolean passedFeeFilter = false; 
            boolean passedTargetCategoryFilter = false; 
    		
            try {
            	_application = applicationLocalService.getApplication(applicationId);
            	
            	// Filter - LifeCycleStatus
            	if (_application.getLifeCycleStatus() >= 4) {
            		passedLifeCycleStatusFilter = true;
            	}
               	if (!passedLifeCycleStatusFilter) {
               		_log.debug("FAILED LifeCycleStatusFilter! applicationId: " + applicationId);
//               		continue;
               	}
            	
            	
            	// Filter - Category            	
            	if (ca != null && ca.length() > 0) {
            		passedCategoryFilter = filterCategory(_application, ca, cop);
            		
               	// Category = ""
            	} else {
            		if (cop.equalsIgnoreCase("AND")) {            		
	            		passedCategoryFilter = true;            		            		
            	    } else {            	    	
	            		passedCategoryFilter = false;            		            		
            	    }            		
            	}            	  
            	
            	if (!passedCategoryFilter) {
            		_log.debug("FAILED CategoryFilter! applicationId: " + applicationId);
//            		continue;
            	}

            	
            	// Filter - Region            	
            	if (re != null && re.length() > 0) {
            		passedRegionFilter = filterRegion(_application, re, rop);
            	// region = ""
            	} else {
            		if (rop.equalsIgnoreCase("AND")) {
            			passedRegionFilter = true;            		            		
            	    } else {            	    	
            	    	passedRegionFilter = false;            		            		
            	    }
            	}
            	if (!passedRegionFilter) {
            		_log.debug("FAILED RegionFilter! applicationId: " + applicationId);
//            		continue;
            	}

            	
            	// Filter - Application_Entitlement  
            	passedApplicationEntitlementFilter = filterEntitlement(_application, es, ap);
            	
            	if (!passedApplicationEntitlementFilter) {
            		_log.debug("FAILED ApplicationEntitlementFilter! applicationId: " + applicationId);
//            		continue;
            	}
            	
            	// Filter - targetOS
            	passedTargetOSFilter = filterOS(_application, to, top);            	
            	if (!passedTargetOSFilter) {
            		_log.debug("FAILED TargetOSFilter! applicationId: " + applicationId);
//            		continue;
            	}

            	// Filter - fee
            	passedFeeFilter = filterFee(_application, fe);
            	if (!passedFeeFilter) {
            		_log.debug("FAILED FeeFilter! applicationId: " + applicationId);
//            		continue;
            	}

            	passedTargetCategoryFilter = filterTargetCategory(_application, tc, sop);
            	if (!passedTargetCategoryFilter) {
            		_log.debug("FAILED TargetCategoryFilter! applicationId: " + applicationId);
//            		continue;
            	}
            	
           		// add _application to applicationResultList
           		boolean passedAllFilters = false;
           		if (op.equalsIgnoreCase("AND")) {
           			passedAllFilters = (passedApplicationEntitlementFilter && passedFeeFilter && passedLifeCycleStatusFilter) && (passedCategoryFilter && passedRegionFilter && passedTargetOSFilter && passedTargetCategoryFilter);
           		} else {
           			passedAllFilters = (passedApplicationEntitlementFilter && passedFeeFilter && passedLifeCycleStatusFilter) && (passedCategoryFilter || passedRegionFilter || passedTargetOSFilter || passedTargetCategoryFilter);
           		}
            	if (passedAllFilters) {
            		List result = new ArrayList();
            		
            		List<Application_Entitlement> app_entitlements = applicationLocalService.getApplicationEntitlements(applicationId);
            		
            		String entitlements = "";
            		List<String> motivations = new ArrayList<String>();
            		for(Application_Entitlement app_ent:app_entitlements) {
            			entitlements+=Long.toString(app_ent.getEntitlementId())+",";
            			motivations.add(app_ent.getMotivation());
            		}
            		
            		String theCategoryIds = "";
            		
            		for(Category cat:applicationLocalService.getCategories(applicationId)) {
            			theCategoryIds+=(Long.toString(cat.getCategoryId())+",");
            		}
            		
            		String theRegionIds = "";
            		for(Region reg:applicationLocalService.getRegions(applicationId)) {
            			theRegionIds+=(Long.toString(reg.getRegionId())+",");
            		}
            		
        			result.add(entitlements);
        			result.add(getIconURL(applicationId));
        			result.add(replaceHTMLTags(_application));
        			result.add(motivations);
        			result.add(theCategoryIds);
        			result.add(theRegionIds);

        			applicationResultList.add(result);        			
            	} else {
            		_log.debug("failed app with id: " + applicationId);            		
            	}            		
            }
            catch (Exception e) {
                continue;
            }
        }
		_log.debug("applicationResultList.size(): " + applicationResultList.size());            		
        return applicationResultList;
	}	
	
	
	
	
	

	
	public List<List> getSimilarApplications(long companyId, long applicationId, boolean byCategory, boolean byRegion) {

		List<List> applicationResultList = new ArrayList<List>();
	
        Application _application = null;
        List<Category> allCategories = new ArrayList<Category>();
        List<Region> allRegions = new ArrayList<Region>();
        
        try {
        	_application = applicationLocalService.getApplication(applicationId);
        	
        	allCategories = applicationLocalService.getCategories(applicationId);
        	allRegions = applicationLocalService.getRegions(applicationId);

        	if (byCategory) {
            	List<Application>  byCategories=  applicationLocalService.getApplicationsByCategories(allCategories);
            	
            	for (Application _c_application: byCategories) {
                	// Filter - LifeCycleStatus
            		List result = new ArrayList(); 
            		
            		Vector<Long> relatedApplicationIdsLong = new Vector<Long>();
            		String relatedApplicationId = _c_application.getRelatedApplicationId();
            		if (relatedApplicationId.length() > 0) {
            			String [] relatedApplicationIds = relatedApplicationId.split(";");

            			for (int i = 0; i<relatedApplicationIds.length; i++) {
            				relatedApplicationIdsLong.add(Long.parseLong(relatedApplicationIds[i]));            				
            			}			
            		}

                	if (_c_application.getLifeCycleStatus() >= 4 && _c_application.getApplicationId() != applicationId && (!relatedApplicationIdsLong.contains(applicationId))) {    
//                	if (_c_application.getApplicationId() != applicationId && (!relatedApplicationIdsLong.contains(applicationId))) {    
                		result.add(_c_application);
                		result.add(getIconURL(_c_application.getApplicationId()));
                		applicationResultList.add(result);
                	}
            		
            	}
        	}

        	if (byRegion) {
            	List<Application>  byRegions=  applicationLocalService.getApplicationsByRegions(allRegions);
            	
            	for (Application _r_application: byRegions) {
                	// Filter - LifeCycleStatus
            		Vector<Object> result = new Vector<Object>();
            		
            		Vector<Long> relatedApplicationIdsLong = new Vector<Long>();
            		String relatedApplicationId = _r_application.getRelatedApplicationId();
            		if (relatedApplicationId.length() > 0) {
            			String [] relatedApplicationIds = relatedApplicationId.split(";");

            			for (int i = 0; i<relatedApplicationIds.length; i++) {
            				relatedApplicationIdsLong.add(Long.parseLong(relatedApplicationIds[i]));            				
            			}			
            		}
                	if (_r_application.getLifeCycleStatus() >= 4 && _r_application.getApplicationId() != applicationId && (!relatedApplicationIdsLong.contains(applicationId))) {
//                	if (_r_application.getApplicationId() != applicationId && (!relatedApplicationIdsLong.contains(applicationId))) {            		
                		result.add(_r_application);
                		result.add(getIconURL(_r_application.getApplicationId()));
                		applicationResultList.add(result);
                	}
            		
            	}
        	}
        	
        } catch (Exception e) {
        	_log.debug(e.getMessage());
        }
	
        return applicationResultList;
	}
	
	
	public List<Application> getApplicationsFromSamePublisher(long companyId, long userId) throws SystemException {
		return applicationLocalService.getApplications(companyId, userId);		
	}
	
	
	public String getIconURL(long applicationId) throws Exception {
		String result = "";		
		try {
//			_log.debug("getIconURL(applicationId " + applicationId + ")");	
			Application application = applicationLocalService.getApplication(applicationId);
			if (application.getLogoImageId() != 0) {
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(application.getLogoImageId());
				result = "http://localhost/documents/10180/0/" + 
						HttpUtil.encodeURL(HtmlUtil.unescape(fe.getTitle())) + 
						StringPool.SLASH + 
						fe.getUuid() +
						"?version=" + fe.getVersion() +
						"&t=" + fe.getModifiedDate().getTime() +
						"&imageThumbnail=1";				
			}
					
		} catch (SystemException se) {
			_log.error("applicationId: " + applicationId);				
			_log.error(se.getMessage());		
		} catch (PortalException pe) {
			_log.error("applicationId: " + applicationId);				
			_log.error(pe.getMessage());				
		}
		return result;		
	}
	

	private String getExternIconURL(Application application) throws Exception {
		String result = "";		
		try {
			if (application.getLogoImageId() != 0) {
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(application.getLogoImageId());
				result = "http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + 
						HttpUtil.encodeURL(HtmlUtil.unescape(fe.getTitle())) + 
						StringPool.SLASH + 
						fe.getUuid() +
						"?version=" + fe.getVersion() +
						"&t=" + fe.getModifiedDate().getTime() +
						"&imageThumbnail=1";				
			}
					
		} catch (SystemException se) {
			_log.error(se.getMessage());				
		} catch (PortalException pe) {
			_log.error(pe.getMessage());				
		}
		return result;		
	}

	
	public List<String> getImageURLs(long applicationId) {
		List<String> result = new ArrayList<String>();		
		try {
			List<MultiMedia> allMultiMedias = applicationLocalService.getMultiMedias(applicationId);
			
			for (MultiMedia multiMedia : allMultiMedias) {			
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(multiMedia.getImageId());
				result.add("http://localhost/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
			}
		} catch (SystemException se) {
			_log.error(se.getMessage());		
		} catch (PortalException pe) {
			_log.error(pe.getMessage());				
		}
		return result;		
	}
	
	public List<String> getExternImageURLs(Application application) {
		List<String> result = new ArrayList<String>();		
		try {
			List<MultiMedia> allMultiMedias = applicationLocalService.getMultiMedias(application.getApplicationId());
			
			for (MultiMedia multiMedia : allMultiMedias) {			
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(multiMedia.getImageId());
				result.add("http://" +  AppConstants.COMPANY_VIRTUAL_HOST + "/documents/10180/0/" + HttpUtil.encodeURL(fe.getTitle(), true));
			}
		} catch (SystemException se) {
			_log.error(se.getMessage());		
		} catch (PortalException pe) {
			_log.error(pe.getMessage());				
		}
		return result;		
	}
	
	public Vector<Object> getApplicationDetailsEI(long applicationId) throws Exception {
		Vector<Object> result = new Vector<Object>();
		try {
			// Logging
			AppDetailsLog.log(applicationId);
			Application _application = applicationLocalService.getApplication(applicationId);
			_application.setDetailsViewed(_application.getDetailsViewed() +1);
			applicationPersistence.update(_application, true);

			result.add(applicationLocalService.getApplicationEntitlements(applicationId));
			result.add(getIconURL(applicationId));
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
		return result;
	}
	
	
	public Vector<Object> getApplicationDetailsEIS(long applicationId) throws Exception {
		Vector<Object> result = new Vector<Object>();
		try {
			// Logging
			AppDetailsLog.log(applicationId);
			Application _application = applicationLocalService.getApplication(applicationId);
			_application.setDetailsViewed(_application.getDetailsViewed() +1);
			applicationPersistence.update(_application, true);

			result.add(applicationLocalService.getApplicationEntitlements(applicationId));
			result.add(getIconURL(applicationId));
			result.add(getImageURLs(applicationId));
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
		return result;
	}
	
	
	public Vector<Object> getFullApplicationDetailsEISCRLLA(long applicationId) throws Exception {		
		Vector<Object> result = new Vector<Object>();
		try {
			// Logging
			AppDetailsLog.log(applicationId);
			Application _application = applicationLocalService.getApplication(applicationId);
			_application.setDetailsViewed(_application.getDetailsViewed() +1);
			applicationPersistence.update(_application, true);
			
			result.add(applicationLocalService.getApplicationEntitlements(applicationId));
			result.add(getIconURL(applicationId));
			result.add(getImageURLs(applicationId));
			result.add(applicationLocalService.getCategories(applicationId));
			result.add(applicationLocalService.getRegions(applicationId));
			result.add(applicationLocalService.getLanguages(applicationId));
			result.add(applicationLocalService.getLinks(applicationId));
			result.add(applicationLocalService.getApplication(applicationId));
			result.add(applicationLocalService.getUserEmailAddressByApplication(applicationId));
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		} catch (PortalException e) {
			_log.debug(e.getMessage());
		}
		return result;
	}
	
	
	private Application replaceHTMLTags(Application app) {
		Application result = app;
		String description = app.getDescription();
		result.setDescription(replaceHTMLTags(description));
		return result;
	}
	
	
	private String replaceHTMLTags(String desc) {

    	String HTMLTag = "";
    	int beginIndex = 0;
    	int endIndex = 0;
    	try {
	    	beginIndex = desc.indexOf("<");
	    	endIndex = desc.indexOf(">");
	    	
	    	if (beginIndex >= 0 && endIndex > 0) {
		    	HTMLTag = desc.substring(beginIndex, endIndex +1);
//		    	_log.debug("HTMLTag: " + HTMLTag);
		    	desc = desc.replaceAll(HTMLTag, "");
		    	return replaceHTMLTags(desc);	    		
	    	} else {
		    	return desc;
	    	}
    	} catch (Exception e) {
	    	_log.debug("Exception: " + e.getMessage());
	    	return desc;    		
    	}
	}

	
	public void updateStatusString(long companyId) throws SystemException {
		applicationLocalService.updateStatusString(companyId);
	}
	
	
	public List<Application> getLinkDoubles() throws SystemException {
		return applicationLocalService.getLinkDoubles();
	}

	
	public List<Long> getRelatedApplications() throws SystemException {
		return applicationLocalService.getRelatedApplications();
	}

	
	public void removeWhitespaceFromTargetOS() throws SystemException {
		applicationLocalService.removeWhitespaceFromTargetOS();
	}
	
	
	public List<String> getAllApplicationNames() throws SystemException {
		List<String> allApplicationNames = new ArrayList<String>();
		try {
			List<Application> allApplication = applicationLocalService.getApplicationsBycl(10154, 4);
//			List<Application> allApplication = applicationLocalService.getApplications(10154);
			for (Application application : allApplication) {
//				if (! allApplicationNames.contains(application.getName()) && application.getLifeCycleStatus() >= 4) {
				allApplicationNames.add(application.getName());
//				}
			}
			return allApplicationNames;
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			allApplicationNames.add(e.getMessage());
			return allApplicationNames;
		}
	}
	
	public void clickApplicationLink(long applicationId) {
		_log.debug("clickApplicationLink::applicationId: " + applicationId);
		try {
			AppClickedLog.log(applicationId);
			// Logging
			AppDetailsLog.log(applicationId);
			Application _application = applicationLocalService.getApplication(applicationId);
			_application.setLinkClicked(_application.getLinkClicked() +1);
			applicationPersistence.update(_application, true);
		} catch (PortalException e) {
			_log.debug(e.getMessage());
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
	}
	
	
	private boolean containsIdString(String myString, String id, String seperator) {
	    _log.debug("myString: " + myString);
	    _log.debug("id: " + id);
				
		if (myString.contains(seperator + id + seperator)) {
			_log.debug("contains(Seperator + id + Seperator)" );
			return true;
			
		} else if (myString.matches("([^\\s]*" + seperator + id+")")) {;
		_log.debug("contains("+seperator + id + "EOL)");			
			return true;
			
		} else if (myString.matches("(^" + id + seperator + "[^\\s]*)" )) {
			_log.debug("contains(" + id + seperator + "[...])");
			return true;
			
		} else  if (myString.equalsIgnoreCase(id)) {
			_log.debug("equalsIgnoreCase(" + id + ")" );
			return true;			
		}
		return false;
	}
	
/*	
	public List<List> getOpenDataApps() {
		List<List> result = new ArrayList<List>();
		List<Application> appList = new ArrayList<Application>();
		try {			
			appList = applicationLocalService.getOpenDataApps();
			for (Application application: appList) {
        		List sList = new ArrayList();
				long applicationId = application.getApplicationId();

				sList.add(application);
        		sList.add(getExternIconURL(application));
        		sList.add(getExternImageURLs(application));
        		sList.add(applicationLocalService.getCategories(applicationId));
        		sList.add(applicationLocalService.getRegions(applicationId));
        		sList.add(applicationLocalService.getLanguages(applicationId));
        		sList.add(applicationLocalService.getLinks(applicationId));
								
				result.add(sList);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
*/	
	
/*
	public List<Object> getOGPD_Entities() {
		List<Object> result = new ArrayList<Object>();
		try {			
			result = applicationLocalService.getOGPD_Entities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
*/
}
