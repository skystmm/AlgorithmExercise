package com.skystmm.leetcode.array;

/**
 * 896. Monotonic Array
 * Created by sky on 2018/11/26
 */
public class MonotonicArray {
    /**
     * AC  time :12 ms  beats:96.55 %
     * @param A
     * @return
     */
    public boolean solution(int[] A) {
        int target = 0 ;
        int length = A.length;
        for(int i =0;i< length -1 ; i++){
            if(target == 0){
                target = Integer.compare(A[i],A[i+1]);
                continue;
            }
            if(target > 0){
                 if(A[i] < A[i+1]){
                     return false;
                 }
            }
            if (target < 0){
                if(A[i] >A[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
