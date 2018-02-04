package com.hjj.action;

import com.hjj.entity.Ingredients;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.IngredientsService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class IngredientsAction extends BaseAction {

    @Autowired
    private IngredientsService ingredientsService;

    /**
     * 食堂食材信息首页
     * @return
     */
    public String index() {
        List<Ingredients> ingredientss = ingredientsService.list();
        request.setAttribute("ingredientss", ingredientss);
        return SUCCESS;
    }

    /**
     * 到更新食堂食材信息页面
     * @return
     */
    public String base(){
        Ingredients ingredientsId = JSONUtil.toBean(dataJson, Ingredients.class);
        Ingredients ingredients = ingredientsService.get(ingredientsId.getId());
        request.setAttribute("ingredients", ingredients);
        return SUCCESS;
    }

    /**
     * 获取某个食堂食材信息
     * @return
     */
    public String get(){
        Ingredients ingredientsId = JSONUtil.toBean(dataJson, Ingredients.class);
        Ingredients ingredients = ingredientsService.get(ingredientsId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("ingredients", ingredients);
        return SUCCESS;
    }

    /**
     * 增加食堂食材信息
     * @return
     */
    public String add(){
        Ingredients ingredients = JSONUtil.toBean(dataJson, Ingredients.class);
        ingredientsService.add(ingredients);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂食材信息
     * @return
     */
    public String delete(){
        Ingredients ingredients = JSONUtil.toBean(dataJson, Ingredients.class);
        ingredientsService.delete(ingredients);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂食材信息
     * @return
     */
    public String update(){
        Ingredients ingredients = JSONUtil.toBean(dataJson, Ingredients.class);
        ingredientsService.updateById(ingredients);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /////////////////////////////////////


    /**
     * 前台显示食材来源页面
     * @return
     */
    public String fIngredients(){
        List<Ingredients> ingredientss = ingredientsService.list();
        request.setAttribute("ingredientss", ingredientss);
        return SUCCESS;
    }


}
