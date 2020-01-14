package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 36. Reverse Linked List II
 * @author: skystmm
 * @date: 2020/1/14 14:22
 */
public class ReverseBetween {


    /**
     * AC time:O(n) space:O(1)
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(m==n){
            return head;
        }
        ListNode result =  new ListNode(Integer.MIN_VALUE);
        result.next = head;
        ListNode start = null;
        ListNode prev = null;
        ListNode end = null;
        if(m == 1){
            prev = result;
        }
        int count = 1;
        while(head != null){
            if(count >m && count <=n){
                ListNode node = head;
                head =head.next;
                node.next = prev.next;
                prev.next = node;
                count++;
                continue;
            }
            if(count == m){
                start = head;
            }
            if(count == m - 1){
                prev = head;
            }
            if(count == n+1){
                end = head;
                start.next = end;
            }
            head = head.next;
            count ++;
        }
        if(end == null){
            start.next = end;
        }
        return result.next;
    }

}
