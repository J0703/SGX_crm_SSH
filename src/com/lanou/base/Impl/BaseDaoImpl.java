package com.lanou.base.Impl;

import com.lanou.base.BaseDao;
import com.lanou.util.PageHibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class<T> tClass;
    private List<Long> find;
    private String hql;
//parameterizedType 获取java泛型参数类型
    public BaseDaoImpl() {
        // this ,在运行时表示的【当前运行类】。在编译时表示就是【当前类】
        // 1 获得当前运行类的父类，父类具有泛型信息，
        ParameterizedType parameterizedType =  (ParameterizedType) this.getClass().getGenericSuperclass();
        // 2 获得实际参数
        tClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
    @Override
    public List<T> findAll() {
       return (List<T>) this.getHibernateTemplate().find("from " + tClass.getName());



    }

    @Override
    public T findById(Serializable id) {
        T t = this.getHibernateTemplate().get(tClass, id);
        return t;
    }


    @Override
    public void delete(T t) {
      this.getHibernateTemplate().delete(t);
    }

    @Override
    public void save(T t) {

        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
     this.getHibernateTemplate().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {

      this.getHibernateTemplate().saveOrUpdate(t);
    }

    //条件查询(高级查询)
    @Override
    public List<T> findAll(String condition, Object[] params) {
        String hql = "from " + tClass.getName() + " where 1=1 " + condition;
        return (List<T>) this.getHibernateTemplate().find(hql , params);
    }
    //分页+高级查询
    @Override
    public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        if (condition != null ){
            hql = "from "+ tClass.getName()+" where 1=1 "+condition;

        }else {
            hql = "from " + tClass.getName();
        }
        return this.getHibernateTemplate().execute(
                new PageHibernateCallback<>(hql, params, startIndex, pageSize));
    }
    //总记录数 4 +高级查询
    @Override
    public int getTotalRecord(String condition, Object[] params) {
        if (condition !=null){
            hql = "select count(*) from "+tClass.getName()+ " c where 1=1"+condition;

        }else {
            hql = "select count(*) from " + tClass.getName();
        }

        if (params == null) {
            find = (List<Long>) this.getHibernateTemplate().find(hql);
        }
            find = (List<Long>) this.getHibernateTemplate().find(hql, params);


        if (find !=null){
            return find.get(0).intValue();
        }
        return 0;
    }


}
