package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 219. Insert Node in Sorted Linked List
 * @author: skystmm
 * @date: 2020/1/17 13:42
 */
public class InsertNode {

    /**
     * AC time:O(n) space:O(1)
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        if(head == null){
            return  new ListNode(val);
        }
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            if(val < cur.val){
                ListNode in = new ListNode(val);
                if(prev == null){
                    in.next = cur;
                    head = in;
                }else{
                    prev.next = in;
                    in.next = cur;
                }
                return head;
            }
            prev = cur;
            cur = cur.next;
        }
        ListNode in = new ListNode(val);
        prev.next = in;
        return  head;
    }
}
