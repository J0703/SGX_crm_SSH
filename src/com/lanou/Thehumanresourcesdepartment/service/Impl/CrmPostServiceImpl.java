package com.lanou.Thehumanresourcesdepartment.service.Impl;

import com.lanou.Thehumanresourcesdepartment.dao.CrmPostDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmPost;
import com.lanou.util.PageBean;
import com.lanou.Thehumanresourcesdepartment.service.CrmPostService;

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

    @Override
    public void addOrEditPost(CrmPost crmPost) {
          crmPostDao.saveOrUpdate(crmPost);
    }

    @Override
    public CrmPost findByAll(String postId) {
        return crmPostDao.findById(postId);
    }

    //分页
    @Override
    public PageBean<CrmPost> findAllP(CrmPost crmPost, int pageNum, int pageSize) {
        //要不然变负数
        if (pageNum == 0) pageNum ++;
//        String condition = "from CrmPost";
//        String condition1 = "select count(*) from CrmPost p";
        int totalRecord = crmPostDao.getTotalRecord(null, null);
        PageBean<CrmPost> pagBean = new PageBean<CrmPost>(pageNum, pageSize, totalRecord);
        List<CrmPost> data = crmPostDao.findAll(null, null, pagBean.getStartIndex(), pagBean.getPageSize());
        pagBean.setData(data);
        return pagBean;
    }


//    给予基类
//     return findAllPP(crmPost,pageNum,pageSize,hql,condition);
//    @Override
//    public PageBean<CrmPost> findAllPP(CrmPost crmPost, int pageNum, int pageSize, String hql, String condition) {
//        int totalRecord = crmPostDao.getTotalRecord(hql,null);
//        PageBean<CrmPost> pagBean = new PageBean<CrmPost>(pageNum, pageSize, totalRecord);
//        List<CrmPost> data = crmPostDao.findAll(condition, null, pagBean.getStartIndex(), pagBean.getPageSize());
//        pagBean.setData(data);
//
//        return pagBean;
//    }


}
