package _static_;


public class Main{
    public static void main(String[] args) {

        // Proxy proxy = new Proxy();
        // proxy.execute();

        // Target target = new Target();
        // Proxy proxy = new Proxy(target); // 多态，父类引用指向子类
        // proxy.execute();


    }
}
/*================== 通过[继承]实现静态代理 ======================*/
/* 目标对象 Target类 */
//class Target{
//    public void execute(){
//        System.out.println(" 目标类的方法 execute() 执行了");
//    }
//}
//
///* 代理类 Proxy */
//class Proxy extends Target{
//    @Override
//    public void execute() {
//
//        System.out.println("目标类方法执行前的操作");
//
//        /* 目标类的方法 */
//        super.execute();
//
//        System.out.println("目标类方法执行后的操作");
//    }
//}

/*================== 通过[组合]实现静态代理 ======================*/
//// 定义一个接口，代理类和目标类都需要实现该接口
//interface Executable{
//    public void execute();
//}
//
///* 目标类 */
//class Target implements Executable{
//
//    @Override
//    public void execute() {
//        System.out.println(" 目标类方法 Target.execute() 执行了");
//    }
//}
//
///* 代理类 */
//class Proxy implements Executable{
//
//    /* 组合接口对象 */
//    private Executable executable;
//    public Proxy(Executable exe){
//        this.executable = exe;
//    }
//
//    @Override
//    public void execute() {
//        System.out.println(" 代理类前置操作执行了");
//        executable.execute();
//        System.out.println(" 代理类后置操作执行了");
//    }
//}


