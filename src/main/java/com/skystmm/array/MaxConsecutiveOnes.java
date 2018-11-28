package com.skystmm.array;

/**
 * 485. Max Consecutive Ones
 * Created by sky on 2018/11/28
 */
public class MaxConsecutiveOnes {
    /**
     * AC time:5 ms beats:84.04 %
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int maxLength = 0;
        int curLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                curLength = 0;
            }else{
                curLength += 1;
                if(maxLength < curLength){
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }
}

