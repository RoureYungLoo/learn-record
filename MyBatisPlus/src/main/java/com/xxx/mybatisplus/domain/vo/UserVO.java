package com.xxx.mybatisplus.domain.vo;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.xxx.mybatisplus.domain.po.UserInfo;
import com.xxx.mybatisplus.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
//@ApiModel("用户VO实体")
@Schema(description = "用户信息")
public class UserVO {
    //    @ApiModelProperty("id")
    @Schema(description = "用户id")
    private Long id;

    //    @ApiModelProperty("username")
    @Schema(description = "用户名")
    private String username;

    //    @ApiModelProperty("info")
    @Schema(description = "用户信息对象")
    // private String info;
    private UserInfo info;

    //    @ApiModelProperty("status")
    @Schema(description = "用户状态")
    // private Integer status;
    private UserStatus status;

    //    @ApiModelProperty("balance")
    @Schema(description = "用户余额")
    private Integer balance;

    @Schema(description = "用户地址")
    private List<AddressVO> address;
}
