package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: MyValidator.java 566 2014-11-13 15:22:01Z sma $
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


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.LegalDetails;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.util.Util;

public class MyValidator {

	private static Log _log = LogFactoryUtil.getLog(MyValidator.class);

    /**
     * Validates a Application_Entitlement object
     *
     * @param application_Entitlement
     * @param errors
     * @return boolean
     */
    public static boolean validateApplication_Entitlement(Application_Entitlement application_Entitlement, List<String> errors) {
    	
    	_log.debug("validateApplication_Entitlement()");
        boolean valid = true;

        if (Validator.isNull(application_Entitlement.getMotivation())) {
            errors.add("missing-required-application_entitlement-motivation");
            valid = false;
        }
        if (containsForbiddenTags(application_Entitlement.getMotivation())) {
            errors.add("contains-forbidden-tags-application_entitlement-motivation");
            valid = false;
            _log.debug("valid: " + valid);
        }
        
        if (Validator.isNull(application_Entitlement.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(application_Entitlement.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(application_Entitlement.getName())) {
            errors.add("missing-required-application_entitlement-name");
            valid = false;
        }
        return valid;
    }
	
	
    /**
     * Validates a Application object
     *
     * @param application
     * @param errors
     * @return boolean
     */
    public static boolean validateApplication(Application application, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(application.getDescription())) {
            errors.add("missing-required-application-description");
            valid = false;
            _log.debug("valid: " + valid);
        }
        
        if (containsForbiddenTags(application.getDescription())) {
        	if (containsOnlyAllowedTags(application.getDescription())) {
        		_log.debug("application.getDescription containsOnlyAllowedTags!" );
        	} else {
        		errors.add("contains-forbidden-tags-description");
        		valid = false;
        		_log.debug("valid: " + valid);
        	}
        }

        if (Validator.isNull(application.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
            _log.debug("valid: " + valid);
        }

        if (Validator.isNull(application.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
            _log.debug("valid: " + valid);
        }

        if (Validator.isNull(application.getName())) {
            errors.add("missing-required-application-name");
            valid = false;
            _log.debug("valid: " + valid);
        }
        if (containsForbiddenTags(application.getName())) {
            errors.add("contains-forbidden-tags-application-name");
            valid = false;
            _log.debug("valid: " + valid);
        }
        /*
        if (Validator.isNull(application.getVersion()) || application.getVersion().isEmpty()) {
            errors.add("missing-required-application-version");
            valid = false;
        }
        if (Validator.isNull(application.getVersionInformation()) || application.getVersionInformation().isEmpty()) {
            errors.add("missing-required-application-versionInformation");
            valid = false;
        }
        */
        _log.debug("application.getFee(): " + application.getFee());
        if (Validator.isNull(application.getFee()) || application.getFee() < 0) {
            errors.add("missing-required-application-fee");
            valid = false;
            _log.debug("valid: " + valid);
        }
        _log.debug("application.getTargetCategory():>" + application.getTargetCategory() + "<") ;
        if (Validator.isNull(application.getTargetCategory())  || application.getTargetCategory().length() < 3) {
            errors.add("missing-required-application-targetCategory");
            valid = false;
            _log.debug("valid: " + valid);
        }
//        _log.debug("application.getMinTargetOSVersion(): " + application.getMinTargetOSVersion());
        /*
        if (Validator.isNull(application.getMinTargetOSVersion())) {
            errors.add("missing-required-application-minTargetOSVersion");
            valid = false;
          _log.debug("valid: " + valid);
        }
         */        
        _log.debug("application.getSize(): " + application.getSize() );
        if (Validator.isNull(application.getSize())  || application.getSize() < 0) {
            errors.add("missing-required-application-size");
            valid = false;
            _log.debug("valid: " + valid);
        }
        _log.debug("application.getTargetOS(): " + application.getTargetOS());
        if (Validator.isNull(application.getTargetOS())) {
            errors.add("missing-required-application-targetOS");
            valid = false;
            _log.debug("valid: " + valid);
        }
        _log.debug("application.getDeveloper(): " + application.getDeveloper());
        if (Validator.isNull(application.getDeveloper())) {
          errors.add("missing-required-application-developer");
          valid = false;
          _log.debug("valid: " + valid);
        }
        if (containsForbiddenTags(application.getDeveloper())) {
            errors.add("contains-forbidden-tags-application-developer");
            valid = false;
            _log.debug("valid: " + valid);
        }
        
        if (Validator.isNull(application.getLegalDetails())) {
          errors.add("missing-required-application-legalDetails");
          valid = false;
          _log.debug("valid: " + valid);
        }
        if (containsForbiddenTags(application.getLegalDetails())) {
            errors.add("contains-forbidden-tags-application-legalDetails");
            valid = false;
            _log.debug("valid: " + valid);
        }
        
        _log.debug("application.getFirstPublishingDate(): " + application.getFirstPublishingDate());
        if (Validator.isNull(application.getFirstPublishingDate())) {
        	errors.add("missing-required-application-firstPublishingDate");
        	valid = false;
            _log.debug("valid: " + valid);
        }
        _log.debug("application.getLastModifiedDate(): " + application.getLastModifiedDate());
        if (Validator.isNull(application.getLastModifiedDate())) {
        	errors.add("missing-required-application-lastModifiedDate");
        	valid = false;
            _log.debug("valid: " + valid);
        }
        _log.debug("valid: " + valid);
        return valid;
    }
    
    
    /**
     * Validates a Category object
     *
     * @param category
     * @param errors
     * @return boolean
     */
    public static boolean validateCategory(Category category, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(category.getCategoryName())) {
            errors.add("missing-required-category-name");
            valid = false;
        }
        if (Validator.isNull(category.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(category.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(category.getParentCategory())) {
            errors.add("missing-required-parentCategoryId");
            valid = false;
        }
        return valid;
    }
	
	
    /**
     * Validates a Entitlement object
     *
     * @param entitlement
     * @param errors
     * @return boolean
     */
    public static boolean validateEntitlement(Entitlement entitlement, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(entitlement.getEntitlementName())) {
            errors.add("missing-required-entitlement-EntitlementName");
            valid = false;
        }
        if (Validator.isNull(entitlement.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(entitlement.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(entitlement.getExplanation())) {
            errors.add("missing-required-entitlement-explanation");
            valid = false;
        } else {
	        if (entitlement.getExplanation().length() < 6) {
	            errors.add("too-short-entitlement-explanation");
	            valid = false;
	        }
        }
        if (Validator.isNull(entitlement.getEstimation())) {
            errors.add("missing-required-entitlement-estimation");
            valid = false;
        }
        return valid;
    }
    
    
    /**
     * Validates a Language object
     *
     * @param language
     * @param errors
     * @return boolean
     */
    public static boolean validateLanguage(Language language, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(language.getLanguageAbbreviation())) {
            errors.add("missing-required-language-languageAbbreviation");
            valid = false;
        }
        if (Validator.isNull(language.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(language.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(language.getLanguageName())) {
            errors.add("missing-required-language-languageName");
            valid = false;
        }
        return valid;
    }
    
    
    /**
     * Validates a LegalDetails object
     *
     * @param legalDetails
     * @param errors
     * @return boolean
     */
    public static boolean validateLegalDetails(LegalDetails legalDetails, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(legalDetails.getAddress())) {
            errors.add("missing-required-legalDetails-address");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getEmail())) {
            errors.add("missing-required-legalDetails-email");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getFax())) {
            errors.add("missing-required-legalDetails-fax");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getLegalForm())) {
            errors.add("missing-required-legalDetails-legalForm");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getName())) {
            errors.add("missing-required-legalDetails-name");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getRegistrationCourt())) {
            errors.add("missing-required-legalDetails-registrationCourt()");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getTelephone())) {
            errors.add("missing-required-legalDetails-telephone()");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getURL())) {
            errors.add("missing-required-legalDetails-url");
            valid = false;
        }
        if (Validator.isNull(legalDetails.getValueAddedTaxNo())) {
            errors.add("missing-required-legalDetails-valueAddedTaxNo");
            valid = false;
        }
        return valid;
    }    
    
    
    /**
     * Validates a Link object
     *
     * @param link
     * @param errors
     * @return boolean
     */
    public static boolean validateLink(Link link, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(link.getDisplayName())) {
            errors.add("missing-required-link-displayName");
            valid = false;
        }
        if (containsForbiddenTags(link.getDisplayName())) {
            errors.add("contains-forbidden-tags-link-displayName");
            valid = false;
            _log.debug("valid: " + valid);
        }
        if (Validator.isNull(link.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(link.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if ("http://".equalsIgnoreCase(link.getUrl())) {
            errors.add("missing-required-link-url");
            valid = false;
        }
        
/*        
        if (!Util.urlExists(link.getUrl())) {
            errors.add("not-valid-link-url");
            valid = false;
        }
*/        
/*        
        if (!Validator.isUrl(link.getUrl())) {
            errors.add("not-valid-link-url");
            valid = false;
        }
*/        
        if (Validator.isNull(link.getUrl())) {
            errors.add("missing-required-link-url");
            valid = false;
        }
        if (containsForbiddenTags(link.getDisplayName())) {
            errors.add("contains-forbidden-tags-link-url");
            valid = false;
            _log.debug("valid: " + valid);
        }
        return valid;
    }    
    
    
    /**
     * Validates a MultiMedia object
     *
     * @param multiMedia
     * @param errors
     * @return boolean
     */
    public static boolean validateMultiMedia(MultiMedia multiMedia, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(multiMedia.getName())) {
            errors.add("missing-required-multiMedia-name");
            valid = false;
        }
        if (Validator.isNull(multiMedia.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(multiMedia.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
        if (Validator.isNull(multiMedia.getType())) {
            errors.add("missing-required-multiMedia-type");
            valid = false;
        }
        return valid;
    }
    
    
    /**
     * Validates a Region object
     *
     * @param region
     * @param errors
     * @return boolean
     */
    public static boolean validateRegion(Region region, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(region.getName())) {
            errors.add("missing-required-region-name");
            valid = false;
        }
        if (Validator.isNull(region.getCompanyId())) {
            errors.add("missing-required-companyId");
            valid = false;
        }
        if (Validator.isNull(region.getUserId())) {
            errors.add("missing-required-userid");
            valid = false;
        }
//        if (Validator.isNull(region.getAgs())) {
//            errors.add("missing-required-region-ags");
//            valid = false;
//        }
//        if (Validator.isNull(region.getCoordniates_x())) {
//            errors.add("missing-required-region-coordniates_x");
//            valid = false;
//        }
//        if (Validator.isNull(region.getCoordniates_y())) {
//            errors.add("missing-required-region-coordniates_y");
//            valid = false;
//        }
        if (Validator.isNull(region.getParentRegion())) {
            errors.add("missing-required-region-parentRegion");
            valid = false;
        }
//        _log.debug("validateRegion:valid: " + valid);
        return valid;
    }      
    

    private static boolean containsForbiddenTags(String inputString) {
    	if (inputString.contains("<") && inputString.contains(">") ) {
    		return true;
    	} 
    	return false;
    }
    
    private static boolean containsOnlyAllowedTags(String inputString) {
//    	if (inputString.contains("<") && inputString.contains(">") ) {
//    		inputString.
    		
    	_log.debug("inputString: " + inputString);

    	String suspiciousTag = "";
    	int beginIndex = 0;
    	int endIndex = 0;
    	try {
	    	beginIndex = inputString.indexOf("<");
	    	endIndex = inputString.indexOf(">");
	    	
	    	
	    	suspiciousTag = inputString.substring(beginIndex, endIndex +1);
	    	_log.debug("suspiciousTag: " + suspiciousTag);
	    	
	    	if (suspiciousTag.equalsIgnoreCase("")) {
	    		return true;
	    	} else {
		    	if (allowedTags.contains(suspiciousTag)) {
		    		return containsOnlyAllowedTags(inputString.substring(endIndex +1));
		    	} else {
		        	return false;		    		
		    	}
	    	}
    	} catch (IndexOutOfBoundsException e) {
	    	_log.debug("e: " + e.getMessage());
    		return true;
	    }
    }
    
//    private static List<String> allowedTags = new ArrayList<String>();
    private static List<String> allowedTags=Arrays.asList(
    	"<p>",
    	"</p>",
    	"<h1>",
    	"</h1>",
    	"<h2>",
    	"</h2>",
    	"<h3>",
    	"</h3>",
    	"<h4>",
    	"</h4>",
    	"<pre>",
    	"</pre>",
    	"<cite>",
    	"</cite>",
    	"<strong>",
    	"</strong>",
    	"<em>", 
    	"</em>",
    	"<u>",
    	"</u>",
    	"<strike>",
    	"</strike>",
    	"<sub>",
    	"</sub>",
    	"<sup>",
    	"</sup>",
    	"<ol>",
    	"</ol>",
    	"<li>",
    	"</li>",
    	"<ul>",
    	"</ul>",
    	"<div class=\"portlet-msg-alert\">",
    	"<div class=\"portlet-msg-info\">",
    	"<div class=\"portlet-msg-error\">",
    	"</div>",
    	"<p style=\"margin-left: 40px;\">",
    	"<p style=\"margin-left: 80px;\">",
    	"<p style=\"margin-left: 120px;\">",
    	"<p style=\"margin-left: 160px;\">",
    	"<p style=\"margin-left: 200px;\">",
    	"<br />",
    	"<br/>",
    	"<br>"
    	);
    		
}
