import java.sql.Connection;
import java.sql.Statement;

// public class CustomerDAO extends DBUtil { // 原有的设计
public class CustomerDAO extends OracleDBUtil { // 需求变更，必须修改CustomerDAO源码（即继承另外一个类）
    public void addCustomer() throws Exception {
        Connection connection = super.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into ...");
        connection.close();
    }
}
