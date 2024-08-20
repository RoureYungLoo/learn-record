package _3_oop;

/* Java 枚举是一个特殊的类 */
public class _07_Enum {
    public static void main(String[] args) {
        // testColor();
        // Phone.choose(Phone.Clr.BLACK);
        // testMethod();

        Days dd = Days.THREE;
        dd.daysInfo();
    }

    public static void testColor() {
        System.out.println(Color.BLACK);
        System.out.println(Color.RED);
        System.out.println(Color.GREEN);

        Phone.testPhone();
        Phone.travel();
    }

    public static void testMethod() {
        // values() 返回枚举类中所有的值
        Color[] colors = Color.values();
        for (Color c : colors) {
            System.out.println(c);
        }

        // ordinal()方法可以找到每个枚举常量的索引，就像数组索引一样
        int index = Color.PINK.ordinal();
        System.out.println(index);

        // valueOf()方法返回指定字符串值的枚举常量
        Color value = Color.valueOf("BLACK");
        System.out.println(value);
    }
}

enum Color {
    RED, GREEN, BLUE, YELLOW, PINK, WHITE, BLACK
}

class Phone {
    /* 枚举类可以声明在内部类 */
    enum Clr {
        RED, GREEN, BLUE, YELLOW, PINK, WHITE, BLACK;
    }

    public static void testPhone() {
        Clr clr = Clr.RED;
        System.out.println(clr);
    }

    public static void travel() {
        for (Clr color : Clr.values()) {
            System.out.println(color);
        }
    }

    public static void choose(Clr color) {
        switch (color) {
            case RED:
                System.out.println("red phone");
                break;
            case BLACK:
                System.out.println("black phone");
                break;
        }
    }
}
/* 每个枚举都是通过 【Class】 在内部实现的，且所有的枚举值都是 【public static final】的 */

class Colo {
    public static final Colo RED = new Colo();
    public static final Colo BLUE = new Colo();
    public static final Colo GREEN = new Colo();
}

/* 迭代枚举元素 */

/* switch 枚举类 */

/* 枚举类成员 */
// 枚举类可以包含抽象方法；枚举类构造函数只能是 private

enum Days {
    ONE, TWO, THREE;

    private Days() {
        System.out.println("Days构造函数: " + this.toString());
    }

    public void daysInfo() {
        System.out.println(this);
    }
}