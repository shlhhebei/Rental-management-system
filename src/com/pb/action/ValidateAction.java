package com.pb.action;

import com.pb.base.action.BaseAction;
import com.pb.service.IUserService;
import com.pb.service.impl.IUserServiceImpl;

/**
 *
 */
public class ValidateAction extends BaseAction {
    private IUserService iUserService = new IUserServiceImpl();
    private String name;
    private boolean b;
    public String validateName(){
        boolean b1 = iUserService.validate(name);
        System.out.println(name);
        if (b1){
            b = false;
        }else {
            b = true;
        }
        return SUCCESS;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
