package com.company.easy;

public class Q_0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(new Q_0026_RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 1, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 1;
        while (fast < len) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow + 1;
    }


}
