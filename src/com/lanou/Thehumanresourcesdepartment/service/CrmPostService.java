package com.lanou.Thehumanresourcesdepartment.service;

import com.lanou.Thehumanresourcesdepartment.domain.CrmPost;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface CrmPostService {
    List<CrmPost> findAll();

    void addOrEditPost(CrmPost crmPost);

    CrmPost findByAll(String postId);
    PageBean<CrmPost> findAllP(CrmPost crmPost,int pageNum,int pageSize);
//    PageBean<CrmPost> findAllPP(CrmPost crmPost,int pageNum,int pageSize,String hql,String condition);
}
