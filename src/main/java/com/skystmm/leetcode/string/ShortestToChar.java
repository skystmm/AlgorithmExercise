package com.skystmm.leetcode.string;


/**
 * 821. Shortest Distance to a Character
 * @author: skystmm
 * @date: 2019/12/17 14:04
 */
public class ShortestToChar {
    /**
     * AC time:O(n),space:O(n)
     * @param S
     * @param C
     * @return
     */
    public int[] solution(String S, char C) {
        int[] res = new int[S.length()];
        //注意溢出问题
        int prev=Integer.MIN_VALUE /2;
        for(int i = 0;i<S.length();i++){
            if(C == S.charAt(i)){
                prev = i;
            }
            res[i] = i - prev;
        }
        prev = Integer.MAX_VALUE /2;
        for(int i =res.length-1;i >= 0;i--){
            if(C == S.charAt(i)){
                prev = i;
            }
            res[i] =Math.min(res[i], prev - i);

        }
        return res;
    }

}
