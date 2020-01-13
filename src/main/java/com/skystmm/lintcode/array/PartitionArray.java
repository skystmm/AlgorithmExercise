package com.skystmm.lintcode.array;

/**
 * 31. Partition Array
 * @author: skystmm
 * @date: 2020/1/13
 */
public class PartitionArray {
    /**
     * AC time:O(n) space: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int solution(int[] nums, int k) {
        // write your code here
        int res = 0;
        for(int i = 0;i<nums.length; i++){
            if(nums[i] < k){
                res ++;
            }
        }
        return  res;

    }

    /**
     * AC time:O(n/2),space O(1)
     * @param nums
     * @param k
     * @return
     */
    public int solutionV2(int[] nums, int k) {
        // write your code here
        int res = 0;
        int i =0,j = nums.length-1;
        while(i<j){
            if(nums[i] < k){
                res++;
            }
            if(nums[j] < k){
                res++;
            }
            i++;j--;
        }
        return  res;

    }
}
