package com.example.nacosconfig.config;

import com.example.nacosconfig.domain.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RefreshScope // 从配置中心刷新配置
@ConfigurationProperties(prefix = "student") // 属性配置
public class StuConfig implements Serializable {
    public static final long serialVersionID = 1L;
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StuConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

