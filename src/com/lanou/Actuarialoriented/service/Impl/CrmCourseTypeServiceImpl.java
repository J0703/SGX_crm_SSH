package com.lanou.Actuarialoriented.service.Impl;

import com.lanou.Actuarialoriented.dao.CrmCourseTypeDao;
import com.lanou.Actuarialoriented.domain.CrmCourseType;
import com.lanou.Actuarialoriented.service.CrmCourseTypeService;
import com.lanou.util.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class CrmCourseTypeServiceImpl implements CrmCourseTypeService {
    private CrmCourseTypeDao crmCourseTypeDao;


    public CrmCourseTypeDao getCrmCourseTypeDao() {
        return crmCourseTypeDao;
    }

    public void setCrmCourseTypeDao(CrmCourseTypeDao crmCourseTypeDao) {
        this.crmCourseTypeDao = crmCourseTypeDao;
    }

    //分页+高级搜索
    @Override
    public PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize) {
        //拼凑条件
        StringBuilder stringBuilder = new StringBuilder();
        //拼凑参数
       List<Object> paramsList = new ArrayList<>();
        if (StringUtils.isNotBlank(crmCourseType.getCourseName())){
            stringBuilder.append(" and courseName like ?");
            paramsList.add("%"+crmCourseType.getCourseName()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getRemark())){
            stringBuilder.append(" and remark like ?");
            paramsList.add("%"+crmCourseType.getRemark()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalStart())){
            stringBuilder.append(" and total >= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())){
            stringBuilder.append(" and total <= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getLessonCostStart())){
            stringBuilder.append(" and courseCost >= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getLessonCostStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getLessonCostEnd())){
            stringBuilder.append(" and courseCost <= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getLessonCostEnd()));
        }
        String condition = stringBuilder.toString();
        Object[] params = paramsList.toArray();

//        return crmCourseTypeDao.findAll(condition,params);
        if (pageNum == 0) pageNum ++;
//        String condition = "from CrmCourseType";
//        String condition1 = "select count(*) from CrmCourseType c";
        int totalRecord = crmCourseTypeDao.getTotalRecord(condition, params);
        PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
        List<CrmCourseType> data = crmCourseTypeDao.findAll(condition, params, pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);

        return pageBean;
    }
}
