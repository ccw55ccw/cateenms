package com.hjj.service;

import com.hjj.entity.Complaints;

import java.util.List;

public interface ComplaintsService {

    /**
     * 获取所有食堂意见信息
     * @return
     */
    List<Complaints> list();

    /**
     * 获取某个意见信息
     * @param id
     * @return
     */
    Complaints get(Long id);

    /**
     * 增加食堂意见信息
     * @param complaints
     */
    void add(Complaints complaints);

    /**
     * 删除食堂意见信息
     * @param complaints
     */
    void delete(Complaints complaints);

    /**
     * 更新食堂意见信息
     * @param complaints
     */
    void updateById(Complaints complaints);
}
