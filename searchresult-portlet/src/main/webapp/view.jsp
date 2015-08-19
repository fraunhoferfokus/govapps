<%--
  #%L
  govapps_searchresult
  $Id: view.jsp 566 2014-11-13 15:22:01Z sma $
  %%
  Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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

<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />

<%
	String setAppIdForm = request.getParameter("appid");
    String searchStr =  request.getParameter("searchStr");
    String filter =  request.getParameter("filter");
    String newAppIds = request.getParameter("newappids");
    String entitlementId = request.getParameter("entitleNr");
    
    String lastSearchView = "";
    String lastSearchStringRegion = "";
    
    if (filter == null | filter == "undefined"){
    	filter = "--null--;--null--;--null--;entitlement_1;entitlement_2;entitlement_3;entitlement_4;entitlement_5;entitlement_6";
    }
    
    
    // for SEO - set random regions in meta keywords - see below
    String[] shuffleReg = {
    "Bundesrepublik Deutschland",
    "Baden-W�rttemberg",
    "Bayern",
    "Berlin",
    "Brandenburg",
    "Bremen",
    "Hamburg",
    "Hessen",
    "Mecklenburg-Vorpommern",
    "Niedersachsen",
    "Nordrhein-Westfalen",
    "Rheinland-Pfalz",
    "Saarland",
    "Sachsen",
    "Sachsen-Anhalt",
    "Schleswig-Holstein",
    "Th�ringen"};
    

    Random generator = new Random();
    int randomNr = generator.nextInt(shuffleReg.length);
    int randomNr2 = generator.nextInt(shuffleReg.length);
    
    if(searchStr!=null) {
        if(searchStr.length()==0) {
        	PortalUtil.addPageKeywords("Apps " + shuffleReg[randomNr] + ", Apps " + shuffleReg[randomNr2], request);
        	PortalUtil.setPageTitle(" Alle Apps", request);
            searchStr = "null"; 
         
        }
        else {
        	PortalUtil.addPageKeywords(searchStr + ", Apps " + shuffleReg[randomNr] + ", Apps " + shuffleReg[randomNr2], request);
        	PortalUtil.setPageTitle(" " + searchStr, request);
        }
        PortalUtil.addPageDescription("Auf GovApps finden Sie mobile Apps aus " + shuffleReg[randomNr] + " und " +shuffleReg[randomNr2] + " sowie aus Ihrer Region. Viele weitere regionale Apps warten auf Sie.", request);	
    }
    else {
    	 PortalUtil.addPageKeywords("Apps " + shuffleReg[randomNr] + ", Apps " + shuffleReg[randomNr2], request);
         PortalUtil.addPageDescription("Auf GovApps finden Sie mobile Apps aus " + shuffleReg[randomNr] + " und " +shuffleReg[randomNr2] + " sowie aus Ihrer Region. Viele weitere Apps warten auf Sie.", request);	
         
    }
    
%>



<!-- portletName="VeplaDetailsPortlet_WAR_VeplaDetailsPortletportlet" -->
	
	<form name="setAppIdForm" id="hiddenAppIdForm" action="<liferay-portlet:actionURL/>" method="GET">
		<input type="hidden" id="appid" name="nr" value="" />
		<input type="hidden" id="appname" name="app" value="" />
	</form>

   
 
<%
	if(searchStr != null) {
		if(searchStr.equals("null")) {
			lastSearchView="Alle Themen";	
		}
	} else {
		lastSearchView=searchStr;
	}
%>





<div id="socialshareprivacy"><span class="socialicon"><img src="/vepa-theme/images/socialshareprivacy/socialbookmarks.png"></span></div>
<div id="mainSearchStringContainer" style="visibility:hidden">
<h1>Suche nach: <span id="lastSearchString"><%= lastSearchView %></span></h1>
<div class="lastSearchRegion"><h3><span id="lastSearchStringRegion"><%= lastSearchStringRegion %></span></h3></div>
<h3><span class="muted" id="hitCount"></span> Apps </h3>

</div>

<script type="text/javascript">

var searchStr = "<%=searchStr%>";
var filter = "<%=filter%>";
var newAppIds = "<%=newAppIds%>";
var entitleNr = "<%=entitlementId%>";

