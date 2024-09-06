package com.xxx.mybatisplus.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tb_user")
//@TableName(value = "tb_user",keepGlobalPrefix = false)
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("`username`")
    private String username;

    private String password;
    private String phone;
    private String info;
    private Integer status;
    private Integer balance;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime updateTime;

    @TableField(exist = false) // 数据库表中无此字段
    private String address;
}
