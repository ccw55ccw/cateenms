package com.hjj.service.impl;

import com.hjj.dao.FoodMenuDao;
import com.hjj.entity.FoodMenu;
import com.hjj.service.FoodMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 */
@Service
public class FoodMenuServiceImpl implements FoodMenuService{
    @Autowired
    private FoodMenuDao FoodMenuDao;

    /**
     * 获取所有食堂菜谱信息
     *
     * @return
     */
    @Override
    public List<FoodMenu> list() {
        return FoodMenuDao.list();
    }

    /**
     * 获取某个菜谱信息
     *
     * @param id
     * @return
     */
    @Override
    public FoodMenu get(Long id) {
        return FoodMenuDao.getById(id).orElse(null);
    }

    /**
     * 获取显示菜谱信息
     *
     * @return
     */
    @Override
    public List<FoodMenu> listShowMenu() {
        FoodMenu cond = new FoodMenu();
        cond.setIsWebShow("1");
        return FoodMenuDao.list(cond);
    }

    /**
     * 增加食堂菜谱信息
     *
     * @param FoodMenu
     */
    @Override
    @Transactional
    public void add(FoodMenu FoodMenu) {
        FoodMenuDao.save(FoodMenu);
    }

    /**
     * 删除食堂菜谱信息
     *
     * @param FoodMenu
     */
    @Override
    @Transactional
    public void delete(FoodMenu FoodMenu) {
        FoodMenuDao.delete(FoodMenu);
    }

    /**
     * 更新食堂菜谱信息
     *
     * @param FoodMenu
     */
    @Override
    @Transactional
    public void updateById(FoodMenu FoodMenu) {
        FoodMenu record = FoodMenuDao.getById(FoodMenu.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(FoodMenu, record);
            FoodMenuDao.update(record);
        }

    }
}
