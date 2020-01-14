package com.skystmm.lintcode.cache;


import java.util.HashMap;

/**
 * 24. LFU Cache
 * AC use LinkList
 * put time O(n)
 * get time O(n)
 * @author: skystmm
 * @date: 2020/1/6 11:12
 */
public class LFUCache {

    private HashMap<Integer, Integer> cache;

    private int capacity;

    private LFULinkNode head;

    /**
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new LFULinkNode();
    }


    /**
     * @param key:   An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
                remove();
            }
            insert(key);
        } else {
            update(key);
        }
        cache.put(key, value);
    }

    /**
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (cache.containsKey(key)) {
            update(key);
            return cache.get(key);
        }
        return -1;
    }

    private void insert(int key) {
        LFULinkNode lfuLinkNode = new LFULinkNode();
        lfuLinkNode.key = key;
        lfuLinkNode.count = 0;
        LFULinkNode prev = head;
        LFULinkNode cur = head.next;
        boolean flag = true;
        while (cur != null) {
            if (cur.count > lfuLinkNode.count) {
                prev.next = lfuLinkNode;
                lfuLinkNode.next = cur;
                flag = false;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (flag) {
            prev.next = lfuLinkNode;
        }
    }

    private void remove() {
        LFULinkNode remove = head.next;
        cache.remove(remove.key);
        if (remove != null) {
            head.next = remove.next;
        } else {
            head.next = null;
        }
    }

    private void update(int key) {
        LFULinkNode target = null;
        LFULinkNode prev = head;
        LFULinkNode cur = head.next;
        while (cur != null) {
            if (cur.key == key) {
                target = cur;
                target.count++;
                if (target.next == null) {
                    return;
                }
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        if (target != null) {
            cur = head.next;
            prev = head;
            while (cur != null) {
                if (cur.count > target.count) {
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
            target.next = prev.next;
            prev.next = target;
        }
    }

    final class LFULinkNode {
        int key;
        int count;
        LFULinkNode next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public LFULinkNode getNext() {
            return next;
        }

        public void setNext(LFULinkNode next) {
            this.next = next;
        }
    }

}