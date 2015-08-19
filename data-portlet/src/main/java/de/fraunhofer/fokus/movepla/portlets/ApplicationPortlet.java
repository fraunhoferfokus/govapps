package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationPortlet.java 566 2014-11-13 15:22:01Z sma $
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


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

//import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Category;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.model.Region;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;
import de.fraunhofer.fokus.oefit.schemagen.ApplicationType;
import de.fraunhofer.fokus.oefit.schemagen.EntitlementListType;
import de.fraunhofer.fokus.oefit.schemagen.EntitlementType;
import de.fraunhofer.fokus.oefit.schemagen.GovAppsExport;
import de.fraunhofer.fokus.oefit.schemagen.LinkListType;
import de.fraunhofer.fokus.oefit.schemagen.LinkType;
import de.fraunhofer.fokus.oefit.schemagen.MediaListType;
import de.fraunhofer.fokus.oefit.schemagen.MediaType;

/*
 * 
 * 
 */

public class ApplicationPortlet extends ContentPortlet {

	private static Log _applicationPortletLog = LogFactoryUtil
			.getLog(ApplicationPortlet.class);

	protected String addApplicationPreambleJSP = "/devel/add_application_preamble.jsp";
	protected String errorJSP = "/devel/error.jsp";

	protected String profileJSP = "/profile/profile.jsp";

	/**
	 * This Action sets the "jspPage" parameter to "addApplicationPreambleJSP"
	 * so that processing is forwarded to add_application.jsp.
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws java.lang.Exception
	 */
	@ProcessAction(name = "addApplicationPreamble")
	public void addApplicationPreamble(ActionRequest request,
			ActionResponse response) {
		_applicationPortletLog.debug("addApplicationPreamble");
		try {
			response.setRenderParameter("jspPage", addApplicationPreambleJSP);
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			response.setRenderParameter("jspPage", errorJSP);
		}
	}

	@ProcessAction(name = "exportAction")
	public void exportAction(ActionRequest request, ActionResponse response) {

		try {
			long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
			long companyId = com.liferay.portal.util.PortalUtil
					.getCompanyId(request);

			List<Application> applicationsPerUser = ApplicationLocalServiceUtil
					.getDeveloperApplications(companyId, userId);

			GovAppsExport export = new GovAppsExport();

			for (Application _application : applicationsPerUser) {

				// add application
				ApplicationType xml = exportApp(_application);
				if (xml != null)
					export.getAppplications().add(xml);

			}

			JAXBContext jctx = JAXBContext
					.newInstance("de.fraunhofer.fokus.oefit.schemagen");
			Marshaller m = jctx.createMarshaller();
			StringWriter sw = new StringWriter();
			m.marshal(export, sw);

			HttpServletRequest httpServletRequest = (HttpServletRequest) PortalUtil
					.getHttpServletRequest(request);
			HttpServletResponse httpServletResponse = (HttpServletResponse) PortalUtil
					.getHttpServletResponse(response);

			httpServletResponse.setHeader("Expires", "0");
			httpServletResponse.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			httpServletResponse.setHeader("Pragma", "public");
			// setting the content type
			sw.flush();
			String content = sw.toString();
			sw.close();
			httpServletResponse.setContentLength(content.length());
			com.liferay.portal.kernel.servlet.ServletResponseUtil.sendFile(
					httpServletRequest, httpServletResponse, "export.xml",
					content.getBytes("UTF-8"));

		} catch (Throwable t) {
			request.setAttribute("errorMsg", t.getMessage());
			response.setRenderParameter("jspPage", errorJSP);
		}

	}

