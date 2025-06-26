package template_method_pattern.test1;

public class ConcreteClass extends AbstractClass {
  @Override
  public void templateMethod() {
    super.templateMethod();
  }

  @Override
  public void primitiveOperation3() {
    System.out.println("具体基本操作3");
  }

  @Override
  public void primitiveOperation2() {
    System.out.println("具体基本操作3");
  }

  @Override
  public void primitiveOperation1() {
    System.out.println("具体基本操作3");
  }
}
