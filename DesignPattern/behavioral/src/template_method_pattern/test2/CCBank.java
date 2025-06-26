package template_method_pattern.test2;

import java.util.Scanner;

public class CCBank extends AbstractBank {
  private String username;
  private String password;
  private static Scanner scanner = new Scanner(System.in);

  @Override
  public void loadUsername() {
    System.out.println("input username: ");
    username = scanner.nextLine();

  }

  @Override
  public void loadPassword() {
    System.out.println("input password: ");
    password = scanner.nextLine();

  }

  @Override
  public void verify() {
    if (username.equals(password)) {
      System.out.println("verify success");
    } else {
      throw new RuntimeException("verify failed");
    }
  }

  @Override
  public void computeBenefits() {
    if (username.length() == 5) {
      System.out.println("定期账户计算利息");
    } else {
      System.out.println("活期账户计算利息");
    }
  }

  @Override
  public void showBenefits() {
    System.out.println("显示利息");
  }
}
