package refactor;

public class EmailSender {
    public void send(Customer customer) {
        String email = customer.getEmail();
        System.out.println("给" + email + "发邮件");
    }
}
