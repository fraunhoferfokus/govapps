<%--
  #%L
  govapps_data
  $Id: add_application_preamble.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="../include.jsp"%>

<noscript>
	<h1>
		<font color="#ff0000"> Diese Seite ben&ouml;tigt JavaScript. Bitte
			&auml;ndern Sie Ihre Browsereinstellungen. </font>
	</h1>
</noscript>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/devel/view.jsp" />
	<portlet:param name="errorForward"
		value="/devel/add_application_preamble.jsp" />
	<portlet:param name="successForward" value="/devel/add_application.jsp" />
</portlet:renderURL>

<portlet:actionURL name="redirectAction" var="addURL">
	<portlet:param name="successForward" value="/devel/add_application.jsp" />
	<portlet:param name="exceptionForward" value="/devel/error.jsp" />
	<portlet:param name="errorForward"
		value="/devel/add_application_preamble.jsp" />
</portlet:actionURL>


<%

Log _log = LogFactoryUtil.getLog("docroot.devel.add_application_jsp");
try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);


String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";
long articleResourcePrimKey = AppConstants.getStaticPage("SVP");
if (articleResourcePrimKey >= 0) {
%>
<liferay-ui:journal-article
	articleResourcePrimKey="<%=articleResourcePrimKey%>" />
<%
}
%>


<script type="text/javascript">
function checkSubmit( clicked )
{
 if (clicked) {
  document.getElementById("continue").disabled=false;
 } else {
  document.getElementById("continue").disabled=true;
 }
}
</script>


<div class="modal hide fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="myModalLabel">AGB</h3>
	</div>
	<div class="modal-body">
		<%@include file="agb.jsp"%>
	</div>
	<div class="modal-footer">
		<a class="btn" data-dismiss="modal" aria-hidden="true">Schlie&szlig;en</a>
	</div>
</div>

<label class="checkbox"> <input type="checkbox" id="agbcheck"
	onclick="checkSubmit(this.checked)">Ich akzeptiere die <a
	href="#myModal" role="button" data-toggle="modal">AGB</a>
</label>

<hr />

<aui:button-row>
	<a class="btn btn-large"
		onClick="location.href = '<%=cancelURL.toString()%>'">Ablehnen</a>
	<button id="continue" disabled="disabled"
		class="btn btn-large btn-primary"
		onClick="location.href = '<%=addURL.toString()%>'">Annehmen</button>
</aui:button-row>



<%
	
} catch (Exception e) {
	_log.debug(e.getMessage());	
	e.printStackTrace();
}
%>
