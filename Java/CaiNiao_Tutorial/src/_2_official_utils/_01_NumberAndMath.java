package _2_official_utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class _01_NumberAndMath {
    /*
     * 基本类型：byte、short、int、long、float、double
     * 包装类：Byte、Short、Integer、Long、Float、Double，这六个包装类是抽象类Number的子类
     *
     * 基本类型：boolean、char
     * 包装类：Boolean、Character
     *
     * 装箱：基本类型->包装类
     * 拆箱：包装类->基本类型
     *
     * */
    public static void main(String[] args) {
        Integer x = 5; //
        x = x + 10; // 拆箱
        System.out.println(x);

        testMath();

    }

    private static void testMath() {
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
        System.out.println(Math.PI);

        double[] nums={1.4, 1.5, 1.6, -1.4, -1.5, -1.6};
        for (double num: nums) {
            test(num);
        }

    }

    public static void test(double num){
        System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("Math.round(" + num + ")=" + Math.round(num));
        System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));
    }
}
