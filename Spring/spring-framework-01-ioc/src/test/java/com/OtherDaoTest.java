package com;

import com.xxx.config.SpringConfiguration;
import com.xxx.dao.OtherDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class OtherDaoTest {

    @Resource
    private OtherDao otherDao;

    @Test
    public void testOtherDao(){
        otherDao.findAll();
    }
}
