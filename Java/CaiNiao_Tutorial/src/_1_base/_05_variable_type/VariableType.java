package _1_base._05_variable_type;

public class VariableType {
    /*
     * 局部变量：函数 或 函数块内的变量
     * 实例变量（成员变量）：类以内，函数 或 函数块以外的变量
     * 类变量（静态变量）：
     * 参数变量（形参变量）：
     * */

    private int instanceVar;
    private static int staticVar;

    public void method(int paramVar) {
        int localVar = 10;
        instanceVar = localVar;
        staticVar = paramVar;

        System.out.println("成员变量：" + instanceVar);
        System.out.println("静态变量：" + staticVar);
        System.out.println("参数变量：" + paramVar);
        System.out.println("局部变量：" + localVar);
    }

    public static void main(String[] args) {
//        VariableType v = new VariableType();
//        v.method(20);
//
//        int a = 10, b = 20;
//        Integer c = 30, d = 40;
//        swap(a, b);
//        swap2(c, d);
//        System.out.println("a = " + a + ", b = " + b);
//        System.out.println("c = " + c + ", d = " + d);

//        testLocalVariable();
//        testInstanceVariable();
        testStaticVariable();
    }


    /* 值传递 */
    public static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    /* 引用传递
    为什么说Java没有引用传递?
    https://blog.csdn.net/weixin_37749732/article/details/120390551
    */
    public static void swap2(Integer x, Integer y) {
        Integer tmp = x;
        x = y;
        y = tmp;
    }

    /* 测试局部变量 */
    public static void testLocalVariable() {
//        int a=10;
//        int b;
//        b=20;
//        System.out.println("a = "+a);
//        System.out.println("b = "+b);
        Cat cat = new Cat();
        cat.addAge();
    }

    /* 测试成员变量（实例变量） */
    private static void testInstanceVariable() {
//        Cat cat = new Cat();
//        cat.name = "Hello";
//        System.out.println("name = " + cat.name);
        Emp emp = new Emp("王五");
        emp.setSalary(3500);
        emp.printEmp();
    }

    /* 测试静态变量（类变量） */
    private static void testStaticVariable() {
//        Boss boss = new Boss();
//        boss.age = 43;
//        Boss.age = 55;
//        System.out.println("老板的年龄: " + boss.age);
//        System.out.println("老板的爱好: " + Boss.HOBBY);

//        AppConfig.getAppInfo();

        Counter c1, c2, c3;
        c1 = new Counter();
        c2 = new Counter();
        c3 = new Counter();
        Counter.printCount();
    }
}

class Cat {
    public void addAge() {
        int age = 0;
//        int age;
        age = age + 7;
        System.out.println("小猫的年龄是：" + age);
    }

    private int cate;
    public String name = "Kitty";
}

class Emp {
    public String name;
    private double salary;

    public Emp(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printEmp() {
        System.out.println("名字：" + this.name);
        System.out.println("薪水：" + this.salary);
    }
}

class Boss {
    public static int age;
    public static final String HOBBY = "钓鱼";
}

class AppConfig {
    private static final String APP_NAME = "MyAPP";
    private static final String APP_VERSION = "1.2.1";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    public static void getAppInfo() {
        System.out.println("app_name: " + APP_NAME);
        System.out.println("app_version: " + APP_VERSION);
        System.out.println("database_url: " + DB_URL);
    }

}

class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static void printCount() {
        System.out.println("已经创建对象数：" + count);
    }

}