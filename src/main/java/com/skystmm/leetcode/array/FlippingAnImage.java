package com.skystmm.leetcode.array;

import java.util.Arrays;

/**
 * 832.Flipping an Image
 * Created by sky on 2018/7/22.
 */
public class FlippingAnImage {
    /**
     * AC use stream times: 48 ms
     * @param A
     * @return
     */
    public int[][] solution(int[][] A) {
        Arrays.stream(A).forEach(item->{
            int len = item.length;
            int start = 0 ;
            int end = len-1;
            while(start <= end){
                int tmp = item[start] ^ 1;
                item[start] = item[end] ^1;
                item[end] = tmp;
                start++;
                end--;
            }
        });
        return A;
    }

    /**
     * AC C-Style times: 5 ms
     * @param A
     * @return
     */
    public int[][] solution2(int[][] A){
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

}
