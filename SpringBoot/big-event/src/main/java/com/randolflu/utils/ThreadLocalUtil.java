package com.randolflu.utils;

import java.util.Map;

public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    /*获取*/
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    public static Integer getThreadLocal(String key) {
        Map<String, Object> claims = (Map<String, Object>) THREAD_LOCAL.get();
        return (Integer) claims.get(key);
    }

    public static String getThreadLocalName() {
        Map<String, Object> claims = (Map<String, Object>) THREAD_LOCAL.get();
        return (String) claims.get("name");
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
