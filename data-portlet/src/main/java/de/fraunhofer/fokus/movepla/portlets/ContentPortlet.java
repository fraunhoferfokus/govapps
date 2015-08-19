package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: ContentPortlet.java 566 2014-11-13 15:22:01Z sma $
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
//import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.fraunhofer.fokus.movepla.Constants;
import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.model.impl.Application_EntitlementImpl;
import de.fraunhofer.fokus.movepla.model.impl.LinkImpl;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.LanguageLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.LinkLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.MultiMediaLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil;


public class ContentPortlet extends MVCPortlet {
	
	protected static Log _log = LogFactoryUtil.getLog(ContentPortlet.class);

	protected String contentViewJSP            = "/content/view.jsp";
	protected String contentAddCategoryJSP     = "/content/add_category.jsp";
	protected String contentEditCategoryJSP    = "/content/edit_category.jsp";
	protected String contentAddRegionJSP       = "/content/add_region.jsp";
	protected String contentEditRegionJSP      = "/content/edit_region.jsp";
	protected String contentAddEntitlementJSP  = "/content/add_entitlement.jsp";
	protected String contentEditEntitlementJSP = "/content/edit_entitlement.jsp";
	protected String contentAddLanguageJSP     = "/content/add_language.jsp";
	protected String contentEditLanguageJSP    = "/content/edit_language.jsp";
	protected String contentErrorJSP           = "/content/error.jsp";
	
	
	// Application
	
	// Application Navigation

	/**
     * This Action gets a categoryId/regionId from the request and puts it as parentCategoryId/parentRegionId into the
     * request. It also sets the "jspPage" parameter to "contentViewJSP" so that
     * processing is forwarded to view.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "readViewDisplay")
	public void readCategoryDisplay(ActionRequest request, ActionResponse response) {
		String errorForward = "/devel/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			String successForward = ParamUtil.getString(request, "successForward");
	        long categoryId = ParamUtil.getLong(request, "categoryId");
	        if (Validator.isNotNull(categoryId)) {
	            request.setAttribute("categoryId", categoryId);
	        }
	        
	        long regionId = ParamUtil.getLong(request, "regionId");
	
	        if (Validator.isNotNull(regionId)) {
	            request.setAttribute("regionId", regionId);
	        }
	        
	        response.setRenderParameter("jspPage", successForward);
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", errorForward);			
		}
	}
	
	
	/**
     * This Action sets the "jspPage" parameter to "ActionRequest-param successForward" so that
     * processing is forwarded to ActionRequest-param successForward.
     *
     * @param request
     * @param response
     * ActionRequest-param exceptionForward
     * ActionRequest-param successForward
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "redirectAction")
	public void redirectAction(ActionRequest request, ActionResponse response) {
		String exceptionForward = "/devel/error.jsp";
		try {
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			response.setRenderParameter("jspPage", successForward);
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}
	
	
	
	/**
     * This Action sets the "jspPage" parameter to "ActionRequest-param successForward" so that
     * processing is forwarded to ActionRequest-param successForward.
     *
     * @param request
     * @param response
     * ActionRequest-param exceptionForward
     * ActionRequest-param successForward
     * ActionRequest-param applicationId
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "applicationRedirectWId")
	public void applicationRedirectWId(ActionRequest request, ActionResponse response) {
		String exceptionForward = "/devel/error.jsp";
		try {
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			Application application = ApplicationLocalServiceUtil.getApplication(ParamUtil.getLong(request, "applicationId"));
	        if (Validator.isNotNull(application)) {
	            request.setAttribute("application", application);
	            response.setRenderParameter("jspPage", successForward);
	        } else {
				request.setAttribute("errorMsg", "Internal Error: missing aplicationId");
				response.setRenderParameter("jspPage", exceptionForward);				        	
	        }
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}

	
	// Application Action
	
	
	@ProcessAction(name = "applicationActionAddApplication")
	public Application applicationActionAddApplication(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Application result = null;
		Application application = null;

		long [] categoryPKs = null;
		long [] regionPKs   = null;
		long [] languagePKs = null;
		
		String [] uris = null;

		String errorForward = "";
		String successForward = "";
		long targetUserId = 0;

		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	
			errorForward = ParamUtil.getString(uploadRequest, "errorForward");
			successForward = ParamUtil.getString(uploadRequest, "successForward");
			
			categoryPKs = ParamUtil.getLongValues(uploadRequest, "category");
			regionPKs   = ParamUtil.getLongValues(uploadRequest, "region");
			languagePKs = ParamUtil.getLongValues(uploadRequest, "languages");

			uris = ParamUtil.getParameterValues(uploadRequest, "od_uri");
			
//			String lizenz = ParamUtil.getString(uploadRequest, "lizenz", "");
//			String sektor = ParamUtil.getString(uploadRequest, "sektor", "");
//			boolean use_od = ParamUtil.getBoolean(uploadRequest, "cb_od");
			
//        	_log.info("use_od: " + use_od);
//        	_log.info("uris.length: " + uris.length);
//        	_log.info("lizenz: " + lizenz);
//        	_log.info("sektor: " + sektor);
//        	if (uris.length > 0) {
//        		for (int i = 0; i< uris.length; i++) {
//                	_log.info("uris["+i+"]: " + uris[i]);
//        		}      		
//        	}
        	
        	application = ActionUtil.applicationFromRequest(uploadRequest);
	        ArrayList<String> errors = new ArrayList<String>();
		        
	        if (MyValidator.validateApplication(application, errors) ) {
	        	if (ParamUtil.getLong(uploadRequest, "_userId") != 0 ) {
		        	_log.debug("userid: " + ParamUtil.getLong(uploadRequest, "_userId"));
		        	targetUserId = ParamUtil.getLong(uploadRequest, "_userId");
		        	application.setUserId(targetUserId);	        		
	        	} else {
	        		targetUserId = application.getUserId();
	        	}
	        	_log.debug("getString_userid: " + ParamUtil.getString(uploadRequest, "_userId"));
				String tempImageFileName = "";
		        tempImageFileName = uploadRequest.getFileName("file");
		        File tempImageFile = uploadRequest.getFile( "file");
		        FileEntry tempImageFileEntry = null ;
		       
		        if( tempImageFile != null && tempImageFileName.length() > 4) {
	                // long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
//					long repositoryId = 10180;
		        	long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	                Calendar rightNow = Calendar.getInstance();
	                tempImageFileName = rightNow.getTimeInMillis() + tempImageFileName;
//	                String tmpMimeType = tempImageFileName.substring(tempImageFileName.lastIndexOf(".")+1);
//	                if (tmpMimeType.equalsIgnoreCase("jpg")) {
//	                	tmpMimeType = "jpeg";
//	                }
//					String mimeType = "image/" + tmpMimeType;
					String mimeType = MimeTypesUtil.getContentType(tempImageFileName);
	                tempImageFileEntry = DLAppLocalServiceUtil.addFileEntry(
	                	targetUserId ,
                        repositoryId ,
                        0,
                        tempImageFileName,
                        mimeType,
                        tempImageFileName,
                        "logo",
                        "BRAND NEW",
                        uploadRequest.getFile("file") ,
                        ServiceContextFactory.getInstance( DLFileEntry.class.getName(), request) ) ;

	                if( tempImageFileEntry != null ) {
		                application.setLogoImageId(tempImageFileEntry.getFileEntryId());
						try {
							ImageProcessorUtil.generateImages(tempImageFileEntry.getLatestFileVersion());
			            } catch (DuplicateFileException de) {
			    //            _log.error("DuplicateFileException generateImages: ");
			            }
	                }
		        }
				result = ApplicationLocalServiceUtil.addApplication(application);
	
				if (result != null) {
					SessionMessages.add(request, "application-added-successfully");
					long _appId = result.getApplicationId();
								

		        	if (uris.length > 0) {
		        		for (int i = 0; i< uris.length; i++) {
		        			
					        Link openDataLink = new LinkImpl();
					        openDataLink.setCompanyId(themeDisplay.getCompanyId());
					        openDataLink.setUserId(themeDisplay.getUserId());	      
					        openDataLink.setDisplayName(uris[i]);
					        openDataLink.setType(Constants.OPENDATA);
					        openDataLink.setUrl(uris[i]);
					        openDataLink.setApplicationId(_appId);

					        if (MyValidator.validateLink(openDataLink, errors) ) {	        	
					        	LinkLocalServiceUtil.addLink(openDataLink);
							}
		        		}        		
		        	}

					
					
					ApplicationLocalServiceUtil.addCategories2Application(result, categoryPKs);
					ApplicationLocalServiceUtil.addRegion2Application(result, regionPKs);
					ApplicationLocalServiceUtil.addLanguages2Application(_appId, languagePKs);
					
			        request.setAttribute("application", result);
			        response.setRenderParameter("jspPage", successForward);					
				} else {
		            SessionErrors.add(request, "error-saving-application");
		            SessionErrors.add(request, "contains-forbidden-tags-description");		            
		            request.setAttribute("application", application);
		            request.setAttribute("categoryPKs", categoryPKs);
		            request.setAttribute("regionPKs", regionPKs);
		            request.setAttribute("languagePKs", languagePKs);
		            response.setRenderParameter("jspPage", errorForward);					
				}
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-application");
	            request.setAttribute("application", application);
	            request.setAttribute("categoryPKs", categoryPKs);
	            request.setAttribute("regionPKs", regionPKs);
	            request.setAttribute("languagePKs", languagePKs);
	            response.setRenderParameter("jspPage", errorForward);
			} 
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			e.printStackTrace();
            SessionErrors.add(request, "error-saving-application");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            response.setRenderParameter("jspPage", errorForward);
        }  catch (FileSizeException fe) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-size");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("FileSizeException adding file entry: " + fe.getMessage());	    			
            response.setRenderParameter("jspPage", errorForward);
        } catch (DuplicateFileException de) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-duplicate-file");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
//            _log.error("DuplicateFileException adding file entry: ");
            response.setRenderParameter("jspPage", errorForward);
        } catch (FileExtensionException e) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("FileExtensionException adding file entry: " + e.getMessage());
	        response.setRenderParameter("jspPage", errorForward);
		} catch (PortalException pe) {
			SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("PortalException adding file entry: " + pe.getMessage());
            response.setRenderParameter("jspPage", errorForward);
        }
        return result;
	}
		
	/**
     * This Action sets the "jspPage" parameter to the ActionRequest - parameter successForward so that
     * processing is forwarded to successForward.
     *
     * @param request
     * @param response
     * ActionRequest-param successForward
     * ActionRequest-param exceptionForward
     * ActionRequest-param applicationId
     * ActionResponse-param application
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "applicationActionCloneApplication")
	public void applicationActionCloneApplication(ActionRequest request, ActionResponse response) {
		String exceptionForward = "/devel/error.jsp";
		try {			
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			_log.debug("applicationRedirectActionWithId: " + ParamUtil.getLong(request, "applicationId"));
	        if (Validator.isNotNull(ParamUtil.getLong(request, "applicationId")) && ParamUtil.getLong(request, "applicationId") != 0) {
				Application application = ApplicationLocalServiceUtil.clone(ParamUtil.getLong(request, "applicationId"));
				request.setAttribute("application", application);
	            response.setRenderParameter("jspPage", successForward);
	        }
			response.setRenderParameter("jspPage", successForward);		
		} catch (Exception e) {
			_log.debug(e.getMessage());
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}

	
	@ProcessAction(name = "applicationActionUpdateApplication")
	public Application applicationActionUpdateApplication(ActionRequest request, ActionResponse response) {
		String errorForward = "/devel/error.jsp";
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Application result = null;
		Application application = null;
		String [] uris = null;
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			errorForward = ParamUtil.getString(uploadRequest, "errorForward");
			String successForward = ParamUtil.getString(uploadRequest, "successForward");
	
			application = ActionUtil.applicationFromRequest(uploadRequest);
	        ArrayList<String> errors = new ArrayList<String>();	
			uris = ParamUtil.getParameterValues(uploadRequest, "od_uri");
			
	        if (MyValidator.validateApplication(application, errors) ) {

	        	application.setUserId(ParamUtil.getLong(uploadRequest, "_userId"));
	        		        	
				String tempImageFileName = "";
		        tempImageFileName = uploadRequest.getFileName("file");
		        File tempImageFile = uploadRequest.getFile( "file");
		        FileEntry tempImageFileEntry = null ;
		       
		        if( tempImageFile != null && tempImageFileName.length() > 4) {
	                // long repositoryId = themeDisplay.getParentGroupId() ;
	                // long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
//					long repositoryId = 10180;
		        	long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	                Calendar rightNow = Calendar.getInstance();
	                tempImageFileName = rightNow.getTimeInMillis() + tempImageFileName;
/*	                
	                String tmpMimeType = tempImageFileName.substring(tempImageFileName.lastIndexOf(".")+1);
	                if (tmpMimeType.equalsIgnoreCase("jpg")) {
	                	tmpMimeType = "jpeg";
	                }
					String mimeType = "image/" + tmpMimeType;
*/					
					String mimeType = MimeTypesUtil.getContentType(tempImageFileName);
	                tempImageFileEntry = DLAppLocalServiceUtil.addFileEntry(
                        themeDisplay.getUserId() ,
                        repositoryId ,
                        0,
                        tempImageFileName,
                        mimeType,
                        tempImageFileName,
                        "logo",
                        "BRAND NEW",
                        tempImageFile ,
                        ServiceContextFactory.getInstance( DLFileEntry.class.getName(), request) ) ;
		        }
                if( tempImageFileEntry != null ) {
					try {
						ImageProcessorUtil.generateImages(tempImageFileEntry.getLatestFileVersion());
		            } catch (DuplicateFileException de) {
//		                _log.error("DuplicateFileException generateImages: ");
		            }
                }
				try {
					application = ApplicationLocalServiceUtil.updateApplicationFileEntry(application, tempImageFileEntry);
					long[] categoryPKs = ParamUtil.getLongValues(uploadRequest, "category");
					long[] regionPKs = ParamUtil.getLongValues(uploadRequest, "region");
					long[] languagePKs = ParamUtil.getLongValues(uploadRequest, "languages");

					application.setRegionString("");
					application.setCategoryString("");
					application = ApplicationLocalServiceUtil.updateApplication(application);
					
					ApplicationLocalServiceUtil.clearCategories(application.getApplicationId());
					ApplicationLocalServiceUtil.clearRegions(application.getApplicationId());
					ApplicationLocalServiceUtil.clearLanguages(application.getApplicationId());
					
					ApplicationLocalServiceUtil.addCategories2Application(application, categoryPKs);
					ApplicationLocalServiceUtil.addRegion2Application(application, regionPKs);
					ApplicationLocalServiceUtil.addLanguages2Application(application.getApplicationId(), languagePKs);
					
			        request.setAttribute("application", application);
			        response.setRenderParameter("jspPage", successForward);
			        
			        // delete all opendata Links and ....
			        List<Link> allLinks = LinkLocalServiceUtil.findByca(10154, application.getApplicationId());
			        
	                for (Link link : allLinks) {
	                	if (link.getType() == Constants.OPENDATA) {
	                		LinkLocalServiceUtil.deleteLink(link);
	                	}
	                }
			        
			        // .... add all opendata Links from request
		        	if (uris.length > 0 && application.getUseOpenData() == 1) {
		        		for (int i = 0; i< uris.length; i++) {
		        			
					        Link openDataLink = new LinkImpl();
					        openDataLink.setCompanyId(themeDisplay.getCompanyId());
					        openDataLink.setUserId(themeDisplay.getUserId());	      
					        openDataLink.setDisplayName(uris[i]);
					        openDataLink.setType(Constants.OPENDATA);
					        openDataLink.setUrl(uris[i]);
					        openDataLink.setApplicationId(application.getApplicationId());

					        if (MyValidator.validateLink(openDataLink, errors) ) {	        	
					        	LinkLocalServiceUtil.addLink(openDataLink);
							}
		        		}        		
		        	}

		        	
					SessionMessages.add(request, "application-updated-successfully");
	            } catch (Exception e) {
		            SessionErrors.add(request, "error-saving-application");
		            request.setAttribute("application", application);
			        response.setRenderParameter("jspPage", errorForward);
		            SessionErrors.add(request, "contains-forbidden-tags-description");		            
	            	
	            }
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-application");
	            request.setAttribute("application", application);
		        response.setRenderParameter("jspPage", errorForward);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            SessionErrors.add(request, "error-saving-application");
            request.setAttribute("application", application);
	        response.setRenderParameter("jspPage", errorForward);
        }  catch (FileSizeException fe) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-size");
            request.setAttribute("application", application);
            _log.error("FileSizeException adding file entry: " + fe.getMessage());	    			
	        response.setRenderParameter("jspPage", errorForward);
        } catch (DuplicateFileException de) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-duplicate-file");
            request.setAttribute("application", application);
