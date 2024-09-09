package com.xxx.mybatisplus.domain.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Schema(description = "用户分页查询参数")
public class UserQuery extends PageQuery{
    @Schema(description = "用户名",defaultValue = "zhangsan")
    private String name;
    @Schema(description = "账号状态",defaultValue = "正常")
    private Integer status;
    @Schema(description = "余额最小值",defaultValue = "200")
    private Integer minBalance;
    @Schema(description = "余额最大值",defaultValue = "2000")
    private Integer maxBalance;
}
