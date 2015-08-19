<%--
  #%L
  govapps_data
  $Id: edit_application.jsp 566 2014-11-13 15:22:01Z sma $
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
<%@include file="./urls.jsp" %>


<script type="text/javascript">


function add() {
     
    //Create an input type dynamically.
    var input_element = document.createElement("input");

    //Assign different attributes to the element.
    input_element.setAttribute("type", "Textbox");
    input_element.setAttribute("value", "URI eingeben");
    input_element.setAttribute("name", "od_uri");
    input_element.setAttribute("class", "span6");


    var div_element = document.createElement("div");
    var a_element = document.createElement("a");
    a_element.setAttribute("href", "#");
    a_element.setAttribute("onclick", 'removeInput(this.parentNode)');

    var t_element = document.createTextNode("entfernen");
    a_element.appendChild(t_element);

    div_element.appendChild(input_element);
    div_element.appendChild(a_element);
    
    var foo = document.getElementById("text");
 
    foo.appendChild(div_element);
}

function removeInput( el ) {
    var parent = document.getElementById('text');
    parent.removeChild(el);
}

</script>

<liferay-ui:error
     key="error-saving-application"
     message="error-saving-application" />
        
<liferay-ui:error
     key="missing-required-application-name"
     message="missing-required-application-name" />
        
<liferay-ui:error key="missing-required-application-description"
    message="missing-required-application-description" />

<liferay-ui:error key="missing-required-application-version"
    message="missing-required-application-version" />

<liferay-ui:error key="missing-required-application-versionInformation"
    message="missing-required-application-versionInformation" />

<liferay-ui:error key="missing-required-application-developer"
    message="missing-required-application-developer" />

<liferay-ui:error key="missing-required-application-legalDetails"
    message="missing-required-application-legalDetails" />

<liferay-ui:error key="missing-required-application-targetCategory"
    message="missing-required-application-targetCategory" />

<liferay-ui:error key="contains-forbidden-tags-application-name"
    message="contains-forbidden-tags-application-name" />

<liferay-ui:error key="contains-forbidden-tags-description"
    message="contains-forbidden-tags-description" />

<liferay-ui:error key="contains-forbidden-tags-application-developer"
    message="contains-forbidden-tags-application-developer" />

<liferay-ui:error key="contains-forbidden-tags-application-legalDetails"
    message="contains-forbidden-tags-application-legalDetails" />


<liferay-ui:error key="error-adding-multiMedia"
    message="error-adding-multiMedia" />

<liferay-ui:error key="error-saving-image-size"
    message="error-saving-image-size" />

<liferay-ui:error key="error-saving-image-duplicate-file"
    message="error-saving-image-duplicate-file" />

<liferay-ui:error key="error-adding-multiMedia-extension"
    message="error-adding-multiMedia-extension" />

<liferay-ui:success key="application-updated-successfully"
    message="application-updated-successfully" />


<%

Log _log = LogFactoryUtil.getLog("docroot.content.edit_application_jsp");

Application _application = (Application) request.getAttribute("application");

List<Category> allCategories = CategoryLocalServiceUtil.getCategories(companyId);
List<Language> allLanguages = LanguageLocalServiceUtil.getLanguages(companyId);
List<Region> allRegions = RegionLocalServiceUtil.findByc(companyId);

List<Category> selectedCategories = new ArrayList<Category>();
List<Region> selectedRegions = new ArrayList<Region>();
List<Language> selectedLanguages = new ArrayList<Language>();

selectedCategories = ApplicationLocalServiceUtil.getCategories(_application.getApplicationId());	
selectedRegions = ApplicationLocalServiceUtil.getRegions(_application.getApplicationId());
selectedLanguages = ApplicationLocalServiceUtil.getLanguages(_application.getApplicationId());

List<User> _allUsers =  new LinkedList<User>();

long _roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.APP_DEVELOPER).getRoleId();		
List<User> allUsers = UserLocalServiceUtil.getRoleUsers(_roleId);
_log.debug("allUsers.size(): " + allUsers.size());

