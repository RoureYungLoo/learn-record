package template_method_pattern.test2;

public class Client {
  public static void main(String[] args) throws Exception {
//    AbstractBank bank= new CCBank();
//    bank.bankTemplate();

    String username = PropertiesUtils.getProperty("username");
    String password = PropertiesUtils.getProperty("password");
    String className = PropertiesUtils.getProperty("accountType");

    Class<?> clazz = Class.forName(className);

    Account account;
    account = (Account) clazz.newInstance();
    account.handle(username, password);


  }
}
