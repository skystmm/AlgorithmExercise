package com.skystmm.array;

/**
 * 941. Valid Mountain Array
 * @author: skystmm
 * @date: 2019/2/4 16:31
 */
public class ValidMountainArray {
    /**
     * AC  O(n) time :5 ms, space: O(1)
     * @param A
     * @return
     */
    public boolean soluton(int[] A) {
        int index =-1;
        for(int i =1 ; i < A.length;i++){
            if(A[i-1] == A[i]){
                return  false;
            }
            if(index == -1){
                if(A[i-1] > A[i]){
                    index = i-1;
                }
            }else{
                if(A[i-1] <= A[i]){
                    return  false;
                }
            }
        }
        return index>0;
    }

}
