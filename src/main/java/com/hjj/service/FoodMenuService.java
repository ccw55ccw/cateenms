package com.hjj.service;

import com.hjj.entity.FoodMenu;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface FoodMenuService {

    /**
     * 获取所有食堂菜谱信息
     * @return
     */
    List<FoodMenu> list();

    /**
     * 获取某个菜谱信息
     * @param id
     * @return
     */
    FoodMenu get(Long id);

    /**
     * 获取显示菜谱信息
     *
     * @return
     */
    List<FoodMenu> listShowMenu();

    /**
     * 增加食堂菜谱信息
     * @param FoodMenu
     */
    void add(FoodMenu FoodMenu);

    /**
     * 删除食堂菜谱信息
     * @param FoodMenu
     */
    void delete(FoodMenu FoodMenu);

    /**
     * 更新食堂菜谱信息
     * @param FoodMenu
     */
    void updateById(FoodMenu FoodMenu);
}
