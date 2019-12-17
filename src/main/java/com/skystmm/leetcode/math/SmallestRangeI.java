package com.skystmm.leetcode.math;


/**
 * 908. Smallest Range I
 * @author: skystmm
 * @date: 2019/12/17 11:54
 */
public class SmallestRangeI {
    /**
     * AC time: O(n),space: O(1)
     * @param A
     * @param K
     * @return
     */
    public int solution(int[] A, int K) {
        if(A.length < 2){
            return  0;
        }
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i =0;i< A.length ; i++){
            int cur = A[i];
            if(cur < min){
                min = cur;
            }
            if(cur > max){
                max = cur;
            }
        }
         int result = max - min - 2* K;
        return result <0 ? 0:result;
    }

}
