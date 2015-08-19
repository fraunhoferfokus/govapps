<%--
  #%L
  govapps_data
  $Id: view_regions.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="./urls.jsp" %>


<liferay-ui:success key="application-added-successfully"
    message="application-added-successfully" />
   
<liferay-ui:success key="application-updated-successfully"
    message="application-updated-successfully" />

<liferay-ui:success key="application-deleted-successfully"
    message="application-deleted-successfully" />

<liferay-ui:success key="application-rejected-successfully"
    message="application-rejected-successfully" />


<portlet:renderURL var="adminURL">
  <portlet:param name="jspPage" value="/content/admin.jsp" />
</portlet:renderURL>

<portlet:renderURL var="statsURL">
  <portlet:param name="jspPage" value="/content/stats.jsp" />
</portlet:renderURL>

<portlet:actionURL name="redirectAction" var="view_appsForVer">
    <portlet:param name="successForward" value="/content/view.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="view_allApps">
    <portlet:param name="successForward" value="/content/view_allApps.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="view_categories">
    <portlet:param name="successForward" value="/content/view_categories.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="view_regions">
    <portlet:param name="successForward" value="/content/view_regions.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="view_entitlements">
    <portlet:param name="successForward" value="/content/view_entitlements.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="view_languages">
    <portlet:param name="successForward" value="/content/view_languages.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>


<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.content.view_jsp");

String portletId= portletDisplay.getId();

try {
	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);

	long roleAdminId = RoleLocalServiceUtil.getRole(user.getCompanyId(), "Administrator").getRoleId();

    PortletURL portletURL = renderResponse.createRenderURL();
    portletURL.setParameter("jspPage", "/content/view_regions.jsp");

	if ( UserLocalServiceUtil.hasRoleUser(roleAdminId, userId)) {	    	
%>
        <a onClick="location.href = '<%=adminURL.toString()%>'" class="btn-mini">Admin</a>
        <a onClick="location.href = '<%=statsURL.toString()%>'" class="btn-mini">Stats</a>
<%
	}

	long catId = -1;
    if (request.getAttribute("categoryId") != null) {
          catId = (Long) request.getAttribute("categoryId");
    }       
    
    long regId = -1;
    if (request.getAttribute("regionId") != null) {
        regId = (Long) request.getAttribute("regionId");
    }

%>

<div class="page-header">
    <h1>Regionen</h1>
        <a onClick="location.href = '<%=view_appsForVer.toString()%>'" class="btn btn-mini">Anwendungen die �berpr�ft werden m�ssen</a>
        <a onClick="location.href = '<%=view_allApps.toString()%>'" class="btn btn-mini">alle Anwendungen</a>
        <a onClick="location.href = '<%=view_categories.toString()%>'" class="btn btn-mini">Kategorien</a>
        <a onClick="location.href = '<%=view_regions.toString()%>'" class="btn btn-mini" disabled="disabled">Regionen</a>
        <a onClick="location.href = '<%=view_entitlements.toString()%>'" class="btn btn-mini">Berechtigungen</a>
        <a onClick="location.href = '<%=view_languages.toString()%>'" class="btn btn-mini">Sprachen</a>
</div>

        <portlet:actionURL name="readViewDisplay" var="readRegHomeURL">
            <portlet:param name="regionId" value="-1" />
            <portlet:param name="categoryId" value="<%=String.valueOf(catId) %>" />
            <portlet:param name="successForward" value="/content/view_regions.jsp" />
            <portlet:param name="errorForward" value="/content/error.jsp" />                
        </portlet:actionURL>

<%
	List<Region> childRegions = RegionLocalServiceUtil.getChildRegions(companyId, regId);
		
	if (regId != -1 && childRegions.size() == 0 ) {
%>

        <h3>keine Regionen vorhanden</h3>
        <button onClick="location.href = '<%=readRegHomeURL.toString()%>'" class="btn-mini">&lt;&lt;alle obersten Regionen</button>
<%
	} else {
%>
        <button onClick="location.href = '<%=readRegHomeURL.toString()%>'" class="btn-mini">&lt;&lt;alle obersten Regionen</button>
    
        <h3>gegebene Unterregionen werden durch den jeweiligen Link ersichtlich</h3>
		
		<liferay-ui:search-container emptyResultsMessage="there-are-no-regions" delta="20"  iteratorURL="<%=portletURL%>" >
		
		  <liferay-ui:search-container-results>
<%
		  results = ListUtil.subList(childRegions, searchContainer.getStart(), searchContainer.getEnd());;
		  total = childRegions.size();
		
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>
		  </liferay-ui:search-container-results>
		
		  <liferay-ui:search-container-row
		      className="de.fraunhofer.fokus.movepla.model.Region"
		      keyProperty="regionId"
		      modelVar="_region">
		
		    <liferay-ui:search-container-column-text
		        name="regionId"
		        property="regionId"
		        orderable="true" />

			<portlet:actionURL name="readViewDisplay" var="readURL">
				<portlet:param name="regionId" value="<%=String.valueOf(_region.getRegionId()) %>" />
				<portlet:param name="categoryId" value="<%=String.valueOf(catId) %>" />
                <portlet:param name="successForward" value="/content/view_regions.jsp" />
                <portlet:param name="errorForward" value="/content/error.jsp" />                
			</portlet:actionURL>
		
		    <liferay-ui:search-container-column-text
		        name="regionName"
		        property="name" 
		        orderable="true" 
		        orderableProperty="name" 
		        href="<%=readURL.toString()%>"/>
		    <liferay-ui:search-container-column-text
		        name="parentRegion"
		        property="parentRegion"
		        orderable="true" />
		        
      		<liferay-ui:search-container-column-jsp
	          path="/content/region_actions.jsp"
	          align="right" />
		        
		  </liferay-ui:search-container-row>
		  <liferay-ui:search-iterator />
		
		</liferay-ui:search-container>
<%
        }
%>          
		
	    <portlet:actionURL name="regionDisplayAddSubRegion" var="addURL">
	      <portlet:param name="parentRegionId" value="<%= String.valueOf(regId) %>" />
	    </portlet:actionURL>

		<input type="button" value="<liferay-ui:message key="add_region" />" onClick="location.href = '<%= addURL.toString() %>';" />

<%		
	} catch (Exception e) {
		_log.debug("Exception: " + e.getMessage());
%>
			<h1>an error occured</h1>
<%
	}
%>
