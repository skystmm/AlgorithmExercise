package com.skystmm.array;

import java.util.Arrays;

/**
 * 976. Largest Perimeter Triangle
 * Created by sky on 2019/1/23
 */
public class LargestPerimeter {
    /**
     * AC O(NlogN) time:14 ms
     * @param A
     * @return
     */
    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--) {
            if(A[i] < A[i-1] + A[i-2]) return A[i] + A[i-1] + A[i-2];
        }
        return 0;
    }
}
