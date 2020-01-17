package com.skystmm.lintcode.sort;

/**
 * 463. Sort Integers
 * @author: skystmm
 * @date: 2020/1/17 11:41
 */
public class SortIntegers {
    /**
     * AC use bubble sort
     * @param A
     */
    public void sortIntegers(int[] A) {
        // write your code here
        boolean flag = false;
        for(int i =0;i<A.length;i++){
            if(flag){
                return;
            }
            flag =true;
            for(int j=i+1;j<A.length;j++){
                if(A[i] > A[j]){
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    flag= false;
                }
            }
        }
    }


}
