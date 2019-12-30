package com.company.hard;

import com.company.common.TreeNode;

/**
 * 二叉树中的最大路径和
 */
public class Q_0124_BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;
    /**
     *           -1
     *          /   \
     *        -3     1
     *       /      / \
     *      4      4  -3
     *
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-3);
        System.out.println(new Q_0124_BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 以左子节点为根节点的所有节点之和
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        // 以当前节点为根节点的所有节点之和
        int root = left + right + node.val;
        maxSum = Math.max(maxSum, root);
        return Math.max(left, right) + node.val;
    }


}
