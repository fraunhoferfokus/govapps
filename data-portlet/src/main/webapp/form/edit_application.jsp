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

<%

Log _log = LogFactoryUtil.getLog("docroot.form.edit_application_jsp");

Application _application = (Application) request.getAttribute("application");

List<Category> allCategories = CategoryLocalServiceUtil.getCategories(companyId);
List<Language> allLanguages = LanguageLocalServiceUtil.getLanguages(companyId);
List<Region> allRegions = RegionLocalServiceUtil.findByc(companyId);

List<Category> selectedCategories = new ArrayList<Category>();
List<Region> selectedRegions = new ArrayList<Region>();
List<Language> selectedLanguages = new ArrayList<Language>();
if (_application != null) {
	selectedCategories = ApplicationLocalServiceUtil.getCategories(_application.getApplicationId());	
	selectedRegions = ApplicationLocalServiceUtil.getRegions(_application.getApplicationId());
	selectedLanguages = ApplicationLocalServiceUtil.getLanguages(_application.getApplicationId());
}
%>
<b>Schritt 1: Anwendung editieren</b>	->	Links editieren	->	Bilder editieren 	->	Berechtigungen editieren

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/form/add_application.jsp" />
</portlet:renderURL>

<portlet:actionURL name="developerUpdateApplicationAction" var="editURL">
    <portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/form/edit_applicationLinks.jsp" />
    <portlet:param name="errorForward" value="/form/edit_application.jsp" />        
</portlet:actionURL>

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
    <aui:input
        name="relatedApplicationId"
        type="hidden"
        value="<%= _application.getRelatedApplicationId() %>"
    />

    <aui:input
        name="status"
        type="hidden"
        value="<%= _application.getLifeCycleStatus() %>"
    />


    <aui:input
        name="name"
        value="<%= _application.getName() %>"
		width="200"
        helpMessage="Tragen-sie-hier-den-Namen-oder-den-Titel-der-Anwendung-ein"
		inputCssClass="aui-field-required"
    />

    <aui:field-wrapper label="description">
	    <liferay-ui:input-editor name="descriptionEditor" toolbarSet="slimmed" initMethod="initEditor" width="200" />
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
        helpMessage="Geben sie die Zielplattform an (z.B. IOS, Android, Windows, Webapp)"
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
        
        if (tgs.contains("iOS") || tgs.equalsIgnoreCase("iOS")) {
    %>
            <input type="radio" name="platform" value="iOS" checked="checked" />iOS<br />           
    <%
        } else {
    %>
            <input type="radio" name="platform" value="iOS" />iOS<br />
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


    <aui:button-row>
      <aui:button type="submit" value="next" />
      <aui:button
          type="cancel"
          value="cancel"
          onClick="<%= cancelURL.toString() %>"
    />

    </aui:button-row>

  </aui:fieldset>

</aui:form>
