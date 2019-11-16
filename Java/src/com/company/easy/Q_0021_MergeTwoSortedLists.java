package com.company.easy;

import com.company.common.ListNode;

public class Q_0021_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = new Q_0021_MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return res.next;
    }

}
