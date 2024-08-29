package com;

import com.xxx.config.Config3;
import com.xxx.config.Config4;
import com.xxx.dao.People;
import com.xxx.service.PenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {Config3.class})
@ContextConfiguration(classes = {Config4.class})
public class PenServiceTest {

    @Resource
    private PenService penService;
    @Test
    public void testPenService(){
        System.out.println(penService);
    }

    @Resource
    private People p1;
    @Resource
    private People p2;
    @Resource
    private People p3;

    @Test
    public void testPeople() {
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
