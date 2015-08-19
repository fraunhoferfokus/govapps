<%--
  #%L
  govapps_data
  $Id: add_region.jsp 566 2014-11-13 15:22:01Z sma $
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
Log _log = LogFactoryUtil.getLog("docroot.content.add_region_jsp");

//String regionName = "";
long parentRegionId = -1;

try {
	parentRegionId = (Long) request.getAttribute("parentRegionId");
	
//	_log.debug("request.getContextPath(): " + request.getContextPath());
//	_log.debug("request.getAttribute(parentRegionId): " + request.getAttribute("parentRegionId"));

//	_log.debug("request.getAttribute(region): " + request.getAttribute("region"));
//	if (parentRegionId == 0) {
//		Region region =  (Region) request.getAttribute("region");
//		parentRegionId = region.getParentRegion();
//		regionName = region.getName();
//	}
	
} catch (Exception e) {
	e.printStackTrace();
}

//_log.debug("regionName: " + regionName);
_log.debug("parentRegionId: " + parentRegionId);
%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/content/view_regions.jsp" />
</portlet:renderURL>

<portlet:actionURL name="regionActionAdd" var="addURL" />

<h2>Add a Region</h2>

<liferay-ui:error
     key="error-saving-region"
     message="error-saving-region" />

<liferay-ui:error
     key="missing-required-region-name"
     message="missing-required-region-name" />

<aui:form
    name="fm"
    action="<%= addURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="parentRegionId"
        value="<%= parentRegionId %>"
        type="hidden"
    />
    <aui:input
        name="regionName"
        value=""
        size="45"
    />

    <aui:button-row>
      <aui:button type="submit"/>
      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%= cancelURL.toString() %>"
    />

    </aui:button-row>

  </aui:fieldset>

</aui:form>
