package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 228. Middle of Linked List
 * @author: skystmm
 * @date: 2020/1/17 13:50
 */
public class MiddleNode {

    /**
     * AC time:O(n) space :O(1)
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null)
                slow = slow.next;
        }
        return  slow;
    }
}
