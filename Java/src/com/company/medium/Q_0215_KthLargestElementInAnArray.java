package com.company.medium;

import java.util.Arrays;

public class Q_0215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 10};
        System.out.println(new Q_0215_KthLargestElementInAnArray().findKthLargest(nums, 2));
    }

    // 排序 时间O(NlogN) 空间O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}
