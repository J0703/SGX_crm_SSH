package com.lanou.Thehumanresourcesdepartment.action;

import com.lanou.Thehumanresourcesdepartment.domain.CrmDepartment;
import com.lanou.Thehumanresourcesdepartment.service.CrmDepartmentService;
import com.opensymphony.xwork2.ActionContext;
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

    public String addDepartment(){
        return SUCCESS;
    }
    public String BeforeaddOrEditDepartment(){
        CrmDepartment crmDepartmentServiceById = crmDepartmentService.findById(crmDepartment.getDepId());
        ActionContext.getContext().getValueStack().push(crmDepartmentServiceById);

        return SUCCESS;
    }

    public String saveDepartment(){
        crmDepartmentService.saveOrUpdate(crmDepartment);
        return SUCCESS;
    }
    @Override
    public CrmDepartment getModel() {
        crmDepartment = new CrmDepartment();
        return crmDepartment;
    }
}
