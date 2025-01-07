package com.example.nacosconfig.controller;

import com.example.nacosconfig.config.StuConfig;
import com.example.nacosconfig.domain.Student;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocaleCache:false}")
    private String useLocaleCache;

    @GetMapping("/get")
    public String get() {
        return useLocaleCache;
    }

    @Autowired
    private StuConfig stuConfig;

    @GetMapping("/getstu")
    public Student getStu() {
//        Student student = new Student();
//        student.setAge(stuConfig.getAge());
//        student.setName(stuConfig.getName());
//        return student;

        return new Student(stuConfig);
    }
}
