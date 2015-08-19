<%--
  #%L
  govapps_newestapps
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />

<%
	
	String new_app_ids=request.getParameter("appid");

%>

<!-- template for newest app -->
<script type="text/template" id="newest_app_template">
	<div class="{{span_app}}">
		<div class="{{span_icon}}">
			<a href="/details/-/results/Apps?nr={{app_id}}&app={{ app_name }}" id="{{app_id}}" title="{{ app_name }}" onClick="submit();">
				<img src="{{app_icon}}" {{icon_class}} class="new_app_link" id="{{app_id}}" alt="{{ app_name }}" title="{{ app_name }}">
			</a>
		</div>
		<div class="{{span_details}}">
			<form action="<liferay-portlet:actionURL/>" method="GET" id="form{{app_id}}">
				<input type="hidden" value="{{newappids}}" name="appid" id="appid">
				<input type="hidden" value="2" name="root">
				<a href="/details/-/results/Apps?nr={{app_id}}&app={{ app_name }}" id="{{app_id}}" title="{{ app_name }}" onClick="submit();">{{ app_name }}</a>
			</form>
			

			{{app_oss}}		
		</div>
	</div>
</script>

<script type="text/template" id="os_template"> 
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App{{webapp}}.png" alt="Als Web-App verf&uuml;gbar"></a>
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android{{android}}.png" alt="Als Android-App verf&uuml;gbar"></a>
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS{{apple}}.png" alt="Als iOS-App verf&uuml;gbar"></a>
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Blackberry{{blackberry}}.png" alt="Als Blackberry-App verf&uuml;gbar"></a>
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon_Ubuntu{{ubuntu}}.png" alt="Als Ubuntu-App verf&uuml;gbar"></a>
<a><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows{{windows}}.png" alt="Als Windows-App verf&uuml;gbar"></a>
</script>


		<h3>Neueste Apps</h3>
		<div id="newest_app_swipe_nav" class="flexslider">
		</div>
		

