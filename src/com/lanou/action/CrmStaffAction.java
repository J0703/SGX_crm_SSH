package com.lanou.action;

import com.lanou.domain.CrmDepartment;
import com.lanou.domain.CrmPost;
import com.lanou.domain.CrmStaff;
import com.lanou.service.CrmDepartmentService;
import com.lanou.service.CrmPostService;
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
import java.util.Set;

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
    @Qualifier("crmDepartmentService")
    @Autowired
    private CrmDepartmentService crmDepartmentService;
    @Qualifier("crmPostService")
    @Autowired
    private CrmPostService crmPostService;
    private Set<CrmPost> posts;
    private String departId;
//    private String postId;

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

   //查询所有(员工)(部门)(职务)
    public String findAllList(){

        List<CrmStaff> crmStaffs = crmStaffService.findAllList();
        List<CrmDepartment> crmDepartments = crmDepartmentService.findAll();
        List<CrmPost> crmPosts = crmPostService.findAll();
        System.out.println(crmStaffs);
        System.out.println(crmDepartments);
        System.out.println(crmPosts);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("crmStaffs",crmStaffs);
        session.setAttribute("crmDepartments",crmDepartments);
        session.setAttribute("crmPosts",crmPosts);
        return SUCCESS;
    }

    //查询部门对应的职务
    public String findPost(){
        System.out.println("departId+++++"+departId);
        //通过部门id查部门对象多个
        CrmDepartment crmDepartments = crmDepartmentService.findById(departId);
        posts = crmDepartments.getPosts();

        return SUCCESS;
    }

    //员工编辑前 id查 回显
    public String editStaff(){
        String staffId = crmStaff.getStaffId();
//        System.out.println("staffID:"+staffId);
        CrmStaff crmStaffById = crmStaffService.editStaff(staffId);
        System.out.println(crmStaffById);
        //将查询结果存放值栈中,压入栈顶,用于struts标签进行回显
        ActionContext.getContext().getValueStack().push(crmStaffById);
//        List<CrmDepartment> crmDepartments = crmDepartmentService.findAll();
//        ServletActionContext.getRequest().getSession().setAttribute("crmDepartments",crmDepartments);
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

    //二级联动
    public String findStaff(){

        List<CrmStaff> crmStaffs1 = crmStaffService.findAll(crmStaff);
        System.out.println("+++++++++++++++++++++++"+crmStaffs1);
        ServletActionContext.getRequest().getSession().setAttribute("crmStaffs1",crmStaffs1);
        return SUCCESS;
//        System.out.println("二级联动depId:"+departId);
//        System.out.println("二级联动postId:"+postId);
//        List<CrmStaff> bypostId = crmStaffService.findBypostId(postId);
//        System.out.println("员工信息:"+bypostId);
//
//        ServletActionContext.getRequest().getSession().setAttribute("",bypostId);
//        return SUCCESS;
    }


    @Override
    public CrmStaff getModel() {
        crmStaff= new CrmStaff();
        return crmStaff;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public Set<CrmPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<CrmPost> posts) {
        this.posts = posts;
    }

//    public String getPostId() {
//        return postId;
//    }
//
//    public void setPostId(String postId) {
//        this.postId = postId;
//    }
}
