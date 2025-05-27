package com.randolflu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

public class JavaReflection {
    public static void main(String[] args) throws Exception {

        /* 加载一个类 */
        Class<?> userClass = Class.forName("com.randolflu.reflection.User");
//            userClass = User.class;
//        userClass = new User().getClass();


        /* 实例化对象 */
        User user1 = (User) userClass.newInstance();
        System.out.println("user1 " + user1);

        /* 获取无参构造器 */
        Constructor<?> noArgConstructor = userClass.getConstructor();
        Object user2 = noArgConstructor.newInstance();
        System.out.println("user2 " + user2);

        /* 获取有参构造器 */
        Constructor<?> allArgConstructor = userClass.getConstructor(String.class, Integer.class, Short.class, LocalDate.class);
        User user3 = (User) allArgConstructor.newInstance("lisi", 23, Short.parseShort("1"), LocalDate.of(1998, 2, 16));
        System.out.println(user3);

        /* 获取构造器 名称与访问权限 */
        System.out.println(allArgConstructor.getName());
        int modifier = allArgConstructor.getModifiers();
        String accessPermission = Modifier.toString(modifier);
        System.out.println(accessPermission);

        Class<?>[] parameterTypes = allArgConstructor.getParameterTypes();
        for (Class<?> type : parameterTypes) {
            System.out.println("-- start --");
            System.out.println(type.getName());
            System.out.println(type.getTypeName());
            System.out.println(type.getSimpleName());
            System.out.println(type.getPackageName());
            System.out.println(type.getCanonicalName());
            System.out.println("-- end --");
        }

        /* 反射获取属性名以及访问权限 */
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName() + " " +
                    Modifier.toString(declaredField.getModifiers()) + "\n");
        }

        /* 通过反射实例化对象,并初始化 */
        Object o = noArgConstructor.newInstance();
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "zhangsan");

        userClass.getDeclaredField("age").set(o, 25);
        userClass.getField("gender").set(o, Short.parseShort("2"));
        userClass.getDeclaredField("birth").set(o, LocalDate.of(1999, 12, 12));
        System.out.println(o);

        /* 通过反射获取方法, 并调用方法 */
        Method setBirth = userClass.getMethod("setBirth", LocalDate.class);
        Object retValue = setBirth.invoke(o, LocalDate.of(2000, 10, 10));
        System.out.println(retValue);
        System.out.println(o);

        Method getName = userClass.getDeclaredMethod("getName");
        retValue = getName.invoke(o);
        System.out.println(retValue);

        /* 获取父类 */
        Class<?> superclass = userClass.getSuperclass();
        System.out.println("superclass: " + superclass.getName());

        /* 获取实现的接口 */
        Class<?>[] interfaces = userClass.getInterfaces();
        if (interfaces.length == 0) {
            System.out.println("no implements interfaces");
        } else {
            for (Class<?> anInterface : interfaces) {
                System.out.println(anInterface.getName());
            }
        }

        userClass.get

    }
}
