package com.lanou.filter;

import com.lanou.Thehumanresourcesdepartment.domain.CrmStaff;
import com.lanou.Thehumanresourcesdepartment.service.CrmStaffService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by dllo on 17/10/30.
 */
public class Filter implements javax.servlet.Filter {

    //初始化方法
    //在tomcat启动时创建
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String admin = filterConfig.getInitParameter("admin");
        if (Boolean.valueOf(admin)){
            CrmStaff crmStaff = new CrmStaff();
            crmStaff.setLoginName("sgx");
            crmStaff.setLoginPwd("787514");
            crmStaff.setStaffName("管理员");
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
            CrmStaffService staffService = (CrmStaffService) webApplicationContext.getBean("crmStaffService");

            CrmStaff login = staffService.login(crmStaff);
            if ( login == null){
                staffService.addStaffReal(crmStaff);

            }

        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

}
