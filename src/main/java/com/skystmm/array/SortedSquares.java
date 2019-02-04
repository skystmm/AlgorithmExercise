package com.skystmm.array;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Created by sky on 2019/1/23
 */
public class SortedSquares {
    /**
     * AC use steam time:51ms
     * AC time: 11 ms
     * @param A
     * @return
     */
    public int[] solution(int[] A) {
        for(int i =0; i <A.length; i++){
            A[i] *=A[i];
        }
        Arrays.sort(A);
        //return Arrays.stream(A).sorted().toArray();
        return A;
    }
}
