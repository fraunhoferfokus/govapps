---
-- #%L
-- govapps_data
-- $Id:$
-- %%
-- Copyright (C) 2013 - 2014 Fraunhofer FOKUS / CC ÖFIT
-- %%
-- Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
-- All rights reserved.
-- Redistribution and use in source and binary forms, with or without modification,
-- are permitted provided that the following conditions are met:
-- 
-- 1) Redistributions of source code must retain the above copyright notice, 
--    this list of conditions and the following disclaimer.
-- 
-- 2) Redistributions in binary form must reproduce the above copyright notice, 
--    this list of conditions and the following disclaimer in the documentation 
--    and/or other materials provided with the distribution.
-- 
-- 3) All advertising materials mentioning features or use of this software must 
--    display the following acknowledgement: 
--    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
-- 
-- 4) Neither the name of the organization nor the names of its contributors may 
--    be used to endorse or promote products derived from this software without 
--    specific prior written permission.
-- 
-- THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
-- IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
-- MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
-- IN NO EVENT SHALL 
-- Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
-- BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
-- CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
-- GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
-- HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
-- LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
-- OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
-- #L%
---
create table mvp_Application (
	applicationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(3000) null,
	version VARCHAR(75) null,
	versionInformation VARCHAR(501) null,
	size_ INTEGER,
	firstPublishingDate DATE null,
	lastModifiedDate DATE null,
	logoImageId LONG,
	fee INTEGER,
	targetOS VARCHAR(500) null,
	minTargetOSVersion INTEGER,
	targetCategory VARCHAR(500) null,
	lifeCycleStatus INTEGER,
	verifiedDate DATE null,
	categoryString VARCHAR(3000) null,
	regionString VARCHAR(3000) null,
	lifeCycleStatusString VARCHAR(2000) null,
	legalDetails VARCHAR(2000) null,
	developer VARCHAR(2000) null,
	detailsViewed LONG,
	linkClicked LONG,
	useOpenData INTEGER,
	Sector VARCHAR(75) null,
	License VARCHAR(75) null,
	relatedApplicationId VARCHAR(500) null,
	newVersionId LONG,
	oldVersionId LONG
);

create table mvp_Application_Category (
	categoryId LONG not null,
	applicationId LONG not null,
	primary key (categoryId, applicationId)
);

create table mvp_Application_Entitlement (
	applicationEntitlementID LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	motivation VARCHAR(3000) null,
	applicationId LONG,
	entitlementId LONG
);

create table mvp_Application_Language (
	LanguageId LONG not null,
	applicationId LONG not null,
	primary key (LanguageId, applicationId)
);

create table mvp_Application_Region (
	regionId LONG not null,
	applicationId LONG not null,
	primary key (regionId, applicationId)
);

create table mvp_Category (
	categoryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null,
	parentCategory LONG
);

create table mvp_Entitlement (
	entitlementId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	entitlementName VARCHAR(75) null,
	explanation VARCHAR(1000) null,
	estimation VARCHAR(1000) null
);

create table mvp_Language (
	LanguageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	languageName VARCHAR(75) null,
	languageAbbreviation VARCHAR(75) null
);

create table mvp_LegalDetails (
	legalDetailsId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	valueAddedTaxNo VARCHAR(75) null,
	registrationCourt VARCHAR(75) null,
	legalForm VARCHAR(75) null,
	address VARCHAR(75) null,
	telephone VARCHAR(75) null,
	email VARCHAR(75) null,
	URL VARCHAR(75) null,
	fax VARCHAR(75) null
);

create table mvp_Link (
	linkId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	displayName VARCHAR(200) null,
	type_ INTEGER,
	url VARCHAR(500) null,
	applicationId LONG
);

create table mvp_Logging (
	loggingId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	isSimpleSearch BOOLEAN,
	searchString VARCHAR(75) null,
	categoryIDString VARCHAR(75) null,
	regionIDString VARCHAR(75) null,
	entitlementIDString VARCHAR(75) null,
	targetOS VARCHAR(75) null,
	fee INTEGER,
	targetCategory VARCHAR(75) null,
	passel LONG
);

create table mvp_MultiMedia (
	multiMediaId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	type_ INTEGER,
	imageId LONG,
	applicationId LONG
);

create table mvp_Region (
	regionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	ags INTEGER,
	coordniates_x DOUBLE,
	coordniates_y DOUBLE,
	parentRegion LONG
);

create table mvp_RelatedApplications (
	RelatedApplicationsID LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	applicationId LONG,
	applicationId2 LONG
);
