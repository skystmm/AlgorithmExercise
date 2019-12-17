package com.skystmm.leetcode.array;

/**
 * 852. Peak Index in a Mountain Array
 * @author: skystmm
 * @date: 2019/10/22 19:27
 */
public class PeakIndexInMountainArray {

    /**
     * AC, time:O(n) space:O(1)
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int length  = A.length;
        for(int i = 1 ; i<= length -2;i++){
            if(A[i-1] < A[i] && A[i] > A[i+1]){
                return i;
            }
        }
        return -1;
    }


}
