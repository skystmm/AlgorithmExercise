package com.skystmm.lintcode.array;

/**
 * 14. First Position of Target
 * @author: skystmm
 * @date: 2020/1/3 15:06
 */
public class BinarySearch {

    /**
     * AC time:O(logN) space:O(1)
     * @param nums
     * @param target
     * @return
     */
    public int solution(int[] nums, int target) {
        // write your code here
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                int cur = mid -1;
                while(cur >= 0){
                    if(nums[cur] == nums[mid]){
                        cur --;
                    }else{
                        break;
                    }
                }
                return  cur +1;
            }else if(nums[mid] > target){
                end = mid -1;
            }else if(nums[mid] < target){
                start = mid+1;
            }
        }
        return -1;
    }


}
