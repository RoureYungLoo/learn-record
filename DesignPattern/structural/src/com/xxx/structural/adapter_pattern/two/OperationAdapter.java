package com.xxx.structural.adapter_pattern.two;

/* 适配器类，别名Wrapper类 */
public class OperationAdapter implements ScoreOperation {

    private QuickSort sortObj;
    private BinarySearch searchObj;


    public OperationAdapter() {
        this.sortObj = new QuickSort();
        this.searchObj = new BinarySearch();
    }


    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array,key);
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array,0,array.length-1);
    }
}
