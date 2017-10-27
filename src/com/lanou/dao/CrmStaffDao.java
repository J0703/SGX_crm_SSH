package com.lanou.dao;

import com.lanou.base.BaseDao;
import com.lanou.domain.CrmStaff;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public interface CrmStaffDao extends BaseDao<CrmStaff> {
    //登录
    CrmStaff login(String loginName, String loginPwd);

    List<CrmStaff> finBypostId(String postId);
}
