package com.hjj.service;

import com.hjj.entity.Stock;

import java.util.List;

public interface StockService {

    /**
     * 获取所有食堂库存信息
     * @return
     */
    List<Stock> list();

    /**
     * 获取某个库存信息
     * @param id
     * @return
     */
    Stock get(Long id);

    /**
     * 增加食堂库存信息
     * @param stock
     */
    void add(Stock stock);

    /**
     * 删除食堂库存信息
     * @param stock
     */
    void delete(Stock stock);

    /**
     * 更新食堂库存信息
     * @param stock
     */
    void updateById(Stock stock);
}
