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
<%@include file="./urls.jsp" %>

<noscript>
    <h1>
        <font color="#ff0000">
            Diese Seite ben�tigt JavaScript. Bitte �ndern Sie Ihre Browsereinstellungen.
        </font>
    </h1>
</noscript>


<script type="text/javascript">
function init() {
    // quit if this function has already been called
    if (arguments.callee.done) return;

    // flag this function so we don't do the same thing twice
    arguments.callee.done = true;

    // kill the timer
    if (_timer) clearInterval(_timer);

    // do stuff
    checkedEBox();
};

/* for Mozilla/Opera9 */
if (document.addEventListener) {
    document.addEventListener("DOMContentLoaded", init, false);
}

/* for Internet Explorer */
/*@cc_on @*/
/*@if (@_win32)
document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
var script = document.getElementById("__ie_onload");
script.onreadystatechange = function() {
    if (this.readyState == "complete") {
    init(); // call the onload handler
}
};
/*@end @*/

/* for Safari */
if (/WebKit/i.test(navigator.userAgent)) { // sniff
    var _timer = setInterval(function() {
    if (/loaded|complete/.test(document.readyState)) {
        init(); // call the onload handler
    }
    }, 10);
}

/* for other browsers */
window.onload = init;
function checkedEBox() {
    if (document.getElementById("cb_od").checked == true) {
        document.getElementById("odid").disabled=false;
        document.getElementById("odid").style.display='block';
    }
    else {
        document.getElementById("odid").disabled=true;
        document.getElementById("odid").style.display='none';
    }
}

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

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/content/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionAddApplication" var="addURL">
<!--
    <portlet:param name="successForward" value="/content/add_applicationLinks.jsp" />
    <portlet:param name="errorForward" value="/content/add_application.jsp" />
 -->    
    <portlet:param name="successForward" value="<%=addApplicationLinksJSP%>" />
    <portlet:param name="errorForward" value="<%=addApplicationJSP%>" />
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
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.content.add_application_jsp");

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
String tgc = "";
String platform = "";
String sektor = "";
String lizenz = "";

Calendar dobFirstPublishingDate = CalendarFactoryUtil.getCalendar();
dobFirstPublishingDate.setTime(new Date());

Calendar dobLastModifiedDate = CalendarFactoryUtil.getCalendar();
dobLastModifiedDate.setTime(new Date());

_application = (Application) request.getAttribute("application");
if (_application != null) {
    _applicationName = _application.getName();
    _description = _application.getDescription();
    _size = _application.getSize();
    _fee = _application.getFee();
    _legalDetails = _application.getLegalDetails();
    _developer = _application.getDeveloper();
    
    long[] _selectedCategories = (long[]) request.getAttribute("categoryPKs");
    long[] _selectedRegions = (long[]) request.getAttribute("regionPKs");
    long[] _selectedLanguages = (long[]) request.getAttribute("languagePKs");
    
    if (_selectedCategories != null) {
        for (int i=0; i<_selectedCategories.length; i++) { 
            selectedCategories.add(CategoryLocalServiceUtil.getCategory(_selectedCategories[i]));
        }
    }
        

    if (_selectedRegions != null) {
        for (int i=0; i<_selectedRegions.length; i++) { 
            selectedRegions.add(RegionLocalServiceUtil.getRegion(_selectedRegions[i]));
        }
    }

    if (_selectedLanguages != null) {
        for (int i=0; i<_selectedLanguages.length; i++) { 
            selectedLanguages.add(LanguageLocalServiceUtil.getLanguage(_selectedLanguages[i]));
        }
    }
    
    dobFirstPublishingDate.setTime(_application.getFirstPublishingDate());
    dobLastModifiedDate.setTime(_application.getLastModifiedDate());
    
    tgc = _application.getTargetCategory();
    platform = _application.getTargetOS();

}

List<Category> allCategories = CategoryLocalServiceUtil.getCategories(companyId);
List<Language> allLanguages = LanguageLocalServiceUtil.getLanguages(companyId);
List<Region> allRegions = RegionLocalServiceUtil.findByc(companyId);


