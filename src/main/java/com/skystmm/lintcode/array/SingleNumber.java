package com.skystmm.lintcode.array;

import java.util.Arrays;

/**
 * @author: skystmm
 * @date: 2020/1/17 10:24
 */
public class SingleNumber {

    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A.length == 1){
            return A[0];
        }
        Arrays.sort(A);
        int i = 0;
        while(i<A.length){
            if(i == 0 ){
                if(A[i+1] != A[i])
                return  A[i];
            }else if(i == A.length -1 ){
                if( A[i-1] != A[i])
                return A[i];
            }else if(A[i-1] != A[i] && A[i] != A[i+1]){
                return A[i];
            }
            i++;
        }
        return -1;
    }
}
