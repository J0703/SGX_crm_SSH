package com.lanou.action;

import com.lanou.domain.CrmDepartment;
import com.lanou.service.CrmDepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("crmDepartmentAction")
@Scope("prototype")
public class CrmDepartmentAction extends ActionSupport implements ModelDriven<CrmDepartment> {
    private CrmDepartment crmDepartment;

    @Qualifier("crmDepartmentService")
    @Autowired
    private CrmDepartmentService crmDepartmentService;


    public String listDepartment(){
        List<CrmDepartment> crmDepartments = crmDepartmentService.findAll();
        ServletActionContext.getRequest().getSession().setAttribute("crmDepartments",crmDepartments);
        return SUCCESS;
    }
    @Override
    public CrmDepartment getModel() {
        crmDepartment = new CrmDepartment();
        return crmDepartment;
    }
}
