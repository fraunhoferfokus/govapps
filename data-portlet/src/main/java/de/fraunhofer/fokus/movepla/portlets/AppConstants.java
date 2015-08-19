package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: AppConstants.java 566 2014-11-13 15:22:01Z sma $
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

import java.util.HashMap;
import java.util.List;

import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AppConstants {

//	public static final String COMPANY_VIRTUAL_HOST = "www.govapps.de";
	public static final String COMPANY_VIRTUAL_HOST = "193.175.133.144";
	
	/*
	 * test-server .144
	 */
//	public static String WEB_ROOT = "/web/umfrage/";
	/*
	 * live-server .185
	 */
	public static final String WEB_ROOT = "/web/public/";
	/*
	 * local
	 */
	//public static String WEB_ROOT = "/web/guest/";

	/*
	 * live-server
	 */
	public static final String EDITOR_TOOLBAR_STYLE = "slimmed";
	/*
	 * local
	 */
	//public static final String EDITOR_TOOLBAR_STYLE = "edit-in-place";
	
	
	private static HashMap<String, E_Images> m_objRegions;
	private static HashMap<String, E_Images> m_objCategories;
	private static HashMap<String, E_Images> m_objPlatforms;
	private static HashMap<String, E_Images> m_objEntitlements;
	private static HashMap<String, E_Images> m_objIcons;
	private static HashMap<Integer, E_Stati>  m_objStati;
	private static HashMap<String, E_Licenses> m_objLicenses;

	static {
		m_objCategories = new HashMap<String, E_Images>();
		m_objPlatforms = new HashMap<String, E_Images>();
		m_objEntitlements = new HashMap<String, E_Images>();
		m_objIcons = new HashMap<String, E_Images>();
		m_objRegions = new HashMap<String, E_Images>();
		m_objStati = new HashMap<Integer, E_Stati>();
		m_objLicenses = new HashMap<String, E_Licenses>();

		E_Images[] imgs = E_Images.values();
		for (E_Images img : imgs) {
			if (img.name().startsWith("REG_")) {
				m_objRegions.put(img.getDescr(), img);
			} else if (img.name().startsWith("CAT_")) {
				m_objCategories.put(img.getDescr(), img);
			} else if (img.name().startsWith("ENT_")) {
				m_objEntitlements.put(img.getDescr(), img);
			} else if (img.name().startsWith("PLATF_")) {
				m_objPlatforms.put(img.getDescr(), img);
			} else
				m_objIcons.put(img.getDescr(), img);
		}
		
		E_Stati[] stati = E_Stati.values();
		for (E_Stati status : stati) {
			m_objStati.put(status.getIntStatus(), status);
		}
		
		E_Licenses[] licenses = E_Licenses.values();
		for (E_Licenses license : licenses) {
			m_objLicenses.put(license.getDescr(), license);
		}
		
		
	}

	public static long getStaticPage(String titleIgnoreCase) {
		long result = -1;
		try {
		JournalArticle art = null;
		List<JournalArticle> articles = JournalArticleLocalServiceUtil
				.getArticles();
		for (JournalArticle article : articles) {
			String rawtitle = article.getTitle();
			int beg = rawtitle.indexOf("<Title ");
			if (beg > 0) {
				beg = rawtitle.indexOf(">", beg) + 1;
				int end = rawtitle.indexOf("</Title", beg);
				String title = rawtitle.substring(beg, end);
				if (title.equalsIgnoreCase(titleIgnoreCase)) {
					art = article;
					break;
				} else {

				}
			}
		}
		if (art != null)
			result = art.getResourcePrimKey();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return result;
	}

	public static E_Images getIcon(String name) {
		E_Images result = null;

		if (name != null) {
			result = m_objIcons.get(name.trim());
		}
		return result;
	}

	public static E_Images getRegion(String name) {
		E_Images result = null;

		if (name != null) {
			result = m_objRegions.get(name.trim());
		}
		return result;
	}

	public static E_Images getCategory(String name) {
		E_Images result = null;

		if (name != null) {
			result = m_objCategories.get(name.trim());
		}
		return result;
	}

	public static E_Images getEntitlement(String name) {
		E_Images result = null;

		if (name != null) {
			result = m_objEntitlements.get(name.trim());
		}
		return result;
	}

	public static E_Images getPlatform(String name) {
		E_Images result = null;

		if (name != null) {
			result = m_objPlatforms.get(name.trim());
		}
		return result;
	}
	
	
	public static E_Stati getStatus(int status) {
		E_Stati result = null;

		if (status != 0) {
			result = m_objStati.get(status);
		}
		return result;
	}


	public static E_Licenses getLicense(String license) {
		E_Licenses result = null;

		if (license != null) {
			result = m_objLicenses.get(license.trim());
		}
		return result;
	}

}
