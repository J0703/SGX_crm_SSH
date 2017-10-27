package com.lanou.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */

public class CrmDepartment {
    private String depId;
    private String depName;

    private Set<CrmPost> posts = new HashSet<>();

    public Set<CrmPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<CrmPost> posts) {
        this.posts = posts;
    }

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
