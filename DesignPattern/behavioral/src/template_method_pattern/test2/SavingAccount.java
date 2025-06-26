package template_method_pattern.test2;

/* 定期账户 */
public class SavingAccount extends Account {

  @Override
  public void ComputeInterest() {
    System.out.println("计算 定期 利率");
  }
}
