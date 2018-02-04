package com.hjj.action;

import com.hjj.entity.User;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.UserService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/12/13.
 */
public class LoginAction extends BaseAction {

    @Autowired
    private UserService userService;

    public String login() {
        return SUCCESS;
    }

    public String doLogin(){
        printLog(dataJson);
        User user = JSONUtil.toBean(dataJson, User.class);
        if (!userService.checkLogin(user)){
            responseJsonMap = respondJsonMap(false);
        }else{
            session.put("username", user.getUsername());
            responseJsonMap = respondJsonMap();
        }
        return SUCCESS;
    }



}
