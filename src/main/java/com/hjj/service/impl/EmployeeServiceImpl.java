package com.hjj.service.impl;

import com.hjj.dao.EmployeeDao;
import com.hjj.entity.Employee;
import com.hjj.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 获取所有食堂员工信息
     *
     * @return
     */
    @Override
    public List<Employee> list() {
        return employeeDao.list();
    }

    /**
     * 获取某个员工信息
     *
     * @param id
     * @return
     */
    @Override
    public Employee get(Long id) {
        return employeeDao.getById(id).orElse(null);
    }

    /**
     * 增加食堂员工信息
     *
     * @param employee
     */
    @Override
    @Transactional
    public void add(Employee employee) {
        employeeDao.save(employee);
    }

    /**
     * 删除食堂员工信息
     *
     * @param employee
     */
    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    /**
     * 更新食堂员工信息
     *
     * @param employee
     */
    @Override
    @Transactional
    public void updateById(Employee employee) {
        Employee record = employeeDao.getById(employee.getId()).orElse(null);
        if (record != null){
            BeanUtils.copyProperties(employee, record);
            employeeDao.update(record);
        }

    }
}
