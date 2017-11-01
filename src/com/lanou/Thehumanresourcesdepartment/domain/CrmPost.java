package com.lanou.Thehumanresourcesdepartment.domain;

/**
 * Created by dllo on 17/10/25.
 */

public class CrmPost {
    private String postId;
    private String postName;


    private CrmDepartment crmDepartment;

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
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
