package com.skystmm.lintcode.sort;

/**
 * 6.Merge Two Sorted Arrays
 * @author: skystmm
 * @date: 2019/12/30 17:49
 */
public class MergeTwoSortedArrays {
    /**
     * AC time:O(M+N) space:O(M+N)
     * @param A
     * @param B
     * @return
     */
    public int[] solution(int[] A, int[] B) {
        // write your code here
        int[] result = new int[A.length+B.length];
        int i=0,j=0;
        while(i<A.length&&j<B.length){
            if(A[i]<=B[j]){
                result[i+j] = A[i];
                i++;

            }else{
                result[i+j] = B[j];
                j++;

            }
        }
        while(i<A.length){
            result[i+j] = A[i];
            i++;
        }
        while(j<B.length){
            result[i+j] = B[j];
            j++;
        }
        return result;
    }



}
