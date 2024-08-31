package com.randolflu.utils;

public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    /*获取*/
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    /*放置*/
    public static void set(Object data) {
        THREAD_LOCAL.set(data);
    }

    /*释放*/
    public static void remove() {
        THREAD_LOCAL.remove();
    }

}
