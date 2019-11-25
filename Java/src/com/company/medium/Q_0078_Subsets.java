package com.company.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q_0078_Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = new Q_0078_Subsets().subsets(nums);
        for (List<Integer> list: res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
//        backtrack(nums, res, 0, new LinkedList<>());
        recursion(nums, res, 0, new LinkedList<>());
        return res;
    }

    // normal recursion
    private void recursion(int[] nums, List<List<Integer>> res, int startIndex, List<Integer> temp) {
        res.add(temp);
        for (int i=startIndex; i<nums.length; i++) {
            List<Integer> new_line = new LinkedList<>(temp);
            new_line.add(nums[i]);
            recursion(nums, res, i+1, new_line);
        }
    }

    // backtrack
    private void backtrack(int[] nums, List<List<Integer>> res, int startIndex, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
