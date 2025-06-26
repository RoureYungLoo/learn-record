package template_method_pattern.test1;


/* 抽象类 */
public abstract class AbstractClass {

  /* 模版方法: 调用基本方法并指定调用次序的方法 */
  public void templateMethod() {
    primitiveOperation2();
    primitiveOperation1();

    /* 根据钩子方法的返回值, 决定是否调用 primitiveOperation3() */
    if (isAuthenticated()) {
      primitiveOperation3();
    }
  }

  /* 基本操作: 可以是抽象方法Abstract	Method, */
  public void primitiveOperation3() {
    System.out.println("基本操作3");
  }

  /* 基本操作: 可以是具体方法Concrete	Method */
  public abstract void primitiveOperation2();

  /* 基本操作:  可以是钩子方法Hook	Method */
  public boolean isAuthenticated() {
    System.out.println("基本操作1, hook method ");
    return true;
  }

  public void primitiveOperation1() {

  }

}
