package com.randolflu.pojo;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    private String state;
    private Integer categoryId;
    private Integer createdUser;
    private Date createdTime;
    private Date updatedTime;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", state='" + state + '\'' +
                ", categoryId=" + categoryId +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Article(Integer id, String title, String content, String coverImg, String state, Integer categoryId, Integer createdUser, Date createdTime, Date updatedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.coverImg = coverImg;
        this.state = state;
        this.categoryId = categoryId;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Article() {
    }
}
