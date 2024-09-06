package com.xxx.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xxx.mybatisplus.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 自定义SQL
    void updateBalanceById(
//            @Param(Constants.WRAPPER) LambdaQueryWrapper<User> lambdaQueryWrapper,

            // 这里必须是ew
            @Param("ew") LambdaQueryWrapper<User> lambdaQueryWrapper,
            @Param("amount") int amount);


    @Update("UPDATE tb_user SET balance = balance - #{money} WHERE id = #{id}")
    void deductionById(@Param("id") Long id, @Param("money") Integer money);

}
