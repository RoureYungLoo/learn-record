package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.domain.MarkPO;
import org.example.domain.StudentPO;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    private final PlatformTransactionManager transactionManager;

    public StudentServiceImpl(StudentDao studentDao, PlatformTransactionManager transactionManager) {
        this.studentDao = studentDao;
        this.transactionManager = transactionManager;
    }

//    public StudentServiceImpl(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    @Override
    public boolean save(StudentPO studentPO, MarkPO markPO) {
        return studentDao.insert(studentPO,markPO)>0;
    }

    @Override
    public boolean remove(Long id) {
        return studentDao.delete(id)>0;
    }

    @Override
    public boolean update(StudentPO studentPO,MarkPO markPO) {
        return studentDao.update(studentPO,markPO)>0;
    }

    @Override
    public StudentPO selectOne(Long id) {
        return studentDao.selectOne(id);
    }

    @Override
    public List<StudentPO> selectList() {
        return studentDao.selectList();
    }
}
