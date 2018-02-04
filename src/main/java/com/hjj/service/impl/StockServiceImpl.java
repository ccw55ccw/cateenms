package com.hjj.service.impl;

import com.hjj.dao.StockDao;
import com.hjj.entity.Stock;
import com.hjj.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    private StockDao stockDao;

    /**
     * 获取所有食堂库存信息
     *
     * @return
     */
    @Override
    public List<Stock> list() {
        return stockDao.list();
    }

    /**
     * 获取某个库存信息
     *
     * @param id
     * @return
     */
    @Override
    public Stock get(Long id) {
        return stockDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂库存信息
     *
     * @param stock
     */
    @Override
    @Transactional
    public void add(Stock stock) {
        stockDao.save(stock);
    }

    /**
     * 删除食堂库存信息
     *
     * @param stock
     */
    @Override
    @Transactional
    public void delete(Stock stock) {
        stockDao.delete(stock);
    }

    /**
     * 更新食堂库存信息
     *
     * @param stock
     */
    @Override
    @Transactional
    public void updateById(Stock stock) {
        Stock record = stockDao.getById(stock.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(stock, record);
            stockDao.update(record);
        }

    }
}
