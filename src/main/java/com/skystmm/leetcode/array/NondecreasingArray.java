package com.skystmm.leetcode.array;

/**
 * 665. Non-decreasing Array
 * @author: skystmm
 * @date: 2018/12/23 20:47
 */
public class NondecreasingArray {
    /**
     * AC O(n) time: 15ms space: O(1)
     * @param nums
     * @return
     */
    public boolean solution(int[] nums) {
        int index  = -1;
        int i = 0;
        while(i < nums.length - 1){
            if(nums[i] > nums[i+1]){
                if(index != -1){
                    return false;
                }
                index = i;
            }
            i++;
        }
        return index == -1 || index == nums.length -2 || index == 0 || nums[index -1] <= nums[index+1] || nums[index] <= nums[index+2];
    }

}
