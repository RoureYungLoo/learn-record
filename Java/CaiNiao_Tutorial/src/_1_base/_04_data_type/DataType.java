package _1_base._04_data_type;

public class DataType {
    // byte、short、int、long
    // float、double、boolean、char
    public static void main(String[] args) {
        Test t = new Test();
//        t.test_byte();
//        t.test_short();
//        t.test_int();
//        t.test_long();
//        t.test_float();
//        t.test_double();
//        t.test_boolean();
//        t.test_char();
        t.test_cast();
    }

}

class Test {
    boolean bool;
    byte by;
    char ch;
    double d;
    float f;
    int i;
    long l;
    short sh;
    String str;

    public void test_byte() {
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：" + Byte.class);
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println("默认值：" + by);
        System.out.println();
    }

    public void test_short() {
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：" + Short.class);
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println("默认值：" + sh);
        System.out.println();

    }

    public void test_int() {
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：" + Integer.class);
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println("默认值：" + i);
        System.out.println();
    }

    public void test_long() {
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：" + Long.class);
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println("默认值：" + l);
        System.out.println();
    }

    public void test_float() {
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：" + Float.class);
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println("默认值：" + f);
        System.out.println();
    }

    public void test_double() {
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：" + Double.class);
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println("默认值：" + d);
        System.out.println();
    }

    public void test_boolean() {
        System.out.println("默认值：" + bool);
        System.out.println();

    }

    public void test_char() {
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：" + Character.class);
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);
        System.out.println("char 默认值：" + ch);
        System.out.println("String 默认值：" + str);

    }

    public void test_const() {
        final double PI = 3.1415927d;
    }

    public void test_cast() {
        /* 自动类型转换 */
        char gender = 'M';
        int i = gender;
        System.out.println("自动类型转换：i = " + i);

        int a = gender + 1;
        System.out.println("自动类型转换：a = " + a);

        /* 强制类型转换 */
        int weight = 130;
        byte b = (byte) weight;
        System.out.println("强制类型转换：b = " + b);

        /* 隐含类型转换 */
        long time1 = 17000000l;
        long time2 = 17000000L;
        float score1 = 95.5f;
        float score2 = 95.5F;
        double money1 = 125.34d;
        double money2 = 125.34D;

        /* 表达式类型提升 */
        byte aa = 40;
        byte bb = 50;
        //byte cc = a + b;             // 编译错误
        //cc = (byte) (a + b);          // 正确
        int ii = a + b;

    }
}
