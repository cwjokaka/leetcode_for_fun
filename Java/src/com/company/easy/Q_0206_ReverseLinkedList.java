package com.company.easy;

import com.company.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Q_0206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ListNode newHead = new Q_0206_ReverseLinkedList().reverseList(head);
        while (newHead != null) {
            System.out.printf(" " + newHead.val);
            newHead = newHead.next;
        }
    }

    // 使用栈 时间O(2n) 空间O(n)
//    public ListNode reverseList(ListNode head) {
//        Deque<ListNode> stack = new ArrayDeque<>();
//        ListNode cur = head;
//        while (cur != null) {
//            stack.addLast(cur);
//            ListNode tmp = cur;
//            cur = cur.next;
//            tmp.next = null;
//        }
//
//        ListNode newHead = stack.removeLast();
//        cur = newHead;
//        while (!stack.isEmpty()) {
//            cur.next = stack.removeLast();
//            cur = cur.next;
//        }
//        return newHead;
//    }

    // 使用循环 时间O(n) 空间O(1)
    // 1 -> 2 -> 3 -> 4
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode tmp = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = tmp;
//        }
//        return prev;
//    }

    // 使用递归 时间O(n) 空间(n)
    // 1 -> 2 -> 3 -> 4
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
