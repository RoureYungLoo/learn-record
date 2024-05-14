package _2_official_utils;

// https://blog.csdn.net/qq_45798556/article/details/117924203
public class _03_String {
    public static void main(String[] args) {
        /* String 是类 */
        String str1 = "str1";
        String str2 = new String("str2");

        /* Java中的String字面值是【不可变】的, 是存储在【字符串常量池】中的*/

        String s1 = "HelloWorld";
        String s2 = "HelloWorld";
        String s3 = s1;
        System.out.println(s1 == s2); // true
        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());
        System.out.println("s3: " + s3.hashCode());

        String s4 = new String("HelloWorld");
        String s5 = new String("HelloWorld");
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));
        System.out.println("s4: " + s4.hashCode());
        System.out.println("s5: " + s5.hashCode());

        // 对象比较 https://blog.csdn.net/qq_21864095/article/details/113176771
        // https://blog.csdn.net/u013063153/article/details/78808923

        char[] hello = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(hello);
        System.out.println(str3);

        System.out.println(str1.length());
        System.out.println(str3.length());

        System.out.println("Hello" + " World");
        System.out.println(s1.concat(str3));

        String base_str = "-- %f -- %d -- %s";
        String str5 = String.format(base_str, 12.34f, 34, "str5");
        System.out.println(str5);
        System.out.printf("- %f - %d - %s", 12.3F, 343, "pf");

        // String类的其他方法参考API文档
    }

}
