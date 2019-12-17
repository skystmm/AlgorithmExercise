package com.skystmm.leetcode.linklist;

import com.skystmm.common.ListNode;

/**
 * 725. Split Linked List in Parts
 * @author: skystmm
 * @date: 2019/10/31 11:36
 */
public class SplitListToParts {
    /**
     * AC time: O(n), space:O(1)
     * @param root
     * @param k
     * @return
     */
    public ListNode[] solution(ListNode root, int k) {
        ListNode[] result = new  ListNode[k];
        Integer length  = 0;
        ListNode cur = root;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        if(length <= k){
            cur = root;
            int i = 0;
            while(i < length){
                ListNode tmp = cur;
                result[i] = tmp;
                cur = cur.next;
                tmp.next = null;
                i++;
            }
            return result;
        }
        Integer count = length / k;
        Integer upCount = length % k ;
        int i = 0;
        cur = root;
        while(i < k){
            int j = 0;
            ListNode head = cur;
            ListNode tail = cur;
            while(j< count){
                tail = cur;
                cur = cur.next;
                j++;
            }
            if(i < upCount){
                tail =cur;
                cur = cur.next;
            }
            tail.next = null;
            result[i] = head;
            i++;
        }

        return  result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        new SplitListToParts().solution(node ,2 );
    }
}
