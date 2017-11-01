package com.lanou.Thehumanresourcesdepartment.dao.Impl;

import com.lanou.base.Impl.BaseDaoImpl;
import com.lanou.Thehumanresourcesdepartment.dao.CrmPostDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmPost;

/**
 * Created by dllo on 17/10/25.
 */
public class CrmPostDaoImpl extends BaseDaoImpl<CrmPost> implements CrmPostDao {

//    @Override
//    public int getTotalRecord(String condition, Object[] params) {
//        String hql = "seclect count(c) from CrmPost c where 1=1"+condition;
//        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql, params);
//        if (find !=null){
//            return find.get(0).intValue();
//        }
//        return 0;
//    }

    //不写
//    @Override
//    public List<CrmPost> findAllPageBean(String condition, Object[] params, int startIndex, int pageSize) {
//       String hql = "from CrmPost where 1=1" +condition;
////hql没有分页函数,可以使用execute来实现
//
//        return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmPost>(hql,params,startIndex,pageSize));
//
//    }
}
