package com.skystmm.array;

/**
 * 724. Find Pivot Index
 * Created by sky on 2018/12/30
 */
public class PivotIndex {
    /**
     * AC O(n) time:27ms  space:O(1)
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int length = nums.length;
        if(length > 0){
            int left = 0;
            int right = 0;
            for(int i : nums){
                right+=i;
            }
            int j = 0;
            while(j < length){
                right -= nums[j];
                if(left == right){
                    return j;
                }
                left+=nums[j];
                j++;
            }
        }
        return -1;
    }
}
