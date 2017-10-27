package com.lanou.service.Impl;

import com.lanou.dao.CrmPostDao;
import com.lanou.domain.CrmPost;
import com.lanou.service.CrmPostService;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class CrmPostServiceImpl implements CrmPostService {
    private CrmPostDao crmPostDao;


    public CrmPostDao getCrmPostDao() {
        return crmPostDao;
    }

    public void setCrmPostDao(CrmPostDao crmPostDao) {
        this.crmPostDao = crmPostDao;
    }

    @Override
    public List<CrmPost> findAll() {
        return crmPostDao.findAll();
    }
}
