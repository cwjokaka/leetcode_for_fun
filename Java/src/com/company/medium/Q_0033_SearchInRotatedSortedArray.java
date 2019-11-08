package com.company.medium;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 * 搜索旋转排序数组, 要求时间复杂度O(log n) 二分法
 * 大致思路:
 *      先用二分法来找到数组有序的部分，再用二分法搜索目标值下标
 */
public class Q_0033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Q_0033_SearchInRotatedSortedArray q = new Q_0033_SearchInRotatedSortedArray();
//        int[] arr = {4,5,6,7,0,1,2};
        int[] arr = {1,3,5};
        int index = q.search(arr, 3);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return innerSearch(nums, 0, nums.length-1, target);
    }

    private int innerSearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (target == nums[end]) {
                return end;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        // 如果数列在区间[start, mid]有序且target在其范围内,则直接执行二分搜索
        if (nums[start] < nums[mid] && target >= nums[start] && target <= nums[mid]) {
            return binarySearch(nums, start, mid, target);
        }
        int res = innerSearch(nums, start, mid, target);
        if (res != -1) {
            return res;
        }
        return innerSearch(nums, mid+1, end, target);
    }


    private int binarySearch(int[] nums, int from, int to, int target) {
        if (from == to) {
            if (target == nums[from]) {
                return from;
            }
            return -1;
        }
        int mid = (from + to) / 2;
        if (target >= nums[from] && target <= nums[mid]){
            return binarySearch(nums, from, mid, target);
        } else {
            return binarySearch(nums, mid+1, to, target);
        }
    }

}
