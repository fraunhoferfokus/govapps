<%--
  #%L
  govapps_concern
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

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
	String previousAddNotSuccessful = "";
	String concernName="", concernDescription="", concernRegion="", concernPlatforms="", concernCategory="", concernMail="";
	previousAddNotSuccessful = ParamUtil.getString(request,"success");
	System.out.println(previousAddNotSuccessful);
	if(previousAddNotSuccessful==null) {
		previousAddNotSuccessful="";
	}
	
	if(previousAddNotSuccessful.equalsIgnoreCase("false")){
		concernName = ParamUtil.getString(request,"concernName");
		concernDescription = ParamUtil.getString(request,"concernDescription");
		concernRegion = ParamUtil.getString(request,"concernRegion");
		concernPlatforms = ParamUtil.getString(request,"concernPlatforms");
		concernCategory = ParamUtil.getString(request,"concernCategory");
		concernMail = ParamUtil.getString(request,"concernMail");
	}

%>

<script type="text/javascript">
	var previousAddNot= "";
	previousAddNot = "<%=previousAddNotSuccessful%>";
	console.log("PreviousAddNotSuccessful: \""+previousAddNot+"\"");
	if(previousAddNot!=undefined && previousAddNot=="false") {
		console.log("prepare resetting of form fields");
		var req_concernName = "<%=concernName%>";
		var req_concernDescription = "<%=concernDescription%>";
		var req_concernRegion = "<%=concernRegion%>";
		var req_concernPlatforms = "<%=concernPlatforms%>";
		var req_concernCategory = "<%=concernCategory%>";
		var req_concernMail = "<%=concernMail%>";
	}
</script>

<liferay-ui:error
     key="contains-forbidden-tags-description"
     message="Ihre Eingaben enthielten nicht erlaubte Zeichen" />
<liferay-ui:error
     key="invalid-captcha"
     message="Ihr captcha war falsch - bitte versuche sie es erneut" />
<liferay-ui:success
	 key="success-add-concern" 
	 message="Vielen Dank f�r Ihre App-Idee. Sie ist erfolgreich zur redaktionellen Pr�fung eingegangen."/>

<div id="concernContainer">
	<div class="container-fluid" id="concernHeader">
		<div class="row-fluid">
			<div class="span6">
			<h1>Ideenb&ouml;rse</h1>
			<span class="muted" id="hitCount">0</span> Ideen
			</div>
			<div class="span6" id="globalSocialMedia_concernList"><span class="socialicon"><img src="/vepa-theme/images/socialshareprivacy/socialbookmarks.png"></span></div>
		</div>
		<div class="row-fluid">
			<div class="span10"></div>
			<div class="span2">
				<a class="btn btn-primary btn-block pull-right" id="add_concern">Idee hinzuf&uuml;gen</a>
			</div>
		</div>
		<a class="btn btn-primary" id="filter_toggle_mobile">Filter</a>
	</div>
	
</div>

			<!-- <div id="concern_collapse_{{concern_id}}" class="accordion-body collapse">
				<div class="span12">
					{{concern_description}}
				</div>
			</div> -->
			
			

