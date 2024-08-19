package _3_oop;

class Animal{
    private String id;
    private String name;
    private String color;
    private String category;

    public Animal() {
    }

    public Animal(String _id, String _name, String _color, String _category) {
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

