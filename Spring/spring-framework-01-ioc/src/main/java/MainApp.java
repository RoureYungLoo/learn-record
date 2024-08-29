import com.xxx.config.SpringConfiguration;
import com.xxx.dao.UserDao;
import com.xxx.entity.Book;
import com.xxx.entity.User;
import com.xxx.service.BookService;
import com.xxx.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码参考地址：
 * [https://blog.csdn.net/xianyu120/article/details/120611838]
 *
 * */
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserDao userDao = (UserDao) context.getBean("userDao1");

        //List<User> userList = userDao.findAll();
        // printUsers(userList);

        //UserService userService = (UserService) context.getBean("userService1");
        //List<User> users = userService.findAllUsers();
        // printUsers(users);

        BookService bookService = (BookService) context.getBean("bookServiceImpl1");
        List<Book> books = bookService.findAll();
        printBooks(books);
    }

    private static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.getName() + book.getPrice() + "元");
        }
    }

    public static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.getName() + " " + user.getAge());
        }
    }
}
