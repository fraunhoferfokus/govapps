<%--
  #%L
  govapps_data
  $Id: application_relatedApplications.jsp 566 2014-11-13 15:22:01Z sma $
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

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Enumeration<String> attributeNames = request.getAttributeNames();
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.application_relatedApps_jsp");

Application myApplication = (Application) row.getObject();
String name = Application.class.getName();
String applicationId = String.valueOf(myApplication.getApplicationId());


try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
	long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.CONTENT_PROVIDER).getRoleId();		
		String relIDs = "";
	    relIDs =  myApplication.getRelatedApplicationId();
	    _log.debug("relIDs: " + relIDs);
	    if (relIDs.length() > 0 ) {
	    	String[] relIDsArray = relIDs.split(";");
	        _log.debug("relIDsArray: " + relIDsArray.length);
	        
	        for (int i=0; i<relIDsArray.length; i++) {
	        	Application _app = ApplicationLocalServiceUtil.fetchApplication(Long.parseLong(relIDsArray[i]));
	        	
%>
		        <portlet:actionURL name="applicationRedirectWId" var="viewDetails">
		            <portlet:param name="applicationId" value="<%= String.valueOf(_app.getApplicationId()) %>" />
		            <portlet:param name="successForward" value="/content/view_application.jsp" />
		            <portlet:param name="exceptionForward" value="/content/error.jsp" />
		        </portlet:actionURL>
		
		
		        <a tabindex="-1" href="<%= viewDetails.toString() %>"><%= _app.getName() %> (<%= _app.getTargetOS() %>)</a> <br />

	        	
<%	        	
	        }
	    	
	    }
	    
		
%>


<%		
} catch (Exception e) {
	_log.debug("ERROR: " + e.getMessage());
}
%>


