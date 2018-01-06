package com.skystmm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 232. Implement Queue using Stacks
 * AC time :106 ms beats: 18.85 %
 * Created by Administrator on 2018/1/6.
 */

public class MyQueue {
    private List<Integer> stack ;
    private List<Integer> tmp;
    private Integer length;
    private Integer front;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new ArrayList<Integer>();
        tmp = new ArrayList<Integer>();
        length = stack.size();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(length == 0){
            front = x;
        }
        stack.add(x);
        length += 1;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer pop = stack.get(0);
        for(int i=1;i<length;i++){
            tmp.add(stack.get(i));
        }
        stack.clear();
        length = 0;
        for(Integer t:tmp){
            push(t);
        }
        tmp.clear();
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
   /* best time solution
    Stack<Integer> input=new Stack<>();
    Stack<Integer> output=new Stack<>();


    public void push(int x) {
        input.push(x);
    }


    public int pop() {
        peek();
        return output.pop();
    }


    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }


    public boolean empty() {
        return input.empty() && output.empty();
    }*/
}