long _roleId2 = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.FORM_DEVELOPER).getRoleId();
List<User> allUsers2 = UserLocalServiceUtil.getRoleUsers(_roleId2);
_log.debug("allUsers2.size(): " + allUsers2.size());

_allUsers.addAll(allUsers);

for (User _user2 : allUsers2) {
/*	_log.debug("_user2.getUserId(): " + _user2.getUserId());
	boolean contains = false;
	for (User _oldUser: _allUsers) {
	    _log.debug("_oldUser.getUserId(): " + _oldUser.getUserId());
		if (_oldUser.getUserId() == _user2.getUserId()) {
			contains = true;
	        _log.debug("contains: " + contains);
		}
	}
    _log.debug("contains: " + contains);
    
	if (! contains) {
	    _log.debug("_allUsers.add: ");
		_allUsers.add(_user2);	
	}
*/	
    if (! _allUsers.contains(_user2)) {
        _log.debug("_allUsers.add: ");
        _allUsers.add(_user2);
    }
}
_log.debug("_allUsers.size(): " + _allUsers.size());
%>


<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="<%=viewJSP%>" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionUpdateApplication" var="editURL">
  <portlet:param name="applicationId" value="<%= String.valueOf(_application.getApplicationId()) %>" />
  <portlet:param name="successForward" value="<%=editApplicationJSP%>" />
  <portlet:param name="errorForward" value="<%=editApplicationJSP%>" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Anwendung_editieren">
    <portlet:param name="applicationId" value="<%= String.valueOf(_application.getApplicationId()) %>" />
    <portlet:param name="successForward" value="<%= editApplicationJSP %>" />
    <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Links_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(_application.getApplicationId()) %>" />
  <portlet:param name="successForward" value="<%= editApplicationLinksJSP %>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Bilder_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(_application.getApplicationId()) %>" />
  <portlet:param name="successForward" value="<%= editApplicationStep3JSP %>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Berechtigungen_editieren">
  <portlet:param name="applicationId" value="<%= String.valueOf(_application.getApplicationId()) %>" />
  <portlet:param name="successForward" value="<%=editApplicationEntitlemetsJSP%>" />
  <portlet:param name="exceptionForward" value="<%= errorJSP %>" />
</portlet:actionURL>

<input class="myInputClass" type="button" value="<liferay-ui:message key="&lt;&lt;zur�ck zur �bersicht" />" onClick="location.href = '<%= cancelURL.toString() %>';" />        
<br />
<b>Schritt 1: Anwendung editieren</b>   ->  <input class="myInputClass" type="button" value="<liferay-ui:message key="Links editieren" />" onClick="location.href = '<%= Links_editieren.toString() %>';" /> ->  <input type="button" value="<liferay-ui:message key="Bilder editieren" />" onClick="location.href = '<%= Bilder_editieren.toString() %>';" />    ->  <input type="button" value="<liferay-ui:message key="Berechtigungen editieren" />" onClick="location.href = '<%= Berechtigungen_editieren.toString() %>';" />


<!-- 
<b>Schritt 1: Anwendung editieren</b>	->	Links editieren	->	Bilder editieren 	->	Berechtigungen editieren
 -->

<aui:form
    name="fm"
    action="<%= editURL.toString() %>"
    enctype="multipart/form-data"
    method="post">

  <aui:fieldset>
<!-- 
    <aui:input
        name="applicationId"
        type="hidden"
        value="< % = _application.getApplicationId() %>"
    />
