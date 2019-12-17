package com.skystmm.leetcode.array;

/**
 * 35. Search Insert Position
 * Created by Administrator on 2017/10/30.
 */

public class SearchInsertPosition {
    /**
     * AC time:5 ms beat:59.06%
     * @param nums
     * @param target
     * @return
     */
    public int solution(int[] nums, int target) {
        int position = 0;
        for(int i =0;i<nums.length ; i++){
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int solutionV2(int[] nums, int target) {
        if(nums == null) return 0;
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target){

        if(right >= left){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            if(target < nums[mid]) return binarySearch(nums, left, mid - 1, target);
            if(target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
        }

        return left;

    }


}
