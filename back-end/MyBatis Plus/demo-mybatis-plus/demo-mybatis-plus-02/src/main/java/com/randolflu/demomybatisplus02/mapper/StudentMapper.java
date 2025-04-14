package com.randolflu.demomybatisplus02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.randolflu.demomybatisplus02.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
