package com.skystmm.stack;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * Created by Administrator on 2018/1/17.
 */

public class DailyTemperatures {
    /**
     * O(n^2) solution
     * AC time: 332 ms beats: null
     * @param temperatures
     * @return
     */
    public int[] solution(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for(int i = 0 ;i < length -1;i++){
            int now = temperatures[i];
            boolean flag = false;
            for(int j =i+1;j<length ;j++){
                int cur = temperatures[j];
                if(cur > now){
                    res[i] = j-i;
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                res[i] = 0 ;
            }

        }
        return res;
    }

    /**
     *  O(n)
     *  OAC times:71 ms
     * @param temperatures
     * @return
     */
    public int[] solution2(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
