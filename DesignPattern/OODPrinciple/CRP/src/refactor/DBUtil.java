package refactor;

import java.sql.Connection;

public class DBUtil {
    public Connection getConnection(){
        System.out.println("获取默认数据库连接");
        return (Connection) new Object();
    }
}
