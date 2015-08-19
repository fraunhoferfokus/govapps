<%--
  #%L
  govapps_data
  $Id: search.jsp 566 2014-11-13 15:22:01Z sma $
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
String keywords = ParamUtil.getString(request, "keywords");
%>

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

<liferay-portlet:renderURL varImpl="searchURL">
  <portlet:param name="jspPage" value="/content/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
  <liferay-portlet:renderURLParams varImpl="searchURL" />
  <liferay-ui:header
      title="search"
/>

<div class="page-header">
    <h1>Suchergebnisse</h1>
        <a onClick="location.href = '<%=view_appsForVer.toString()%>'" class="btn btn-mini">Anwendungen die �berpr�ft werden m�ssen</a>
        <a onClick="location.href = '<%=view_allApps.toString()%>'" class="btn btn-mini">alle Anwendungen</a>
        <a onClick="location.href = '<%=view_categories.toString()%>'" class="btn btn-mini">Kategorien</a>
        <a onClick="location.href = '<%=view_regions.toString()%>'" class="btn btn-mini">Regionen</a>
        <a onClick="location.href = '<%=view_entitlements.toString()%>'" class="btn btn-mini">Berechtigungen</a>
        <a onClick="location.href = '<%=view_languages.toString()%>'" class="btn btn-mini">Sprachen</a>
</div>

<%
  

  themeDisplay= (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
  portletDisplay= themeDisplay.getPortletDisplay();
  String portletId= portletDisplay.getId();

  PortletURL portletURL = renderResponse.createRenderURL();

  portletURL.setParameter("jspPage", "/content/search.jsp");
  portletURL.setParameter("keywords", keywords);


  List<String> headerNames = new ArrayList<String>();

//  headerNames.add("Icon");
  headerNames.add("#");
  headerNames.add("id");
  headerNames.add("Name");
  headerNames.add("Plattform");
//  headerNames.add("developer");
  headerNames.add("modifiedDate");
//  headerNames.add("Status");
//  headerNames.add("relatedApplications");
//  headerNames.add("application_actions");

  
  
//  headerNames.add("lifeCycleStatus");

  SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

  try {
      Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);

      SearchContext searchContext = new SearchContext();
      searchContext.setEnd(searchContainer.getEnd());
      searchContext.setKeywords(keywords);
      searchContext.setStart(searchContainer.getStart());
      QueryConfig queryConfig = new QueryConfig();
      queryConfig.setHighlightEnabled(false);
      queryConfig.setScoreEnabled(false);
      searchContext.setQueryConfig(queryConfig);
        
      searchContext.setCompanyId(companyId);

      Hits results = indexer.search(searchContext);

//      _log.debug("hits: " + results.getLength());
      int total = results.getLength();

      searchContainer.setTotal(total);

      List<ResultRow> resultRows = new ArrayList<ResultRow>();
      resultRows = searchContainer.getResultRows();

      for (int i=0; i<results.getDocs().length; i++) {
          Document doc = results.doc(i);

          ResultRow row = new ResultRow(doc, i, i);
          // Position
          row.addText(searchContainer.getStart() + i + 1 + StringPool.PERIOD);

          // Application

          long applicationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

          Application _application = null;

          try {
        	  _application = ApplicationLocalServiceUtil.getApplication(applicationId);

//         	if (_application.getLifeCycleStatus() > 4) {
//          	  _application = _application.toEscapedModel();
//        	}
          }
          catch (Exception e) {
              continue;
          }

          PortletURL rowURL = renderResponse.createRenderURL();
          rowURL.setParameter("jspPage", "/content/view_application.jsp");
          rowURL.setParameter("redirect", currentURL);          
          rowURL.setParameter("applicationId", String.valueOf(_application.getApplicationId()));
//          _log.debug("_application.getApplicationId(): " + _application.getApplicationId());

          row.addText(String.valueOf(_application.getApplicationId()));
          row.addText(_application.getName(), rowURL);
          row.addText(_application.getTargetOS());
          row.addText(_application.getModifiedDate().toString());

          // Add result row
          resultRows.add(row);
      }
%>

  <span class="aui-search-bar">
    <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" value="<%= keywords %>" />
    <aui:button type="submit" value="search" />
  </span>

  <br /><br />

  <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

  <%
  }
  catch (Exception e) {
	  
      _log.debug("Exception");
      _log.error(e.getMessage());
  }
  %>
</aui:form>

<%
if (Validator.isNotNull(keywords)) {
    PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("docroot.devel.search_jsp");
%>
