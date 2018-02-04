package com.hjj.action;

import com.hjj.framework.action.BaseAction;
import com.hjj.service.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/12/13.
 */
public class IndexAction extends BaseAction {

    @Autowired
    private FoodMenuService foodMenuService;

    public String index() {


        return SUCCESS;
    }

    public String front(){

        request.setAttribute("menus", foodMenuService.listShowMenu());

        return SUCCESS;
    }

    public String about(){

        return SUCCESS;
    }

    public String gallery(){

        return SUCCESS;
    }

}
