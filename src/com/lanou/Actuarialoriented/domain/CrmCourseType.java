package com.lanou.Actuarialoriented.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/31.
 */

public class CrmCourseType {
    private String courseTypeId;
    private Double courseCost;
    private Integer total; //总学时
    private String courseName;
    private String remark;//备注

    //条件查询
    private String totalStart;
    private String totalEnd;
    private String lessonCostStart;
    private String lessonCostEnd;





    public String getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }

    public String getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    public String getLessonCostStart() {
        return lessonCostStart;
    }

    public void setLessonCostStart(String lessonCostStart) {
        this.lessonCostStart = lessonCostStart;
    }

    public String getLessonCostEnd() {
        return lessonCostEnd;
    }

    public void setLessonCostEnd(String lessonCostEnd) {
        this.lessonCostEnd = lessonCostEnd;
    }

    @Override
    public String toString() {
        return "CrmCourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }


    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
