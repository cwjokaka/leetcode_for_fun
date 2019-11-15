package com.company.medium;

/**
 * 盛最多水的容器
 */
public class Q_0011_ContainerWithMostWater {
    public static void main(String[] args) {
        int[][] tests = {
            {1,8,6,2,5,4,8,3,7}
        };
        for (int[] arr : tests) {
            System.out.println(new Q_0011_ContainerWithMostWater().maxArea(arr));
        }
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(calArea(height, left, right), maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private int calArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }

}
