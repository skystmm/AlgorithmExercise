package com.skystmm.leetcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 876. Middle of the Linked List
 * @author: skystmm
 * @date: 2019/10/31 10:12
 */
public class MiddleNode {

    /**
     * AC time:O(n),space O(1)
     * @param head
     * @return
     */
    public ListNode solution(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast.next == null?slow:slow.next;
    }
}
