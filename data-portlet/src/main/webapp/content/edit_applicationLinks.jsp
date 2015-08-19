<%--
  #%L
  govapps_data
  $Id: edit_applicationLinks.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="./urls.jsp" %>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="<%= viewJSP %>" />
</portlet:renderURL>


<portlet:actionURL name="applicationActionEditLink" var="editURL">
    <portlet:param name="successForward" value="<%= editApplicationLinksJSP %>" />
    <portlet:param name="errorForward" value="<%= editApplicationLinksJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
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
Log _log = LogFactoryUtil.getLog("docroot.content.edit_applicationLinks_jsp");

Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();


List<Link> allLinks = LinkLocalServiceUtil.findByca(companyId, applicationId);
String displayName_1 = "Link zum AppStore";
String url_1 = "http://";
long linkId1 = -1;

String displayName_2 = "Homepage der Anwendung";
String url_2 = "http://";
long linkId2 = -1;

String displayName_3 = "Homepage des Entwicklers";
String url_3 = "http://";
long linkId3 = -1;

String displayName_4 = "Homepage des Herausgebers";
String url_4 = "http://";
long linkId4 = -1;

for (Link link :allLinks) {
	if (link.getType() == 2) {
		displayName_1 = link.getDisplayName();
		url_1 = link.getUrl();
		linkId1 = link.getLinkId();
	}
	
	if (link.getType() == 4) {
		displayName_2 = link.getDisplayName();
		url_2 = link.getUrl();
		linkId2 = link.getLinkId();
	}

	if (link.getType() == 5) {
		displayName_3 = link.getDisplayName();
		url_3 = link.getUrl();
		linkId3 = link.getLinkId();
	}

	if (link.getType() == 6) {
		displayName_4 = link.getDisplayName();
		url_4 = link.getUrl();
		linkId4 = link.getLinkId();
	}
}

%>

<portlet:actionURL name="applicationRedirectWId" var="Anwendung_editieren">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="<%= editApplicationJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Links_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
  <portlet:param name="successForward" value="<%= editApplicationLinksJSP %>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Bilder_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
  <portlet:param name="successForward" value="<%= editApplicationStep3JSP %>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Berechtigungen_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
  <portlet:param name="successForward" value="<%= editApplicationEntitlemetsJSP %>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>


<input class="myInputClass" type="button" value="<liferay-ui:message key="&lt;&lt;zur�ck zur �bersicht" />" onClick="location.href = '<%= cancelURL.toString() %>';" />        
<br />

<input type="button" value="<liferay-ui:message key="Anwendung editieren" />" onClick="location.href = '<%= Anwendung_editieren.toString() %>';" /> -> <b>Schritt 2:Links editieren</b>  ->  <input type="button" value="<liferay-ui:message key="Bilder editieren" />" onClick="location.href = '<%= Bilder_editieren.toString() %>';" />    ->  <input type="button" value="<liferay-ui:message key="Berechtigungen editieren" />" onClick="location.href = '<%= Berechtigungen_editieren.toString() %>';" />


<aui:form
    name="fm"
    action="<%= editURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="applicationId"
        value="<%= applicationId %>"
        type="hidden"
    />

    <aui:input
        name="action"
        value="edit_application"
        type="hidden"
    />

	<aui:field-wrapper label="Anwendungslink">
	    <aui:input
	        name="linkId1"
	        value="<%= linkId1 %>"
	        type="hidden"
	    />
	
		<aui:input 
			name="displayName_1"
			label="Anzeigetext (Erforderlich) "
			type="text"
	        value="<%= displayName_1 %>"	
            helpMessage="Geben sie hier den Link f�r den Anwendungs-Store an."
			inputCssClass="aui-field-required"
			maxlength="200"			
		/>
	    
		<aui:input 
			name="url_1"
            label="URL (Erforderlich) "
			type="text"
	        value="<%= url_1 %>"	
			inputCssClass="aui-field-required"
			maxlength="500"			
		/>
		<hr />
	</aui:field-wrapper>
	
	<aui:field-wrapper label="Anwendungswebseite">
	    <aui:input
	        name="linkId2"
	        value="<%= linkId2 %>"
	        type="hidden"
	    />
		<aui:input 
			name="displayName_2"
			showRequiredLabel="true"
			type="text"
	        value="<%= displayName_2 %>"	
			maxlength="200"			
		/>
	
		<aui:input 
			name="url_2"
			showRequiredLabel="true"
			type="text"
	        value="<%= url_2 %>"	
            helpMessage="F�gen sie hier einen Link ein, der auf eine der Anwendung zugeordnete Webseite mit weiteren Informationen zur Anwendung verweist."
			maxlength="500"			
		/>
		<hr />
	</aui:field-wrapper>

	<aui:field-wrapper label="Entwicklerwebseite">
	    <aui:input
	        name="linkId3"
	        value="<%= linkId3 %>"
	        type="hidden"
	    />
		<aui:input 
			name="displayName_3"
			showRequiredLabel="true"
			type="text"
	        value="<%= displayName_3 %>"	
			maxlength="200"			
		/>
	    
		<aui:input 
			name="url_3"
			showRequiredLabel="true"
			type="text"
	        value="<%= url_3 %>"	
	        helpMessage="F�gen sie hier einen Link ein, der auf eine Webseite mit weiteren Informationen zum Entwickler der Anwendung verweist."
			maxlength="500"			
		/>
		<hr />
	</aui:field-wrapper>

	<aui:field-wrapper label="Anbieterwebseite">
	    <aui:input
	        name="linkId4"
	        value="<%= linkId4 %>"
	        type="hidden"
	    />
		<aui:input 
			name="displayName_4"
			showRequiredLabel="true"
			type="text"
	        value="<%= displayName_4 %>"	
			maxlength="200"			
		/>
	    
		<aui:input 
			name="url_4"
			showRequiredLabel="true"
			type="text"
	        value="<%= url_4 %>"	
	        helpMessage="F�gen sie hier einen Link ein, der auf eine Webseite mit weiteren Informationen zum Anbieter der Anwendung verweist."
			maxlength="500"			
		/>
		<hr />
	</aui:field-wrapper>
   	
    <aui:button-row>
      <aui:button type="submit" value="Speichern" />
      
      
    </aui:button-row>

  </aui:fieldset>

</aui:form>
