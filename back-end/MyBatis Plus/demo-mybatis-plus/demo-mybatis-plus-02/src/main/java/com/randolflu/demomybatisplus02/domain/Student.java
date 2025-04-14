package com.randolflu.demomybatisplus02.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_student")
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer sid;
    @TableField("s_name")
    private String sname;
    private Integer sage;
    private String ssex;
    private String sphone;

}
