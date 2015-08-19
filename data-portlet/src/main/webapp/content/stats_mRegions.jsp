<%--
  #%L
  govapps_data
  $Id: stats_mRegions.jsp 566 2014-11-13 15:22:01Z sma $
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

<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.content.stats_jsp");

List<Logging> logsByRegions        = LoggingLocalServiceUtil.getLoggingsByRegions();
if (logsByRegions  == null) {
    logsByRegions = new ArrayList<Logging>();
}

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/content/stats_mRegions.jsp");

%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/content/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="iconslURL">
  <portlet:param name="jspPage" value="/content/stats_icons.jsp" />
</portlet:renderURL>

<portlet:actionURL name="redirectAction" var="mostviewedApps">
<portlet:param name="successForward" value="/content/stats.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostClickedLinks">
<portlet:param name="successForward" value="/content/stats_cLinks.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="allLogs">
<portlet:param name="successForward" value="/content/stats_allLogs.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedKeywords">
<portlet:param name="successForward" value="/content/stats_mkeywords.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostAggUsedKeywords">
<portlet:param name="successForward" value="/content/stats_agMkeywords.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedCategories">
<portlet:param name="successForward" value="/content/stats_mCategories.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedRegions">
<portlet:param name="successForward" value="/content/stats_mRegions.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedEntitlements">
<portlet:param name="successForward" value="/content/stats_mEntitlements.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedPlatforms">
<portlet:param name="successForward" value="/content/stats_mPlatforms.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="redirectAction" var="mostUsedTargetCategories">
<portlet:param name="successForward" value="/content/stats_mTargetCategories.jsp" />
<portlet:param name="exceptionForward" value="/content/error.jsp" />        
</portlet:actionURL>

<div class="page-header">
    <small>
        <a onClick="location.href = '<%=cancelURL.toString()%>'" class="btn btn-mini">&lt;&lt;zur&uuml;ck zur &Uuml;bersicht</a>
        <a onClick="location.href = '<%=iconslURL.toString()%>'" class="btn btn-mini">Bedeutung der Icons</a>
    </small>
    <h1>meistgesuchte Regionen</h1>
        <a onClick="location.href = '<%=mostviewedApps.toString()%>'" class="btn btn-mini">meistgesehene Anwendungen</a>
        <a onClick="location.href = '<%=mostClickedLinks.toString()%>'" class="btn btn-mini" >gedr�ckte Anwendungsverkn�pfungen</a>
        <a onClick="location.href = '<%=allLogs.toString()%>'" class="btn btn-mini">alle Logeintr�ge</a>
        <a onClick="location.href = '<%=mostUsedKeywords.toString()%>'" class="btn btn-mini">meistgesuchte Ausdr�cke</a>
        <a onClick="location.href = '<%=mostAggUsedKeywords.toString()%>'" class="btn btn-mini">meistbenutze Suchausdr�cke (aggregiert)</a>
        <a onClick="location.href = '<%=mostUsedCategories.toString()%>'" class="btn btn-mini">meistgesuchte Themen</a>
        <a onClick="location.href = '<%=mostUsedRegions.toString()%>'" class="btn btn-mini" disabled="disabled">meistgesuchte Regionen</a>
        <a onClick="location.href = '<%=mostUsedEntitlements.toString()%>'" class="btn btn-mini">meistabgew�hlte Berechtigungen</a>
        <a onClick="location.href = '<%=mostUsedPlatforms.toString()%>'" class="btn btn-mini">meistgesuchte Plattformen</a>
        <a onClick="location.href = '<%=mostUsedTargetCategories.toString()%>'" class="btn btn-mini">meistgesuchte Ger�tekategorien</a>
    
</div>

<h2>meistgesuchte Regionen</h2>


<liferay-ui:search-container 
    curParam="storelogsByRegions" 
    emptyResultsMessage="there-are-no-log-entries" 
    delta="75"
    deltaParam="myDeltalogsByRegions"
    iteratorURL="<%= portletURL %>" 
>
    
    <liferay-ui:search-container-results>
<%
        results = ListUtil.subList(logsByRegions, searchContainer.getStart(), searchContainer.getEnd());
        total = logsByRegions.size();
        
        pageContext.setAttribute("results", results);
        pageContext.setAttribute("total", total);
 %>
    </liferay-ui:search-container-results>
        
    <liferay-ui:search-container-row
        className="de.fraunhofer.fokus.movepla.model.Logging"
        keyProperty="loggingId"
        modelVar="_logging"
        rowVar="_loggingRow">

        <liferay-ui:search-container-column-text
            name="regionIDString"
            property="regionIDString"
        />

        <liferay-ui:search-container-column-text
            name="passel"
            property="passel"
        />

      </liferay-ui:search-container-row>
      <liferay-ui:search-iterator />
        
</liferay-ui:search-container>
