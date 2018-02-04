package com.hjj.action;

import com.hjj.entity.Complaints;
import com.hjj.entity.Employee;
import com.hjj.framework.action.BaseAction;
import com.hjj.service.ComplaintsService;
import com.hjj.service.EmployeeService;
import com.hjj.service.UserService;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ComplaintsAction extends BaseAction {

    @Autowired
    private ComplaintsService complaintsService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 食堂投诉信息首页
     * @return
     */
    public String index() {
        List<Complaints> complaintss = complaintsService.list();
        request.setAttribute("complaintss", complaintss);
        return SUCCESS;
    }

    /**
     * 到更新食堂投诉信息页面
     * @return
     */
    public String base(){
        Complaints complaintsId = JSONUtil.toBean(dataJson, Complaints.class);
        Complaints complaints = complaintsService.get(complaintsId.getId());
        request.setAttribute("complaints", complaints);
        return SUCCESS;
    }

    /**
     * 获取某个食堂投诉信息
     * @return
     */
    public String get(){
        Complaints complaintsId = JSONUtil.toBean(dataJson, Complaints.class);
        Complaints complaints = complaintsService.get(complaintsId.getId());
        responseJsonMap = respondJsonMap();
        responseJsonMap.put("complaints", complaints);
        return SUCCESS;
    }

    /**
     * 增加食堂投诉信息
     * @return
     */
    public String add(){
        Complaints complaints = JSONUtil.toBean(dataJson, Complaints.class);
        complaintsService.add(complaints);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 增加食堂投诉信息
     * @return
     */
    public String delete(){
        Complaints complaints = JSONUtil.toBean(dataJson, Complaints.class);
        complaintsService.delete(complaints);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    /**
     * 更新食堂投诉信息
     * @return
     */
    public String update(){
        Complaints complaints = JSONUtil.toBean(dataJson, Complaints.class);
        complaintsService.updateById(complaints);
        responseJsonMap = respondJsonMap();
        return SUCCESS;
    }

    ///////////////////////////////////////////

    public String fComplaintsRes(){

        List<Complaints> complaintss = complaintsService.list();
        request.setAttribute("complaintss", complaintss);

        return SUCCESS;
    }


    public String fComplaints(){

        request.setAttribute("employees", employeeService.list());

        return SUCCESS;
    }


}
