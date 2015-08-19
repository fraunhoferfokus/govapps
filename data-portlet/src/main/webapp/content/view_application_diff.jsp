<%--
  #%L
  govapps_data
  $Id: view_application_diff.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@page import="de.fraunhofer.fokus.movepla.portlets.E_Images"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="de.fraunhofer.fokus.movepla.service.EntitlementLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Entitlement"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Application_Entitlement"%>
<%@page import="de.fraunhofer.fokus.movepla.model.MultiMedia"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Link"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Region"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Language"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="de.fraunhofer.fokus.movepla.model.Application"%>
<%@page import="de.fraunhofer.fokus.movepla.portlets.ViewUtil.E_FieldType"%>

<%

 //E_FieldType field = null;
 //Application viewApp = null;
 
 switch (field) {
 
   case DEVICES:
	   %>
	   
	   <div class="span3"><strong>Endger�te:</strong></div><div class="span9"><%= viewApp.getTargetCategory() %></div>
	   
	   <%
	   break;
 
   case OS:
	   E_Images timg = AppConstants.getPlatform(viewApp.getTargetOS());
	   %>
	   
	   <div class="span3"><strong>Plattform:</strong></div>
	   <div class="span9"><img style="margin: 5px 10px;" src="<%=timg.getIcon()%>" alt="<%=timg.getDescr()%>">&nbsp;<%= viewApp.getTargetOS() %></div>
	   
	   <%
	   break;
 
   case SIZE:
	   String sizeDec = "0";
	   if (viewApp.getSize() > 0) {
			DecimalFormat df = new DecimalFormat(",##0.00");
			sizeDec = df.format((double) viewApp.getSize() / (double) 1024);
	   }
	   %>
	   
	   <div class="span3"><strong>Gr&ouml;sse:</strong></div><div class="span9"><%= sizeDec %> MB</div>
	   
	   <%
	   break;
	   
   case COST:
	   %>
	   
	   <div class="span3"><strong>Kosten:</strong></div><div class="span9"><%= viewApp.getFee() %> ct.</div>
	   
	   <%
	   break;
 
 
   case NAME:
	   %>
	   
	   <div class="span3"><strong>Name:</strong></div><div class="span9"><%= viewApp.getName() %></div>
	   
	   <%
	   break;
	   
   case LOGO:
	   
	   String rowHREF = "";
		if (viewApp.getLogoImageId() != 0) {
		    DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(viewApp.getLogoImageId());
		    rowHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + "0" + StringPool.SLASH + HttpUtil.encodeURL(fe.getTitle(), true);
		}
	   
	   %>
	   
	   <div class="span3"><strong>Logo:</strong></div><div class="span9" style="height: 50px;"><img src="<%= rowHREF %>"  style="height: 50px;"></div>
	   
	   <%
	   break;
	
   case DESCR:
       %>
	   
	   <div class="span3"><strong>Beschreibung:</strong></div><div class="span9"><%= viewApp.getDescription() %></div>
	   
	   <%
	   break;
   
   case DEVEL:
       %>
	   
	   <div class="span3"><strong>Entwickler:</strong></div><div class="span9"><%= viewApp.getDeveloper() %></div>
	   
	   <%
	   break;
	   
   case IMPRES:
       %>
	   
	   <div class="span3"><strong>Impressum:</strong></div><div class="span9"><%= viewApp.getLegalDetails() %></div>
	   
	   <%
	   break;
	   
   case CAT:
	   %>
	    <strong>Kategorien:</strong><br/>
	   <%
	     List<Category> allCategorys = ApplicationLocalServiceUtil.getCategories(viewApp.getApplicationId());	
	     for (Category category : allCategorys) {
	    	 E_Images img = AppConstants.getCategory(category.getCategoryName());
	    	 if (img == null) img = E_Images.NONE;
       %>
          <div style="margin: 10px;">
	        <img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" style="margin: 5px 10px;"/><%= category.getCategoryName() %>
	      </div>
	   <%
	     }
	   %>
	   <%
	   break;
	   
   case LANG:
	   %>
	    <strong>Sprachen:</strong><br/>
	   <%
	     List<Language> allLanguages = ApplicationLocalServiceUtil.getLanguages(viewApp.getApplicationId());	
	     for (Language lang : allLanguages) {		
       %>
	      <div style="margin: 10px;"><%= lang.getLanguageName() %> </div>
	   <%
	     }
	   %>
	   <%
	   break;
	   
   case REGION:
	   %>
	    <strong>Regionen:</strong><br/>
	   <%
		 List<Region> allRegions = ApplicationLocalServiceUtil.getRegions(viewApp.getApplicationId());
	     for (Region reg : allRegions) {
	    	 E_Images img = AppConstants.getRegion(reg.getName());
	    	 if (img == null) img = E_Images.NONE;
       %>
	      <div style="margin: 10px;"><img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" style="margin: 5px 10px;"/><%= reg.getName() %> </div>
	   <%
	     }
	   %>
	   <%
	   break;
	 
   case LINKS:
	   %>
	    <strong>URLs:</strong><br/>
	    <dl>
	   <%
		 List<Link> allLinks = ApplicationLocalServiceUtil.getLinks(viewApp.getApplicationId());
	     for (Link link : allLinks) {		
       %>
	      <dt> <%= link.getDisplayName() %> </dt>
	      <dd><a href="<%= link.getUrl()%>"><%= link.getUrl() %></a> </dd>
	   <%
	     }
	   %>
	    </dl>
	   <%
	   break;
	   
   case ENTITLE:
	   %>
	    <strong>Berechtigungen:</strong><br/>
	    <dl>
	   <%
		 List<Application_Entitlement> allApplicationEntitlements = ApplicationLocalServiceUtil.getApplicationEntitlements(viewApp.getApplicationId());		
	     for (Application_Entitlement ent : allApplicationEntitlements) {
	    	 Entitlement entitlement = EntitlementLocalServiceUtil.fetchEntitlement(ent.getEntitlementId());
	    	 E_Images img = AppConstants.getEntitlement(ent.getName());
	    	 if (img == null) img = E_Images.NONE;
       %>
	      <dt><img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" style="margin: 5px 10px;" /><%= entitlement.getEntitlementName() %> </dt>
	      <dd> <%= ent.getMotivation() %> </dd>
	   <%
	     }
	   %>
	    </dl>
	   <%
	   break;
	   
   case IMAGES:
	   %>
	    <strong>Bilder:</strong><br/>
	    <ul class="thumbnails">
	   <%
		 List<MultiMedia> allMultiMedias = ApplicationLocalServiceUtil.getMultiMedias(viewApp.getApplicationId());
	     for (MultiMedia multi : allMultiMedias) {
	    	 if (multi.getImageId() != 0) {
	           DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(multi.getImageId());
	    	   String imgHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + "0" + StringPool.SLASH + HttpUtil.encodeURL(fe.getTitle(), true);
       %>
	           <li class="span2"><div class="thumbnail"><img src="<%= imgHREF %>" alt=""></div></li>
	   <%
	    	 }
	     }
	   %>
	    </ul>
	   <%
	   break;
 
   case TIME:
	   %>
	    <strong>Zeitangaben:</strong><br/>
	    <%
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
	    String pubStr = sdf.format(viewApp.getFirstPublishingDate());
		String lmdStr = sdf.format(viewApp.getLastModifiedDate());
		
	    
	    %>
	    <dl>
	      <dt>Anwendung ver�ffentlicht:</dt>
	      <dd> <%= pubStr %> </dd>
	    </dl>
	    <dl>
	      <dt>Anwendung modifiziert:</dt>
	      <dd> <%= lmdStr %> </dd>
	    </dl>
	   <%
	   break;
 }

%>
