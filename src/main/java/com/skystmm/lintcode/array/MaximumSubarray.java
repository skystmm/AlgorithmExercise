package com.skystmm.lintcode.array;

/**
 * 41. Maximum Subarray
 * @author: skystmm
 * @date: 2020/2/2
 */
public class MaximumSubarray {

    /**
     * OAC time：O(n) space :O(1)
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int sum = nums[0];
        int max = sum;
        for(int i=1; i<nums.length; i++) {
            int temp = sum + nums[i];
            sum = sum>0&&temp>0 ? temp:nums[i];
            max = sum>max ? sum:max;
        }
        return max;
    }
}
