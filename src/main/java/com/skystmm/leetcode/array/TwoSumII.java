package com.skystmm.leetcode.array;

/**
 * 167. Two Sum II - Input array is sorted
 * Created by Administrator on 2017/10/25.
 */

public class TwoSumII {
    /**
     * AC time:1ms beat:39.58%
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length < 2 ){
            return result;
        }
        int i = 0 ;
        int j = numbers.length -1;
        if(numbers[i] + numbers[i+1] > target){
            return result;
        }
        while(i<j){
            int cur = numbers[i] + numbers[j];
            if(cur > target){
                j--;
            }else if(cur < target) {
                i++;
            }else{
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }
        return result;
    }
}
