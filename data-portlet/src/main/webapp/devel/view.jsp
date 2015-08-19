<%--
  #%L
  govapps_data
  $Id: view.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@ include file="../include.jsp" %>



<noscript>
    <h1>
        <font color="#ff0000"> Diese Seite ben&ouml;tigt JavaScript. Bitte
            &auml;ndern Sie Ihre Browsereinstellungen. </font>
    </h1>
</noscript>

<liferay-ui:success key="application-added-successfully"
    message="application-added-successfully" />
   
<liferay-ui:success key="application-updated-successfully"
    message="application-updated-successfully" />

<liferay-ui:success key="application-deleted-successfully"
    message="application-deleted-successfully" />


<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.view_jsp");

/*
String url = PortalUtil.getCurrentURL(request);
String[] _url = url.split("/");
String _currentURL = "/" + _url[_url.length-1];

if (_currentURL.contains("?")) {
	_currentURL = _currentURL.substring(0, _currentURL.indexOf('?'));
}
_log.debug("_currentURL: " + _currentURL);

PortletPreferences prefs = renderRequest.getPreferences();
prefs.setValue(currentURL, _currentURL);
prefs.store();
*/
String portletId= portletDisplay.getId();
//_log.debug("portletId: " + portletId);

String header1  = "This is the Application Developer portlet.";
String error2 =  "an error occured";
error2 =  "you are not authorized to view this content, because you do not authenticated";
String header2_application  = "Applications";

if ("de_DE".equalsIgnoreCase(locale.toString().trim())) {
	header1 = "Dies ist das Portlet des Anwendungsentwicklers";
	error2 =  "Es ist ein Fehler aufgetreten";
	error2 =  "Sie sind nicht berechtigt die Aktion auszuführen, weil Sie nicht authentifiziert sind";
	header2_application = "Anwendungen";
}

String redirect = ParamUtil.getString(request, "redirect");
String keywords = ParamUtil.getString(request, "keywords");

try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
%>
		<div id="application">	
		<h2><%= header2_application %></h2>
<%
		List<Application> applicationsPerUser = ApplicationLocalServiceUtil.getDeveloperApplications(companyId, userId);
%>
		<liferay-ui:search-container 
			curParam="storeCur" 
			emptyResultsMessage="there-are-no-applications" 
			delta="30"
			deltaParam="myDeltaParam"
			var="myVar"
			>
			
		  <liferay-ui:search-container-results>
<%
		  results = ListUtil.subList(applicationsPerUser, myVar.getStart(), myVar.getEnd());
		  total = applicationsPerUser.size();
		
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>
		  </liferay-ui:search-container-results>
		
			<% boolean color = false; %>
		
		  <liferay-ui:search-container-row
		      className="de.fraunhofer.fokus.movepla.model.Application"
		      keyProperty="applicationId"
		      modelVar="_application"
		      rowVar="_applicationRow"
		      >
		      
		      <% 
		      if (color=!color)
		      	_applicationRow.setClassName("app-search-row-even");
		      else
		   		_applicationRow.setClassName("app-search-row-odd");
		      %>
		
			<portlet:actionURL name="applicationRedirectWId" var="readURL">
				<portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId()) %>" />
                <portlet:param name="successForward" value="/devel/view_application.jsp" />
                <portlet:param name="exceptionForward" value="/devel/error.jsp" />
			</portlet:actionURL>
		
      		<liferay-ui:search-container-column-jsp
	          path="/devel/application_icon.jsp"
	          align="left"
	          name="logo"
	        />		
		
		    <liferay-ui:search-container-column-text
		        name="name"
		        property="name" 
		        orderable="false" 
		        orderableProperty="name" 
		        href="<%=readURL.toString()%>"
		        align="left"
		        
		    />
		         
		    <liferay-ui:search-container-column-text
		        name="Plattform"
		        property="targetOS" 
		        align="left"
		    />
		        
         <liferay-ui:search-container-column-jsp
                   path="/devel/applicationLifeCycleStatusString.jsp"
                   align="right"
                   name="Status"
            />

         <liferay-ui:search-container-column-jsp
                   path="/devel/application_relatedApplications.jsp"
                   align="right"
                   name="relatedApplications"
            />

      		<liferay-ui:search-container-column-jsp
	               path="/devel/application_actions.jsp"
	               align="right"
	        />
		        
		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
		
		</liferay-ui:search-container>
		
	    <portlet:actionURL name="addApplicationPreamble" var="addURL" />
	    
	        <portlet:actionURL name="exportAction" var="exportURL">
        <portlet:param name="successForward" value="/content/view.jsp" />
        <portlet:param name="exceptionForward" value="/content/error.jsp" />        
    </portlet:actionURL>

		<a class="btn" onClick="location.href = '<%= addURL.toString() %>';"><liferay-ui:message key="add_application" /></a>
		
		<a class="btn" onClick="location.href = '<%= exportURL.toString() %>';"><liferay-ui:message key="export" /></a>
	
		</div>  <!--  END div application -->
<%		
	} catch (Exception e) {
		_log.debug("Exception: " + e.getMessage());
%>
			<h1><%= error2 %></h1>
<%
	}
%>
