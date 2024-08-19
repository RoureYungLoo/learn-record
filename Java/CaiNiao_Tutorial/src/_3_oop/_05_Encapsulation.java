package _3_oop;

public class _05_Encapsulation {
    // 一种将抽象性函式接口的实现细节部分包装、隐藏起来的方法
    public static void main(String[] args) {
        testEncap();
    }
    public static void testEncap(){
        EncapTest en = new EncapTest();
        en.setAge(20);
        en.setIdNum("123");
        en.setName("James");

        System.out.println(en.getAge()+" "+en.getIdNum()+" "+en.getName());
    }
}

/**
 * 实现封装的步骤 ：
 * 1. 修改访问控制属性为 private
 * 2. 提供公共访问方法
 */
class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class EncapTest {
    private String name;
    private String idNum;
    private int age;

    // 外部类访问该类成员变量的入口, 通常情况下，这些方法被称为getter和setter方法。
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}