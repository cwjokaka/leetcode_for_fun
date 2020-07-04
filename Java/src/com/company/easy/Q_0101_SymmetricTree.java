package com.company.easy;

import com.company.common.TreeNode;

public class Q_0101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        System.out.println(new Q_0101_SymmetricTree().isSymmetric(tree));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (
                (t1 == null && t2 != null)
                || (t1 != null && t2 == null)
                || (t1.val != t2.val))
        {
            return false;
        }
        return isEqual(t1.left, t2.right) && isEqual(t1.right, t2.left);
    }

}
