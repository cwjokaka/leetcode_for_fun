package com.company.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 */
public class Q_0136_SingleNumber {

    public static void main(String[] args) {
        System.out.println(new Q_0136_SingleNumber().singleNumber(new int[]{2, 2, 1, 3, 3}));
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i=0; i<nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

}
