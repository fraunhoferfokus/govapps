<%--
  #%L
  govapps_data
  $Id: add_application.jsp 566 2014-11-13 15:22:01Z sma $
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

<noscript>
    <h1>
        <font color="#ff0000">
            Diese Seite ben�tigt JavaScript. Bitte �ndern Sie Ihre Browsereinstellungen.
        </font>
    </h1>
</noscript>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/form/add_application.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddApplication" var="addURL">
    <portlet:param name="successForward" value="/form/add_applicationLinks.jsp" />
    <portlet:param name="errorForward" value="/form/add_application.jsp" />    
</portlet:actionURL>

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
Application _application = null;
String _applicationName = "";
String _description = "";
int _size = 0;
int _fee = 0;
String _legalDetails = "";
String _developer = "";
List<Category> selectedCategories = new ArrayList<Category>();
List<Region> selectedRegions = new ArrayList<Region>();
List<Language> selectedLanguages = new ArrayList<Language>();

_application = (Application) request.getAttribute("application");
if (_application != null) {
    _applicationName = _application.getName();
    _description = _application.getDescription();
    _size = _application.getSize();
    _fee = _application.getFee();
    _legalDetails = _application.getLegalDetails();
    _developer = _application.getDeveloper();
    selectedCategories = ApplicationLocalServiceUtil.getCategories(_application.getApplicationId());    
    selectedRegions = ApplicationLocalServiceUtil.getRegions(_application.getApplicationId());
    selectedLanguages = ApplicationLocalServiceUtil.getLanguages(_application.getApplicationId());
}

List<Category> allCategories = CategoryLocalServiceUtil.getCategories(companyId);
List<Language> allLanguages = LanguageLocalServiceUtil.getLanguages(companyId);
List<Region> allRegions = RegionLocalServiceUtil.findByc(companyId);

Calendar dob = CalendarFactoryUtil.getCalendar();
dob.setTime(new Date());


