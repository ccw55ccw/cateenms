package com.hjj.action;

import com.hjj.entity.HealthScore;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.HealthScoreService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HealthScoreAction extends BaseAction {

    @Autowired
    private HealthScoreService healthScoreService;

    /**
     * 食堂卫生评分信息首页
     * @return
     */
    public String index() {
        List<HealthScore> healthScores = healthScoreService.list();
        request.setAttribute("healthScores", healthScores);
        return SUCCESS;
    }

    /**
     * 到更新食堂卫生评分信息页面
     * @return
     */
    public String base(){
        HealthScore healthScoreId = JSONUtil.toBean(dataJson, HealthScore.class);
        HealthScore healthScore = healthScoreService.get(healthScoreId.getId());
        request.setAttribute("healthScore", healthScore);
        return SUCCESS;
    }

    /**
     * 获取某个食堂卫生评分信息
     * @return
     */
    public String get(){
        HealthScore healthScoreId = JSONUtil.toBean(dataJson, HealthScore.class);
        HealthScore healthScore = healthScoreService.get(healthScoreId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("healthScore", healthScore);
        return SUCCESS;
    }

    /**
     * 增加食堂卫生评分信息
     * @return
     */
    public String add(){
        HealthScore healthScore = JSONUtil.toBean(dataJson, HealthScore.class);
        healthScoreService.add(healthScore);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂卫生评分信息
     * @return
     */
    public String delete(){
        HealthScore healthScore = JSONUtil.toBean(dataJson, HealthScore.class);
        healthScoreService.delete(healthScore);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂卫生评分信息
     * @return
     */
    public String update(){
        HealthScore healthScore = JSONUtil.toBean(dataJson, HealthScore.class);
        healthScoreService.updateById(healthScore);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
