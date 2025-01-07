package refactor;

public class App {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        OracleDBUtil dbUtil = new OracleDBUtil();
        dao.setDbUtil(dbUtil);
        dao.addCustomer();
    }
}
