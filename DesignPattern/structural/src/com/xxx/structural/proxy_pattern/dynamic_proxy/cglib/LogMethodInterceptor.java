package com.xxx.structural.proxy_pattern.dynamic_proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/* cglib动态代理 */
public class LogMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object proxy, /* 代理类对象, cglib动态生成的子类对象 */
                            Method method,  /* 被代理类的的方法, 父类的方法, 目标类的方法 */
                            Object[] objects, /*方法入参*/
                            MethodProxy methodProxy /* 父类方法的封装, 用于快速调用父类方法 */) throws Throwable {

        System.out.println("proxy info: " + proxy.getClass().getName()); // com.xxx...cglib.Tank$$EnhancerByCGLIB$$d73485c4
        System.out.println("proxy.getSuperClass info: " + proxy.getClass().getSuperclass().getName()); // com.xxx.....cglib.Tank
//        System.out.println("method info: " + method.getName()); //fire
//        System.out.println("args info: ");
//        Arrays.stream(objects).forEach(System.out::println);
//        System.out.println("methodProxy info: " + methodProxy.getSignature()); //fire()V

//        methodProxy.invoke() 调用指定目标对象的方法（当使用多个拦截器链时可能会用到，但通常不直接使用原始目标对象）。
//        methodProxy.invokeSuper() 调用代理对象的父类（即原始目标对象）的方法。这是最常用的方式。
        System.out.println("-------业务方法调用前-------");
        /* 使用代理方法调用代理对象的父类方法,  */
        Object result = methodProxy.invokeSuper(proxy, objects);
        System.out.println("=======业务方法调用后========");
        return result;
    }
}
