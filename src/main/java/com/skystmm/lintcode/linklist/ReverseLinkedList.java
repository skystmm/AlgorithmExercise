package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 35.Reverse Linked List
 * @author: skystmm
 * @date: 2020/1/14 14:13
 */
public class ReverseLinkedList {

    /**
     * AC time:O(n) space:O(1)
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode solution(ListNode head) {
        // write your code here
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        while(head != null){
            ListNode node = head;
            head = head.next;
            node.next =  newHead.next;
            newHead.next = node;
        }
        return  newHead.next;
    }
}
