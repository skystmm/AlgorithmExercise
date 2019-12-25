package com.skystmm.leetcode.array;

/**
 * 1295. Find Numbers with Even Number of Digits
 * @author: skystmm
 * @date: 2019/12/25 18:58
 */
public class FindNumbers {
    /**
     * AC time:O(N*M) space: O(1)
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int count = 0;
        for(int num: nums){
            int digit = 0;
            while(num >0){
                num /=10;
                digit++;
            }
            if(digit%2 == 0){
                count++;
            }
        }
        return  count;

    }
}
