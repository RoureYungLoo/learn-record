package strategy_pattern.test3;

public class StudentDiscountStrategy implements AbstractDiscountStrategy {
  @Override
  public double calculate(double price) {
    System.out.println("学生票打八折");
    return price * 0.8;
  }
}
