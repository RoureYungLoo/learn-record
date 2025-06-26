package strategy_pattern.test2;

/*环境类: 需要使用算法的类*/
public class Context {

  /* 持有抽象策略类的引用 */
  private AbstractStrategy strategy;

  void algorithm() {
    strategy.algorithm();
  }

  public void setStrategy(AbstractStrategy strategy) {
    this.strategy = strategy;
  }
}
