package com.company.easy;

import com.company.common.TreeNode;

/**
 * 比较两颗二叉树是否相等
 */
public class Q_0100_SameTree {

    public static void main(String[] args) {
        TreeNode tree_1 = new TreeNode(1);
        tree_1.left = new TreeNode(2);
        tree_1.right = new TreeNode(3);
        tree_1.left = new TreeNode(4);
        TreeNode tree_2 = new TreeNode(1);
        tree_2.left = new TreeNode(2);
        tree_2.right = new TreeNode(3);
        tree_2.left = new TreeNode(4);
        System.out.println(new Q_0100_SameTree().isSameTree(tree_1, tree_2));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return compare(p.left, q.left) && compare(p.right, q.right);
            } else {
                return false;
            }
        }
        return p == null && q == null;
    }


}
