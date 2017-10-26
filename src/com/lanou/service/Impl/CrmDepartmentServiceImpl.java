package com.lanou.service.Impl;

import com.lanou.dao.CrmDepartmentDao;
import com.lanou.service.CrmDepartmentService;

/**
 * Created by dllo on 17/10/25.
 */
public class CrmDepartmentServiceImpl implements CrmDepartmentService {
    private CrmDepartmentDao crmDepartmentDao;

    public CrmDepartmentDao getCrmDepartmentDao() {
        return crmDepartmentDao;
    }

    public void setCrmDepartmentDao(CrmDepartmentDao crmDepartmentDao) {
        this.crmDepartmentDao = crmDepartmentDao;
    }
}
