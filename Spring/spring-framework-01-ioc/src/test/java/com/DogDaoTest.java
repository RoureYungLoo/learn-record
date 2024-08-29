package com;

import com.xxx.config.Config2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config2.class})
public class DogDaoTest {

    @Test
    public void testDogDao(){

    }


}
