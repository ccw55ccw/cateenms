package com.hjj.service;

import com.hjj.entity.HealthScore;

import java.util.List;

public interface HealthScoreService {

    /**
     * 获取所有食堂卫生评分信息
     * @return
     */
    List<HealthScore> list();

    /**
     * 获取某个卫生评分信息
     * @param id
     * @return
     */
    HealthScore get(Long id);

    /**
     * 增加食堂卫生评分信息
     * @param healthScore
     */
    void add(HealthScore healthScore);

    /**
     * 删除食堂卫生评分信息
     * @param healthScore
     */
    void delete(HealthScore healthScore);

    /**
     * 更新食堂卫生评分信息
     * @param healthScore
     */
    void updateById(HealthScore healthScore);
}
