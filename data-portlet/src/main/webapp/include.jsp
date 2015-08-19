<%--
  #%L
  govapps_data
  $Id: include.jsp 566 2014-11-13 15:22:01Z sma $
  %%
  Copyright (C) 2013 - 2014 Fraunhofer FOKUS / CC ÖFIT
  %%
  Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
  All rights reserved.
  Redistribution and use in source and binary forms, with or without modification,
  are permitted provided that the following conditions are met:
  
  1) Redistributions of source code must retain the above copyright notice, 
     this list of conditions and the following disclaimer.
  
  2) Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
  
  3) All advertising materials mentioning features or use of this software must 
     display the following acknowledgement: 
     This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
  
  4) Neither the name of the organization nor the names of its contributors may 
     be used to endorse or promote products derived from this software without 
     specific prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL 
  Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
  BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
  LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
  OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
  #L%
  --%>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%> 
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.QueryConfig"%>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.service.PortalPreferencesLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>


<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>

<%@ page import="com.liferay.portal.model.Role"%>
<%@ page import="com.liferay.portal.model.User"%>

<%@ page import="com.liferay.portal.theme.PortletDisplay"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil"%>

<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileShortcut" %> 
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portlet.PortletURLUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Application"%> 
<%@ page import="de.fraunhofer.fokus.movepla.model.Application_Entitlement"%> 
<%@ page import="de.fraunhofer.fokus.movepla.model.Category"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Entitlement"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Language"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.LegalDetails"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Logging"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Link"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.MultiMedia"%>
<%@ page import="de.fraunhofer.fokus.movepla.model.Region"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.permission.ActionKeys"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.permission.Permission"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.ActionUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.ApplicationPortlet"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.ContentPortlet"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.MyValidator"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.AppConstants"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.E_Stati"%>
<%@ page import="de.fraunhofer.fokus.movepla.portlets.E_Images"%>

<%@ page import="de.fraunhofer.fokus.movepla.Constants"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil"%> 
<%@ page import="de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil"%> 
<%@ page import="de.fraunhofer.fokus.movepla.service.CategoryLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil"%> 
<%@ page import="de.fraunhofer.fokus.movepla.service.LanguageLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.LegalDetailsLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.LinkLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.LoggingLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.MultiMediaLocalServiceUtil"%>
<%@ page import="de.fraunhofer.fokus.movepla.service.RegionLocalServiceUtil"%>

<%@ page import="de.fraunhofer.fokus.movepla.util.CustomComparatorUtil"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Iterator"%>


<%@ page import="javax.portlet.PortletSession"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.WindowState"%>
<!-- 
< % @ taglib uri="http://displaytag.sf.net" prefix="display" %>

< % @ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
< %@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
< %@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
< %@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
< %@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
 -->
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page contentType="text/html" isELIgnored="false"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
WindowState windowState = null;
PortletMode portletMode = null;

PortletURL currentURLObj = null;

if (renderRequest != null) {
	windowState = renderRequest.getWindowState();
	portletMode = renderRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
}
else if (resourceRequest != null) {
	windowState = resourceRequest.getWindowState();
	portletMode = resourceRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
}

String currentURL = currentURLObj.toString();

long companyId = themeDisplay.getCompanyId();



%>


