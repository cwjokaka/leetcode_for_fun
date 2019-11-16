package com.company.medium;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Q_0016_ThreeSumClosest {

    public static void main(String[] args) {
        int[] tests = {-1, 2, 1, -4};
        System.out.println(new Q_0016_ThreeSumClosest().threeSumClosest(tests, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int slow = i+1, fast = nums.length-1;
            while (slow < fast) {
                int sum = nums[i] + nums[slow] + nums[fast];
                int distance = Math.abs(target - sum);
                if (minDistance > distance) {
                    minDistance = distance;
                    res = sum;
                }
                if (sum < target) {
                    slow++;
                } else if (sum > target) {
                    fast--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }


}
