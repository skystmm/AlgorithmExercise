package com.skystmm.array;

/**
 * 674. Longest Continuous Increasing Subsequence
 * @author: tian.shen
 * @date: 2018/12/20 21:59
 */
public class LongestContinuousIncreasingSubsequence {
    /**
     * AC O(n) time : 4ms
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        int result = 1;
        int cur = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i - 1] < nums[i]){
                cur+=1;
            }else{
                if(cur > result){
                    result = cur;
                }
                cur = 1;
            }
        }

        return cur > result ? cur : result;
    }
}
