<%--
  #%L
  govapps_data
  $Id: multimedia_actions.jsp 566 2014-11-13 15:22:01Z sma $
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

<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.image_actions_jsp");

ResultRow multiMediaRow = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MultiMedia myMultimedia = (MultiMedia) multiMediaRow.getObject();
String name = MultiMedia.class.getName();
String multiMediaId = String.valueOf(myMultimedia.getMultiMediaId());
String applicationId =  String.valueOf(myMultimedia.getApplicationId());
String backURL = (String) request.getAttribute("backURL");
//_log.debug("backURL: " + backURL);
String successForward = (String) request.getAttribute("successForward");
//_log.debug("successForward: " + successForward);
_log.debug("multiMediaId: " + multiMediaId);
_log.debug("applicationId: " + applicationId);
%>

<%
try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
%>

    <portlet:actionURL name="applicationActionDeleteImage" var="deleteURL">
      <portlet:param name="multiMediaId" value="<%= multiMediaId %>" />
      <portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
      <portlet:param name="successForward" value="<%= successForward %>" />
      <portlet:param name="exceptionForward" value="/devel/error.jsp" />
    </portlet:actionURL>
    
    <a class="btn btn-small tdpad" onClick="location.href = '<%= deleteURL.toString() %>';"><i class="icon-trash"></i>L&ouml;schen</a>

<%		
} catch (Exception e) {
	e.printStackTrace();	
}
%>
