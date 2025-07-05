package com.xxx.structural.bridge_pattern.two;

/* 扩充抽象类 */
public class RefinedAbstraction extends Abstraction{
    @Override
    public void operation() {
        // 业务代码
        impl.operationImpl(); // 调用实现类的方法
        // 业务代码
    }
}
