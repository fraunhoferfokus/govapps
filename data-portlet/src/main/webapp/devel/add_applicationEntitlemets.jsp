<%--
  #%L
  govapps_data
  $Id: add_applicationEntitlemets.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="../include.jsp" %>


<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/devel/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddEntitlements" var="addURL">
    <portlet:param name="successForward" value="/devel/view.jsp" />
    <portlet:param name="errorForward" value="/devel/add_applicationEntitlemets.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />
</portlet:actionURL>

<!--  Error Messages -->

<liferay-ui:error key="contains-forbidden-tags-application_entitlement-motivation"
    message="contains-forbidden-tags-application_entitlement-motivation" />

<liferay-ui:error key="too-short-entitlement-explanation"
     message="too-short-entitlement-explanation" />


<!--  Success Messages -->

    
<liferay-ui:success key="entitlement-added-successfully"
    message="entitlement-added-successfully" />

<liferay-ui:success key="entitlement-updated-successfully"
    message="entitlement-updated-successfully" />

<liferay-ui:success key="entitlement-deleted-successfully"
    message="entitlement-deleted-successfully" />
    
<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.add_application4_jsp");
Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();
_log.debug("applicationId: " + applicationId);


List<Entitlement> allEntitlements = EntitlementLocalServiceUtil.getEntitlements(companyId);
List<Application_Entitlement> allApplicationEntitlements = Application_EntitlementLocalServiceUtil.findByca(companyId, applicationId);

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";

%>

<div class="page-header">
    <small>
        <a onClick="location.href = '<%=cancelURL.toString()%>'" class="btn btn-mini">Zur&uuml;ck</a>
    </small>
	<h1>
		Anwendung hinzuf&uuml;gen <small>in 4 Schritten</small>
	</h1>
	<div class="progress">
	<div class="bar" style="width: 25%;">Anwendungsdetails</div>
	<div class="bar" style="width: 25%;">Links</div>
	<div class="bar" style="width: 25%;">Bilder</div>
	<div class="bar" style="width: 25%;">Berechtigungen</div>
</div>
</div>

<script type="text/javascript">
function checkedEBox(id) {
	console.log("unchecking for id: "+id);
	var cbid = "cb"+id;
	var taid = "ta"+id;
	if (document.getElementById(cbid).checked == true) {
	  document.getElementById(taid).disabled=true;
	  document.getElementById(taid).style.display='none';
	}
	else {
      document.getElementById(taid).disabled=false;
      document.getElementById(taid).style.display='block';
    }
}
</script>		

<h2>Berechtigungen</h2>
<div class="well well-small">
<p>
	Bitte erl&auml;utern Sie sorgf&auml;ltig welche Berechtigungen Ihre Anwendung warum ben&ouml;tigt.<br />
	Ein Schwerpunkt der Plattform GovApps liegt auf der Aufkl&auml;rung des Nutzers welche Berechtigungen eine App ben&ouml;tigt.<br />
    Wenn eine App eine Berechtigung ben&ouml;tigt, soll dies begr&uuml;ndet werden, damit der Nutzer individuell abw&auml;gen kann, <br />
    ob er die "Risiken" eingehen m&ouml;chte, oder lieber auf die App verzichtet.
</p>

<p>
   Bei nicht zutreffenden Angaben oder nicht nachvollziehbaren Begr&uuml;ndungen, wird sich die Freigabe der Anwendung unn&ouml;tig verz&ouml;gern.
</p>
	
<p>
	F&uuml;r den Fall, dass Ihre Anwendung eine Berechtigung NICHT ben&ouml;tigt, w&auml;hlen Sie die Checkbox '<b>Diese Berechtigung wird nicht ben&ouml;tigt</b>'.<br />
</p>
	Das Fragezeichen <img src="<%=helpHREF%>"> gibt Hinweise zu den einzelnen Datenfeldern.</b>
</div>
		
		
<aui:form
    name="fm"
    action="<%= addURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="applicationId"
        value="<%= applicationId %>"
        type="hidden"
    />

    <aui:input
        name="companyId"
        value="<%= companyId %>"
        type="hidden"
    />

    <aui:input
        name="action"
        value="add_application"
        type="hidden"
    />
<%
   	for (Entitlement entitlement :allEntitlements) {
   		
   		String _name       = "name_"       + entitlement.getEntitlementName(); 
   		String _motivation = "motivation_" + entitlement.getEntitlementName();
   		String _checked = "checked_" + entitlement.getEntitlementName();
   		String _id = "toggle_id" + _name;

   		_log.debug("_name: " + _name);
		_log.debug("_motivation: " + _motivation);
   		
%>

	<p class="lead">
	<%= entitlement.getEntitlementName() %>
	</p>

	<div id="<%= _id %>">
	    <p class="text-info">
    		<%= entitlement.getExplanation() %>
    	</p>
            <label class="checkbox">
              <input type="checkbox" name="<%= _checked %>" id="cb<%= _id %>" onClick='checkedEBox("<%=_id%>")'>Diese Berechtigung wird nicht ben&ouml;tigt.
            </label>
    	
		    <aui:input 
		        name="<%= _name %>"
				type="hidden"
		        value="<%= entitlement.getEntitlementName() %>"
		    />
			
			<div id="ta<%= _id %>">
			<aui:field-wrapper name="<%= _motivation %>"
 				helpMessage="Begr&uuml;nden sie, warum ihre Anwendung diese Berechtigung ben&ouml;tigt."
            required="true">
            	<textarea name="<%= _motivation %>" rows="4" cols="100" maxlength="1000" class="input-xxlarge span8"></textarea>
            </aui:field-wrapper>
            </div>
	</div>

	<hr/>
		    
<%   			
   	}
%>

<script type="text/javascript">
function checked(id) {
	console.log("unchecking for id: "+id);
	var cbid = "cb"+id;
	var taid = "ta"+id;
	if (document.getElementById(cbid).checked == false)
	  document.getElementById(taid).readOnly=true;
	else
      document.getElementById(taid).readOnly=false;
}
</script>
  
  		<aui:button-row>

			<button type="submit" class="btn btn-large btn-primary" value="next">Abschlie&szlig;en</button>


		</aui:button-row>
		  

  </aui:fieldset>

</aui:form>