<div class="container-fluid" id="concernsPage">
		
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
										<li><label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_webapp" value="platform_webapp"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App.png">
												WebApp</label></li>
										<li><label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_android" value="platform_android"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android.png">
												Android</label></li>
										<li><label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_apple" value="platform_ios"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS.png">
												Apple iOS </label></li>
										<li><label class="checkbox"><input type="checkbox" class="filter-checkbox" id="os_win" value="platform_windows"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows.png">
												Windows </label></li>
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
				</div>
			</div>
	
			<div class="span9 searchresult_list">
				<div class="row-fluid">
					<div id="addConcernForm" style="display:none;">
						<h2>App f&uuml;r B&uuml;rgerinnen und B&uuml;rger</h2>
						<span>Bitte beschreiben Sie m&ouml;glichst ausf&uuml;hrlich die Idee Ihrer App.</span>
						<form action='<portlet:actionURL name="addConcern"/>' id="addConcernForm" method="post" name="addConcernForm">
						<div class="row-fluid">
							<div class="span9">
								<div class="row-fluid">
									<div class="span6">
										<div class="control-group" id="concernNameMail">
											<label class="control-label" for="concernName">Titel*</label>
											<div class="controls">
											<input type="text" id="concernName" required="true" placeholder="Titel der Idee">
											</div>
											<label class="control-label" for="concernMail">Email</label>
											<div class="controls">
											<input type="text" id="concernMail" placeholder="Kontakt Email">
											</div>
										</div>
									</div>
									<div class="control-group" id="concernRegionPlatform">
							  			<div class="span3">
								  			<select multiple="multiple" id="concern_Categories" size="1"> 
							               	<option value="--null--" selected>Themen </option>
											<!-- Get all categories - filled from javascript  -->	                        
							            	</select>
										</div>
										<div class="span3">
											<select multiple="multiple" id="concern_Regions" size="1"> 
						               		<option value="--null--" selected>Regionen </option>
											<!-- Get all categories - filled from javascript  -->	                        
						            		</select>
										</div>
									</div>
								</div>
							</div>
							<div class="span3">
							<liferay-ui:error key="Invalid-captcha" message="Invalid-captcha"></liferay-ui:error>
								<portlet:resourceURL var="captchaURL" />
								Bitte Captcha Eingeben:
								<liferay-ui:captcha url="<%= captchaURL %>" />
								<input type="text" name="captchaText" required="true" id="concern_captcha">

								<br>
								<input type="hidden" id="form_concernName" name="form_concernName" value="">
								<input type="hidden" id="form_concernDescription" name="form_concernDescription">
								<input type="hidden" id="form_concernRegion" name="form_concernRegion">
								<input type="hidden" id="form_concernCategory" name="form_concernCategory">
								<input type="hidden" id="form_concernPlatforms" name="form_concernPlatforms">
								<input type="hidden" id="form_concernMail" name="form_concernMail">
								
							
							</div>
						</div>
						<div class="row-fluid">
							<div class="span9">
		 						<div class="row-fluid">
		 							<p>Plattform*</p>
									<ul class="concern_Platform span12">
											<li><label class="checkbox inline"><input type="checkbox" name="platform_webapp" id="platform_webapp" value="platform_webapp">  <img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App.png"> Web App</label></li>
											<li><label class="checkbox inline"><input type="checkbox" name="platform_android" id="platform_android" value="platform_android"> <img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android.png"> Android</label></li>
											<li><label class="checkbox inline"><input type="checkbox" name="platform_ios" id="platform_ios" value="platform_ios">  <img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS.png"> Apple iOS</label></li>
											<li><label class="checkbox inline"><input type="checkbox" name="platform_win" id="platform_windows" value="platform_windows">  <img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows.png"> Windows</label></li>
									</ul>
								</div> 
								<div class="row-fluid">
									<div class="span12">
										<div class="control-group concernNameDescriptionBox">
											<br>
											<label class="control-label" for="concernDescription">Erkl&auml;rung*</label>
											<div class="controls">
											<textarea class="input-block-level" rows="2" id="concernDescription" required="true">
											</textarea>
											</div>
										</div>
									</div>
								</div>
									
							</div>
							<div class="span3">
								<div class="row-fluid">
									<div class="span12">
										<button type="submit" class="btn btn-primary btn-block" id="proposeConcern">Absenden!</button>
									</div>
								</div>
							</div>	
						</div>
						<div class="row-fluid">
							<div class="span12">
								<div id="errorBox" class="alert alert-error alert-block" style="display:none">
							    <button class="close" data-dismiss="alert" type="button">�</button>
					            </div>
							</div>
						</div>
						</form>
					</div>
					
				</div>
				
				<div class="row-fluid">
					<div class="filter_concernList" style="display:none;">
						Sortieren nach: <a href="#" id="filter_name">Name</a> <a href="#" id="filter_likes">Unterst&uuml;tzungen</a> <a href="#" id="filter_date">Datum</a>
					</div>
					<div class="searchresult" style="display:block;">
		
						<!-- Get all searchresults from JsonRequest  -->
					</div>
					<div id="pagination_resultpage">
					</div>
				</div>
			</div>
		</div>
	</div><script type="text/template" id="concern_template"> 

<div class="row-fluid" id="concern_{{concern_id}}">
	<input type="hidden" id="socialmedia_href_{{concern_id}}" value="https://www.govapps.de/ideenboerse#{{concern_id}}"/>
	<div class="row-fluid" id="concern_accordion_{{concern_id}}">
		<div class="span2">
			<a class="img_concern concern_toggle" id="concern_img_{{concern_id}}" data-toggle="collapse" data-parent="#concern_accordion_{{concern_id}}" href=".concern_collapse_{{concern_id}}">
				<img src="/Vepla-concern-Portlet-portlet/images/idee.png"/>
			</a>
		</div>
		<div class="span7">
			<a class="concern_desc_teaser concern_toggle" id="concern_desc_teaser_{{concern_id}}" data-toggle="collapse" data-parent="#concern_accordion_{{concern_id}}" href=".concern_collapse_{{concern_id}}">
				<h3>{{concern_name}}</h3>
			</a>
			{{concern_description_teaser}}
			<div class="accordion-body collapse concern_collapse_{{concern_id}} concern_collapser" id="concerncollapser_{{concern_id}}">
				<div class="row-fluid">
					<div class="span12">
					{{concern_description}}
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12" id="socialmedia_{{concern_id}}">
					</div>
				</div>
			</div>
		</div>
		<div class="span3 concern_detail_teaser" id="concern_detail_teaser_{{concern_id}}">
			<div class="row-fluid">
				<div class="span12">
					{{concern_platforms}}
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<img src="/Vepla-concern-Portlet-portlet/images/thumb.png"/><span id="support_{{concern_id}}">{{concern_supports}}</span>
				</div>
			</div>
			<div class="accordion-body collapse concern_collapse_{{concern_id}}">
				<div class="row-fluid">
					<div class="span12">
						<img src="/vepa-theme/images/vepa-icons/Details/Icon-Datum.png"/>{{concern_date}}
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						{{concern_category}}
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						{{concern_region}}
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<button class="btn btn-primary btn-block supportConcern" id="support_button_{{concern_id}}">Finde ich gut!</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

</script>

<script type="text/template" id="os_template"> 

<img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App{{webapp}}.png">
<img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android{{android}}.png">
<img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS{{apple}}.png">
<img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows{{windows}}.png">

</script>