-->

	<aui:select 
		label="user" 
		name="_userId" 		        
		helpMessage="Tragen-sie-hier-den-Benutzer-der-Anwendung-ein"
	>
			
	<%
	for (User _user : _allUsers) {
		if(_user.getUserId() == _application.getUserId()) {
			
	%>			
<!-- 			<aui:option selected="true" value="< % = _user.getUserId() %>"><liferay-ui:message key="< % = _user.getFullName() %>" /></aui:option>   -->
            <aui:option selected="true" value="<%= _user.getUserId() %>"><liferay-ui:message key="<%= _user.getEmailAddress() %>" /></aui:option>
	<%
		} else {			
	%>			
			<aui:option value="<%= _user.getUserId() %>"><liferay-ui:message key="<%= _user.getEmailAddress() %>" /></aui:option>
	<%
		}
	}
	%>			
	</aui:select>


    <aui:input
        name="name"
        value="<%= _application.getName() %>"
		width="200"
        helpMessage="Tragen-sie-hier-den-Namen-oder-den-Titel-der-Anwendung-ein"
		inputCssClass="aui-field-required"
    />

    <aui:field-wrapper label="description">
	    <liferay-ui:input-editor name="descriptionEditor" toolbarSet="<%=AppConstants.EDITOR_TOOLBAR_STYLE%>" initMethod="initEditor" width="200"  cssClass="span6"/>
	    <script type="text/javascript">
	        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(_application.getDescription()) %>"; }
	    </script>
	</aui:field-wrapper>


    <aui:input
        name="size"
        type="int"
        value="<%= _application.getSize() %>"
		helpMessage="Geben sie hier eine Angabe zur Menge der bei der Installation zu �bertragenen Informationen der Anwendung ein."
		suffix="kB"
        width="200"
    />

    <aui:input
        name="fee"
        type="int"
        value="<%= _application.getFee() %>"
		helpMessage="Geben sie hier den Preis ein, der f�r den Bezug der Anwendung zu entrichten ist."
		suffix="ct."
        width="200"
    />
   
      
    <aui:field-wrapper
        label="platform"
        name="platform"
        helpMessage="Geben sie die Zielplattform an (z.B. IOS, Android, Windows, BlackBerry, Ubuntu, Webapp)"
        required="true"
	>
	
<%
		String tgs = _application.getTargetOS();
		_log.debug("tgs: " + tgs);
		
        if (tgs.contains("Webapp")  || tgs.equalsIgnoreCase("Webapp")) {
%>
            <input type="radio" name="platform" value="Webapp" checked="checked" />Webapp<br />
            
<%
        } else {
%>
            <input type="radio" name="platform" value="Webapp" />Webapp<br />            
<%  
        }
        if (tgs.contains("Android")  || tgs.equalsIgnoreCase("Android")) {
%>
            <input type="radio" name="platform" value="Android" checked="checked" />Android<br />          
<%
        } else {
%>
            <input type="radio" name="platform" value="Android" />Android<br />         
<%  
        }
        if (tgs.contains("BlackBerry")  || tgs.equalsIgnoreCase("BlackBerry")) {
%>
            <input type="radio" name="platform" value="BlackBerry" checked="checked" />BlackBerry<br />          
<%
        } else {
%>
            <input type="radio" name="platform" value="BlackBerry" />BlackBerry<br />         
<%  
        }
        
		if (tgs.contains("iOS") || tgs.equalsIgnoreCase("iOS")) {
	%>
    		<input type="radio" name="platform" value="iOS" checked="checked" />iOS<br />			
	<%
		} else {
	%>
    		<input type="radio" name="platform" value="iOS" />iOS<br />
	<%	
	    }
	    if (tgs.contains("Ubuntu")  || tgs.equalsIgnoreCase("Ubuntu")) {
    %>
           <input type="radio" name="platform" value="Ubuntu" checked="checked" />Ubuntu<br />          
    <%
    } else {
    %>
        <input type="radio" name="platform" value="Ubuntu" />Ubuntu<br />         
    <%  
		}
	    
		if (tgs.contains("Windows")  || tgs.equalsIgnoreCase("Windows")) {
	%>
    		<input type="radio" name="platform" value="Windows" checked="checked" />Windows<br />			
	<%
		} else {
	%>
	    	<input type="radio" name="platform" value="Windows" />Windows<br />
	<%	
		}
	%>
    </aui:field-wrapper>


    <aui:field-wrapper
        label="targetCategory"
        name="targetCategory"
        helpMessage="Geben sie die Endger�tekategorie an (z.B. Smartphone, Tablet)"
        required="true"
	>    
	
	<%
		String tgc = _application.getTargetCategory();
		_log.debug("tgc: " + tgc);
		
		if (tgc.contains("Smartphone") || tgc.equalsIgnoreCase("Smartphone")) {
	%>
    		<input type="checkbox" name="targetCategory" value="Smartphone" checked="checked" />Smartphone<br />			
	<%
		} else {
	%>
    		<input type="checkbox" name="targetCategory" value="Smartphone" />Smartphone<br />
	<%	
		}
		if (tgc.contains("Tablet") || tgc.equalsIgnoreCase("Tablet")) {
	%>
    		<input type="checkbox" name="targetCategory" value="Tablet" checked="checked" />Tablet<br />			
	<%
		} else {
	%>
    		<input type="checkbox" name="targetCategory" value="Tablet" />Tablet<br />			
	<%	
		}
	%>
    </aui:field-wrapper>
	
	
