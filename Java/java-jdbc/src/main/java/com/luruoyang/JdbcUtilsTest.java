package com.luruoyang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class JdbcUtilsTest {
  public static void main(String[] args) throws Exception {

//    testInsert();
//    testDelete();
//    testUpdate();
    testQuery();

  }

  private static void testQuery() throws Exception {
    String sql = "select * from emp where id between ? and ?";

    List<Emp> emps = JdbcUtils.executeQuery(sql, Emp.class, 10, 20);

//    List<Emp> emps = JdbcUtils.executeQuery2(sql, Emp.class, 10, 20);

    for (Emp emp : emps) {
      System.out.println(emp);
    }
  }

  public static void testInsert() throws Exception {
    String sql = "insert into emp(name,username,password,gender,phone,job) values (?,?,?,?,?,?)";
    JdbcUtils.executeUpdate(sql, "赵云", "zhaoyun", "123456", 1, "18812341235", 2);
  }

  public static void testDelete() throws Exception {
    String sql = "delete from emp where id = ?";
    JdbcUtils.executeUpdate(sql, 42);
  }

  public static void testUpdate() throws Exception {
    String sql = "update emp set name = ? where id = ?";
    JdbcUtils.executeUpdate(sql, "赵云2", 42);
    Map map = new
  }
}
