package org.example.service;

import org.example.domain.MarkPO;
import org.example.domain.StudentPO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    /*增*/
    boolean save(StudentPO studentPO, MarkPO markPO);

    /*删*/
    boolean remove(Long id);

    /*改*/
    boolean update(StudentPO studentPO,MarkPO markPO);

    /*查*/
    StudentPO selectOne(Long id);

    List<StudentPO> selectList();
}
