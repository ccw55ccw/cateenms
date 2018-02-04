package com.hjj.service.impl;

import com.hjj.dao.IngredientsDao;
import com.hjj.entity.Ingredients;
import com.hjj.service.IngredientsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 */
@Service
public class IngredientsServiceImpl implements IngredientsService{
    @Autowired
    private IngredientsDao ingredientsDao;

    /**
     * 获取所有食堂食材信息
     *
     * @return
     */
    @Override
    public List<Ingredients> list() {
        return ingredientsDao.list();
    }

    /**
     * 获取某个食材信息
     *
     * @param id
     * @return
     */
    @Override
    public Ingredients get(Long id) {
        return ingredientsDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂食材信息
     *
     * @param ingredients
     */
    @Override
    @Transactional
    public void add(Ingredients ingredients) {
        ingredientsDao.save(ingredients);
    }

    /**
     * 删除食堂食材信息
     *
     * @param ingredients
     */
    @Override
    @Transactional
    public void delete(Ingredients ingredients) {
        ingredientsDao.delete(ingredients);
    }

    /**
     * 更新食堂食材信息
     *
     * @param ingredients
     */
    @Override
    @Transactional
    public void updateById(Ingredients ingredients) {
        Ingredients record = ingredientsDao.getById(ingredients.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(ingredients, record);
            ingredientsDao.update(record);
        }

    }
}