long _roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.APP_DEVELOPER).getRoleId();      
List<User> allUsers = UserLocalServiceUtil.getRoleUsers(_roleId);

Calendar dob = CalendarFactoryUtil.getCalendar();
dob.setTime(new Date());


try {
    long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
    long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.CONTENT_PROVIDER).getRoleId();        


//String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/welcome-theme/images/portlet/help.png";

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";


%>

<b>Beschreiben Sie Ihre Anwendung in 4 Schritten<br />
Das HilfsIcon <img src="<%= helpHREF %>" > gibt Hinweise zu den einzelnen Datenfeldern</b>

        <b>Schritt 1: Anwendung beschreiben</b>  -> Links hinzuf�gen    ->  Bilder hinzuf�gen   ->  Berechtigungen erl�utern
        
        
        <aui:form
            name="fm"
            action="<%= addURL.toString() %>"
            enctype="multipart/form-data"
            method="post">
<!--        
          <aui:input type="hidden" name="errorForward" value="/content/add_application.jsp" />
          <aui:input type="hidden" name="successForward" value="/content/add_applicationLinks.jsp" />            
 -->                    
  <aui:fieldset>

    <aui:fieldset>
       <aui:select 
            label="user" 
            name="_userId"              
            helpMessage="Tragen-sie-hier-den-Benutzer-der-Anwendung-ein"
       >
            
       <%   for (User _user : allUsers) {                                                               %>
                <aui:option value="<%= _user.getUserId() %>"><%= _user.getFullName() %></aui:option>
       <%   }                                                                                           %>          
       </aui:select>
    </aui:fieldset>

    <aui:fieldset>
        <aui:field-wrapper label="Anwendungsname" name="name"
            helpMessage="Tragen-sie-hier-den-Namen-oder-den-Titel-der-Anwendung-ein"
            required="true">

            <input name="name" type="text" maxlength="75"
                value="<%=_applicationName%>" class="span6" />
        </aui:field-wrapper>
    
        
        <aui:input label="iconE" name="file" type="file" showRequiredLabel="true"
            helpMessage="Laden sie hier das Logo der Anwendung hoch. Es sollte z.B. 72*72 Pixel gro� sein."
            width="200" multiple="true" cssClass="input-medium" inputCssClass="btn" />
        <p class="text-info">Die maximale Dateigr��e betr�gt 100kB</p>

    </aui:fieldset>

    <aui:fieldset column="true" style="margin-left: -10px; margin-top: 5px; margin-bottom: 5px; margin-right: 40px;">
        
        <aui:field-wrapper label="description" name="description"
            helpMessage="Beschreiben sie hier ihre Anwendung, bez�glich Anwendungsfunktionalit�t und Angaben zum Einsatzzweck."
            required="true">
            <liferay-ui:input-editor name="descriptionEditor"
                toolbarSet="<%=AppConstants.EDITOR_TOOLBAR_STYLE%>" initMethod="initEditor" width="200" height="200" cssClass="span6"/>
            <script type="text/javascript">
                    function <portlet:namespace />initEditor() { return "<%=_description =="" ? UnicodeFormatter.toString("Beschreiben sie hier ihre Anwendung, bez�glich Anwendungsfunktionalit�t und Angaben zum Einsatzzweck.") : UnicodeFormatter.toString(_description)%>"; }
                </script>
        </aui:field-wrapper>

    </aui:fieldset>
        
        
    <aui:fieldset>

        <br/>
        <br/>

        <aui:field-wrapper label="Gr��e" name="size"
            helpMessage="Geben sie hier eine Angabe zur Menge der bei der Installation zu �bertragenen Informationen der Anwendung ein."
            inlineField="true">

            <div class="input-append">
                <input class="span2" name="size" maxlength="6" value="<%=_size%>"
                    type="text"><span class="add-on">kB</span>
            </div>
        </aui:field-wrapper>

        <aui:field-wrapper label="Kosten" name="fee"
            helpMessage="Geben sie hier den Preis ein, der f�r den Bezug der Anwendung zu entrichten ist.">

            <div class="input-append">
                <input class="span2" name="fee" maxlength="6" value="<%=_fee%>"
                    type="text"><span class="add-on">ct.</span>
            </div>
        </aui:field-wrapper>
            
        <aui:field-wrapper label="platform" name="platform" required="true"
            helpMessage="Geben sie die Zielplattform an (z.B. IOS, Android, Windows, BlackBerry, Ubuntu, Webapp), sollten sie die Anwendung f�r mehrere Zielplattformen imlementiert haben, so k�nnen sie am Ende die eingegebenen Daten f�r weitere Zielplattformen �bernehmen">

            <select class="span2" name="platform">
                <% if (platform.equalsIgnoreCase("Webapp") || platform.equalsIgnoreCase("")) { %>
                     <option selected="selected">Webapp</option>
                <% } else { %>
                     <option>Webapp</option>
                <% } if (platform.equalsIgnoreCase("Android") ) { %>
                    <option selected="selected">Android</option>
                <% } else { %>
                     <option>BlackBerry</option>
                <% } if (platform.equalsIgnoreCase("BlackBerry") ) { %>
                    <option selected="selected">BlackBerry</option>
                <% } else { %>
                    <option>Android</option>
                <% } if (platform.equalsIgnoreCase("iOS") ) { %>                    
                    <option selected="selected">iOS</option>
                <% } else { %>
                     <option>Ubuntu</option>
                <% } if (platform.equalsIgnoreCase("Ubuntu") ) { %>
                    <option selected="selected">Ubuntu</option>
                <% } else { %>
                    <option>iOS</option>
                <% } if (platform.equalsIgnoreCase("Windows") ) { %>
                    <option selected="selected">Windows</option>
                <% } else { %>
                    <option>Windows</option>
                <% }        %>
            </select>
        </aui:field-wrapper>


        <aui:field-wrapper label="targetCategory" name="targetCategory"
            helpMessage="Geben sie die Endger�tekategorie an (z.B. Smartphone, Tablet)" required="true">
            <%  if (tgc.equals("") || tgc.contains("Smartphone") ) { %>
                    <label class="checkbox"> <input type="checkbox" name="targetCategory" value="Smartphone" checked="checked"> Smartphone</label>
            <%  } else  { %>
                    <label class="checkbox"> <input type="checkbox" name="targetCategory" value="Smartphone"> Smartphone</label>
            <%  } if(tgc.contains("Tablet")) { %>
                    <label class="checkbox"> <input type="checkbox" name="targetCategory" value="Tablet" checked="checked"> Tablet</label>
            <%  } else  { %>
                    <label class="checkbox"> <input type="checkbox" name="targetCategory" value="Tablet"> Tablet</label>
            <%  }  %>
        </aui:field-wrapper>
    </aui:fieldset>
  </aui:fieldset>
    <hr/>
         
  <aui:fieldset>
    <aui:fieldset>
        <aui:input name="firstPublishingDate"
            helpMessage="Geben sie das Datum der Erstver�ffentlichung an."
            model="<%=Application.class%>" value="<%=dobFirstPublishingDate%>"
            inputCssClass="aui-field-required" />

        <aui:input name="lastModifiedDate" 
            helpMessage="Tragen sie hier das Datum der aktuellsten Version der Anwendung ein."
            model="<%=Application.class%>" value="<%=dobLastModifiedDate%>"
            inputCssClass="aui-field-required" />
    </aui:fieldset> 
    
    <aui:fieldset column="true" style="margin-left: -5px; margin-top: 0px; margin-bottom: 0px; margin-right: 40px;">
        <aui:field-wrapper label="legalDetails" name="legalDetails"
            helpMessage="Tragen sie hier alle Angaben zum Anbieter der Anwendung ein. Beachten sie, dass jede registrierte Anwendung genau einen Anbieter besitzt, der die Zugriffsrechte zur Verwaltung des Angebotes besitzt."
            required="true">
            <textarea rows="4" name="legalDetails" maxlength="2000" cols="150"
                class="span5"><%=_legalDetails%></textarea>
        </aui:field-wrapper>
    </aui:fieldset>
    
    <aui:fieldset>
        <aui:field-wrapper label="developer" name="developer"
            helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
            required="true">
            <textarea rows="4" name="developer" maxlength="2000" cols="150"
                class="span5"><%=_developer%></textarea>
        </aui:field-wrapper>
    </aui:fieldset>
  </aui:fieldset>
    
    <hr/>
    
  <aui:fieldset>
    <aui:fieldset>
        <aui:field-wrapper label="category" name="category"
            helpMessage="Geben sie Die Kategorie an, in die die Anwendung eingegliedert werden kann( z.B. St�dte, Politik)"
            required="false">
            <%
                for (Category category : allCategories) {
                    if (selectedCategories.contains(category)) {
            %>
                        <label class="checkbox inline"> 
                          <input type="checkbox" checked="checked" name="category" value="<%=category.getCategoryId()%>" /><%= category.getCategoryName() %>
                        </label>
            <%
                    } else {
            %>
                        <label class="checkbox inline"> 
                          <input type="checkbox" name="category" value="<%=category.getCategoryId()%>" /><%= category.getCategoryName() %>
                        </label>
            <%
                    }
                }
            %>
        </aui:field-wrapper>

        <aui:field-wrapper label="region" name="region"
            helpMessage="W�hlen sie aus, auf welche geografische Region sich ihre Anwendung bezieht(z.B. Sachsen- Anhalt oder Bundesweit)"
            required="false">
            <%
                for (Region region : allRegions) {          
                    if (selectedRegions.contains(region)) {
            %>
                        <label class="checkbox inline"> 
                          <input type="checkbox" checked="checked" name="region" value="<%=region.getRegionId()%>" /><%= region.getName() %>
                        </label>
            <%
                    } else {
            %>
                        <label class="checkbox inline">
                         <input type="checkbox" name="region" value="<%=region.getRegionId()%>" /><%= region.getName() %>
                        </label>
            <%
                    }
                }
            %>
        </aui:field-wrapper>


        <aui:field-wrapper label="languages" name="languages"
            helpMessage="Geben sie die von der Anwendung unterst�tzten Sprachen ein."
            required="false">
