<%--
  #%L
  govapps_data
  $Id: application_icon.jsp 566 2014-11-13 15:22:01Z sma $
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

Log _log = LogFactoryUtil.getLog("de.fraunhofer.docroot.devel.application_icon_jsp");
try {

	long userId = com.liferay.portal.util.PortalUtil.getUserId(request);
	long roleId = RoleLocalServiceUtil.getRole(user.getCompanyId(), Constants.CONTENT_PROVIDER).getRoleId();		

		ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		Application myApplication = (Application) row.getObject();
		String name = Application.class.getName();
		String applicationId = String.valueOf(myApplication.getApplicationId());
	
	/*
		String tempImageFileEntryUrl = themeDisplay.getPortalURL() +
		themeDisplay.getPathContext() +
		"/image/" +
		themeDisplay.getScopeGroupId() +
		StringPool.SLASH +
		myApplication.getLogoImageId() ;
	*/
	String rowHREF = "";
    String rowHREF2 = "";
	DLFileEntry fe = null;
  _log.debug("myApplication.getLogoImageId(): " + myApplication.getLogoImageId() );
	if (myApplication.getLogoImageId() != 0) {
	    fe = DLFileEntryLocalServiceUtil.getDLFileEntry(myApplication.getLogoImageId());
	    DLFileShortcut sh = null;
	    FileEntry fe2 = DLAppLocalServiceUtil.getFileEntry(myApplication.getLogoImageId());
	    rowHREF2 = DLUtil.getThumbnailSrc(fe2, sh,themeDisplay);

	    _log.debug("thumbnail: " + rowHREF2 );
	    
//	    rowHREF = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + "0" + StringPool.SLASH + HttpUtil.encodeURL(fe.getTitle(), true);
//        _log.debug("original: " + rowHREF );
	}



		
		
		
%>
<!-- 
    <img width="72" height="72" src="/image/image_gallery?img_id=< % = myApplication.getLogoImageId() % >">
 -->    
    <img width="72" src="<%= rowHREF2 %>" >
    
<%		
} catch (Exception e) {
	e.printStackTrace();
	}
%>
    
