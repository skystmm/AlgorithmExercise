package com.skystmm.leetcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * @author: skystmm
 * @date: 2019/12/25 19:06
 */
public class GetDecimalValue {
    /**
     * AC time: O(n) ,space O(1)
     * @param head
     * @return
     */
    public int solution(ListNode head) {
        int result =0;
        while(head != null){
            result = (result<<1) + head.val;
            head = head.next;
        }
        return result;
    }
}
