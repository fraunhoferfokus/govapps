package de.fraunhofer.fokus.movepla.service.base;

/*
 * #%L
 * govapps_data
 * $Id: Application_EntitlementLocalServiceBaseImpl.java 566 2014-11-13 15:22:01Z sma $
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

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import de.fraunhofer.fokus.movepla.model.Application_Entitlement;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalService;
import de.fraunhofer.fokus.movepla.service.ApplicationService;
import de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalService;
import de.fraunhofer.fokus.movepla.service.Application_EntitlementService;
import de.fraunhofer.fokus.movepla.service.CategoryLocalService;
import de.fraunhofer.fokus.movepla.service.CategoryService;
import de.fraunhofer.fokus.movepla.service.EntitlementLocalService;
import de.fraunhofer.fokus.movepla.service.EntitlementService;
import de.fraunhofer.fokus.movepla.service.LanguageLocalService;
import de.fraunhofer.fokus.movepla.service.LanguageService;
import de.fraunhofer.fokus.movepla.service.LegalDetailsLocalService;
import de.fraunhofer.fokus.movepla.service.LegalDetailsService;
import de.fraunhofer.fokus.movepla.service.LinkLocalService;
import de.fraunhofer.fokus.movepla.service.LinkService;
import de.fraunhofer.fokus.movepla.service.LoggingLocalService;
import de.fraunhofer.fokus.movepla.service.MultiMediaLocalService;
import de.fraunhofer.fokus.movepla.service.MultiMediaService;
import de.fraunhofer.fokus.movepla.service.OGPD_EntityLocalService;
import de.fraunhofer.fokus.movepla.service.OGPD_EntityService;
import de.fraunhofer.fokus.movepla.service.RegionLocalService;
import de.fraunhofer.fokus.movepla.service.RegionService;
import de.fraunhofer.fokus.movepla.service.RelatedApplicationsLocalService;
import de.fraunhofer.fokus.movepla.service.RelatedApplicationsService;
import de.fraunhofer.fokus.movepla.service.persistence.ApplicationPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.Application_EntitlementPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.CategoryPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.EntitlementPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LanguagePersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LegalDetailsPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LinkPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.LoggingPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.MultiMediaPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.RegionPersistence;
import de.fraunhofer.fokus.movepla.service.persistence.RelatedApplicationsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the application_ entitlement local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.fraunhofer.fokus.movepla.service.impl.Application_EntitlementLocalServiceImpl}.
 * </p>
 *
 * @author jpa
 * @see de.fraunhofer.fokus.movepla.service.impl.Application_EntitlementLocalServiceImpl
 * @see de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil
 * @generated
 */
