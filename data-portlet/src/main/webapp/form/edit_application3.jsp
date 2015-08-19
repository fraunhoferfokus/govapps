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

<%
Log _log = LogFactoryUtil.getLog("docroot.form.edit_application3_jsp");
Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();
String applicationIdString = String.valueOf(applicationId);
_log.debug("applicationIdString: " + applicationIdString);

List<MultiMedia> allMultiMedias = MultiMediaLocalServiceUtil.findByca(companyId, applicationId);

request.setAttribute("backURL", "/form/edit_application3.jsp");

%>  

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/form/add_application.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddMultiMedia" var="addURL">
    <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="/form/edit_application3.jsp" />
    <portlet:param name="errorForward" value="/form/edit_application3.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="nextURL">
	<portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="/form/edit_applicationEntitlemets.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />
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


Anwendung editieren	 ->	Links editieren	 ->	<b>Schritt 3: Bilder editieren</b> 	->	Berechtigungen editieren


		<liferay-ui:search-container emptyResultsMessage="there-are-no-images" delta="30">
		  <liferay-ui:search-container-results>
<%
	  	  results = ListUtil.subList(allMultiMedias, searchContainer.getStart(), searchContainer.getEnd());
		  total = allMultiMedias.size();
		
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>
		  </liferay-ui:search-container-results>
		
		  <liferay-ui:search-container-row
		      className="de.fraunhofer.fokus.movepla.model.MultiMedia"
		      keyProperty="multiMediaId"
		      modelVar="_multiMedia">
						
      		<liferay-ui:search-container-column-jsp
	          path="/form/multimedia_icon.jsp"
	          align="left"
	        />
		    			
			<liferay-ui:search-container-column-jsp
		         path="/form/multimedia_actions.jsp"
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
<!-- 
    <aui:input
        name="applicationId"
        value="< % = applicationId %>"
        type="hidden"
    />
    
    <aui:input
        name="action"
        value="edit_application"
        type="hidden"
    />
-->
	Die Dateigr��e eines Bildes ist auf 100 kB beschr�nkt <br /> 
    <aui:input 
    	label="image" 
    	name="file" 
    	type="file" 
 		helpMessage="Um einen optischen Eindruck der Anwendung vermitteln zu k�nnen laden sie hier ihre Screenshots hoch."
   	/>

    <aui:button-row>
      <aui:button type="submit" value="Hochladen" />
      
      <aui:button
          type="cancel"
          value="cancel"
          onClick="<%= cancelURL.toString() %>"
      />

    </aui:button-row>

  </aui:fieldset>

</aui:form>



<!-- 
<aui:form
    name="fm3"
    action="< % = nextURL.toString() % >"
    method="post">
  <aui:fieldset>
      
    <aui:button-row>
      <aui:button
          type="image"
          value="next"
          onClick="< % = nextURL.toString() % >"
      />
    </aui:button-row>
  </aui:fieldset>
</aui:form>
 -->
 
<input type="button" value="<liferay-ui:message key="next" />" onClick="location.href = '<%= nextURL.toString() %>';" />
