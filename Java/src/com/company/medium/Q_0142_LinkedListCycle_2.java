package com.company.medium;

import com.company.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表_2
 */
public class Q_0142_LinkedListCycle_2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next;
        System.out.println(new Q_0142_LinkedListCycle_2().detectCycle(head).val);
    }

    // 使用set 时间O(n), 空间O(n)
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
