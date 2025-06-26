package strategy_pattern.test1;

public class MovieTicket {
  private double price;
  private String type;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double calculatePrice() {
    if (type.equalsIgnoreCase("student")) {
      System.out.println("学生票, 打八折");
      return price * 0.8;
    } else if (type.equalsIgnoreCase("children")) {
      System.out.println("儿童票, 优惠10元");
      return price - 10;
    } else if (type.equalsIgnoreCase("vip")) {
      System.out.println("VIP 半价");
      System.out.println("VIP 增加积分");
      return price * 0.5;
    } else {
      System.out.println("不满足打折要求");
      return price;
    }
  }
}
