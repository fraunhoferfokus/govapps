<%--
  #%L
  govapps_data
  $Id: stats_allLogs.jsp 566 2014-11-13 15:22:01Z sma $
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

List<Logging> allLoggings = LoggingLocalServiceUtil.getAllLoggings();
if (allLoggings  == null) {
	allLoggings = new ArrayList<Logging>();
}

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/content/stats_allLogs.jsp");

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
    </small>
    <h1>alle Logeintr�ge</h1> 
        <a onClick="location.href = '<%=mostviewedApps.toString()%>'" class="btn btn-mini" >meistgesehene Anwendungen</a>
        <a onClick="location.href = '<%=mostClickedLinks.toString()%>'" class="btn btn-mini" >gedr�ckte Anwendungsverkn�pfungen</a>
        <a onClick="location.href = '<%=allLogs.toString()%>'" class="btn btn-mini" disabled="disabled">alle Logeintr�ge</a>
        <a onClick="location.href = '<%=mostUsedKeywords.toString()%>'" class="btn btn-mini">meistgesuchte Ausdr�cke</a>
        <a onClick="location.href = '<%=mostAggUsedKeywords.toString()%>'" class="btn btn-mini">meistbenutze Suchausdr�cke (aggregiert)</a>
        <a onClick="location.href = '<%=mostUsedCategories.toString()%>'" class="btn btn-mini">meistgesuchte Themen</a>
        <a onClick="location.href = '<%=mostUsedRegions.toString()%>'" class="btn btn-mini">meistgesuchte Regionen</a>
        <a onClick="location.href = '<%=mostUsedEntitlements.toString()%>'" class="btn btn-mini">meistabgew�hlte Berechtigungen</a>
        <a onClick="location.href = '<%=mostUsedPlatforms.toString()%>'" class="btn btn-mini">meistgesuchte Plattformen</a>
        <a onClick="location.href = '<%=mostUsedTargetCategories.toString()%>'" class="btn btn-mini">meistgesuchte Ger�tekategorien</a>
    
</div>


<h2>alle Logeintr�ge: jeder Unterschied eines Parameters f�hrt zu einem neuen Eintrag, ansonsten wird der Z�hler hochgez�hlt </h2>

<liferay-ui:search-container 
    curParam="storeAllLoggings" 
    emptyResultsMessage="there-are-no-log-entries" 
    delta="75"
    deltaParam="myDeltaAllLoggings"
    iteratorURL="<%= portletURL %>" 
>
    
    <liferay-ui:search-container-results>
<%
        results = ListUtil.subList(allLoggings, searchContainer.getStart(), searchContainer.getEnd());
        total = allLoggings.size();
        
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
            name="loggingId"
            property="loggingId"
        />

        <liferay-ui:search-container-column-text
            name="searchString"
            property="searchString"
        />

        <liferay-ui:search-container-column-text
            name="passel"
            property="passel"
        />

        <liferay-ui:search-container-column-text
            name="isSimpleSearch"
            property="isSimpleSearch"
        />

        <liferay-ui:search-container-column-jsp
            path="/content/stats_categories.jsp"
            align="left"
            name="Themen"
        />

        <liferay-ui:search-container-column-jsp
            path="/content/stats_regions.jsp"
            align="left"
            name="Regionen"
        />
        
        <liferay-ui:search-container-column-jsp
            path="/content/stats_entitlements.jsp"
            align="left"
            name="erlaubte Berechtigungen"
        />

        <liferay-ui:search-container-column-jsp
            path="/content/stats_platforms.jsp"
            align="left"
            name="Plattform"
        />

        <liferay-ui:search-container-column-jsp
            path="/content/stats_fee.jsp"
            align="left"
            name="Kosten"
        />

        <liferay-ui:search-container-column-text
            name="targetCategory"
            property="targetCategory"
        />
        
        <liferay-ui:search-container-column-text
            name="createDate"
            property="createDate" 
        />

        <liferay-ui:search-container-column-text
            name="modifiedDate"
            property="modifiedDate"
        />
                
      </liferay-ui:search-container-row>
      <liferay-ui:search-iterator />
        
</liferay-ui:search-container>
