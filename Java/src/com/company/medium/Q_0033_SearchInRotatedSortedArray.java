package com.company.medium;

/**
 * 搜索旋转排序数组, 要求时间复杂度O(log n) 二分法
 */
public class Q_0033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Q_0033_SearchInRotatedSortedArray q = new Q_0033_SearchInRotatedSortedArray();
        int[] arr = {4,5,6,7,0,1,2};
        int index = q.search(arr, 0);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        int mid = nums.length / 2;
        int start = 0;
        // 条件成立则代表区间数列在[start, mid]有序
        if (nums[start] < nums[mid]) {
            if (target >= nums[start] && target <= nums[mid]) {
                // 直接用二分查找
            } else {

            }

        } else {

        }
        return -1;
    }

    private int binarySearch(int[] nums, int from, int to, int target) {
        while ()
    }

}
