<%--
  #%L
  govapps_data
  $Id: view.jsp 566 2014-11-13 15:22:01Z sma $
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

<portlet:actionURL name="redirectAction" var="addURL" >
    <portlet:param name="successForward" value="/form/add_application.jsp" />
    <portlet:param name="exceptionForward" value="/form/error.jsp" />        
</portlet:actionURL>

<p>Der Markt f&uuml;r mobile Anwendungen w&auml;chst rasant, schon jeder 3.
    Deutsche ist Besitzer eines Smartphones. Zurzeit existieren mehr als
    1.000.000 Anwendungen (Apps) f&uuml;r mobile Endger&auml;te in verschiedenen
    Anwendungs-Stores, wie z.B. Apple-Store, Windows Phone Marketplace oder
    Google Play. Dies f&uuml;hrt dazu, dass die Nutzer zunehmend &uuml;berfordert
    sind, aus diesem gro&szlig;en Angebot n&uuml;tzliche Anwendungen herauszufinden.
    Auch die fehlende Regionalisierung, das Fehlen von themenbezogenen
    Anwendungen, mangelnde Produktinformationen, die un&uuml;bersichtlichen
    Zulassungskriterien der App-Store Betreiber sowie die M&ouml;glichkeit der
    Erhebung, Sammlung und Verarbeitung von sensiblen Daten durch Dritte
    verunsichert den Verbraucher zusehends.</p>

<p>Mit Hilfe der Plattform
    sollen diese bekannten Risiken und Problembereiche aktiv kompensiert
    und das Bewusstsein der Nutzer in Bezug auf die Gefahr und Auswirkungen
    des Umgangs mit mobilen Endger&auml;ten sensibilisiert werden. Einerseits
    werden datenschutzrelevante Informationen in der Plattform
    nutzerfreundlich dargestellt, anderseits wird das Angebot an mobilen
    Anwendungen auf gemeinn&uuml;tzige Zwecke sowie auf die Unterst&uuml;tzung einer
    regionalisierten Suche fokussiert.</p>
<p>Wir danken Ihnen vorab f&uuml;r Ihr Interesse und Ihrer Registrierung.
    Sollten Sie dennoch Fragen oder Anmerkungen haben, wenden Sie sich
    bitte per E-Mail Martin.Ulbrich@fokus.fraunhofer.de oder per Telefon
    unter der Nummer +49 (0)30/3463-7360 vertrauensvoll an uns.</p>


<input type="button"
    value="<liferay-ui:message key="Anwendung eintragen" />"
    onClick="location.href = '<%= addURL.toString() %>';" />
