package com.lanou.domain;

import javax.persistence.*;

/**
 * Created by dllo on 17/10/25.
 */

public class CrmDepartment {
    private String depId;
    private String depName;


    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;

    }

    public CrmDepartment() {
    }

    public CrmDepartment(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "CrmDepartment{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }
}
