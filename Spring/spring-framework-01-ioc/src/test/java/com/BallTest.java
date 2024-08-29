package com;

import com.xxx.config.Config5;
import com.xxx.entity.Apple;
import com.xxx.entity.Ball;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config5.class})
public class BallTest {

    @Resource
    private Ball ball;

    @Resource
    private Apple apple;

    @Test
    public void testBall(){
        ball.eat();
    }

    @Test
    public void testApple(){
        apple.show();
    }

}
