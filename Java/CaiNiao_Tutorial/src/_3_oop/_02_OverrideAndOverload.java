package _3_oop;

import java.io.FileNotFoundException;
import java.io.IOException;

public class _02_OverrideAndOverload {

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws IOException {
        AA aa = new AA();
        AA bb = new BB();

        aa.move();
        bb.move();
    }
}


/**
 * override, 重写：子类中①方法名、②参数列表、③返回类型与父类相同，异常范围不能扩大【抛出新的异常/抛出更加宽泛的有异常】
 * overload, 重载：同一个类中，方法名相同，参数列表不同的多个方法称为重载，重载的返回类型不做要求。
 * 方法重载可以新增异常或增加异常的范围
 */

/* override */
class AA {
    public void move() throws IOException {
        System.out.println("AA.move()");
    }
}

class BB extends AA {
    // public void move() throws Exception {
    public void move() throws IOException {
    // public void move() throws FileNotFoundException {
        // super.move();
        System.out.println("BB.move()");
    }
}