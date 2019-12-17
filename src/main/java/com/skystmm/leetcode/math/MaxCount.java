package com.skystmm.leetcode.math;

/**
 * 598. Range Addition II
 * @author: skystmm
 * @date: 2019/12/17 13:53
 */
public class MaxCount {
    /**
     * AC time:O(n) ,space:O(1)
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int solution(int m, int n, int[][] ops) {
        int i = m,j=n;
        for(int[] a : ops){
            if(a[0] < i){
                i = a[0];
            }
            if(a[1] < j){
                j = a[1];
            }
        }
        return i*j;
    }

}
