package com.skystmm.lintcode.stack;

import java.util.Stack;

/**
 * 40. Implement Queue by Two Stacks
 * @author: skystmm
 * @date: 2020/2/1
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        // do intialization if necessary
        in = new Stack<>();
        out = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
       in.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(out.empty()){
            while (!in.empty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(out.empty()){
            while (!in.empty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
}
