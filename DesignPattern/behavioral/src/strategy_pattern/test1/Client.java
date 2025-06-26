package strategy_pattern.test1;

public class Client {
  public static void main(String[] args) {
    MovieTicket ticket = new MovieTicket();
    double original = 100.0;
    double discountPrice;

    ticket.setPrice(original);

    ticket.setType("student");
    System.out.println(ticket.calculatePrice());

    ticket.setType("children");
    System.out.println(ticket.calculatePrice());

    ticket.setType("vip");
    System.out.println(ticket.calculatePrice());

    ticket.setType("common");
    System.out.println(ticket.calculatePrice());
  }
}
