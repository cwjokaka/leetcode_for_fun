package com.company.easy;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    // 递归方式
//    public boolean isEqual(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) {
//            return true;
//        }
//        if (
//                (t1 == null && t2 != null)
//                || (t1 != null && t2 == null)
//                || (t1.val != t2.val))
//        {
//            return false;
//        }
//        return isEqual(t1.left, t2.right) && isEqual(t1.right, t2.left);
//    }

    // 队列方式
    public boolean isEqual(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


}
