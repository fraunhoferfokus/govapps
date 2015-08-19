<%--
  #%L
  govapps_data
  $Id: profile.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@page import="com.liferay.portal.service.ContactServiceUtil"%>
<%@page import="com.liferay.portal.service.UserServiceUtil"%>
<%@page import="de.fraunhofer.fokus.movepla.portlets.AppConstants"%>
<%@ include file="../include.jsp"%>

<%
	Log _log = LogFactoryUtil.getLog("docroot.devel.view_jsp");

	/*
	 long userId = com.liferay.portal.util.PortalUtil.getUserId(request);

	 User user = UserServiceUtil.getUserById(userId);
	 */
	 
	String fname = user.getFirstName();
	String lname = user.getLastName();
	String eaddr = user.getDisplayEmailAddress();
	String tab = "details";
	
	String param = (String) request.getAttribute("fname");
	if (param != null)
		fname = param;
	param = (String) request.getAttribute("lname");
	if (param != null)
		lname = param;
	param = (String) request.getAttribute("eaddr");
	if (param != null)
		eaddr = param;
	param = (String) request.getAttribute("tab");
	if (param != null)
		tab = param;
	
	/*
	PortletPreferences prefs = renderRequest.getPreferences();
	
	fname = prefs.getValue("fname",fname);
	lname = prefs.getValue("lname",lname);
	eaddr = prefs.getValue("eaddr",eaddr);
	tab = prefs.getValue("tab",tab);*/
	
	String emsg = (String) request.getAttribute("errorMsg");
	String smsg = (String) request.getAttribute("successMsg");

	String tab1class = "";
	String tab2class = "";
	
	if (tab.equalsIgnoreCase("details"))
		tab1class = "active";
	else
		tab2class = "active";
	
	if (emsg != null && emsg.trim().length() > 0) {
%>
<div class="alert alert-error">
	<strong><%=emsg%></strong>
</div>
<%
	} else if (smsg != null && smsg.trim().length() > 0) {
%>

<div class="alert alert-success">
	<strong><%=smsg%></strong>
</div>
<%
	}
%>

<portlet:actionURL name="profileActionUpdateDetails" var="updateURL"  copyCurrentRenderParameters="true">
	<portlet:param name="successForward" value="/devel/view.jsp" />
	<portlet:param name="errorForward" value="/profile/profile.jsp" />
</portlet:actionURL>

<portlet:actionURL name="profileActionUpdatePassword" var="updateURL2" copyCurrentRenderParameters="true">
	<portlet:param name="successForward" value="/devel/view.jsp" />
	<portlet:param name="errorForward" value="/profile/profile.jsp" />
</portlet:actionURL>

<portlet:renderURL var="appURL">
	<portlet:param name="jspPage" value="/devel/view.jsp" />
	<portlet:param name="errorForward"
		value="/devel/view.jsp" />
	<portlet:param name="successForward" value="/devel/view.jsp" />
</portlet:renderURL>


<a href="<%= appURL.toString() %>" class="btn btn-mini">Zur&uuml;ck</a>
<br/>
<br/>

<div class="tabbable" onLoad="disableNav()">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Details</a></li>
		<li><a href="#tab2" data-toggle="tab">Passwort</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane <%=tab1class %>" id="tab1">
			<form name="fm" action="<%=updateURL%>"
				method="post">

                <input type="hidden"
						name="tab" 
						value="details" />


				<label class="span2" style="text-align: right; margin-right: 10px;">Vorname</label> <input type="text"
						name="fname" class="input-medium"
						value="<%=fname%>" />
				<br/>

				<label class="span2"  style="text-align: right; margin-right: 10px;">Nachname</label>
				<input type="text"
						name="lname" class="input-medium"
						value="<%=lname%>" />
				<br/>

				<label class="span2"  style="text-align: right; margin-right: 10px;">eMail</label><input type="text"
						name="eaddr" class="input-medium"
						value="<%=eaddr%>" />
				<br/>


				<div class="offset2">
				<button name="next" type="submit" class="btn btn-large btn-primary">Speichern</button>
				</div>

			</form>
		</div>
		<div class="tab-pane <%=tab2class %>" id="tab2">
			<form name="fm2"
				action="<%=updateURL2.toString()%>"
				method="post">
				
				<input type="hidden"
						name="tab" 
						value="password" />

				<label class="span2" style="text-align: right; margin-right: 10px;">Passwort</label>
				<input type="password"
					name="pass1" class="input-medium" />
					<br/>

				<label class="span2"  style="text-align: right; margin-right: 10px;">Wiederholen</label>
				<input type="password"
					name="pass2" class="input-medium" />
					<br/>


				<div class="offset2">
				<button name="next" type="submit" class="btn btn-large btn-primary">Speichern</button>
				</div>
			</form>
		</div>
	</div>
</div>
