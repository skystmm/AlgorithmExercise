package com.skystmm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: tian.shen
 * @date: 2018/12/13 15:55
 */
public class MaximumProductOfThreeNumbers {
    /**
     * Time Limit Exceeded O(n^3)
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<nums.length  ;i++){
            for(int j = i+1; j<nums.length ;j++){
                for(int k= j+1 ; k < nums.length ;k++){
                    int cur = nums[i] * nums[j] * nums[k];
                    if(cur > max) {
                        max = cur;
                    }
                }
            }

        }
        return max;
    }

    /**
     * space O(n) time O(nlogn)
     * AC time : 89 ms
     * @param nums
     * @return
     */
    public int soluton2(int[] nums){
        List<Integer> positive = new ArrayList<>();
        List<Integer> nagetive = new ArrayList<>();
        if(nums.length  == 3){
            return nums[0]* nums[1] * nums[2];
        }
        for(int n : nums){
            if(n < 0){
                nagetive.add(n);
            }else{
                positive.add(n);
            }
        }
        Collections.sort(positive);
        Collections.sort(nagetive);
        int pl = positive.size();
        int nl = nagetive.size();
        List<Integer> result = new ArrayList<>();
        if(pl >= 3){
            int a = positive.get(pl - 1) * positive.get(pl - 2) * positive.get(pl-3);
            result.add(a);
        }
        if(nl >= 2){
            int a = positive.get(pl-1) * nagetive.get(0) * nagetive.get(1);
            result.add(a);
        }

        Collections.sort(result);
        return result.get(result.size() -1);

    }

    /**
     * space O(1) time O(nlogn)
     * AC time : 25 ms
     * @param nums
     * @return
     */
    public int solution3(int[] nums){
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

}
