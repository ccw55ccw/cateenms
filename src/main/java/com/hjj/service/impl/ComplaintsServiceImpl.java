package com.hjj.service.impl;

import com.hjj.dao.ComplaintsDao;
import com.hjj.entity.Complaints;
import com.hjj.service.ComplaintsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComplaintsServiceImpl implements ComplaintsService{
    @Autowired
    private ComplaintsDao complaintsDao;

    /**
     * 获取所有食堂投诉信息
     *
     * @return
     */
    @Override
    public List<Complaints> list() {
        return complaintsDao.list();
    }

    /**
     * 获取某个投诉信息
     *
     * @param id
     * @return
     */
    @Override
    public Complaints get(Long id) {
        return complaintsDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂投诉信息
     *
     * @param complaints
     */
    @Override
    @Transactional
    public void add(Complaints complaints) {
        complaintsDao.save(complaints);
    }

    /**
     * 删除食堂投诉信息
     *
     * @param complaints
     */
    @Override
    @Transactional
    public void delete(Complaints complaints) {
        complaintsDao.delete(complaints);
    }

    /**
     * 更新食堂投诉信息
     *
     * @param complaints
     */
    @Override
    @Transactional
    public void updateById(Complaints complaints) {
        Complaints record = complaintsDao.getById(complaints.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(complaints, record);
            complaintsDao.update(record);
        }

    }
}
