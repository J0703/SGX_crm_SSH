package com.lanou.Actuarialoriented.action;

import com.lanou.Actuarialoriented.domain.CrmCourseType;
import com.lanou.Actuarialoriented.service.CrmCourseTypeService;
import com.lanou.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/31.
 */
@Controller("crmCourseTypeAction")
@Scope("prototype")
public class CrmCourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType>{
    private CrmCourseType crmCourseType;

    @Qualifier("crmCourseTypeService")
    @Autowired
    private CrmCourseTypeService crmCourseTypeService;

    private int pageNum=1;
    private int pageSize=2;

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

    //分页查询所有
    public String listCourse(){
        PageBean<CrmCourseType> pageBeanCourse = crmCourseTypeService.findAll(crmCourseType, pageNum, pageSize);

        System.out.println("pageBeanCourse++++"+pageBeanCourse);
        ActionContext.getContext().put("pageBeanCourse",pageBeanCourse);

        return SUCCESS;
    }



    @Override
    public CrmCourseType getModel() {
        crmCourseType = new CrmCourseType();
        return crmCourseType;
    }

}
