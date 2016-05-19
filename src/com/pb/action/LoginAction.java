package com.pb.action;

import com.pb.base.action.BaseAction;
import com.pb.entity.HouseUser;
import com.pb.service.IUserService;
import com.pb.service.impl.IUserServiceImpl;

/**
 *登陆操作类
 * 可以验证用户是否存在，密码是否正确
 */
public class LoginAction extends BaseAction {
    IUserService service = new IUserServiceImpl();
    HouseUser houseUser;
    public String login() {
        //用于测试的代码
       /* HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        houseUser = (HouseUser) request.getAttribute("houseUser");*/
        if (service.validate(houseUser.getUsername())) {
            HouseUser user = (HouseUser) service.login(houseUser).get("user");
            if (service.login(houseUser).size() != 0 && houseUser.getPassword().equals(user.getPassword())) {
                service.login(houseUser);
                session.put("user", user);
                return SUCCESS;
            }
            //添加actionMessage，在转发的页面可以使用<s:actionMessage/>接收
            addActionMessage("密码不正确");
            return LOGIN;
        } else {
            addActionMessage("用户名不存在");
            return LOGIN;
        }
    }

    public HouseUser getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(HouseUser houseUser) {
        this.houseUser = houseUser;
    }

    public IUserService getService() {
        return service;
    }

    public void setService(IUserService service) {
        this.service = service;
    }
}
