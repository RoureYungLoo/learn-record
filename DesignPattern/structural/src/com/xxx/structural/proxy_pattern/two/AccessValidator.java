package com.xxx.structural.proxy_pattern.two;

import java.util.Objects;

public class AccessValidator {
    /* 模拟验证 */
    public boolean Validate(String userId) {
        System.out.println("--- 正在验证, 请稍后 ---");
        if (Objects.isNull(userId) || userId.isBlank() || userId.isEmpty()) {
            return false;
        }
        return true;
    }
}
