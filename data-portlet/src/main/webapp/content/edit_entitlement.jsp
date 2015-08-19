<%--
  #%L
  govapps_data
  $Id: edit_entitlement.jsp 566 2014-11-13 15:22:01Z sma $
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

<%
Entitlement entitlement = (Entitlement) request.getAttribute("entitlement");
%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/content/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="entitlementActionUpdate" var="updateURL" />

<h2>Edit an Entitlement</h2>


<liferay-ui:error
     key="error-updating-entitlement"
     message="error-updating-entitlement" />

<liferay-ui:error
     key="missing-required-entitlement-EntitlementName"
     message="missing-required-entitlement-EntitlementName" />

<liferay-ui:error
     key="missing-required-entitlement-explanation"
     message="missing-required-entitlement-explanation" />

<liferay-ui:error
     key="missing-required-entitlement-estimation"
     message="missing-required-entitlement-estimation" />

<aui:form
    name="fm"
    action="<%= updateURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="entitlementId"
        value="<%= entitlement.getEntitlementId() %>"
        type="hidden"
    />
    <aui:input
        name="entitlementName"
        value="<%= entitlement.getEntitlementName() %>"
        size="45"
    />
      <aui:input
        name="explanation"
        value="<%= entitlement.getExplanation() %>"
        size="45"
    />
    <aui:input
        name="estimation"
        value="<%= entitlement.getEstimation() %>"
        size="45"
    />

    <aui:button-row>
      <aui:button type="submit"/>
      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%= cancelURL.toString() %>"
    />
    </aui:button-row>

  </aui:fieldset>

</aui:form>
