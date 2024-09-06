package com.xxx.mybatisplus.domain.vo;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//@ApiModel("用户VO实体")
@Schema(name = "用户VO实体")
public class UserVO {
    //    @ApiModelProperty("id")
    @Schema(description = "用户id")

    private Long id;
    //    @ApiModelProperty("username")
    @Schema(description = "用户名")

    private String username;
    //    @ApiModelProperty("info")
    @Schema(description = "用户信息JSON")

    private String info;
    //    @ApiModelProperty("status")
    @Schema(description = "用户状态")

    private Integer status;
    //    @ApiModelProperty("balance")
    @Schema(description = "用户余额")

    private Integer balance;
}
