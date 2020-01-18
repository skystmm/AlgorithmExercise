package com.skystmm.lintcode.array;

import java.util.List;

/**
 * 39. Recover Rotated Sorted Array
 * @author: skystmm
 * @date: 2020/1/18
 */
public class RecoverRotatedSortedArray {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int start = 0,end=nums.size()-1;
        int rotate = -1;
        int i =0;
        while(i < end-1){
            if(nums.get(i) > nums.get(i+1)){
                rotate = i+1;
                break;
            }
            i++;
        }
        if(rotate > -1){
            rotate(nums,start, rotate-1);
            rotate(nums,rotate, end);
            rotate(nums,start,end);
        }

    }

    private void rotate(List<Integer> nums, int start, int end) {
        while(start < end){
            Integer tmp = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end,tmp);
            start++;
            end--;
        }
    }
}
