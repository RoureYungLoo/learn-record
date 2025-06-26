package strategy_pattern.test3;

public class VipDiscountStrategy implements AbstractDiscountStrategy {
  @Override
  public double calculate(double price) {
    System.out.println("Vip 积分");
    System.out.println("Vip 半价");
    return price * 0.5;
  }
}
