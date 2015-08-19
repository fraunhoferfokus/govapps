<%--
  #%L
  govapps_data
  $Id: admin.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@ include file="./urls.jsp" %>


<liferay-ui:success key="removeWhitespaceFromTargetOSURL-successfully"
    message="removeWhitespaceFromTargetOSURL-successfully" />
   
<liferay-ui:error key="application-removeWhitespaceFromTargetOSURL-error"
    message="application-removeWhitespaceFromTargetOSURL-error" />
   
<liferay-ui:success key="application-updateStatusString-successfully"
    message="application-updateStatusString-successfully" />
   
<liferay-ui:error key="application-updateStatusString-error"
    message="application-updateStatusString-error" />


<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.content.admin_jsp");

List<Application> allApps = ApplicationLocalServiceUtil.getApplications(10154);

List<Application> applicationWithLinkDoubles = new ArrayList<Application>();
List<Application> applicationWithTooManyRelatedApps = new ArrayList<Application>();
List<Application> applicationWithRelatedAppswithDifferentDevelopers = new ArrayList<Application>();


//if (applicationWithLinkDoubles.size() == 0) {
applicationWithLinkDoubles = ApplicationLocalServiceUtil.getLinkDoubles();
//}



for (Application _application: allApps) {
     if (_application.getRelatedApplicationId().split(";").length > 3) {
         _log.debug("_application: " + _application.getApplicationId());
         _log.debug("_application.getRelatedApplicationId().split(;).length: " + _application.getRelatedApplicationId().split(";").length);
    	 applicationWithTooManyRelatedApps.add(_application);
     }


     long currentUserId = _application.getUserId();           
     if (_application.getRelatedApplicationId() != "" && _application.getRelatedApplicationId()!= null ) {
         String[]  relatedApplicationIdsString = _application.getRelatedApplicationId().split(";");
         for (int i=0; i<relatedApplicationIdsString.length; i++) {
             long relUserId = ApplicationLocalServiceUtil.getApplication(Long.parseLong(relatedApplicationIdsString[i])).getUserId();
             if (relUserId != currentUserId) {
                 _log.debug("currentUserId: " + currentUserId + " != " + relUserId);
                 applicationWithRelatedAppswithDifferentDevelopers.add(_application);
                 continue;
             }
         }
     }


}           







%>

<portlet:actionURL name="updateStatusString" var="updateStatusStringURL">
    <portlet:param name="successForward" value="<%= adminJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>


<portlet:actionURL name="removeWhitespaceFromTargetOS" var="removeWhitespaceFromTargetOSURL">
    <portlet:param name="successForward" value="<%= adminJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/content/view.jsp" />
</portlet:renderURL>

<a onClick="location.href = '<%=cancelURL.toString()%>'" >zur�ck</a>
<br />
<br />
<hr />

<a onClick="location.href = '<%=updateStatusStringURL.toString()%>'" >updateStatusString</a>
<br />
<br />
<hr />

<a onClick="location.href = '<%=removeWhitespaceFromTargetOSURL.toString()%>'" >removeWhitespaceFromTargetOS</a>
<br />
<br />
<hr />





<h2>applicationWithLinkDoubles</h2>
        
<liferay-ui:search-container 
    curParam="storeCur" 
    emptyResultsMessage="there-are-no-applications" 
    delta="75"
    deltaParam="myDeltaParam"
    var="myVar">
    <liferay-ui:search-container-results>
<%
        results = ListUtil.subList(applicationWithLinkDoubles, myVar.getStart(), myVar.getEnd());
        total = applicationWithLinkDoubles.size();
        
        pageContext.setAttribute("results", results);
        pageContext.setAttribute("total", total);
 %>
    </liferay-ui:search-container-results>
        
    <liferay-ui:search-container-row
        className="de.fraunhofer.fokus.movepla.model.Application"
        keyProperty="applicationId"
        modelVar="_application"
        rowVar="_applicationRow">
        
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
            name="applicationId"
            property="applicationId"
            orderable="true" />

        <liferay-ui:search-container-column-text
            name="name"
            property="name" 
            href="<%=readURL.toString()%>" />

        <liferay-ui:search-container-column-jsp
          path="/content/application_developer.jsp"
          align="left"
          name="developer"
        />
        
        <liferay-ui:search-container-column-text
            name="lifeCycleStatus"
            property="lifeCycleStatus"
         />
                
        <liferay-ui:search-container-column-jsp
          path="/content/application_actions.jsp"
          align="right" />
                
      </liferay-ui:search-container-row>
      <liferay-ui:search-iterator />
        
</liferay-ui:search-container>




<br />
<br />
<hr />







<h2>applicationWithTooManyRelatedApps</h2>
        
<liferay-ui:search-container 
    curParam="storeCurTooMany" 
    emptyResultsMessage="there-are-no-applications" 
    delta="75"
    deltaParam="myDeltaParamTooMany"
    var="myVarTooMany">
    <liferay-ui:search-container-results>
<%
        results = ListUtil.subList(applicationWithTooManyRelatedApps, myVarTooMany.getStart(), myVarTooMany.getEnd());
        total = applicationWithTooManyRelatedApps.size();
        
        pageContext.setAttribute("results", results);
        pageContext.setAttribute("total", total);
 %>
    </liferay-ui:search-container-results>
        
    <liferay-ui:search-container-row
        className="de.fraunhofer.fokus.movepla.model.Application"
        keyProperty="applicationId"
        modelVar="_application"
        rowVar="_applicationRow">
        
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
            name="applicationId"
            property="applicationId"
            orderable="true" />

        <liferay-ui:search-container-column-text
            name="name"
            property="name" 
            href="<%=readURL.toString()%>" />

        <liferay-ui:search-container-column-jsp
          path="/content/application_developer.jsp"
          align="left"
          name="developer"
        />
        
        <liferay-ui:search-container-column-text
            name="lifeCycleStatus"
            property="lifeCycleStatus"
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



<br />
<br />
<hr />




<h2>applicationWithRelatedAppswithDifferentDevelopers</h2>
        
<liferay-ui:search-container 
    curParam="storeCurDiff" 
    emptyResultsMessage="there-are-no-applications" 
    delta="75"
    deltaParam="myDeltaParamDiff"
    var="myVarTooDiff">
    <liferay-ui:search-container-results>
<%
        results = ListUtil.subList(applicationWithRelatedAppswithDifferentDevelopers, myVarTooDiff.getStart(), myVarTooDiff.getEnd());
        total = applicationWithRelatedAppswithDifferentDevelopers.size();
        
        pageContext.setAttribute("results", results);
        pageContext.setAttribute("total", total);
 %>
    </liferay-ui:search-container-results>
        
    <liferay-ui:search-container-row
        className="de.fraunhofer.fokus.movepla.model.Application"
        keyProperty="applicationId"
        modelVar="_application"
        rowVar="_applicationRow">
        
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
            name="applicationId"
            property="applicationId"
            orderable="true" />

        <liferay-ui:search-container-column-text
            name="name"
            property="name" 
            href="<%=readURL.toString()%>" />

        <liferay-ui:search-container-column-jsp
          path="/content/application_developer.jsp"
          align="left"
          name="developer"
        />
        
        <liferay-ui:search-container-column-text
            name="lifeCycleStatus"
            property="lifeCycleStatus"
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


