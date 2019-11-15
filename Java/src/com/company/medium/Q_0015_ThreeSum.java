package com.company.medium;

import java.util.*;

/**
 * 三数之和
 */
public class Q_0015_ThreeSum {

    public static void main(String[] args) {
        int[][] numss = {
                {0, 0, 0},
                {-1, 0, 1, 2, -1, -4},
//                {-4, 2, 2}
        };
        for (int[] nums : numss) {
            List<List<Integer>> res = new Q_0015_ThreeSum().threeSum(nums);
            for (List<Integer> list : res){
                StringBuilder sb = new StringBuilder("[");
                for (int num : list){
                    sb.append(num).append(" ");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int slow = 0;
        while (slow < nums.length-2) {
            int fast = slow+1, last = nums.length-1;
            while (fast < last) {
                int target = -nums[slow];
                int numF = nums[fast];
                int numL = nums[last];
                if (numF + numL == target) {
                    // 添加返回记录
                    res.add(Arrays.asList(nums[slow], numF, numL));
                    while (fast < last && nums[fast] == nums[fast+1]) fast++;
                    while (fast < last && nums[last] == nums[last-1]) last--;
                    fast++;
                    last--;
                } else if (numF + numL < target) {
                    while (fast < last && nums[fast] == nums[fast+1]) fast++;
                    fast++;
                } else {
                    while (fast < last && nums[last] == nums[last-1]) last--;
                    last--;
                }
            }
            while (slow < nums.length-1 && nums[slow] == nums[slow+1]) slow++;
            slow++;
        }
        return res;
    }

}
