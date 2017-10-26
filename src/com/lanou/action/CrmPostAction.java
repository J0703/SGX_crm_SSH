package com.lanou.action;

import com.lanou.domain.CrmPost;
import com.lanou.service.CrmPostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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

    @Override
    public CrmPost getModel() {
        crmPost = new CrmPost();
        return crmPost;
    }
}
