package refactor;

import java.sql.Connection;

public class MySQLDBUtil extends DBUtil {
    @Override
    public Connection getConnection() {
        System.out.println("获取mysql数据库连接");
        return (Connection) new Object();
    }
}
