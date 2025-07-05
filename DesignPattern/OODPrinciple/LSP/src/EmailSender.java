public class EmailSender {
    public void send(CommonCustomer customer) {
        String email = customer.getEmail();
        System.out.println("给普通客户发邮件：" + email);
    }

    public void send(VIPCustomer customer) {
        String email = customer.getEmail();
        System.out.println("给VIP客户发邮件：" + email);
    }

    /* 每次新增客户类型，都需要修改 EmailSender 类 */
}
