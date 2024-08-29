package com.xxx.service;

import com.xxx.dao.UserDaoImpl;
import com.xxx.dao.UserDaoMysqlImpl;
import com.xxx.dao.UserDaoOracleImpl;
import com.xxx.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Test
    public void testUserService() {
        // UserService userService = new UserServiceImpl();
        // userService.findUser();

        UserServiceImpl service = new UserServiceImpl();
        service.setUserDao(new UserDaoImpl());
        service.findUser();

        service.setUserDao(new UserDaoOracleImpl());
        service.findUser();

        service.setUserDao(new UserDaoMysqlImpl());
        service.findUser();
    }

    @Test
    public void test01() {
        //解析beans.xml文件 , 生成管理相应的Bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean : 参数即为spring配置文件中bean的id .
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) context.getBean("ServiceImpl");
        service.findUser();
    }

    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User lisi = (User) context.getBean("lisi");
        lisi.show();

        User u1001 = (User) context.getBean("u1001");
        User u1002 = (User) context.getBean("u1002");
        User u1003 = (User) context.getBean("u1003");

        u1001.show();
        u1002.show();
        u1003.show();

        User bro = (User) context.getBean("brother");
        bro.show();

    }

    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User myId = (User) context.getBean("myId");
        myId.show();

        User myAlias = (User) context.getBean("myAlias");
        myAlias.show();


        Cat cat = context.getBean(Cat.class);
        cat.show();
    }

    @Test
    public void test05() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello newHello = (Hello) context.getBean("newHello");
        newHello.show();
    }

    @Test
    public void test06() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* 1. 常量 注入*/
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());

        /* 2. Bean 注入 */
        Student lisi = (Student) context.getBean("lisi");
        System.out.println(lisi.getName());
        System.out.println(lisi.getAddress());

        /* 3. 数组 注入 */
        String[] books = lisi.getBooks();
        for (String book : books) {
            System.out.println(book);
        }

        /* 4. List 注入 */
        List<String> hobbies = lisi.getHobbies();
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        /* 5. Map 注入 */
        Map<String, String> cards = lisi.getCard();
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /* 6. Set 注入 */
        Set<String> games = lisi.getGames();
        for (String game : games) {
            System.out.println(game);
        }

        /* 7. Null 注入 */
        String wife = lisi.getWife();
        System.out.println(wife);

        /* 8. Properties 注入 */
        Properties info = lisi.getInfo();
        System.out.println(info);
    }

    @Test
    public void test07(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person wangwu = (Person) context.getBean("wangwu");
        System.out.println(wangwu.toString());

        Person caocao = (Person) context.getBean("caocao");
        System.out.println(caocao);
    }

    @Test
    public void test08(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person liubei1 = (Person) context.getBean("liubei");
        Person liubei2 = (Person) context.getBean("liubei");
        System.out.println(liubei1==liubei2);

        Person zhangfei1 = (Person) context.getBean("zhangfei");
        Person zhangfei2 = (Person) context.getBean("zhangfei");
        System.out.println(zhangfei1==zhangfei2);
    }
}
