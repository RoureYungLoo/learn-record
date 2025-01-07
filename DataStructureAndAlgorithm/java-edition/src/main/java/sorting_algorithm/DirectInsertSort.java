package sorting_algorithm;

import com.mysql.cj.protocol.x.ReusableOutputStream;

public class DirectInsertSort {
    public static void directInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // i=0时只有1个元素，视为有序
            int key = arr[i]; // 关键字
            int j = i - 1; //
            while (j >= 0 && key < arr[j]) { // 比较关键字 key 和 arr[j]
                arr[j + 1] = arr[j]; // 有序数组比key大的往后移动
                j--;
            }
            arr[j + 1] = key; // 此时j=-1，表示关键字key比有序数组的任意元素都要小，放在有序数组的第一位
        }
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // n个数比较 ( n-1 ) 轮
            // System.out.println("第" + i + "轮"); // 每比较一轮，就会找出当前轮次的最大值
            for (int j = 0; j < arr.length - i - 1; j++) { // 每轮比较( n-1 - i )次， i为轮次
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void QuickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int base = arr[start];
        int low = start;
        int high = end;

        /* 版本1 */
        while (low < high) {
            while (low < high && arr[high] > base) high--;
            while (low < high && arr[low] < base) low++;
            if (low < high) {
                int tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
            }
        }

        /* 版本2 */
        /* while (low < high) {
            while (low < high && arr[high] > base) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] < base) low++;
            arr[high] = arr[low];
        } */
        // 交换base与arr[low]的值
        int tmp = arr[low];
        arr[low] = base;
        base = tmp;

        QuickSort(arr, start, low - 1);
        QuickSort(arr, low + 1, end);
    }

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.printf("%d ", a);
        }
    }

    public static void swap(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{7, 4, -2, 19, 13, 6};
        int[] arr = new int[]{29, 38, 22, 45, 23, 67, 31};
        directInsertSort(arr);
        // BubbleSort(arr);
        QuickSort(arr, 0, arr.length - 1);
        printArray(arr);


    }
}
