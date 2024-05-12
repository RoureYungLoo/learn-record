package _1_base._03_object_and_class;

public class Employee {
    String name;
    int age;
    String designation;
    double salary;

    public Employee(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printEmployee() {
        System.out.println("名字：" + this.name);
        System.out.println("年龄：" + this.age);
        System.out.println("职位：" + this.designation);
        System.out.println("薪水：" + this.salary);
    }
}
