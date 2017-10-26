package com.lanou.action;

import com.lanou.domain.CrmDepartment;
import com.lanou.service.CrmDepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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

    @Override
    public CrmDepartment getModel() {
        crmDepartment = new CrmDepartment();
        return crmDepartment;
    }
}
