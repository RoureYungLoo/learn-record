package com.xxx.mybatisplus.domain.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Schema(description = "用户信息对象")
public class UserInfo { // 用于JSON处理器
    @Schema(description = "年龄")
    private Integer age;
    @Schema(description = "简介")
    private String intro;
    @Schema(description = "性别")
    private String gender;
}
