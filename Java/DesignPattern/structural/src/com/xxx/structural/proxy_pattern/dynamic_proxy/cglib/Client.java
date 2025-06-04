package com.xxx.structural.proxy_pattern.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Tank proxy = getProxy();
        proxy.fire(3,"穿甲弹");
    }

    public static Tank getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Tank.class.getClassLoader());
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogMethodInterceptor());
        Object o = enhancer.create();
        Tank tankProxy = (Tank) o;
        return tankProxy;
    }
}


//    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Target.class);
//        enhancer.setCallback(new MyInterceptor());
//        Target target = (Target) enhancer.create();
//        target.execute();
//    }
//}
//
//class Target {
//    public void execute(){
//        System.out.println("目标类方法执行了");
//    }
//}
//
//class MyInterceptor implements MethodInterceptor{
//
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("生成的类名："+o.getClass().getName());
//        System.out.println("生成的类的父类："+o.getClass().getSuperclass().getName());
//        System.out.println("方法执行前，被代理的方法 "+ method.getName());
//
//        Object result = null;
//        result = methodProxy.invokeSuper(o,objects);
//
//        System.out.println("方法执行后，被代理的方法 "+ method.getName());
//        return result;
//    }
//}

