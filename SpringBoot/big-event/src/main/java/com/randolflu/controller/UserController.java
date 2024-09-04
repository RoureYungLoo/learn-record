package com.randolflu.controller;

import com.randolflu.constants.Code;
import com.randolflu.constants.Msg;
import com.randolflu.pojo.Result;
import com.randolflu.pojo.User;
import com.randolflu.service.UserService;
import com.randolflu.utils.EncryptUtils;
import com.randolflu.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated // Validation校验
@CrossOrigin

public class UserController {

    @Autowired
    private UserService userService;

    /*用户注册*/
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public Result register(@Pattern(regexp = "^\\S{5,18}$") String username,
                           @Pattern(regexp = "^\\S{5,18}$") String password) {

        /* // 手动校验
        if (username != null && username.length() < 5 || username.length() > 18) {
            return Result.error(Code.OPTION_FAILED, Msg.REG_ERR);
        }
        if (password != null && password.length() < 5 || password.length() > 18) {
            return Result.error(Code.OPTION_FAILED, Msg.REG_ERR);
        } */

        // 用户名是否已被占用
        User user = userService.findByUserName(username);
        if (user == null) {
            int row = userService.add(username, password);
            if (row == Code.ROW_AFFECTED) { // 注册成功
                return Result.success(Code.OPTION_SUCCESS, Msg.REG_OK);
            } else {
                return Result.success(Code.ROW_NOT_AFFECTED, Msg.REG_ERR);
            }
        } else { // 用户名已被占用
            return Result.error(Code.OPTION_FAILED, Msg.REG_ERR_CAUSE);
        }
    }

    /* 重构 => Result 静态方法 */
    /*private <T> Result wrapResult(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }*/

    // @PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@Pattern(regexp = "^\\S{5,18}$") String username,
                        @Pattern(regexp = "^\\S{5,18}$") String password) {
        String token = userService.login(username, password);
        if (StringUtils.hasText(token)) {
            return Result.success(Code.OPTION_SUCCESS, Msg.OPTION_SUCCESS, token);
        }

        return Result.error(Code.OPTION_FAILED, Msg.LOGIN_ERR);
    }

    /* 获取用户详细信息 */
    @GetMapping("/info")
    public Result<User> UserInfo(@RequestHeader("Authorization") String token) {
        assert token != null : "no token";
        User user = userService.getUserInfo(token);
        return Result.success(user);
    }

    /* 更新用户信息 */
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        System.out.println(user);
        userService.update(user);
        return Result.success();
    }

    /* 更新密码 */
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        if (userService.updatePwd(params)){
            return Result.success();
        }
        return Result.error();
    }

    /* 更新用户头像 */
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }


}
