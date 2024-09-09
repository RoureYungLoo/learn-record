package com.xxx.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL(1, "正常"),
    ABNORMAL(2, "异常"),
    ;

    @EnumValue
    // @JsonValue
    private Integer value;
    @JsonValue
    private String desc;

    UserStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
