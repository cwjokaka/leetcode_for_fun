package com.company.medium;


/**
 * 螺旋矩阵II
 */
public class Q_0059_SpiralMatrix_2 {

    public static void main(String[] args) {
        int n = 10;
        int[][] res = new Q_0059_SpiralMatrix_2().generateMatrix(n);
        for (int[] row : res) {
            for (int item : row) {
                System.out.printf(item + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int allSteps = n * n + 1;
        // 当前坐标
        int posX = 0, posY = 0;
        // 当前方向
        int status = 0;
        // 各个方向的集合
        int[] vx = {1, 0, -1, 0};
        int[] vy = {0, 1, 0, -1};
        for (int i=1; i<allSteps; i++) {
            res[posY][posX] = i;
            int next_x = posX + vx[status];
            int next_y = posY + vy[status];
            // 边界检测，碰壁转变方向
            if (next_x == -1 || next_y == -1 || next_x == n || next_y == n || res[next_y][next_x] != 0) {
                status = (status + 1) % 4;
            }
            posX += vx[status];
            posY += vy[status];
        }
        return res;
    }

}
