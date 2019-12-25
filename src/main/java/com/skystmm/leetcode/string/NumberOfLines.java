package com.skystmm.leetcode.string;

/**
 * 806. Number of Lines To Write String
 * @author: skystmm
 * @date: 2019/12/25 14:52
 */
public class NumberOfLines {

    /**
     * AC time:O(n),space: O(1)
     * @param widths
     * @param S
     * @return
     */
    public int[] solution(int[] widths, String S) {
        int [] result = new int[2];
        int line = 1;
        int index = 0;
        for(int i =0;i<S.length();i++){
           int tIndex =  S.charAt(i) - 'a';
           int cur = index + widths[tIndex];
           if(cur > 100){
               index = widths[tIndex];
               line ++;
           }else if(cur == 100){
               index = 0;
               line++;
           }else{
               index = cur;
           }
        }
        result[0] = line;
        result[1] = index;
        return result;
    }
}