	private ApplicationType exportApp(Application _application) {
		ApplicationType result = new ApplicationType();

		try {
			long applicationId = _application.getApplicationId();
			// String applicationIdString = String.valueOf(applicationId);

			String logoImageId = String.valueOf(_application.getLogoImageId());

			List<Application_Entitlement> allApplicationEntitlements = ApplicationLocalServiceUtil
					.getApplicationEntitlements(applicationId);
			List<Category> allCategorys = ApplicationLocalServiceUtil
					.getCategories(applicationId);
			List<Language> allLanguages = ApplicationLocalServiceUtil
					.getLanguages(applicationId);
			List<Link> allLinks = ApplicationLocalServiceUtil
					.getLinks(applicationId);
			List<MultiMedia> allMultiMedias = ApplicationLocalServiceUtil
					.getMultiMedias(applicationId);
			List<Region> allRegions = ApplicationLocalServiceUtil
					.getRegions(applicationId);

			String name = _application.getName();
			String license = _application.getLicense();
			String regs = _application.getRegionString();
			String cats = _application.getCategoryString();
			String descr = _application.getDescription();
			String devel = _application.getDeveloper();
			// Herausgeber
			String legal = _application.getLegalDetails();

			int fee = _application.getFee();
			int size = _application.getSize();
			long registered = _application.getCreateDate().getTime();
			long lastModified = _application.getLastModifiedDate().getTime();
			long relatedTo = Long.MIN_VALUE;
			byte[] logo = getImageBytes(_application.getLogoImageId());

			StringBuffer langs = new StringBuffer();
			for (Language lang : allLanguages)
				langs.append(lang.getLanguageName()).append(",");

			result.setName(name);
			// result.setLicense(license);
			result.setTargetOS(_application.getTargetOS());
			result.setTargetDevice(_application.getTargetCategory().replaceAll(" ", ","));
			result.setCategories(cats);
			result.setRegions(regs);
			result.setLanguages(langs.toString());
			result.setFee(fee);
			result.setSize(size);
			result.setLastModifiedDate(lastModified);
			result.setRegisteredDate(registered);
			result.setDeveloper(devel);
			result.setDescription(descr);
			result.setIssuer(legal);
			if (logo != null && logo.length > 0)
				result.setLogo(logo);

			String relToStr = _application.getRelatedApplicationId();
			if (relToStr != null) {
				try {
					relatedTo = Long.parseLong(relToStr);

					if (relatedTo != Long.MIN_VALUE)
						result.setRelatedTo(relatedTo);
				} catch (Throwable t) {
				}

			}
			if (allApplicationEntitlements != null) {
				result.setEntitlements(new EntitlementListType());
				for (Application_Entitlement ent : allApplicationEntitlements) {
					EntitlementType et = new EntitlementType();
					et.setName(ent.getName());
					et.setValue(ent.getMotivation());
					result.getEntitlements().getEntitlements().add(et);
				}
			}

			if (allLinks != null) {
				result.setLinks(new LinkListType());
				for (Link link : allLinks) {
					LinkType lt = new LinkType();
					lt.setName(link.getDisplayName());
					lt.setValue(link.getUrl());
					result.getLinks().getLinks().add(lt);
				}
			}

			if (allMultiMedias != null) {
				result.setMedia(new MediaListType());
				for (MultiMedia mm : allMultiMedias) {
					MediaType media = new MediaType();
					media.setName(mm.getName());
					media.setValue(getImageBytes(mm.getImageId()));
					result.getMedia().getMedias().add(media);
				}
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return result;
	}

	private byte[] getImageBytes(long imgId) {
		byte[] result = null;

		try {
			DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(imgId);
			InputStream in = fe.getContentStream();
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(in));
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			// BufferedWriter bw = new BufferedWriter(new
			// OutputStreamWriter(bout));
			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read(buffer)) != -1) {
				bout.write(buffer, 0, len);
			}
			result = bout.toByteArray();
		} catch (Throwable t) {
		}
		return result;
	}

	/**
	 * This Action sets the "jspPage" parameter to "addApplicationPreambleJSP"
	 * so that processing is forwarded to add_application.jsp.
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws java.lang.Exception
	 */
	@ProcessAction(name = "profileActionUpdateDetails")
	public void profileActionUpdateDetails(ActionRequest request,
			ActionResponse response) {
		_applicationPortletLog.debug("profileActionUpdateDetails");

		response.setRenderParameter("jspPage", profileJSP);
		try {

			String fname = ParamUtil.getString(request, "fname");
			String lname = ParamUtil.getString(request, "lname");
			String eaddr = ParamUtil.getString(request, "eaddr");
			String tab = ParamUtil.getString(request, "tab");

			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("eaddr", eaddr);
			request.setAttribute("tab", tab);

			if (!isString(fname)) {
				request.setAttribute("errorMsg",
						"Der Vorname muss angegeben werden!");
			} else if (!isString(lname)) {
				request.setAttribute("errorMsg",
						"Der Nachname muss angegeben werden!");
			} else if (!isEmail(eaddr)) {
				request.setAttribute("errorMsg",
						"Die eMail-Adresse muss angegeben werden!");
			} else {
				User user = PortalUtil.getUser(request);
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setEmailAddress(eaddr);
				UserLocalServiceUtil.updateUser(user);
				request.setAttribute("successMsg",
						"Die Daten wurden erfolgreich ge&auml;ndert!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg",
					"Internal Error: " + e.getMessage());

		}
	}

	@ProcessAction(name = "profileActionUpdatePassword")
	public void profileActionUpdatePassword(ActionRequest request,
			ActionResponse response) {
		_applicationPortletLog.debug("profileActionUpdatePassword");

		response.setRenderParameter("jspPage", profileJSP);
		try {

			String pass1 = ParamUtil.getString(request, "pass1");
			String pass2 = ParamUtil.getString(request, "pass2");
			String tab = ParamUtil.getString(request, "tab");

			request.setAttribute("tab", tab);

			if (!isString(pass1)) {
				request.setAttribute("errorMsg",
						"Ein neues Passwort muss eingegeben werden!");
			} else if (!isString(pass2)) {
				request.setAttribute("errorMsg",
						"Das neue Passwort muss zur Best&auml;tigung erneut eingegeben werden!");
			} else if (!pass1.equals(pass2)) {
				request.setAttribute("errorMsg",
						"Die eingegebenen Passw&ouml;rter stimmen nicht &uuml;berein!");
			} else {
				User user = PortalUtil.getUser(request);
				UserLocalServiceUtil.updatePassword(user.getUserId(), pass1,
						pass2, false);
				request.setAttribute("successMsg",
						"Das Passwort wurde erfolgreich ge&auml;ndert!");
			}

		} catch (UserPasswordException e) {
			request.setAttribute("errorMsg",
					"Das Passwort entspricht dem bisherigen Passwort!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg",
					"Internal Error: " + e.getMessage());
		}
	}

	private boolean isString(String data) {
		boolean result = false;

		result = data != null && data.trim().length() > 0;

		return result;
	}

	private boolean isEmail(String data) {
		boolean result = false;

		if (isString(data)) {
			int beg = data.indexOf("@");
			if (beg > 0) {
				beg = data.indexOf(".", beg + 1);
				result = beg > 0;
			}
		}

		return result;
	}

}
