package com.lanou.service.Impl;

import com.lanou.dao.CrmStaffDao;
import com.lanou.domain.CrmStaff;
import com.lanou.service.CrmStaffService;
import com.lanou.util.UUID;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class CrmStaffServiceImpl implements CrmStaffService {
   private CrmStaffDao crmStaffDao;



    public CrmStaffDao getCrmStaffDao() {
        return crmStaffDao;
    }

    public void setCrmStaffDao(CrmStaffDao crmStaffDao) {
        this.crmStaffDao = crmStaffDao;
    }

    @Override
    public List<CrmStaff> findAllList() {
        
        return crmStaffDao.findAll();
    }

    @Override
    public CrmStaff editStaff(String staffId) {
        return crmStaffDao.findById(staffId);
    }

    @Override
    public void editReal(CrmStaff crmStaff) {
        String loginPwd = crmStaff.getLoginPwd();
        if (loginPwd.length()!=32) {
            String md5Value = UUID.getMD5Value(loginPwd);
            crmStaff.setLoginPwd(md5Value);
        }
        crmStaffDao.update(crmStaff);
    }

    @Override
    public void addStaffReal(CrmStaff crmStaff) {
        String loginPwd = crmStaff.getLoginPwd();
            String md5Value = UUID.getMD5Value(loginPwd);
            crmStaff.setLoginPwd(md5Value);
        crmStaffDao.save(crmStaff);
    }

    @Override
    public CrmStaff login(CrmStaff crmStaff) {
        //MD5加密
        String loginPwd = crmStaff.getLoginPwd();
        String md5ValuePwd = UUID.getMD5Value(loginPwd);
        return crmStaffDao.login(crmStaff.getLoginName(),md5ValuePwd);
    }

    //条件查询
    @Override
    public List<CrmStaff> findAll(CrmStaff crmStaff) {
        StringBuilder builder = new StringBuilder();
        List<Object> paramsList = new ArrayList<>();
        if (crmStaff.getCrmPost() !=null && crmStaff.getCrmPost().getCrmDepartment() !=null ){
            if (StringUtils.isNotBlank(crmStaff.getCrmPost().getCrmDepartment().getDepId())){
                builder.append(" and crmPost.crmDepartment.depId = ?");
                paramsList.add(crmStaff.getCrmPost().getCrmDepartment().getDepId());
            }
        }
        if (crmStaff.getCrmPost() !=null){
            if (StringUtils.isNotBlank(crmStaff.getCrmPost().getPostId())){
                builder.append(" and crmPost.postId = ?");
                paramsList.add(crmStaff.getCrmPost().getPostId());
            }

        }
        if (StringUtils.isNotBlank(crmStaff.getStaffName())){
            builder.append(" and staffName = ?");
            paramsList.add(crmStaff.getStaffName());
        }
        String condition = builder.toString();
        Object[] params = paramsList.toArray();


        return crmStaffDao.findAll(condition,params);
    }

//    @Override
//    public List<CrmStaff> findBypostId(String postId) {
//        return  crmStaffDao.finBypostId(postId);
//    }
}
