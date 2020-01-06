package com.company.easy;

import com.company.common.ListNode;

/**
 * 相交链表
 */
public class Q_0160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(5);
        headA.next.next = new ListNode(5);
        ListNode common = new ListNode(-111);
        common.next = new ListNode(-222);
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(5);
        headB.next.next = common;
        headA.next.next.next = common;
        System.out.println(new Q_0160_IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 4
        // 5 -> 3 -> 4 -> 1 -> 2 -> 3 -> 4
        ListNode curA = headA;
        ListNode curB = headB;
        boolean isAChanged = false;
        boolean isBChanged = false;
        while (true) {
            if (curA == null) {
                curA = headB;
                isAChanged = true;
            }
            if (curB == null) {
                curB = headA;
                isBChanged = true;
            }
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
            if (curA == null && isAChanged) {
                break;
            }
            if (curB == null && isBChanged) {
                break;
            }
        }
        return null;
    }

}
