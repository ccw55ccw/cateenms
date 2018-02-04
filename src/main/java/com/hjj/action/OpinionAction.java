package com.hjj.action;

import com.hjj.entity.Opinion;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.OpinionService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OpinionAction extends BaseAction {

    @Autowired
    private OpinionService opinionService;

    /**
     * 食堂意见信息首页
     * @return
     */
    public String index() {
        List<Opinion> opinions = opinionService.list();
        request.setAttribute("opinions", opinions);
        return SUCCESS;
    }

    /**
     * 到更新食堂意见信息页面
     * @return
     */
    public String base(){
        Opinion opinionId = JSONUtil.toBean(dataJson, Opinion.class);
        Opinion opinion = opinionService.get(opinionId.getId());
        request.setAttribute("opinion", opinion);
        return SUCCESS;
    }

    /**
     * 获取某个食堂意见信息
     * @return
     */
    public String get(){
        Opinion opinionId = JSONUtil.toBean(dataJson, Opinion.class);
        Opinion opinion = opinionService.get(opinionId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("opinion", opinion);
        return SUCCESS;
    }

    /**
     * 增加食堂意见信息
     * @return
     */
    public String add(){
        Opinion opinion = JSONUtil.toBean(dataJson, Opinion.class);
        opinionService.add(opinion);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂意见信息
     * @return
     */
    public String delete(){
        Opinion opinion = JSONUtil.toBean(dataJson, Opinion.class);
        opinionService.delete(opinion);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂意见信息
     * @return
     */
    public String update(){
        Opinion opinion = JSONUtil.toBean(dataJson, Opinion.class);
        opinionService.updateById(opinion);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


    ///////////////////////////////////////////

    public String fOpinion(){

        return SUCCESS;

    }


}
