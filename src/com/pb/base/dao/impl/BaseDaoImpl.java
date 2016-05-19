package com.pb.base.dao.impl;

import com.pb.base.dao.IBaseDao;
import com.pb.util.HibernateSessionFactory;
import com.pb.util.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	private Log log = LogFactory.getLog(this.getClass());
	private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
    	entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}	
	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}

	/**
	 * 保存信息
	 * @param instance 传入的实体对象
	 */
	@Override
	public void save(T instance) {
		log.debug("saving "+instance+" instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(instance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("save failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}

	/**
	 * 删除某条数据
	 * @param instance 传入的实体对象
	 */
	@Override
	public void delete(T instance) {
		log.debug("deleting "+instance+" instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().delete(instance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}

	/**
	 * 更新数据
	 * @param instance 传入的实体对象
	 */
	@Override
	public void update(T instance) {
		log.debug("updating "+instance+" instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().update(instance);
			tx.commit();
			log.debug("update successful");
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("update failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}

	/**
	 * 根据Id查询信息
	 * @param clazz 对象的class对象
	 * @param id id数值
	 * @return 实体对象
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object findById(Class clazz, Integer id) {
		log.debug("getting "+clazz+" instance with id: " + id);
		try {
			//Hibernate.initialize(District.class);
			return getSession().get(clazz,id);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}

	/**
	 * 查询某表的所有数据
	 * @return 实体对象列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		log.debug("getting "+entityClass+" List All ");
		try {
			String hql = "FROM "+entityClass;
			Query queryObject = getSession().createQuery(hql);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by HQL ", re);
			throw re;
		} finally{
			closeSession();
		}
	}

	/**
	 * 查询某个表的所有数据
	 * @param clazz 传入对象的Class对象
	 * @return 实体对象列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findAll(Class clazz) {
		log.debug("getting "+clazz+" List All ");
		try {
			String c = clazz.toString();//toString()后的值：class com.pb.entity.House
			String hql = "FROM "+c.substring(c.lastIndexOf(".")+1,c.length());
			Query queryObject = getSession().createQuery(hql);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by HQL ", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	/**
	 * 根据对象名和对象属性查询数据
	 * @param className 对象名
	 * @param propertyName 属性名
	 * @param value where子句传入的参数
	 * @return 实体对象列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String className,String propertyName, Object value) {
		log.debug("finding "+className+" instance with property: " + propertyName + ", value: " + value);
		
		try {
			String hql = "FROM "+className+" as o WHERE o."+propertyName+" = ?";
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, value);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	/**
	 * 根据HQL查询数据
	 * @param hql  查询数据的HQL
	 * @return 实体对象列表
	 */
	@SuppressWarnings("rawtypes")
	public List findByHql(String hql) {
		log.debug(hql);
		try {
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by HQL ", re);
			throw re;
		} finally{
			//如果在方法内关闭session，则action类和视图层的关联对象的导航就会失效，使用spring管理项目的话，可以是使用
			//org.springframework.orm.hibernate3.support.OpenSessionInViewFilter过滤器，让视图层决定session的打开与关闭
			//closeSession();
		}
	}
	
	/**
	 * 获取分页对象，实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @param page 需要显示数据的页码
	 * @param pageSize 每页数据量
	 * @return Object[0]当前页的数据列表List ,Object[1]总页数，Object[2]总数量
	 */
	@SuppressWarnings("rawtypes")
	public Object[] findPageByHql(final String hql, String hqlCount, final int page, final int pageSize) {
		log.debug(hql);
		List list = new ArrayList();
		Long total = new Long(0);
		Integer totalPage = 0;
		try {
			//1、根据hql语句查询指定数据
			Query qList = getSession().createQuery(hql);
			qList.setFirstResult(page * pageSize);
			qList.setMaxResults(pageSize);
		    list = qList.list();
		    
			//2、根据hql语句查询总记录数
		    List listCount = findByHql(hqlCount);
			if(listCount!=null && listCount.size()>0){
				total = (Long)listCount.get(0);
			}
			
			//3、根据总记录数计算出总页数
			totalPage = (int) Math.ceil((double) total.longValue() / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
		return new Object[] { list, totalPage, total };
	}
	
	/**
	 * 获取分页对象，实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @param page 分页对象
	 * @return page 分页对象
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page findPageByHql(final String hql, String hqlCount, Page page) {
		log.debug(hql);
		try {
			if(page !=null){
				//1、根据hql语句查询指定数据
				Query qList = getSession().createQuery(hql);
				qList.setFirstResult(page.getStartRow());
				qList.setMaxResults(page.getSize());
			    page.setList(qList.list());//将数据集合保存到page对象
			    
				//2、根据hql语句查询总记录数
			    List listCount = findByHql(hqlCount);
				if(listCount!=null && listCount.size()>0){
					page.setTotalCount(Integer.parseInt(String.valueOf(listCount.get(0))));//将总记录数保存到page对象
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
		return page;
	}
	/*setters and getters*/

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
}