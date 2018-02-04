package com.hjj.service;

import com.hjj.entity.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface EmployeeService {

    /**
     * 获取所有食堂员工信息
     * @return
     */
    List<Employee> list();

    /**
     * 获取某个员工信息
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * 增加食堂员工信息
     * @param employee
     */
    void add(Employee employee);

    /**
     * 删除食堂员工信息
     * @param employee
     */
    void delete(Employee employee);

    /**
     * 更新食堂员工信息
     * @param employee
     */
    void updateById(Employee employee);
}
