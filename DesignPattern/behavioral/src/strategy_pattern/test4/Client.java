package strategy_pattern.test4;

import template_method_pattern.test2.PropertiesUtils;

public class Client {
  public static void main(String[] args) throws Exception {
    Container jPanel = new JPanel();

    CardLayout cardLayout = new CardLayout();

    /* 反射获取类名, 动态创建不同的LayoutManager */
    String layout = PropertiesUtils.getProperty("layout");
    LayoutManager layoutManager = (LayoutManager) Class.forName(layout).newInstance();
    jPanel.setLayoutManager(layoutManager);

    jPanel.show();



    Order order = new Order();
    order.loadStrategy();
    order.insert();
  }
}
