package strategy_pattern.test4;

public class OrderAsync implements OrderStrategy {
  @Override
  public void insert() {
    System.out.println("异步插入订单");
  }
}
