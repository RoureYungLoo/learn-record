package _1_base._03_object_and_class;

public class ObjectAndClass {
    public static void main(String[] args) {
        Dog dog = new Dog("金毛");
        dog.setName("小金金");
        String dogName = dog.getName();
        System.out.println(dogName);

        Employee emp1 = new Employee("张三");
        Employee emp2 = new Employee("李四");

        emp1.setAge(23);
        emp2.setAge(32);

        emp1.setDesignation("初级工程师");
        emp2.setDesignation("高级工程师");

        emp1.setSalary(5000);
        emp2.setSalary(8000);

        emp1.printEmployee();
        emp2.printEmployee();
    }
}

