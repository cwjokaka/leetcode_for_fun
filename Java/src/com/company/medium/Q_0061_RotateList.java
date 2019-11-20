package com.company.medium;

import com.company.common.ListNode;

import java.util.List;
import java.util.Stack;

public class Q_0061_RotateList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode res = new Q_0061_RotateList().rotateRight(list, 11);
        while (res != null) {
            System.out.printf(res.val + " ");
            res = res.next;
        }
    }

    // 利用栈来解决 时间O(n) 空间O(n)
//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        ListNode curNode = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (curNode != null) {
//            stack.push(curNode);
//            curNode = curNode.next;
//        }
//        int size = stack.size();
//        k = k % size;
//        for (int i=0; i<k; i++) {
//            ListNode node = stack.pop();
//            node.next = head;
//            head = node;
//        }
//        stack.pop().next = null;
//        return head;
//    }

    // 环形链表解决方案
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = 1;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
            size++;
        }
        // 头尾连成环形链表
        curNode.next = head;
        k = size - (k % size) - 1;
        while (k > 0) {
            head = head.next;
            k--;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }



}
