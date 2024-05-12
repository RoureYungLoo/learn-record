package _1_base._10_loop;

public class Loop {
    public static void main(String[] args) {
        // testWhile();
        // testDoWhile();
        // testFor();
        testEnhancedFor();

    }

    private static void testEnhancedFor() {
        int[] ages = {10, 20, 30, 40};
        String[] names = {"James", "Tom", "Lily", "Jerry"};

        /* foreach */
        for (int age : ages) {
            if (age==30) {
//                break;
                continue;
            }
            System.out.print(age + ", ");
        }
        System.out.print("\n");

        /* foreach */
        for (String name : names) {
            System.out.print(name);
            System.out.print(", ");
        }
        System.out.print("\n");
    }

    private static void testFor() {
        for (int times = 10; times < 20; times++) {
            System.out.println("times = " + times);
        }
    }

    private static void testDoWhile() {
        int times = 10;
        do {
            System.out.println("times = " + times);
            times++;
        } while (times < 20);
    }

    private static void testWhile() {
        int times = 10;
        while (times < 20) {
            System.out.println("times = " + times);
            times++;
        }
    }
}
