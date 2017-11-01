package com.lanou.Thehumanresourcesdepartment.dao.Impl;

import com.lanou.base.Impl.BaseDaoImpl;
import com.lanou.Thehumanresourcesdepartment.dao.CrmStaffDao;
import com.lanou.Thehumanresourcesdepartment.domain.CrmStaff;
import com.lanou.util.PageHibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class CrmStaffDaoImpl extends BaseDaoImpl<CrmStaff> implements CrmStaffDao {

    @Override
    public CrmStaff login(String loginName, String loginPwd) {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) this.getHibernateTemplate().find("from  CrmStaff  where loginName = ? and loginPwd = ?",loginName,loginPwd);
        if (crmStaffs !=null&& crmStaffs.size()>0){
            return crmStaffs.get(0);
        }


        return null;
    }

    @Override
    public List<CrmStaff> finBypostId(String postId) {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff where postId =?", postId);
        return crmStaffs;
    }



//分页
    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "seclect count(c) from CrmPost c where 1=1"+condition;
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql, params);
        if (find !=null){
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CrmStaff> findAllPageBean(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from CrmStaff where 1=1" +condition;
//hql没有分页函数,可以使用execute来实现

        return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmStaff>(hql,params,startIndex,pageSize));

    }

}
