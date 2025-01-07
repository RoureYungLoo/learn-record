package org.example.dao;

import org.example.domain.MarkPO;
import org.example.domain.StudentMark;
import org.example.domain.StudentPO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.print.DocFlavor;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    private final PlatformTransactionManager transactionManager;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = transactionManager;
    }

    @Override
    public int insert(StudentPO studentPO, MarkPO markPO) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        int row = 1;
        try {
            String sql = "INSERT INTO tb_stu(`name`,age) VALUES(?,?) ";
            Object[] param = {studentPO.getName(), studentPO.getAge()};
            jdbcTemplate.update(sql, param);

            String sql2 = "SELECT max(id) FROM tb_stu";
            Integer latestId = jdbcTemplate.queryForObject(sql2, Integer.class);

            String sql3 = "INSERT INTO tb_mark(sid,marks,year) VALUES(?,?,?)";
            Object[] param3 = {latestId, markPO.getMarks(), markPO.getYear()};
            jdbcTemplate.update(sql3, param3);

            transactionManager.commit(status);
        } catch (Exception e) {
            System.out.println("StudentDaoImpl exception occurs, **rollback**");
            transactionManager.rollback(status);
            row = 0;
            throw e;
        }
        System.out.println("status: " + status.isCompleted());
        return row;
    }

    @Override
    public int delete(Long id) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        int row = 1;
        try {
            String sql = "DELETE FROM tb_stu WHERE id=?";
            Object[] param = {id};
            jdbcTemplate.update(sql, param);

            String sql2 = "DELETE FROM tb_mark WHERE sid=?";
            jdbcTemplate.update(sql2, id);

            transactionManager.commit(status);

        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            row = 0;
            throw e;
        }
        System.out.println("status: " + status.isCompleted());
        return row;
    }

    @Override
    public int update(StudentPO studentPO, MarkPO markPO) {
        int row = 1;
//        TransactionDefinition definition = new DefaultTransactionDefinition();
//        TransactionStatus status = transactionManager.getTransaction(definition);
        try {

            String sql = "UPDATE tb_stu SET `NAME`=?,age=? WHERE id=?";
            Object[] param = {studentPO.getName(), studentPO.getAge(), studentPO.getId()};
            jdbcTemplate.update(sql, param);

            String sql2 = "UPDATE tb_mark SET marks=?,year=? WHERE sid=?";
            Object[] param2 = {markPO.getMarks(), markPO.getYear(), studentPO.getId()};
            jdbcTemplate.update(sql2, param2);
            throw new RuntimeException();
//            transactionManager.commit(status);
        } catch (DataAccessException e) {
//            transactionManager.rollback(status);
            row = 0;
            throw e;
        }
//        System.out.println("status: " + status.isCompleted());

//        return row;

    }

    @Override
    public StudentPO selectOne(Long id) {
        String sql = "SELECT * FROM tb_stu WHERE id = ?";
        Object[] param = {id};
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StudentPO.class), param);
    }

    @Override
    public List<StudentPO> selectList() {
        String sql = "SELECT * FROM tb_stu";
        Object[] param = {};
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentPO.class), param);
    }
}
