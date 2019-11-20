package com.company.medium;

public class Q_0062_UniquePaths {

    public static void main(String[] args) {

        System.out.println(new Q_0062_UniquePaths().uniquePaths(5, 5));

    }

    // 回溯法(超时了 /(ㄒoㄒ)/~~)
//    public int uniquePaths(int m, int n) {
//        return backtrack(m-1, n-1, 0, 0);
//    }
//    private int backtrack(int tarX, int tarY, int curX, int curY) {
//        int res = 0;
//        if (curX == tarX && curY == tarY) {
//            return 1;
//        }
//        if (curX < tarX) {
//            res += backtrack(tarX, tarY, curX + 1, curY);
//        }
//        if (curY < tarY) {
//            res += backtrack(tarX, tarY, curX, curY + 1);
//        }
//        return res;
//    }


    public int uniquePaths(int m, int n) {
        int[][] memo = new int[n][m];
        for (int i=0; i< m; i++) {
            memo[0][i] = 1;
        }
        for (int i=0; i< n; i++) {
            memo[i][0] = 1;
        }
        for (int y=1; y<n; y++) {
            for (int x=1; x<m; x++) {
                memo[y][x] = memo[y-1][x] + memo[y][x-1];
            }
        }
        return memo[n-1][m-1];
    }


}
