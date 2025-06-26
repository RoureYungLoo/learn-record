package strategy_pattern.test2;

/* 具体策略类B */
public class ConcreteStrategyB extends AbstractStrategy {
  @Override
  void algorithm() {
    System.out.println("采用算法B");
  }
}
