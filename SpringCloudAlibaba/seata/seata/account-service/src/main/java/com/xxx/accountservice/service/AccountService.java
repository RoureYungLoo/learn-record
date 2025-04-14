package com.xxx.accountservice.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {
    void decrease(
            @RequestParam("userId") Long userId,
            @RequestParam("money") BigDecimal money
    );
}