<%
	Calendar dob = CalendarFactoryUtil.getCalendar();
	dob.setTime(_application.getFirstPublishingDate());
%>    	

	<aui:input 
		name="firstPublishingDate"
		helpMessage="Geben sie das Datum der Erstver�ffentlichung an."
		model="<%= Application.class %>"
		value="<%= dob %>"
		inputCssClass="aui-field-required"
	/>
<%
	Calendar dob2 = CalendarFactoryUtil.getCalendar();
	dob2.setTime(_application.getLastModifiedDate());
%>    	
	
	<aui:input 
		name="lastModifiedDate"
		helpMessage="Tragen sie hier das Datum der aktuellsten Version der Anwendung ein."
		model="<%= Application.class %>"
		value="<%= dob2 %>"
		inputCssClass="aui-field-required"
	/>
	
<%
String rowHREF = "";
if (_application.getLogoImageId() != 0) {
	DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(_application.getLogoImageId());
	rowHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + "0" + StringPool.SLASH + HttpUtil.encodeURL(fe.getTitle(), true);
} 
%>
	
	Icon: <img width="72" src="<%= rowHREF %>" > <br />	
	Die Dateigr��e eines Bildes ist auf 100 kB beschr�nkt <br /> 
    <aui:input 
    	label="icon" 
    	name="file" 
    	type="file" 
    	helpMessage="Laden sie hier das Logo der Anwendung hoch. Es sollte z.B. 72*72 Pixel gro� sein."
        width="200"
        showRequiredLabel="true"
    	
    />

    <!--  
    de.fraunhofer.fokus.movepla.Constants.java
    public static final int APPLICATION_STATUS_SUBMITTED   = 1;	
    
    see ApplicationLocalServiceImpl.java
    -->
    
    <aui:input 
    	label="legalDetails" 
    	name="legalDetails" 
		type="textarea"
 		rows="4" cols="200"
		helpMessage="Tragen sie hier alle Angaben zum Anbieter der Anwendung ein. Beachten sie, dass jede registrierte Anwendung genau einen Anbieter besitzt, der die Zugriffsrechte zur Verwaltung des Angebotes besitzt."
		inputCssClass="aui-field-required"
		value="<%= _application.getLegalDetails() %>"
   	/>

    <aui:input 
    	label="developer" 
    	name="developer" 
		type="textarea"
 		rows="4" cols="200"
		helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
		inputCssClass="aui-field-required"
		value="<%= _application.getDeveloper() %>"
    />

    
<!-- 

   	<aui:select name="category"  
   		helpMessage="Geben sie Die Kategorie an, in die die Anwendung eingegliedert werden kann( z.B. St�dte, Politik)"
        width="200"
   		multiple="true" 
        size="10"
	>
		<aui:option value="0">
		    <liferay-ui:message key="Bitte w�hlen" />
		</aui:option>
< % 
	List<Category> appCategories = ApplicationLocalServiceUtil.getCategories(_application.getApplicationId());

	for (Category category : allCategories) {
	
		boolean _selected = false;
		if (appCategories.contains(category)) {
			_selected = true;
		}
% >
  		<aui:option value="< % =category.getCategoryId() % >" selected="< % =_selected % >">
	        <liferay-ui:message key="< % = category.getCategoryName() % >" />
	    </aui:option>
< % 		
   	}
