package com.pb.service.impl;

import com.pb.dao.House_userDao;
import com.pb.dao.impl.House_userDaoImpl;
import com.pb.entity.HouseUser;
import com.pb.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *登录，注册，验证，根据id获取对象
 */
public class IUserServiceImpl implements IUserService {
    House_userDao userDao = new House_userDaoImpl();
    List<HouseUser> result = null;

    /**
     * 登录
     * @param user 从页面获取的用户信息
     * @return 包含数据的map对象
     */
    @Override
    public Map<String, Object> login(HouseUser user) {
        Map<String, Object> session = new HashMap<>();
            for (HouseUser user1 : result) {
                if (user1.getPassword().equals(user.getPassword())) {
                    session.put("user", user1);
                }
            }
        return session;
    }

    /**
     * 注册
     * @param user 从页面获取的用户信息
     * @return boolean
     */
    @Override
    public boolean doRegister(HouseUser user) {
        if (validate(user.getUsername())) {
            System.out.println("用户名已经存在");
            return false;
        }
        userDao.save(user);
        return true;
    }

    /**
     * 验证
     * @param name 传入的用户名
     * @return boolean对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean validate(String name) {
        String className = "HouseUser";
        String propertyName = "username";
        result = (List<HouseUser>) userDao.findByProperty(className, propertyName, name);
        if (result.size()>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据Id获取user对象
     * @param id 用户id
     * @return 用户实体对象
     */
    @Override
    public HouseUser getUserById(Integer id) {
       return (HouseUser)userDao.findById(HouseUser.class,id);
    }

    /*getters and setters*/

    public List<HouseUser> getResult() {
        return result;
    }

    public void setResult(List<HouseUser> result) {
        this.result = result;
    }

    public House_userDao getUserDao() {
        return userDao;
    }

    public void setUserDao(House_userDao userDao) {
        this.userDao = userDao;
    }
}
