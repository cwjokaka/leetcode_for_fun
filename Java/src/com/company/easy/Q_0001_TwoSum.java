package com.company.easy;

import java.util.HashMap;



/**
 * 两数之和
 */
public class Q_0001_TwoSum {

    public static void main(String[] args) {
        Q_0001_TwoSum twoSum = new Q_0001_TwoSum();
        int[] arr = {1,2,3,9};
        System.out.println(twoSum.twoSum(arr, 10));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int part = target - num;
            if (record.containsKey(part)) {
                return new int[]{record.get(part), i};
            } else {
                record.put(num, i);
            }
        }
        return null;
    }

}
