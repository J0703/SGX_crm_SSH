package com.lanou.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */

public class CrmPost {
    private String postId;
    private String postName;

    private Set<CrmStaff> crmStaffs = new HashSet<>();

    public Set<CrmStaff> getCrmStaffs() {
        return crmStaffs;
    }

    public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
        this.crmStaffs = crmStaffs;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public CrmPost() {
    }

    public CrmPost(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "CrmPost{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
