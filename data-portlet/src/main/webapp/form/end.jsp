<%--
  #%L
  govapps_data
  $Id: end.jsp 566 2014-11-13 15:22:01Z sma $
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
Application _application = (Application) request.getAttribute("application");

long applicationId = _application.getApplicationId();
String applicationIdString = String.valueOf(applicationId);
%>

<portlet:actionURL name="redirectAction" var="addURL">
    <portlet:param name="successForward" value="/form/add_application.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="applicationActionCloneApplication" var="addVarURL">
	<portlet:param name="applicationId" value="<%= String.valueOf(applicationId) %>" />
    <portlet:param name="successForward" value="/form/edit_application.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />
</portlet:actionURL>

<h1>vielen Dank f�r ihre Teilnahme</h1>

<p>
Sie k�nnen entweder eine <input type="button" value="<liferay-ui:message key="weitere_Anwendung_eintragen" />" onClick="location.href = '<%= addURL.toString() %>';" />, <br />
<a href="/c/portal/logout">sich abmelden</a>, oder das Fenster schlie�en.</p>


<p>
Desweiteren k�nnen sie die Daten der Anwendung f�r eine andere Zielplattform <input type="button" value="<liferay-ui:message key="�bernehmen" />" onClick="location.href = '<%= addVarURL.toString() %>';" />.
</p>

<p>
Wir werden sie zeitnah �ber den Fortschritt des Projektes informieren.
</p>
