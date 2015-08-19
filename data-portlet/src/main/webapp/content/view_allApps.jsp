<%--
  #%L
  govapps_data
  $Id: view_allApps.jsp 566 2014-11-13 15:22:01Z sma $
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

<portlet:actionURL name="redirectAction" var="addURL">
    <portlet:param name="successForward" value="/content/add_application.jsp" />
    <portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>


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
    portletURL.setParameter("jspPage", "/content/view_allApps.jsp");

    if ( UserLocalServiceUtil.hasRoleUser(roleAdminId, userId)) {	    	
%>
        <a onClick="location.href = '<%=adminURL.toString()%>'" class="btn-mini">Admin</a>
        <a onClick="location.href = '<%=statsURL.toString()%>'" class="btn-mini">Stats</a>
<%
	}


    List<Application> applications = ApplicationLocalServiceUtil.getApplications(companyId);
    List<Application> tmpApplications = new ArrayList<Application>();
    tmpApplications.addAll(applications);

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);
		
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");


	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
	    portalPrefs.setValue("de.fraunhofer", "order-by-col", orderByCol);
	    portalPrefs.setValue("de.fraunhofer", "order-by-type", orderByType);

	} else {
		  orderByCol = portalPrefs.getValue("de.fraunhofer", "order-by-col", "modifiedDate");
		  orderByType = portalPrefs.getValue("de.fraunhofer", "order-by-type", "desc");
	}
				
	OrderByComparator orderByComparator = CustomComparatorUtil.getApplicationOrderByComparator(orderByCol, orderByType);        
    _log.debug("orderByComparator.getOrderBy():  "+ orderByComparator.getOrderBy());

    Collections.sort(tmpApplications, orderByComparator);
    _log.debug("tmpApplications.size():  "+ tmpApplications.size());

%>
    <liferay-portlet:renderURL varImpl="searchURL">
      <portlet:param name="jspPage" value="/content/search.jsp" />
    </liferay-portlet:renderURL>

    <aui:form action="<%= searchURL %>" method="get" name="fm">
      <liferay-portlet:renderURLParams varImpl="searchURL" />
      <liferay-ui:header
          title="Anwendungen Suchen"
      />
      <span class="aui-search-bar">
        <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
        <aui:button type="submit" value="search" />
      </span>
    </aui:form>
    <hr />

<div class="page-header">
    <h1>alle Anwendungen</h1>
        <a onClick="location.href = '<%=view_appsForVer.toString()%>'" class="btn btn-mini">Anwendungen die �berpr�ft werden m�ssen</a>
        <a onClick="location.href = '<%=view_allApps.toString()%>'" class="btn btn-mini" disabled="disabled">alle Anwendungen</a>
        <a onClick="location.href = '<%=view_categories.toString()%>'" class="btn btn-mini">Kategorien</a>
        <a onClick="location.href = '<%=view_regions.toString()%>'" class="btn btn-mini">Regionen</a>
        <a onClick="location.href = '<%=view_entitlements.toString()%>'" class="btn btn-mini">Berechtigungen</a>
        <a onClick="location.href = '<%=view_languages.toString()%>'" class="btn btn-mini">Sprachen</a>    
</div>
        
	<liferay-ui:search-container 
		curParam="storeCur" 
		emptyResultsMessage="there-are-no-applications" 
        orderByCol="<%= orderByCol %>"
        orderByType="<%= orderByType %>"
		delta="75"
		deltaParam="myDeltaParam"
		var="myVar"
		iteratorURL="<%=portletURL%>"
		>
	  <liferay-ui:search-container-results>
<%
	  results = ListUtil.subList(tmpApplications, myVar.getStart(), myVar.getEnd());
	  total = tmpApplications.size();
	
	  pageContext.setAttribute("results", results);
	  pageContext.setAttribute("total", total);
%>
	  </liferay-ui:search-container-results>
	
	  <liferay-ui:search-container-row
	      className="de.fraunhofer.fokus.movepla.model.Application"
	      keyProperty="applicationId"
	      modelVar="_application"
	      rowVar="_applicationRow"
 	      >
			
        <portlet:actionURL name="applicationRedirectWId" var="readURL">
            <portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId()) %>" />
            <portlet:param name="successForward" value="<%= ViewApplicationDetailsJSP %>" />
            <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
        </portlet:actionURL>

     		<liferay-ui:search-container-column-jsp
          path="/content/application_icon.jsp"
          align="left"
        />
	
	    <liferay-ui:search-container-column-text
	        name="ID"
	        property="applicationId"
               orderable="<%= true %>"
               orderableProperty="applicationId" 
	        />

           <liferay-ui:search-container-column-text
               name="name"
               property="name" 
               orderable="<%= true %>"
               orderableProperty="name" 
               href="<%=readURL.toString()%>" />

           <liferay-ui:search-container-column-text
               name="Plattform"
               property="targetOS" 
               align="left"
           />


           <liferay-ui:search-container-column-jsp
             path="/content/application_developer.jsp"
             align="left"
             name="developer"
           />
	
           <liferay-ui:search-container-column-text
               name="modifiedDate"
               property="modifiedDate"
               orderable="<%= true %>"
               orderableProperty="modifiedDate" 
            />

           <liferay-ui:search-container-column-jsp
                  path="/content/applicationLifeCycleStatusString.jsp"
                  align="right"
                  name="Status"
           />
	        
           <liferay-ui:search-container-column-jsp
                  path="/content/application_relatedApplications.jsp"
                  align="right"
                  name="relatedApplications"
           />

     		<liferay-ui:search-container-column-jsp
          path="/content/application_actions.jsp"
          align="right" />
	        
	  </liferay-ui:search-container-row>
	  <liferay-ui:search-iterator />
	
	</liferay-ui:search-container>
		    
    <aui:form
           name="fm"
           action="<%= addURL.toString() %>"
           method="post">
       
         <aui:input type="hidden" name="errorForward" value="/content/view.jsp" />
         <aui:input type="hidden" name="successForward" value="/content/add_application.jsp" />

           <aui:button-row>
             <aui:button type="submit" value="add_application"/>
       
           </aui:button-row>
               
    </aui:form>
<%		
	} catch (Exception e) {
		_log.debug("Exception: " + e.getMessage());
%>
			<h1>an error occured</h1>
<%
	}
%>
