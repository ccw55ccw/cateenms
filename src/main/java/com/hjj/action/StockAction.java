package com.hjj.action;

import com.hjj.entity.Stock;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.StockService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockAction extends BaseAction {

    @Autowired
    private StockService stockService;

    /**
     * 食堂库存信息首页
     * @return
     */
    public String index() {
        List<Stock> stocks = stockService.list();
        request.setAttribute("stocks", stocks);
        return SUCCESS;
    }

    /**
     * 到更新食堂库存信息页面
     * @return
     */
    public String base(){
        Stock stockId = JSONUtil.toBean(dataJson, Stock.class);
        Stock stock = stockService.get(stockId.getId());
        request.setAttribute("stock", stock);
        return SUCCESS;
    }

    /**
     * 获取某个食堂库存信息
     * @return
     */
    public String get(){
        Stock stockId = JSONUtil.toBean(dataJson, Stock.class);
        Stock stock = stockService.get(stockId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("stock", stock);
        return SUCCESS;
    }

    /**
     * 增加食堂库存信息
     * @return
     */
    public String add(){
        Stock stock = JSONUtil.toBean(dataJson, Stock.class);
        stockService.add(stock);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂库存信息
     * @return
     */
    public String delete(){
        Stock stock = JSONUtil.toBean(dataJson, Stock.class);
        stockService.delete(stock);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂库存信息
     * @return
     */
    public String update(){
        Stock stock = JSONUtil.toBean(dataJson, Stock.class);
        stockService.updateById(stock);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
