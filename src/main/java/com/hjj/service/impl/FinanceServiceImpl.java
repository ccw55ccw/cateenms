package com.hjj.service.impl;

import com.hjj.dao.FinanceDao;
import com.hjj.entity.Finance;
import com.hjj.service.FinanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService{
    @Autowired
    private FinanceDao financeDao;

    /**
     * 获取所有食堂财务信息
     *
     * @return
     */
    @Override
    public List<Finance> list() {
        return financeDao.list();
    }

    /**
     * 获取某个财务信息
     *
     * @param id
     * @return
     */
    @Override
    public Finance get(Long id) {
        return financeDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂财务信息
     *
     * @param finance
     */
    @Override
    @Transactional
    public void add(Finance finance) {
        financeDao.save(finance);
    }

    /**
     * 删除食堂财务信息
     *
     * @param finance
     */
    @Override
    @Transactional
    public void delete(Finance finance) {
        financeDao.delete(finance);
    }

    /**
     * 更新食堂财务信息
     *
     * @param finance
     */
    @Override
    @Transactional
    public void updateById(Finance finance) {
        Finance record = financeDao.getById(finance.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(finance, record);
            financeDao.update(record);
        }

    }
}
