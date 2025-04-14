package com.randolflu.demomybatisplus02;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.randolflu.demomybatisplus02.domain.Student;
import com.randolflu.demomybatisplus02.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoMybatisPlus02ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectList() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }

    @Test
    public void selectById() {
        System.out.println(studentMapper.selectById(10));
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("s_name", "新名字");
        System.out.println(studentMapper.selectByMap(map));
    }

    @Test
    public void selectByBatchIds() {
        List<Student> students = studentMapper.selectByIds(Arrays.asList(10, 11));
        students.forEach(System.out::println);
    }


    @Test
    public void insert() {
        Student student = new Student();
        student.setSname("张杰");
        student.setSage(28);
        student.setSsex("1");
        student.setSphone("12344448888");

        int insert = studentMapper.insert(student);

        System.out.println("影响行数：" + insert);
        System.out.println("主键: " + student.getSid());
    }

    @Test
    public void updateById() {
        Student student = new Student();
        student.setSid(11);
        student.setSname("新名字");

        int updated = studentMapper.updateById(student);
        System.out.println("影响行数：" + updated);
    }

    @Test
    public void deleteById() {
        int deleted = studentMapper.deleteById(8);
        System.out.println("影响行数：" + deleted);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("s_name", "赵六六");
        int deleted = studentMapper.deleteByMap(map);
        System.out.println("影响行数：" + deleted);

    }


    @Test
    public void deleteByIds() {
        int deleted = studentMapper.deleteByIds(Arrays.asList(6, 7));
        System.out.println("影响行数：" + deleted);
    }

    @Test
    public void Analysis() {
        // Wrapper
        // AbstractWrapper
//        AbstractLambdaWrapper
//        LambdaQueryWrapper
//        LambdaUpdateWrapper
//        QueryWrapper
//        UpdateWrapper

    }

    @Test
    public void Wrapper01() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("sage", 12)
                .isNotNull("s_name");

        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void Wrapper02() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_name", "小特");
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void Wrapper03() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("sage", 20, 30);
        Long count = studentMapper.selectCount(queryWrapper);
        System.out.println("count: " + count);
    }

    @Test
    public void Wrapper04() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

//        queryWrapper.like("sphone", 4);
//        queryWrapper.likeRight("s_name","小");
        queryWrapper.likeLeft("s_name", "迪");

        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void Wrapper05() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
//        queryWrapper.inSql("sid", "select sid from t_student where sid > 10");
        queryWrapper.inSql("sid", "select sid from t_student where sid > 10")
                .orderByDesc("sage");
//        List<Object> objects = studentMapper.selectObjs(queryWrapper);
//        objects.forEach(System.out::println);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);

    }
}