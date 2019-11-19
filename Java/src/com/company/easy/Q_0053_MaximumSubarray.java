package com.company.easy;

/**
 * 最大子序列之和
 */
public class Q_0053_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // answer: 6 (4,-1,2,1)
        System.out.println(new Q_0053_MaximumSubarray().maxSubArray(nums));
    }

//    public int maxSubArray(int[] nums) {
//        int sum = Integer.MIN_VALUE;
//        int res = nums[0];
//        for (int i=0; i<nums.length; i++) {
//            if (sum < 0) {
//                sum = nums[i];
//            } else {
//                sum += nums[i];
//            }
//            res = Math.max(res, sum);
//        }
//        return res;
//    }


    public int maxSubArray(int[] nums) {
        // memo代表以i为结尾的最大子序列之和
//        int[] memo = new int[nums.length];
        int memo = nums[0];
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            memo = Math.max(memo + nums[i], nums[i]);
            res = Math.max(res, memo);
        }
        return res;
    }

}
