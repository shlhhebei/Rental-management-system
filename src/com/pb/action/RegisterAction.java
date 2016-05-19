package com.pb.action;

import com.pb.base.action.BaseAction;
import com.pb.entity.HouseUser;
import com.pb.service.IUserService;
import com.pb.service.impl.IUserServiceImpl;

/**
 *
 */
public class RegisterAction extends BaseAction {
    private IUserService iUserService = new IUserServiceImpl();
    private HouseUser houseUser;
    private String b;

    public String register() {
        /**
         * 在业务方法内实现验证，工作量大，但是灵活
         */
       /* if (null == houseUser.getUsername() || "".equals(houseUser.getUsername())){
            this.addFieldError("houseUser.username","用户名不能为空--业务方法");
        }
        if (null == houseUser.getPassword() || "".equals(houseUser.getPassword())){
            this.addFieldError("houseUser.password","密码不能为空--业务方法");
        }*/
        if (null != houseUser.getPassword() && !"".equals(houseUser.getPassword()) && iUserService.doRegister(houseUser)) {
            System.out.println("注册成功");
        }else {
            this.addActionError("用户名已经存在");
        }
       /* if (this.hasErrors()) {
            return INPUT;
        }*/
        return SUCCESS;
    }

    /**
     * 使用重写ActionSupport类的validate方法，在此方法内实现验证，使数据校验和业务处理分离开
     * 该方法会在业务方法之前被调用，当验证不通过的时候，业务处理方法不会被执行
     * 该方法对Action类中的所有业务方法都有效，调用任意业务方法都先调用该方法
     */
   /* @Override
    public void validate() {
        if (null == houseUser.getUsername() || "".equals(houseUser.getUsername())){
            this.addFieldError("houseUser.username","用户名不能为空--validate方法");
        }
        if (null == houseUser.getPassword() || "".equals(houseUser.getPassword())){
            this.addFieldError("houseUser.password","密码不能为空--validate方法");
        }
    }*/

    /**
     * 使用validateXXX方法，实现对单一业务方法进行验证，其他同validate方法
     * 注意： 这两种方法都得配置name= "input" 的Result
     */
   /* public void validateRegister() {
        if (null == houseUser.getUsername() || "".equals(houseUser.getUsername())){
            this.addFieldError("houseUser.username","用户名不能为空--validateXXX方法");
        }
        if (null == houseUser.getPassword() || "".equals(houseUser.getPassword())){
            this.addFieldError("houseUser.password","密码不能为空--validateXXX方法");
        }
    }*/

    /*setters and getters*/
    public HouseUser getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(HouseUser houseUser) {
        this.houseUser = houseUser;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }
}
