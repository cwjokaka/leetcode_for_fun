package com.company.hard;

import com.company.common.ListNode;

/**
 * 合并K个有序的链表
 */
public class Q_0023_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = new Q_0023_MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2});
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int count = lists.length;
        if (count == 0) {
            return null;
        }
        int interval = 1;
        while (count > interval) {
            for (int i=0; i<count-interval; i+=interval*2) {
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return res.next;
    }


}
