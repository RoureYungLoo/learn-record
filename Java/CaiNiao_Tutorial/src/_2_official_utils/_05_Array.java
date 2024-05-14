package _2_official_utils;

public class _05_Array {
    public static void main(String[] args) {
        // test1();
        test4();

    }

    private static void test1() {
        /* 声明数组 */
        int[] ages;
        int days[];

        /* 创建数组 */
        ages = new int[5];
        days = new int[9];

        int[] status = {200, 300, 500, 400, 100};

        int total = 0;
        for (int i = 0; i < 5; i++) {
            ages[i] = i;
        }
        for (int age : ages) {
            total += age;
        }
        System.out.println(ages);
        System.out.println(total);

        for (int i = 0; i < status.length; i++) {
            System.out.print(status[i]);
            System.out.print(", ");
            if (i == 4) {
                System.out.print("\n");
            }
        }

        test2(ages);
        String[] ds = test3();
        for (String d : ds) {
            System.out.println(d);
        }
    }

    /* 数组形参 */
    private static void test2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /* 数组返回值 */
    private static String[] test3() {
        String days[] = {"周一", "周二", "周三"};
        return days;
    }

    /* 多维数组 */
    public static void test4() {
        int counter = 0;
        /* 声明 */
        String[][] strs;

        /* 创建 */
        strs = new String[3][4];

        /* 初始化 */
        for (int j = 0; j < strs.length; j++) {
            for (int k = 0; k < strs[j].length; k++) {
                strs[j][k] = String.valueOf(counter++);
            }
        }
        /* 遍历 */
        for (String[] s_arr : strs) {
            for (String s : s_arr) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
        }
        /* 数组工具类 Arrays类 */


    }
}
