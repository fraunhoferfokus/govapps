<%--
  #%L
  govapps_data
  $Id: add_applicationLinks.jsp 566 2014-11-13 15:22:01Z sma $
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

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/devel/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddLink" var="addURL" >
    <portlet:param name="successForward" value="/devel/add_application3.jsp" />
    <portlet:param name="errorForward" value="/devel/add_applicationLinks.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
</portlet:actionURL>

<liferay-ui:success key="link-added-successfully"
    message="link-added-successfully" />

<liferay-ui:success key="link-updated-successfully"
    message="link-updated-successfully" />

<liferay-ui:success key="link-deleted-successfully"
    message="link-deleted-successfully" />

<liferay-ui:error
     key="missing-required-link-displayName"
     message="missing-required-link-displayName" />

<liferay-ui:error
     key="missing-required-link-url"
     message="missing-required-link-url" />

<liferay-ui:error
     key="not-valid-link-url"
     message="not-valid-link-url" />

<liferay-ui:error
     key="contains-forbidden-tags-link-displayName"
     message="contains-forbidden-tags-link-displayName" />
        
<liferay-ui:error
     key="contains-forbidden-tags-link-url"
     message="contains-forbidden-tags-link-url" />

<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.add_applicationLinks_jsp");
Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();

List<Link> allLinks = LinkLocalServiceUtil.findByca(companyId, applicationId);

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";

%>
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
	<div class="bar-custom">Bilder</div>
	<div class="bar-custom">Berechtigungen</div>
</div>
</div>


<h2>Links:</h2>
<div class="well well-small">Das Fragezeichen <img src="<%=helpHREF%>"> gibt Hinweise zu den einzelnen Datenfeldern.</b></div>

<aui:form
    name="fm"
    action="<%= addURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="applicationId"
        value="<%= applicationId %>"
        type="hidden"
    />

    <aui:input
        name="action"
        value="add_application"
        type="hidden"
    />

	<aui:field-wrapper label="Anwendungslink">
		<aui:input
			name="displayName_1"
            label="Anzeigetext (Erforderlich) "
            type="text"
	        value="Anwendungslink"
			inputCssClass="span4"
			maxlength="200"
			cssClass="span4"
		/>
	    
		<aui:input 
		    label="URL (Erforderlich) "
			name="url_1"
            inputCssClass="span4"
			type="text"
	        value="http://"	
            helpMessage="Geben sie hier den Link f&uuml;r den Anwendungs-Store an."
			maxlength="500"
			cssClass="span4"
		/>
		<!-- inputCssClass="span4" -->
		<hr />
	</aui:field-wrapper>
	
	<aui:field-wrapper label="Anwendungswebseite">
		<aui:input 
			name="displayName_2"
			showRequiredLabel="true"
			type="text"
	        value="Anwendungswebseite "	
			maxlength="200"
			inputCssClass="span4"
			cssClass="span4"
		/>
	
		<aui:input 
			name="url_2"
			showRequiredLabel="true"
			type="text"
	        value="http://"	
            helpMessage="F&uuml;gen sie hier einen Link ein, der auf eine der Anwendung zugeordnete Webseite mit weiteren Informationen zur Anwendung verweist."
			maxlength="500"
			inputCssClass="span4"
			cssClass="span4"
		/>
		<hr />
	</aui:field-wrapper>

	<aui:field-wrapper label="Entwicklerwebseite">
		<aui:input 
			name="displayName_3"
			showRequiredLabel="true"
			type="text"
	        value="Entwicklerwebseite"	
			maxlength="200"
			inputCssClass="span4"
			cssClass="span4"
		/>
	    
		<aui:input 
			name="url_3"
			showRequiredLabel="true"
			type="text"
	        value="http://"	
	        helpMessage="F&uuml;gen sie hier einen Link ein, der auf eine Webseite mit weiteren Informationen zum Entwickler der Anwendung verweist."
			maxlength="500"
	        inputCssClass="span4"
	        cssClass="span4"
		/>
		<hr />
	</aui:field-wrapper>

	<aui:field-wrapper label="Anbieterwebseite">
	<aui:input 
		name="displayName_4"
		showRequiredLabel="true"
		type="text"
        value="Anbieterwebseite"	
		maxlength="200"
		inputCssClass="span4"
		cssClass="span4"
	/>
    
	<aui:input 
		name="url_4"
		showRequiredLabel="true"
		type="text"
        value="http://"	
        helpMessage="F&uuml;gen sie hier einen Link ein, der auf eine Webseite mit weiteren Informationen zum Anbieter der Anwendung verweist."
		maxlength="500"
		inputCssClass="span4"
		cssClass="span4"
	/>
	</aui:field-wrapper>
   	
   	
   	<br/>
<hr/>

		<aui:button-row>


			<button type="submit" class="btn btn-large btn-primary" value="next">N&auml;chster Schritt</button>


		</aui:button-row>


  </aui:fieldset>

</aui:form>
