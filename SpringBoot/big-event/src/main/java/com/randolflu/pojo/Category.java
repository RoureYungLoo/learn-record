package com.randolflu.pojo;

import java.util.Date;

public class Category {
    private Integer id;
    private String categoryName;
    private String categoryAlias;
    private Integer createdUser;
    private Date createdTime;
    private Date updatedTime;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAlias='" + categoryAlias + '\'' +
                ", createdUser=" + createdUser +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Category(Integer id, String categoryName, String categoryAlias, Integer createdUser, Date createdTime, Date updatedTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryAlias = categoryAlias;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Category() {
    }
}
