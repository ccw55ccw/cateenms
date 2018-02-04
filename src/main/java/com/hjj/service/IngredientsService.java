package com.hjj.service;

import com.hjj.entity.Ingredients;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface IngredientsService {

    /**
     * 获取所有食堂食材信息
     * @return
     */
    List<Ingredients> list();

    /**
     * 获取某个食材信息
     * @param id
     * @return
     */
    Ingredients get(Long id);

    /**
     * 增加食堂食材信息
     * @param ingredients
     */
    void add(Ingredients ingredients);

    /**
     * 删除食堂食材信息
     * @param ingredients
     */
    void delete(Ingredients ingredients);

    /**
     * 更新食堂食材信息
     * @param ingredients
     */
    void updateById(Ingredients ingredients);
}
