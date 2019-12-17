package com.skystmm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Created by Administrator on 2017/10/22.
 */
public class TwoSum {
    /**
     * 双循环依次遍历
     * AC time:40ms beat:26.44%
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionV1(int[] nums, int target){
        int [] result = {-1,-1};
        int length  = nums.length;
        if(nums == null || length < 2){
            return result;
        }
        for(int i =0;i < length -1;i++){
            int cur = nums[i];
            for(int j = i + 1; j< length; j++){
                int tmp = cur + nums[j];
                if(target == tmp){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * AC time:11ms beat:47.58%
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionV2(int[] nums, int target){
        int [] result = {-1,-1};
        int length  = nums.length;
        if(nums == null || length < 2){
            return result;
        }
        Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
        for(int i =0;i < length;i++){
            maps.put(target - nums[i],i);
        }
        for(int i= 0;i< length ; i++){
            int cur = nums[i];
            if(maps.get(cur) != null){
                if(maps.get(cur) != i){
                    result[0] = i;
                    result[1] = maps.get(cur);
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 单循环依次遍历
     * AC time:8ms beat:73.31%
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionV3(int[] nums, int target){
        int [] result = {-1,-1};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
