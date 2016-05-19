package com.pb.base.dao;

import com.pb.util.Page;
import org.hibernate.Session;

import java.util.List;

public interface IBaseDao<T> {
	Session getSession();
	
	void closeSession();
	
	void save(T instances);
	
	void delete(T instances);
	
	void update(T instances);

	@SuppressWarnings("rawtypes")
	Object findById(Class clazz, Integer id) ;

	/**
	 * 查询所有用户列表
	 */
	List<T> findAll();

	/**
	 * 查询所有用户列表
	 * @param clazz 传入对象的Class对象
	 */
	@SuppressWarnings("rawtypes")
	 List<Object> findAll(Class clazz);

	/**
	 * 根据HQL查询数据
	 * @param hql 查询数据的HQL
	 * @return 实体对象列表
	 */
	@SuppressWarnings("rawtypes")
	 List findByHql(String hql) ;

	/**
	 * 根据对象名和对象属性获取对象集合
	 * @param className 对象名
	 * @param propertyName 属性名
	 * @param value 传入的一个参数
	 * @return 实体对象列表
	 */
	 List<T> findByProperty(String className, String propertyName, Object value);

	/**
	 * 实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @return Object[0]当前页的数据列表List、Object[1]总页数、Object[2]总记录数
	 */
	 Object[] findPageByHql(final String hql, String hqlCount, final int page, final int pageSize);
	
	/**
	 * 获取分页对象，实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @return Page对象 包含当前页的数据列表List、总页数、总数量和页数集合
	 */
	 Page findPageByHql(final String hql, String hqlCount, Page page);
}