package com.hjj.action;

import com.hjj.entity.FoodMenu;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.FoodMenuService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class FoodMenuAction extends BaseAction {

    @Autowired
    private FoodMenuService foodMenuService;

    /**
     * 食堂菜谱信息首页
     * @return
     */
    public String index() {
        List<FoodMenu> foodMenus = foodMenuService.list();
        request.setAttribute("foodMenus", foodMenus);
        return SUCCESS;
    }

    /**
     * 到更新食堂菜谱信息页面
     * @return
     */
    public String base(){
        FoodMenu foodMenuId = JSONUtil.toBean(dataJson, FoodMenu.class);
        FoodMenu foodMenu = foodMenuService.get(foodMenuId.getId());
        request.setAttribute("foodMenu", foodMenu);
        return SUCCESS;
    }

    /**
     * 获取某个食堂菜谱信息
     * @return
     */
    public String get(){
        FoodMenu foodMenuId = JSONUtil.toBean(dataJson, FoodMenu.class);
        FoodMenu foodMenu = foodMenuService.get(foodMenuId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("foodMenu", foodMenu);
        return SUCCESS;
    }

    /**
     * 增加食堂菜谱信息
     * @return
     */
    public String add(){
        FoodMenu foodMenu = JSONUtil.toBean(dataJson, FoodMenu.class);
        foodMenuService.add(foodMenu);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂菜谱信息
     * @return
     */
    public String delete(){
        FoodMenu foodMenu = JSONUtil.toBean(dataJson, FoodMenu.class);
        foodMenuService.delete(foodMenu);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂菜谱信息
     * @return
     */
    public String update(){
        FoodMenu foodMenu = JSONUtil.toBean(dataJson, FoodMenu.class);
        foodMenuService.updateById(foodMenu);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
