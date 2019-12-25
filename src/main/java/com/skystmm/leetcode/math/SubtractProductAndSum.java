package com.skystmm.leetcode.math;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * @author: skystmm
 * @date: 2019/12/25 19:02
 */
public class SubtractProductAndSum {
    /**
     * AC time O(n) space :O(1)
     * @param n
     * @return
     */
    public int solution(int n) {
        int plus= 0;
        int mul = 1;
        while(n > 0){
            int cur = n%10;
            plus += cur;
            mul *= cur;
            n /=10;
        }
        return  mul-plus;
    }
}
