package _1_base._09_condition;

public class Condition {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /* if */
        if (10 < 20) {
            System.out.println("条件为真");
        }

        /* if else */
        if (10 > 20) {
            System.out.println("条件为真");
        } else {
            System.out.println("条件为假");
        }

        /* if else if */
        int age = 30;
        if (age == 10) {
            System.out.println("age is 10");
        } else if (age == 20) {
            System.out.println("age is 20");
        } else if (age == 30) {
            System.out.println("age is 30");
        } else {
            System.out.println("所有条件都不满足");
        }

        /* 条件嵌套 */
        int num = 20;
        if (age == 30) {
            if (num == 20) {
                System.out.println("age is 30 and num is 20");
            }
        }

        /* switch case */
        char[] grades = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char grade :
                grades) {
            switch (grade) {
                case 'A':
                    System.out.println("优秀");
                    break;
                case 'B':
                case 'C':
                    System.out.println("良好");
                    break;
                case 'D':
                    System.out.println("及格");
                    break;
                case 'F':
                    System.out.println("不及格");
                    break;
                default:
                    System.out.println("未知等级");
            }
        }

        /* case匹配成功后，直到遇到break才会退出 */
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
        }
    }
}
