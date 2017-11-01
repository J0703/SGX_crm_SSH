package com.lanou.Actuarialoriented.service;

import com.lanou.Actuarialoriented.domain.CrmClasses;
import com.lanou.util.PageBean;

/**
 * Created by dllo on 17/10/31.
 */
public interface CrmClassesService {
    PageBean<CrmClasses> findAll(CrmClasses crmClasses, int pageNum, int pageSize);

}
