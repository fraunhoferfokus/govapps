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
create index IX_6F1816CA on mvp_Application (companyId);
create index IX_F09C7482 on mvp_Application (companyId, lifeCycleStatus);
create index IX_E05F0504 on mvp_Application (companyId, userId);
create index IX_FB5FDFB8 on mvp_Application (detailsViewed);
create index IX_BC05DDDF on mvp_Application (linkClicked);
create index IX_C2CD6C69 on mvp_Application (modifiedDate);
create index IX_643730C3 on mvp_Application (modifiedDate, lifeCycleStatus);
create index IX_8370F74D on mvp_Application (useOpenData);

create index IX_B6B77DF0 on mvp_Application_Category (applicationId);
create index IX_874D2198 on mvp_Application_Category (categoryId);

create index IX_BF54F63C on mvp_Application_Entitlement (companyId);
create index IX_14CF06BF on mvp_Application_Entitlement (companyId, applicationId);
create index IX_4F99B139 on mvp_Application_Entitlement (companyId, applicationId, entitlementId);
create index IX_FCD1381C on mvp_Application_Entitlement (companyId, entitlementId);

create index IX_83863FEC on mvp_Application_Language (LanguageId);
create index IX_8017E6D6 on mvp_Application_Language (applicationId);

create index IX_5FE3F8FA on mvp_Application_Region (applicationId);
create index IX_35E4FE84 on mvp_Application_Region (regionId);

create unique index IX_685EC419 on mvp_Category (categoryName);
create index IX_8FAA19EC on mvp_Category (companyId);
create index IX_AF351128 on mvp_Category (companyId, parentCategory);

create index IX_36AB1E0D on mvp_Entitlement (companyId);

create index IX_49BEE5D2 on mvp_Language (companyId);
create unique index IX_7682D14D on mvp_Language (languageName);

create index IX_401A8F81 on mvp_LegalDetails (companyId);

create index IX_233F38C3 on mvp_Link (applicationId);
create index IX_6F73E470 on mvp_Link (companyId);
create index IX_D2D76A0B on mvp_Link (companyId, applicationId);
create index IX_F79AE1D on mvp_Link (type_);

create index IX_4170522B on mvp_Logging (categoryIDString);
create index IX_AEBE825C on mvp_Logging (entitlementIDString);
create index IX_FBC26B69 on mvp_Logging (fee);
create index IX_DD0F99D9 on mvp_Logging (passel);
create index IX_DA9E5061 on mvp_Logging (regionIDString);
create index IX_A7B7C9BA on mvp_Logging (searchString);
create index IX_B9D8B133 on mvp_Logging (searchString, categoryIDString, regionIDString, entitlementIDString, targetOS, fee, targetCategory);
create index IX_88644A50 on mvp_Logging (targetCategory);
create index IX_C68CB996 on mvp_Logging (targetOS);

create index IX_E9F8A4B2 on mvp_MultiMedia (applicationId);
create index IX_6DE69FDF on mvp_MultiMedia (companyId);
create index IX_3D7682BC on mvp_MultiMedia (companyId, applicationId);
create index IX_FF3D2A4A on mvp_MultiMedia (companyId, applicationId, imageId);
create index IX_3E1076FD on mvp_MultiMedia (imageId);

create index IX_6149D1B6 on mvp_Region (companyId);
create index IX_792061E8 on mvp_Region (companyId, parentRegion);
create unique index IX_2847C171 on mvp_Region (name);

create index IX_E0AE7E3F on mvp_RelatedApplications (applicationId);
create index IX_35216977 on mvp_RelatedApplications (applicationId2);
create index IX_3D7947EC on mvp_RelatedApplications (companyId);
create index IX_45A71F0F on mvp_RelatedApplications (companyId, applicationId);
create index IX_6F3CE2A7 on mvp_RelatedApplications (companyId, applicationId2);