Log _log = LogFactoryUtil.getLog("docroot.form.add_application_jsp");
try {
    long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
    long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.FORM_DEVELOPER).getRoleId();       
    if (! UserLocalServiceUtil.hasRoleUser(roleId, userId)) {
    } else {

//String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/welcome-theme/images/portlet/help.png";

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";


%>

<b>Beschreiben Sie Ihre Anwendung in 4 Schritten<br />
Das Fragezeichen <img src="<%= helpHREF %>" > gibt Hinweise zu den einzelnen Datenfeldern.</b><br />

<b>Schritt 1: Anwendung beschreiben</b>  -> Links hinzuf�gen    ->  Bilder hinzuf�gen   ->  Berechtigungen erl�utern
        

        <aui:form
            name="fm"
            action="<%= addURL.toString() %>"
            enctype="multipart/form-data"
            method="post">
        
          <aui:fieldset>
        
            <aui:field-wrapper 
                label="Anwendungsname"
                name="name"
                helpMessage="Tragen-sie-hier-den-Namen-oder-den-Titel-der-Anwendung-ein"
                required="true"
            >
            <aui:input
                label=""
                name="name"
                width="200"
                type="text"
                maxlength="75"
                value="<%= _applicationName %>"
                inputCssClass="aui-field-required"
                
            />
            </aui:field-wrapper>
            
            <aui:field-wrapper 
                label="description"
                name="description"
                helpMessage="Beschreiben sie hier ihre Anwendung, bez�glich Anwendungsfunktionalit�t und Angaben zum Einsatzzweck."
                required="true"    
            >
                <liferay-ui:input-editor name="descriptionEditor" toolbarSet="slimmed" initMethod="initEditor" width="200" />
                <script type="text/javascript">
                    function <portlet:namespace />initEditor() { return "<%= _description =="" ? UnicodeFormatter.toString("Beschreiben sie hier ihre Anwendung, bez�glich Anwendungsfunktionalit�t und Angaben zum Einsatzzweck.") : UnicodeFormatter.toString(_description) %>"; }
                </script>
            </aui:field-wrapper>
        
        
            <aui:input
                name="size"
                type="int"
                helpMessage="Geben sie hier eine Angabe zur Menge der bei der Installation zu �bertragenen Informationen der Anwendung ein."
                suffix="kB"
                width="200"
                maxlength="6"
                value="<%= _size %>"
            />
        
            <aui:input
                name="fee"
                type="int"
                helpMessage="Geben sie hier den Preis ein, der f�r den Bezug der Anwendung zu entrichten ist."
                suffix="ct."
                width="200"
                maxlength="6"
                value="<%= _fee %>"
            />
            
            <aui:field-wrapper
                label="platform"
                name="platform"
                helpMessage="Geben sie die Zielplattform an (z.B. IOS, Android, Windows, Webapp), sollten sie die Anwendung f�r mehrere Zielplattformen imlementiert haben, so k�nnen sie am Ende die eingegebenen Daten f�r weitere Zielplattformen �bernehmen"
                required="true"
            >
            <!--  
                <input type="checkbox" name="targetCategory" value="iPhone" />iPhone<br />
                <input type="checkbox" name="targetCategory" value="iPad" />iPad<br />  
                <input type="checkbox" name="targetCategory" value="Android_Smartphone" />Android_Smartphone<br />   
                <input type="checkbox" name="targetCategory" value="Android_Tablet" />Android_Tablet<br />  
                <input type="checkbox" name="targetCategory" value="Windows_Smartphone" />Windows_Smartphone<br />
                <input type="checkbox" name="targetCategory" value="Windows_Tablet" />Windows_Tablet<br />
                <aui:input inlineLabel="right" name="gender" type="radio" value="1" label="male" />
                <aui:input checked="< % = true % >" inlineLabel="right" name="gender" type="radio" value="2" label="female"  />
            --> 

                <input type="radio" checked="checked"  name="platform" value="Webapp" />Webapp<br />   
                <input type="radio" name="platform" value="Android" />Android<br /> 
                <input type="radio"  name="platform" value="iOS" />iOS<br />
                <input type="radio" name="platform" value="Windows" />Windows<br /> 
                   
            </aui:field-wrapper>


            <aui:field-wrapper
                label="targetCategory"
                name="targetCategory"
                helpMessage="Geben sie die Endger�tekategorie an (z.B. Smartphone, Tablet)"
                required="true"
            >
                <input type="checkbox" name="targetCategory" value="Smartphone" checked="checked" />Smartphone<br />
                <input type="checkbox" name="targetCategory" value="Tablet" />Tablet<br />  
                   
            </aui:field-wrapper>
         
            <aui:input 
                name="firstPublishingDate"
                helpMessage="Geben sie das Datum der Erstver�ffentlichung an."
                model="<%= Application.class %>"
                value="<%= dob %>"
                inputCssClass="aui-field-required"
            />
            
            <aui:input 
                name="lastModifiedDate"
                helpMessage="Tragen sie hier das Datum der aktuellsten Version der Anwendung ein."
                model="<%= Application.class %>"
                value="<%= dob %>"
                inputCssClass="aui-field-required"
            />
        
            Die Dateigr��e eines Bildes ist auf 100 kB beschr�nkt <br /> 
            <aui:input 
                label="icon" 
                name="file" 
                type="file" 
                helpMessage="Laden sie hier das Logo der Anwendung hoch. Es sollte z.B. 72*72 Pixel gro� sein."
                width="200"
                multiple="true"
                />

            <aui:field-wrapper 
                label="legalDetails"
                name="legalDetails" 
                helpMessage="Tragen sie hier alle Angaben zum Anbieter der Anwendung ein. Beachten sie, dass jede registrierte Anwendung genau einen Anbieter besitzt, der die Zugriffsrechte zur Verwaltung des Angebotes besitzt."
                required="true"    
            >
        
                <aui:input 
                    required="true"    
                    label=""
                    name="legalDetails" 
                    type="textarea"
                    maxlength="2000"
                    rows="4" cols="200"
                    inputCssClass="aui-field-required"
                    value="<%= _legalDetails %>"
                />
            </aui:field-wrapper> 
        
            <aui:field-wrapper 
                label="developer"
                name="developer" 
                helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
                required="true"    
            >
                <aui:input 
                    required="true"    
                    label="" 
                    name="developer" 
                    type="textarea"
                    maxlength="2000"
                    rows="4" cols="200"
                    helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
                    inputCssClass="aui-field-required"
                    value="<%= _developer %>"
                />
            </aui:field-wrapper> 
            
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
                        <input  type="checkbox" checked="checked" name="category" value="<%=category.getCategoryId() %>" /><%=category.getCategoryName() %><br />
            <% 
                        
                    } else {
            %>
                        <input  type="checkbox" name="category" value="<%=category.getCategoryId() %>" /><%=category.getCategoryName() %><br />
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
                        <input  type="checkbox" checked="checked" name="region" value="<%=region.getRegionId() %>" /><%=region.getName() %><br />
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
                        <input  type="checkbox" checked="checked" name="languages" value="<%=language.getLanguageId() %>" /><%=language.getLanguageName() %><br />
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
              <aui:button type="submit" value="next"/>
              <aui:button
                  type="cancel"
                  value="cancel"
                  onClick="<%= cancelURL.toString() %>"
              />
        
            </aui:button-row>
        
          </aui:fieldset>
        
        </aui:form>
        
        <% 
        }
    
} catch (Exception e) {
    _log.debug(e.getMessage()); 
    e.printStackTrace();
}
%>
        