//            _log.error("DuplicateFileException adding file entry: ");
	        response.setRenderParameter("jspPage", errorForward);
        } catch (FileExtensionException e) {
        	SessionErrors.add(request, "error-adding-multiMedia");
        	SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            _log.error("FileExtensionException adding file entry: " + e.getMessage());
	        response.setRenderParameter("jspPage", errorForward);
		} catch (PortalException pe) {
			SessionErrors.add(request, "error-adding-multiMedia");
			SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            _log.error("PortalException adding file entry: " + pe.getMessage());
	        response.setRenderParameter("jspPage", errorForward);
        }
        return result;
	}		
	
	
	@ProcessAction(name = "developerUpdateApplicationAction")
	public Application developerUpdateApplicationAction(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String errorForward = "/devel/error.jsp";

		Application result = null;
		Application application = null;
		UploadPortletRequest uploadRequest = null;
		String [] uris = null;
		try {
			uploadRequest = PortalUtil.getUploadPortletRequest(request);
	
			errorForward = ParamUtil.getString(uploadRequest, "errorForward");
			String successForward = ParamUtil.getString(uploadRequest, "successForward");

			application = ActionUtil.applicationFromRequest(uploadRequest);
	        ArrayList<String> errors = new ArrayList<String>();
	
			uris = ParamUtil.getParameterValues(uploadRequest, "od_uri");
// todo
			if (MyValidator.validateApplication(application, errors) ) {

				String tempImageFileName = "";
		        tempImageFileName = uploadRequest.getFileName("file");
		        File tempImageFile = uploadRequest.getFile( "file");
		        FileEntry tempImageFileEntry = null ;
		       
		        if( tempImageFile != null && tempImageFileName.length() > 4) {
	                // long repositoryId = themeDisplay.getParentGroupId() ;
	                // long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
//					long repositoryId = 10180;
		        	long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	                Calendar rightNow = Calendar.getInstance();
	                tempImageFileName = rightNow.getTimeInMillis() + tempImageFileName;
					_log.debug("tempImageFileName: " + tempImageFileName);
//					String mimeType = "image/" + tempImageFileName.substring(tempImageFileName.lastIndexOf(".")+1);
					String mimeType = MimeTypesUtil.getContentType(tempImageFileName);
	                tempImageFileEntry = DLAppLocalServiceUtil.addFileEntry(
                        themeDisplay.getUserId() ,
                        repositoryId ,
                        0,
                        tempImageFileName,
                        mimeType,
                        tempImageFileName,
                        "logo",
                        "BRAND NEW",
                        tempImageFile ,
                        ServiceContextFactory.getInstance( DLFileEntry.class.getName(), request) ) ;
		        }
                if( tempImageFileEntry != null ) {
					try {
						ImageProcessorUtil.generateImages(tempImageFileEntry.getLatestFileVersion());
		            } catch (DuplicateFileException de) {
//		                _log.error("DuplicateFileException generateImages: ");
		            }
	                _log.debug("tempImageFileEntry != null: ");
                }
                try {
			        application = ApplicationLocalServiceUtil.developerUpdateApplicationFileEntry(application, tempImageFileEntry);
	
					long[] categoryPKs = ParamUtil.getLongValues(uploadRequest, "category");
					long[] regionPKs = ParamUtil.getLongValues(uploadRequest, "region");
					long[] languagePKs = ParamUtil.getLongValues(uploadRequest, "languages");
	
					application.setRegionString("");
					application.setCategoryString("");
					application = ApplicationLocalServiceUtil.updateApplication(application);
					
					ApplicationLocalServiceUtil.clearCategories(application.getApplicationId());
					ApplicationLocalServiceUtil.clearRegions(application.getApplicationId());
					ApplicationLocalServiceUtil.clearLanguages(application.getApplicationId());
					
					ApplicationLocalServiceUtil.addCategories2Application(application, categoryPKs);
					ApplicationLocalServiceUtil.addRegion2Application(application, regionPKs);
					ApplicationLocalServiceUtil.addLanguages2Application(application.getApplicationId(), languagePKs);
					
	//		        request.setAttribute("applicationId", application.getApplicationId());
			        request.setAttribute("application", application);
			        response.setRenderParameter("jspPage", successForward);

			        // delete all opendata Links and ....
			        List<Link> allLinks = LinkLocalServiceUtil.findByca(10154, application.getApplicationId());
			        
	                for (Link link : allLinks) {
	                	if (link.getType() == Constants.OPENDATA) {
	                		LinkLocalServiceUtil.deleteLink(link);
	                	}
	                }

			        // .... add all opendata Links from request
		        	if (uris.length > 0  && application.getUseOpenData() == 1) {
		        		for (int i = 0; i< uris.length; i++) {
		        			
					        Link openDataLink = new LinkImpl();
					        openDataLink.setCompanyId(themeDisplay.getCompanyId());
					        openDataLink.setUserId(themeDisplay.getUserId());	      
					        openDataLink.setDisplayName(uris[i]);
					        openDataLink.setType(Constants.OPENDATA);
					        openDataLink.setUrl(uris[i]);
					        openDataLink.setApplicationId(application.getApplicationId());

					        if (MyValidator.validateLink(openDataLink, errors) ) {	        	
					        	LinkLocalServiceUtil.addLink(openDataLink);
							}
		        		}        		
		        	}
			        
			        
					SessionMessages.add(request, "application-updated-successfully");
	            } catch (Exception e) {
		            SessionErrors.add(request, "error-saving-application");
		            request.setAttribute("application", application);
			        response.setRenderParameter("jspPage", errorForward);
		            SessionErrors.add(request, "contains-forbidden-tags-description");	            	
	            }
				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-application");
	            request.setAttribute("application", application);
		        response.setRenderParameter("jspPage", errorForward);
			}
		} catch (SystemException e) {
			_log.debug("SystemException adding file entry: " + e.getMessage());
            uploadRequest.setAttribute("application", application);
            SessionErrors.add(request, "error-saving-application");
            SessionErrors.add(request, "error-adding-multiMedia");
	        response.setRenderParameter("jspPage", errorForward);
        }  catch (FileSizeException fe) {
			uploadRequest.setAttribute("application", application);
	        response.setRenderParameter("jspPage", errorForward);			
            SessionErrors.add(request, "error-saving-application");
            SessionErrors.add(request, "error-saving-image-size");
            _log.error("FileSizeException adding file entry: " + fe.getMessage());
        } catch (DuplicateFileException de) {
            _log.debug("DuplicateFileException de: ");
            SessionErrors.add(request, "error-saving-application");
            SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-duplicate-file");
			uploadRequest.setAttribute("application", application);
//            _log.error("DuplicateFileException adding file entry: ");
	        response.setRenderParameter("jspPage", errorForward);
        } catch (FileExtensionException e) {
        	SessionErrors.add(request, "error-adding-multiMedia");
        	SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            _log.error("FileExtensionException adding file entry: " + e.getMessage());
	        response.setRenderParameter("jspPage", errorForward);
		} catch (PortalException pe) {
            _log.debug("PortalException pe: ");
            SessionErrors.add(request, "error-saving-application");
            SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-adding-multiMedia-extension");
			uploadRequest.setAttribute("application", application);
            _log.error("PortalException adding file entry: " + pe.getMessage());
	        response.setRenderParameter("jspPage", errorForward);
		}
        return result;
	}	

	
	// only in ContentPortlet
	@ProcessAction(name = "applicationActionDelete")
	public void applicationActionDelete(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);        
	        _log.debug("themeDisplay.getCompanyId(): " + themeDisplay.getCompanyId());
	        long companyId = themeDisplay.getCompanyId();
	        long applicationId = ParamUtil.getLong(request, "applicationId");
	
	        if (applicationId != 0) {
	        	ApplicationLocalServiceUtil.deleteApplication(companyId, applicationId);
				SessionMessages.add(request, "application-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-application");
//	            request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		} catch (PortalException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}

    // only in ApplicationPortlet
	@ProcessAction(name = "applicationActionDeveloperDelete")
	public void applicationActionDeveloperDelete(ActionRequest request, ActionResponse response) {
		String errorForward = "/devel/error.jsp";
		try {
			Application application = ApplicationLocalServiceUtil.fetchApplication(ParamUtil.getLong(request, "applicationId"));

	        if (application != null) {
	        	ApplicationLocalServiceUtil.developerDeleteApplication(application);
				SessionMessages.add(request, "application-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-application");
//	            request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", errorForward);			
		}
	}
	
	// only in ContentPortlet
	@ProcessAction(name = "applicationActionVerify")
	public void applicationActionVerify(ActionRequest request, ActionResponse response) {
		try {
	        long applicationId = ParamUtil.getLong(request, "applicationId");
	        if (applicationId != 0) {
	        	long oldVersionId = 0;
	        	
	        	Application application = ApplicationLocalServiceUtil.getApplication(applicationId);
	        	oldVersionId = application.getOldVersionId();
	        	application.setLifeCycleStatus(4);
	        	application.setLifeCycleStatusString("");
	        	application.setVerifiedDate(new Date());
	        	application.setOldVersionId(0);
	        	
	        	ApplicationLocalServiceUtil.updateApplication(application);
	        	if (oldVersionId != 0) { 
	    	        _log.debug("ContentPortlet::applicationActionVerify::deleteApplication(" + oldVersionId + ")!");
	    	        ApplicationLocalServiceUtil.deleteOldApplication(oldVersionId, applicationId);
	    	        
	    	        // update relatedApplicationIds oldVersionId ==> applicationId
	    	        String relIds = application.getRelatedApplicationId();
	    	        String[] relIdsArray = relIds.split(";");
	    	        _log.debug("ContentPortlet::relIdsArray.length: " + relIdsArray.length );
	    	        _log.debug("ContentPortlet::relIdsArray[0]: " + relIdsArray[0] );
	    	        if (!relIdsArray[0].equalsIgnoreCase("")) {
		    	        for (int i=0; i< relIdsArray.length; i++) {
			    	        _log.debug("ContentPortlet::relIdsArray["+i+"]: " + relIdsArray[i] );
		    	        	Application _app = ApplicationLocalServiceUtil.fetchApplication(Long.parseLong(relIdsArray[i]));
		    	        	String _oldRelIds = _app.getRelatedApplicationId();
		    	        	String _newRelIds = replaceRelatedIds(_oldRelIds, String.valueOf(oldVersionId), String.valueOf(applicationId));
		    	        	_app.setRelatedApplicationId(_newRelIds);
		    	        	ApplicationLocalServiceUtil.updateApplication(_app);
		    	        }
	    	        }
	        	}
	        	/*	twitter  */
	        	//publish(application.getName(), applicationId);
	        	
				SessionMessages.add(request, "application-verified-successfully");
				response.setRenderParameter("jspPage", contentViewJSP);							
			} else {
	            SessionErrors.add(request, "error-verifying-application");
//	            request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	
	
	
	// only in ContentPortlet
	@ProcessAction(name = "applicationActionRejectApplication")
	public void applicationActionRejectApplication(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);        
	        _log.debug("themeDisplay.getCompanyId(): " + themeDisplay.getCompanyId());
	        _log.debug("reason: " + ParamUtil.getString(request, "reason").trim());
	        _log.debug("applicationIdLong: " + ParamUtil.getLong(request, "applicationId"));
	        _log.debug("applicationIdString: " + ParamUtil.getString(request, "applicationId"));
	        
	        _log.debug("errorForward: " + ParamUtil.getString(request, "errorForward"));
	        _log.debug("successForward: " + ParamUtil.getString(request, "successForward"));
//	        long companyId = themeDisplay.getCompanyId();
	        long applicationId = ParamUtil.getLong(request, "applicationId");
	        if (applicationId != 0) {
	        	Application application = ApplicationLocalServiceUtil.getApplication(applicationId);
	        	application.setLifeCycleStatus(-1);
	        	application.setLifeCycleStatusString(ParamUtil.getString(request, "reason").trim());
	        	ApplicationLocalServiceUtil.updateApplication(application);
				SessionMessages.add(request, "application-rejected-successfully");
				response.setRenderParameter("jspPage", ParamUtil.getString(request, "successForward"));
			} else {
	            SessionErrors.add(request, "error-rejecting-application");
				response.setRenderParameter("jspPage", ParamUtil.getString(request, "errorForward"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	
	
	@ProcessAction(name = "applicationActionAddLink")
	public void applicationActionAddLink(ActionRequest request, ActionResponse response) throws PortalException {
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			
//			if ("add_application".equalsIgnoreCase(ParamUtil.getString(request, "action"))) {
//				request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));
		    response.setRenderParameter("jspPage", successForward);
//			} else {
//		        response.setRenderParameter("jspPage", editApplicationStep3JSP);			
//			}
			
	        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	        Link targetLink = new LinkImpl();
	        targetLink.setCompanyId(themeDisplay.getCompanyId());
	        targetLink.setUserId(themeDisplay.getUserId());	      
	        targetLink.setDisplayName(ParamUtil.getString(request, "displayName_1"));
	        targetLink.setType(Constants.TARGET_LINK);
	        targetLink.setUrl(ParamUtil.getString(request, "url_1"));
	        targetLink.setApplicationId(ParamUtil.getLong(request, "applicationId"));
	        
	        Link appHPLink = new LinkImpl();
	        appHPLink.setCompanyId(themeDisplay.getCompanyId());
	        appHPLink.setUserId(themeDisplay.getUserId());	      
	        appHPLink.setDisplayName(ParamUtil.getString(request, "displayName_2"));
	        appHPLink.setType(Constants.APPLICATION_HOME_PAGE);
	        appHPLink.setUrl(ParamUtil.getString(request, "url_2"));
	        appHPLink.setApplicationId(ParamUtil.getLong(request, "applicationId"));

	        Link devHPLink = new LinkImpl();
	        devHPLink.setCompanyId(themeDisplay.getCompanyId());
	        devHPLink.setUserId(themeDisplay.getUserId());	      
	        devHPLink.setDisplayName(ParamUtil.getString(request, "displayName_3"));
	        devHPLink.setType(Constants.DEVELOPER_HOME_PAGE);
	        devHPLink.setUrl(ParamUtil.getString(request, "url_3"));
	        devHPLink.setApplicationId(ParamUtil.getLong(request, "applicationId"));

	        Link ldHPLink = new LinkImpl();
	        ldHPLink.setCompanyId(themeDisplay.getCompanyId());
	        ldHPLink.setUserId(themeDisplay.getUserId());	      
	        ldHPLink.setDisplayName(ParamUtil.getString(request, "displayName_4"));
	        ldHPLink.setType(Constants.LEGAL_DETAILS_HOME_PAGE);
	        ldHPLink.setUrl(ParamUtil.getString(request, "url_4"));
	        ldHPLink.setApplicationId(ParamUtil.getLong(request, "applicationId"));

	        ArrayList<String> errors = new ArrayList<String>();
	        long applicationId = ParamUtil.getLong(request, "applicationId");
	        Application application = ApplicationLocalServiceUtil.getApplication(applicationId);
	        request.setAttribute("application", application);
	        
	        if (MyValidator.validateLink(targetLink, errors) ) {	        	
	        	LinkLocalServiceUtil.addLink(targetLink);        	
	        	SessionMessages.add(request, "link-added-successfully");
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-link");
//				if ("add_application".equalsIgnoreCase(ParamUtil.getString(request, "action"))) {
//					request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));
			    response.setRenderParameter("jspPage", errorForward);
//				} else {
//			        response.setRenderParameter("jspPage", editApplicationLinksJSP);
//				}
			}
	        
	        if (MyValidator.validateLink(appHPLink, errors) ) {	        	
	        	LinkLocalServiceUtil.addLink(appHPLink);
			}
	        if (MyValidator.validateLink(devHPLink, errors) ) {	        	
	        	LinkLocalServiceUtil.addLink(devHPLink);
			}
	        if (MyValidator.validateLink(ldHPLink, errors) ) {	        	
	        	LinkLocalServiceUtil.addLink(ldHPLink);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}
	
	
	@ProcessAction(name = "applicationActionEditLink")
	public void applicationActionEditLink(ActionRequest request, ActionResponse response) {
		_log.debug("applicationActionEditLink - start");
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			
	        response.setRenderParameter("jspPage", successForward);			
	        long applicationId = ParamUtil.getLong(request, "applicationId");
	        ArrayList<String> errors = new ArrayList<String>();
	        Application application = ApplicationLocalServiceUtil.getApplication(applicationId);
	        _log.debug("applicationActionEditLink - working on app "+application.getApplicationId());
	        boolean updateApp = !(ViewUtil.isVerificationRequired(application));
	        if (updateApp) {
	        	_log.debug("applicationActionEditLink - app is verified, creating clone ...");
	        	application = ApplicationLocalServiceUtil.developerUpdateApplicationFileEntry(application, null);
            	applicationId = application.getApplicationId();
            	_log.debug("applicationActionEditLink - working on clone "+application.getApplicationId());
	        }
	        
	        request.setAttribute("application", application);
	        request.setAttribute("applicationId", applicationId);
	        
	        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	        
	        /*
	         * delete cloned links
	         */
	        if (updateApp) {
	        	long cid = themeDisplay.getCompanyId();
	        
	        	List<Link> links = LinkLocalServiceUtil.findByca(cid, applicationId);
	        	if (links != null) {
	        		for (Link link: links) {
	        			LinkLocalServiceUtil.deleteLink(link);
	        		}
	        	}
	        }
	        
	        

	        Link targetLink = new LinkImpl();
	        if (!ParamUtil.getString(request, "url_1").equalsIgnoreCase("http://")) {
	        	if (updateApp || ParamUtil.getLong(request, "linkId1") == -1) {
	    	        targetLink.setCompanyId(themeDisplay.getCompanyId());
	    	        targetLink.setUserId(themeDisplay.getUserId());	      
	    	        targetLink.setType(2);
	    	        targetLink.setApplicationId(applicationId);
			        targetLink.setDisplayName(ParamUtil.getString(request, "displayName_1"));
			        targetLink.setUrl(ParamUtil.getString(request, "url_1"));
			        if (MyValidator.validateLink(targetLink, errors) ) {	        	
			        	LinkLocalServiceUtil.addLink(targetLink);        	
			        	SessionMessages.add(request, "link-added-successfully");
					} else {
			            for (String error : errors) {
			                SessionErrors.add(request, error);
			            }
			            SessionErrors.add(request, "error-saving-link");
				        response.setRenderParameter("jspPage", errorForward);			
					}
			        
			        
	        	} else {
	    	        targetLink = LinkLocalServiceUtil.getLink(ParamUtil.getLong(request, "linkId1"));
			        targetLink.setDisplayName(ParamUtil.getString(request, "displayName_1"));
			        targetLink.setUrl(ParamUtil.getString(request, "url_1"));
			        if (MyValidator.validateLink(targetLink, errors) ) {	        	
			        	LinkLocalServiceUtil.updateLink(targetLink);        	
			        	SessionMessages.add(request, "link-updated-successfully");
					} else {
			            for (String error : errors) {
			                SessionErrors.add(request, error);
			            }
			            SessionErrors.add(request, "error-updating-link");
				        response.setRenderParameter("jspPage", errorForward);			
					}
	        	}
	        }
	        
	        for (int i=2; i<5;i++) {
	        	Link appHPLink = new LinkImpl();
		        if (!ParamUtil.getString(request, "url_"+i).equalsIgnoreCase("http://")) {
		        	if (updateApp || ParamUtil.getLong(request, "linkId"+i) == -1) {
		        		appHPLink.setCompanyId(themeDisplay.getCompanyId());
		        		appHPLink.setUserId(themeDisplay.getUserId());	      
		        		appHPLink.setType(i+2);
		        		appHPLink.setApplicationId(applicationId);
			        	appHPLink.setDisplayName(ParamUtil.getString(request, "displayName_"+i));
			        	appHPLink.setUrl(ParamUtil.getString(request, "url_"+i));
		    	        if (MyValidator.validateLink(appHPLink, errors) ) {	        	
		    	        	LinkLocalServiceUtil.addLink(appHPLink);
		    			}

		        	} else {
		        		appHPLink = LinkLocalServiceUtil.getLink(ParamUtil.getLong(request, "linkId"+i));
			        	appHPLink.setDisplayName(ParamUtil.getString(request, "displayName_"+i));
			        	appHPLink.setUrl(ParamUtil.getString(request, "url_"+i));
		    	        if (MyValidator.validateLink(appHPLink, errors) ) {	        	
		    	        	LinkLocalServiceUtil.updateLink(appHPLink);
		    			}
		        	}
		        }	
	        }
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);						
		}
	}		

	
	@ProcessAction(name = "applicationActionAddMultiMedia")
	public MultiMedia applicationActionAddMultiMedia(ActionRequest request, ActionResponse response) {
		_log.debug("applicationActionAddMultiMedia");
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		MultiMedia result = null;
		long applicationId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	
			errorForward = ParamUtil.getString(uploadRequest, "errorForward");
			exceptionForward = ParamUtil.getString(uploadRequest, "exceptionForward");
			String successForward = ParamUtil.getString(uploadRequest, "successForward");
			String isEdit = ParamUtil.getString(uploadRequest, "isEdit");
			
			MultiMedia multiMedia = ActionUtil.multiMediaFromRequest(uploadRequest);

//	        applicationId = ParamUtil.getLong(uploadRequest, "applicationId");
	
//			_log.debug(ParamUtil.getString(uploadRequest, "action"));
//			if ("add_application".equalsIgnoreCase(ParamUtil.getString(uploadRequest, "action"))) {
			Application app = ApplicationLocalServiceUtil.getApplication(ParamUtil.getLong(uploadRequest, "applicationId"));
			/*
			 * update/clone instance only if edited and not already cloned before
			 */
			boolean updateAppInstance = isEdit != null && isEdit.equalsIgnoreCase("true") &&
					!(ViewUtil.isVerificationRequired(app));
		    response.setRenderParameter("jspPage", successForward);
//			} else {
//				uploadRequest.setAttribute("applicationId", ParamUtil.getLong(uploadRequest, "applicationId"));
//		        response.setRenderParameter("jspPage", editApplicationStep3JSP);			
//			}        
						
			String tempImageFileName = "";
	        tempImageFileName = uploadRequest.getFileName("file");
	        File tempImageFile = uploadRequest.getFile("file");
	        FileEntry tempImageFileEntry = null ;

	        if( tempImageFile != null && tempImageFileName.length() > 4) {
	            try {
	                // long repositoryId = themeDisplay.getParentGroupId() ;
	                // long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
//					long repositoryId = 10180;
		        	long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	                _log.debug("repositoryId: " + repositoryId);
//	                tempUploadedImageFolder = DLAppLocalServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "UPLOAD_IMAGE_TMP_FOLDER");
	                Calendar rightNow = Calendar.getInstance();
	                tempImageFileName = rightNow.getTimeInMillis() + tempImageFileName;
	                _log.debug("tempImageFileName: " + tempImageFileName);
/*            
	    	        String tmpMimeType = tempImageFileName.substring(tempImageFileName.lastIndexOf(".")+1);
	                if (tmpMimeType.equalsIgnoreCase("jpg")) {
	                	tmpMimeType = "jpeg";
	                }
	    			String mimeType = "image/" + tmpMimeType;
*/			
	    			String mimeType = MimeTypesUtil.getContentType(tempImageFileName);
	                tempImageFileEntry = DLAppLocalServiceUtil.addFileEntry(
	                        themeDisplay.getUserId() ,
	                        repositoryId ,
	                        0,
	                        tempImageFileName,
	                        mimeType,
	                        tempImageFileName,
	                        "description",
	                        "BRAND NEW",
	                        uploadRequest.getFile("file") ,
	                        ServiceContextFactory.getInstance( DLFileEntry.class.getName(), request) ) ;

	               
	                if( tempImageFileEntry != null ) {
	                	if (updateAppInstance) {
		                	app = ApplicationLocalServiceUtil.developerUpdateApplicationFileEntry(app, null);
		                	applicationId = app.getApplicationId();
		                	multiMedia.setApplicationId(applicationId);
	                	}
						multiMedia.setImageId(tempImageFileEntry.getFileEntryId());
						result = MultiMediaLocalServiceUtil.addMultiMedia(multiMedia);
						
						try {
							ImageProcessorUtil.generateImages(tempImageFileEntry.getLatestFileVersion());
			            } catch (DuplicateFileException de) {
//			                _log.error("DuplicateFileException generateImages: ");
			            }
						SessionMessages.add(request, "multiMedia-added-successfully");	
	                }

	            } catch ( SystemException se) {
	                _log.error("System exception adding file entry" , se);
	    			se.printStackTrace();
		            SessionErrors.add(request, "error-saving-application");
		            uploadRequest.setAttribute("applicationId", applicationId);
	            }  catch (FileSizeException fe) {
	            	SessionErrors.add(request, "error-adding-multiMedia");
	                SessionErrors.add(request, "error-saving-image-size");
	                uploadRequest.setAttribute("applicationId", applicationId);
	                _log.error("FileSizeException adding file entry: " + fe.getMessage());	    			
	            } catch (DuplicateFileException de) {
	            	SessionErrors.add(request, "error-adding-multiMedia");
	                SessionErrors.add(request, "error-saving-image-duplicate-file");
	                uploadRequest.setAttribute("applicationId", applicationId);
//	                _log.error("DuplicateFileException adding file entry");
	            } catch (FileExtensionException e) {
	            	SessionErrors.add(request, "error-adding-multiMedia");
	                SessionErrors.add(request, "error-adding-multiMedia-extension");
	                request.setAttribute("applicationId", applicationId);
	                _log.error("FileExtensionException adding file entry: " + e.getMessage());
	    		} catch (PortalException pe) {
	    			SessionErrors.add(request, "error-adding-multiMedia");
	    			SessionErrors.add(request, "error-adding-multiMedia-extension");
	                uploadRequest.setAttribute("applicationId", applicationId);
	                _log.error("PortalException adding file entry: " + pe.getMessage());
	            }
	        }
			uploadRequest.setAttribute("applicationId", applicationId);
			uploadRequest.setAttribute("application", app);
        } catch (Exception e) {
            _log.error("Exception adding file entry" , e);
			e.printStackTrace();
            SessionErrors.add(request, "error-saving-application");
            request.setAttribute("applicationId", applicationId);
        }
        return result;
	}	
	
/*	
	@ProcessAction(name = "deleteMultiMediaAction")
	public void deleteMultiMediaAction(ActionRequest request, ActionResponse response) {
		_log.debug("deleteMultiMediaAction");

		try {			
			MultiMedia multiMedia = MultiMediaLocalServiceUtil.fetchMultiMedia(ParamUtil.getLong(request, "multiMediaId"));
	
	        if (multiMedia != null) {
	        	MultiMediaLocalServiceUtil.deleteMultiMedia(multiMedia);
				SessionMessages.add(request, "multiMedia-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-multiMedia");
	            request.setAttribute("multiMediaId", ParamUtil.getLong(request, "multiMediaId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
*/
	
	
	@ProcessAction(name = "applicationActionDeleteImage")
	public void applicationActionDeleteImage(ActionRequest request, ActionResponse response) {
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		_log.debug("applicationActionDeleteImage");

		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			MultiMedia multiMedia = MultiMediaLocalServiceUtil.fetchMultiMedia(ParamUtil.getLong(request, "multiMediaId"));
//			String backURL = ParamUtil.getString(request, "backURL");
//			_log.debug("backURL: " + backURL);
					
	        if (multiMedia != null) {
	        	MultiMediaLocalServiceUtil.deleteMultiMedia(multiMedia);
				SessionMessages.add(request, "multiMedia-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-multiMedia");
	            request.setAttribute("multiMediaId", ParamUtil.getLong(request, "multiMediaId"));
			}
			request.setAttribute("application", ApplicationLocalServiceUtil.getApplication(ParamUtil.getLong(request, "applicationId")));
            response.setRenderParameter("jspPage", successForward);
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}	
	
	
	@ProcessAction(name = "applicationActionAddEntitlements")
	public void applicationActionAddEntitlements(ActionRequest request, ActionResponse response) throws PortalException {
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			List<Entitlement> allEntitlements = EntitlementLocalServiceUtil.getEntitlements(ParamUtil.getLong(request, "companyId"));

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long applicationId = ParamUtil.getLong(request, "applicationId");
	   		_log.debug("applicationId: " + applicationId);

	   		request.setAttribute("application", ApplicationLocalServiceUtil.getApplication(applicationId));
			
	   		boolean _error = false;

	   		String success = null;
	   		
	   		for (Entitlement entitlement :allEntitlements) {	
		   		String _name       = "name_"       + entitlement.getEntitlementName(); 
		   		String _motivation = "motivation_" + entitlement.getEntitlementName();
		   		String _checked = "checked_" + entitlement.getEntitlementName();
		   		long entitlementId = entitlement.getEntitlementId();

		   		String _nameValue = ParamUtil.getString(request, _name);
		   		String _motivationValue = ParamUtil.getString(request, _motivation);
		   		
		   		Boolean _cbValue = ParamUtil.getBoolean(request, _checked);

		   		_log.debug(_name + ": " + _nameValue);
				_log.debug(_motivation + ": " + _motivationValue);
				_log.debug(_checked + ": " + _cbValue);

				
				if ( (!_cbValue) && _motivationValue.length() > 0) {
		   	        Application_Entitlement model = new Application_EntitlementImpl();
		   	        
		   	        model.setCompanyId(ParamUtil.getLong(request, "companyId"));
		   	        model.setUserId(themeDisplay.getUserId());
		   	        model.setApplicationId(applicationId);
		   	        model.setEntitlementId(entitlementId);
		   	        model.setName(_nameValue);
		   	        model.setMotivation(_motivationValue);
		   	        
		   	        Application_EntitlementLocalServiceUtil.addApplication_Entitlement(model);
				} else {
					if ((!_cbValue) && _motivationValue.trim().length() == 0) {
				        _error = true;
				        break;
					}
				}		 
			}
	   		if (_error) {
                SessionErrors.add(request, "too-short-entitlement-explanation");
		        response.setRenderParameter("jspPage", errorForward);	   			
	   		} else {	   			
	            response.setRenderParameter("jspPage", successForward);
	   		}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}		
	
	
	@ProcessAction(name = "applicationActionEditApplicationEntitlements")
	public void applicationActionEditApplicationEntitlements(ActionRequest request, ActionResponse response) throws PortalException {
		String exceptionForward = "/devel/error.jsp";
		String errorForward      = "/devel/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			exceptionForward = ParamUtil.getString(request, "exceptionForward");
			String successForward = ParamUtil.getString(request, "successForward");
			List<Entitlement> allEntitlements = EntitlementLocalServiceUtil.getEntitlements(ParamUtil.getLong(request, "companyId"));
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long companyId = ParamUtil.getLong(request, "companyId");
			long applicationId= ParamUtil.getLong(request, "applicationId");
	   		_log.debug("applicationId: " + applicationId);
		   	
			Application app = ApplicationLocalServiceUtil.getApplication(applicationId);
			
			boolean updateAppInstance = !(ViewUtil.isVerificationRequired(app));

			if (updateAppInstance) {
				app = ApplicationLocalServiceUtil.developerUpdateApplicationFileEntry(app, null);
            	applicationId = app.getApplicationId();
            } 

			
			
	   		boolean _error = false;
	   		
	   		String success = null;

	   		for (Entitlement entitlement :allEntitlements) {	
		   		String _name       = "name_" + entitlement.getEntitlementName(); 
		   		String _motivation = "motivation_" + entitlement.getEntitlementName();
		   		String _checked = "checked_" + entitlement.getEntitlementName();
		   		long entitlementId = entitlement.getEntitlementId();
				
		   		String _nameValue = ParamUtil.getString(request, _name);
		   		String _motivationValue = ParamUtil.getString(request, _motivation);
		   		
		   		Boolean _cbValue = ParamUtil.getBoolean(request, _checked);

		   		_log.debug(_name + ": " + _nameValue);
				_log.debug(_motivation + ": " + _motivationValue);
				_log.debug(_checked + ": " + _cbValue);
				
				
				List <Application_Entitlement> applicationEntitlements = Application_EntitlementLocalServiceUtil.findBycae(companyId, applicationId, entitlementId);
				if (updateAppInstance) {
					/*
					 * remove former entitlements
					 */
					for (Application_Entitlement appent : applicationEntitlements) {
						Application_EntitlementLocalServiceUtil.deleteApplication_Entitlement(appent);
					}
				}
		   		_log.debug("applicationEntitlements.size(): " + applicationEntitlements.size());

		   		
		   		
		   		if ((!_cbValue) && _motivationValue.length() > 0) {
			   		_log.debug("(!_cbValue) && _motivationValue.length() > 0");
		   			
			   		_log.debug("_nameValue.length(): " + _nameValue.length());
					_log.debug("_motivationValue.length(): " + _motivationValue.length() );

		   			if (applicationEntitlements.size() == 0) {
				   		_log.debug("applicationEntitlements.size() == 0");
		   				Application_Entitlement model = new Application_EntitlementImpl();
			   	        model.setCompanyId(companyId);
			   	        model.setUserId(themeDisplay.getUserId());

			   	        model.setApplicationId(applicationId);
			   	        model.setEntitlementId(entitlementId);
			   	        model.setName(_nameValue);
			   	        model.setMotivation(_motivationValue);
			   	        Application_EntitlementLocalServiceUtil.addApplication_Entitlement(model);
			   	        
			   	        success = "entitlement-added-successfully";
		   			} else {
				   		_log.debug("applicationEntitlements.size() > 0");
		   				Application_Entitlement ae = applicationEntitlements.get(0);
				   		_log.debug("ae.getApplicationEntitlementID(): " + ae.getApplicationEntitlementID());
				   		_log.debug("ae.getApplicationId(): " + ae.getApplicationId());
				   		_log.debug("ae.getMotivation(): " + ae.getMotivation());
				   		_log.debug("ae.getName(): " + ae.getName());
			   	        ae.setApplicationId(applicationId);
			   	        ae.setName(_nameValue);
			   	        ae.setMotivation(_motivationValue);
			   	        Application_EntitlementLocalServiceUtil.updateApplication_Entitlement(ae);
			   	        success = "entitlement-updated-successfully";
		   			}
		   		} else {
			   		_log.debug(" ! ((!_cbValue) && _motivationValue.length() > 0))");
			   		if (_cbValue && applicationEntitlements.size() > 0) {
				   		_log.debug(" _cbValue && applicationEntitlements.size() > 0");
			   			success = "entitlement-deleted-successfully";
		   				Application_Entitlement ae = applicationEntitlements.get(0);
				   		_log.debug("delete appl_ent with id:" + ae.getApplicationEntitlementID());
				   		Application_EntitlementLocalServiceUtil.deleteApplication_Entitlement(ae);
		   			} else {		   				
				   		_log.debug(" !( _cbValue && applicationEntitlements.size() > 0) ");
						if ((!_cbValue) && _motivationValue.length() == 0) {
					        _error = true;
					        break;						
						}
		   			}
		   		}
		   	}
	   		request.setAttribute("application", app);
			if (_error) {
                SessionErrors.add(request, "too-short-entitlement-explanation");
		        response.setRenderParameter("jspPage", errorForward);	   			
	   		} else {
	   			if (success != null)
	   				SessionMessages.add(request, success);
	            response.setRenderParameter("jspPage", successForward);
	   		}
		   	
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", exceptionForward);			
		}
	}		
	
/*	
 	@ProcessAction(name = "deleteLinkAction")
	public void deleteLinkAction(ActionRequest request, ActionResponse response) {

		try {
			Link link = LinkLocalServiceUtil.fetchLink(ParamUtil.getLong(request, "linkId"));
			request.setAttribute("applicationId", ParamUtil.getLong(request, "applicationId"));		
	
	        if (link != null) {
	        	LinkLocalServiceUtil.deleteLink(link);
				SessionMessages.add(request, "link-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-link");
	            request.setAttribute("linkId", ParamUtil.getLong(request, "linkId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
*/
	
	

	// Category
	
	// Category Navigation

    /**
     * This Action gets a categoryId from the request and puts it as parentCategoryId into the
     * request. It also sets the "jspPage" parameter to "contentAddCategoryJSP" so that
     * processing is forwarded to add_category.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "categoryDisplayAddSubCategory")
	public void categoryDisplayAddSubCategory(ActionRequest request, ActionResponse response) {
		try {
	        long parentCategoryId = ParamUtil.getLong(request, "parentCategoryId");
	        if (Validator.isNotNull(parentCategoryId)) {
	            request.setAttribute("parentCategoryId", parentCategoryId);
	            response.setRenderParameter("jspPage", contentAddCategoryJSP);
	        }	        
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}


	/**
     * This Action gets a category from the database and puts it into the
     * request. It also sets the "jspPage" parameter to "editCategory" so that
     * processing is forwarded to edit_category.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "categoryDisplayUpdate")
	public void categoryDisplayUpdate(ActionRequest request, ActionResponse response) {
		try {
	        long categoryId = ParamUtil.getLong(request, "categoryId");
	
	        if (Validator.isNotNull(categoryId)) {
	        	Category category = CategoryLocalServiceUtil.getCategory(categoryId);
	            request.setAttribute("category", category);
	            response.setRenderParameter("jspPage", contentEditCategoryJSP);
	        }
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}

	// Category Action

	@ProcessAction(name = "categoryActionAdd")
	public void categoryActionAdd(ActionRequest request, ActionResponse response) {
		try {
			Category category = ActionUtil.categoryFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	        if (MyValidator.validateCategory(category, errors) ) {
				CategoryLocalServiceUtil.addCategory(category);
				SessionMessages.add(request, "category-added-successfully");
	            response.setRenderParameter("jspPage", "/content/view_categories.jsp");
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-category");
	            request.setAttribute("category", category);
	            response.setRenderParameter("jspPage", contentAddCategoryJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}

	
	@ProcessAction(name = "categoryActionUpdate")
	public void categoryActionUpdate(ActionRequest request, ActionResponse response) {
		try {
			Category category = ActionUtil.categoryFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateCategory(category, errors) ) {
				CategoryLocalServiceUtil.updateCategory(category);
				SessionMessages.add(request, "category-updated-successfully");			
	            response.setRenderParameter("jspPage", "/content/view_categories.jsp");
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-updating-category");
	            request.setAttribute("category", category);
	            response.setRenderParameter("jspPage", contentEditCategoryJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	

	@ProcessAction(name = "categoryActionDelete")
	public void categoryActionDelete(ActionRequest request, ActionResponse response) {
		try {

			Category category = CategoryLocalServiceUtil.fetchCategory(ParamUtil.getLong(request, "categoryId"));
	
	        if (category != null) {
				CategoryLocalServiceUtil.deleteCategory(category);
				SessionMessages.add(request, "category-deleted-successfully");
	            response.setRenderParameter("jspPage", "/content/view_categories.jsp");				
			} else {
	            SessionErrors.add(request, "error-deleting-category");
	            request.setAttribute("categoryId", ParamUtil.getLong(request, "categoryId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}	

	
	// Entitlement
	
	// Entitlement Navigation
	
    /**
     * This Action sets the "jspPage" parameter to "contentAddEntitlementJSP" so that
     * processing is forwarded to add_entitlement.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "entitlementDisplayAdd")
	public void entitlementDisplayAdd(ActionRequest request, ActionResponse response) {
		try {
			response.setRenderParameter("jspPage", contentAddEntitlementJSP);
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}

	
    /**
     * This Action gets an entitlement from the database and puts it into the
     * request. It also sets the "jspPage" parameter to "editEntitlement" so that
     * processing is forwarded to edit_entitlement.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "entitlementDisplayUpdate")
	public void entitlementDisplayUpdate(ActionRequest request, ActionResponse response) {
		try {

	        long entitlementId = ParamUtil.getLong(request, "entitlementId");
	
	        if (Validator.isNotNull(entitlementId)) {
	        	Entitlement entitlement = EntitlementLocalServiceUtil.getEntitlement(entitlementId);
	            request.setAttribute("entitlement", entitlement);
	            response.setRenderParameter("jspPage", contentEditEntitlementJSP);
	        }
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	
	
	// Entitlement Action
	
	@ProcessAction(name = "entitlementActionAdd")
	public void entitlementActionAdd(ActionRequest request, ActionResponse response) {
		try {

			Entitlement entitlement = ActionUtil.entitlementFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateEntitlement(entitlement, errors) ) {
	        	EntitlementLocalServiceUtil.addEntitlement(entitlement);
				SessionMessages.add(request, "entitlement-added-successfully");
	            response.setRenderParameter("jspPage", "/content/view_entitlements.jsp");				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-entitlement");
	            request.setAttribute("entitlement", entitlement);
	            response.setRenderParameter("jspPage", contentAddEntitlementJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}

	
	@ProcessAction(name = "entitlementActionUpdate")
	public void entitlementActionUpdate(ActionRequest request, ActionResponse response) {
		try {

			Entitlement entitlement = ActionUtil.entitlementFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateEntitlement(entitlement, errors) ) {
	        	EntitlementLocalServiceUtil.updateEntitlement(entitlement);
				SessionMessages.add(request, "entitlement-updated-successfully");
	            response.setRenderParameter("jspPage", "/content/view_entitlements.jsp");				
				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-entitlement");
	            request.setAttribute("entitlement", entitlement);
	            response.setRenderParameter("jspPage", contentEditEntitlementJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	
	
	@ProcessAction(name = "entitlementActionDelete")
	public void entitlementActionDelete(ActionRequest request, ActionResponse response) {
		try {

			Entitlement entitlement = EntitlementLocalServiceUtil.fetchEntitlement(ParamUtil.getLong(request, "entitlementId"));
	
	        if (entitlement != null) {
	        	EntitlementLocalServiceUtil.deleteEntitlement(entitlement);
				SessionMessages.add(request, "entitlement-deleted-successfully");
	            response.setRenderParameter("jspPage", "/content/view_entitlements.jsp");				
				
			} else {
	            SessionErrors.add(request, "error-deleting-entitlement");
	            request.setAttribute("entitlementId", ParamUtil.getLong(request, "entitlementId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	


	
	
	// Language

	// Language Navigation
	
    /**
     * This Action sets the "jspPage" parameter to "contentAddLanguageJSP" so that
     * processing is forwarded to add_language.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "languageDisplayAdd")
	public void languageDisplayAdd(ActionRequest request, ActionResponse response) {
		try {
			response.setRenderParameter("jspPage", contentAddLanguageJSP);
		} catch (Exception e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	
	
    /**
     * This Action gets an language from the database and puts it into the
     * request. It also sets the "jspPage" parameter to "editLanguage" so that
     * processing is forwarded to edit_language.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "languageDisplayUpdate")
	public void languageDisplayUpdate(ActionRequest request, ActionResponse response) {
		try {

	        long languageId = ParamUtil.getLong(request, "languageId");
	
	        if (Validator.isNotNull(languageId)) {
	        	Language language = LanguageLocalServiceUtil.getLanguage(languageId);
	            request.setAttribute("language", language);
	            response.setRenderParameter("jspPage", contentEditLanguageJSP);
	        }
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}	
	

	// Language Actions
	
	@ProcessAction(name = "languageActionAdd")
	public void languageActionAdd(ActionRequest request, ActionResponse response) {
		try {
			Language language = ActionUtil.languageFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateLanguage(language, errors) ) {
	        	LanguageLocalServiceUtil.addLanguage(language);
				SessionMessages.add(request, "language-added-successfully");
	            response.setRenderParameter("jspPage", "/content/view_languages.jsp");				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-language");
	            request.setAttribute("language", language);
	            response.setRenderParameter("jspPage", contentAddLanguageJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            SessionErrors.add(request, "error-saving-language");
            response.setRenderParameter("jspPage", contentAddLanguageJSP);			
		}
	}

	
	@ProcessAction(name = "languageActionUpdate")
	public void languageActionUpdate(ActionRequest request, ActionResponse response) {
		try {
			Language language = ActionUtil.languageFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateLanguage(language, errors) ) {
	        	LanguageLocalServiceUtil.updateLanguage(language);
				SessionMessages.add(request, "language-updated-successfully");
	            response.setRenderParameter("jspPage", "/content/view_languages.jsp");				
				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-updating-language");
	            request.setAttribute("language", language);
	            response.setRenderParameter("jspPage", contentEditLanguageJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            SessionErrors.add(request, "error-updating-language");
            response.setRenderParameter("jspPage", contentEditLanguageJSP);			
		}
	}

	
	@ProcessAction(name = "languageActionDelete")
	public void languageActionDelete(ActionRequest request, ActionResponse response) {
		try {

			Language language = LanguageLocalServiceUtil.fetchLanguage(ParamUtil.getLong(request, "languageId"));
	
	        if (language != null) {
	        	LanguageLocalServiceUtil.deleteLanguage(language);
				SessionMessages.add(request, "language-deleted-successfully");
	            response.setRenderParameter("jspPage", "/content/view_languages.jsp");				
				
			} else {
	            SessionErrors.add(request, "error-deleting-language");
	            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}
	
	
	
	// LegalDetails Action
/*	
	@ProcessAction(name = "addLegalDetailsAction")
	public void addLegalDetailsAction(ActionRequest request, ActionResponse response) {
		try {

			LegalDetails legalDetails = ActionUtil.legalDetailsFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateLegalDetails(legalDetails, errors) ) {
	        	LegalDetailsLocalServiceUtil.addLegalDetails(legalDetails);
				SessionMessages.add(request, "legalDetails-added-successfully");
				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-legalDetails");
	            request.setAttribute("legalDetails", legalDetails);
			}
	        
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}
*/
/*	
	@ProcessAction(name = "updateLegalDetailsAction")
	public void updateLegalDetailsAction(ActionRequest request, ActionResponse response) {
		try {

			LegalDetails legalDetails = ActionUtil.legalDetailsFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateLegalDetails(legalDetails, errors) ) {
	        	LegalDetailsLocalServiceUtil.updateLegalDetails(legalDetails);
				SessionMessages.add(request, "legalDetails-updated-successfully");
				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-legalDetails");
	            request.setAttribute("legalDetails", legalDetails);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}
*/	
/*
	@ProcessAction(name = "deleteLegalDetailsAction")
	public void deleteLegalDetailsAction(ActionRequest request, ActionResponse response) {
		try {

			LegalDetails legalDetails = LegalDetailsLocalServiceUtil.fetchLegalDetails(ParamUtil.getLong(request, "legalDetailsId"));
	
	        if (legalDetails != null) {
	        	LegalDetailsLocalServiceUtil.deleteLegalDetails(legalDetails);
				SessionMessages.add(request, "legalDetails-deleted-successfully");
				
			} else {
	            SessionErrors.add(request, "error-deleting-legalDetails");
	            request.setAttribute("legalDetailsId", ParamUtil.getLong(request, "legalDetailsId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}
*/
	
	

	
	// Region
	
	// Region Navigation
		
    /**
     * This Action gets a region from the database and puts it into the
     * request. It also sets the "jspPage" parameter to "editRegion" so that
     * processing is forwarded to edit_region.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "regionDisplayUpdate")
	public void regionDisplayUpdate(ActionRequest request, ActionResponse response) {

		try {
	        long regionId = ParamUtil.getLong(request, "regionId");
	
	        if (Validator.isNotNull(regionId)) {
	        	Region region = RegionLocalServiceUtil.getRegion(regionId);
	            request.setAttribute("region", region);
	            response.setRenderParameter("jspPage", contentEditRegionJSP);
	        }
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		} catch (PortalException e) {
			_log.debug(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", contentErrorJSP);			
		}
	}
	

    /**
     * This Action gets a regionId from the request and puts it as parentRegionId into the
     * request. It also sets the "jspPage" parameter to "contentAddRegionJSP" so that
     * processing is forwarded to add_region.jsp.
     *
     * @param request
     * @param response
     * @throws PortalException 
     * @throws java.lang.Exception
     */
	@ProcessAction(name = "regionDisplayAddSubRegion")
	public void regionDisplayAddSubRegion(ActionRequest request, ActionResponse response) {
		try {

	        long parentRegionId = ParamUtil.getLong(request, "parentRegionId");
	//        _log.debug("parentRegionId: " + parentRegionId);
	        if (Validator.isNotNull(parentRegionId)) {
	            request.setAttribute("parentRegionId", parentRegionId);
	            response.setRenderParameter("jspPage", contentAddRegionJSP);
	        }
		} catch (Exception e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}

	
	
	// Region Action
	
	@ProcessAction(name = "regionActionAdd")
	public void regionActionAdd(ActionRequest request, ActionResponse response) {
		try {

			Region region = ActionUtil.regionFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateRegion(region, errors) ) {
	        	RegionLocalServiceUtil.addRegion(region);
				SessionMessages.add(request, "region-added-successfully");
	            response.setRenderParameter("jspPage", "/content/view_regions.jsp");				
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-region");
	            request.setAttribute("parentRegionId", region.getParentRegion());
	            response.setRenderParameter("jspPage", contentAddRegionJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}

	
	@ProcessAction(name = "regionActionUpdate")
	public void regionActionUpdate(ActionRequest request, ActionResponse response) {

		try {
			Region region = ActionUtil.regionFromRequest(request);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        if (MyValidator.validateRegion(region, errors) ) {
	        	RegionLocalServiceUtil.updateRegion(region);
				SessionMessages.add(request, "region-updated-successfully");
	            response.setRenderParameter("jspPage", "/content/view_regions.jsp");
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-region");
	            request.setAttribute("region", region);
	            response.setRenderParameter("jspPage", contentEditRegionJSP);            
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}

	
	@ProcessAction(name = "regionActionDelete")
	public void regionActionDelete(ActionRequest request, ActionResponse response) {
		try {

			Region region = RegionLocalServiceUtil.fetchRegion(ParamUtil.getLong(request, "regionId"));
	
	        if (region != null) {
	        	RegionLocalServiceUtil.deleteRegion(region);
				SessionMessages.add(request, "region-deleted-successfully");
	            response.setRenderParameter("jspPage", "/content/view_regions.jsp");
			} else {
	            SessionErrors.add(request, "error-deleting-region");
	            request.setAttribute("regionId", ParamUtil.getLong(request, "regionId"));
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
            request.setAttribute("languageId", ParamUtil.getLong(request, "languageId"));
		}
	}
	
	
	



	
	
	

/*	
	@ProcessAction(name = "addApplicationAction")
	public Application addApplicationAction(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Application result = null;
		Application application = null;

		long [] categoryPKs = null;
		long [] regionPKs   = null;
		long [] languagePKs = null;

		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	
			categoryPKs = ParamUtil.getLongValues(uploadRequest, "category");
			regionPKs   = ParamUtil.getLongValues(uploadRequest, "region");
			languagePKs = ParamUtil.getLongValues(uploadRequest, "languages");

			application = ActionUtil.applicationFromRequest(uploadRequest);
	        ArrayList<String> errors = new ArrayList<String>();
	
	        
	        if (MyValidator.validateApplication(application, errors) ) {
	        	
	        	application.setUserId(ParamUtil.getLong(uploadRequest, "_userId"));
	        	_log.debug("userid: " + ParamUtil.getLong(uploadRequest, "_userId"));
	        	_log.debug("getString_userid: " + ParamUtil.getString(uploadRequest, "_userId"));
				String tempImageFileName = "";
		        tempImageFileName = uploadRequest.getFileName("file");
		        File tempImageFile = uploadRequest.getFile( "file");
		        FileEntry tempImageFileEntry = null ;
		       
		        if( tempImageFile != null && tempImageFileName.length() > 4) {
	                // long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
//					long repositoryId = 10180;
		        	long repositoryId = DLFolderConstants.getDataRepositoryId(themeDisplay.getLayout().getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	                Calendar rightNow = Calendar.getInstance();
	                tempImageFileName = rightNow.getTimeInMillis() + tempImageFileName;
					_log.debug("tempImageFileName: " + tempImageFileName);
					String mimeType = "image/" + tempImageFileName.substring(tempImageFileName.lastIndexOf(".")+1);
	                tempImageFileEntry = DLAppLocalServiceUtil.addFileEntry(
                        themeDisplay.getUserId() ,
                        repositoryId ,
                        0,
                        tempImageFileName,
                        mimeType,
                        tempImageFileName,
                        "logo",
                        "BRAND NEW",
                        uploadRequest.getFile("file") ,
                        ServiceContextFactory.getInstance( DLFileEntry.class.getName(), request) ) ;

	                if( tempImageFileEntry != null ) {
		                application.setLogoImageId(tempImageFileEntry.getFileEntryId());
	                }
		        }
				result = ApplicationLocalServiceUtil.addApplication(application);
				SessionMessages.add(request, "application-added-successfully");
	
				long _appId = result.getApplicationId();
											
				ApplicationLocalServiceUtil.addCategories2Application(result, categoryPKs);
				ApplicationLocalServiceUtil.addRegion2Application(result, regionPKs);
				ApplicationLocalServiceUtil.addLanguages2Application(_appId, languagePKs);
				
		        request.setAttribute("applicationId", _appId);
		        response.setRenderParameter("jspPage", addApplicationLinksJSP);
			} else {
	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }
	            SessionErrors.add(request, "error-saving-application");
	            request.setAttribute("application", application);
	            request.setAttribute("categoryPKs", categoryPKs);
	            request.setAttribute("regionPKs", regionPKs);
	            request.setAttribute("languagePKs", languagePKs);
	            response.setRenderParameter("jspPage", addApplicationJSP);
			}
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			e.printStackTrace();
            SessionErrors.add(request, "error-saving-application");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            response.setRenderParameter("jspPage", addApplicationJSP);
        }  catch (FileSizeException fe) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-size");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("FileSizeException adding file entry: " + fe.getMessage());	    			
            response.setRenderParameter("jspPage", addApplicationJSP);
        } catch (DuplicateFileException de) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-saving-image-duplicate-file");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("DuplicateFileException adding file entry: " + de.getMessage());
            response.setRenderParameter("jspPage", addApplicationJSP);
        } catch (FileExtensionException e) {
        	SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("FileExtensionException adding file entry: " + e.getMessage());
	        response.setRenderParameter("jspPage", addApplicationJSP);
		} catch (PortalException pe) {
			SessionErrors.add(request, "error-adding-multiMedia");
            SessionErrors.add(request, "error-adding-multiMedia-extension");
            request.setAttribute("application", application);
            request.setAttribute("categoryPKs", categoryPKs);
            request.setAttribute("regionPKs", regionPKs);
            request.setAttribute("languagePKs", languagePKs);
            _log.error("PortalException adding file entry: " + pe.getMessage());
            response.setRenderParameter("jspPage", addApplicationJSP);
        }
        return result;
	}
*/	
	
	
	
	
@ProcessAction(name = "updateStatusString")
	public void updateStatusString(ActionRequest request, ActionResponse response) {
		String errorForward = "/content/error.jsp";
		try {
			errorForward = ParamUtil.getString(request, "errorForward");
			String successForward = ParamUtil.getString(request, "successForward");
				
			List<Application> allApps = ApplicationLocalServiceUtil.getApplications(10154);
			for (Application application : allApps) {
	        	ApplicationLocalServiceUtil.updateStatusString(application.getApplicationId());
			}	
			SessionMessages.add(request, "application-updateStatusString-successfully");
            response.setRenderParameter("jspPage", successForward);            
	} catch (SystemException e) {
		_log.debug(e.getMessage());
		SessionMessages.add(request, "application-updateStatusString-error");
           response.setRenderParameter("jspPage", errorForward);
	}
}
	
	
	
@ProcessAction(name = "removeWhitespaceFromTargetOS")
public void removeWhitespaceFromTargetOS(ActionRequest request, ActionResponse response) {
	String errorForward = "/content/error.jsp";
	try {
		errorForward = ParamUtil.getString(request, "errorForward");
		String successForward = ParamUtil.getString(request, "successForward");
			
       	ApplicationLocalServiceUtil.removeWhitespaceFromTargetOS();
		SessionMessages.add(request, "application-removeWhitespaceFromTargetOSURL-successfully");
        response.setRenderParameter("jspPage", successForward);            
} catch (SystemException e) {
	_log.debug(e.getMessage());
	SessionMessages.add(request, "application-removeWhitespaceFromTargetOSURL-error");
       response.setRenderParameter("jspPage", errorForward);
}
}
	
private static String replaceRelatedIds(String myString, String oldPatt, String newPatt) {
    _log.debug("Ids before: " + myString);
    _log.debug("replace: " + oldPatt);
			
	if (myString.contains(";" + oldPatt + ";")) {
		_log.debug("contains(;" + oldPatt + ";)" );
		return myString.replace(";" + oldPatt, ";" + newPatt);
		
	} else if (myString.matches("([^\\s]*;" + oldPatt+")")) {;
	_log.debug("contains(;"  + oldPatt + "EOL)");			
		return myString.replace(";" + oldPatt, ";" + newPatt);
		
	} else if (myString.matches("(^" + oldPatt + ";[^\\s]*)" )) {
		_log.debug("contains(" + oldPatt + ";)");
		return myString.replace(oldPatt + ";", newPatt + ";");
		
	} else  if (myString.equalsIgnoreCase(oldPatt)) {
		_log.debug("equalsIgnoreCase(" + oldPatt + ")" );
		return myString.replace(oldPatt, newPatt);			
	}
	return myString;
}

	
private static void publish(String appName, long appid) {
    try {
    	String tweetString = "neuste App: http://www.govapps.de/?root=1&appid=" + appid + " " +  appName + " veröffentlicht.";
        _log.debug("tweetString: "+ tweetString);
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(false)
    	  .setOAuthConsumerKey("7ZVgfKiOvBDcDFpytRWSA")
    	  .setOAuthConsumerSecret("JmeJVeym78arzmGthrDUshQyhkq6nWA9tWLUKxc")
    	  .setOAuthAccessToken("1128008024-blkDYfot8A0DdKj6kznxtcDi122hMZoXCbQuzXT")
    	  .setOAuthAccessTokenSecret("c2YdcPPrB496YQ9QbYGXjNCVBavafCHWMbekAIRc");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();

        Status status = twitter.updateStatus(tweetString);
        _log.debug("Successfully updated the status to [" + status.getText() + "].");
//        System.exit(0);
    } catch (TwitterException te) {
        te.printStackTrace();
        _log.debug("Failed to get timeline: " + te.getMessage());
//        System.exit(-1);
    }
}

	
}
