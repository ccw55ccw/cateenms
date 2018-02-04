package com.hjj.service;

import com.hjj.entity.Rules;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface RulesService {

    /**
     * 获取食堂制度
     * @return
     */
    Rules getFirst();

    /**
     * 没有记录时增加食堂制度记录
     * @param rules
     */
    void add(Rules rules);

    /**
     * 更新食堂制度
     * @param rules
     */
    void update(Rules rules);
}
