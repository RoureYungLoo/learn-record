package _3_oop;

public class NewCat extends Animal {
    public NewCat(String _id, String _name, String _color, String _category) {
        super(_id, _name, _color, _category); // 实现对父类成员的访问，用来引用当前对象的父类

    }
}
