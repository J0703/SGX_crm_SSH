package com.lanou.Thehumanresourcesdepartment.service;

import com.lanou.Thehumanresourcesdepartment.domain.CrmStaff;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */


public interface CrmStaffService {
    List<CrmStaff> findAllList();

    CrmStaff editStaff(String staffId);

    void editReal(CrmStaff crmStaff);

    void addStaffReal(CrmStaff crmStaff);

    CrmStaff login(CrmStaff crmStaff);

//    List<CrmStaff> findBypostId(String postId);

    List<CrmStaff> findAll(CrmStaff crmStaff);


    void update(CrmStaff crmStaff);

    void findByid(String staffId, String newPassword);

//    public PageBean<CrmStaff> findAllpageBean(CrmStaff crmPost, int pageNum, int pageSize);

}
