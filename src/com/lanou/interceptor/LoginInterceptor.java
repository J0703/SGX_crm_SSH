package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.aopalliance.intercept.Invocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/30.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object attribute = ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if (attribute == null){
            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addFieldError("loginName","拦截器  你还没有登录");
            return "login";
        }

        return actionInvocation.invoke();
    }
}
