package com;

import com.xxx.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class PropertyTest {

    @Value("${jdbc.driver}")
    private String driverName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Test
    public  void  testProperty(){
        System.out.println(driverName);
        System.out.println(url);
        System.out.println(password);
        System.out.println(username);
    }

}
