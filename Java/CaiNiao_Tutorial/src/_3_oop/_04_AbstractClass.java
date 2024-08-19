package _3_oop;

/* 定义：缺少必要的描述具体对象信息的类就是抽象类 */
/* Java 中的抽象类表示的是【继承关系】 */
/* 一个类只能继承一个抽象类，一个类可以实现多个接口 */
public class _04_AbstractClass {
    public static void main(String[] args) {
        testSala();
    }

    public static void testSala() {
        Sala sala = new Sala("zhaoyun", "wei", 1003, 3600);
        Emp emp = new Sala("zhangfei", "wei", 1004, 2400);

        System.out.println("----- 使用 Sala 的引用调用mailCheck --");
        sala.mailCheck();

        System.out.println("\n----- 使用 Emp 的引用调用mailCheck --");
        emp.mailCheck();
    }
}

// 抽象类 Emp
abstract class Emp {
    private String name;
    private String address;
    private int number;

    public Emp(String name, String address, int number) {
        System.out.println("调用 Emp 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Emp内部计算方法");
        return 0.0;
    }

    public void mailCheck() {
        System.out.println("Emp.mailCheck()");
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

    // 抽象方法：抽象类中用 abstract 修饰的成员方法，无方法体
    // 如果一个类包含抽象方法，那么该类必须是抽象类
    // 任何子类必须重写父类的抽象方法，或者声明自身为抽象类
    // 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法
    public abstract void foo();
}

class Sala extends Emp {
    private double salary; // 一整年的薪水

    public Sala(String name, String address, int number, double salary) {
        super(name, address, number);
        // this.salary = salary;
        setSalary(salary);
        System.out.println("调用 Sala 的构造函数");
    }

    public void mailCheck() {
        System.out.println("Sala.mailCheck()");
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

    @Override
    public void foo() {

    }
}
