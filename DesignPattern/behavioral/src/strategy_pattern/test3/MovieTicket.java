package strategy_pattern.test3;

public class MovieTicket {
  AbstractDiscountStrategy strategy;
  private double price;

  public void setStrategy(AbstractDiscountStrategy strategy) {
    this.strategy = strategy;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return strategy.calculate(price);
  }
}
