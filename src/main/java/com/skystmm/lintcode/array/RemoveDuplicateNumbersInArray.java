package com.skystmm.lintcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 521.Remove Duplicate Numbers in Array
 * @author: skystmm
 * @date: 2020/1/17 11:35
 */
public class RemoveDuplicateNumbersInArray {

    /**
     * AC time:O(n) space O(n)
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int solution(int[] nums) {
        // write your code here
        Set<Integer> containNum = new HashSet<>();
        int i = 0;
        int dunlicateCount = 0;
        while(i < nums.length - dunlicateCount){
            int cur = nums[i];
            if(!containNum.add(cur)){
                nums[i] =  nums[nums.length -1 - dunlicateCount];
                dunlicateCount++;
            }else{
                i++;
            }
        }
        return nums.length - dunlicateCount;
    }
}
