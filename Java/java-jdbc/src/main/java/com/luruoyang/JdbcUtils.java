package com.luruoyang;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {
  private static Connection connection = null;
  private static Properties properties = null;

  static {
    try {
      /* load database configuration */
      ClassLoader classLoader = ClassLoader.getSystemClassLoader();
      InputStream in = classLoader.getResourceAsStream("db.properties");
      properties = new Properties();
      properties.load(in);

      /* register driver */
      Class.forName(properties.getProperty("driverClassName"));

      /* get connection */
      connection = DriverManager.getConnection(
          properties.getProperty("url"),
          properties.getProperty("user"),
          properties.getProperty("password"));
    } catch (SQLException e) {
      System.out.println("连接获取失败: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("properties load Error");
    } catch (ClassNotFoundException e) {
      System.out.println("驱动加载错误");
    }
  }

  /* Insert Delete Update */
  public static void executeUpdate(String sql, Object... args) throws Exception {
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    if (preparedStatement == null) {
      System.out.println("preparedStatement error");
    }

    for (int i = 0; i < args.length; i++) {
      preparedStatement.setObject(i + 1, args[i]);
    }

    System.out.println(preparedStatement);
    preparedStatement.executeUpdate();

    close(preparedStatement, connection);
  }

  /* 查询 */
  public static List<Emp> executeQuery(String sql, Class<Emp> clazz, Object... args) throws Exception {

    /* 获取 preparedStatement */
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    /* 设置参数 */
    for (int i = 0; i < args.length; i++) {
      preparedStatement.setObject(i + 1, args[i]);
    }

    Emp emp = null;
    List<Emp> empList = new ArrayList<>();
    /* 反射 */
    Field[] fields = clazz.getDeclaredFields();
    Constructor<Emp> constructor = clazz.getDeclaredConstructor();

    /* 查询结果 */
    ResultSet resultSet = preparedStatement.executeQuery();

    /* 处理结果 */
    while (resultSet.next()) {
      emp = constructor.newInstance();
      for (Field field : fields) {
        /* property 对应 column  */
        String objFiledName = field.getName();
        Object object = resultSet.getObject(objFiledName);
        field.setAccessible(true);
        field.set(emp, field.getType().cast(object)); // 类型强转
      }
      empList.add(emp);
    }

    close(preparedStatement, connection, resultSet);
    return empList;
  }

  /* 查询 */
  public static <T> List<T> executeQuery2(String sql, Class<T> clazz, Object... args) throws Exception {
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    for (int i = 0; i < args.length; i++) {
      preparedStatement.setObject(i + 1, args[i]);
    }

    ResultSet resultSet = preparedStatement.executeQuery();
    List<T> list = new ArrayList<>();
    Constructor<T> constructor = clazz.getDeclaredConstructor();
    Field[] fields = clazz.getDeclaredFields();

    while (resultSet.next()) {
      T t = constructor.newInstance();
      for (Field field : fields) {
        Class<?> fieldType = field.getType(); // 获取对象字段的类型
        String objFieldName = field.getName();
        Object o = resultSet.getObject(objFieldName);
        Object property = fieldType.cast(o); // 类型转换
        field.setAccessible(true);
        field.set(t, property);
      }
      list.add(t);
    }

    close(preparedStatement, connection, resultSet);

    return list;
  }

  public static Connection getConnection() {
    return connection;
  }

  /* 释放资源 */
  public static void close(Statement stmt, Connection conn, ResultSet rs) {

    try {
      if (stmt != null) stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    try {
      if (conn != null) conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    try {
      if (rs != null) rs.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public static void close(Statement stmt, Connection conn) {
    close(stmt, conn, null);
  }
}

