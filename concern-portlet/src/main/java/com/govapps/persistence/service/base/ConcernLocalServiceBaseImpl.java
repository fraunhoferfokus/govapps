package com.govapps.persistence.service.base;

/*
 * #%L
 * govapps_concern
 * $Id: ConcernLocalServiceBaseImpl.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
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

import com.govapps.persistence.model.Concern;
import com.govapps.persistence.service.ConcernLocalService;
import com.govapps.persistence.service.ConcernService;
import com.govapps.persistence.service.persistence.ConcernPersistence;

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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the concern local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.govapps.persistence.service.impl.ConcernLocalServiceImpl}.
 * </p>
 *
 * @author ekl
 * @see com.govapps.persistence.service.impl.ConcernLocalServiceImpl
 * @see com.govapps.persistence.service.ConcernLocalServiceUtil
 * @generated
 */
public abstract class ConcernLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements ConcernLocalService, IdentifiableBean {
    @BeanReference(type = ConcernLocalService.class)
    protected ConcernLocalService concernLocalService;
    @BeanReference(type = ConcernService.class)
    protected ConcernService concernService;
    @BeanReference(type = ConcernPersistence.class)
    protected ConcernPersistence concernPersistence;
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
    private ConcernLocalServiceClpInvoker _clpInvoker = new ConcernLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.govapps.persistence.service.ConcernLocalServiceUtil} to access the concern local service.
     */

    /**
     * Adds the concern to the database. Also notifies the appropriate model listeners.
     *
     * @param concern the concern
     * @return the concern that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Concern addConcern(Concern concern) throws SystemException {
        concern.setNew(true);

        return concernPersistence.update(concern, false);
    }

    /**
     * Creates a new concern with the primary key. Does not add the concern to the database.
     *
     * @param id the primary key for the new concern
     * @return the new concern
     */
    public Concern createConcern(long id) {
        return concernPersistence.create(id);
    }

    /**
     * Deletes the concern with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the concern
     * @return the concern that was removed
     * @throws PortalException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    public Concern deleteConcern(long id)
        throws PortalException, SystemException {
        return concernPersistence.remove(id);
    }

    /**
     * Deletes the concern from the database. Also notifies the appropriate model listeners.
     *
     * @param concern the concern
     * @return the concern that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    public Concern deleteConcern(Concern concern) throws SystemException {
        return concernPersistence.remove(concern);
    }

    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Concern.class,
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
        return concernPersistence.findWithDynamicQuery(dynamicQuery);
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
        return concernPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
        return concernPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return concernPersistence.countWithDynamicQuery(dynamicQuery);
    }

    public Concern fetchConcern(long id) throws SystemException {
        return concernPersistence.fetchByPrimaryKey(id);
    }

    /**
     * Returns the concern with the primary key.
     *
     * @param id the primary key of the concern
     * @return the concern
     * @throws PortalException if a concern with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Concern getConcern(long id) throws PortalException, SystemException {
        return concernPersistence.findByPrimaryKey(id);
    }

    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return concernPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the concerns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of concerns
     * @param end the upper bound of the range of concerns (not inclusive)
     * @return the range of concerns
     * @throws SystemException if a system exception occurred
     */
    public List<Concern> getConcerns(int start, int end)
        throws SystemException {
        return concernPersistence.findAll(start, end);
    }

    /**
     * Returns the number of concerns.
     *
     * @return the number of concerns
     * @throws SystemException if a system exception occurred
     */
    public int getConcernsCount() throws SystemException {
        return concernPersistence.countAll();
    }

    /**
     * Updates the concern in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param concern the concern
     * @return the concern that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Concern updateConcern(Concern concern) throws SystemException {
        return updateConcern(concern, true);
    }

    /**
     * Updates the concern in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param concern the concern
     * @param merge whether to merge the concern with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
     * @return the concern that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    public Concern updateConcern(Concern concern, boolean merge)
        throws SystemException {
        concern.setNew(false);

        return concernPersistence.update(concern, merge);
    }

    /**
     * Returns the concern local service.
     *
     * @return the concern local service
     */
    public ConcernLocalService getConcernLocalService() {
        return concernLocalService;
    }

    /**
     * Sets the concern local service.
     *
     * @param concernLocalService the concern local service
     */
    public void setConcernLocalService(ConcernLocalService concernLocalService) {
        this.concernLocalService = concernLocalService;
    }

    /**
     * Returns the concern remote service.
     *
     * @return the concern remote service
     */
    public ConcernService getConcernService() {
        return concernService;
    }

    /**
     * Sets the concern remote service.
     *
     * @param concernService the concern remote service
     */
    public void setConcernService(ConcernService concernService) {
        this.concernService = concernService;
    }

    /**
     * Returns the concern persistence.
     *
     * @return the concern persistence
     */
    public ConcernPersistence getConcernPersistence() {
        return concernPersistence;
    }

    /**
     * Sets the concern persistence.
     *
     * @param concernPersistence the concern persistence
     */
    public void setConcernPersistence(ConcernPersistence concernPersistence) {
        this.concernPersistence = concernPersistence;
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
        PersistedModelLocalServiceRegistryUtil.register("com.govapps.persistence.model.Concern",
            concernLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.govapps.persistence.model.Concern");
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
        return Concern.class;
    }

    protected String getModelClassName() {
        return Concern.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = concernPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
