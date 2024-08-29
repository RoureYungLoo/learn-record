package com.xxx.demo01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect01 {

//    @Before("execution(public void com.xxx.demo01.User.eat())")
//    /* 1. 没有参数的通知方法*/
//    public void before01(){
//        System.out.println("正在更衣");
//    }
//
//    /* 2. 参数为 JointPoint 的通知方法 */
//    @Before("execution(public void com.xxx.demo01.User.eat())")
//    public void before02(JoinPoint jp){
//        System.out.println("正在更衣");
//
//        System.out.println("目标类："+jp.getTarget());
//        System.out.println("切入点："+jp.getSignature());
//    }

//    @Around("execution(public void com.xxx.demo01.User.eat())")
//    /* 3. 环绕通知：参数为 ProceedingJointPoint */
//    public void before03(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("洗手···");
//
//        pjp.proceed();
//
//        System.out.println("擦嘴···");
//    }

    /* 4. 抽取公共切入点 */
    // @Pointcut("execution(* com.xxx.demo01..*.*())")
    @Pointcut("execution(* *..*.*(..))")
    private void myPointCut1() {
        System.out.println("公共切入点执行了");
        int a = 1/0;
    }

    @Before("myPointCut1()")
    public void before(JoinPoint jp) {
        System.out.println("前置..."+jp.getTarget());
        System.out.println("前置..."+jp.getSignature().getName());
    }

    @AfterReturning("myPointCut1()")
    public void afterReturning() {
        System.out.println("后置...");
    }

}
