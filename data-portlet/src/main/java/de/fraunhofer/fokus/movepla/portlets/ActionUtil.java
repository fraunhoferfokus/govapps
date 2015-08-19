package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: ActionUtil.java 566 2014-11-13 15:22:01Z sma $
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

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.movepla.Constants;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.LegalDetails;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.model.impl.ApplicationImpl;
import de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl;
import de.fraunhofer.fokus.movepla.model.impl.CategoryImpl;
import de.fraunhofer.fokus.movepla.model.impl.EntitlementImpl;
import de.fraunhofer.fokus.movepla.model.impl.LanguageImpl;
import de.fraunhofer.fokus.movepla.model.impl.LegalDetailsImpl;
import de.fraunhofer.fokus.movepla.model.impl.LinkImpl;
import de.fraunhofer.fokus.movepla.model.impl.MultiMediaImpl;
import de.fraunhofer.fokus.movepla.model.impl.RegionImpl;

public class ActionUtil {
	
	private static Log _log = LogFactoryUtil.getLog(ActionUtil.class);

    /**
     * Creates a Application_Entitlement object out of fields from the request.
     *
     * @param request
     * @return application_Entitlement
     */
    public static Application_Entitlement application_EntitlementFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Application_Entitlement model = new Application_EntitlementImpl();
        
        _log.debug("themeDisplay.getCompanyId(): " + themeDisplay.getCompanyId());
        
