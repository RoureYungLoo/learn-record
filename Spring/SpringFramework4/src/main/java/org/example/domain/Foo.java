package org.example.domain;

public class Foo {
    /* 构造注入，参数类型相同 */
    public Foo(Bar param1, Bar param2) {
        System.out.println("Foo constructor called.(构造函数参数类型相同)");
    }

    /* 构造注入，参数类型不同 */
    public Foo(String name, Long timestamp, int grade) {
        System.out.println("Foo constructor called.(构造函数参数类型不同)");
        System.out.println(name + " " + timestamp + " " + grade);
    }

    public Foo() {
    }

    public Foo(Bar bar){
        System.out.println("Foo constructor with parameter bar");
    }
}
