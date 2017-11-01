package com.lanou.Thehumanresourcesdepartment.dao;

import com.lanou.base.BaseDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmStaff;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public interface CrmStaffDao extends BaseDao<CrmStaff> {
    //登录
    CrmStaff login(String loginName, String loginPwd);

    List<CrmStaff> finBypostId(String postId);


    //获取总记录数

    /**
     *
     * @param condition 条件
     * @param params 参数
     * @return
     */
    public int getTotalRecord(String condition,Object[] params);

    //获取到数据

    /**
     *
     * @param condition 条件
     * @param params 参数
     * @param startIndex 开始索引
     * @param pageSize 每页显示记录数
     * @return
     */
    public List<CrmStaff> findAllPageBean(String condition, Object[] params, int startIndex, int pageSize);
}


