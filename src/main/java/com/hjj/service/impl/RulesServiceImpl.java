package com.hjj.service.impl;

import com.hjj.dao.RulesDao;
import com.hjj.dao.UserDao;
import com.hjj.entity.Rules;
import com.hjj.entity.User;
import com.hjj.service.RulesService;
import com.hjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 */
@Service
public class RulesServiceImpl implements RulesService{
    @Autowired
    private RulesDao rulesDao;

    /**
     * 获取食堂制度
     *
     * @return
     */
    @Override
    public Rules getFirst() {
        List<Rules> rules = rulesDao.list();
        if (!rules.isEmpty()){
            return rules.get(0);
        }
        return null;
    }

    /**
     * 没有记录时增加食堂制度记录
     *
     * @param rules
     */
    @Override
    public void add(Rules rules) {
        rulesDao.save(rules);
    }

    /**
     * 更新食堂制度
     *
     * @param rules
     */
    @Override
    @Transactional
    public void update(Rules rules) {
        Rules record = getFirst();
        record.setRules(rules.getRules());
        rulesDao.update(record);
    }
}
