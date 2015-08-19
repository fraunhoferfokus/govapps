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
<%@page import="de.fraunhofer.fokus.movepla.portlets.AppConstants"%>
<%@ include file="../include.jsp"%>

<%
	Log _log = LogFactoryUtil.getLog("docroot.devel.view_jsp");

	String uname = user.getFullName();
	//User user = UserLocalServiceUtil.getUser(userId);
%>


<portlet:renderURL var="appURL">
	<portlet:param name="jspPage" value="/devel/view.jsp" />
	<portlet:param name="errorForward"
		value="/devel/view.jsp" />
	<portlet:param name="successForward" value="/devel/view.jsp" />
</portlet:renderURL>



<aui:script>
    Liferay.provide(
        window,
        'showSiteManagement',
        function() {
            var instance = this;

            var url='<%= AppConstants.WEB_ROOT %>/entwickler-profil';

                Liferay.Util.openWindow(
                    {
                        cache: false,
                        dialog: {
                            after: {
                                render: function(event) {
                                    this.set('y', this.get('y') + 50);
                                }
                            },
                            draggable: true,
                            modal: true, 
                            destroyOnClose: true,
                            width: 900
                        },
                        dialogIframe: {
                            id: 'siteManagementIframe',
                            uri: url
                        },
                        title: 'Profil',
                        uri: url,
                        width: 900
                    }
                );
        },
        ['liferay-util-window']
    );
    </aui:script>
    
<aui:script>
    Liferay.provide(
        window,
        'showSiteHelp',
        function() {
            var instance = this;

            var url='<%= AppConstants.WEB_ROOT %>/entwickler-hilfe';

                Liferay.Util.openWindow(
                    {
                        cache: false,
                        dialog: {
                            after: {
                                render: function(event) {
                                    this.set('y', this.get('y') + 50);
                                }
                            },
                            center: true,
                            draggable: true,
                            modal: true, 
                            destroyOnClose: true,
                            width: 900
                        },
                        dialogIframe: {
                            id: 'siteHelpIframe',
                            uri: url
                        },
                        title: 'Hilfe',
                        uri: url,
                        width: 900
                    }
                );
        },
        ['liferay-util-window']
    );
    </aui:script>


	<div
		style="margin: 10px 10px 10px auto !important; text-align: right; clear: both; vertical-align: bottom; padding: 10px 10px !important;">
		
		<div style="margin: 0 0 0 auto !important; clear: none; text-align: right; vertical-align: bottom;">
		Willkommen&nbsp;<strong><%=uname%></strong>!
		<a class="btn"
			href="<%= AppConstants.WEB_ROOT %>entwickler-profil" style="margin-left: 20px;"><i
			class="icon-user"></i>&nbsp;Profil</a> 
			<a class="btn"
			href="<%= AppConstants.WEB_ROOT %>entwickler-hilfe" style="margin-left: 20px;"><i
			class="icon-question-sign"></i>&nbsp;Hilfe</a>
		<a class="btn" href="/c/portal/logout"><i class="icon-hand-left"></i>&nbsp;Abmelden</a>
		</div>
	</div>
