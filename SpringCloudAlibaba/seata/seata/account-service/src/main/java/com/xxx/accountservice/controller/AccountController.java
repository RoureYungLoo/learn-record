package com.xxx.accountservice.controller;

import com.xxx.accountservice.domain.CommonResult;
import com.xxx.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/decrease")
    public CommonResult decrease(
            @RequestParam("userId") Long userId,
            @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId,money);

        return new CommonResult(200,"账户余额扣减成");
    }
}