<%
            for (Language language : allLanguages) {
                if (selectedLanguages.contains(language)) {
%>
                    <label class="checkbox inline"> 
                       <input type="checkbox" checked="checked" name="languages" value="<%= language.getLanguageId() %>" /><%= language.getLanguageName() %>
                    </label>                
<%
                } else {
%>
                    <label class="checkbox inline"> 
                       <input type="checkbox" name="languages" value="<%=language.getLanguageId()%>" /><%= language.getLanguageName() %>
                    </label>
<%
                }
            }
%>
        </aui:field-wrapper>
    </aui:fieldset>
  </aui:fieldset>
  
  <br />
  <hr />
  
  
   <aui:fieldset>
    <aui:fieldset>
        <aui:field-wrapper label="Verwendet Ihre App Datens&auml;tze vom GovData Portal? " name="open data" required="false">
            <div align="right"><a href="http://www.govdata.de" target="_blank" > <img src="/vepa-backend-theme/images/vepa-icons/govdata_logo.png" alt="govdata logo" ></a></div>
            
            <label class="checkbox">
              <input type="checkbox" name="cb_od" id="cb_od" onchange='checkedEBox()' >Ja.
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
            
                <div id="text"></div>
            </div>

        </aui:field-wrapper>
    </aui:fieldset>
  </aui:fieldset>
   
  <br />
  <hr />
          
  <aui:fieldset>
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
 
} catch (Exception e) {
    _log.debug(e.getMessage()); 
    e.printStackTrace();
}
%>
