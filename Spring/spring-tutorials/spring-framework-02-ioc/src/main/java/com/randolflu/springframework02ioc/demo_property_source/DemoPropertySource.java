package com.randolflu.springframework02ioc.demo_property_source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoPropertySource {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(PersonConfig.class);

        /* -Dperson.name=xiaoming -Dperson.age=18 */
//        String name = context.getEnvironment().getProperty("person.name");
//        String ageStr = context.getEnvironment().getProperty("person.age");
//        int age = 0;
//        if (ageStr != null) {
//            age = Integer.parseInt(ageStr);
//        }
        context.refresh();
        Person person = context.getBean(Person.class);
//        person.setAge(age);
//        person.setName(name);
        System.out.println(person);
        person.sayHello();

    }
}
