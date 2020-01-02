package com.company.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 */
public class Q_0146_LRUCache {

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        obj.put(2, 1);
        System.out.println(obj.get(2));
        obj.put(3, 2);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
//        obj.put(4, 4);
//        int param_1 = obj.get(1);

//        obj.put(key, value);
    }

}
class LRUCache {

    private int size;
    private int capacity;
    private Map<Integer, DLinkedList.DLinkedNode> cache = new HashMap<>();
    private DLinkedList dLinkedList = new DLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedList.DLinkedNode node = cache.get(key);
        dLinkedList.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedList.DLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            dLinkedList.moveToHead(node);
            return;
        }
        DLinkedList.DLinkedNode n = new DLinkedList.DLinkedNode(key, value);
        cache.put(key, n);
        dLinkedList.add(n);
        if (size >= capacity) {
            DLinkedList.DLinkedNode rem = dLinkedList.removeOld();
            cache.remove(rem.key);
//            System.out.println("移除了" + rem.val);
            return;
        }
        size++;
    }

}

class DLinkedList {

    private DLinkedNode head;
    private DLinkedNode tail;

    public DLinkedList() {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public final static class DLinkedNode {
        public DLinkedNode prev;
        public DLinkedNode next;
        public int val;
        public int key;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public DLinkedNode() {
            this.val = val;
        }
    }

    public void add(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public DLinkedNode remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public void moveToHead(DLinkedNode node) {
        remove(node);
        add(node);
    }

    public DLinkedNode removeOld() {
        DLinkedNode old = tail.prev;
        return remove(old);
    }

}
