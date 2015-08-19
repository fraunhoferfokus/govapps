<%--
  #%L
  govapps_search
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

<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> --%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<% String searchStr = request.getParameter("searchStr"); %>	
<% String setFilter = request.getParameter("filter"); %>
<% String entitlementNr = request.getParameter("entitleNr"); %>
<% String shortCutFilter1 = request.getParameter("shortcut1"); %>		
<% String shortCutFilter2 = request.getParameter("shortcut2"); %>
<% String shortCutFilter =  shortCutFilter1; %>	
<%-- 
<portlet:defineObjects /> --%>


<!-- Here the basics -->
	

	
	<liferay-portlet:renderURL var="setmyFilter" portletName="VeplaSearchResultPortlet_WAR_vepa_SearchResultportlet">
	<liferay-portlet:param name="filter" value="<%=setFilter%>" />
	</liferay-portlet:renderURL>



<!-- Now the shortcuts for search on top  -->

	<form name="setFilter" id="hiddenform" action="<%= setmyFilter %>" method="POST">
		<input type="hidden" id="filter" name="filter" value="" />
		<input type="hidden" id="searchStr" name="searchStr" value="" />
	</form>
							
		<div id="mainnav" style="visibility:hidden;" class="nav-collapse">	   
			<ul class="nav">
                   <li class="dropdown">  
                    <select id="ddPlattform"> 
                       <option value="--null--" selected>Plattform </option>
<!-- The iOS versions  -->
						<option value="platform_webapp">Webapp</option>
						<option value="platform_android">Android</option>
						<option value="platform_ios">Apple iOS</option>
						<option value="platform_blackberry">Blackberry</option>
						<option value="platform_ubuntu">Ubuntu</option>
						<option value="platform_windows">Windows</option>     
                      </select>  
                 </li>
                 <li class="dropdown">
                      <select id="ddRegions"> 
                       <option value="--null--" selected>Regionen </option>
<!-- Get all regions - filled from javascript  -->	                       
                      </select>
                 </li>
                     <li class="dropdown">
                      <select id="ddCategories"> 
                      <option value="--null--" selected>Themen </option>
<!-- Get all categories - filled from javascript  -->	                        
                      </select>
                 </li>
                  </ul>
			</div>

	<!-- Now the Searchbar -->	
			
		 <a class="btn btn-navbar toggle_extrasearch_mobile" data-toggle="collapse" data-target="#searchform1x1">
			<span class="icon-search">
			</span>
		</a>
				
			<div id="searchform1x1" style="visibility:hidden;" class="mainnav nav-collapse">
					<input type="search" class="input-xlarge search-query" autocomplete="false" data-provide="typeahead" name="searchStr2" id="searchStr2" placeholder="Suche nach Apps  ...">
					<span class="startsearch"><a href="javascript:sendForm1()" title="Suchen Sie hier nach Apps"><img src="/vepa-theme/images/search.jpg" alt="App Suche auf GovApps.de"></a> </span>
				
					
					<ul class="nav pull-right" id="advsearchbtn" >
						<li class="dropdown" >
							<a class="dropdown-toggle mycollapse" data-toggle="collapse" href="#advsearch">Erweiterte Suche <b class="caret"></b></a>			                
						</li>
					</ul>
					
<!-- Now the advanced search box  -->	

				<div id="advsearch" class="collapse span12">
				   <div class="btn-toolbar">
					   <div class="btn-group span12">
						   <select multiple="multiple" id="setPlattform2012"> 
							 <option value="--null--" selected>Plattformen </option>
		<!-- The iOS versions  -->
							<option value="platform_webapp">Webapp</option>
							<option value="platform_android">Android</option>
							<option value="platform_ios">Apple iOS</option>
							<option value="platform_blackberry">Blackberry</option>
							<option value="platform_ubuntu">Ubuntu</option>
							<option value="platform_windows">Windows</option>     				
							</select>
						</div>
						 <div class="btn-group span12">
							<select multiple="multiple" id="setRegions2012"> 
							 <option value="--null--" selected>Regionen </option>
		<!-- Get all regions - filled from javascript  -->		
							</select>
						</div>
						 <div class="btn-group span12">
						  <select multiple="multiple" id="setCategories2012"> 
						   <option value="--null--" selected>Themen </option>
	<!-- Get all categories - filled from javascript  -->
							</select>
						  
						</div>
				   </div>

					
					<div class="span12 hr"></div>
					
					
					<ul class="searchprice">
							<li class="price">Preis: </li>	
							<li><label class="checkbox inline"><input type="checkbox" name="fee_0" value="fee_0"> Kostenlos</label></li>
							<li><label class="checkbox inline"><input type="checkbox" name="fee_1" value="fee_1">  Kostenpflichtig</label></li>
					</ul>
					<div class="span12 hr"></div>
					<ul class="searchopendata">
						<li class="opendata">Offene Daten: </li>
						<li><label class="checkbox inline"><input type="checkbox" id="uses_opendata_es" value="uses_opendata"> Nutzt offene Daten </label>	</li>
					</ul>
				
					<div id="advSearchBtn" class="pull-right">
						<button type="button" class="btn btn-primary" data-toggle="button" onClick="javascript:sendForm1()">�bernehmen</button>
						<button type="reset" class="btn" data-toggle="button">Abbrechen</button>
					</div>
				   
				</div>	 		
			</div>
