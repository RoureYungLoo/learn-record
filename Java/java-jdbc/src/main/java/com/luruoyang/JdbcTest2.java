package com.luruoyang;


import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class JdbcTest2 {

  private static Connection connection = null;
  private static PreparedStatement preparedStatement = null;

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

  /* 测试方法 */
  public static void main(String[] args) throws Exception {
    JdbcTest2 jdbcTest2 = new JdbcTest2();
//    jdbcTest2.testInsert();
    jdbcTest2.testDelete();
  }

  public void releaseResources() {
    // System.out.println("释放连接资源");
    try {
      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println("statement close error");
    }
    try {
      connection.close();
    } catch (SQLException e) {
      System.out.println("connection close error");
    }
  }


  public void testInsert() throws Exception {

    String sql = "insert into emp(name,username,password,gender,phone,job) values " +
        "(?,?,?,?,?,?)";

    int i = new Random().nextInt(50);

    preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setObject(1, "周云");
    preparedStatement.setObject(2, "zhouyun");
    preparedStatement.setObject(3, "123456");
    preparedStatement.setObject(4, new Random().nextInt(2));
    preparedStatement.setObject(5, "18812341234" + i);
    preparedStatement.setObject(6, new Random().nextInt(5));

    int insert = preparedStatement.executeUpdate(sql);
    if (insert == 1) {
      System.out.println("insert success");
    }
  }


  public void testUpdate() throws Exception {
    String sql = "update emp set name='李思思' where id=?";
    preparedStatement = connection.prepareStatement(sql);
    int update = preparedStatement.executeUpdate();
    if (update == 1) {
      System.out.println("更新成功");
    }
  }


  public void testSelect() throws Exception {
    String sql = "select * from emp where id between 10 and  20";
    preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery(sql);

    System.out.println(resultSet);

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
    System.out.println("输入要删除的ID");

    String sql = "delete from emp where id = ?";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setObject(1, 3);
    try {
      int row = preparedStatement.executeUpdate();
      if (row == 1) {
        System.out.println("删除成功");
      } else {
        System.out.println("delete Error");
      }
    } catch (SQLException e) {
      System.out.println("sql 执行失败");
    }
  }


  public void testLogin() {
    System.out.println();
    Scanner sc = new Scanner(System.in);
    System.out.println("输入用户名: ");
//    String username = sc.nextLine();

    System.out.println("密码: ");
//    String password = sc.nextLine();

  }

}
