package _3_oop;

public class _01_extends {
    // Java 继承的关系是 IS-A
    public static void main(String[] args) {
        Son son = new Son();
        son.testEat();

        SonClass1 sc1 = new SonClass1();
        SonClass1 sc2 = new SonClass1(200);
    }
}

/* 定义 Java 基类（父类） */
class BasedClass {

}

/* 定义 Java 派生类（子类）*/
class derivedClass extends BasedClass {

}

class Cat {
    private String id;
    private String name;
    private String color;
    private String category;

    public Cat() {
    }

    /* this关键字：指向自己的引用，引用当前对象，即它所在的方法或构造函数所属的【对象实例】*/
    public Cat(String _id, String _name, String _color, String _category) {
        this.id = _id;
        this.name = _name;
        this.color = _color;
        this.category = _category;
    }

    public void eat() {
        System.out.println(color + category + name + "正在吃···");
    }

    public void sleep() {
        System.out.println(color + category + name + "正在睡觉···");

    }

    public void say() {
        System.out.println("大家好，我是" + color + category + name + ": " + id);
    }
}

class Mouse {
    private String id;
    private String name;
    private String color;
    private String category;

    public Mouse() {
    }

    public Mouse(String _id, String _name, String _color, String _category) {
        this.id = _id;
        this.name = _name;
        this.color = _color;
        this.category = _category;
    }

    public void eat() {
        System.out.println(color + category + name + "正在吃···");
    }

    public void sleep() {
        System.out.println(color + category + name + "正在睡觉···");

    }

    public void say() {
        System.out.println("大家好，我是" + color + category + name + ": " + id);

    }
}

// 以上两个类 Cat 、Mouse 存在大量的代码重复，重构如下：Animal.java NewCat.java NewMouse.java

/* implements 关键字，Java不支持多继承，但可以实现多个接口 */

interface A {
    void eat();

    void sleep();
}

interface B {
    void say();
}

class C implements A, B {
    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void say() {

    }
}

class Person {
    public void eat() {
        System.out.println("Person.eat()");
    }
}

class Father extends Person {
    public void eat() {
        System.out.println("Father.eat()");
        super.eat();
    }
}

class Son extends Father {
    public void eat() {
        System.out.println("Son.eat()");
    }

    public void testEat() {
        this.eat();
        super.eat();

    }
}

/* final 关键字 */

// 禁止子类继承基类 atom
//final class atom {}

class atom {
    // 禁止子类重写方法 show()
    public final void show() {

    }
}

/* 构造函数 ：构造函数不能继承，只能调用（显式/隐式））*/
class SuperClass {
    private int n;

    public SuperClass() { // 父类无参构造函数
        System.out.println("SuperClass.SuperClass()");
    }

    public SuperClass(int n) { // 父类含参构造函数
        System.out.println("SuperClass.SuperClass(int n): " + n);
        this.n = n;
    }
}

class SonClass1 extends SuperClass {
    private int n;

    public SonClass1() { // 子类无参数构造器，自动调用父类的无参数构造器
        super();
        System.out.println("SonClass1.SonClass1()");
    }

    public SonClass1(int n) { // 子类带参数构造器，调用父类中带有参数的构造器
        super(300);
        System.out.println("SonClass1.SonClass1(int n): " + n);
        this.n = n;
    }
}

class Last extends SuperClass {
    private int n;

    public Last() { // // 无参数构造器，调用父类中带有参数的构造器
        super(300);
        System.out.println("Last.Last()");
    }

    public Last(int n) { // // 带参数构造器，自动调用父类的无参数构造器
        System.out.println("Last.Last(int n): " + n);
        this.n = n;
    }
}

class SonClass2 extends SuperClass {

}