        model.setApplicationEntitlementID(ParamUtil.getLong(request, "ApplicationEntitlementId"));
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());

        model.setApplicationId(ParamUtil.getLong(request, "applicationId"));
        model.setEntitlementId(ParamUtil.getLong(request, "entitlementId"));
        model.setName(ParamUtil.getString(request, "name").trim());
        model.setMotivation(ParamUtil.getString(request, "motivation").trim());
        
        return model;
    }
    
    
    /**
     * Creates a Application object out of fields from the request.
     *
     * @param request
     * @return application
     */
    public static Application applicationFromRequest(UploadPortletRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Application model = new ApplicationImpl();

        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        _log.debug("themeDisplay.getUserId(): " + themeDisplay.getUserId());

        model.setApplicationId(ParamUtil.getLong(request, "applicationId"));
        if (ParamUtil.getString(request, "descriptionEditor").trim().length() > 2998 ) {
            model.setDescription(ParamUtil.getString(request, "descriptionEditor").trim().substring(0, 2998));
        	
        } else {
            model.setDescription(ParamUtil.getString(request, "descriptionEditor").trim());        	
        }
        model.setFee(ParamUtil.getInteger(request, "fee"));

        _log.debug("targetCategory: " + ParamUtil.getString(request, "targetCategory").trim());
        String[] targetCategoryArray = ParamUtil.getParameterValues(request, "targetCategory");
        String targetCategoryValue =""; 
        _log.debug("targetCategoryArray.lengths: " + targetCategoryArray.length);
        for (int i=0; i<targetCategoryArray.length; i++ ) {
        	targetCategoryValue += " " +  targetCategoryArray[i];
        }
        
        _log.debug("platform: " + ParamUtil.getString(request, "platform"));
        String[] platformArray = ParamUtil.getParameterValues(request, "platform");
        String platformValue =""; 
        _log.debug("platformArray.lengths: " + platformArray.length);
        for (int i=0; i<platformArray.length; i++ ) {
        	platformValue=platformValue + " " +  platformArray[i];
        }
/*      
        if (targetCategoryValue.contains("IOS")) {
        	platformValue += " IOS";        	
        }

        if (targetCategoryValue.contains("iPad") || targetCategoryValue.contains("iPhone")) {
        	platformValue += " Apple";        	
        }

        if (targetCategoryValue.contains("Android")) {
        	platformValue += " Android";
        }
        
        if (targetCategoryValue.contains("Windows")) {
        	platformValue += " Windows";
        }
        
        if (targetCategoryValue.contains("Webapp")) {
        	platformValue += " Webapp";
        }
*/        
        _log.debug("targetCategoryValue: " + targetCategoryValue);
        _log.debug("platformValue: " + platformValue);

        model.setTargetCategory(targetCategoryValue.trim());
        model.setTargetOS(platformValue.trim());
        
        
//        model.setMinTargetOSVersion(ParamUtil.getInteger(request, "minTargetOSVersion"));
        model.setName(ParamUtil.getString(request, "name").trim());
        model.setSize(ParamUtil.getInteger(request, "size"));
//        model.setVersion(ParamUtil.getString(request, "version"));
//        model.setVersionInformation(ParamUtil.getString(request, "versionInformation"));        
        model.setDeveloper(ParamUtil.getString(request, "developer").trim());
        model.setLegalDetails(ParamUtil.getString(request, "legalDetails").trim());
        
        int firstPublishingDateMonth = ParamUtil.getInteger(request, "firstPublishingDateMonth");
        int firstPublishingDateDay = ParamUtil.getInteger(request, "firstPublishingDateDay");
        int firstPublishingDateYear = ParamUtil.getInteger(request, "firstPublishingDateYear");

        try {
        	model.setFirstPublishingDate(PortalUtil.getDate(firstPublishingDateMonth, firstPublishingDateDay, firstPublishingDateYear, new PortalException()));
        } catch (PortalException ex) {
        	model.setFirstPublishingDate(new Date());
        }

        int lastModifiedDateMonth = ParamUtil.getInteger(request, "lastModifiedDateMonth");
        int lastModifiedDateDay = ParamUtil.getInteger(request, "lastModifiedDateDay");
        int lastModifiedDateYear = ParamUtil.getInteger(request, "lastModifiedDateYear");

        try {
        	model.setLastModifiedDate(PortalUtil.getDate(lastModifiedDateMonth, lastModifiedDateDay, lastModifiedDateYear, new PortalException()));
        } catch (PortalException ex) {
        	model.setLastModifiedDate(new Date());
        }
//        model.setFirstPublishingDate(ParamUtil.getDate(request, "firstPublishingDate", DateFormat.getDateInstance()));
//        model.setLastModifiedDate(ParamUtil.getDate(request, "lastModifiedDate", DateFormat.getDateInstance()));
        
        model.setLifeCycleStatus(ParamUtil.getInteger(request, "status"));
        model.setRelatedApplicationId(ParamUtil.getString(request, "relatedApplicationId").trim());
        
        boolean use_od = ParamUtil.getBoolean(request, "cb_od");
        if (use_od) {
        	model.setUseOpenData(Constants.USE_OPEN_DATA);
        	model.setLicense(AppConstants.getLicense(ParamUtil.getString(request, "lizenz")).getID());
        	model.setSector(ParamUtil.getString(request, "sektor"));
        } else {
        	model.setUseOpenData(0);
        	model.setLicense("");
        	model.setSector("");        	
        }
        
        return model;
    }
    

    /**
     * Creates a Category object out of fields from the request.
     *
     * @param request
     * @return category
     */
    public static Category categoryFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Category model = new CategoryImpl();

        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
