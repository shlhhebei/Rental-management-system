package com.pb.test;

import com.opensymphony.xwork2.ActionContext;
import com.pb.base.action.BaseAction;
import com.pb.entity.HouseUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试struts2的多种跳转方式
 */
public class TestAction extends BaseAction {
    public String testJump() {
        HouseUser houseUser = new HouseUser();
        houseUser.setUsername("accp");
        houseUser.setPassword("111111");
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        request.setAttribute("houseUser",houseUser);
        return SUCCESS;
    }
}
