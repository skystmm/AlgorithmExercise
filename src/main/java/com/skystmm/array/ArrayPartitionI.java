package com.skystmm.array;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * Created by Administrator on 2017/11/14.
 */

public class ArrayPartitionI {
    /**
     * AC commit1 time :37ms beats:37.41%
     * commit2 time :33ms beat 87.01%
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        Arrays.sort(nums);
        int res = 0;
        for(int i =0;i < nums.length; i += 2){
            res += nums[i];
        }
        return res;
    }
}