/*
        _log.debug("ActionUtil:categoryFromRequest:parentCategoryId: " + ParamUtil.getLong(request, "parentCategoryId"));
        _log.debug("ActionUtil:categoryFromRequest:categoryName: " + ParamUtil.getString(request, "categoryName"));
        _log.debug("ActionUtil:categoryFromRequest:request.getParameter: " +  request.getParameter("categoryName"));
        Enumeration<String>  parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
        	String parameterName = parameterNames.nextElement();
            _log.debug("ActionUtil:categoryFromRequest:parameterName: " +  parameterName);        	
            String[]  parameterValues = request.getParameterValues(parameterName);
                    for (int i=0; i<parameterValues.length; i++) {
                    	String parameterValue = parameterValues[i];
                        _log.debug("ActionUtil:categoryFromRequest:parameterValue: " +  parameterValue);        	
                    }
        }
*/        
        model.setCategoryId(ParamUtil.getLong(request, "categoryId"));
        model.setParentCategory(ParamUtil.getLong(request, "parentCategoryId"));                                                            
        model.setCategoryName(ParamUtil.getString(request, "categoryName").trim());

        return model;
    }
    
    
    /**
     * Creates a Entitlement object out of fields from the request.
     *
     * @param request
     * @return entitlement
     */
    public static Entitlement entitlementFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Entitlement model = new EntitlementImpl();
        
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setEntitlementId(ParamUtil.getLong(request, "entitlementId"));
        model.setEntitlementName(ParamUtil.getString(request, "entitlementName").trim());
        model.setExplanation(ParamUtil.getString(request, "explanation").trim());
        model.setEstimation(ParamUtil.getString(request, "estimation").trim());
        return model;
    }
    
    
    /**
     * Creates a Language object out of fields from the request.
     *
     * @param request
     * @return language
     */
    public static Language languageFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Language model = new LanguageImpl();
        
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setLanguageId(ParamUtil.getLong(request, "languageId"));
        model.setLanguageAbbreviation(ParamUtil.getString(request, "languageAbbreviation").trim());
        model.setLanguageName(ParamUtil.getString(request, "languageName").trim());
        return model;
    }
    
    
    /**
     * Creates a LegalDetails object out of fields from the request.
     *
     * @param request
     * @return legalDetails
     */
    public static LegalDetails legalDetailsFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        LegalDetails model = new LegalDetailsImpl();
        
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setLegalDetailsId(ParamUtil.getLong(request, "legalDetailsId"));
        model.setAddress(ParamUtil.getString(request, "address").trim());
        model.setEmail(ParamUtil.getString(request, "email").trim());
        model.setFax(ParamUtil.getString(request, "fax").trim());
        model.setLegalForm(ParamUtil.getString(request, "legalForm").trim());
        model.setName(ParamUtil.getString(request, "name").trim());
        model.setRegistrationCourt(ParamUtil.getString(request, "registrationCourt").trim());
        model.setTelephone(ParamUtil.getString(request, "telephone").trim());
        model.setURL(ParamUtil.getString(request, "URL").trim());
        model.setValueAddedTaxNo(ParamUtil.getString(request, "valueAddedTaxNo").trim());
        return model;
    }
    
    
    /**
     * Creates a Link object out of fields from the request.
     *
     * @param request
     * @return link
     */
    public static Link linkFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Link model = new LinkImpl();
        
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setLinkId(ParamUtil.getLong(request, "linkId"));
        model.setDisplayName(ParamUtil.getString(request, "displayName").trim());
        model.setType(ParamUtil.getInteger(request, "type"));
        model.setUrl(ParamUtil.getString(request, "url").trim());
        model.setApplicationId(ParamUtil.getLong(request, "applicationId"));
        return model;
    }
    
    
    /**
     * Creates a MultiMedia object out of fields from the request.
     *
     * @param request
     * @return multiMedia
     */
    public static MultiMedia multiMediaFromRequest(UploadPortletRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        MultiMedia model = new MultiMediaImpl();
        
        model.setMultiMediaId(ParamUtil.getLong(request, "multiMediaId"));
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setName(ParamUtil.getString(request, "name").trim());
        model.setType(ParamUtil.getInteger(request, "type"));
        model.setApplicationId(ParamUtil.getLong(request, "applicationId"));
        return model;
    }
    

    /**
     * Creates a Region object out of fields from the request.
     *
     * @param request
     * @return region
     */
    public static Region regionFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Region model = new RegionImpl();
        
        model.setCompanyId(themeDisplay.getCompanyId());
        model.setUserId(themeDisplay.getUserId());
        
        model.setRegionId(ParamUtil.getLong(request, "regionId"));
        model.setAgs(ParamUtil.getInteger(request, "ags"));
        model.setCoordniates_x(ParamUtil.getDouble(request, "coordniates_x"));
        model.setCoordniates_y(ParamUtil.getDouble(request, "coordniates_y"));
        model.setName(ParamUtil.getString(request, "regionName").trim());
        model.setParentRegion(ParamUtil.getLong(request, "parentRegionId"));
        return model;
    }
}
