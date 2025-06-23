package com.luruoyang;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

/* 存在SQL注入的版本 */
public class JdbcTest {

  private static Connection connection = null;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("驱动加载失败: " + e.getMessage());
    }

    try {
      connection = DriverManager.getConnection("jdbc:mysql://192.168.100.132:3306/db01", "root", "MySQL123!");
    } catch (SQLException e) {
      System.out.println("连接获取失败: " + e.getMessage());
    }

  }

  public static Connection getConnection() {
    return connection;
  }

  /* 释放资源 */
  public void releaseResources(Statement stmt, Connection conn, ResultSet rs) throws Exception {
    rs.close();
    stmt.close();
    connection.close();
  }


  public void testInsert() throws Exception {
    Statement statement = connection.createStatement();
    String sql = "insert into emp(name,username,password,gender,phone,job) values " +
        "('李四','lisi','123456',1,'18812341234',2)";
    int insert = statement.executeUpdate(sql);
    if (insert == 1) {
      System.out.println("insert success");
    }
  }


  public void testUpdate() throws Exception {
    Connection conn = getConnection();
    Statement statement = conn.createStatement();
    int update = statement.executeUpdate("update emp set name='李思思' where id=27");
    if (update == 1) {
      System.out.println("更新成功");
    }
  }


  public void testSelect() throws Exception {
    Connection conn = getConnection();
    Statement statement = conn.createStatement();

    String sql = "select * from emp where id between 0 and  20";
    ResultSet resultSet = statement.executeQuery(sql);

    // System.out.println(resultSet); // com.mysql.cj.jdbc.result.ResultSetImpl@6a2f6f80

    /*while (resultSet.next()) {
      System.out.println(resultSet.getInt("id"));
      System.out.println(resultSet.getString("username"));
      System.out.println(resultSet.getString("password"));
      System.out.println(resultSet.getString("name"));
      System.out.println(resultSet.getByte("gender"));
      System.out.println(resultSet.getString("phone"));
      System.out.println(resultSet.getByte("job"));
      System.out.println(resultSet.getInt("salary"));
      System.out.println(resultSet.getString("image"));
      System.out.println(resultSet.getDate("entry_date"));
      System.out.println(resultSet.getDate("create_time"));
      System.out.println(resultSet.getDate("update_time"));
    }*/

    while (resultSet.next()) {
      System.out.print(resultSet.getObject("id") + " ");
      System.out.print(resultSet.getObject("username") + " ");
      System.out.print(resultSet.getObject("password") + " ");
      System.out.print(resultSet.getObject("name") + " ");
      System.out.print(resultSet.getObject("gender") + " ");
      System.out.print(resultSet.getObject("phone") + " ");
      System.out.print(resultSet.getObject("job") + " ");
      System.out.print(resultSet.getObject("salary") + " ");
      System.out.print(resultSet.getObject("image") + " ");
      System.out.print(resultSet.getObject("entry_date") + " ");
      System.out.print(resultSet.getObject("create_time") + " ");
      System.out.print(resultSet.getObject("update_time") + " \n");
    }
  }


  public void testDelete() throws Exception {
    Connection conn = getConnection();
    Statement statement = conn.createStatement();
    int row = statement.executeUpdate("delete from emp where id =2");
    if (row == 1) {
      System.out.println("删除成功");
    }
  }

  public static void main(String[] args) throws Exception {
    JdbcTest jdbcTest = new JdbcTest();
//    jdbcTest.testInsert();
//    jdbcTest.testSelect();
//    jdbcTest.testDelete();
    jdbcTest.testUpdate();
  }

}
