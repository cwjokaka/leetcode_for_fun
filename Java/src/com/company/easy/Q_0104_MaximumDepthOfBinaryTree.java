package com.company.easy;

import com.company.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q_0104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(7);
        System.out.println(new Q_0104_MaximumDepthOfBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
//        return dfs(root);
        return bfs(root);
    }

    /**
     * 深度优先
     * time O(N)
     * space 最差(每个节点只有左节点)O(N) 最好(平衡二叉树) O(logN)
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 广度优先(抄的)
     * time O(N)
     * space O(N)
     */
    public int bfs(TreeNode node) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (node != null) {
            queue.add(new Pair(node, 1));
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            // 弹出队首元素
            Pair<TreeNode, Integer> current = queue.poll();
            node = current.getKey();
            int current_depth = current.getValue();
            if (node != null) {
                depth = Math.max(depth, current_depth);
                queue.add(new Pair(node.left, current_depth + 1));
                queue.add(new Pair(node.right, current_depth + 1));
            }
        }
        return depth;
    }
}
