package com.skystmm.leetcode.array;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * @author: skystmm
 * @date: 2019/7/28
 */
public class HeightChecker {
    /**
     *  AC time :1 ms O(nlogn) space: o(n)
     * @param heights
     * @return
     */
    public int solution(int[] heights) {
        int[] target = heights.clone();
        Arrays.sort(target);
        int count = 0;
        for(int i =0;i<heights.length;i++){
            if(target[i] != heights[i]){
                count++;
            }
        }
        return count;
    }
}