public abstract class Application_EntitlementLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements Application_EntitlementLocalService,
        IdentifiableBean {
    @BeanReference(type = ApplicationLocalService.class)
    protected ApplicationLocalService applicationLocalService;
    @BeanReference(type = ApplicationService.class)
    protected ApplicationService applicationService;
    @BeanReference(type = ApplicationPersistence.class)
    protected ApplicationPersistence applicationPersistence;
    @BeanReference(type = Application_EntitlementLocalService.class)
    protected Application_EntitlementLocalService application_EntitlementLocalService;
    @BeanReference(type = Application_EntitlementService.class)
    protected Application_EntitlementService application_EntitlementService;
    @BeanReference(type = Application_EntitlementPersistence.class)
    protected Application_EntitlementPersistence application_EntitlementPersistence;
    @BeanReference(type = CategoryLocalService.class)
    protected CategoryLocalService categoryLocalService;
    @BeanReference(type = CategoryService.class)
    protected CategoryService categoryService;
    @BeanReference(type = CategoryPersistence.class)
    protected CategoryPersistence categoryPersistence;
    @BeanReference(type = EntitlementLocalService.class)
    protected EntitlementLocalService entitlementLocalService;
    @BeanReference(type = EntitlementService.class)
    protected EntitlementService entitlementService;
    @BeanReference(type = EntitlementPersistence.class)
    protected EntitlementPersistence entitlementPersistence;
    @BeanReference(type = LanguageLocalService.class)
    protected LanguageLocalService languageLocalService;
    @BeanReference(type = LanguageService.class)
    protected LanguageService languageService;
    @BeanReference(type = LanguagePersistence.class)
    protected LanguagePersistence languagePersistence;
    @BeanReference(type = LegalDetailsLocalService.class)
    protected LegalDetailsLocalService legalDetailsLocalService;
    @BeanReference(type = LegalDetailsService.class)
    protected LegalDetailsService legalDetailsService;
    @BeanReference(type = LegalDetailsPersistence.class)
    protected LegalDetailsPersistence legalDetailsPersistence;
    @BeanReference(type = LinkLocalService.class)
    protected LinkLocalService linkLocalService;
    @BeanReference(type = LinkService.class)
    protected LinkService linkService;
    @BeanReference(type = LinkPersistence.class)
    protected LinkPersistence linkPersistence;
    @BeanReference(type = LoggingLocalService.class)
    protected LoggingLocalService loggingLocalService;
    @BeanReference(type = LoggingPersistence.class)
    protected LoggingPersistence loggingPersistence;
    @BeanReference(type = MultiMediaLocalService.class)
    protected MultiMediaLocalService multiMediaLocalService;
    @BeanReference(type = MultiMediaService.class)
    protected MultiMediaService multiMediaService;
    @BeanReference(type = MultiMediaPersistence.class)
    protected MultiMediaPersistence multiMediaPersistence;
    @BeanReference(type = OGPD_EntityLocalService.class)
    protected OGPD_EntityLocalService ogpd_EntityLocalService;
    @BeanReference(type = OGPD_EntityService.class)
    protected OGPD_EntityService ogpd_EntityService;
    @BeanReference(type = RegionLocalService.class)
    protected RegionLocalService regionLocalService;
    @BeanReference(type = RegionService.class)
    protected RegionService regionService;
    @BeanReference(type = RegionPersistence.class)
    protected RegionPersistence regionPersistence;
    @BeanReference(type = RelatedApplicationsLocalService.class)
    protected RelatedApplicationsLocalService relatedApplicationsLocalService;
    @BeanReference(type = RelatedApplicationsService.class)
    protected RelatedApplicationsService relatedApplicationsService;
    @BeanReference(type = RelatedApplicationsPersistence.class)
    protected RelatedApplicationsPersistence relatedApplicationsPersistence;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private Application_EntitlementLocalServiceClpInvoker _clpInvoker = new Application_EntitlementLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link de.fraunhofer.fokus.movepla.service.Application_EntitlementLocalServiceUtil} to access the application_ entitlement local service.
     */

    /**
     * Adds the application_ entitlement to the database. Also notifies the appropriate model listeners.
     *
     * @param application_Entitlement the application_ entitlement
     * @return the application_ entitlement that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Application_Entitlement addApplication_Entitlement(
        Application_Entitlement application_Entitlement)
        throws SystemException {
        application_Entitlement.setNew(true);

        return application_EntitlementPersistence.update(application_Entitlement,
            false);
    }

    /**
     * Creates a new application_ entitlement with the primary key. Does not add the application_ entitlement to the database.
     *
     * @param applicationEntitlementID the primary key for the new application_ entitlement
     * @return the new application_ entitlement
     */
    public Application_Entitlement createApplication_Entitlement(
        long applicationEntitlementID) {
        return application_EntitlementPersistence.create(applicationEntitlementID);
    }

    /**
     * Deletes the application_ entitlement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicationEntitlementID the primary key of the application_ entitlement
     * @return the application_ entitlement that was removed
     * @throws PortalException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    public Application_Entitlement deleteApplication_Entitlement(
        long applicationEntitlementID) throws PortalException, SystemException {
        return application_EntitlementPersistence.remove(applicationEntitlementID);
    }

    /**
     * Deletes the application_ entitlement from the database. Also notifies the appropriate model listeners.
     *
     * @param application_Entitlement the application_ entitlement
     * @return the application_ entitlement that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    public Application_Entitlement deleteApplication_Entitlement(
        Application_Entitlement application_Entitlement)
        throws SystemException {
        return application_EntitlementPersistence.remove(application_Entitlement);
    }

    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Application_Entitlement.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return application_EntitlementPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return application_EntitlementPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return application_EntitlementPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return application_EntitlementPersistence.countWithDynamicQuery(dynamicQuery);
    }

    public Application_Entitlement fetchApplication_Entitlement(
        long applicationEntitlementID) throws SystemException {
        return application_EntitlementPersistence.fetchByPrimaryKey(applicationEntitlementID);
    }

    /**
     * Returns the application_ entitlement with the primary key.
     *
     * @param applicationEntitlementID the primary key of the application_ entitlement
     * @return the application_ entitlement
     * @throws PortalException if a application_ entitlement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Application_Entitlement getApplication_Entitlement(
        long applicationEntitlementID) throws PortalException, SystemException {
        return application_EntitlementPersistence.findByPrimaryKey(applicationEntitlementID);
    }

    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return application_EntitlementPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the application_ entitlements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of application_ entitlements
     * @param end the upper bound of the range of application_ entitlements (not inclusive)
     * @return the range of application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public List<Application_Entitlement> getApplication_Entitlements(
        int start, int end) throws SystemException {
        return application_EntitlementPersistence.findAll(start, end);
    }

    /**
     * Returns the number of application_ entitlements.
     *
     * @return the number of application_ entitlements
     * @throws SystemException if a system exception occurred
     */
    public int getApplication_EntitlementsCount() throws SystemException {
        return application_EntitlementPersistence.countAll();
    }

    /**
     * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param application_Entitlement the application_ entitlement
     * @return the application_ entitlement that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Application_Entitlement updateApplication_Entitlement(
        Application_Entitlement application_Entitlement)
        throws SystemException {
        return updateApplication_Entitlement(application_Entitlement, true);
    }

    /**
     * Updates the application_ entitlement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param application_Entitlement the application_ entitlement
     * @param merge whether to merge the application_ entitlement with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
     * @return the application_ entitlement that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Application_Entitlement updateApplication_Entitlement(
        Application_Entitlement application_Entitlement, boolean merge)
        throws SystemException {
        application_Entitlement.setNew(false);

        return application_EntitlementPersistence.update(application_Entitlement,
            merge);
    }

    /**
     * Returns the application local service.
     *
     * @return the application local service
     */
    public ApplicationLocalService getApplicationLocalService() {
        return applicationLocalService;
    }

    /**
     * Sets the application local service.
     *
     * @param applicationLocalService the application local service
     */
    public void setApplicationLocalService(
        ApplicationLocalService applicationLocalService) {
        this.applicationLocalService = applicationLocalService;
    }

    /**
     * Returns the application remote service.
     *
     * @return the application remote service
     */
    public ApplicationService getApplicationService() {
        return applicationService;
    }

    /**
     * Sets the application remote service.
     *
     * @param applicationService the application remote service
     */
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * Returns the application persistence.
     *
     * @return the application persistence
     */
    public ApplicationPersistence getApplicationPersistence() {
        return applicationPersistence;
    }

    /**
     * Sets the application persistence.
     *
     * @param applicationPersistence the application persistence
     */
    public void setApplicationPersistence(
        ApplicationPersistence applicationPersistence) {
        this.applicationPersistence = applicationPersistence;
    }

    /**
     * Returns the application_ entitlement local service.
     *
     * @return the application_ entitlement local service
     */
    public Application_EntitlementLocalService getApplication_EntitlementLocalService() {
        return application_EntitlementLocalService;
    }

    /**
     * Sets the application_ entitlement local service.
     *
     * @param application_EntitlementLocalService the application_ entitlement local service
     */
    public void setApplication_EntitlementLocalService(
        Application_EntitlementLocalService application_EntitlementLocalService) {
        this.application_EntitlementLocalService = application_EntitlementLocalService;
    }

    /**
     * Returns the application_ entitlement remote service.
     *
     * @return the application_ entitlement remote service
     */
    public Application_EntitlementService getApplication_EntitlementService() {
        return application_EntitlementService;
    }

    /**
     * Sets the application_ entitlement remote service.
     *
     * @param application_EntitlementService the application_ entitlement remote service
     */
    public void setApplication_EntitlementService(
        Application_EntitlementService application_EntitlementService) {
        this.application_EntitlementService = application_EntitlementService;
    }

    /**
     * Returns the application_ entitlement persistence.
     *
     * @return the application_ entitlement persistence
     */
    public Application_EntitlementPersistence getApplication_EntitlementPersistence() {
        return application_EntitlementPersistence;
    }

    /**
     * Sets the application_ entitlement persistence.
     *
     * @param application_EntitlementPersistence the application_ entitlement persistence
     */
    public void setApplication_EntitlementPersistence(
        Application_EntitlementPersistence application_EntitlementPersistence) {
        this.application_EntitlementPersistence = application_EntitlementPersistence;
    }

    /**
     * Returns the category local service.
     *
     * @return the category local service
     */
    public CategoryLocalService getCategoryLocalService() {
        return categoryLocalService;
    }

    /**
     * Sets the category local service.
     *
     * @param categoryLocalService the category local service
     */
    public void setCategoryLocalService(
        CategoryLocalService categoryLocalService) {
        this.categoryLocalService = categoryLocalService;
    }

    /**
     * Returns the category remote service.
     *
     * @return the category remote service
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * Sets the category remote service.
     *
     * @param categoryService the category remote service
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Returns the category persistence.
     *
     * @return the category persistence
     */
    public CategoryPersistence getCategoryPersistence() {
        return categoryPersistence;
    }

    /**
     * Sets the category persistence.
     *
     * @param categoryPersistence the category persistence
     */
    public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    /**
     * Returns the entitlement local service.
     *
     * @return the entitlement local service
     */
    public EntitlementLocalService getEntitlementLocalService() {
        return entitlementLocalService;
    }

    /**
     * Sets the entitlement local service.
     *
     * @param entitlementLocalService the entitlement local service
     */
    public void setEntitlementLocalService(
        EntitlementLocalService entitlementLocalService) {
        this.entitlementLocalService = entitlementLocalService;
    }

    /**
     * Returns the entitlement remote service.
     *
     * @return the entitlement remote service
     */
    public EntitlementService getEntitlementService() {
        return entitlementService;
    }

    /**
     * Sets the entitlement remote service.
     *
     * @param entitlementService the entitlement remote service
     */
    public void setEntitlementService(EntitlementService entitlementService) {
        this.entitlementService = entitlementService;
    }

    /**
     * Returns the entitlement persistence.
     *
     * @return the entitlement persistence
     */
    public EntitlementPersistence getEntitlementPersistence() {
        return entitlementPersistence;
    }

    /**
     * Sets the entitlement persistence.
     *
     * @param entitlementPersistence the entitlement persistence
     */
    public void setEntitlementPersistence(
        EntitlementPersistence entitlementPersistence) {
        this.entitlementPersistence = entitlementPersistence;
    }

    /**
     * Returns the language local service.
     *
     * @return the language local service
     */
    public LanguageLocalService getLanguageLocalService() {
        return languageLocalService;
    }

    /**
     * Sets the language local service.
     *
     * @param languageLocalService the language local service
     */
    public void setLanguageLocalService(
        LanguageLocalService languageLocalService) {
        this.languageLocalService = languageLocalService;
    }

    /**
     * Returns the language remote service.
     *
     * @return the language remote service
     */
    public LanguageService getLanguageService() {
        return languageService;
    }

    /**
     * Sets the language remote service.
     *
     * @param languageService the language remote service
     */
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * Returns the language persistence.
     *
     * @return the language persistence
     */
    public LanguagePersistence getLanguagePersistence() {
        return languagePersistence;
    }

    /**
     * Sets the language persistence.
     *
     * @param languagePersistence the language persistence
     */
    public void setLanguagePersistence(LanguagePersistence languagePersistence) {
        this.languagePersistence = languagePersistence;
    }

    /**
     * Returns the legal details local service.
     *
     * @return the legal details local service
     */
    public LegalDetailsLocalService getLegalDetailsLocalService() {
        return legalDetailsLocalService;
    }

    /**
     * Sets the legal details local service.
     *
     * @param legalDetailsLocalService the legal details local service
     */
    public void setLegalDetailsLocalService(
        LegalDetailsLocalService legalDetailsLocalService) {
        this.legalDetailsLocalService = legalDetailsLocalService;
    }

    /**
     * Returns the legal details remote service.
     *
     * @return the legal details remote service
     */
    public LegalDetailsService getLegalDetailsService() {
        return legalDetailsService;
    }

    /**
     * Sets the legal details remote service.
     *
     * @param legalDetailsService the legal details remote service
     */
    public void setLegalDetailsService(LegalDetailsService legalDetailsService) {
        this.legalDetailsService = legalDetailsService;
    }

    /**
     * Returns the legal details persistence.
     *
     * @return the legal details persistence
     */
    public LegalDetailsPersistence getLegalDetailsPersistence() {
        return legalDetailsPersistence;
    }

    /**
     * Sets the legal details persistence.
     *
     * @param legalDetailsPersistence the legal details persistence
     */
    public void setLegalDetailsPersistence(
        LegalDetailsPersistence legalDetailsPersistence) {
        this.legalDetailsPersistence = legalDetailsPersistence;
    }

    /**
     * Returns the link local service.
     *
     * @return the link local service
     */
    public LinkLocalService getLinkLocalService() {
        return linkLocalService;
    }

    /**
     * Sets the link local service.
     *
     * @param linkLocalService the link local service
     */
    public void setLinkLocalService(LinkLocalService linkLocalService) {
        this.linkLocalService = linkLocalService;
    }

    /**
     * Returns the link remote service.
     *
     * @return the link remote service
     */
    public LinkService getLinkService() {
        return linkService;
    }

    /**
     * Sets the link remote service.
     *
     * @param linkService the link remote service
     */
    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }

    /**
     * Returns the link persistence.
     *
     * @return the link persistence
     */
    public LinkPersistence getLinkPersistence() {
        return linkPersistence;
    }

    /**
     * Sets the link persistence.
     *
     * @param linkPersistence the link persistence
     */
    public void setLinkPersistence(LinkPersistence linkPersistence) {
        this.linkPersistence = linkPersistence;
    }

    /**
     * Returns the logging local service.
     *
     * @return the logging local service
     */
    public LoggingLocalService getLoggingLocalService() {
        return loggingLocalService;
    }

    /**
     * Sets the logging local service.
     *
     * @param loggingLocalService the logging local service
     */
    public void setLoggingLocalService(LoggingLocalService loggingLocalService) {
        this.loggingLocalService = loggingLocalService;
    }

    /**
     * Returns the logging persistence.
     *
     * @return the logging persistence
     */
    public LoggingPersistence getLoggingPersistence() {
        return loggingPersistence;
    }

    /**
     * Sets the logging persistence.
     *
     * @param loggingPersistence the logging persistence
     */
    public void setLoggingPersistence(LoggingPersistence loggingPersistence) {
        this.loggingPersistence = loggingPersistence;
    }

    /**
     * Returns the multi media local service.
     *
     * @return the multi media local service
     */
    public MultiMediaLocalService getMultiMediaLocalService() {
        return multiMediaLocalService;
    }

    /**
     * Sets the multi media local service.
     *
     * @param multiMediaLocalService the multi media local service
     */
    public void setMultiMediaLocalService(
        MultiMediaLocalService multiMediaLocalService) {
        this.multiMediaLocalService = multiMediaLocalService;
    }

    /**
     * Returns the multi media remote service.
     *
     * @return the multi media remote service
     */
    public MultiMediaService getMultiMediaService() {
        return multiMediaService;
    }

    /**
     * Sets the multi media remote service.
     *
     * @param multiMediaService the multi media remote service
     */
    public void setMultiMediaService(MultiMediaService multiMediaService) {
        this.multiMediaService = multiMediaService;
    }

    /**
     * Returns the multi media persistence.
     *
     * @return the multi media persistence
     */
    public MultiMediaPersistence getMultiMediaPersistence() {
        return multiMediaPersistence;
    }

    /**
     * Sets the multi media persistence.
     *
     * @param multiMediaPersistence the multi media persistence
     */
    public void setMultiMediaPersistence(
        MultiMediaPersistence multiMediaPersistence) {
        this.multiMediaPersistence = multiMediaPersistence;
    }

    /**
     * Returns the o g p d_ entity local service.
     *
     * @return the o g p d_ entity local service
     */
    public OGPD_EntityLocalService getOGPD_EntityLocalService() {
        return ogpd_EntityLocalService;
    }

    /**
     * Sets the o g p d_ entity local service.
     *
     * @param ogpd_EntityLocalService the o g p d_ entity local service
     */
    public void setOGPD_EntityLocalService(
        OGPD_EntityLocalService ogpd_EntityLocalService) {
        this.ogpd_EntityLocalService = ogpd_EntityLocalService;
    }

    /**
     * Returns the o g p d_ entity remote service.
     *
     * @return the o g p d_ entity remote service
     */
    public OGPD_EntityService getOGPD_EntityService() {
        return ogpd_EntityService;
    }

    /**
     * Sets the o g p d_ entity remote service.
     *
     * @param ogpd_EntityService the o g p d_ entity remote service
     */
    public void setOGPD_EntityService(OGPD_EntityService ogpd_EntityService) {
        this.ogpd_EntityService = ogpd_EntityService;
    }

    /**
     * Returns the region local service.
     *
     * @return the region local service
     */
    public RegionLocalService getRegionLocalService() {
        return regionLocalService;
    }

    /**
     * Sets the region local service.
     *
     * @param regionLocalService the region local service
     */
    public void setRegionLocalService(RegionLocalService regionLocalService) {
        this.regionLocalService = regionLocalService;
    }

    /**
     * Returns the region remote service.
     *
     * @return the region remote service
     */
    public RegionService getRegionService() {
        return regionService;
    }

    /**
     * Sets the region remote service.
     *
     * @param regionService the region remote service
     */
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    /**
     * Returns the region persistence.
     *
     * @return the region persistence
     */
    public RegionPersistence getRegionPersistence() {
        return regionPersistence;
    }

    /**
     * Sets the region persistence.
     *
     * @param regionPersistence the region persistence
     */
    public void setRegionPersistence(RegionPersistence regionPersistence) {
        this.regionPersistence = regionPersistence;
    }

    /**
     * Returns the related applications local service.
     *
     * @return the related applications local service
     */
    public RelatedApplicationsLocalService getRelatedApplicationsLocalService() {
        return relatedApplicationsLocalService;
    }

    /**
     * Sets the related applications local service.
     *
     * @param relatedApplicationsLocalService the related applications local service
     */
    public void setRelatedApplicationsLocalService(
        RelatedApplicationsLocalService relatedApplicationsLocalService) {
        this.relatedApplicationsLocalService = relatedApplicationsLocalService;
    }

    /**
     * Returns the related applications remote service.
     *
     * @return the related applications remote service
     */
    public RelatedApplicationsService getRelatedApplicationsService() {
        return relatedApplicationsService;
    }

    /**
     * Sets the related applications remote service.
     *
     * @param relatedApplicationsService the related applications remote service
     */
    public void setRelatedApplicationsService(
        RelatedApplicationsService relatedApplicationsService) {
        this.relatedApplicationsService = relatedApplicationsService;
    }

    /**
     * Returns the related applications persistence.
     *
     * @return the related applications persistence
     */
    public RelatedApplicationsPersistence getRelatedApplicationsPersistence() {
        return relatedApplicationsPersistence;
    }

    /**
     * Sets the related applications persistence.
     *
     * @param relatedApplicationsPersistence the related applications persistence
     */
    public void setRelatedApplicationsPersistence(
        RelatedApplicationsPersistence relatedApplicationsPersistence) {
        this.relatedApplicationsPersistence = relatedApplicationsPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        PersistedModelLocalServiceRegistryUtil.register("de.fraunhofer.fokus.movepla.model.Application_Entitlement",
            application_EntitlementLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "de.fraunhofer.fokus.movepla.model.Application_Entitlement");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
    }

    protected Class<?> getModelClass() {
        return Application_Entitlement.class;
    }

    protected String getModelClassName() {
        return Application_Entitlement.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = application_EntitlementPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
