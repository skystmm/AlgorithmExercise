package com.skystmm.leetcode.array;

import java.util.HashSet;

/**
 * 888. Fair Candy Swap
 * Created by sky on 2018/11/28
 */
public class FairCandySwap {
    /**
     * AC time: 25 ms beats:75.55 %
     * @param A
     * @param B
     * @return
     */
    public int[] solution(int[] A, int[] B) {
        int sum_a = 0;
        int sum_b = 0;
        for (int a : A)  sum_a+=a;
        for (int b : B)  sum_b+=b;

        int t = (sum_a - sum_b) /2;
        HashSet<Integer> set  = new HashSet<>();
        for (int b : B)  set.add(b);

        for(int a: A){
            if (set.contains(a -t)){
                return new int[]{a,a-t};
            }
        }

        return null;
    }
}