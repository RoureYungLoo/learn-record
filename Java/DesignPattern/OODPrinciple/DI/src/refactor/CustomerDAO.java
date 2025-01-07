package refactor;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomerDAO {
    public void addCustomers() throws Exception {
        String className = "refactor.TXTDataConvertor"; // 读取config.xml ,获取 className
        /* 拿到类对象Class，利用反射 */
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance();

        DataConvertor convertor = (DataConvertor) o;
         convertor.readFile();
        // ...
    }
}
