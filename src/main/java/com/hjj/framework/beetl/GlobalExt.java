package com.hjj.framework.beetl;

import com.hjj.framework.context.SpringContextHolder;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/28.
 */
public class GlobalExt implements WebRenderExt {

    private ReadConfigProperties readConfigProperties;

    @Override
    public void modify(Template template, GroupTemplate gt, HttpServletRequest request, HttpServletResponse response) {
        readConfigProperties = SpringContextHolder.getBean(ReadConfigProperties.class);
        Map<String, Object> map = readConfigProperties.getProperties();
        template.binding("username", request.getSession().getAttribute("username"));
        gt.setSharedVars(map);
    }
}