% >   	
	</aui:select>

 -->    

		    <aui:field-wrapper
		        label="category"
		        name="category"
		        helpMessage="Geben sie Die Kategorie an, in die die Anwendung eingegliedert werden kann( z.B. St�dte, Politik)"
		        required="false"    
		   	>
		    
<% 
				for (Category category : allCategories) {
					
					if (selectedCategories.contains(category)) {
%>
			    		<input	type="checkbox" checked="checked" name="category" value="<%=category.getCategoryId() %>" /><%=category.getCategoryName() %><br />
<% 
						
					} else {
%>
			    		<input	type="checkbox" name="category" value="<%=category.getCategoryId() %>" /><%=category.getCategoryName() %><br />
<% 						
					}
				}				
%>
		    </aui:field-wrapper> 
		    
		    
		    
		    <aui:field-wrapper
			        label="region"
			        name="region"
			        helpMessage="W�hlen sie aus, auf welche geografische Region sich ihre Anwendung bezieht(z.B. Sachsen- Anhalt oder Bundesweit)"
			        required="false"    
		   	>
		<%  
				for (Region region : allRegions) {   		
					if (selectedRegions.contains(region)) {
		%>
			    		<input	type="checkbox" checked="checked" name="region" value="<%=region.getRegionId() %>" /><%=region.getName() %><br />
		<% 						
					} else {
		%>
			    		<input type="checkbox" name="region" value="<%=region.getRegionId() %>" /><%=region.getName() %><br />    
		<% 
					}
		   		}
		%>   	
		    </aui:field-wrapper> 
		
		
		    <aui:field-wrapper
		        label="languages"
		        name="languages" 
		        helpMessage="Geben sie die von der Anwendung unterst�tzten Sprachen ein."
		        required="false"    
		   	>
		
		<%  
				for (Language language : allLanguages) {
					if (selectedLanguages.contains(language)) {
		%>
			    		<input	type="checkbox" checked="checked" name="languages" value="<%=language.getLanguageId() %>" /><%=language.getLanguageName() %><br />
		<% 						
					} else {
		%>
			    		<input type="checkbox" name="languages" value="<%=language.getLanguageId() %>" /><%=language.getLanguageName() %><br />
		<% 
					}
		   		}	
		%>
		    </aui:field-wrapper> 		    



    <aui:select name="status"  
        helpMessage="Geben sie den Status der Applikation an"
        width="200"
        size="10"
    >
    
    <%
        int statusInt = _application.getLifeCycleStatus();
        E_Stati e_status = AppConstants.getStatus(statusInt);
        String statusString = e_status.getStrStatus();
    %>

    
<%
    if (statusInt == 1 ) {
    	
%>
        <aui:option value="1" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
    	
<%
    } else {    	
%>
        <aui:option value="1">
            <liferay-ui:message key="<%= AppConstants.getStatus(1).getStrStatus() %>" />
        </aui:option>
<%
    }
%>
    
