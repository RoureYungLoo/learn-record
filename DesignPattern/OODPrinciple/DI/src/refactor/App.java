package refactor;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerDAO dao = new CustomerDAO();
        dao.addCustomers();
    }
}
