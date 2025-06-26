package template_method_pattern.test2;


public abstract class Account {
  /* 基本方法, 钩子方法 */
  public boolean validate(String account, String password) {
    return account.equals("lisi") && password.equals("123456");
  }

  /* 基本方法, 抽象方法 */
  public abstract void ComputeInterest();

  /* 基本方法, 具体方法 */
  public void display() {
    System.out.println("显示利息信息");
  }


  /* 模版方法 */
  public void handle(String account, String password) {
    if (validate(account, password)) {
      ComputeInterest();
      display();
    } else {
      throw new RuntimeException("用户名密码错误");
    }
  }
}
