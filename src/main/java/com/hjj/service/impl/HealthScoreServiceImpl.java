package com.hjj.service.impl;

import com.hjj.dao.HealthScoreDao;
import com.hjj.entity.HealthScore;
import com.hjj.service.HealthScoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HealthScoreServiceImpl implements HealthScoreService{
    @Autowired
    private HealthScoreDao healthScoreDao;

    /**
     * 获取所有食堂食材信息
     *
     * @return
     */
    @Override
    public List<HealthScore> list() {
        return healthScoreDao.list();
    }

    /**
     * 获取某个食材信息
     *
     * @param id
     * @return
     */
    @Override
    public HealthScore get(Long id) {
        return healthScoreDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂食材信息
     *
     * @param healthScore
     */
    @Override
    @Transactional
    public void add(HealthScore healthScore) {
        healthScoreDao.save(healthScore);
    }

    /**
     * 删除食堂食材信息
     *
     * @param healthScore
     */
    @Override
    @Transactional
    public void delete(HealthScore healthScore) {
        healthScoreDao.delete(healthScore);
    }

    /**
     * 更新食堂食材信息
     *
     * @param healthScore
     */
    @Override
    @Transactional
    public void updateById(HealthScore healthScore) {
        HealthScore record = healthScoreDao.getById(healthScore.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(healthScore, record);
            healthScoreDao.update(record);
        }

    }
}
