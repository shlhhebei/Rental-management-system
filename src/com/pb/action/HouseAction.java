package com.pb.action;

import com.pb.base.action.BaseAction;

/**
 *显示某房屋的具体信息
 */
public class HouseAction extends BaseAction {
    public String show() {
        System.out.println("显示房屋具体信息");
        return SUCCESS;
    }

}
