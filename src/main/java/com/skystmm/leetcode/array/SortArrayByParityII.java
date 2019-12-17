package com.skystmm.leetcode.array;

/**
 * 922. Sort Array By Parity II
 * Created by sky on 2018/11/24
 */
public class SortArrayByParityII {
    /**
     * AC : 7ms beats: 69.09%
     * @param A
     * @return
     */
    public int[] solution(int[] A) {
        int oddIndex = 0;
        int evenIndex = 1;
        int length = A.length;
        while(oddIndex <length && evenIndex<length){
            int odd = A[oddIndex];
            int event = A[evenIndex];
            boolean eventCheck  = (event >>1 )<<1 != event;
            boolean odoCheck = (odd >>1)<<1== odd;
            if(eventCheck){
                evenIndex +=2;
            }
            if(odoCheck){
                oddIndex +=2;
            }
            if (!odoCheck && !eventCheck ){
                A[oddIndex] = event;
                A[evenIndex] = odd;
                oddIndex +=2;
                evenIndex +=2;
            }
        }
        return A;
    }
}
