import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/* 这个类不符合单一职责原则 */
public class CustomerDataChart {
    public Connection getConnection() throws Exception {
/*        *//* 1.加载驱动 *//*
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        *//* 2.建立连接 *//*
        String url = "jdbc:mysql://192.168.42.133:3306/test";
        Connection connection = DriverManager.getConnection(url);*/
        return connection;
    }


    public List findCustomers() throws Exception {
/*        *//* 3.创建statement语句 *//*
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        *//* 4.执行SQL语句 *//*
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        *//* 5.遍历结果 *//*
        List<Customer> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Customer(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getTimestamp(4),
                    resultSet.getTimestamp(5)));
        }*/
        return list;
    }

    public void createChart() {
        // TODO
    }

    public void displayChart() {
        // TODO
    }


}

// Customer 实/*
//class Customer {
//    private Long id;
//    private String name;
//    private String address;
//    private Timestamp createTime;
//    private Timestamp updateTime;
//
//    Customer(Long id, String name, String address, Timestamp createTime, Timestamp updateTime) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//    }
//
//}*/体类
