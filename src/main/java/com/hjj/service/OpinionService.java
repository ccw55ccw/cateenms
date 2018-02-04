package com.hjj.service;

import com.hjj.entity.Opinion;

import java.util.List;

public interface OpinionService {

    /**
     * 获取所有食堂意见信息
     * @return
     */
    List<Opinion> list();

    /**
     * 获取某个意见信息
     * @param id
     * @return
     */
    Opinion get(Long id);

    /**
     * 增加食堂意见信息
     * @param opinion
     */
    void add(Opinion opinion);

    /**
     * 删除食堂意见信息
     * @param opinion
     */
    void delete(Opinion opinion);

    /**
     * 更新食堂意见信息
     * @param opinion
     */
    void updateById(Opinion opinion);
}
