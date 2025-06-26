package strategy_pattern.test4;

public class OrderSync implements OrderStrategy {
  @Override
  public void insert() {
    System.out.println("同步插入订单");
  }
}
