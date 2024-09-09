package com.xxx.mybatisplus.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "地址信息")
public class AddressVO {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "用户id")
    private Long userId;
    @Schema(description = "省")
    private String province;
    @Schema(description = "市")
    private String city;
    @Schema(description = "区")
    private String town;
    @Schema(description = "手机号码")
    private String mobile;
    @Schema(description = "街道")
    private String street;
    @Schema(description = "联系人")
    private String contact;
    @Schema(description = "默认地址")
    private Boolean isDefault;
    @Schema(description = "备注")
    private String notes;

}
