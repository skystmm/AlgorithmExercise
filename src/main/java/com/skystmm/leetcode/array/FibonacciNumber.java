package com.skystmm.leetcode.array;

/**
 * 509. Fibonacci Number
 * Created by sky on 2019/1/14
 */
public class FibonacciNumber {
    /**
     * AC recursion time:16ms
     * @param N
     * @return
     */
    public int solution(int N) {
        if (N <= 2) {
            return N;
        }
        return solution(N-1) + solution(N-2);
    }
}
