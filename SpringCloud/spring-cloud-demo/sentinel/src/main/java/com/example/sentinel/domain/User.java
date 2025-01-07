package com.example.sentinel.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    /* 基本信息 */
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    //    private String nickname;
//    private String truename;
//    private String avatar;
    @Column(nullable = false)
    private String password;
    //    private Integer gender;
//    private Integer age;
//
//    /* 联系信息 */
//    private String phone;
//    private String email;
//    private String addr;
//    private String emergeContact;
//
//    /* 工作信息 */
//    private String career;
//    private String married;
//    private String company;
//    private Integer salary;
//
//    /* 账号属性 */
//    private Integer level;
//    private Integer point;
//    private Date lastLogin;
//    private String status;
//    private Integer role;
//    private String notes;
    @Column(name = "created_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "updated_time", nullable = false)
    private Date updatedTime;
//    private Date createdBy;
//
//    /* 个性化信息 */
//    private String intro;
//    private Integer activeLevel;


    public User() {
    }

    public User(Long id, String username, String password, Date createdTime, Date updatedTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
