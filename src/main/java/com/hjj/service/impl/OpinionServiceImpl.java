package com.hjj.service.impl;

import com.hjj.dao.OpinionDao;
import com.hjj.entity.Opinion;
import com.hjj.service.OpinionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService{
    @Autowired
    private OpinionDao opinionDao;

    /**
     * 获取所有食堂意见信息
     *
     * @return
     */
    @Override
    public List<Opinion> list() {
        return opinionDao.list();
    }

    /**
     * 获取某个意见信息
     *
     * @param id
     * @return
     */
    @Override
    public Opinion get(Long id) {
        return opinionDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂意见信息
     *
     * @param opinion
     */
    @Override
    @Transactional
    public void add(Opinion opinion) {
        opinionDao.save(opinion);
    }

    /**
     * 删除食堂意见信息
     *
     * @param opinion
     */
    @Override
    @Transactional
    public void delete(Opinion opinion) {
        opinionDao.delete(opinion);
    }

    /**
     * 更新食堂意见信息
     *
     * @param opinion
     */
    @Override
    @Transactional
    public void updateById(Opinion opinion) {
        Opinion record = opinionDao.getById(opinion.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(opinion, record);
            opinionDao.update(record);
        }

    }
}
