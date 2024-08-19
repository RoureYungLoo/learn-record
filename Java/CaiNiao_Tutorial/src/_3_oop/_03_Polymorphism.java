package _3_oop;

import sun.security.x509.AVA;

import javax.naming.StringRefAddr;

public class _03_Polymorphism {
    public static void main(String[] args) {
        // testShape();
        // testPet();
        testSalary();
    }


    public static void testShape() {
        Shape s1 = new Circle();
        Shape s2 = new Square();
        Shape s3 = new Triangle();

        s1.draw();
        s2.draw();
        s3.draw();
    }

    public static void testPet() {
        show(new MyCat());
        show(new MyDog());

        Pet pet = new MyCat();
        pet.eat();
        MyCat myCat = (MyCat) pet;
        myCat.work();
    }

    public static void show(Pet pet) {
        pet.eat();
        if (pet instanceof MyCat) {
            MyCat mc = (MyCat) pet;
            mc.work();
        }
        if (pet instanceof MyDog) {
            MyDog md = (MyDog) pet;
            md.work();
        }
    }

    private static void testSalary() {
        Salary s = new Salary("lisi", "beijing", 1001, 3600);
        Employee e = new Salary("zhangsan", "shanghai", 1002, 2400);

        System.out.println("----- 使用Salary的引用调用mailCheck --");
        s.mailCheck();

        System.out.println("\n----- 使用Employee的引用调用mailCheck --");
        e.mailCheck();
    }
}

/**
 * 多态：
 * 同一个行为具有多种表现形式或形态的能力
 * 同一个接口具有多种操作的能力
 * 多态的必要条件：
 * 1. 继承
 * 2. 重写
 * 3. 父引用指向子类对象（父指子） 或者 接口引用指向实现类实例对象（接指实）
 * <p>
 * 多态的三种实现方式：
 * 一、重写
 * 二、接口
 * 三、抽象类和抽象方法
 */

class Shape {
    public void draw() {
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Square extends Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}

abstract class Pet {
    abstract void eat();
}

class MyCat extends Pet {

    void eat() {
        System.out.println("吃鱼");
    }

    void work() {
        System.out.println("捉老鼠");
    }
}

class MyDog extends Pet {

    void eat() {
        System.out.println("吃骨头");
    }

    void work() {
        System.out.println("看家");
    }
}

// 虚函数：Java 中没有虚函数概念，Java 普通函数就相当于 C++ 的虚函数
// Java 默认动态绑定
// final 关键字可以使 Java 函数变成非虚函数

class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("调用 Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck() {
        System.out.println("Employee.mailCheck()");
        System.out.println("邮寄支票给：" + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {
    private double salary; // 一整年的薪水

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        this.salary = salary;
        System.out.println("调用 Salary 的构造函数");
    }

    public void mailCheck() {
        System.out.println("Salary.mailCheck()");
        System.out.println("邮寄支票给：" + getName() + " ,工资为：" + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0) this.salary = newSalary;
    }

    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary / 52;
    }

}
