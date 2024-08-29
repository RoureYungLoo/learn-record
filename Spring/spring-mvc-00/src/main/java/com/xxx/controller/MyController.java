package com.xxx.controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.xxx.enrity.User;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class MyController {

    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "在ModelAndView中处理了some.do请求");
        mv.addObject("func", "执行了doSome()");

//        mv.setViewName("/WEB-INF/view/show.jsp");

        mv.setViewName("show");

        return mv;
    }

    /* 1，获取单个参数 */
    @RequestMapping(value = "/sayHi1")
    public String sayHi1(String name) {
        System.out.println("sayHi: " + name);
        return "Hi" + name;
    }

    /* 2，获取多个参数 */
    @RequestMapping(value = "/sayHi2")
    public String sayHi2(String name, String password) {
        return "name: " + name + ", " + password;
    }

    /* 3，获取普通对象 */
    @RequestMapping(value = "/sayHi3")
    public Object sayHi3(User user) {
        return user;
    }

    /* 4，获取Json对象 */
    @RequestMapping(value = "/sayHi4")
    public Object sayHi4(@RequestBody User user) {
        return user;
    }

    /* 5、获取基础URL问号(?)之前的参数 */
    @RequestMapping(value = "/sayHi5/{uname}/{pwd}")
    public Object sayHi5(@PathVariable(value = "uname") String name,
                         @PathVariable(value = "pwd") String password) {
        return "name: " + name + ", password: " + password;
    }

    /* 6、获取上传文件 */
    @RequestMapping(value = "/upload")
    public Object upLoad(MultipartFile file) {

        String uuid = UUID.randomUUID().toString();
        File saveFile = new File("D:\\Image\\" + uuid + ".png");
        try {
            file.transferTo(saveFile);
            return "Upload Success";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Upload Failed";
    }

    /* 7、获取Header */
    @RequestMapping(value = "/getHeader")
    public Object getHeader(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    /* 8、获取Cookie */
    @RequestMapping(value = "/getCookie")
    public Object getCookie(@CookieValue("testCookie") String testCookie) {
        return "Cookie" + testCookie;
    }

    /* 9、获取Session */
    private static final String SESSION_KEY = "USER_SESSION_KEY";

    @RequestMapping(value = "/setSesssion")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_KEY, "xaioming");
        return "Session 存储成功";
    }

    @RequestMapping(value = "/getSesssion")
    public Object getSession(@SessionAttribute(SESSION_KEY) String session) {
        return "SESSION_KEY = " + session;
    }

}