<%
    if (statusInt == 2 ) {
%>
        <aui:option value="2" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {        
%>
        <aui:option value="2">
            <liferay-ui:message key="<%= AppConstants.getStatus(2).getStrStatus() %>" />
        </aui:option>
<%
    }
%>

<%
    if (statusInt == 3 ) {
%>
        <aui:option value="3" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {        
%>
        <aui:option value="3">
            <liferay-ui:message key="<%= AppConstants.getStatus(3).getStrStatus() %>" />
        </aui:option>
<%
    }
    if (statusInt == -1 ) {
%>
        <aui:option value="-1" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {
%>
        <aui:option value="-1">
            <liferay-ui:message key="<%= AppConstants.getStatus(-1).getStrStatus() %>" />
        </aui:option>
<%
    }
    if (statusInt == -3 ) {
%>
        <aui:option value="-3" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {
%>
        <aui:option value="-3">
            <liferay-ui:message key="<%= AppConstants.getStatus(-3).getStrStatus() %>" />
        </aui:option>
<%
    }
    if (statusInt == 4 ) {
%>
        <aui:option value="4" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {
%>
        <aui:option value="4">
            <liferay-ui:message key="<%= AppConstants.getStatus(4).getStrStatus() %>" />
        </aui:option>
<%
    }
%>

<%
    if (statusInt == 5 ) {
%>
        <aui:option value="5" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {
%>
        <aui:option value="5">
            <liferay-ui:message key="<%= AppConstants.getStatus(5).getStrStatus() %>" />
        </aui:option>
<%
    }
    if (statusInt == 6 ) {
%>
        <aui:option value="6" selected="true">
            <liferay-ui:message key="<%= statusString %>" />
        </aui:option>
        
<%
    } else {
%>
        <aui:option value="6">
            <liferay-ui:message key="<%= AppConstants.getStatus(6).getStrStatus() %>" />
        </aui:option>
<%
    }
%>

    </aui:select>
    
    
    
    <aui:input
        name="relatedApplicationId"
        value="<%= _application.getRelatedApplicationId() %>"
        width="200"
        helpMessage="Tragen-sie-hier-andere-Instanzen-der-Applikation-ein"
    />
    

<!--     
   	<aui:select name="region" 
   		helpMessage="W�hlen sie aus, auf welche geografische Region sich ihre Anwendung bezieht(z.B. Sachsen- Anhalt oder Bundesweit)"
        width="200"
   		multiple="true" 
        size="10"
   	>
		<aui:option value="0">
		    <liferay-ui:message key="Bitte w�hlen" />
		</aui:option>
< %  

	List<Region> appRegions = ApplicationLocalServiceUtil.getRegions(_application.getApplicationId());
	for (Region region : allRegions) {
		boolean _selected = false;
		if (appRegions.contains(region)) {
			_selected = true;
		}
% >   	
  		<aui:option value="< % =region.getRegionId() % >" selected="< % =_selected % >">
        	<liferay-ui:message key="< % =region.getName() % >" />
	   	 </aui:option>
< % 
   	}
% >
	</aui:select>
 
   	<aui:select
   		name="languages" 
   		multiple="true" 
   		helpMessage="Geben sie die von der Anwendung unterst�tzten Sprachen ein."
   	    width="200"
   	>
< %  
	List<Language> appLanguages = ApplicationLocalServiceUtil.getLanguages(_application.getApplicationId());
	for (Language language : allLanguages) {
		boolean _selected = false;
		if (appLanguages.contains(language)) {
			_selected = true;
		}
   		
% >
  		<aui:option value="< % = language.getLanguageId() %>"  selected="< % =_selected % >">
	        <liferay-ui:message key="< % = language.getLanguageName() %>" />
	    </aui:option>
< % 
   	}
% >   	
	</aui:select>
-->



<%
  int useOD = _application.getUseOpenData();
  String sektor = _application.getSector();
  String lizenz = _application.getLicense();
  List<Link> allLinks = LinkLocalServiceUtil.findByca(companyId, _application.getApplicationId());
%>
        <br />
        <hr />
          <aui:fieldset>
            <aui:fieldset>
                <aui:field-wrapper label="Verwendet Ihre App Datens&auml;tze vom GovData Portal? " name="open data" required="false">
                <div align="right"><a href="http://www.govdata.de" target="_blank" > <img src="/vepa-backend-theme/images/vepa-icons/govdata_logo.png" alt="govdata logo" ></a></div>
                                    
                    <label class="checkbox">
                    <% if (useOD != 0) { %> 
                      <input type="checkbox" name="cb_od" id="cb_od" checked='checked' onchange='checkedEBox()' >Ja.
                    <% } else { %>
                      <input type="checkbox" name="cb_od" id="cb_od" onchange='checkedEBox()' >Ja.
                    <% } %>
                    </label>
                    
                    <div id="odid">
                    Bitte geben Sie nachfolgend an, f&uuml;r welchen Sektor Ihre App konzipiert ist, unter welcher Lizenz Sie diese ver&ouml;ffentlichen und welche GovData Datens&auml;tze die App nutzt. <br />
                    
                        <aui:field-wrapper label="Sektor" name="sektor" required="true"
                            helpMessage="Zeigt an, ob eine App aus dem &ouml;ffentlichem, dem privaten oder einem anderen Bereich kommt.">
                
                            <select class="span2" name="sektor">
                                <% if (sektor.equalsIgnoreCase("oeffentlich") || sektor.equalsIgnoreCase("")) { %>
                                     <option selected="selected">oeffentlich</option>
                                <% } else { %>
                                     <option>oeffentlich</option>
                                <% } if (sektor.equalsIgnoreCase("privat") ) { %>
                                    <option selected="selected">privat</option>
                                <% } else { %>
                                    <option>privat</option>
                                <% } if (sektor.equalsIgnoreCase("andere") ) { %>                    
                                    <option selected="selected">andere</option>
                                <% } else { %>
                                    <option>andere</option>
                                <% } %>
                            </select>
                        </aui:field-wrapper>
        
                        <aui:field-wrapper label="Lizenz" name="Lizenz" required="true"
                        helpMessage="Unter welcher Lizenz ist die App ver&ouml;ffentlicht?">
                
                            <select class="span2" name="lizenz">
                                <% if (lizenz.equalsIgnoreCase("apache") || lizenz.equalsIgnoreCase("")) { %>
                                     <option selected="selected">Apache Lizenz</option>
                                <% } else { %>
                                     <option>Apache Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("app_commercial") ) { %>
                                    <option selected="selected">Andere kommerzielle Lizenz</option>
                                <% } else { %>
                                    <option>Andere kommerzielle Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("app_freeware") ) { %>                    
                                    <option selected="selected">Andere kostenfreie Lizenz</option>
                                <% } else { %>
                                    <option>Andere kostenfreie Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("app_opensource") ) { %>                    
                                    <option selected="selected">Andere Open Source Lizenz</option>
                                <% } else { %>
                                    <option>Andere Open Source Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("bsd-license") ) { %>                    
                                    <option selected="selected">BSD Lizenz</option>
                                <% } else { %>
                                    <option>BSD Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("gpl-3.0") ) { %>                    
                                    <option selected="selected">GNU General Public License version 3.0 (GPLv3)</option>
                                <% } else { %>
                                    <option>GNU General Public License version 3.0 (GPLv3)</option>
                                <% } if (lizenz.equalsIgnoreCase("mozilla") ) { %>                    
                                    <option selected="selected">Mozilla Public License 1.0 (MPL)</option>
                                <% } else { %>
                                    <option>Mozilla Public License 1.0 (MPL)</option>
                                <% } if (lizenz.equalsIgnoreCase("other-open") ) { %>                    
                                    <option selected="selected">Andere freie Lizenz</option>
                                <% } else { %>
                                    <option>Andere freie Lizenz</option>
                                <% } if (lizenz.equalsIgnoreCase("other-closed") ) { %>                    
                                    <option selected="selected">Andere eingeschr&auml;nkte Lizenz</option>
                                <% } else { %>
                                    <option>Andere eingeschr&auml;nkte Lizenz</option>
                                <% } %>
                            </select>
                        </aui:field-wrapper>
        
        
                    <p><b>Verwendete GovData Datens&auml;tze</b><br />
                    F&uuml;gen Sie bitte f&uuml;r jeden verwendeten GovData Datensatz, die entsprechende URI hinzu:
                    </p>
                    <div>
                        <p> <input type="button" value="Datensatz hinzuf&uuml;gen" onclick="add()"></p>
                    </div>
                    
                        <div id="text">
                        <%
                        for (Link link : allLinks) {
                            if (link.getType() == Constants.OPENDATA) {
                        %>
                            <div>
                                <input type='Textbox' value="<%=link.getUrl() %>" name="od_uri"  class="span6" /> 
                                <a href="#" onclick='removeInput(this.parentNode)' >entfernen</a>                            
                            </div>
                        <%      
                            }
                            
                        }
                        %>
                        </div>
                    </div>
        
                </aui:field-wrapper>
            </aui:fieldset>
          </aui:fieldset>
    <aui:button-row>
      <aui:button type="submit" value="Speichern" />
    </aui:button-row>

  </aui:fieldset>

</aui:form>
