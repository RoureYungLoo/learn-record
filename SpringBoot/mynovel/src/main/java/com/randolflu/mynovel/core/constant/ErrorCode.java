package com.randolflu.mynovel.core.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    OK("00000","success"),
    USER_ERROR("A0001","用户端错误"),
    USER_REGISTER_ERROR("A0100","用户注册错误"),
    USER_VERIFY_CODE_ERROR("A0240","用户验证码错误" ),
    USER_NAME_EXIST("A0111","用户名已存在"),
    USER_COMMENTED("A2001","用户已发表评论" ),
    USER_ACCOUNT_NOT_EXIST("A0201","用户账号不存在"),
    USER_PASSWORD_ERROR("A0210","用户密码错误"),
    USER_REQUEST_PARAM_ERROR("A0400","用户请求参数错误" ),
    SYSTEM_ERROR("B0001","系统内部错误" );
    private final String code;
    private final String message;
}
