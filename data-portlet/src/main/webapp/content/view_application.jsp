<%--
  #%L
  govapps_data
  $Id: view_application.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@page import="de.fraunhofer.fokus.movepla.portlets.ViewUtil.E_FieldType"%>
<%@page import="de.fraunhofer.fokus.movepla.portlets.ViewUtil"%>
<%@include file="../include.jsp" %>
<%@include file="./urls.jsp" %>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="<%=viewJSP%>" />
</portlet:renderURL>

<link rel="stylesheet" type="text/css" href="/vepa-backend-theme/css/bootstrap.css">

<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.view_application_jsp");
try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
	long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.CONTENT_PROVIDER).getRoleId();		

        Application _application = (Application) request.getAttribute("application");
        if (_application == null) {
            String _applicationId = (String) request.getParameter("applicationId");
            _application = ApplicationLocalServiceUtil.fetchApplication(Long.parseLong(_applicationId));
        }

        long applicationId = _application.getApplicationId();
        String applicationIdString = String.valueOf(applicationId);
        _log.debug("applicationIdString: " + applicationIdString);

        if (applicationIdString == null || "null".equals(applicationIdString)) {
    		PortletURL renderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
    		Map<String, String[]> map = renderURL.getParameterMap();
    		applicationIdString =  map.get("applicationId")[0];
        }

		
		long oldApplicationId =_application.getOldVersionId();
		Application _oldApplication = null;
		if (oldApplicationId > 0)
			_oldApplication = ApplicationLocalServiceUtil.getApplication(oldApplicationId);
		
		User _user = null;
		String _userName = "";
		String _userEmail = "";
		
		try {
			 _user = UserLocalServiceUtil.getUser(_application.getUserId());
			 _userName = _user.getFullName();
			 _userEmail = _user.getEmailAddress();
		} catch (Exception e) {
	        _log.debug("user with id: " + _application.getUserId() + " not found");
		}
		
		/*
		* define what a request is
		*/
        boolean isRequest = _application.getLifeCycleStatus() == E_Stati.APPLICATION_STATUS_SUBMITTED.getIntStatus() ||
        		_application.getLifeCycleStatus() == E_Stati.APPLICATION_STATUS_RESUBMITTED.getIntStatus() ||
                _application.getLifeCycleStatus() == E_Stati.APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED.getIntStatus() ||
        		_application.getLifeCycleStatus() == E_Stati.APPLICATION_STATUS_DELETED.getIntStatus();
		
		String relIds = _application.getRelatedApplicationId();
		List<Application> relApps = new LinkedList<Application>();
		if (relIds.trim().length() > 0) {
			String[] relIdSplit = relIds.split(";");
			for (String relId : relIdSplit) {
				Long id = null;
				try {
					id = Long.valueOf(relId);
				} catch (Throwable t) {
				}
				if (id != null) {
					Application relApp = ApplicationLocalServiceUtil.getApplication(id);
					if (relApp != null)
						relApps.add(relApp);
				} else {
					log("Invalid related appID: " + relId);
				}

			}
		}
		%>

<a class="btn btn-mini" type="button" onClick="location.href = '<%= cancelURL.toString() %>';" ><liferay-ui:message key="&lt;&lt;zur�ck zur �bersicht" /></a>

<div class="hero-unit" style="padding: 10px;">
 
 <% if (_oldApplication != null) { %>
 
 <div class="row-fluid">
 <div class="span8 offset2">
  <div class="span12">
   <strong>Die Darstellung folgt dem Schema:</strong>
  </div>
  <div class="span12">
  <div class="row-fluid">
   <div class="span8 offset2 alert alert-info">
   Unver&auml;nderte Angaben
   </div>
  </div>
  <div class="row-fluid">
  <div class="span6 alert alert-error">
   Eintrags&auml;nderung: Alter Stand
  </div>
  <div class="span6 alert alert-success">
   Eintrags&auml;nderung: Neuer Stand
   </div>
  </div>
  </div>
 </div>
 </div>
 
 <%
  }
 %>
 
 <div class="page-header">
  <h3><%=_application.getName()%></h3>
 </div>
 
 <div class="row-fluid">
 <div class="span10 offset1 alert">
  <div class="span3">
   <strong>Nutzer:</strong>
  </div>
  <div class="span9">
   <%= _userName %><br/> <%= _userEmail %>
  </div>
 </div>
</div>
<div class="row-fluid">
 <div class="span10 offset1 alert">
  <%
	  int statusInt = _application.getLifeCycleStatus();
	  E_Stati e_status = AppConstants.getStatus(statusInt);
	  String statusString = e_status.getStrStatus();
  %>
  <div class="span3">
   <strong>Status:</strong></div>
   <div class="span9">
    <liferay-ui:message key="<%= statusString %>"></liferay-ui:message>
   </div>
 </div>
 </div>
 <div class="row-fluid">
 <% 
 if (relApps.size() > 0) {
	 %>
	 <div class="span10 offset1 alert">
	 <strong>Verwandte Apps:</strong>
	 <%
		for (Application app : relApps) {
			String os = app.getTargetOS();
			E_Images img = AppConstants.getPlatform(os);
%>
        <div style="margin: 10px;">
<%
           if (img != null) {
%> 
				<a href="<portlet:actionURL name="applicationRedirectWId">
						<portlet:param name="applicationId" value="<%=String.valueOf(app.getApplicationId())%>" />
	                    <portlet:param name="successForward" value="/devel/view_application.jsp" />
	                    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
					</portlet:actionURL>">
					 <img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" />&nbsp;<%=os%>
					</a> 
<%
			 }
%>

        </div>
<%
	   }
	 %>
	 </div>
	 <%
	}
 %> 
