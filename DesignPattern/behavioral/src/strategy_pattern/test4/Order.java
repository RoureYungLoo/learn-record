package strategy_pattern.test4;

import template_method_pattern.test2.PropertiesUtils;

public class Order {
  private OrderStrategy orderStrategy;

  public OrderStrategy loadStrategy() {
    String strategy = PropertiesUtils.getProperty("orderStrategy");

    try {
      orderStrategy = (OrderStrategy) Class.forName(strategy).newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return orderStrategy;
  }

  public void insert() {
    orderStrategy.insert();
  }
}
