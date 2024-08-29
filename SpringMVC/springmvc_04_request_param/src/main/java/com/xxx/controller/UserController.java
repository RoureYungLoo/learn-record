package com.xxx.controller;

import com.xxx.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递 name ==> " + name);
        System.out.println("普通参数传递 age ==> " + age);
        return "{\"module\":\"common param\"}";
    }

    @RequestMapping("/commondiffname")
    @ResponseBody
    /* 普通参数: 请求参数名与形参名不同 */
    public String commonParamDiffName(@RequestParam("name") String username, int age) {
        System.out.println("普通参数传递 username ==> " + username);
        System.out.println("普通参数传递 age ==> " + age);
        return "{\"module\":\"common param different name\"}";
    }

    /* POJO类型参数 */
    @RequestMapping("/pojoparam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("POJO参数传递 user ===> " + user);
        return "{\"module\":\"pojo param\"}";
    }


    /* 嵌套POJO类型参数 */
    @RequestMapping("/nestedpojoparam")
    @ResponseBody
    public String nestedPojoParam(User user) {
        System.out.println("嵌套POJO参数传递  user ===> " + user);
        return "{\"module\":\"nested pojo param\"}";
    }

    /* 数组参数 */
    @RequestMapping("/arrayparam")
    @ResponseBody
    public String arrayParam(String[] hobby) {
        System.out.println("数组类型参数传递 hobby ===> " + Arrays.toString(hobby));
        return "{\"module\":\"array param\"}";
    }

    /* 集合参数 */
    @RequestMapping("/listparam")
    @ResponseBody
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println("集合类型参数传递 hobby ===> " + (hobby));
        return "{\"module\":\"list param\"}";
    }

    /* 集合参数:json格式 */
    @RequestMapping("/listparamjson")
    @ResponseBody
    public String listParamJson(@RequestBody List<String> hobby) {
        System.out.println("list common(json)参数传递 ==> " + hobby);
        return "{\"module\":\"list common for json param\"}";
    }

    /* POJO参数:json */
    @RequestMapping("/pojoparamjson")
    @ResponseBody
    public String pojoParamJson(@RequestBody User user) {
        System.out.println("pojo(json)参数传递 ==> " + user);
        return "{\"module\":\"pojo for json param\"}";
    }

    /* POJO集合参数:json */
    @RequestMapping("/listPojoParamJson")
    @ResponseBody
    public String listPojoParamJson(@RequestBody List<User> users) {
        System.out.println("list pojo(json)参数传递 ==> " + users);
        return "{\"module\":\"list pojo for json param\"}";
    }

    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")Date date2){
        System.out.println("参数传递 date ==> "+ date);
        System.out.println("参数传递 date(yyyy-MM-dd)==> "+ date1);
        System.out.println("参数传递 date(yyyy/MM/dd HH:mm:ss)==> "+ date2);
        return "{\"module\":\"date param\"}";
    }


}
