package com.xxx.springbootconfigfile.utils;

import com.xxx.springbootconfigfile.pojo.EmailProperties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


import java.util.Properties;

public class MailUtil {
    public static boolean sendMail(EmailProperties emailProperties, String to, String title, String content) throws Exception {

        // 设置SMTP服务器属性
        Properties properties = new Properties();
        properties.put("mail.smtp.host", emailProperties.getHost()); // 示例SMTP服务器地址
        properties.put("mail.smtp.port", "587"); // SMTP服务器端口 465或587
        properties.put("mail.smtp.auth", emailProperties.isAuth()); // 需要请求身份认证
        properties.put("mail.smtp.starttls.enable", "true"); // 启用TLS

        // 创建Session实例对象
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperties.getUser(), emailProperties.getCode()); // 发件人邮箱账号、密码
            }
        });

        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailProperties.getUser())); // 发件人邮箱账号
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 收件人邮箱账号
        message.setSubject(title); // 邮件主题
        message.setText(content); // 邮件正文

        // 发送邮件
        Transport.send(message);
        System.out.println("邮件发送成功！");
        return true;

    }
}
