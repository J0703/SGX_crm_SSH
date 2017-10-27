package com.lanou.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface BaseDao<T> {
    //查询所有
    List<T> findAll();

    //id查询
    T findById(Serializable id);

    //删除
    void delete(T t);

    //添加
    void save(T t);

    //更新
    void update(T t);

    //保存并更新
    void saveOrUpdate(T t);

    //条件查询
    List<T> findAll(String condition, Object... params);


}
