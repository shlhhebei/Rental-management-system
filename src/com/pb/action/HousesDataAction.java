package com.pb.action;

import com.opensymphony.xwork2.ActionContext;
import com.pb.base.action.BaseAction;
import com.pb.service.IHouseService;
import com.pb.service.impl.IHouseServiceImpl;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class HousesDataAction extends BaseAction {
   private IHouseService service = new IHouseServiceImpl();
    public String findAllHouses() {
        Object[] objects = service.findALL();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("houses",objects);
        return SUCCESS;
    }
}
