package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 1661. Delete the nth to mth nodes in the linked list
 * @author: skystmm
 * @date: 2020/1/17 14:02
 */
public class DeleteNode {
    /**
     * AC time :O(n) space :O(1)
     * @param head
     * @param n
     * @param m
     * @return
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        // Write your code here
        int count = 0;
        ListNode cur = head;
        ListNode prev = null;
        ListNode tail = null;
        while(cur != null){
            if(count == n -1){
                prev = cur;
            }
            if(count == m+1){
                tail = cur;
            }
            count++;
            cur = cur.next;
        }

        if(prev == null){
            if(tail != null){
                return  tail;
            }
            if(count > n){
                return  prev;
            }else{
                return  head;
            }
        }else if(tail == null){
            prev.next = null;
            return  head;
        }else{
            prev.next = tail;
            return head;
        }
    }
}
