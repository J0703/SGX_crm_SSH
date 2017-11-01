package com.lanou.Thehumanresourcesdepartment.service.Impl;

import com.lanou.Thehumanresourcesdepartment.dao.CrmDepartmentDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmDepartment;
import com.lanou.Thehumanresourcesdepartment.service.CrmDepartmentService;

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

    @Override
    public void saveOrUpdate(CrmDepartment crmDepartment) {
        crmDepartmentDao.saveOrUpdate(crmDepartment);
    }
}
