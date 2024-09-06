package com.xxx.mybatisplus.controller;


import cn.hutool.core.bean.BeanUtil;
import com.xxx.mybatisplus.domain.dto.UserFormDTO;
import com.xxx.mybatisplus.domain.po.User;
import com.xxx.mybatisplus.domain.query.UserQuery;
import com.xxx.mybatisplus.domain.vo.UserVO;
import com.xxx.mybatisplus.service.IUserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
//@Api(tags = "用户管理接口")
@Tag(name = "用户管理接口")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    //    @ApiOperation("新增用户")
    @Operation(summary = "新增用户")
    @PostMapping
    public void save(@RequestBody UserFormDTO userFormDTO) {
        User user = BeanUtil.copyProperties(userFormDTO, User.class); // DTO->PO
        iUserService.save(user);
    }

    //    @ApiOperation("删除用户")
    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        iUserService.removeById(id);
    }

    //    @ApiOperation("查询用户")
    @Operation(summary = "查询用户")
    @GetMapping("/{id}")
    public UserVO getById(@PathVariable("id") String id) {
        User user = iUserService.getById(id);
        return BeanUtil.copyProperties(user, UserVO.class); // PO->VO
    }

    //    @ApiOperation("查询用户列表")
    @Operation(summary = "查询用户列表")
    @GetMapping()
    public List<UserVO> getListByIds(@RequestParam("ids") List<Long> ids) {
        List<User> users = iUserService.listByIds(ids);
        return BeanUtil.copyToList(users, UserVO.class); // PO->VO
    }

    //    @ApiOperation("查询所有用户")
//    @Operation(summary = "查询所有用户")
//    @GetMapping
//    public List<UserVO> getUsers() {
//        List<User> userList = iUserService.list();
//        return BeanUtil.copyToList(userList, UserVO.class);
//    }

    /* 复杂业务示例 */
    @Operation(summary = "根据用户ID扣钱")
    @PutMapping("/{id}/deduction/{money}")
    @Parameters({
            @Parameter(name = "id", example = "1", description = "用户ID", required = true, in = ParameterIn.PATH),
            @Parameter(name = "money", example = "1234", description = "所扣金额", required = true, in = ParameterIn.PATH)
    })
//    @Schema()
    public void deductionById(
            @PathVariable("id") Long id,
            @PathVariable("money") Integer money
    ) {
        iUserService.deductionById(id, money);
    }

    /* lambda query */
    @GetMapping("/list")
    @Operation(summary = "多条件查询")
    @Parameters({
            @Parameter(name = "name", example = "lisi", description = "用户名"),
            @Parameter(name = "status", example = "1", description = "账户状态"),
            @Parameter(name = "minBalance", example = "3000", description = "余额最小值"),
            @Parameter(name = "maxBalance", example = "5000", description = "余额最大值")
    })
    public List<User> getUserList(UserQuery userQuery) {
        System.out.println(userQuery);
        return iUserService.getUserList(userQuery.getName(), userQuery.getStatus(), userQuery.getMinBalance(), userQuery.getMaxBalance());
    }



    /* lambda update */
    @PutMapping("/{id}/{money}")
    public void updateByLambda(
            @PathVariable("id") Integer id,
            @PathVariable("money") Integer money
    ) {
        iUserService.updateByLambda(id,money);
    }


}
