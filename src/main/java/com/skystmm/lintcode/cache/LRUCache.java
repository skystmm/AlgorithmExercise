package com.skystmm.lintcode.cache;


import java.util.HashMap;
import java.util.Map;

/**
 * 134. LRU Cache
 * AC put time:O(1)
 *    get time:O(1)
 * @author: skystmm
 * @date: 2020/1/8 20:41
 */
public class LRUCache {

    private int capacity;

    private Map<Integer ,DLinkNode> cache;

    private DLinkNode head;
    
    private DLinkNode tail;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        if(capacity < 1){
            throw new IllegalArgumentException("capacity should be gather than 0");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkNode();
        this.tail = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(cache.containsKey(key)){
            DLinkNode cur = cache.get(key);
            update(cur);
            return  cur.value;
        }
        return -1;
    }

    private void update(DLinkNode dLinkNode) {
        if(dLinkNode != tail){
            DLinkNode p = dLinkNode.prev;
            DLinkNode n = dLinkNode.next;
            p.next = n;
            n.prev = p;

            tail.next = dLinkNode;
            dLinkNode.prev = tail ;
            dLinkNode.next =null;
            tail = dLinkNode;
        }

    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(cache.containsKey(key)){
            DLinkNode cur = cache.get(key);
            cur.value = value;
            update(cur);
        }else{
            if(capacity == cache.size()){
                DLinkNode remove = head.next;
                cache.remove(remove.key);
                head.next = remove.next;
                if(remove.next != null){
                    remove.next.prev = head;
                }

            }
            insert(key,value);
        }
    }

    private void insert(int key, int value) {
        DLinkNode newNode = new DLinkNode();
        newNode.key = key;
        newNode.value = value;

        cache.put(key, newNode);

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    final class DLinkNode{
        private int key;
        private int value;
        private DLinkNode prev;
        private DLinkNode next;
    }



}
