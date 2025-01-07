package org.example.service.impl;

import org.example.domain.MarkPO;
import org.example.domain.StudentPO;
import org.example.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
//@Transactional // 此处会自动回滚
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testAddStudent() {
        StudentPO studentPO = new StudentPO();
        studentPO.setName("李四");
        studentPO.setAge(25);

        MarkPO markPO = new MarkPO(null, 78.5d, 5);
        Assert.assertTrue(studentService.save(studentPO,markPO));
    }

    @Test
    public void testDeleteStudent() {

    }

    @Test
    public void testUpdate() {
        StudentPO studentPO = new StudentPO(4L, "lisi", 18);
        MarkPO markPO = new MarkPO(null, 60d, 3);
        boolean update = studentService.update(studentPO, markPO);
        Assert.assertTrue(update);
    }

    @Test
    public void testSelectOne() {
        System.out.println(studentService.selectOne(3L));
    }

    @Test
    public void testSelectList() {
        System.out.println(studentService.selectList());
    }
}
