package com;

import com.xxx.config.SpringConfiguration;
import com.xxx.dao.CatDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class CatDaoTest {

    // @Resource(name = "cdia")
    @Resource(name = "cdib")
    private CatDao catDao;

    @Test
    public void catDaoTest(){
        catDao.findAll();
    }

}
