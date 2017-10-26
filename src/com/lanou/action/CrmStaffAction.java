package com.lanou.action;

import com.lanou.domain.CrmStaff;
import com.lanou.service.CrmStaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("crmStaffAction")
@Scope("prototype")
public class CrmStaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
    private CrmStaff crmStaff;

    @Qualifier("crmStaffService")
    @Autowired
    private CrmStaffService crmStaffService;

    //登录
    public String login(){
        CrmStaff loginUser = crmStaffService.login(crmStaff);
        System.out.println("loginUser:+++"+loginUser);
           ServletActionContext.getRequest().getSession().setAttribute("loginUser",loginUser);
        if (loginUser !=null){
            ServletActionContext.getRequest().getSession().setAttribute("loginName",loginUser.getLoginName());
            return SUCCESS;
        }
        addFieldError("loginName","账号和密码不匹配");
        return "login";
    }
    //重新登录
    public String staffAction_logout(){
      ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
      return SUCCESS;
    }

   //查询所有(员工)
    public String findAllList(){
        List<CrmStaff> crmStaffs = crmStaffService.findAllList();
//        System.out.println(crmStaffs);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("crmStaffs",crmStaffs);
        return SUCCESS;
    }
    //员工编辑前 id查 回显
    public String editStaff(){
        String staffId = crmStaff.getStaffId();
        System.out.println("staffID:"+staffId);
        CrmStaff crmStaffById = crmStaffService.editStaff(staffId);
        System.out.println(crmStaffById);
        //将查询结果存放值栈中,压入栈顶,用于struts标签进行回显
        ActionContext.getContext().getValueStack().push(crmStaffById);
        return SUCCESS;
    }
    //员工编辑
    public String editReal(){
        crmStaffService.editReal(crmStaff);
        return SUCCESS;
    }

    //员工添加
    public String addStaffReal(){
        crmStaffService.addStaffReal(crmStaff);
        return SUCCESS;
    }



    @Override
    public CrmStaff getModel() {
        crmStaff= new CrmStaff();
        return crmStaff;
    }


}
