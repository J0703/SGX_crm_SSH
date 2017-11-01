package com.lanou.Thehumanresourcesdepartment.dao;

import com.lanou.base.BaseDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmPost;

/**
 * Created by dllo on 17/10/25.
 */
public interface CrmPostDao  extends BaseDao<CrmPost>{
//不写

    //获取总记录数

    /**
     *
     * @param condition 条件
     * @param params 参数
     * @return
     */
//    public int getTotalRecord(String condition,Object[] params);

    //获取到数据

    /**
     *
     * @param condition 条件
     * @param params 参数
     * @param startIndex 开始索引
     * @param pageSize 每页显示记录数
     * @return
     */
//    public List<CrmPost> findAllPageBean(String condition,Object[] params,int startIndex,int pageSize);
}
