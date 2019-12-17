package com.skystmm.leetcode.stack;


/**
 * 224. Basic Calculator
 * @author: skystmm
 * @date: 2019/8/20 14:26
 */
public class BasicCalculator {
    /**
     * OAC 1ms
     * @param s
     * @return
     */
    public int solution(String s){
        if (s.length() == 0) {
            return 0;
        }
        s = "(" + s + ")";
        int[] pos = {0};
        return eval(s, pos);
    }

    private static int eval(String s, int[] pos) {
        int val = 0, i = pos[0], sign = 1, num = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            switch(c) {
                case '+': val = val + sign * num; num = 0; sign = 1; i++; break;
                case '-': val = val + sign * num; num = 0; sign = -1; i++; break;
                //pos 记录位置
                case '(': pos[0] = i + 1; val = val + sign * eval(s, pos); i = pos[0]; break;
                case ')': pos[0] = i + 1; return val + sign * num;
                case ' ': i++; continue;
                //计算当前数据
                default : num = num * 10 + c - '0'; i++;
            }
        }
        return val;
    }


    public static void main(String[] args) {
        System.out.println(new  BasicCalculator().solution(" 1+2 -(3 -4)+5-(7+(9-10))"));
    }
}

