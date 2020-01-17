package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 822. Reverse Order Storage
 * @author: skystmm
 * @date: 2020/1/17 13:55
 */
public class ReverseOrderStorage {
    /**
     * AC time:O(n) space O(n)
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        Deque<Integer> queue = new ArrayDeque<>();
        while(head != null){
            queue.addFirst(head.val);
            head = head.next;
        }
        return new ArrayList<>(queue);
    }
}
