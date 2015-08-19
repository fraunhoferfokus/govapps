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

<div id="concernContainer">
	<div class="container-fluid" id="concernHeader">
		<div class="row-fluid">
			<div class="span8">
			<h1>Aktuelle Wunschliste (<span class="muted" id="hitCount">0</span>)</h1>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="alert alert-success alert-block" id="successBox" style="display:none">
				<button class="close" data-dismiss="alert" type="button">�</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid" id="concernsPage">
		<div class="row-fluid">	
			<div class="span12 searchresult_list">
				<div class="filter_concernList" style="display:none;">
					Sortieren nach: <a href="#" id="filter_name">Name</a> <a href="#"
						id="filter_likes">Unterst&uuml;tzungen</a> <a href="#"
						id="filter_date">Datum</a> <a href="#"
						id="filter_state">Status</a>
				</div>
				<div class="searchresult">
	
					<!-- Get all searchresults from JsonRequest  -->
				</div>
				<div id="pagination_resultpage"></div>
			</div>
		</div>
	</div>
</div>

<script type="text/template" id="concern_template"> 

<div class="row-fluid" id="concern_{{concern_id}}">
	<div class="row-fluid" id="concern_accordion_{{concern_id}}">
		<div class="span2">
			<a class="img_concern" id="concern_img_{{concern_id}}" data-toggle="collapse" data-parent="#concern_accordion_{{concern_id}}" href=".concern_collapse_{{concern_id}}">
				<img src="/Vepla-concern-Portlet-portlet/images/idee.png"/>
			</a>
		</div>
		<div class="span7">
			<h3>{{concern_name}}</h3>
			Mail: <span id="concern_mail_{{concern_id}}">{{concern_mail}}</span><br>
			{{concern_description}}
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
					Unterst&uuml;tzer: {{concern_supports}}
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<h4>Status</h4>
			{{concern_state}}
		</div>
		<div class="span4">
			<button class="btn btn-primary pull-right toggleApprovalState" id="{{concern_id}}">Status wechseln</button>
		</div>
		<div class="span4">
			<button class="btn btn-primary pull-right removeConcern" id="{{concern_id}}">Wunsch l�schen</button>
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

