import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new MyInterceptor());
        Target target = (Target) enhancer.create();
        target.execute();
    }
}

class Target {
    public void execute(){
        System.out.println("目标类方法执行了");
    }
}

class MyInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("生成的类名："+o.getClass().getName());
        System.out.println("生成的类的父类："+o.getClass().getSuperclass().getName());
        System.out.println("方法执行前，被代理的方法 "+ method.getName());

        Object result = null;
        result = methodProxy.invokeSuper(o,objects);

        System.out.println("方法执行后，被代理的方法 "+ method.getName());
        return result;
    }
}

