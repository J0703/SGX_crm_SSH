package com.lanou.Thehumanresourcesdepartment.action;

import com.lanou.Thehumanresourcesdepartment.domain.CrmDepartment;
import com.lanou.Thehumanresourcesdepartment.domain.CrmPost;
import com.lanou.util.PageBean;
import com.lanou.Thehumanresourcesdepartment.service.CrmDepartmentService;
import com.lanou.Thehumanresourcesdepartment.service.CrmPostService;
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
@Controller("crmPostAction")
@Scope("prototype")
public class CrmPostAction extends ActionSupport implements ModelDriven<CrmPost> {
    private CrmPost crmPost;

    @Qualifier("crmPostService")
    @Autowired
    private CrmPostService crmPostService;

    @Qualifier("crmDepartmentService")
    @Autowired
    private CrmDepartmentService crmDepartmentService;

    private int pageNum = 1;
    private int pageSize = 3;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //分页
    public String findAllP(){
        PageBean<CrmPost> pageBean = crmPostService.findAllP(crmPost, pageNum, pageSize);
        System.out.println("pageBean+++"+pageBean);
        ActionContext.getContext().put("pageBean",pageBean);

        return SUCCESS;
    }

    //没有分页的查询所有
//    public String listPost(){
//        List<CrmPost> posts = crmPostService.findAll();
//        System.out.println("post"+posts);
//
//        List<CrmDepartment> crmDepartments = crmDepartmentService.findAll();
//        ServletActionContext.getRequest().getSession().setAttribute("posts",posts);
//        ServletActionContext.getRequest().getSession().setAttribute("crmDepartments",crmDepartments);
//        return SUCCESS;
//    }

    public String JumpPost(){
        System.out.println("crPost.getPostId+++++"+crmPost.getPostId());
        CrmPost crmPostBYid = crmPostService.findByAll(crmPost.getPostId());
        List<CrmDepartment> crmDepartments = crmDepartmentService.findAll();
        ServletActionContext.getRequest().getSession().setAttribute("crmDepartments",crmDepartments);

        //用于回显
        ActionContext.getContext().getValueStack().push(crmPostBYid);
        return SUCCESS;
    }


    public String AddorEditPost(){
        System.out.println("crPost.getPostId*******"+crmPost.getPostId());
        crmPostService.addOrEditPost(crmPost);

        return SUCCESS;
    }
    public String AddPost(){
        System.out.println("crPost.getPostId===="+crmPost.getPostId());
        return SUCCESS;
    }





    @Override
    public CrmPost getModel() {
        crmPost = new CrmPost();
        return crmPost;
    }
}
