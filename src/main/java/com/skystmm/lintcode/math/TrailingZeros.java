package com.skystmm.lintcode.math;

/**
 * 2. Trailing Zeros
 * @author: skystmm
 * @date: 2019/12/17 11:28
 */
public class TrailingZeros {

    /**
     * AC time: O(logN),space O(1)
     * @param n
     * @return
     */
    public long solution(long n) {
        long count =0;
        while(n > 0){
           count += n/5;
           n/=5;
        }
        return  count;
    }

}
