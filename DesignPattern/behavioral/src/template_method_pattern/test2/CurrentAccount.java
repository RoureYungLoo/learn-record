package template_method_pattern.test2;

/* 活期账户 */
public class CurrentAccount extends Account {

  @Override
  public void ComputeInterest() {
    System.out.println("计算 活期 利率");
  }

}
