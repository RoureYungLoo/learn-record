package com.xxx.mybatisplus.domain.dto;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
//@ApiModel(description = "用户表单实体")

public class UserFormDTO {
//    @ApiModelProperty("id")
    private Long id;
//    @ApiModelProperty("username")
    private String username;
//    @ApiModelProperty("password")
    private String password;
//    @ApiModelProperty("phone")
    private String phone;
//    @ApiModelProperty("info")
    private String info;
//    @ApiModelProperty("balance")
    private Integer balance;
}