</script>
<div class="container-fluid tab-pane active" id="searchresultpage">
	<a class="btn btn-primary" id="filter_toggle_mobile">Filter</a>
		<div class="row-fluid">
	    <div class="span3">
		    <!--Sidebar content-->
		    <div id="filters_for_result">
		    
		   			 <div class="accordion" id="accordion4">
							<div class="accordion-group filter">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#filter3">Plattformen</a>
								</div>
							<div id="filter3" class="accordion-body collapse in">
								<div class="accordion-inner">
									<ul>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_webapp" value="platform_webapp"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App.png" message="Web-App"></liferay-ui:icon> WebApp</label> <span class="pull-right badge webapp"> </span>	</li>										
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_android" value="platform_android"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android.png" message="Android "></liferay-ui:icon> Android</label>  <span class="pull-right badge android"> </span>	</li>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_apple" value="platform_ios"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS.png" message="Apple iOS"></liferay-ui:icon>Apple iOS </label>	 <span class="pull-right badge ios"> </span></li>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_blackberry" value="platform_blackberry"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon-Blackberry.png" message="Blackberry mobile App"></liferay-ui:icon> Blackberry </label>  <span class="pull-right badge blackberry"> </span>	</li>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_ubuntu" value="platform_ubuntu"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon_Ubuntu.png" message="Ubuntu mobile App"></liferay-ui:icon> Ubuntu </label>  <span class="pull-right badge ubuntu"> </span>	</li>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_win" value="platform_windows"><liferay-ui:icon src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows.png" message="Windows mobile App"></liferay-ui:icon> Windows </label>  <span class="pull-right badge windows"> </span>	</li>

									
<!-- 										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="device_Smartphone" value="device_Smartphone">Smartphone</label>	</li>
										<li> <label class="checkbox"><input type="checkbox" class="filter-checkbox" id="device_Tablet" value="device_Tablet">Tablet</label>	</li> -->
									</ul>
									</div>
								</div>
							</div>
				   		</div>
				   		
				   		<div class="accordion" id="accordion6">
							<div class="accordion-group filter">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion6" href="#filter5">Regionen</a>
								</div>
							<div id="filter5" class="accordion-body collapse in">
								<div class="accordion-inner">
									<ul id="regions">
									</ul>
									</div>
								</div>
							</div>
				   		</div>
				   		
				<div class="accordion" id="accordion2">
					<div class="accordion-group filter">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#filter1">Themen</a>
						</div>
						<div id="filter1" class="accordion-body collapse in">
							<div class="accordion-inner">
								<ul id="categories">
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				<div class="accordion" id="accordion5">
							<div class="accordion-group filter">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#filter4">Berechtigungen</a>
								</div>
							<div id="filter4" class="accordion-body collapse in">
								<div class="accordion-inner">
									<ul id="filter_entitlements">								
									</ul>
									</div>
								</div>
							</div>
				   		</div>
				
				<div class="accordion" id="accordion3">
					<div class="accordion-group filter">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#filter2">Kosten</a>
						</div>
						<div id="filter2" class="accordion-body collapse in">
						<div class="accordion-inner">
									<ul class="filter_for_fee">
										<li> <label class="checkbox"><input type="checkbox" id="no_fee" value="fee_0" class="filter-checkbox"> Kostenlos </label>	</li>
										<li> <label class="checkbox"><input type="checkbox" id="with_fee" value="fee_1" class="filter-checkbox"> Kostenpflichtig </label>	</li>
									</ul>
	
									</div>
								</div>
							</div>
				   		</div>
				   		
				  <div class="accordion" id="accordion_opendata">
					<div class="accordion-group filter">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion_opendata" href="#filter_opendata">Offene Daten</a>
						</div>
						<div id="#filter_opendata" class="accordion-body collapse in">
						<div class="accordion-inner">
									<ul class="filter_for_opendata">
										<li> <label class="checkbox"><input type="checkbox" id="uses_opendata" value="uses_opendata" class="filter-checkbox"> Nutzt offene Daten </label>	</li>
									</ul>	
									</div>
								</div>
							</div>
				   		</div>
				   		
				   		
				   		
				   		
				   		
				   		</div>
				    </div>
				  
				<div class="span9 searchresult_list">
				<div class="filter_searchresult">
					Sortieren nach: <a href="#" id="filter_name" title="Sortieren Sie nach Namen">Name</a> <a href="#" id="filter_date" title="Sortieren Sie nach Datum">Aktualit&auml;t</a>
				</div>
				<div class="searchresult">
					
					<!-- Get all searchresults from JsonRequest  -->
				</div>
				<div id="pagination_resultpage">
				</div>
			</div>
		</div>	
</div>

<script type="text/template" id="os_template"> 

<a {{tooltip_webapp}} id="tooltip_os_web{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App{{webapp}}.png" alt="Als Web-App verf&uuml;gbar"></a>
<a {{tooltip_and}} id="tooltip_os_and{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android{{android}}.png" alt="Als Android-App verf&uuml;gbar"></a>
<a {{tooltip_ios}} id="tooltip_os_ios{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS{{apple}}.png" alt="Als iOS-App verf&uuml;gbar"></a>
<a {{tooltip_blackberry}} id="tooltip_os_blackberry{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Blackberry{{blackberry}}.png" alt="Als Blackberry-App verf&uuml;gbar"></a>
<a {{tooltip_ubuntu}} id="tooltip_os_ubuntu{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon_Ubuntu{{ubuntu}}.png" alt="Als Ubuntu-App verf&uuml;gbar"></a>
<a {{tooltip_win}} id="tooltip_os_win{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows{{windows}}.png" alt="Als Windows-App verf&uuml;gbar"></a>



</script>

	
