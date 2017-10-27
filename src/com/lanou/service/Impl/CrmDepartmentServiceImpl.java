package com.lanou.service.Impl;

import com.lanou.dao.CrmDepartmentDao;
import com.lanou.domain.CrmDepartment;
import com.lanou.service.CrmDepartmentService;

import java.util.List;

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

    @Override
    public List<CrmDepartment> findAll() {
        return crmDepartmentDao.findAll();
    }

    @Override
    public CrmDepartment findById(String depId) {
        return crmDepartmentDao.findById(depId);
    }
}
