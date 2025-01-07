package refactor;

public class App {
    public static void main(String[] args) {
        VIPCustomer customer = new VIPCustomer();
        customer.setEmail("testuser@vip.com");

        EmailSender sender = new EmailSender();
        sender.send(customer);
    }
}
