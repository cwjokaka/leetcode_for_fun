package com.company.medium;

import java.util.LinkedList;
import java.util.Queue;

// 求岛屿数量, 1为岛屿 0为海
public class Q_0200_NumberOfIslands {

    private final static char[][][] MAPS = {
            // 答案: 3
            {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            },
            // 答案: 1
            {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'},
            }
    };

    public static void main(String[] args) {
        for (int i=0; i<MAPS.length; i++) {
            System.out.println("-------------------------地图:" + i + "-------------------------");
//            System.out.println(solution_dfs(MAPS[i]));
            System.out.println(solution_bfs(MAPS[i]));
        }
    }

    // 深度优先解 时间O(row*col) 空间O(row*col)
    private static int solution_dfs(char[][] map) {
        int islandCount = 0;
        for (int row=0; row<map.length; row++) {
            for (int col=0; col<map[0].length; col++) {
                if (map[row][col] == '1') {
                    islandCount++;
                    dfs(map, row, col);
                }
            }
        }
        return islandCount;
    }

    private static void dfs(char[][] map, int row, int col) {
        // 判断是否超出地图边界或已到达海洋
        if (isUnreachable(map, row, col)) {
            return;
        }
        map[row][col] = '0';
        dfs(map, row-1, col);
        dfs(map, row+1, col);
        dfs(map, row, col-1);
        dfs(map, row, col+1);
    }

    // 广度优先解 时间O(row*col) O(row*col)-最坏情况: 格子均为陆地, 全部加入队列
    private static int solution_bfs(char[][] map) {
        int islandCount = 0;
        for (int row=0; row<map.length; row++) {
            for (int col=0; col<map[0].length; col++) {
                if (map[row][col] == '1') {
                    islandCount++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, col});
                    while (!queue.isEmpty()) {
                        int[] rc = queue.remove();
                        int r = rc[0];
                        int c = rc[1];
                        search(map, r+1, c, queue);
                        search(map, r-1, c, queue);
                        search(map, r, c+1, queue);
                        search(map, r, c-1, queue);
                    }
                }
            }
        }
        return islandCount;
    }

    private static void search(char[][] map, int row, int col, Queue<int[]> queue) {
        if (isUnreachable(map, row, col)) {
            return;
        }
        queue.add(new int[]{row, col});
        map[row][col] = '0';
    }

    private static boolean isUnreachable(char[][] map, int row, int col) {
        return row == -1 || row == map.length || col == -1 || col == map[0].length || map[row][col] == '0';
    }

}
