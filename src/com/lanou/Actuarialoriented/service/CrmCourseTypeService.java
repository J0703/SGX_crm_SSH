package com.lanou.Actuarialoriented.service;

import com.lanou.Actuarialoriented.domain.CrmCourseType;
import com.lanou.util.PageBean;

/**
 * Created by dllo on 17/10/31.
 */
public interface CrmCourseTypeService  {
    PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize);
}
