package com.hjj.action;

import com.hjj.entity.Rules;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.RulesService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/12/13.
 */
public class RulesAction extends BaseAction {

    @Autowired
    private RulesService rulesService;

    /**
     * 食堂制度首页
     * @return
     */
    public String index() {
        Rules rules = rulesService.getFirst();
        request.setAttribute("rules", rules);
        return SUCCESS;
    }

    /**
     * 到更新食堂制度页面
     * @return
     */
    public String base(){
        Rules rules = rulesService.getFirst();
        request.setAttribute("rules", rules);
        return SUCCESS;
    }

    /**
     * 更新食堂制度
     * @return
     */
    public String update(){
        Rules rules = JSONUtil.toBean(dataJson, Rules.class);
        rulesService.update(rules);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
