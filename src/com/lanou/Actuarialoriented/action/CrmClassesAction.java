package com.lanou.Actuarialoriented.action;

import com.lanou.Actuarialoriented.domain.CrmClasses;

import com.lanou.Actuarialoriented.service.CrmClassesService;
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
@Controller("crmClassesAction")
@Scope("prototype")
public class CrmClassesAction extends ActionSupport implements ModelDriven<CrmClasses> {
    private CrmClasses crmClasses;

    @Qualifier("crmClassesService")
    @Autowired
    private CrmClassesService crmClassesService;

    private int pageNum=1 ;
    private int pageSize=2;


    public String listClass(){
        PageBean<CrmClasses> pageBeanClasses = crmClassesService.findAll(crmClasses, pageNum, pageSize);

        ActionContext.getContext().put("pageBeanClasses",pageBeanClasses);
        return SUCCESS;
    }



    @Override
    public CrmClasses getModel() {
        crmClasses = new CrmClasses();
        return crmClasses;
    }

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
}
