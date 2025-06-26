package strategy_pattern.test3;

public class Client {
  public static void main(String[] args) {
    MovieTicket ticket = new MovieTicket();
    ticket.setPrice(39);

    System.out.println("原始票价: 39元");

//    AbstractDiscountStrategy strategy = new StudentDiscountStrategy();
//    AbstractDiscountStrategy strategy = new VipDiscountStrategy();
    AbstractDiscountStrategy strategy = new ChildDiscountStrategy();

    /* 可以通过配置文件动态切换折扣策略 */


    ticket.setStrategy(strategy);

    double discountPrice = ticket.getPrice();

    System.out.println("折后价格: "+discountPrice);
  }
}
