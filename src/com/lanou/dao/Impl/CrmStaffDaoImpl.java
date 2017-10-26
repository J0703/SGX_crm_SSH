package com.lanou.dao.Impl;

import com.lanou.base.Impl.BaseDaoImpl;
import com.lanou.dao.CrmStaffDao;
import com.lanou.domain.CrmStaff;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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
}
