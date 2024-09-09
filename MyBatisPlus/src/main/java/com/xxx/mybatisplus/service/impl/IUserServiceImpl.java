package com.xxx.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.xxx.mybatisplus.domain.dto.PageDTO;
import com.xxx.mybatisplus.domain.po.Address;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.domain.query.UserQuery;
import com.xxx.mybatisplus.domain.vo.AddressVO;
import com.xxx.mybatisplus.domain.vo.UserVO;
import com.xxx.mybatisplus.enums.UserStatus;
import com.xxx.mybatisplus.mapper.UserMapper;
import com.xxx.mybatisplus.service.IUserService;
import org.apache.ibatis.ognl.ASTShiftRight;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* 实现类 继承 ServiceImpl ,实现自定义的Service接口 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    /* 复杂业务示例 */
    @Override
    public void deductionById(Long id, Integer money) {

        User user = this.getById(id);

        assert user != null : "用户不存在";

        assert user.getStatus().equals(UserStatus.NORMAL) : "用户状态异常";

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
        assert user.getStatus().equals(UserStatus.NORMAL) : "用户状态异常";

        int remainBalance = user.getBalance() - money;

        lambdaUpdate().set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) //  乐观锁
                .update();
    }

    /* 根据id查询用户信息，包含用户地址 */

    @Override
    public UserVO getUserInfoById(String id) {
        // 1. 查询用户PO
        User user = this.getById(id);

        assert user != null : "用户不存在";
        //if (user.getStatus() == 2) {
        if (user.getStatus() == UserStatus.ABNORMAL) {
            throw new RuntimeException("用户已被冻结");
        }
        // 2. 查询地址PO
        List<Address> addressList = Db.lambdaQuery(Address.class).eq(Address::getUserId, id).list();
        // PO->VO
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        //
        List<AddressVO> addressVOList = BeanUtil.copyToList(addressList, AddressVO.class);
        userVO.setAddress(addressVOList);

        return userVO;
    }

    /* 根据id查询用户信息列表，包含用户地址 */
    public List<UserVO> getUserInfoByIds(List<Long> ids) {

        /* user PO list */
        List<User> users = this.listByIds(ids);

        /* address PO list */
        List<Address> addressList = Db.lambdaQuery(Address.class).in(Address::getUserId, ids).list();
        List<AddressVO> addressVOS = BeanUtil.copyToList(addressList, AddressVO.class);

        /* 分组 */
        Map<Long, List<AddressVO>> addressMap = addressVOS.stream().collect(Collectors.groupingBy(AddressVO::getUserId));

        List<UserVO> userVOList = new ArrayList<>(users.size());
        for (User user : users) {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            userVO.setAddress(addressMap.get(user.getId()));
            userVOList.add(userVO);
        }
        return userVOList;
    }

    /* 条件分页查询用户 */
    public PageDTO<UserVO> getUsersByPage(UserQuery userQuery) {

        // 取出参数方便校验
//        Integer pageNo = userQuery.getPageNo();
//        Integer pageSize = userQuery.getPageSize();
//        String sortBy = userQuery.getSortBy();
//        Boolean isAsc = userQuery.getIsAsc();
        String name = userQuery.getName();
        Integer status = userQuery.getStatus();

        Page<User> page = userQuery.toMpPageDefaultSortByCreateTime();
        // 分页
//        if (pageNo == null || pageSize == null) {
//            throw new RuntimeException("分页参数不合法");
//        }
//        page = new Page<>(pageNo, pageSize);
//
//        Page<User> p = null;
//        if (StrUtil.isNotBlank(sortBy)) {
//            p = page.addOrder(new OrderItem().setColumn(sortBy).setAsc(isAsc));
//        }else{ // 默认根据create_time排序
//            p = page.addOrder(new OrderItem().setColumn("update_time").setAsc(isAsc));
//        }

        // 查询条件
        Page<User> userPage = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status).page(page);

//        PageDTO<UserVO> pageDTO = new PageDTO<>();
//        pageDTO.setTotal(userPage.getTotal());
//        pageDTO.setPages(userPage.getPages());
//
//        // PO
//        List<User> userList = userPage.getRecords();
//
//        // PO -> VO
//        List<UserVO> vos = BeanUtil.copyToList(userList, UserVO.class);
//        // VO -> DTO
//        pageDTO.setList(vos);

        PageDTO<UserVO> pageDTO = PageDTO.of(page, UserVO.class);
        return pageDTO;
    }

    public PageDTO<UserVO> getUsersByPage2(UserQuery userQuery) {
        String name = userQuery.getName();
        Integer status = userQuery.getStatus();

        Page<User> page = userQuery.toMpPageDefaultSortByCreateTime();
        // 查询条件
        Page<User> userPage = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status).page(page);

        // return PageDTO.of(userPage, UserVO.class);
        return PageDTO.of(userPage, user -> {
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            // vo的特殊处理

            return vo;
        });
    }
}
