package com.skystmm.lintcode.stack;

import com.skystmm.common.ListNode;

import java.util.ArrayDeque;

/**
 * 12. Min Stack
 * use linkedList and quene
 * @author: skystmm
 * @date: 2020/1/2 16:50
 */
public class MinStack {

    private ArrayDeque<Integer> stask;
    private ListNode head;

    public MinStack() {
        // do intialization if necessary
        this.stask = new ArrayDeque<>();
        head = new ListNode(Integer.MIN_VALUE);
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        this.stask.addLast(number);
        insertNode(number);

    }

    private void insertNode(int number) {
        //TODO 插入节点
        ListNode prev = head;
        if(head.next == null){
            ListNode cur = new ListNode(number);
            head.next = cur;
        }else{
            ListNode node = head.next;
            boolean flag = false;
            while(node != null){
                if(number < node.val){
                    ListNode cur = new ListNode(number);
                    prev.next = cur;
                    cur.next = node;
                    flag = true;
                    break;
                }else{
                    prev = node;
                    node = node.next;
                }
            }
            if(!flag){
                ListNode cur = new ListNode(number);
                prev.next = cur;
            }
        }


    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(!stask.isEmpty()){
            int item = this.stask.pollLast();
            deleteNode(item);
            return  item;
        }else{
            throw new NullPointerException();
        }
    }

    private void deleteNode(int item) {
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == item){
                prev.next = cur.next;
                break;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return head.next.val;
    }



}
