<%--
  #%L
  govapps_data
  $Id: add_application3.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="../include.jsp" %>

<%
Log _log = LogFactoryUtil.getLog("docroot.devel.add_application3_jsp");

Application _application = (Application) request.getAttribute("application");
if (_application == null) {
	String _applicationId = (String) request.getParameter("applicationId"); 
	_application = ApplicationLocalServiceUtil.fetchApplication(Long.parseLong(_applicationId));
}

long applicationId = _application.getApplicationId();

_log.debug("applicationId: " + applicationId);
List<MultiMedia> allMultiMedias = MultiMediaLocalServiceUtil.findByca(companyId, applicationId);

request.setAttribute("backURL", "/devel/add_application3.jsp");
request.setAttribute("successForward", "/devel/add_application3.jsp");

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/devel/add_application3.jsp");
portletURL.setParameter("applicationId", String.valueOf(applicationId));

%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/devel/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationRedirectWId" var="nextURL">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="/devel/add_applicationEntitlemets.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
</portlet:actionURL>

<portlet:actionURL name="applicationActionAddMultiMedia" var="addURL">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="/devel/add_application3.jsp" />
    <portlet:param name="errorForward" value="/devel/add_application3.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
</portlet:actionURL>


<liferay-ui:error key="error-adding-multiMedia"
    message="error-adding-multiMedia" />

<liferay-ui:error key="error-saving-image-size"
    message="error-saving-image-size" />

<liferay-ui:error key="error-saving-image-duplicate-file"
    message="error-saving-image-duplicate-file" />

<liferay-ui:error key="error-adding-multiMedia-extension"
    message="error-adding-multiMedia-extension" />

<liferay-ui:error key="error-deleting-multiMedia"
    message="error-deleting-multiMedia" />

<liferay-ui:success key="multiMedia-added-successfully"
    message="multiMedia-added-successfully" />

<liferay-ui:success key="multiMedia-updated-successfully"
    message="multiMedia-updated-successfully" />

<liferay-ui:success key="multiMedia-deleted-successfully"
    message="multiMedia-deleted-successfully" />


<div class="page-header">
    <small>
        <a onClick="location.href = '<%=cancelURL.toString()%>'" class="btn btn-mini">Zur&uuml;ck</a>
    </small>
	<h1>
		Anwendung hinzuf&uuml;gen <small>in 4 Schritten</small>
	</h1>
<div class="progress">
	<div class="bar" style="width: 25%;">Anwendungsdetails</div>
	<div class="bar" style="width: 25%;">Links</div>
	<div class="bar" style="width: 25%;">Bilder</div>
	<div class="bar-custom">Berechtigungen</div>
</div>
</div>


<h2>Bilder:</h2>
<div class="well well-small">
    Um einen optischen Eindruck der Anwendung vermitteln zu k&ouml;nnen, laden Sie hier mindestens ein Screenshot hoch.<br/>
    Das Fragezeichen <img src="<%=helpHREF%>"> gibt Hinweise zu den
    einzelnen Datenfeldern.</b>
</div>

<aui:form
    name="fm"
    action="<%= addURL.toString() %>"
    enctype="multipart/form-data"
    method="post">

  <aui:fieldset>
<!-- 
    <aui:input
        name="action"
        value="add_application"
        type="hidden"
    />

    <aui:input
        name="applicationId"
        value="< % = applicationId %>"
        type="hidden"
    />
--> 

	<aui:input label="image" name="file" type="file"
			helpMessage="Um einen optischen Eindruck der Anwendung vermitteln zu k&ouml;nnen laden Sie hier ihre Screenshots hoch."
			width="200" multiple="true" cssClass="input-medium" inputCssClass="btn" />
    <p class="text-info">Die maximale Dateigr&ouml;&szlig;e betr&auml;gt 100kb</p> 

    <aui:button-row>
	   <button type="submit" class="btn btn-large btn-success">Hochladen</button>
    </aui:button-row>

  </aui:fieldset>

</aui:form>


		<liferay-ui:search-container emptyResultsMessage="there-are-no-images" delta="5" iteratorURL="<%= portletURL %>" >
		  <liferay-ui:search-container-results>
<%
	  	  results = ListUtil.subList(allMultiMedias, searchContainer.getStart(), searchContainer.getEnd());
		  total = allMultiMedias.size();
		
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>
		  </liferay-ui:search-container-results>
		
		<% boolean color = false; %>
		
		  <liferay-ui:search-container-row
		      className="de.fraunhofer.fokus.movepla.model.MultiMedia"
		      keyProperty="multiMediaId"
		      modelVar="_multiMedia"
		      rowVar="_applicationRow">
						
<% 
		      if (color=!color)
		      	_applicationRow.setClassName("app-search-row-even");
		      else
		   		_applicationRow.setClassName("app-search-row-odd");
%>
						
      		<liferay-ui:search-container-column-jsp
	          path="/devel/multimedia_icon.jsp"
	          align="left"
	        />
		    
			<liferay-ui:search-container-column-jsp
		         path="/devel/multimedia_actions.jsp"
		         align="right" />
			
		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
		
		</liferay-ui:search-container>

    <br/>
    
	<aui:button-row>
<%
    if (allMultiMedias.size() > 0 ) {    	
%>
        <button class="btn btn-large btn-primary" value="next" onClick="location.href = '<%= nextURL.toString() %>';">N&auml;chster Schritt</button>
<%    	
    }
%>
	</aui:button-row>
