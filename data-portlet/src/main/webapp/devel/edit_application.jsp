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
<%@include file="../include.jsp"%>


<noscript>
    <h1>
        <font color="#ff0000"> Diese Seite ben&ouml;tigt JavaScript. Bitte
           &auml;ndern Sie Ihre Browsereinstellungen. </font>
    </h1>
</noscript>

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
<liferay-ui:error key="error-saving-application"
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
	Log _log = LogFactoryUtil.getLog("docroot.devel.edit_application_jsp");

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

String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";
%>

<portlet:renderURL var="cancelURL">
    <portlet:param name="jspPage" value="/devel/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="developerUpdateApplicationAction" var="editURL">
    <portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/devel/edit_application.jsp" />
    <portlet:param name="errorForward" value="/devel/edit_application.jsp" />        
</portlet:actionURL>


<portlet:actionURL name="applicationRedirectWId" var="Anwendung_editieren">
    <portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/devel/edit_application.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Links_editieren">
	<portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/devel/edit_applicationLinks.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Bilder_editieren">
	<portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/devel/edit_application3.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />        
</portlet:actionURL>

<portlet:actionURL name="applicationRedirectWId" var="Berechtigungen_editieren">
	<portlet:param name="applicationId" value="<%=String.valueOf(_application.getApplicationId())%>" />
    <portlet:param name="successForward" value="/devel/edit_applicationEntitlemets.jsp" />
    <portlet:param name="exceptionForward" value="/devel/error.jsp" />        
</portlet:actionURL>




<div class="page-header">

        <small>
            <a onClick="location.href = '<%=cancelURL.toString()%>'" class="btn btn-mini">&lt;&lt;zur&uuml;ck zur &Uuml;bersicht</a>
        </small>
    	<h1>Anwendung bearbeiten 
			<a
				onClick="location.href = '<%=Anwendung_editieren.toString()%>'"
				class="btn btn-mini" disabled="disabled">Details</a>
			<a onClick="location.href = '<%=Links_editieren.toString()%>'"
				class="btn btn-mini">Links</a>
			<a onClick="location.href = '<%=Bilder_editieren.toString()%>'"
				class="btn btn-mini">Bilder</a>
			<a
				onClick="location.href = '<%=Berechtigungen_editieren.toString()%>'"
				class="btn btn-mini">Berechtigungen</a>
	</h1>
</div>




<h2>Anwendungsdetails:</h2>
<div class="well well-small">
	Das Fragezeichen <img src="<%=helpHREF%>"> gibt Hinweise zu den
	einzelnen Datenfeldern.
</div>
<div class="alert">
    <a type="button" class="close" data-dismiss="alert">X</a>
    <strong>Hinweis:</strong> Eine &Auml;nderung dieser Seiten erfordert eine Freigabe durch den Seitenbetreiber! 
 </div>



<aui:form id="fm" name="fm" action="<%=editURL.toString()%>"
	enctype="multipart/form-data" method="post">

	<aui:fieldset>
