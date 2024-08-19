package _3_oop;

public class _06_Interface {
    public static void main(String[] args) {
        // 接口是抽象方法的集合
        // 实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类
        // 接口类型可以声明变量，不可以实例化对象
        // 接口中的方法只能是 【public abstract】 方法，接口中的变量只能是 【public static final】 变量

        // testPig();
        testMulti();
    }

    public static void testPig() {
        Pig pig = new Pig();
        pig.eat();
        pig.travel();
    }

    public static void testMulti(){
        CD cd = new CD();
        cd.say();

        IA ia = new CD();
        ia.say();

        IB ib = new CD();
        ib.say();
    }
}

/**
 * [访问控制符] interface 接口名称 [extends 其他接口] {
 * // 声明变量
 * // 抽象方法
 * }
 */

interface MyInter {
    void run();

    void say();
}

interface Beings {
    void eat();

    void travel();
}

class Pig implements Beings {

    @Override
    public void eat() {
        System.out.println("pig eat");
    }

    @Override
    public void travel() {
        System.out.println("pig travel");
    }
}

// 抽象类可以不实现接口中的方法
abstract class AbstractPig implements Beings {
}

/* 接口继承 */
interface AAA {
    void methodA1();

    void methodA2();
}

interface BBB extends AAA {
    void methodB1();

    void methodB2();

    void methodB3();
}

interface CCC extends AAA {
    void methodC1();

    void methodC2();

    void methodC3();

    void methodC4();
}

//class DDD implements CCC{
// 需要实现六个方法
//}

/* 接口多继承 */
interface EEE extends BBB, CCC {
    void methodE1();
}

interface IA {
    void say();

    void walk();
}

interface IB {
    void say();

    void sleep();
}

//interface IC extends IA,IB {
//
//}

//class CD implements IA,IB{
class CD implements IB,IA{


    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public void sleep() {
        System.out.println("sleep");

    }

    @Override
    public void walk() {
        System.out.println("walk");

    }
}

/* 接口多继承*/

// https://blog.csdn.net/kaszxc/article/details/106316119
// https://www.cjavapy.com/article/172/

/* 标记接口 */
// 标记接口是没有任何方法和属性的接口
interface Readable {}
interface Eatable {}
