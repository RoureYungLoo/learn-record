package com.xxx.springbootconfigfile.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "email")
@Component
public class EmailProperties2 {
    // @Value("${email.user}")
    private String user;

    // @Value("${email.code}")
    private String code;

    // @Value("${email.host}")
    private String host;
    
    // @Value("${email.auth}")
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
}