<!-- 
		<aui:input name="applicationId" type="hidden"
			value="< % =_application.getApplicationId()%>" />
 -->
		<aui:input name="relatedApplicationId" type="hidden"
			value="<%=_application.getRelatedApplicationId()%>" />

		<aui:input name="status" type="hidden"
			value="<%=_application.getLifeCycleStatus()%>" />

		<aui:fieldset>

			<aui:field-wrapper label="Anwendungsname" name="name"
				helpMessage="Tragen-sie-hier-den-Namen-oder-den-Titel-der-Anwendung-ein"
				required="true">

				<input name="name" type="text" maxlength="75"
					value="<%=_application.getName()%>" class="span6" />
			</aui:field-wrapper>


			<%
				String rowHREF = "";
					if (_application.getLogoImageId() != 0 ) {
						   DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(_application.getLogoImageId());
						   rowHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + "0" + StringPool.SLASH + HttpUtil.encodeURL(fe.getTitle(), true);
					}
					
			%>


			<aui:fieldset column="true" style="margin-left: -5px;">

				<aui:input label="icon" name="file" type="file"
					helpMessage="Laden sie hier das Logo der Anwendung hoch. Es sollte z.B. 72*72 Pixel gro&szlig; sein."
					width="200" multiple="true" cssClass="input-medium"
					inputCssClass="btn" />
				<p class="text-info">Die maximale Dateigr&ouml;&szlig;e betr&auml;gt 100kB</p>


			</aui:fieldset>
			<aui:fieldset>
				<br />
				<div style="max-height: 72px;">
					<img class="img-rounded" style="height: 72px;" src="<%=rowHREF%>">
				</div>
			</aui:fieldset>

		</aui:fieldset>


		<aui:fieldset column="true"
			style="margin-left: -10px; margin-top: 5px; margin-bottom: 5px; margin-right: 40px;">

			<aui:field-wrapper label="description" name="description"
				helpMessage="Beschreiben sie hier ihre Anwendung, bez&uuml;glich Anwendungsfunktionalität und Angaben zum Einsatzzweck."
				required="true">
				<input id="description" name="description" type="text" style="display:none;"/>								
			</aui:field-wrapper>
			
			<liferay-ui:input-editor name="descriptionEditor"
                 toolbarSet="<%=AppConstants.EDITOR_TOOLBAR_STYLE%>" initMethod="initEditor" width="200"  cssClass="span6"
                 height="200" />
             <script type="text/javascript">
                 function <portlet:namespace />initEditor() { return "<%=_application.getDescription() =="" ? UnicodeFormatter.toString("Beschreiben sie hier ihre Anwendung, bez�glich Anwendungsfunktionalit�t und Angaben zum Einsatzzweck.") : UnicodeFormatter.toString(_application.getDescription())%>"; }
             </script>
		</aui:fieldset>


		<aui:fieldset>

			<!-- div class="input-append">
			<aui:input name="size" type="int"
				helpMessage="Geben sie hier eine Angabe zur Menge der bei der Installation zu �bertragenen Informationen der Anwendung ein."
				suffix="Eurocent" width="200" maxlength="6" />
		</div-->
			<br />
			<br />

			<aui:field-wrapper label="Gr&ouml;&szlig;e" name="size"
				helpMessage="Geben sie hier eine Angabe zur Menge der bei der Installation zu &uuml;bertragenen Informationen der Anwendung ein."
				inlineField="true">

				<div class="input-append">
					<input class="span2" name="size" maxlength="6"
						value="<%=_application.getSize()%>" type="text"><span
						class="add-on">kB</span>
				</div>
			</aui:field-wrapper>

			<aui:field-wrapper label="Kosten" name="fee"
				helpMessage="Geben sie hier den Preis ein, der f&uuml;r den Bezug der Anwendung zu entrichten ist.">

				<div class="input-append">
					<input class="span2" name="fee" maxlength="6"
						value="<%=_application.getFee()%>" type="text"><span
						class="add-on">ct.</span>
				</div>
			</aui:field-wrapper>

			<aui:field-wrapper label="platform" name="platform" required="true"
				helpMessage="Geben sie die Zielplattform an (z.B. IOS, Android, Windows, BlackBerry, Ubuntu, Webapp), sollten sie die Anwendung f&uuml;r mehrere Zielplattformen imlementiert haben, so k&ouml;nnen sie am Ende die eingegebenen Daten f&uuml;r weitere Zielplattformen &uuml;bernehmen">

				<select class="span2" name="platform">

					<%
					String tgs = _application.getTargetOS();
					_log.debug("tgs: " + tgs);

					String[] targets = new String[] {"Webapp", "Android", "iOS", "Windows", "BlackBerry", "Ubuntu"};

					for (int i = 0; i < targets.length; i++) {
						String target = targets[i];
						if (tgs.trim().equalsIgnoreCase(target)) {
					%>
    					<option selected="selected"><%=target%></option>
					<%
						} else {
					%>
	   				    <option><%=target%></option>
					<%
						}
					}
					%>
				</select>

			</aui:field-wrapper>


			<aui:field-wrapper label="targetCategory" name="targetCategory"
				helpMessage="Geben sie die Endgerätekategorie an (z.B. Smartphone, Tablet)"
				required="true">

				<%
					String tgc = _application.getTargetCategory();
					_log.debug("tgc: " + tgc);

					String[] targets = new String[] { "Tablet",	"Smartphone" };

					for (int i = 0; i < targets.length; i++) {
						String target = targets[i];
						if (tgc.trim().toLowerCase().equalsIgnoreCase(target.toLowerCase()) || tgc.toLowerCase().contains(target.toLowerCase())) {
				%>
        				    <label class="checkbox"> <input type="checkbox"
        					name="targetCategory" checked="checked" value="<%=target%>"><%=target%></label>
        		<%
        		  		} else {
				%>
				            <label class="checkbox"> <input type="checkbox"
					       name="targetCategory" value="<%=target%>"><%=target%></label>
				<%
			            }
					}
				%>
			</aui:field-wrapper>

		</aui:fieldset>

	</aui:fieldset>
	<hr />
	<aui:fieldset>

		<aui:fieldset>

			<%
				Calendar dob = CalendarFactoryUtil.getCalendar();
							dob.setTime(_application.getFirstPublishingDate());
			%>

			<aui:input name="firstPublishingDate"
				helpMessage="Geben sie das Datum der Erstver&ouml;ffentlichung an."
				model="<%=Application.class%>" value="<%=dob%>"
				inputCssClass="aui-field-required" />

			<%
				Calendar dob2 = CalendarFactoryUtil.getCalendar();
							dob2.setTime(_application.getLastModifiedDate());
			%>

			<aui:input name="lastModifiedDate"
				helpMessage="Tragen sie hier das Datum der aktuellsten Version der Anwendung ein."
				model="<%=Application.class%>" value="<%=dob2%>"
				inputCssClass="aui-field-required" />


		</aui:fieldset>


		<aui:fieldset column="true"
			style="margin-left: -5px; margin-top: 0px; margin-bottom: 0px; margin-right: 40px;">

			<aui:field-wrapper label="legalDetails" name="legalDetails"
				helpMessage="Tragen sie hier alle Angaben zum Anbieter der Anwendung ein. Beachten sie, dass jede registrierte Anwendung genau einen Anbieter besitzt, der die Zugriffsrechte zur Verwaltung des Angebotes besitzt."
				required="true">

				<textarea rows="4" name="legalDetails" maxlength="2000" cols="150"
					class="input-xlarge span5"><%=_application.getLegalDetails()%></textarea>

				<!-- aui:input required="true" label="" name="legalDetails"
				type="textarea" maxlength="2000" rows="4" cols="200"
				inputCssClass="aui-field-required"  /-->
			</aui:field-wrapper>

		</aui:fieldset>

		<aui:fieldset>

			<aui:field-wrapper label="developer" name="developer"
				helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
				required="true">

				<textarea rows="4" name="developer" maxlength="2000" cols="150"
					class="input-xlarge span5"><%=_application.getDeveloper()%></textarea>

				<!-- aui:input required="true" label="" name="developer" type="textarea"
				maxlength="2000" rows="4" cols="200"
				helpMessage="Geben sie hier ein paar Angaben zum Entwickler an."
				inputCssClass="aui-field-required"  /-->
			</aui:field-wrapper>

		</aui:fieldset>

	</aui:fieldset>


	<hr />

	<aui:fieldset>

		<aui:fieldset>

			<aui:field-wrapper label="category" name="category"
				helpMessage="Geben sie Die Kategorie an, in die die Anwendung eingegliedert werden kann( z.B. Städte, Politik)"
				required="false">

				<%
					for (Category category : allCategories) {

						if (selectedCategories.contains(category)) {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					checked="checked" name="category"
					value="<%=category.getCategoryId()%>" /><%=category.getCategoryName()%>
				</label>
				<%
					} else {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					name="category" value="<%=category.getCategoryId()%>" /><%=category.getCategoryName()%>
				</label>
				<%
					}
									}
				%>
			</aui:field-wrapper>


			<aui:field-wrapper label="region" name="region"
				helpMessage="Wählen sie aus, auf welche geografische Region sich ihre Anwendung bezieht(z.B. Sachsen- Anhalt oder Bundesweit)"
				required="false">
				<%
					for (Region region : allRegions) {
										if (selectedRegions.contains(region)) {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					checked="checked" name="region" value="<%=region.getRegionId()%>" /><%=region.getName()%>
				</label>
				<%
					} else {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					name="region" value="<%=region.getRegionId()%>" /><%=region.getName()%>
				</label>
				<%
					}
									}
				%>
			</aui:field-wrapper>


			<aui:field-wrapper label="languages" name="languages"
				helpMessage="Geben sie die von der Anwendung unterst&uuml;tzten Sprachen ein."
				required="false">

				<%
					for (Language language : allLanguages) {
										if (selectedLanguages.contains(language)) {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					checked="checked" name="languages"
					value="<%=language.getLanguageId()%>" /><%=language.getLanguageName()%>
				</label>

				<%
					} else {
				%>
				<label class="checkbox inline"> <input type="checkbox"
					name="languages" value="<%=language.getLanguageId()%>" /><%=language.getLanguageName()%>
				</label>
				<%
					}
									}
				%>
			</aui:field-wrapper>

		</aui:fieldset>


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
		
        <br />
        <hr />
		

<%@include file="agb_modal.jsp"%>
 
		<aui:button-row>

 <a href="#myModal" role="button" data-toggle="modal">
			<button class="btn btn-large btn-primary" value="next">Speichern</button></a>


			<!-- button class="btn btn-large btn-primary" onClick="fsub();">Speichern</a-->


		</aui:button-row>

	</aui:fieldset>

</aui:form>
