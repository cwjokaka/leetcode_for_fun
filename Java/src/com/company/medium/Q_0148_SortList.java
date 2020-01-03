package com.company.medium;

import com.company.common.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Q_0148_SortList {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(0);
        h1.next.next.next = new ListNode(-1);
        ListNode sorted = new Q_0148_SortList().sortList(h1);
        while (sorted != null) {
            System.out.printf(sorted.val + " ");
            sorted = sorted.next;
        }

    }

    // 归并
    public ListNode sortList(ListNode head) {
        return splitLinked(head);
    }

    // 递归拆开链表
    private ListNode splitLinked(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 分割
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = splitLinked(head);
        ListNode right = splitLinked(mid);
        ListNode h = new ListNode(0);
        ListNode cur = h;
        // 合并
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return h.next;
    }

}
