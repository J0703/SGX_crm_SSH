package com.lanou.Actuarialoriented.service.Impl;

import com.lanou.Actuarialoriented.dao.CrmClassesDao;
import com.lanou.Actuarialoriented.domain.CrmClasses;
import com.lanou.Actuarialoriented.service.CrmClassesService;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class CrmClassesServiceImpl implements CrmClassesService {
    private CrmClassesDao crmClassesDao;


    public CrmClassesDao getCrmClassesDao() {
        return crmClassesDao;
    }

    public void setCrmClassesDao(CrmClassesDao crmClassesDao) {
        this.crmClassesDao = crmClassesDao;
    }

    @Override
    public PageBean<CrmClasses> findAll(CrmClasses crmClasses, int pageNum, int pageSize) {
        if (pageNum == 0) pageNum++;
        int totalRecord =crmClassesDao.getTotalRecord(null,null);
        PageBean<CrmClasses> pageBean = new PageBean<CrmClasses>( pageNum, pageSize,totalRecord);
        List<CrmClasses> data = crmClassesDao.findAll(null, null, pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }
}
