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
 * $Id: LoggingLocalServiceImpl.java 566 2014-11-13 15:22:01Z sma $
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
import java.util.Iterator;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;

import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Logging;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.model.impl.LoggingImpl;
import de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.base.LoggingLocalServiceBaseImpl;
import de.fraunhofer.fokus.movepla.util.CustomComparatorUtil;

/**
 * The implementation of the logging local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.fraunhofer.fokus.movepla.service.LoggingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.base.LoggingLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.movepla.service.LoggingLocalServiceUtil
 */
public class LoggingLocalServiceImpl extends LoggingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.fraunhofer.fokus.movepla.service.LoggingLocalServiceUtil} to access the logging local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(LoggingLocalServiceImpl.class);

	public void addSimpleLog(String searchString) {
		try {
			
			List<Logging> logList = loggingPersistence.findBysearchString(searchString);
			boolean isNew = true;
			
			for (Logging logging:  logList) {
				if (logging.getIsSimpleSearch()) {
					isNew = false;
				}
			}
			
			// new Log-entry
			if (isNew) {
				long logID = CounterLocalServiceUtil.increment(Logging.class.getName());				
				Logging logging =  loggingPersistence.create(logID);
				logging.setCreateDate(new Date());
				logging.setModifiedDate(new Date());
				logging.setIsSimpleSearch(true);
				logging.setPassel(1);
				logging.setSearchString(searchString);
				loggingPersistence.update(logging, true);
			// update Log-entry for simpleSearch: increment passel
			} else {
				for (Logging logging:  logList) {
					if (logging.getIsSimpleSearch()) {
						logging.setPassel(logging.getPassel() + 1);
						logging.setModifiedDate(new Date());
						loggingPersistence.update(logging, true);
					}
				}				
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
	}
	
	/*
	 * 			", keywords ke: " + ke +
		    ", requiredCategoryIds ca: " + ca + 
		    ", requiredRegionIds re: " + re +
			", allowedApplicationEntitlementIds ap: " + ap + 
			", requiredTargetOS to: " + to + 
			", fee fe: " + fe  +
			", es: " + es + ", tc: " + tc  

	 */
	public void addComplexLog(String searchString, String categoryIDString, String regionIDString, String entitlementIDString, String targetOS, int fee, String targetCategory) {
		try {
			List<Logging> logList = loggingPersistence.findByall(searchString, categoryIDString, regionIDString, entitlementIDString, targetOS, fee, targetCategory);
			_log.debug("logList.size(): " + logList.size());

			// new Log-entry
			if (logList.size() == 0) {
				long logID = CounterLocalServiceUtil.increment(Logging.class.getName());				
				Logging logging =  loggingPersistence.create(logID);
				logging.setCreateDate(new Date());
				logging.setModifiedDate(new Date());
				logging.setIsSimpleSearch(false);
				logging.setPassel(1);
				logging.setSearchString(searchString);
				logging.setCategoryIDString(categoryIDString);
				logging.setRegionIDString(regionIDString);
				logging.setEntitlementIDString(entitlementIDString);
				logging.setTargetOS(targetOS);
				logging.setFee(fee);
				logging.setTargetCategory(targetCategory);
				loggingPersistence.update(logging, true);				
				// update Log-entry for complex search: increment passel
			} else {
				for (Logging logging:  logList) {
					if (logging.getIsSimpleSearch() == false) {
						logging.setPassel(logging.getPassel() + 1);
						logging.setModifiedDate(new Date());
						loggingPersistence.update(logging, true);
					}
				}				
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
	}
	
	
	public List<Logging> getMostUsedSearchStringNotNull() {
		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
			
			Criterion criterion = RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.like("searchString", "null"));
			dynamicQuery.add(criterion);
					
			Order defaultOrder = OrderFactoryUtil.desc("passel");
			dynamicQuery.addOrder(defaultOrder); 
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Logging> getAllLoggings() {		
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
								
			Order defaultOrder = OrderFactoryUtil.desc("passel");
			dynamicQuery.addOrder(defaultOrder); 
							
			return dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Logging> getMostUsedSearchStringInclNull() {
		
		List<Logging> resultList = new ArrayList<Logging>();
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
								
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

			projectionList.add(ProjectionFactoryUtil.groupProperty("searchString"));
			projectionList.add(ProjectionFactoryUtil.sum("passel"));

			dynamicQuery.setProjection(projectionList);			
						
			Order defaultOrder = OrderFactoryUtil.desc("passel");
			dynamicQuery.addOrder(defaultOrder); 
			List  result = dynamicQuery(dynamicQuery);
			_log.info(result.size());
			
			Iterator it = result.iterator();
			
			if(!it.hasNext()) {
			    _log.info("No any data!");
			} else {
				while(it.hasNext()) {
					Logging log = new LoggingImpl();
					Object[] row = (Object[]) it.next();
//					for(int i = 0; i < row.length;i++) {
//					    _log.info(row[i]);
//					}
					log.setSearchString(String.valueOf(row[0]));
					log.setPassel(Long.parseLong(String.valueOf(row[1])));	
					resultList.add(log);
				}
			}
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
	    }
		return resultList;
	}
	
	
	public List<Logging> getLoggingsByCategories() {
		
		List<Logging> resultList = new ArrayList<Logging>();
        List<Logging> tmpApplications = new ArrayList<Logging>();
		try {
			
			List <Category> allCategories = CategoryLocalServiceUtil.getCategories(10154);
			
			for (Category category : allCategories) {
			
				String catIdString = String.valueOf( category.getCategoryId());
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
									
				ProjectionList projectionList = ProjectionFactoryUtil.projectionList();	
				projectionList.add(ProjectionFactoryUtil.sum("passel"));
				dynamicQuery.setProjection(projectionList);			
							
				// only one category
				Criterion criterion = RestrictionsFactoryUtil.like("categoryIDString", catIdString);
				// categoryId at the beginning
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("categoryIDString", catIdString + ";" + StringPool.PERCENT));
				// categoryId at the end
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("categoryIDString", StringPool.PERCENT + ";" + catIdString));
				// categoryId in the middle
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("categoryIDString", StringPool.PERCENT + ";" + catIdString + ";" + StringPool.PERCENT));
				
				dynamicQuery.add(criterion);
	
				Order defaultOrder = OrderFactoryUtil.desc("passel");
				dynamicQuery.addOrder(defaultOrder); 

				List<Long>  result = dynamicQuery(dynamicQuery);
//				_log.info("catIdString::result.size(): " + catIdString + "::" + result.size());
				
				if (result.size() > 0) {
					
//				    _log.info("result.get(0): " + result.get(0));
					if (result.get(0) != null) {
						Logging log = new LoggingImpl();
						log.setCategoryIDString(category.getCategoryName());
						
					    long _p = result.get(0);
//					    _log.info("_p: " + _p);
						log.setPassel(_p);	
						tmpApplications.add(log);
//						_log.info("tmpApplications.size(): " + tmpApplications.size());
					} else {
						continue;
					}
				}
			}
			resultList.addAll(tmpApplications);
			
			OrderByComparator orderByComparator = CustomComparatorUtil.getLoggingOrderByComparator("passel", "desc");			
			Collections.sort(resultList, orderByComparator);
			
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
			e.printStackTrace();
	    }
		return resultList;
	}
	
/*
List<Logging> logsByTargetCategories        = LoggingLocalServiceUtil.getLoggingsByTargetCategories();
if (logsByTargetCategories  == null) {
    logsByTargetCategories = new ArrayList<Logging>();
}
 */
	
	public List<Logging> getLoggingsByRegions() {
		
		List<Logging> resultList = new ArrayList<Logging>();
        List<Logging> tmpApplications = new ArrayList<Logging>();
		try {
			
			List <Region> allRegions = RegionLocalServiceUtil.findByc(10154);
			
			for (Region region : allRegions) {
			
				String regIdString = String.valueOf(region.getRegionId());
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
									
				ProjectionList projectionList = ProjectionFactoryUtil.projectionList();	
				projectionList.add(ProjectionFactoryUtil.sum("passel"));
				dynamicQuery.setProjection(projectionList);			
							
				// only one category
				Criterion criterion = RestrictionsFactoryUtil.like("regionIDString", regIdString);
				// categoryId at the beginning
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("regionIDString", regIdString + ";" + StringPool.PERCENT));
				// categoryId at the end
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("regionIDString", StringPool.PERCENT + ";" + regIdString));
				// categoryId in the middle
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("regionIDString", StringPool.PERCENT + ";" + regIdString + ";" + StringPool.PERCENT));
				
				dynamicQuery.add(criterion);
	
				Order defaultOrder = OrderFactoryUtil.desc("passel");
				dynamicQuery.addOrder(defaultOrder); 

				List<Long>  result = dynamicQuery(dynamicQuery);
				
				if (result.size() > 0) {					
					if (result.get(0) != null) {
						Logging log = new LoggingImpl();
						log.setRegionIDString(region.getName());
					    long _p = result.get(0);
						log.setPassel(_p);	
						tmpApplications.add(log);
					} else {
						continue;
					}
				}
			}
			resultList.addAll(tmpApplications);
			
			OrderByComparator orderByComparator = CustomComparatorUtil.getLoggingOrderByComparator("passel", "desc");			
			Collections.sort(resultList, orderByComparator);
			
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
			e.printStackTrace();
	    }
		return resultList;
	}
	
	
	
	public List<Logging> getLoggingsByMissingEntitlements() {
		
		List<Logging> resultList = new ArrayList<Logging>();
        List<Logging> tmpApplications = new ArrayList<Logging>();
		try {
			
			List <Entitlement> allEntitlements = EntitlementLocalServiceUtil.getEntitlements(10154);
			
			for (Entitlement entitlement : allEntitlements) {
			
				String entitlementIdString = String.valueOf(entitlement.getEntitlementId());
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
									
				ProjectionList projectionList = ProjectionFactoryUtil.projectionList();	
				projectionList.add(ProjectionFactoryUtil.sum("passel"));
				dynamicQuery.setProjection(projectionList);			
							
				// only one category
				Criterion criterion = RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.like("entitlementIDString", entitlementIdString));
				// categoryId at the beginning
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.like("entitlementIDString", entitlementIdString + ";" + StringPool.PERCENT)));
				// categoryId at the end
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.like("entitlementIDString", StringPool.PERCENT + ";" + entitlementIdString)));
				// categoryId in the middle
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.like("entitlementIDString", StringPool.PERCENT + ";" + entitlementIdString + ";" + StringPool.PERCENT)));
				
				dynamicQuery.add(criterion);
	
				Order defaultOrder = OrderFactoryUtil.desc("passel");
				dynamicQuery.addOrder(defaultOrder); 

				List<Long>  result = dynamicQuery(dynamicQuery);
				
				if (result.size() > 0) {					
					if (result.get(0) != null) {
						Logging log = new LoggingImpl();
						log.setEntitlementIDString(entitlement.getEntitlementName());
					    long _p = result.get(0);
						log.setPassel(_p);	
						tmpApplications.add(log);
					} else {
						continue;
					}
				}
			}
			resultList.addAll(tmpApplications);
			
			OrderByComparator orderByComparator = CustomComparatorUtil.getLoggingOrderByComparator("passel", "desc");			
			Collections.sort(resultList, orderByComparator);
			
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
			e.printStackTrace();
	    }
		return resultList;
	}	
	
	
	public List<Logging> getLoggingsByPlatforms() {
		
		List<Logging> resultList = new ArrayList<Logging>();
        List<Logging> tmpApplications = new ArrayList<Logging>();
		try {
			
			List <String> allPlatforms = new ArrayList<String>();
			allPlatforms.add("android");
			allPlatforms.add("ios");
			allPlatforms.add("webapp");
			allPlatforms.add("windows");
			allPlatforms.add("blackberry");
			allPlatforms.add("ubuntu");
			
			for (String platform : allPlatforms) {
			
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
									
				ProjectionList projectionList = ProjectionFactoryUtil.projectionList();	
				projectionList.add(ProjectionFactoryUtil.sum("passel"));
				dynamicQuery.setProjection(projectionList);			
							
				// only one category
				Criterion criterion = RestrictionsFactoryUtil.like("targetOS", platform);
				// categoryId at the beginning
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetOS", platform + ";" + StringPool.PERCENT));
				// categoryId at the end
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetOS", StringPool.PERCENT + ";" + platform));
				// categoryId in the middle
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetOS", StringPool.PERCENT + ";" + platform + ";" + StringPool.PERCENT));
				
				dynamicQuery.add(criterion);
	
				Order defaultOrder = OrderFactoryUtil.desc("passel");
				dynamicQuery.addOrder(defaultOrder); 

				List<Long>  result = dynamicQuery(dynamicQuery);
				
				if (result.size() > 0) {					
					if (result.get(0) != null) {
						Logging log = new LoggingImpl();
						log.setTargetOS(platform);
					    long _p = result.get(0);
						log.setPassel(_p);	
						tmpApplications.add(log);
					} else {
						continue;
					}
				}
			}
			resultList.addAll(tmpApplications);
			
			OrderByComparator orderByComparator = CustomComparatorUtil.getLoggingOrderByComparator("passel", "desc");			
			Collections.sort(resultList, orderByComparator);
			
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
			e.printStackTrace();
	    }
		return resultList;
	}	
	
	
	public List<Logging> getLoggingsByTargetCategories() {
		
		List<Logging> resultList = new ArrayList<Logging>();
        List<Logging> tmpApplications = new ArrayList<Logging>();
		try {
			
			List <String> allTargetCategories = new ArrayList<String>();
			allTargetCategories.add("Smartphone");
			allTargetCategories.add("Tablet");
			
			for (String targetCategory : allTargetCategories) {
			
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Logging.class);
									
				ProjectionList projectionList = ProjectionFactoryUtil.projectionList();	
				projectionList.add(ProjectionFactoryUtil.sum("passel"));
				dynamicQuery.setProjection(projectionList);			
							
				// only one category
				Criterion criterion = RestrictionsFactoryUtil.like("targetCategory", targetCategory);
				// categoryId at the beginning
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetCategory", targetCategory + ";" + StringPool.PERCENT));
				// categoryId at the end
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetCategory", StringPool.PERCENT + ";" + targetCategory));
				// categoryId in the middle
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("targetCategory", StringPool.PERCENT + ";" + targetCategory + ";" + StringPool.PERCENT));
				
				dynamicQuery.add(criterion);
	
				Order defaultOrder = OrderFactoryUtil.desc("passel");
				dynamicQuery.addOrder(defaultOrder); 

				List<Long>  result = dynamicQuery(dynamicQuery);
				
				if (result.size() > 0) {					
					if (result.get(0) != null) {
						Logging log = new LoggingImpl();
						log.setTargetCategory(targetCategory);
					    long _p = result.get(0);
						log.setPassel(_p);	
						tmpApplications.add(log);
					} else {
						continue;
					}
				}
			}
			resultList.addAll(tmpApplications);
			
			OrderByComparator orderByComparator = CustomComparatorUtil.getLoggingOrderByComparator("passel", "desc");			
			Collections.sort(resultList, orderByComparator);
			
	    } catch (Exception e) {
			_log.info("Exception: " + e.getMessage());
			e.printStackTrace();
	    }
		return resultList;
	}	
	
}
