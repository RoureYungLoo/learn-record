package _2_official_utils;

import javax.naming.InsufficientResourcesException;
import java.awt.image.BandCombineOp;
import java.io.*;
import java.rmi.RemoteException;
import java.util.Scanner;

public class _11_Exception {
    public static void main(String[] args) {
    /* 常见异常
        1. 非法输入
        2. 文件不存在
        3. 访问空指针
        4. 内存溢出
        5. 网络连接失败
        6. 下标越界

    异常分类：
        1. 检查性异常
        2. 运行时异常
        3. 错误

    类层次：
        Throwable-
            Error-
                IOError
                OutOfMemoryError
            Exception-
                IOException-
                    FileNotFoundException
                RuntimeException-
                    NullPointerException

    */
        // testTryCatch();

        // testThrow();

        // testTryWithResources();

        testMyException();

        /* 通用异常
        * 1. JVM异常
        * 2. 程序级异常
        * */

    }

    public static void testTryCatch() {
        try {
            int[] a = new int[2];
            System.out.println(a[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            FileInputStream file = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally { /* 可选的 */
            System.out.println("无论是否发生异常都会执行");
        }

    }

    public static void testThrow() {
        System.out.println("11");
        throw new IllegalArgumentException("参数不合法");
        // System.out.println("22"); // 报错：unreachable statement
    }

    public static void testThrows() throws IOException, RemoteException, InsufficientResourcesException {
        BufferedReader reader = new BufferedReader(new FileReader("filePath"));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    }

    public static void testTryWithResources() {
        /* try-with-resources 语句关闭所有实现 AutoCloseable 接口的资源 */
        String line;
        String filename = "C:\\Users\\RuoYang\\Desktop\\FileStream.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                System.out.println("Line => " + line);
            }
        } catch (IOException e) {
            System.out.println("出错了：" + e.getMessage());
        }

        /* try-with-resources 多个资源 */
        try (Scanner sc = new Scanner(new File(filename));
             PrintWriter pr = new PrintWriter(new File(filename + ".bk"))) {
            while (sc.hasNext()) {
                pr.print(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testMyException() {
        CheckAccount c = new CheckAccount(101);
        System.out.println("存入500");
        c.deposit(500);

        try {
            System.out.println("取出200");
            c.withdraw(200);
            System.out.println("取出400");
            c.withdraw(400);
        } catch (MyException me) {
            System.out.println("对不起，还差" + me.getAmount() + "才能取出");
            me.printStackTrace();
        }
    }

}

class MyException extends Exception {
    private double amount;

    public MyException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
}

class CheckAccount {
    private double balance;
    private int number;

    public CheckAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws MyException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new MyException(needs);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }
}