package _1_base._03_object_and_class;

public class Dog {
    // 成员变量
    String breed;
    int size;
    String color;
    int age;
    String name;

    // 构造函数
    public Dog(){}
    public Dog(String breed){
        this.breed = breed;
        System.out.println("小狗的品种是："+breed);
    }

    // 成员函数
    void eat(){}
    void run(){}
    void sleep(){}
    void name(){}

    void setName(String name){
        this.name = name;
    }

    String getName(){
        System.out.println("小狗的名字是："+this.name);
        return this.name;
    }
}
