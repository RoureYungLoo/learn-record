package com.xxx.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.mapper.UserMapper;
import com.xxx.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* 实现类 继承 ServiceImpl ,实现自定义的Service接口 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    /* 复杂业务示例 */
    @Override
    public void deductionById(Long id, Integer money) {

        User user = this.getById(id);

        assert user != null : "用户不存在";

        assert user.getStatus().equals(1) : "用户状态异常";

        assert money <= user.getBalance() : "余额不足";
        if (money > user.getBalance()) {
            throw new RuntimeException("余额不足了");
        }

        this.baseMapper.deductionById(id, money);
    }

    /* lambda query */
    public List<User> getUserList(String name, Integer status, Integer minBalance, Integer maxBalance) {

        List<User> userList = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .gt(minBalance != null, User::getBalance, minBalance)
                .lt(maxBalance != null, User::getBalance, maxBalance)
                .list();

        return userList;
    }

    @Override
    @Transactional
    public void updateByLambda(Integer id, Integer money) {
        User user = this.getById(id);

        assert user != null : "用户不存在";
        assert user.getStatus().equals(1) : "用户状态异常";

        int remainBalance = user.getBalance() - money;

        lambdaUpdate().set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) //  乐观锁
                .update();
    }
}
