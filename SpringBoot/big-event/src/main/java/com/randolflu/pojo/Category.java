package com.randolflu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class Category {
    /* 分组校验 */
    @NotNull(groups = {Update.class})
    private Integer id;

    /* 分组校验 */
    @NotEmpty(groups = {Add.class, Update.class},message = "分类名称不合法")
    @Pattern(regexp = "^\\S{1,10}$", groups = {Add.class, Update.class})
    private String categoryName;

    /* 分组校验 */
    @NotEmpty(groups = {Add.class,Update.class},message = "分类别名不合法")
    @Pattern(regexp = "^\\S{1,10}$", groups = {Add.class, Update.class})
    private String categoryAlias;

    private Integer createdUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    /* 分组 */
    public interface Add {
    }

    /* 分组 */
    public interface Update {
    }


}
