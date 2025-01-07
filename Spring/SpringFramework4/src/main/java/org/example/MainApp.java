package org.example;

import org.example.domain.*;
import org.example.event.CustomEventPublisher;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 */
public class MainApp {
    public static void main(String[] args) {
         ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(BeanConfig.class);
//        context.register(BeanConfig.class);
        // ...加载各种配置类
//        context.register(AppConfig.class);
//         context.register(TextEditorConfig.class);
//        context.refresh();

        // ClassPathResource resource = new ClassPathResource("beans.xml");
        // XmlBeanFactory context = new XmlBeanFactory(resource);

        // ApplicationContext context  = new FileSystemXmlApplicationContext("C:\\Users\\RuoYang\\Desktop\\bean.xml");
        // HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
        // HelloWorld obj2= (HelloWorld) context.getBean("helloWorld");
        // HelloWorld obj3 = (HelloWorld) context.getBean("helloWorld");

        // System.out.println(obj1);
        // System.out.println(obj2);
        // System.out.println(obj3);

//        BaseBean baseBean = context.getBean(BaseBean.class);
//        System.out.println(baseBean);
//        SubBean subBean = context.getBean(SubBean.class);
//        System.out.println(subBean);
//        SubBean subBean = (SubBean) context.getBean("subBean2");
//        System.out.println(subBean);
//
//        TextEditor textEditor = context.getBean(TextEditor.class);
//        textEditor.spellCheck();

//        Foo foo = (Foo) context.getBean("foo");

//        JavaCollection collection = context.getBean(JavaCollection.class);
//        collection.getNicknames();
//        collection.getLangs();
//        collection.getHobbies();
//        collection.getAddrMap();
//        collection.getCateProps();
//        collection.getUsername();

//        TextEditor2 textEditor2 = context.getBean(TextEditor2.class);
//        textEditor2.spellCheck();

//        UserService service = context.getBean(UserService.class);
//        service.selectList();

//        context.registerShutdownHook();


//        Day day = (Day) context.getBean("day");
//        Year year = context.getBean(Year.class);
//        System.out.println(day);
//        System.out.println(year);

//        Foo foo = (Foo) context.getBean("foo");

//        TextEditor textEditor = context.getBean(TextEditor.class);
//        textEditor.spellCheck();

//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        context.start();

//        Day day = context.getBean(Day.class);

//        context.stop();

//        CustomEventPublisher publisher = (CustomEventPublisher) context.getBean("publisher");
//        publisher.publish();
//        publisher.publish();
//        publisher.publish();

//        Student student = context.getBean(Student.class);
//        student.getName();
//        System.out.println("------------------");
//        student.throwAnException();

    }
}
