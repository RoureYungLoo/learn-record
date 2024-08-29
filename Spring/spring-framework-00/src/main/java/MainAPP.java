import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld hello = (HelloWorld) context.getBean("hello");
        System.out.println(hello);
    }
}
