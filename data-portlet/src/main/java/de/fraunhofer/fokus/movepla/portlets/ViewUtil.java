package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: ViewUtil.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.model.Entitlement;
import de.fraunhofer.fokus.movepla.model.Language;
import de.fraunhofer.fokus.movepla.model.Link;
import de.fraunhofer.fokus.movepla.model.MultiMedia;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;
import de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil;

public class ViewUtil {

	public enum E_FieldType {
		NAME, LOGO, DESCR, OS, DEVICES, COST, SIZE, DEVEL, IMPRES, LINKS, IMAGES, CAT, LANG, REGION, ENTITLE, TIME
	}

	public static boolean isDifferent(Application oldApp, Application newApp,
			E_FieldType field) {
		boolean result = false;

		try {
			if (field != null && oldApp != null) {
				switch (field) {
				case NAME:
					result = !oldApp.getName().equals(newApp.getName());
					break;
				case CAT:
					result = !oldApp.getCategoryString().equals(
							newApp.getCategoryString());
					break;
				case COST:
					result = !(oldApp.getFee() == newApp.getFee());
					break;
				case DESCR:
					result = !(oldApp.getDescription().equals(newApp
							.getDescription()));
					break;
				case DEVEL:
					result = !(oldApp.getDeveloper().equals(newApp
							.getDeveloper()));
					break;
				case DEVICES:
					result = !(oldApp.getTargetCategory().equals(newApp
							.getTargetCategory()));
					break;
				case ENTITLE:
					StringBuffer oldEnti = new StringBuffer();
					try {
						List<Application_Entitlement> oldEntiList = ApplicationLocalServiceUtil
								.getApplicationEntitlements(oldApp
										.getApplicationId());
						for (Application_Entitlement enti : oldEntiList) {
							Entitlement realEnti = EntitlementLocalServiceUtil
									.fetchEntitlement(enti.getEntitlementId());
							oldEnti.append(realEnti.getEntitlementName())
									.append(enti.getMotivation());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					StringBuffer newEnti = new StringBuffer();
					try {
						List<Application_Entitlement> newEntiList = ApplicationLocalServiceUtil
								.getApplicationEntitlements(newApp
										.getApplicationId());
						for (Application_Entitlement enti : newEntiList) {
							Entitlement realEnti = EntitlementLocalServiceUtil
									.fetchEntitlement(enti.getEntitlementId());
							newEnti.append(realEnti.getEntitlementName())
									.append(enti.getMotivation());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					result = !oldEnti.toString().equals(newEnti.toString());
					break;
				case IMAGES:
					StringBuffer oldImgs = new StringBuffer();
					try {
						List<MultiMedia> oldMultiList = ApplicationLocalServiceUtil
								.getMultiMedias(oldApp.getApplicationId());
						for (MultiMedia multi : oldMultiList) {
							oldImgs.append(multi.getImageId());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					StringBuffer newImgs = new StringBuffer();
					try {
						List<MultiMedia> newMultiList = ApplicationLocalServiceUtil
								.getMultiMedias(newApp.getApplicationId());
						for (MultiMedia multi : newMultiList) {
							newImgs.append(multi.getImageId());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					result = !oldImgs.toString().equals(newImgs.toString());
					break;
				case IMPRES:
					result = !(oldApp.getLegalDetails().equals(newApp
							.getLegalDetails()));
					break;
				case LANG:
					StringBuffer oldLangs = new StringBuffer();
					try {
						List<Language> oldLanguages = ApplicationLocalServiceUtil
								.getLanguages(oldApp.getApplicationId());
						for (Language lang : oldLanguages) {
							oldLangs.append(lang.getLanguageName());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					StringBuffer newLangs = new StringBuffer();
					try {
						List<Language> newLanguages = ApplicationLocalServiceUtil
								.getLanguages(newApp.getApplicationId());
						for (Language lang : newLanguages) {
							newLangs.append(lang.getLanguageName());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					result = !oldLangs.toString().equals(newLangs.toString());
					break;
				case LINKS:
					StringBuffer oldLinks = new StringBuffer();
					try {
						List<Link> oldLinkList = ApplicationLocalServiceUtil
								.getLinks(oldApp.getApplicationId());
						for (Link link : oldLinkList) {
							oldLinks.append(link.getDisplayName()).append(
									link.getUrl());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					StringBuffer newLinks = new StringBuffer();
					try {
						List<Link> newLinkList = ApplicationLocalServiceUtil
								.getLinks(newApp.getApplicationId());
						for (Link link : newLinkList) {
							newLinks.append(link.getDisplayName()).append(
									link.getUrl());
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}
					result = !oldLinks.toString().equals(newLinks.toString());
					break;
				case LOGO:
					result = !(oldApp.getLogoImageId() == newApp
							.getLogoImageId());
					break;
				case OS:
					result = !(oldApp.getTargetOS()
							.equals(newApp.getTargetOS()));
					break;
				case REGION:
					result = !oldApp.getRegionString().equals(
							newApp.getRegionString());
					break;
				case SIZE:
					result = !(oldApp.getSize() == newApp.getSize());
					break;
				case TIME:
					result = !((newApp.getFirstPublishingDate().equals(oldApp
							.getFirstPublishingDate())) && (newApp
							.getLastModifiedDate().equals(oldApp
							.getLastModifiedDate())));
					break;
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return result;
	}

	/*
	 * used along developer edit JSPs to verify whether a clone should be created or not
	 */
	public static boolean isVerificationRequired(Application app) {
		return app.getLifeCycleStatus()     == E_Stati.APPLICATION_STATUS_RESUBMITTED.getIntStatus()
				|| app.getLifeCycleStatus() == E_Stati.APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED.getIntStatus();
	}
}
