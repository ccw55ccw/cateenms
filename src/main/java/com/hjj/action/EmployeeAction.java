package com.hjj.action;

import com.hjj.entity.Employee;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.EmployeeService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class EmployeeAction extends BaseAction {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 食堂员工信息首页
     * @return
     */
    public String index() {
        List<Employee> employees = employeeService.list();
        request.setAttribute("employees", employees);
        return SUCCESS;
    }

    /**
     * 到更新食堂员工信息页面
     * @return
     */
    public String base(){
        Employee employeeId = JSONUtil.toBean(dataJson, Employee.class);
        Employee employee = employeeService.get(employeeId.getId());
        request.setAttribute("employee", employee);
        return SUCCESS;
    }

    /**
     * 获取某个食堂员工信息
     * @return
     */
    public String get(){
        Employee employeeId = JSONUtil.toBean(dataJson, Employee.class);
        Employee employee = employeeService.get(employeeId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("employee", employee);
        return SUCCESS;
    }

    /**
     * 增加食堂员工信息
     * @return
     */
    public String add(){
        Employee employee = JSONUtil.toBean(dataJson, Employee.class);
        employeeService.add(employee);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂员工信息
     * @return
     */
    public String delete(){
        Employee employee = JSONUtil.toBean(dataJson, Employee.class);
        employeeService.delete(employee);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂员工信息
     * @return
     */
    public String update(){
        Employee employee = JSONUtil.toBean(dataJson, Employee.class);
        employeeService.updateById(employee);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }


}