</div>
 
</div>



<%
		
		E_FieldType[] fields = E_FieldType.values();
		
		for (E_FieldType field: fields) {
			
			Application viewApp = null;
%>


       <div class="row-fluid">
       <%
         boolean isDif = ViewUtil.isDifferent(_oldApplication, _application, field);
       
         if (_oldApplication == null)
        	 viewApp = _application;
         else
        	 viewApp = _oldApplication;
         
         if (!isDif) {
       %>
        <div class="span10 offset1 alert alert-info">
        
       <%
         } else {
       %>
        <div class="span6 alert alert-error">
       <%
         }
         // ENTER FIRST APPLICATION DATA BELOW
         
       %>
         <%@include file="./view_application_diff.jsp" %>

       <%
         if (isDif) {
        	 
        	 viewApp = _application;
       %>
         </div>
         <div class="span6 alert alert-success">
         
         <%@include file="./view_application_diff.jsp" %>
         
          
       <%
        // ENTER SECOND APPLICATION DATA ABOVE
         }
       %>
        </div>
       </div>

<%
		} // END OF FIELD LOOP
		
		if (isRequest) {
%>

<div class="row-fluid">
       <portlet:actionURL name="applicationRedirectWId"  var="rejectURL">
            <portlet:param name="applicationId" value="<%= applicationIdString %>" />
    		<portlet:param name="exceptionForward" value="<%=errorJSP%>" />
            <portlet:param name="successForward" value="<%=rejectApplicationJSP%>" />
		</portlet:actionURL>
		<portlet:actionURL name="applicationActionVerify" var="verifyURL">
				<portlet:param name="applicationId" value="<%= applicationIdString %>" />
		</portlet:actionURL>
		<aui:form
		    name="fm"
		    action="<%= verifyURL.toString() %>"
		    method="post">
		
		  <aui:fieldset>
		
		    <aui:input
		        name="applicationId"
		        value="<%= applicationId %>"
		        type="hidden"
		    />
		
		      <div class="span1 offset4" >
		        <a class="btn btn-danger" type="button" onClick="location.href = '<%= rejectURL.toString() %>';" ><liferay-ui:message key="weitere Informationen anfordern" /></a>
		      </div>
		      <div class="span1 offset2" >
		        <button class="btn btn-success" type="submit" value="verify">Freigeben</button>
		      </div>
		      <!-- 
		      <aui:button
		          type="cancel"
		          value="cancel"
		          onClick="< % = cancelURL.toString() %>"
		    />
		    <button onClick="location.href = '< % =cancelURL.toString() % >'" class="btn-mini">&lt;&lt;zur�ck zur �bersicht</button>
             -->
		
		  </aui:fieldset>
		
		</aui:form>   
</div>
<% } %>

        <portlet:actionURL name="applicationRedirectWId" var="editURL">
	        <portlet:param name="applicationId" value="<%= applicationIdString %>" />
            <portlet:param name="successForward" value="<%= editApplicationJSP %>" />
            <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
	    </portlet:actionURL>
		
		<portlet:actionURL name="applicationActionDelete" var="deleteURL">
			<portlet:param name="applicationId" value="<%= applicationIdString %>" />
		</portlet:actionURL>

		<aui:form
		    name="fm"
		    action="<%= deleteURL.toString() %>"
		    method="post">
		
		  <aui:fieldset>
		
		    <aui:input
		        name="applicationId"
		        value="<%= applicationId %>"
		        type="hidden"
		    />
		
		    <aui:button-row>
		      <button class="btn" type="submit" value="delete">Anwendung l&ouml;schen</button>
		      <a class="btn" onClick="location.href = '<%= editURL.toString() %>';"><liferay-ui:message key="Anwendung_bearbeiten" /></a>		
		    </aui:button-row>
		
		  </aui:fieldset>
		
		</aui:form>

	    <portlet:actionURL name="addApplicationDisplay" var="addURL">
            <portlet:param name="successForward" value="<%= addApplicationJSP %>" />
            <portlet:param name="errorForward" value="<%= errorJSP %>" />
	    </portlet:actionURL>
	    
	    <a class="btn btn-mini" type="button" onClick="location.href = '<%= cancelURL.toString() %>';" ><liferay-ui:message key="&lt;&lt;zur�ck zur �bersicht" /></a>
		<a class="btn btn-mini" type="button" onClick="location.href = '<%= addURL.toString() %>';"><liferay-ui:message key="add_application" /></a>


		

<%
} catch (Exception e) {
	_log.debug(e.getMessage());	
	e.printStackTrace();
}
%>

