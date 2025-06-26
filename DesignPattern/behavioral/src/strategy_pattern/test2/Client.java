package strategy_pattern.test2;

import template_method_pattern.test2.PropertiesUtils;

public class Client {
  public static void main(String[] args) throws Exception{

    /* 创建环境类 */
    Context context = new Context();

    /* 方式1: 指定使用抽象策略的实现类 */
//    AbstractStrategy strategy = new ConcreteStrategyA();

    /* 方式2: 反射配置具体策略类 */
    String className = PropertiesUtils.getProperty("strategy");
    AbstractStrategy strategy = (AbstractStrategy) Class.forName(className).newInstance();


    /* 设置到环境中 */
    context.setStrategy(strategy);

    /* 在环境中使用 */
    context.algorithm();
  }
}
