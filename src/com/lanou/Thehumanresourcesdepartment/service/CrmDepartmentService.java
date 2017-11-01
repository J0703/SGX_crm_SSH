package com.lanou.Thehumanresourcesdepartment.service;

import com.lanou.Thehumanresourcesdepartment.domain.CrmDepartment;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface CrmDepartmentService {
    List<CrmDepartment> findAll();

    CrmDepartment findById(String depId);

    void saveOrUpdate(CrmDepartment crmDepartment);
}
