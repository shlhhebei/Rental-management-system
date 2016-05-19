package com.pb.service;

import com.pb.entity.HouseUser;

import java.util.Map;

public interface IUserService {

	/**
	 * 登录
	 * @param user 从页面获取的用户信息
	 * @return
	 */
	Map<String,Object> login(HouseUser user);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	 boolean doRegister(HouseUser user);
	
	/**
	 * 验证
	 * @param name
	 * @return
	 */
	 boolean validate(String name);
	
	/**
	 * 根据Id获取user对象
	 * @param id
	 * @return
	 */
	 Object getUserById(Integer id);
}
