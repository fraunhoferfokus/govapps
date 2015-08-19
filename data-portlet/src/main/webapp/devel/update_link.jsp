<%--
  #%L
  govapps_data
  $Id: update_link.jsp 566 2014-11-13 15:22:01Z sma $
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

<portlet:actionURL name="updateLinkAction" var="editURL" />


<%
Link _link = (Link) request.getAttribute("link");
String applicationId = String.valueOf((Long) request.getAttribute("applicationId"));

%>
<liferay-ui:error
     key="missing-required-link-displayName"
     message="missing-required-link-displayName" />

<liferay-ui:error
     key="missing-required-link-url"
     message="missing-required-link-url" />


<aui:form
    name="fm"
    action="<%= editURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="applicationId"
        value="<%= applicationId %>"
        type="hidden"
    />

    <aui:input
        name="linkId"
        value="<%= _link.getLinkId() %>"
        type="hidden"
    />

	<aui:input 
		name="displayName"
		showRequiredLabel="true"
		type="text"
        size="200"	
        value="<%= _link.getDisplayName() %>"
	/>
    
	<aui:input 
		name="url"
		showRequiredLabel="true"
		type="text"
        size="200"
        value="<%= _link.getUrl() %>"
	/>

   	<aui:select name="type">
   	<% if (_link.getType() == 1) {
   	%>	
  		<aui:option value="1" selected="true">
    	   <liferay-ui:message key="Quellcode" />
	    </aui:option>	    
   	<%	
   	} else {
   	%>	
		<aui:option value="1">
	        <liferay-ui:message key="Quellcode" />
	    </aui:option>	    
   		
   	<%	
   	}
   	if (_link.getType() == 2) {
   	%>	
  		<aui:option value="2" selected="true">
	        <liferay-ui:message key="Link zum AppStore" />
	    </aui:option>
   	<%	
   	} else {
   	%>	
  		<aui:option value="2">
	        <liferay-ui:message key="Link zum AppStore" />
	    </aui:option>
   		
   	<%	
   	}
   	if (_link.getType() == 3) {
   	%>	
  		<aui:option value="3" selected="true">
	        <liferay-ui:message key="Bin�rcode" />
	    </aui:option>
   	<%	
   	} else {
   	%>	
  		<aui:option value="3">
	        <liferay-ui:message key="Bin�rcode" />
	    </aui:option>
   		
   	<%	
   	}
   	if (_link.getType() == 4) {
   	%>	
  		<aui:option value="4"  selected="true">
	        <liferay-ui:message key="Homepage der Anwendung" />
	    </aui:option>	    
   	<%	
   	} else {
   	%>	
  		<aui:option value="4">
	        <liferay-ui:message key="Homepage der Anwendung" />
	    </aui:option>	    
   		
   	<%	
   	}
   	if (_link.getType() == 5) {
   	%>	
  		<aui:option value="5" selected="true">
	        <liferay-ui:message key="Homepage des Entwicklers" />
	    </aui:option>
   	<%	
   	} else {
   	%>	
  		<aui:option value="5">
	        <liferay-ui:message key="Homepage des Entwicklers" />
	    </aui:option>
   		
   	<%	
   	}
   	
   	if (_link.getType() == 6) {
   	%>	
  		<aui:option value="6" selected="true">
	        <liferay-ui:message key="Homepage des Herausgebers" />
	    </aui:option>
   	<%	
   	} else {
   	%>	
  		<aui:option value="6">
	        <liferay-ui:message key="Homepage des Herausgebers" />
	    </aui:option>
   		
   	<%	
   	}
   	%>	
	</aui:select>
<!-- 

	public static final int SOURCE_CODE    				= 1;
	public static final int TARGET_LINK				  	= 2;
	public static final int BINARY_CODE    				= 3;
	public static final int APPLICATION_HOME_PAGE   	= 4;
	public static final int DEVELOPER_HOME_PAGE    		= 5;
	public static final int LEGAL_DETAILS_HOME_PAGE  	= 6;

 -->
    <aui:button-row>
      <aui:button type="submit"/>
      
      <aui:button
          type="cancel"
          value="cancel"
          onClick="<%= cancelURL.toString() %>"
      />
      
      
    </aui:button-row>

  </aui:fieldset>

</aui:form>
