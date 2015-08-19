<%--
  #%L
  govapps_details
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
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<portlet:defineObjects />

<%
	String appIdForDetails = PortalUtil.getOriginalServletRequest(request).getParameter("nr");
	String appName = PortalUtil.getOriginalServletRequest(request).getParameter("app");

  
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
	
    if(appName == null | appName == "")
    	appName="GovApps";
        
	PortalUtil.addPageKeywords(appName +" App, Apps " + shuffleReg[randomNr] + ", Apps " + shuffleReg[randomNr2], request);
	PortalUtil.addPageDescription(appName + " auf GovApps. Weitere mobile Apps zB aus " + shuffleReg[randomNr] + " oder " + shuffleReg[randomNr2]+" finden Sie auf GovApps.de", request);
	PortalUtil.setPageTitle(" " + appName, request);
%>


<script type="text/javascript">
var appIdToLoad = "<%=appIdForDetails%>";
if(!appIdToLoad | isNaN(appIdToLoad) ){
	location.href="/erweiterte-suche/-/results/Apps";
	
}
</script>
<div id="socialshareprivacy"><span class="socialicon"><img src="/vepa-theme/images/socialshareprivacy/socialbookmarks.png"></span></div>
<div id="app-details-container">
	<div class="container-fluid tab-pane" id="app-details">
   		<!-- <a class="btn btn-primary back_to_results"><< Zu den Suchergebnissen</a> -->
   		<div id="app_details_heading" class="separator-top">
		</div>
		<ul class="nav nav-tabs" id="app_detail_tabs">
			
		</ul>
		<div class="tab-content" id="app_detail_tab_content">
			<div class="tab-pane" id="tab0"></div>
			<div class="tab-pane" id="tab1"></div>
			<div class="tab-pane" id="tab2"></div>
			<div class="tab-pane" id="tab3"></div>
			<div class="tab-pane" id="tab4"></div>
			<div class="tab-pane" id="tab5"></div>
		</div>
	</div>
</div>

<script type="text/template" id="similar_app_template">

	<!-- This template is for the small preview version of new or similar apps -->
<form action="<liferay-portlet:actionURL/>" method="GET" id="form{{app_id}}">
	<div class="{{span_size}}">
		<div class="{{span_icon}}">
			<a class="similar_app_links btn-link" href="/details/-/results/Apps?nr={{app_id}}&app={{ app_name }}" id="{{related_ids}}" title="{{ app_name }}" onClick="submit();">
				<img src="{{app_icon}}" class="similar_app_links" id="{{related_ids}}" alt="GovApps | {{ app_name }}" >
			</a>
		</div>
		<div class="{{span_details}}">	
		<a class="similar_app_links btn-link" href="/details/-/results/Apps?nr={{app_id}}&app={{ app_name }}" id="{{related_ids}}" title="{{ app_name }}" onClick="submit();">{{ app_name }}</a><br><br>
				{{app_target_oss}}		
		</div>
	</div>
</form>
</script>




<script type="text/template" id="os_template"> 

<a {{tooltip_webapp}} id="tooltip_os_web{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App{{webapp}}.png"></a>
<a {{tooltip_and}} id="tooltip_os_and{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android{{android}}.png"></a>
<a {{tooltip_ios}} id="tooltip_os_ios{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS{{apple}}.png"></a>
<a {{tooltip_win}} id="tooltip_os_win{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows{{windows}}.png"></a>
<a {{tooltip_blackberry}} id="tooltip_os_blackberry{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Blackberry{{blackberry}}.png"></a>
<a {{tooltip_ubuntu}} id="tooltip_os_ubuntu{{app_id}}"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Ubuntu{{ubuntu}}.png"></a>



</script>

<script type="text/template" id="os_template">
<option class="multiselect_touch_filter" id="{{id}}" value="{{value}}" {{selected}}>{{text}}</option>
</script>

