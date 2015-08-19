<%--
  #%L
  govapps_data
  $Id: application_actions.jsp 566 2014-11-13 15:22:01Z sma $
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
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Enumeration<String> attributeNames = request.getAttributeNames();
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.application_actions_jsp");

Application myApplication = (Application) row.getObject();
String name = Application.class.getName();
String applicationId = String.valueOf(myApplication.getApplicationId());
%>

<liferay-ui:icon-menu>
<%
try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
	long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.CONTENT_PROVIDER).getRoleId();		
%>


    <portlet:actionURL name="applicationRedirectWId" var="readURL">
        <portlet:param name="applicationId" value="<%= applicationId %>" />
        <portlet:param name="successForward" value="/content/view_application.jsp" />
        <portlet:param name="exceptionForward" value="/content/error.jsp" />
    </portlet:actionURL>

    <liferay-ui:icon  message="Vorschau" url="<%= readURL.toString() %>" />

    <portlet:actionURL name="applicationRedirectWId" var="editURL">
      <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
      <portlet:param name="successForward" value="<%= editApplicationJSP %>" />
      <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
    </portlet:actionURL>
    
    <liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />

    <portlet:actionURL name="applicationActionDelete" var="deleteURL">
      <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    </portlet:actionURL>
    
    <liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />

    <portlet:actionURL name="applicationActionCloneApplication" var="addVarURL">
        <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
        <portlet:param name="successForward" value="<%= editApplicationJSP %>" />
        <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
    </portlet:actionURL>

<%
    if (myApplication.getLifeCycleStatus() != E_Stati.APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED.getIntStatus() ) {
%>  
        <liferay-ui:icon  message="Variante hinzuf�gen" url="<%= addVarURL.toString() %>" />
<%		
    }
} catch (Exception e) {
	}
%>
    
</liferay-ui:icon-menu>
