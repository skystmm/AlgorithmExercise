package com.skystmm.leetcode.stack;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * @author: skystmm
 * @date: 2019/10/31 17:43
 */
public class RemoveDuplicates {
    /**
     * AC time:O(n),space:O(n)
     * @param S
     * @return
     */
    public String solution(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek().equals(c)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return  sb.toString();
    }
}