<!-- <div id="versions_per_os_{{app_id}}"></div> -->
<script type="text/template" id="search_result_template">
<div id="socialshareprivacy"> </div>
		<!-- 	this is the template for a details version of an app
		each different version of an app (based on respective target OS)
		is based on that template -->
	<div id="app_detail_for_id_{{app_id}}">
		<div class="row-fluid">
			<div class="span8">
				<div class="row-fluid">
					<div class="span12 movepla-content app_description" id="app_details">
						<a href="{{app_store_link}}" title="{{app_target_os_storename}}" target="_blank" value="{{app_id}}" class="app_store_link_button btn btn-primary"> {{app_target_os_storename}} : {{app_fee}}</a>
						{{app_description}}
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12 movepla-content" >
						<h3>{{count_screenshots}} Screenshot{{multiple_screens}}</h3>
							<div id="gallery">
								<div id="screens-slider{{app_id}}" value="{{count_screenshots}}" class="flexslider flexslider_screens-slider">
									<ul class="slides">
									{{app_screenshots_swipe}}
									</ul>
								</div>
							</div>
					</div>
				</div>
			</div>
			<div class="span4">
				<div class="row-fluid">
					<div class="span12 movepla-content" id="app_facts">
						<div class="accordion" id="accordion2">
							<div class="accordion-heading">
								<h5 class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" data-target="#collapseOne{{app_id}}">
								Berechtigungen
								</h5>
							</div>
							<div id="collapseOne{{app_id}}" class="accordion-body collapse in">
								<div class="accordion-inner">
									<div class="row-fluid">
									<a id="ent_net_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation-Aktiv.png" id="det_ent_network{{app_id}}" class="disabled_ent"></a> 
									<a id="ent_med_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff-Aktiv.png" id="det_ent_media_access{{app_id}}" class="disabled_ent"></a> 
									<a id="ent_pla_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste-Aktiv.png" id="det_ent_directions{{app_id}}" class="disabled_ent"></a> 
									<a id="ent_sys_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung-Aktiv.png" id="det_ent_system_settings{{app_id}}" class="disabled_ent"></a> 
									<a id="ent_fee_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste-Aktiv.png" id="det_ent_money{{app_id}}" class="disabled_ent"></a> 
									<a id="ent_per_tooltip{{app_id}}" class="ent_tooltip" rel="tooltip" data-placement="bottom">
									<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten-Aktiv.png" id="det_ent_personal{{app_id}}" class="disabled_ent"></a> 
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12 movepla-content" id="app_details2">
						<div class="accordion" id="accordion3">
							<div class="accordion-heading">
								<h5 class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" data-target="#collapseTwo{{app_id}}">
								Daten
								</h5>
							</div>
							<div id="collapseTwo{{app_id}}" class="accordion-body collapse in">
								<div class="accordion-inner">
									<div class="row-fluid">
										<ul class="nav nav-pills nav-stacked">
											<li>{{app_category}}</li>
											<li><img src="/vepa-theme/images/vepa-icons/Details/Icon-Datum.png"> {{app_update}}</li>
											<li><img src="/vepa-theme/images/vepa-icons/Details/Icon-MB.png"> {{app_size}} MB</li>
											<li><img src="/vepa-theme/images/vepa-icons/Details/Icon-Sprachen.png"> {{app_languages}}</li>
 											{{uses_open_data}}
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12 movepla-content" id="app_author">
						<div class="accordion" id="accordion4">
							<div class="accordion-heading">
								<h5 class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" data-target="#collapseThree{{app_id}}">
								Regionen
								</h5>
							</div>
							<div id="collapseThree{{app_id}}" class="accordion-body collapse in">
								<div class="accordion-inner">
									<div class="row-fluid">
										{{app_regions}}
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12 movepla-content">
						<div class="accordion" id="accordion5">
							<div class="accordion-heading">
								<h5 class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" data-target="#collapseFour{{app_id}}">
								Herausgeber
								</h5>
							</div>
							<div id="collapseFour{{app_id}}" class="accordion-body collapse in">
								<div class="accordion-inner">
									<div class="row-fluid">
										<p>{{app_developer}}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12 movepla-content similar_app_box" id="app_similar">
				<h3>{{count_similar_apps}} App{{multiple_apps}} aus der Region</h3>

				<div id="gallery_sim_apps">
					<div id="sim-apps-slider{{app_id}}" value="{{count_similar_apps}}" class="flexslider flexslider_simapps">
						<ul class="slides">
						{{app_sim_apps_mobile}}
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

</script>
