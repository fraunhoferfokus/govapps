<%--
  #%L
  govapps_data
  $Id: view_application.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@page import="java.util.HashMap"%>
<%@page import="com.sun.xml.internal.ws.message.RelatesToHeader"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="de.fraunhofer.fokus.movepla.portlets.AppConstants"%>
<%@page import="de.fraunhofer.fokus.movepla.portlets.E_Images"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@include file="../include.jsp"%>


<%
	Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.view_application_jsp");
	
    
    try {
		long userId = com.liferay.portal.util.PortalUtil.getUserId(request);

			Application _application = (Application) request.getAttribute("application");

			long applicationId = _application.getApplicationId();
			String applicationIdString = String.valueOf(applicationId);
			_log.debug("applicationIdString: " + applicationIdString);

			if (applicationIdString == null  || "null".equals(applicationIdString)) {
				PortletURL renderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
				Map<String, String[]> map = renderURL.getParameterMap();
				applicationIdString = map.get("applicationId")[0];
			}


			String logoImageId = String.valueOf(_application.getLogoImageId());

			List<Application_Entitlement> allApplicationEntitlements = ApplicationLocalServiceUtil.getApplicationEntitlements(applicationId);
			List<Category> allCategorys = ApplicationLocalServiceUtil.getCategories(applicationId);
			List<Language> allLanguages = ApplicationLocalServiceUtil.getLanguages(applicationId);
			List<Link> allLinks = ApplicationLocalServiceUtil.getLinks(applicationId);
			List<MultiMedia> allMultiMedias = ApplicationLocalServiceUtil.getMultiMedias(applicationId);
			List<Region> allRegions = ApplicationLocalServiceUtil.getRegions(applicationId);

			// semik sep.
			String relIds = _application.getRelatedApplicationId();
			List<Application> relApps = new LinkedList<Application>();
			if (relIds.trim().length() > 0) {
				String[] relIdSplit = relIds.split(";");
				for (String relId : relIdSplit) {
					Long id = null;
					try {
						id = Long.valueOf(relId);
					} catch (Throwable t) {
					}
					if (id != null) {
						Application relApp = ApplicationLocalServiceUtil.getApplication(id);
						if (relApp != null)
							relApps.add(relApp);
					} else {
						log("Invalid related appID: " + relId);
					}

				}
			}
			int relAppsSize = relApps.size();

			String rowHREF = "";
			if (_application.getLogoImageId() != 0) {
				DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(_application.getLogoImageId());
				rowHREF = themeDisplay.getPortalURL()
						+ themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId()
						+ StringPool.SLASH + "0" + StringPool.SLASH
						+ HttpUtil.encodeURL(fe.getTitle(), true);
			}
			Iterator<MultiMedia> mmiter = allMultiMedias.iterator();
			String mmsize = Integer.toString(allMultiMedias.size());
%>


<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="jspPage" value="/devel/view.jsp" />
</liferay-portlet:renderURL>

<portlet:actionURL name="applicationRedirectWId" var="editURL">
	<portlet:param name="applicationId" value="<%=String.valueOf(applicationId)%>" />
    <portlet:param name="successForward" value="/devel/edit_application.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
</portlet:actionURL>

<div>
	<a class="btn" onClick="location.href = '<%=viewURL.toString()%>'">&lt;&lt;zur&uuml;ck zur &Uuml;bersicht</a>
<%
    if (_application.getLifeCycleStatus() != 6 && _application.getLifeCycleStatus() != 2) {
%>	
	   <a class="btn" onClick="location.href = '<%=editURL.toString()%>'">App	bearbeiten</a>
<%
    }
%>  
</div>
<br />


<div style="float: none; clear: both; vertical-align: middle;">
	<div style="float: left; height: 50px; margin-right: 20px;">
		<%
			if (rowHREF != null && rowHREF.trim().length() > 0) {
		%>
		<img src="<%=rowHREF%>" alt="" style="height: 50px;" />
		<%
			}
		%>
	</div>
	<h3><%=_application.getName()%></h3>
</div>
<br />
<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs" style="margin-bottom: 0px;">
	
		<li class="active">
			<%
				String tos = _application.getTargetOS();
				E_Images timg = AppConstants.getPlatform(tos);

				if (timg != null) {
			%> <a href="#tab1" style="border: 1px solid white;"><img src="<%=timg.getIcon()%>" alt="<%=timg.getDescr()%>" />&nbsp;<%=tos%></a>
			<%
				} else {
			%> <a href="#tab1"><%=tos%></a> <% 	log("Missing image for plattform: " + tos);
 			}
%>
		</li>
	        
<%

			if (relApps.size() > 0) {
				for (Application app : relApps) {
					String os = app.getTargetOS();
					E_Images img = AppConstants.getPlatform(os);
%>
		            <li>
<%
                      if (img != null) {
%> 
						<a
						href="<portlet:actionURL name="applicationRedirectWId">
								<portlet:param name="applicationId" value="<%=String.valueOf(app.getApplicationId())%>" />
			                    <portlet:param name="successForward" value="/devel/view_application.jsp" />
			                    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
							</portlet:actionURL>"
						style="border: 1px solid white;"><img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" />&nbsp;<%=os%></a> 
<%
					 } else {
 %>                    <a href="#tab1"><%=os%></a> <%
		               log("Missing image for plattform: " + os);
 			         }
 %>

		           </li>
<%
			   }
			}
%>
	</ul>

	<div class="tab-content" style="padding: 0px; margin-top: 0px;">
		<div class="tab-pane active" id="tab1">
			<div class="float-none">
				<div class="unitbox-left">
					<div class="hero-unit unit">
						<h3>Beschreibung</h3>
						<hr />
						<%=_application.getDescription()%>
					</div>
					
                    <%
                    if (_application.getLifeCycleStatusString()  != null && _application.getLifeCycleStatusString().length() > 0 ) {
                    %>  
                    <div class="hero-unit unit">
                        <h3>zur Freigabe sind weitere Informationen erforderlich:</h3>                        
                        <hr />
                        
                        <%= _application.getLifeCycleStatusString() %>
                    </div>
                        
                    <%
                    }                   
                    %>  

					<div class="hero-unit unit">
						<h3>
							Screenshots (<%=mmsize%>)
						</h3>
						<hr />
						<div style="margin: auto; text-align: center;">
							<div id="myCarousel" class="carousel slide">
								<!-- Carousel items -->
								<div class="carousel-inner">
									<%
									boolean first = true;
										while (mmiter.hasNext()) {
													MultiMedia mm = mmiter.next();
													Long imgId = mm.getImageId();
													String imgUrl = null;
													if (imgId != null) {
														DLFileEntry fe = DLFileEntryLocalServiceUtil
																.getDLFileEntry(imgId);
														imgUrl = themeDisplay.getPortalURL()
																+ themeDisplay.getPathContext()
																+ "/documents/"
																+ themeDisplay.getScopeGroupId()
																+ StringPool.SLASH + "0" + StringPool.SLASH
																+ HttpUtil.encodeURL(fe.getTitle(), true);
														if (imgUrl != null) {
									%>
									<%
									if (first) {
										first = false;
									%>
										<div class="active item">
									<%
										} else {
									%>
										<div class="item">
									<%
										}
									%>

										<img src="<%=imgUrl%>" alt="" style="max-height: 200px; margin: auto;">

									</div>

									<%
										}
													}
												}
									%>
								</div>
								<!-- Carousel nav -->
								<a class="carousel-control left" href="#myCarousel"
									data-slide="prev">&lsaquo;</a> <a
									class="carousel-control right" href="#myCarousel"
									data-slide="next">&rsaquo;</a>
							</div>
						</div>
						
						
					</div>
				</div>
				<div class="unitbox-right">

					<div class="hero-unit unit">
						<h3>Berechtigungen</h3>
						<hr />
						<%
							for (Application_Entitlement ae : allApplicationEntitlements) {
										//for (E_Images img: E_Images.values()) {
										//if (img.name().startsWith("ENT_")) {
										E_Images img = AppConstants
												.getEntitlement(ae.getName());
										if (img != null) {
						%>
						<a href="#" rel="tooltip" title="<%=ae.getMotivation()%>"> <img
							src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>"
							style="margin: 5px 10px;" /></a>
						<%
							} else {
											log("Missing image for entitlement: "
													+ ae.getName());
										}
									}
						%>
					</div>
					<div class="hero-unit unit">
						<h3>Daten</h3>
						<hr />
						<%
							if (_application.getCategoryString() != null
											&& _application.getCategoryString().trim().length() > 0) {

										for (Category cat : allCategorys) {
											E_Images img = AppConstants.getCategory(cat
													.getCategoryName());
											if (img != null) {
						%>
						<div>
							<div class="small-img">
								<img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" />
							</div>
							<b><%=cat.getCategoryName()%></b>
						</div>
						<hr />
						<%
							} else {
												log("Missing image for category: "
														+ cat.getCategoryName());
											}
										}
									}
									Date lmd = _application.getLastModifiedDate();
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
									String lmdStr = sdf.format(lmd);
						%>

						<div>
							<div class="small-img">
								<img src="<%=E_Images.DATE.getIcon()%>"
									alt="<%=E_Images.DATE.getDescr()%>" />
							</div>
							<b><%=lmdStr%></b>
						</div>
						<hr />

						<%
							if (_application.getSize() > 0) {
										DecimalFormat df = new DecimalFormat(",##0.00");
										String sizeDec = df.format((double) _application
												.getSize() / (double) 1024);
						%>
						<div>
							<div class="small-img">
								<img src="<%=E_Images.SIZE.getIcon()%>"
									alt="<%=E_Images.SIZE.getDescr()%>" />
							</div>
							<b><%=sizeDec%> MB</b>
						</div>
						<hr />
						<%
							}
						%>



						<%
							if (allLanguages != null && allLanguages.size() > 0) {
										Iterator<Language> iter = allLanguages.iterator();
										StringBuffer langStr = new StringBuffer();
										while (iter.hasNext()) {
											langStr.append(iter.next().getLanguageName());
											if (iter.hasNext())
												langStr.append(", ");
										}
						%>
						<div>
							<div class="small-img">
								<img src="<%=E_Images.LANGUAGES.getIcon()%>"
									alt="<%=E_Images.LANGUAGES.getDescr()%>" />
							</div>
							<b><%=langStr.toString()%></b>
						</div>
						<hr />
						<%
							}
						%>
					</div>
					<%
						if (_application.getRegionString() != null
										&& _application.getRegionString().trim().length() > 0) {
					%>
					<div class="hero-unit unit">
						<h3>Regionen</h3>
						<hr />
						<%
							for (Region reg : allRegions) {
											E_Images img = AppConstants
													.getRegion(reg.getName());
											if (img != null) {
						%>
						<div style="float: none; clear: both;">
							<div class="small-img">
								<img src="<%=img.getIcon()%>" alt="<%=img.getDescr()%>" />
							</div>
							<b><%=img.getDescr()%> </b>
						</div>
						<%
							} else {
												log("Missing image for region: "
														+ reg.getName());
											}
										}
						%>
					</div>
					<%
						}
					%>
					<div class="hero-unit unit">
						<h3>Herausgeber</h3>
						<hr />
						<%=_application.getLegalDetails()%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%

	} catch (Exception e) {
		_log.debug(e.getMessage());
		e.printStackTrace();
	}
%>
