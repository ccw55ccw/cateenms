package com.hjj.action;

import com.hjj.entity.Finance;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.FinanceService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FinanceAction extends BaseAction {

    @Autowired
    private FinanceService financeService;

    /**
     * 食堂财务信息首页
     * @return
     */
    public String index() {
        List<Finance> finances = financeService.list();
        request.setAttribute("finances", finances);
        return SUCCESS;
    }

    /**
     * 到更新食堂财务信息页面
     * @return
     */
    public String base(){
        Finance financeId = JSONUtil.toBean(dataJson, Finance.class);
        Finance finance = financeService.get(financeId.getId());
        request.setAttribute("finance", finance);
        return SUCCESS;
    }

    /**
     * 获取某个食堂财务信息
     * @return
     */
    public String get(){
        Finance financeId = JSONUtil.toBean(dataJson, Finance.class);
        Finance finance = financeService.get(financeId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("finance", finance);
        return SUCCESS;
    }

    /**
     * 增加食堂财务信息
     * @return
     */
    public String add(){
        Finance finance = JSONUtil.toBean(dataJson, Finance.class);
        financeService.add(finance);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂财务信息
     * @return
     */
    public String delete(){
        Finance finance = JSONUtil.toBean(dataJson, Finance.class);
        financeService.delete(finance);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂财务信息
     * @return
     */
    public String update(){
        Finance finance = JSONUtil.toBean(dataJson, Finance.class);
        financeService.updateById(finance);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
