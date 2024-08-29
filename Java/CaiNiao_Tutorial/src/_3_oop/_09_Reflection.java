package _3_oop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的作用：在程序运行期间查询、访问、修改：类、接口、成员变量、成员方法
 * 和反射相关的类和接口：
 * java.lang.Class                 表示一个类
 * java.lang.reflect.Field         表示类的成员变量
 * java.lang.reflect.Method        表示类的成员方法
 * java.lang.reflect.Constructor   表示类的构造函数
 * <p>
 * 反射使用流程：
 * 1. 获取 Class 对象
 * 2. 获取成员信息
 * 3. 操作成员
 */
public class _09_Reflection {

    public static void main(String[] args) throws Exception {
        // Test.test2();
        // Test.test3();
        // Test.test4();
        // Test.test5();
        // Test.test6();
        Test.test7();
    }
}

class Test {
    /* 1. 获取 Class 对象 */
    public static void test1() {
        // Class<String> clazz = String.class;

        String str = "Hello";
        Class<?> clazz = str.getClass();

        // Class<?> clazz = Class.forName("java.lang.String");
    }

    /* 2. 创建对象 */
    public static void test2() throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Object obj = clazz.getDeclaredConstructor().newInstance();
    }

    /* 3. 访问成员变量 */
    public static void test3() throws Exception {
        Cup cup = new Cup("Red", 250);

        Class<?> clazz = Cup.class;
        Field field = clazz.getDeclaredField("color");
        field.setAccessible(true); // 如果成员变量是私有的，需要设置为可访问

        Object val = field.get(cup);
        System.out.println(val);
        field.set(cup, "Black");
        System.out.println(cup);
    }

    /* 4. 访问成员方法 */
    public static void test4() throws Exception {
        Cup cup = new Cup("yellow", 3500);

        Class<?> clazz = Cup.class;
        Method method = clazz.getMethod("show");
        method.invoke(cup);

        Method methodWithArgs = clazz.getMethod("show", Double.class);
        methodWithArgs.invoke(cup, 278.89);
    }

    /* 5. 访问构造函数 */
    public static void test5() throws Exception {
        Class<?> clazz = Cup.class;
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("pink", 1000);
        System.out.println(obj);

    }

    /* 6. 获取接口和父类 */
    public static void test6() {
        Class<?> clazz = Cup.class;

        // 获取所有实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }

        // 获取父类
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("父类是：" + superclass.getName());
    }

    /* */
    public static void  test7() throws Exception{
        Class<?> clazz = Jason.class;

        Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
        Object person = constructor.newInstance("John",30);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println("Name: "+ name.get(person));

        name.set(person,"Joe");
        System.out.println("Updated name: "+name.get(person));

        Method method = clazz.getMethod("greet", String.class);
        method.invoke(person,"world");
    }
}

// class Cup {
class Cup extends Things implements Valuables, Fashionable, Readable {
    private String color;
    private int volume;

    public Cup() {
    }

    public Cup(String color) {
        this.color = color;
    }

    public Cup(String color, int volume) {
        this.color = color;
        this.volume = volume;
    }

    public void show() {
        System.out.println("I am a cup");
    }

    public void show(Double d) {
        System.out.println("I am a cup " + d);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Cup{" +
                "color='" + color + '\'' +
                ", volume=" + volume +
                '}';
    }
}

class Things {
    private String category;
}

interface Valuables {
}

interface Fashionable {
}

interface Reliable {
}

class Jason {
    private String name;
    private int age;

    public Jason(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet(String msg) {
        System.out.println(name + " says: " + msg);
    }
}