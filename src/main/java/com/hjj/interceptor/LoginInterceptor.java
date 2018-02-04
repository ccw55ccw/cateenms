package com.hjj.interceptor;

import com.hjj.constants.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        ActionContext ctx = actionInvocation.getInvocationContext();
        Map session = ctx.getSession();
        String username = (String)session.get(Constants.SessionKey.username);
        if (username != null)
            return actionInvocation.invoke();
        ctx.put("tip", "你还没有登录");
        return Action.LOGIN;
    }
}
