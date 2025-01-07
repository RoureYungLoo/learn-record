package com.randolflu.mynovel.manager.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.randolflu.mynovel.core.constant.DatabaseConsts;
import com.randolflu.mynovel.dao.entity.UserInfo;
import com.randolflu.mynovel.dao.mapper.UserInfoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户模块 DAO管理类
 *
 * @author xiongxiaoyang
 * @date 2022/5/20
 */
@Component
@RequiredArgsConstructor
public class UserDaoManager {

    private final UserInfoMapper userInfoMapper;

    /**
     * 根据用户ID集合批量查询用户信息列表
     *
     * @param userIds 需要查询的用户ID集合
     * @return 满足条件的用户信息列表
     */
    public List<UserInfo> listUsers(List<Long> userIds) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(DatabaseConsts.CommonColumnEnum.ID.getName(), userIds);
        return userInfoMapper.selectList(queryWrapper);
    }

}
