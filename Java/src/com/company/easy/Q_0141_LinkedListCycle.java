package com.company.easy;

import com.company.common.ListNode;

/**
 * 检测环形链表
 */
public class Q_0141_LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next;
        System.out.println(new Q_0141_LinkedListCycle().hasCycle(head));
    }

    // set方法, 时间O(n) 空间O(n)
//    public boolean hasCycle(ListNode head) {
//        ListNode cur = head;
//        Set<ListNode> set = new HashSet<>();
//        while (cur != null) {
//            if (set.contains(cur)) {
//                return true;
//            }
//            set.add(cur);
//            cur = cur.next;
//        }
//        return false;
//    }

    // 双指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
