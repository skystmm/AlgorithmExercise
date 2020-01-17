package com.skystmm.lintcode.linklist;

import com.skystmm.common.ListNode;

/**
 * @author: skystmm
 * @date: 2020/1/17 14:00
 */
public class CountLinkedListNodes {

    public int countNodes(ListNode head) {
        // write your code here
        int count = 0;
        while(head != null){
            head = head.next;
            count+=1;
        }
        return  count;
    }
}
