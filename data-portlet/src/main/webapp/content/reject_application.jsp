<%--
  #%L
  govapps_data
  $Id: reject_application.jsp 566 2014-11-13 15:22:01Z sma $
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
            Diese Seite ben&ouml;tigt JavaScript. Bitte &auml;ndern Sie Ihre Browsereinstellungen.
        </font>
    </h1>
</noscript>



<liferay-ui:error key="error-rejecting-application"
    message="error-rejecting-application" />

<%
Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.content.reject_application_jsp");

Application _application = null;
String _reason = "";
_application = (Application) request.getAttribute("application");
String applicationIdString = String.valueOf(_application.getApplicationId());

_log.debug("applicationIdString: " + applicationIdString);

%>
<portlet:renderURL var="cancelURL">
    <portlet:param name="jspPage" value="<%= viewJSP %>" />
</portlet:renderURL>

<portlet:actionURL name="applicationActionRejectApplication" var="rejectURL">
    <portlet:param name="applicationId" value="<%= applicationIdString %>" />
    <portlet:param name="successForward" value="<%=viewJSP%>" />
    <portlet:param name="errorForward" value="<%=rejectApplicationJSP%>" />
</portlet:actionURL>



<%
try {
    String helpHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + themeDisplay.getPathThemeRoot() + "images/portlet/help.png";
/*    
    String pre_mailBody = "Sehr%20geehrter%20Herr%2F%20Frau%20" + UserLocalServiceUtil.fetchUser(_application.getUserId()).getLastName() + ",%0A%0A" +
    	    "vielen%20Dank%20f%FCr%20die%20Registrierung%20Ihrer%20App%20bei%20GovApps.%20Leider%20konnten%20wir%20Ihre%20App%20noch%20nicht%20freischalten,%20da%20Sie%20wichtige%20Registrierungsschritte%20nicht%20oder%20unvollst%E4ndig%20ausgef%FChrt%20haben.%0A%0A" +
    		"Wir%20bitten%20Sie%20deshalb%20die%20Angaben%20Ihrer%20App%20auf%20Vollst%E4ndigkeit%20zu%20pr%FCfen.%20Ohne%20das%20vollst%E4ndige%20Ausf%FCllen%20der%20Beschreibungsdatenfelder%20kann%20die%20App%20nicht%20auf%20GovApps%20freigegeben%20werden.%0A%0A"  +
    		"Bitte%20pr%FCfen%20Sie%20noch%20einmal,%20ob%20Sie%0A";
*/
    String pre_mailBody = "Sehr geehrter Herr/ Frau " + UserLocalServiceUtil.fetchUser(_application.getUserId()).getLastName() + "," + 
    		"%0A%0Avielen Dank f�r die Registrierung Ihrer App bei GovApps. %0ALeider konnten wir Ihre App noch nicht freischalten," + 
    		"%0Ada Sie wichtige Registrierungsschritte nicht oder unvollst�ndig ausgef�hrt haben." +
    		"%0A%0AWir bitten Sie deshalb die Angaben Ihrer App auf Vollst�ndigkeit zu pr�fen." +
    		"%0AOhne das vollst�ndige Ausf�llen der Beschreibungsdatenfelder kann die App nicht auf GovApps freigegeben werden." + 
    		"%0A%0ABitte pr�fen Sie noch einmal, ob Sie";
    String emailAddress = "";
    emailAddress = UserLocalServiceUtil.fetchUser(_application.getUserId()).getEmailAddress();
%>
	<b>Beschreiben Sie welche Informationen zur Freigabe noch fehlen.<br />
		
	<aui:form
	    name="fm"
	    action="<%= rejectURL.toString() %>"
	    method="post">
		
		
	    <aui:fieldset>
	        <aui:field-wrapper label="fehlende Informationen" name="developer"
	            helpMessage="Beschreiben Sie welche Informationen zur Freigabe noch fehlen."
	            required="true">
	            <textarea rows="4" name="reason" maxlength="2000" cols="150" id="_reason"
	                class="input-large span5">Beschreiben Sie welche Informationen zur Freigabe noch fehlen. z.B. fehlende Berechtigungen, falsche Links, etc.</textarea>
	        </aui:field-wrapper>
	    </aui:fieldset>
	    
	    Es fehlen/ sind falsch: <br /> 
	    <label class="checkbox">
          <input type="checkbox" name="logo" id="logo" onClick='checkedLogoBox()'>das Logo, 
        </label>
        <br/>
        <label class="checkbox">
          <input type="checkbox" name="screenshots" id="screenshots" onClick='checkedScreenshotsBox()'>die Screenshots, 
        </label>
        <br/>
        <label class="checkbox">
          <input type="checkbox" name="links" id="links" onClick='checkedLinksBox()'>die Links, 
        </label>
        <br/>
        <label class="checkbox">
          <input type="checkbox" name="berechtigungen" id="berechtigungen" onClick='checkedBerechtigungenBox()'>die Berechtigungen,
        </label>
        <br/>
		    
        <br />
        <hr />
        <aui:fieldset>
		    <aui:button-row>
		        <aui:button type="submit" value="next"/>
		    </aui:button-row>  
		</aui:fieldset>
		        
		        
    <a  id="_mailto">Mail per externem MailProgramm vesenden</a>
		        
	</aui:form>
	<a class="btn btn-mini" type="button" onClick="location.href = '<%= cancelURL.toString() %>';" ><liferay-ui:message key="&lt;&lt;zur&uuml;ck zur &Uuml;bersicht" /></a>

<br />
<br />
<br />

<script type="text/javascript">

	var emailAddress = "<%=emailAddress%>";
	var pre_mailto = "mailto:" + emailAddress + "?cc=info@govapps.de&subject=Anfrage unvollst�ndiger Daten f�r GovApps&body=";
	
	var pre_mailBody = "<%=pre_mailBody%>";
		
	var checkedLogo = false;
	var checkedScreenshots = false;
	var checkedLinks = false;
	var checkedBerechtigungen = false;
	
	var mailBodyLogoValue = "";
	var mailBodyScreenshotsValue = "";
    var mailBodyLinksValue = "";
    var mailBodyBerechtigungenValue = "";
    var mailBodyBerechtigungenValue2 = "";

    var reasonLogoValue = "";
    var reasonScreenshotsValue = "";
    var reasonLinksValue = "";
    var reasonBerechtigungenValue = "";

//	var post_mailBody = "%0Avollst%E4ndig%20und%20richtig%20ausgef%FCllt%20haben.%0A%0ABei%20Fragen%20wenden%20Sie%20sich%20bitte%20an%20info@govapps.de%0A%0AMit%20freundlichen%20Gr%FC%DFen,";
    var post_mailBody = "%0Avollst�ndig und richtig ausgef�llt haben.";
    var post_mailBody2 = "%0A%0ABei Fragen wenden Sie sich bitte an info@govapps.de" +  
                         "%0A%0AMit freundlichen Gr��en,%0A";
    
	function checkedLogoBox() {
		
	    if (checkedLogo == false) {
//	    	mailBodyLogoValue = "das%20Logo%20Ihrer%20App,%20";
            mailBodyLogoValue = "%0Adas Logo Ihrer App,";
            reasonLogoValue = "das Logo der App, <br />";
	        checkedLogo = true;
	    }
	    else {
	        mailBodyLogoValue = "";
            reasonLogoValue = "";
	        checkedLogo = false;
	    }
	    var _mailtoValue = pre_mailto + pre_mailBody + mailBodyLogoValue +  mailBodyScreenshotsValue + mailBodyLinksValue + mailBodyBerechtigungenValue + post_mailBody + mailBodyBerechtigungenValue2 + post_mailBody2;
        setMailToValue(_mailtoValue);
        setReasonValue(reasonLogoValue +  reasonScreenshotsValue + reasonLinksValue + reasonBerechtigungenValue);	    
	}
	
	function checkedScreenshotsBox() {
	    if (checkedScreenshots == false) {
//	        mailBodyScreenshotsValue = "%20Screenshots%20der%20App%2DOberfl%E4che%20(die%20nicht%20das%20Logo%20sein%20sollte),%20";
            mailBodyScreenshotsValue = "%0AScreenshots der App Oberfl�che (die nicht das Logo sein sollte), ";
            reasonScreenshotsValue = "die Screenshots,<br />";
	        checkedScreenshots = true;
	    }
	    else {
	        mailBodyScreenshotsValue = "";
            reasonScreenshotsValue = "";
	        checkedScreenshots = false;
	    }
	    var _mailtoValue = pre_mailto + pre_mailBody + mailBodyLogoValue +  mailBodyScreenshotsValue + mailBodyLinksValue + mailBodyBerechtigungenValue + post_mailBody + mailBodyBerechtigungenValue2 + post_mailBody2;
        setMailToValue(_mailtoValue);
        setReasonValue(reasonLogoValue +  reasonScreenshotsValue + reasonLinksValue + reasonBerechtigungenValue);
	}
	
    function checkedLinksBox() {
        if (checkedLinks == false) {
        	mailBodyLinksValue = "%0ALinks, ";
        	reasonLinksValue = "die Links, <br />";
            checkedLinks = true;
        }
        else {
        	mailBodyLinksValue = "";
            reasonLinksValue = "";
            checkedLinks = false;
        }
        var _mailtoValue = pre_mailto + pre_mailBody + mailBodyLogoValue +  mailBodyScreenshotsValue + mailBodyLinksValue + mailBodyBerechtigungenValue + post_mailBody + mailBodyBerechtigungenValue2 + post_mailBody2;
        setMailToValue(_mailtoValue);
        setReasonValue(reasonLogoValue +  reasonScreenshotsValue + reasonLinksValue + reasonBerechtigungenValue);
    }
	
    function checkedBerechtigungenBox() {
        if (checkedBerechtigungen == false) {
//            mailBodyBerechtigungenValue = "%20die%20Berechtigungen,%20also%20die%20Zugriffe%20Ihrer%20Applikation%20auf%20Hard%2D%20und%20Softwarefunktion%20eines%20Smartphones%20";
        	mailBodyBerechtigungenValue = "%0Adie Berechtigungen, also die Zugriffe Ihrer Applikation auf Hard- und Softwarefunktion eines Smartphones ";
//        	mailBodyBerechtigungenValue2 = "Wenn%20eine%20App%20Zugriff%20auf%20Hard%2D%20und%20Softwarefunktion%20eines%20Smartphones%20(bspw.%20Netzwerkkommunikation,%20GPS%2DVerwendung,%20Kamerafunktion,%20o.%E4.)%20nutzt,%20" + 
//        		"muss%20der%20Zweck%20der%20Nutzung%20angegeben%20werden.%20Es%20m%FCssen%20alle%20Nutzungen%20und%20alle%20Zwecke%20vollst%E4ndig%20angegeben%20werden.%20" +  
//        		"Auf%20diese%20Basis%20kann%20der%20Nutzer%20entscheiden,%20ob%20er%20di%20Funktionalit%E4t%20oder%20die%20App%20insgesamt%20nutze%20m%F6chte.%0A"; 
            mailBodyBerechtigungenValue2 = "%0A%0AWenn eine App Zugriff auf Hard-  und Softwarefunktion eines smartphones (bspw. Netzwerkkommunikation, GPS-Verwendung, Kamerafunktion, o.�.) nutzt, " + 
            "%0Amuss der Zweck der Nutzung angegeben werden. Es m�ssen alle Nutzungen und alle Zwecke vollst�ndig angegeben werden. " +
            "%0AAuf diese Basis kann der Nutzer entscheiden, ob er die Funktionalit�t oder die App insgesamt nutze m�chte.%0A"; 
            reasonBerechtigungenValue = "die Berechtigungen<br / >";
            checkedBerechtigungen = true;
        }
        else {        	
        	mailBodyBerechtigungenValue = "";
        	mailBodyBerechtigungenValue2 = "";
        	reasonBerechtigungenValue = "";
            checkedBerechtigungen = false;
        }
        var _mailtoValue = pre_mailto + pre_mailBody + mailBodyLogoValue +  mailBodyScreenshotsValue + mailBodyLinksValue + mailBodyBerechtigungenValue + post_mailBody + mailBodyBerechtigungenValue2 + post_mailBody2;
        setMailToValue(_mailtoValue);
        setReasonValue(reasonLogoValue +  reasonScreenshotsValue + reasonLinksValue + reasonBerechtigungenValue);
    }
    
	
	function setMailToValue(mailtoValue) {
	    var _mailto = document.getElementById('_mailto');
	    _mailto.href = mailtoValue;	    
	}
	
    function setReasonValue(value) {
        document.getElementById("_reason").value = value;
    }

</script>       

	        
<% 
    
} catch (Exception e) {
    _log.debug(e.getMessage()); 
    e.printStackTrace();
}
%>


