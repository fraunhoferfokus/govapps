package de.fraunhofer.fokus.movepla.search;

/*
 * #%L
 * govapps_data
 * $Id: ApplicationIndexer.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS / CC ÖFIT
 * %%
 * Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 * 2) Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 * 3) All advertising materials mentioning features or use of this software must 
 *    display the following acknowledgement: 
 *    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
 * 
 * 4) Neither the name of the organization nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL 
 * Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */


import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;
import de.fraunhofer.fokus.movepla.util.WebKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;

//import com.liferay.portal.kernel.exception.SystemException;
//import com.liferay.portal.kernel.search.BaseIndexer;
//import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
//import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
//import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;


public class ApplicationIndexer extends BaseIndexer {

	private static Log _log = LogFactoryUtil.getLog(ApplicationIndexer.class);

	public static final String[] CLASS_NAMES = {
		Application.class.getName()
    };
	
    public static final String PORTLET_ID = WebKeys.PORTLET_ID;

    
	public String[] getClassNames() {	
		_log.debug("getClassNames(): " + CLASS_NAMES);
		return CLASS_NAMES;
	}

	
	public String getPortletId() {
		_log.debug("getPortletId()");
		return PORTLET_ID;
	}

	
	@Override
	protected void doDelete(Object obj) throws Exception {
		_log.debug("doDelete()");
        Application application = (Application) obj;
//        Document document = new DocumentImpl();
//        document.addUID(PORTLET_ID, application.getPrimaryKey());
//        SearchEngineUtil.deleteDocument(application.getCompanyId(), document.get(Field.UID));	
        deleteDocument(application.getCompanyId(), application.getPrimaryKey());
	}

	
	@Override
	protected Document doGetDocument(Object obj) throws Exception {
//		_log.debug("doGetDocument()");
		Application application = (Application) obj;
        long companyId = application.getCompanyId();
//        long groupId = getParentGroupId(application.getGroupId());
//        long scopeGroupId = application.getGroupId();
//        long groupId = 20102;
//        long scopeGroupId = 20102;
      
        long userId = application.getUserId();
        long resourcePrimKey = application.getPrimaryKey();
        String title = application.getName().toLowerCase();
        String content = "";
        String description = application.getDescription().toLowerCase();
        String regions = application.getRegionString().toLowerCase();
        String categoryString = application.getCategoryString().toLowerCase();
        String targetOS = application.getTargetOS().toLowerCase();
        content = content + " " + application.getRegionString().toLowerCase();
        content = content + " " + application.getCategoryString().toLowerCase();
        content = content + " " + application.getTargetOS().toLowerCase();
//        content = content + " " + application.getMinTargetOSVersion();

        
        Date modifiedDate = application.getModifiedDate();

       long[] assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(Application.class.getName(), resourcePrimKey);
       
       List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(Application.class.getName(), resourcePrimKey);

       String[] assetCategoryNames = StringUtil.split(ListUtil.toString(categories, "name"));
       
       // EE lets you do this quicker: 
       
       // String[] assetCategoryNames =
       //     AssetCategoryLocalServiceUtil.getCategoryNames(
       //         Slogan.class.getName(), resourcePrimKey);
       
       String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(Application.class.getName(), resourcePrimKey);

        Document document = new DocumentImpl();

        document.addUID(PORTLET_ID, resourcePrimKey);

        document.addDate("modifiedDate", modifiedDate);
        document.addKeyword(Field.COMPANY_ID, companyId);
        document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
//        document.addKeyword(Field.GROUP_ID, groupId);
//        document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
        document.addKeyword(Field.USER_ID, userId);
        document.addText(Field.TITLE, title);
        document.addText(Field.CONTENT, content);
        document.addText(Field.DESCRIPTION, description);
        document.addText("regions", regions);
        document.addText("categoryString", categoryString);
        document.addText("targetOS", targetOS);
        document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
        document.addKeyword("assetCategoryNames", assetCategoryNames);
        //document.addKeyword(Field.ASSET_CATEGORY_NAMES, assetCategoryNames);
        document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);
        document.addKeyword(Field.ENTRY_CLASS_NAME, Application.class.getName());
        document.addKeyword(Field.ENTRY_CLASS_PK, resourcePrimKey);
        
        return document;
	}

	
	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {
		_log.debug("doGetSummary()");
		String title = document.get(Field.TITLE);
		String content = snippet;
		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);
			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.DESCRIPTION), 200);
			}
		}
        String resourcePrimKey = document.get(Field.ENTRY_CLASS_PK);

        portletURL.setParameter("jspPage", "/devel/view.jsp");
        portletURL.setParameter("resourcePrimKey", resourcePrimKey);

        return new Summary(title, content, portletURL);
	}

	
	@Override
	protected void doReindex(Object obj) throws Exception {
		_log.debug("doReindex()");
		Application application = (Application) obj;
        Document document = getDocument(application);
        SearchEngineUtil.updateDocument(application.getCompanyId(), document);      
	}

	
	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Application application = ApplicationLocalServiceUtil.getApplication(classPK);
        doReindex(application);		
	}
	

	@Override
	protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);
        reIndexApplications(companyId);		
	}

	
    protected void reIndexApplications(long companyId) throws Exception {
        int count = ApplicationLocalServiceUtil.getApplicationsCount();
        int pages = count / Indexer.DEFAULT_INTERVAL;
        for (int i = 0; i <= pages; i++) {
            int start = (i * Indexer.DEFAULT_INTERVAL);
            int end = start + Indexer.DEFAULT_INTERVAL;
            reIndexApplications(companyId, start, end);
        }
    }

	
    protected void reIndexApplications(long companyId, int start, int end) throws Exception {

        List<Application> applications = ApplicationLocalServiceUtil.getApplications(start, end);
        if (applications.isEmpty()) {
            return;
        }
        Collection<Document> documents = new ArrayList<Document>();
        for (Application application : applications) {
            Document document = getDocument(application);
            documents.add(document);
        }
        SearchEngineUtil.updateDocuments(companyId, documents);
    }    
    
    
	@Override
	protected String getPortletId(SearchContext searchContext) {
		_log.debug("getPortletId()");
		return PORTLET_ID;
	}
	

}
