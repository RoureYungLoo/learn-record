package dynamic;

import com.sun.javafx.tk.TKPulseListener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
//        Target target = new Target();
//        MyProxy myProxy = new MyProxy(target);
//        Executable exe = (Executable) Proxy.newProxyInstance(
//                Target.class.getClassLoader(), // 被代理类对象
//                new Class[]{Executable.class}, // 接口类对象
//                myProxy //
//        );
//        exe.execute();
    }


}
/*================== JDK 动态代理 ======================*/

//interface Executable {
//    public void execute();
//}
//
//class Target implements Executable {
//    @Override
//    public void execute() {
//        System.out.println(" 目标类 代理方法 execute() 执行了");
//    }
//}
//
//class MyProxy implements InvocationHandler {
//
//    private Executable executable;
//
//    public MyProxy(Executable exe) {
//        this.executable = exe;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        System.out.println("方法" + method.getName() + "执行前");
//
//        Object invoke = method.invoke(executable, args); // 此处相当于 executable.execute();
//
//        System.out.println("方法" + method.getName() + "执行后");
//
//        return invoke;
//    }
//}
