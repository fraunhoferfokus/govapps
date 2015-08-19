<%--
  #%L
  govapps_data
  $Id: add_applicationEntitlemets.jsp 566 2014-11-13 15:22:01Z sma $
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
  <portlet:param name="jspPage" value="/form/add_application.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddEntitlements" var="addURL">
    <portlet:param name="successForward" value="/form/end.jsp" />
    <portlet:param name="errorForward" value="/form/add_applicationEntitlements.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />
</portlet:actionURL>


<!--  Error Messages -->

<liferay-ui:error key="contains-forbidden-tags-application_entitlement-motivation"
    message="contains-forbidden-tags-application_entitlement-motivation" />

<liferay-ui:error key="too-short-entitlement-explanation"
     message="too-short-entitlement-explanation" />


<!--  Success Messages -->

    
<liferay-ui:success key="entitlement-added-successfully"
    message="entitlement-added-successfully" />

<liferay-ui:success key="entitlement-updated-successfully"
    message="entitlement-updated-successfully" />

<liferay-ui:success key="entitlement-deleted-successfully"
    message="entitlement-deleted-successfully" />
    
<%
Log _log = LogFactoryUtil.getLog("docroot.form.add_application4_jsp");
Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();
_log.debug("applicationId: " + applicationId);


List<Entitlement> allEntitlements = EntitlementLocalServiceUtil.getEntitlements(companyId);
List<Application_Entitlement> allApplicationEntitlements = Application_EntitlementLocalServiceUtil.findByca(companyId, applicationId);


%>
Anwendung beschreiben	->	Links hinzuf�gen	->	Bilder hinzuf�gen 	->	<b>Schritt 4: Berechtigungen erl�utern</b><br />
		
		
<b>Bitte w�hlen sie welche Berechtigungen Ihre Anwendung ben�tigt und geben gegebenenfalls eine nachvollziehbare Begr�ndung an, warum diese notwendig ist.</b>

		
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
        name="companyId"
        value="<%= companyId %>"
        type="hidden"
    />

    <aui:input
        name="action"
        value="add_application"
        type="hidden"
    />
<%
   	for (Entitlement entitlement :allEntitlements) {
   		
   		String _name       = "name_"       + entitlement.getEntitlementName(); 
   		String _motivation = "motivation_" + entitlement.getEntitlementName();
   		String _id = "toggle_id" + _name;

   		_log.debug("_name: " + _name);
		_log.debug("_motivation: " + _motivation);
   		
%>

	
		<liferay-ui:toggle
			id="<%= _id %>"
			showImage='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>'
			hideImage='<%= themeDisplay.getPathThemeImages() + "/common/close.png" %>'
			defaultShowContent="true"
		/> &nbsp; <aui:field-wrapper label="<%= entitlement.getEntitlementName() %>"> </aui:field-wrapper>
		

	<div id="<%= _id %>" style="display: <liferay-ui:toggle-value id="<%= _id %>" />; padding-top: 10px;">
		<p><%= entitlement.getExplanation() %> </p>
		    <aui:input 
		        name="<%= _name %>"
				type="hidden"
		        value="<%= entitlement.getEntitlementName() %>"
		    />
			
		    <aui:input
		        name="<%= _motivation %>"
		        type="textarea"
 				rows="4" cols="200"
 				helpMessage="Begr�nden sie, warum ihre Anwendung diese Berechtigung ben�tigt."
 				maxlength="1000" 				
		    />
	</div>


		    
<%   			
   	}
   	
%>
    
    <aui:button-row>
      <aui:button type="submit"  value="next"/>
      
      <aui:button
          type="cancel"
          value="cancel"
          onClick="<%= cancelURL.toString() %>"
      />

    </aui:button-row>

  </aui:fieldset>

</aui:form>
