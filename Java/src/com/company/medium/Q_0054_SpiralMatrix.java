package com.company.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Q_0054_SpiralMatrix {

    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> res = new Q_0054_SpiralMatrix().spiralOrder(test);
        for (int num : res) {
            System.out.printf(num + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        // 矩阵行列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 记录走过的格子
        boolean[][] memo = new boolean[rows][cols];
        // 计算总共要走的步数
        int allSteps = rows * cols;
        // 当前坐标
        int posX = 0, posY = 0;
        // 当前方向
        int status = 0;
        // 各个方向的集合
        int[] vx = {1, 0, -1, 0};
        int[] vy = {0, 1, 0, -1};
        for (int i=0; i<allSteps; i++) {
            res.add(matrix[posY][posX]);
            memo[posY][posX] = true;
            int next_x = posX + vx[status];
            int next_y = posY + vy[status];
            // 边界检测，碰壁转变方向
            if (next_x == -1 || next_y == -1 || next_x == cols || next_y == rows || memo[next_y][next_x]) {
                status = (status + 1) % 4;
            }
            posX += vx[status];
            posY += vy[status];
        }
        return res;
    }

}
