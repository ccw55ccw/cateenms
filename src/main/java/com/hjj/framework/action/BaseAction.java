package com.hjj.framework.action;

import com.hjj.dao.UserDao;
import com.hjj.entity.User;
import com.hjj.framework.model.ResponseJsonMap;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/10.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware{

    private static final Log log = LogFactory.get();

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected Map<String, Object> session;

    protected ResponseJsonMap responseJsonMap;

    protected String dataJson;

    public final void printLog(String str) {
        printLog(str, "");
    }

    public final void printLog(String... str) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        sb.append("[class:").append(stacks[2].getClassName())
                .append(";method:")
                .append(stacks[2].getMethodName())
                .append("]");
        for (int i = 0; i < str.length; i++) {
            sb.append("{}");
        }
        log.info(sb.toString(), str);
    }

    public String index() {
        return SUCCESS;
    }

    public ResponseJsonMap getResponseJsonMap() {
        return responseJsonMap;
    }

    public void setResponseJsonMap(ResponseJsonMap responseJsonMap) {
        this.responseJsonMap = responseJsonMap;
    }

    public ResponseJsonMap respondJsonMap() {
        return respondJsonMap(true);
    }

    public ResponseJsonMap respondJsonMap(boolean isSuccess) {
        return new ResponseJsonMap(isSuccess);
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