<!-- 
Anfrage unvollst�ndige Daten:

Sehr geehrter Herr/ Frau XXX, 
vielen Dank f�r die Registrierung Ihrer App bei GovApps. Leider konnten wir Ihre App noch nicht freischalten, 
da Sie wichtige Registrierungsschritte nicht oder unvollst�ndig ausgef�hrt haben.
Wir bitten Sie deshalb die Angaben Ihrer App auf Vollst�ndigkeit zu pr�fen. 
Ohne das vollst�ndige Ausf�llen der Beschreibungsdatenfelder kann die App nicht auf GovApps freigegeben werden. 
Bitte pr�fen Sie noch einmal, ob Sie 
das Logo Ihrer App, 
Screenshots der App-Oberfl�che (die nicht das Logo sein sollte) und 
Link(s) 
die Berechtigungen, also die Zugriffe Ihrer Applikation auf Hard- und Softwarefunktion eines Smartphones vollst�ndig und richtig ausgef�llt haben. 
Wenn eine App Zugriff auf Hard- und Softwarefunktion eines Smartphones  (bspw. Netzwerkkommunikation, GPS-Verwendung, Kamerafunktion, o.�.) nutzt, 
muss der Zweck der Nutzung  angegeben werden. Es m�ssen alle Nutzungen und alle Zwecke vollst�ndig angegeben werden.  
Auf dieser Basis kann der Nutzer entscheiden, ob er die Funktionalit�t oder die App insgesamt nutzen m�chte. 

Bei Fragen wenden Sie sich bitte an info@govapps.de 
Mit freundlichen Gr��en,

-->
