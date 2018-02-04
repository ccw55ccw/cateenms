package com.hjj.service;

import com.hjj.entity.Finance;

import java.util.List;

public interface FinanceService {

    /**
     * 获取所有食堂财务信息
     * @return
     */
    List<Finance> list();

    /**
     * 获取某个财务信息
     * @param id
     * @return
     */
    Finance get(Long id);

    /**
     * 增加食堂财务信息
     * @param finance
     */
    void add(Finance finance);

    /**
     * 删除食堂财务信息
     * @param finance
     */
    void delete(Finance finance);

    /**
     * 更新食堂财务信息
     * @param finance
     */
    void updateById(Finance finance);
}
