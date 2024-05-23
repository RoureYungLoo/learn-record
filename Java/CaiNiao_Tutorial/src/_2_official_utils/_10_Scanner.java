package _2_official_utils;

import java.util.Scanner;

public class _10_Scanner {
    public static void main(String[] args) {
        // testNext();
        // testNextLine();
        // testNextXXX();
        testCalculator();
    }

    public static void testNext() {
        Scanner scan = new Scanner(System.in);

        if (scan.hasNext()) {
            /* 遇到空格结束 */
            String str = scan.next();
            System.out.println("你的输入：" + str);
        }
        scan.close();
    }

    public static void testNextLine() {
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextLine()) {
            /* 遇到换行或回车结束 */
            String str = scan.nextLine();
            System.out.println("你的输入：" + str);
        }
        scan.close();
    }

    public static void testNextXXX() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.println("输入整数：");
        if (scan.hasNextInt()) {
            i = scan.nextInt();
        } else {
            System.out.println("输入的不是整数");
        }
        System.out.println("输入小数：");
        if (scan.hasNextFloat()) {
            f = scan.nextFloat();
        } else {
            System.out.println("输入的不是小数");
        }
        scan.close();
    }

    public static void testCalculator() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0d;
        int m = 0;

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.println("和：" + sum);
        System.out.println("平均值：" + (sum / m));
        scanner.close();
    }
}
