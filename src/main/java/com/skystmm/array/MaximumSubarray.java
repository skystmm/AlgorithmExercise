package com.skystmm.array;

/**
 * 53. Maximum Subarray
 * @author: tian.shen
 * @date: 2018/12/20 22:26
 */
public class MaximumSubarray {
    /**
     * DAC O(n) time: 8ms
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int result = nums[0];
        int temp = 0;
        for(int i = 0;i<nums.length;i++){
            temp += nums[i];
            if(temp > result){
                result = temp;
            }
            if(temp < 0){
                temp = 0;
            }
        }
        return  result;
    }
}
