package com.xxx.springbootconfigfile.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProperties {
    // 发件人
    @Value("${email.user}")
    private String user;

    // 授权码
    @Value("${email.code}")
    private String code;

    // 发件人邮箱服务器
    @Value("${email.host}")
    private String host;

    // 发送邮件前，是否验证发件人的信息
    @Value("${email.auth}")
    private boolean auth;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "EmailProperties{" +
                "user='" + user + '\'' +
                ", code='" + code + '\'' +
                ", host='" + host + '\'' +
                ", auth=" + auth +
                '}';
    }
}
