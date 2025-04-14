package com.xxx.accountservice.service.impl;

import com.xxx.accountservice.dao.AccountDao;
import com.xxx.accountservice.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {

        System.out.println("=== account-service 开始扣减账户余额");
        accountDao.decrease(userId,money);
        System.out.println("=== account-service 结束扣减账户余额");


    }
}
