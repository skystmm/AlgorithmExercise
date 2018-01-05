package com.skystmm.stack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 155. Min Stack
 * M1 AC time :112ms beats:28.21%
 * M2 AC time :107ms beats:62.67%
 * Created by Administrator on 2018/1/5.
 */
class MinStack {
    private ArrayList<Integer> stack ;
    private Integer min;
    private Integer length ;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
        length = 0;
    }

    public void push(int x) {
        stack.add(x);
        min = min > x ? x : min;
        length++;
    }

    public void pop() {
        Integer current = stack.remove(length-1);
        length--;
        /* M1
        if(length > 0 ){
            min =  Collections.min(stack);
        }else {
            min = Integer.MAX_VALUE;
        }
         */
        if(length > 0 && current.equals(min)){
            min =  Collections.min(stack);
        }else if(length == 0){
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.get(length-1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack stacks = new MinStack();
        stacks.push(512);
        stacks.push(-1024);
        stacks.push(-1024);
        stacks.push(512);
        stacks.pop();
        stacks.pop();
        stacks.pop();
        System.out.println(stacks.getMin());
    }
}