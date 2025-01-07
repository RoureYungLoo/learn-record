package com.xxx.structural.adapter_pattern.two;



import com.xxx.utils.XMLUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args)  {

        // 可以在配置文件中配置
//        String className = "com.xxx.structural.adapter_pattern.two.OperationAdapter";
//        Class<?> clazz = Class.forName(className);
//        Constructor<?> constructor = clazz.getConstructor();
//        OperationAdapter adapter = (OperationAdapter) constructor.newInstance();

        Object o = XMLUtils.gerBean();
        OperationAdapter adapter = (OperationAdapter) o;

        int scores[] = {84, 76, 50, 69, 90, 91, 88, 96};
        int result[];
        int score;

        System.out.println("成绩排序结果");
        result = adapter.sort(scores);
        for (int j : result) {
            System.out.print(j + ", ");
        }

        System.out.println("查找成绩90");
        score = adapter.search(result, 90);
        if (score == -1) {
            System.out.println("没有找到成绩90");
        } else {
            System.out.println("找到成绩90，下标为result[" + score + "]");
        }

        score = adapter.search(result, 92);
        if (score == -1) {
            System.out.println("没有找到成绩92");
        } else {
            System.out.println("找到成绩92，下标为result[" + score + "]");
        }


    }
}
