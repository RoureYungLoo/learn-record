package com.xxx.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.mybatisplus.domain.dto.PageDTO;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.domain.query.UserQuery;
import com.xxx.mybatisplus.domain.vo.UserVO;

import java.util.List;

/* 接口继承 IService */
public interface IUserService extends IService<User> {
    void deductionById(Long id, Integer money);

    List<User> getUserList(String name, Integer status, Integer minBalance, Integer maxBalance);

    void updateByLambda(Integer id, Integer money);

    UserVO getUserInfoById(String id);

    List<UserVO> getUserInfoByIds(List<Long> ids);

    PageDTO<UserVO> getUsersByPage(UserQuery userQuery);
}
