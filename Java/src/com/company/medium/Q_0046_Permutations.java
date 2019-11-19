package com.company.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 列出数组的全部排列情况
 * 前提:
 *      数组没有重复的数字
 */
public class Q_0046_Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Q_0046_Permutations().permute(nums);
        for (List<Integer> list : permute) {
            for (int i : list) {
                System.out.printf(i+",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // 用于保存输出的结果
        List<List<Integer>> output = new LinkedList<>();

        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }


    /**
     * 回溯法
     * @param n 原始输入数组的长度
     * @param nums 输入数组
     * @param output 用于保存已知的解
     * @param first 当前即将要用来替换的下标，在此值之前的所有下标已被确定下来
     */
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            // backtrack回退
            Collections.swap(nums, first, i);
        }
    }


}
