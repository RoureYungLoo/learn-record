package com.xxx.springbootconfigfile.controller;

import com.xxx.springbootconfigfile.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private  EmailService emailService;

    @RequestMapping("/send")
    public boolean send()  {
        String to = "694306515@qq.com";
        String title = "测试邮件";
        String content = "这是一封测试邮件.....";
        boolean flag = emailService.send(to,title,content);
        return flag;
    }

}
