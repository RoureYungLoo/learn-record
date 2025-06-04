//package com.randolflu.springframework03aop.aspectj;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class MyAspect {
//
//    @Pointcut("target(com.randolflu.springframework03aop.aspectj.HelloImpl)")
//    public void helloImpl() {
//    }
//
//    @Pointcut("execution(public * say(..))")
//    public void sayOpt() {
//    }
//
//    @Pointcut("helloImpl()&&sayOpt()")
//    public void sayHello() {
//    }
//
////    @Before("helloImpl()")
////    public void before() {
////        System.out.println("前置通知");
////    }
//
//            @Before("helloImpl() && args(sb)")
//    public void before(StringBuilder sb) {
//        System.out.println("前置通知");
//        sb.append(" 前置通知修改了参数");
//    }
//
//    //        @After("helloImpl()")
//        @After(value = "sayOpt()")
//    public void after() {
//        System.out.println(" @After 后置通知, 进行资源清理工作");
//    }
//
//    //    @AfterReturning(value = "helloImpl()", returning = "retValue")
//    @AfterReturning(value = "sayOpt()", returning = "retValue")
//    public void afterReturn(String retValue) {
//        System.out.println("后置返回通知");
//        retValue = retValue.toUpperCase();
//        System.out.println(" AfterReturning 返回值是: " + retValue);
//    }
//
//    //    @AfterThrowing("helloImpl()")
//    @AfterThrowing(value = "helloImpl()", throwing = "ex")
//    public void afterException(Exception ex) {
//
//        System.out.println("后置异常通知, 出现了异常: " + ex.getMessage());
//    }
//
//    //        @Around("helloImpl()")
//    @Around(value = "sayOpt()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        System.out.println("------ 环绕通知 ------前");
//        long start = System.currentTimeMillis();
//
//        Object ret = null;
//        try {
////            ret = joinPoint.proceed();
//            ret = joinPoint.proceed(new Object[]{new StringBuilder("666")});
//            System.out.println("环绕通知,业务方法返回值: " + ret);
//            ret = ret + " 环绕通知修改了返回值";
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println("------ 环绕通知 ------ 后");
//
//        System.out.println("耗时: " + (end - start));
//        return ret;
//    }
//
//    /* 引入通知 */
//    @DeclareParents(value = "com.randolflu.springframework03aop.aspectj.Hello+",
//            defaultImpl = DefaultGoodBye.class)
//    private GoodBye goodBye;
//
//    @Around(value = "sayOpt()&&this(bye)", argNames = "pjp,bye")
//    public Object aound2(ProceedingJoinPoint pjp, GoodBye bye) {
//
//        Object retValue = null;
//        try {
//            retValue = pjp.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//        return retValue + bye.sayBye();
//    }
//}
