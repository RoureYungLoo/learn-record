package com.xxx.structural.adapter_pattern.two;

/* 被适配的类 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0,
                right = nums.length - 1,
                mid = (left + right) / 2,
                res = -1;
        while (mid != left && mid != right) {
            if (nums[mid] > target) {
                right = mid;
                mid = (left + right) / 2;
            }
            if (nums[mid] < target) {
                left = mid;
                mid = (left + right) / 2;
            }
            if (nums[mid] == target) {
                res = mid;
                break;
            }
        }
        if (nums[left] == target)
            res = left;
        if (nums[right] == target)
            res = right;

        return res;
    }
}
