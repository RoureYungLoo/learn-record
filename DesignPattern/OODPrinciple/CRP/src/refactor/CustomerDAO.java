package refactor;

public class CustomerDAO {
    private DBUtil dbUtil;

    public DBUtil getDbUtil() {
        return dbUtil;
    }

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public void addCustomer() {
        dbUtil.getConnection();
        // ...
    }
}
