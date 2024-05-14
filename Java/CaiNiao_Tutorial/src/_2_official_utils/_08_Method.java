package _2_official_utils;

public class _08_Method {
    public static void main(String[] args) {
        /* Java 方法是一个函数 */
        /*
        修饰符 返回值类型 方法名(参数类型 参数名) {
            // 方法体
            // ...
        }
        */
        int result;
        int num1 = 10;
        int num2 = 20;
        result = max(num1, num2);
        System.out.println(result);

        test();

        /* 实参 */
        printNum("hello world", 3);

        SwapByValue(num1, num2);

        printArgs(args);

        testConstructor();

        printMax(2.5, 3.5);
        printMax(2.5, 3.5, 4.5, 5.5);
        // printMax(2.5, 3.5, 4.5, 5.5, new double[]{6.5, 7.5}); // 错误的用法
        printMax(2.5, 3.5, new double[]{6.5, 7.5});

        /* 手动清理对象 */
        System.gc();
    }

    public static int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    /* void */
    public static void test() {
        System.out.println("这个函数无返回值");

    }

    /* 形参 msg、times */
    public static void printNum(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }

    /* 按值传递参数 */
    public static void SwapByValue(int n1, int n2) {
        System.out.println("交换前：n1 = " + n1 + ", n2 = " + n2);

        /* 交换 n1、n2 */
        int tmp = n1;
        n1 = n2;
        n2 = tmp;

        System.out.println("交换后：n1 = " + n1 + ", n2 = " + n2);

    }

    /* 方法重载 */
    public static double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    /* 变量作用域
     * 局部变量：在方法内声明的变量。
     */
    public static void test2() {
        int k;
        for (int i = 0; i < 10; i++) {
            int j;
        }
    }

    /* 命令行参数 */
    public static void printArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }

    /* 构造方法：访问修饰符和类的访问修饰符相同
        访问修饰符 类名(参数) {
            // ...
        }
    */
    public static void testConstructor() {
        MyClass myClass1, myClass2;
        myClass1 = new MyClass();
        myClass2 = new MyClass(21);

    }

    /* 可变参数 */
    public static double printMax(double d1, double d2, double... params) {
        double tmp = d1 > d2 ? d1 : d2;

        for (int i = 0; i < params.length; i++) {
            if (params[i] > tmp) {
                tmp = params[i];
            }
        }
        System.out.println("最大值是：" + tmp);
        return tmp;
    }

    /* finalize() 方法，对象被清除之前调用 */


}

class MyClass {
    int x;

    MyClass() {
        x = 10;
        System.out.println("调用 无 参构造函数");
    }

    MyClass(int val) {
        x = val;
        System.out.println("调用 有 参构造函数");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("正在进行对象@"+this.hashCode()+"回收前的工作");
    }
}