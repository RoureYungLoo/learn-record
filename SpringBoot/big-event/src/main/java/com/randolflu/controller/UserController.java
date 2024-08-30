package com.randolflu.controller;

import com.randolflu.constants.Code;
import com.randolflu.constants.Msg;
import com.randolflu.pojo.Result;
import com.randolflu.pojo.User;
import com.randolflu.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated // Validation校验
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
}
