package com.skystmm.array;

/**
 * 747. Largest Number At Least Twice of Others
 * @author: skystmm
 * @date: 2018/12/23 15:43
 */
public class LargestNumberAtLeastTwiceOfOthers {
    /**
     * AC O(n) time :10 ms space： O(1)
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
       int max = nums[0];
       int index = 0;
       int second = Integer.MIN_VALUE;
       for(int i =1 ;i<nums.length;i ++){
           if(nums[i] >= max){
               second = max;
               max = nums[i];
               index = i;
           }else if(nums[i] > second){
               second = nums[i];
           }

       }

       return max >> 1  >= second ? index :-1;
    }
}
