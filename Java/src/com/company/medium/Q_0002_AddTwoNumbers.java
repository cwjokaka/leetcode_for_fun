package com.company.medium;

import com.company.common.ListNode;

/**
 * 使用链表相加两数
 */
public class Q_0002_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1n3 = new ListNode(3);
        ListNode l1n2 = new ListNode(4, l1n3);
        ListNode l1 = new ListNode(2, l1n2);

        ListNode l2n3 = new ListNode(4);
        ListNode l2n2 = new ListNode(6, l2n3);
        ListNode l2 = new ListNode(5, l2n2);
        ListNode ln = new Q_0002_AddTwoNumbers().addTwoNumbers(l1, l2);
        while (ln != null){
            System.out.printf(ln.val + ",");
            ln = ln.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode la = l1, lb = l2, dummyNode = new ListNode(0), curNode = dummyNode;
        int carry = 0;
        while (la != null || lb != null || carry == 1) {
            int x = la != null ? la.val : 0;
            int y = lb != null ? lb.val : 0;
            int sum = carry + x + y;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            curNode.next = new ListNode(sum);
            curNode = curNode.next;
            la = la != null ? la.next : null;
            lb = lb != null ? lb.next : null;
        }
        return dummyNode.next;
    }

}
