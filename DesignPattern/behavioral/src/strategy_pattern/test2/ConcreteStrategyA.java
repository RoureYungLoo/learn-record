package strategy_pattern.test2;

/* 具体策略类A */
public class ConcreteStrategyA extends AbstractStrategy {
  @Override
  void algorithm() {
    System.out.println("采用算法A");
  }
}
