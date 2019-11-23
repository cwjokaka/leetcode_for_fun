package com.company.easy;

/**
 * 爬楼梯
 */
public class Q_0070_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new Q_0070_ClimbingStairs().climbStairs(4));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i=2; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

}
