<%--
  #%L
  govapps_data
  $Id: edit_application3.jsp 566 2014-11-13 15:22:01Z sma $
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

<%
Log _log = LogFactoryUtil.getLog("docroot.content.edit_application3_jsp");
Application _application = (Application) request.getAttribute("application");
if (_application == null) {
	_log.info("_application == null !!");
    String _applicationId = (String) request.getParameter("applicationId"); 
    _log.info("_applicationId: " + _applicationId);
    _application = ApplicationLocalServiceUtil.fetchApplication(Long.parseLong(_applicationId));
}

long applicationId = _application.getApplicationId();
String applicationIdString = String.valueOf(applicationId);
_log.debug("applicationIdString: " + applicationIdString);
request.setAttribute("applicationId", applicationIdString);

List<MultiMedia> allMultiMedias = MultiMediaLocalServiceUtil.findByca(companyId, applicationId);

request.setAttribute("backURL", "/content/edit_application3.jsp");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/content/edit_application3.jsp");
portletURL.setParameter("applicationId", String.valueOf(applicationId));

%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="<%= viewJSP %>" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddMultiMedia" var="addURL">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="<%= editApplicationStep3JSP %>" />
    <portlet:param name="errorForward" value="<%= editApplicationStep3JSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="nextURL">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="<%= editApplicationEntitlemetsJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

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
  <portlet:param name="successForward" value="<%=editApplicationEntitlemetsJSP%>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<liferay-ui:error
     key="error-saving-application"
     message="error-saving-application" />
        
<liferay-ui:error
     key="missing-required-application-name"
     message="missing-required-application-name" />
        
<liferay-ui:error key="missing-required-application-description"
    message="missing-required-application-description" />

<liferay-ui:error key="missing-required-application-version"
    message="missing-required-application-version" />

<liferay-ui:error key="missing-required-application-versionInformation"
    message="missing-required-application-versionInformation" />

<liferay-ui:error key="missing-required-application-developer"
    message="missing-required-application-developer" />

<liferay-ui:error key="missing-required-application-legalDetails"
    message="missing-required-application-legalDetails" />

<liferay-ui:error key="missing-required-application-targetCategory"
    message="missing-required-application-targetCategory" />

<liferay-ui:error key="contains-forbidden-tags-application-name"
    message="contains-forbidden-tags-application-name" />

<liferay-ui:error key="contains-forbidden-tags-description"
    message="contains-forbidden-tags-description" />

<liferay-ui:error key="contains-forbidden-tags-application-developer"
    message="contains-forbidden-tags-application-developer" />

<liferay-ui:error key="contains-forbidden-tags-application-legalDetails"
    message="contains-forbidden-tags-application-legalDetails" />


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



<input class="myInputClass" type="button" value="<liferay-ui:message key="&lt;&lt;zur�ck zur �bersicht" />" onClick="location.href = '<%= cancelURL.toString() %>';" />        
<br />

<input type="button" value="<liferay-ui:message key="Anwendung editieren" />" onClick="location.href = '<%= Anwendung_editieren.toString() %>';" /> -> <input type="button" value="<liferay-ui:message key="Links editieren" />" onClick="location.href = '<%= Links_editieren.toString() %>';" />  ->  <b>Schritt 3: Bilder editieren</b>    ->  <input type="button" value="<liferay-ui:message key="Berechtigungen editieren" />" onClick="location.href = '<%= Berechtigungen_editieren.toString() %>';" />

		<liferay-ui:search-container emptyResultsMessage="there-are-no-images" delta="30" iteratorURL="<%= portletURL %>">
		  <liferay-ui:search-container-results>
<%
	  	  results = ListUtil.subList(allMultiMedias, searchContainer.getStart(), searchContainer.getEnd());
		  total = allMultiMedias.size();
		
          pageContext.setAttribute("applicationId", applicationId);
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>
		  </liferay-ui:search-container-results>
		
		  <liferay-ui:search-container-row
		      className="de.fraunhofer.fokus.movepla.model.MultiMedia"
		      keyProperty="multiMediaId"
		      modelVar="_multiMedia">
						
      		<liferay-ui:search-container-column-jsp
	          path="/content/multimedia_icon.jsp"
	          align="left"
	        />
		    			
			<liferay-ui:search-container-column-jsp
		         path="/content/multimedia_actions.jsp"
		         align="right" />
		    			
		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
		
		</liferay-ui:search-container>

<aui:form
    name="fm"
    action="<%= addURL.toString() %>"
    enctype="multipart/form-data"
    method="post">

  <aui:fieldset>

  	Die Dateigr��e eines Bildes ist auf 100 kB beschr�nkt <br /> 
    <aui:input 
    	label="image" 
    	name="file" 
    	type="file" 
 		helpMessage="Um einen optischen Eindruck der Anwendung vermitteln zu k�nnen laden sie hier ihre Screenshots hoch."
   	/>

    <aui:button-row>
      <aui:button type="submit"  value="Hochladen"/>
    </aui:button-row>

  </aui:fieldset>

</aui:form>
