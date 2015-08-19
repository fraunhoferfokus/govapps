package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: E_Images.java 566 2014-11-13 15:22:01Z sma $
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


public enum E_Images {

	NONE("http://localhost:8080/VmAmG-portlet/images/image-missing.png","Fehlt"),
	
	LANGUAGES("/vepa-backend-theme/images/vepa-icons/Details/Icon-Sprachen.png","Sprache(n)"),
	SIZE("/vepa-backend-theme/images/vepa-icons/Details/Icon-MB.png","Größe"),
	DATE("/vepa-backend-theme/images/vepa-icons/Details/Icon-Datum.png","Datum"),
	CATEGORY("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Organisation.png","Kategorie(n)"),
	
	ENT_NET_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation-Aktiv.png","Netzwerkkommunikation"),
	ENT_MEDIA_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-3-Medienzugriff-Aktiv.png","Medienzugriff"),
	ENT_GPS_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste-Aktiv.png","Ortungsdienste"),
	ENT_SYS_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung-Aktiv.png","Systemeinstellungen"),
	ENT_PAYSRV_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste-Aktiv.png","Kostenpflichtige Dienste"),
	ENT_PERSDATA_ACTIVE("/vepa-backend-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten-Aktiv.png","Ihre persönlichen Daten"),
	
	REG_DE("/vepa-backend-theme/images/vepa-icons/Regionen/Icon-Deutschland-Aktiv.png","Bundesrepublik Deutschland"),
	REG_BW("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg-Aktiv.png","Baden-Württemberg"),
	REG_BAYERN("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Bayern-Aktiv.png","Bayern"),
	REG_BERL("/vepa-backend-theme/images/vepa-icons/Regionen/Icon-Berlin-Aktiv.png","Berlin"),
	REG_BRANDBRG("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Brandenburg-Aktiv.png","Brandenburg"),
	REG_BREMEN("/vepa-backend-theme/images/vepa-icons/Regionen/Icon-Bremen-Aktiv.png","Bremen"),
	REG_HAMBURG("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Hamburg-Aktiv.png","Hamburg"),
	REG_HESSEN("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Hessen-Aktiv.png","Hessen"),
	REG_MECKPOM("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern-Aktiv.png","Mecklenburg-Vorpommern"),
	REG_NIEDERSACHS("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen-Aktiv.png","Niedersachsen"),
	REG_NRW("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen-Aktiv.png","Nordrhein-Westfalen"),
	REG_RHP("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz-Aktiv.png","Rheinland-Pfalz"),
	REG_SAAR("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Saarland-Aktiv.png","Saarland"),
	REG_SACHS("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Aktiv.png","Sachsen"),
	REG_SACHSANH("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt-Aktiv.png","Sachsen-Anhalt"),
	REG_SCHLESWH("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein-Aktiv.png","Schleswig-Holstein"),
	REG_TUER("/vepa-backend-theme/images/vepa-icons/Regionen/Wappen-Thueringen-Aktiv.png","Thüringen"),
	
	PLATF_WEB ("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png","Webapp"),
	PLATF_ANDR("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Android-Aktiv.png","Android"),
	PLATF_IOS ("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-iOS-Aktiv.png","iOS"),
	PLATF_WIN ("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Windows-Aktiv.png","Windows"),
	PLATF_BCK ("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-BlackBerry-Aktiv.png","BlackBerry"),
	PLATF_UBU ("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Ubuntu-Aktiv.png","Ubuntu"),
	
	PLATF_WEB_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Web-App.png","Webapp_p"),
	PLATF_ANDR_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Android.png","Android_p"),
	PLATF_IOS_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-iOS.png","iOS_p"),
	PLATF_WIN_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Windows.png","Windows_p"),
	PLATF_BCK_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-BlackBerry.png","BlackBerry_p"),
	PLATF_UBU_P("/vepa-backend-theme/images/vepa-icons/Plattform/Icon-Ubuntu.png","Ubuntu_p"),

	CAT_BILDUNG("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Bildung.png","Bildung"),
	CAT_FAMILIE("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Familie.png","Familie"),
	CAT_HEALTH("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Gesundheit.png","Gesundheit"),
	CAT_NEWS("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Nachrichten.png","Nachrichten"),
	CAT_LEXIKA("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Lexika.png","Nachschlagewerke"),
	CAT_VERKEHR("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Verkehr.png","Navigation"),
	CAT_POLITIK("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Politik.png","Politik"),
	CAT_ORGA("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Organisation.png","Organisation"),
	CAT_TOURISMUS("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Tourismus.png","Reisen"),
	CAT_SOCIALNET("/vepa-backend-theme/images/vepa-icons/Themen/Icon-1-Soziale-Netzwerke.png","Soziale Netze"),
	CAT_SPORT("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Sport.png","Sport"),
	CAT_WETTER("/vepa-backend-theme/images/vepa-icons/Themen/Icon-Wetter.png","Wetter"),
	;
	
	private String m_strIcon;
	private String m_strDescr;
	
	private E_Images(String icon, String descr) {
		m_strIcon = icon;
		m_strDescr = descr;
	}
	
	public String getIcon() {
		return m_strIcon;
	}
	
	public String getDescr() {
		return m_strDescr;
	}
	
}

