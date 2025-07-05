package com.xxx.structural.adapter_pattern.two;

/* 被适配的类 */
public class QuickSort {
    public int[] quickSort(int[] arr, int start, int end) {
        if (start >= end) return arr;
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

        quickSort(arr, start, low - 1);
        quickSort(arr, low + 1, end);

        return arr;
    }
}
