package org.example.dao;

import org.example.domain.MarkPO;
import org.example.domain.StudentMark;
import org.example.domain.StudentPO;

import java.util.List;

public interface StudentDao {
    /*增加*/
    int insert(StudentPO studentPO, MarkPO markPO);

    /* 删除 */
    int delete(Long id);

    /* 修改 */
    int update(StudentPO studentPO,MarkPO markPO);

    /* 查询 */
    StudentPO selectOne(Long id) ;

    List<StudentPO> selectList();
}
