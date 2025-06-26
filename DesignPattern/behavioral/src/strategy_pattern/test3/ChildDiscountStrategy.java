package strategy_pattern.test3;

public class ChildDiscountStrategy implements AbstractDiscountStrategy {
  @Override
  public double calculate(double price) {
    System.out.println("儿童票优惠10元");
    return price - 10;
  }
}
