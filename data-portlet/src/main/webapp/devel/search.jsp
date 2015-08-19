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
String redirect = ParamUtil.getString(request, "redirect");
String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
  <portlet:param name="jspPage" value="/devel/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
  <liferay-portlet:renderURLParams varImpl="searchURL" />
  <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

  <liferay-ui:header
      backURL="<%= redirect %>"
      title="search"
  />

  <%
  

  themeDisplay= (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
  portletDisplay= themeDisplay.getPortletDisplay();
  String portletId= portletDisplay.getId();

  PortletURL portletURL = renderResponse.createRenderURL();

  portletURL.setParameter("jspPage", "/devel/search.jsp");
  portletURL.setParameter("redirect", redirect);
  portletURL.setParameter("keywords", keywords);


  List<String> headerNames = new ArrayList<String>();

  headerNames.add("#");
  headerNames.add("application");
  headerNames.add("description");
//  headerNames.add("lifeCycleStatus");

  SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

  try {
      Indexer indexer = IndexerRegistryUtil.getIndexer(Application.class);

      //SearchContext searchContext = SearchContextFactory.getInstance(request);
//	  _log.debug("searchContext.getCompanyId(): " + searchContext.getCompanyId());
//	  _log.debug("searchContext.getOwnerUserId(): " + searchContext.getOwnerUserId());
//	  _log.debug("searchContext.getUserId(): " + searchContext.getUserId());
//	  _log.debug("searchContext.getAssetCategoryIds().length: " + searchContext.getAssetCategoryIds().length);
//      _log.debug("searchContext.getSearchEngineId(): " + searchContext.getSearchEngineId());
//      _log.debug("keywords: " + keywords);
//      _log.debug("searchContainer.getEnd(): " + searchContainer.getEnd());
//      _log.debug("searchContainer.getStart(): " + searchContainer.getStart());
      
      //searchContext.setEnd(searchContainer.getEnd());
      //searchContext.setKeywords(keywords);
      //searchContext.setStart(searchContainer.getStart());

//      _log.debug("indexer.getPortletId(): " + indexer.getPortletId());
//      _log.debug("indexer.getSearchEngineId(): " + indexer.getSearchEngineId());
      
      
//      _log.debug("indexer.getClassNames().length: " + indexer.getClassNames().length);
/*      
      Application _app = ApplicationLocalServiceUtil.getApplication(3601);
      _log.debug("indexer.getDocument(_app).getUID(): " + indexer.getDocument(_app).getUID());
      Map<String, Field> fields = indexer.getDocument(_app).getFields();
      _log.debug("fields.size(): " + fields.size());
      
      Collection<Field> fieldValues =  fields.values();
      Set<String> fieldStrings =  fields.keySet();
      
      
      Iterator<Field> iter = fieldValues.iterator();
      while  (iter.hasNext()) {
    	  Field field = iter.next();
          _log.debug("field.name: " + field.getName());
          _log.debug("field.value: " + field.getValue());    	  
      }
      Iterator<String> iter2 =fieldStrings.iterator();
      while  (iter2.hasNext()) {
    	  String string = iter2.next();
          _log.debug("field.string: " + string);
      }
      
*/      
      
      //com.liferay.portal.kernel.search.BooleanQuery  booleanQuery  = indexer.getFullQuery(searchContext);
//      _log.debug("booleanQuery.toString(): " + booleanQuery.toString());
  
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

          	if (_application.getLifeCycleStatus() > 4) {
          	  _application = _application.toEscapedModel();
        	}
        	  
        	  
          }
          catch (Exception e) {
              if (_log.isWarnEnabled()) {
                  _log.warn("Application search index is stale and contains entry " + applicationId);
              }

              continue;
          }

          PortletURL rowURL = renderResponse.createRenderURL();

          rowURL.setParameter("jspPage", "/devel/view_application.jsp");
          rowURL.setParameter("redirect", currentURL);
          
          rowURL.setParameter("applicationId", String.valueOf(_application.getApplicationId()));
//          _log.debug("_application.getApplicationId(): " + _application.getApplicationId());
          row.addText(_application.getName(), rowURL);
          
          row.addText(_application.getDescription());

          // Score
    //      row.addScore(results.score(i));

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
