package com.xxx.springbootconfigfile.service.impl;

import com.xxx.springbootconfigfile.pojo.EmailProperties;
import com.xxx.springbootconfigfile.service.EmailService;
import com.xxx.springbootconfigfile.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailProperties emailProperties;

    @Override
    public boolean send(String to, String title, String content) {
        boolean flag = false;
        System.out.println("emailProperties" + emailProperties);
        try {
            flag = MailUtil.sendMail(emailProperties, to, title, content);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
