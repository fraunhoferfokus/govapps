package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: E_Licenses.java 566 2014-11-13 15:22:01Z sma $
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


public enum E_Licenses {
	// key (id, decription, calssification, is4data, is4app)
	
	APACHE("apache", "Apache Lizenz", 															"offen", 			0, 1),
	APP_COMMERCIAL("app_commercial", "Andere kommerzielle Lizenz", 								"eingeschränkt", 	0, 1),
	APP_FREEWARE("app_freeware", "Andere kostenfreie Lizenz", 									"eingeschränkt", 	0, 1),
	APP_OPENSOURCE("app_opensource", "Andere Open Source Lizenz", 								"offen",			0, 1),
	BSD_LICENSE("bsd-license", "BSD Lizenz",													"offen", 			0, 1),
	CC_BY("cc-by", "Creative Commons Namensnennung (CC-BY)", 									"offen", 			1, 0),
	CC_BY_SA("cc-by-sa", "Creative Commons Attribution Weitergabe unter gleichen Bedingungen (CC-BY-SA)", 	"offen", 1, 0),
	CC_NC("cc-nc", "Creative Commons Nicht-Kommerziell (CC-NC)", 								"eingeschränkt", 	1, 0),
	CC_ZERO("cc-zero", "Creative Commons Zero", 												"offen", 			1, 0),
	GFDL("gfdl", "GNU Free Documentation License", 												"offen", 			1, 0),
	GPL_3_0("gpl-3.0", "GNU General Public License version 3.0 (GPLv3)",						"offen", 			0, 1),
	MOZILLA("mozilla", "Mozilla Public License 1.0 (MPL)", 										"offen", 			0, 1),
	ODC_ODBL("odc-odbl", "Open Data Commons Open Database License (ODbL)", 						"offen", 			1, 0),
	OTHER_OPEN("other-open", "Andere freie Lizenz", 				  							"offen", 			1, 1),
	OTHER_CLOSED("other-closed", "Andere eingeschränkte Lizenz", 				  				"eingeschränkt",	1, 1),
	GEOLIZENZ_I_A("geolizenz-i-a", "Geolizenz Ia Namensnennung", 								"offen", 			1, 0),
	GEOLIZENZ_CLOSED("geolizenz-closed", "eingeschränkte Geolizenz", 							"offen", 			1, 0),
	OFFICIAL_WORK("official-work", "Amtliches Werk, lizenzfrei nach §5 UrhG", 					"offen", 			1, 0),
	DL_DE_BY_1_0_("dl-de-by-1.0", "Datenlizenz Deutschland Namensnennung", 						"offen", 			1, 0),
	DL_DE_BY_NC_1_0("dl-de-by-nc-1.0", "Datenlizenz Deutschland Namensnennung", 				"eingeschränkt", 	1, 0),	
	ODC_PDDL("odc-pddl", "Open Data Commons Public Domain Dedication and Licence (PDDL)", 		"offen", 			1, 0),	
	ODC_BY("odc-by", "Open Data Commons Namensnennung", 										"offen", 			1, 0)	
	;
	
	private String m_id;
	private String m_descr;
	private String m_classification;
	private int m_is4Data;
	private int m_is4App;
	
	
	private E_Licenses(String id, String descr, String classification, int is4Data, int is4App) {
		m_id = id;
		m_descr = descr;
		m_classification = classification;
		m_is4Data = is4Data;
		m_is4App = is4App;
	}
	
	
	public String getID() {
		return m_id;
	}

	public String getDescr() {
		return m_descr;
	}

	public String getClassification() {
		return m_classification;
	}

	public int getIs4Data() {
		return m_is4Data;
	}

	public int getIs4App() {
		return m_is4App;
	}

}
