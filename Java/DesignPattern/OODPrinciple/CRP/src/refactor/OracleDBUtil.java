package refactor;

import java.sql.Connection;

public class OracleDBUtil extends DBUtil {
    @Override
    public Connection getConnection() {
        System.out.println("获取Oracle数据库连接");
        return (Connection) new Object();
    }
}
