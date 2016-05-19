package com.pb.action;

import com.opensymphony.xwork2.ActionContext;
import com.pb.base.action.BaseAction;
import com.pb.util.Page;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HouseListAction extends BaseAction {
    private Page page;
    public String displayHouses(){
        //获取一个request
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        Object[] houses = (Object[]) request.getAttribute("houses");
        List list = new ArrayList();
        for (int i = 0; i <houses.length; i++) {
            list.add(houses[i]);
        }
        page.setList(list);
        return SUCCESS;
    }

    /*setters and getters*/
    @Override
    public Page getPage() {
        return page;
    }

    @Override
    public void setPage(Page page) {
        this.page = page;
    }
}
