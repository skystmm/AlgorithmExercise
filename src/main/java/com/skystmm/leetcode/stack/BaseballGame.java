package com.skystmm.leetcode.stack;

import java.util.*;

/**
 * 682. Baseball Game
 * Created by Administrator on 2017/12/21.
 */

public class BaseballGame {
    /**
     * AC time: 9 ms,beats:71.57 %
     * @param ops
     * @return
     */
    public static int solutionV1(String[] ops) {
        List<Integer> stack = new ArrayList<Integer>();
        for(String s : ops){
            if(s.equals("D")){
                stack.add(stack.get(stack.size()-1)*2);
            }else if(s.equals("C")){
                stack.remove(stack.size()-1);
            }else if ("+".equals(s)){
                Integer a1 = stack.get(stack.size()-1);
                Integer a2 = stack.get(stack.size()-2);
                stack.add(a1+a2);
            }else{
                stack.add(Integer.valueOf(s));
            }
        }
        int result = 0;
        for(Integer n : stack){
            result+= n;
        }
        return result ;
    }

    public static void main(String[] args) {
        solutionV1(new String[]{"5","-2","4","C","D","9","+","+"});
    }
}
