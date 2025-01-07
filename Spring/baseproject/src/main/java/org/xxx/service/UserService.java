package org.xxx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.xxx.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("" + i, "" + 200 + i, "" + 300 + i));
        }
        logger.info("---- 被代理的方法 UserService#findALl() 执行了 ------");
        return users;
    }


    /* 编程式事务 */
    private final TransactionTemplate transactionTemplate;

    public void 转账(){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // 转出操作

                // 转入操作

            }
        });
    }

    @Transactional // 声明式事务
    public void 转账2(){
        // 转出操作

        // 转入操作
    }
}
