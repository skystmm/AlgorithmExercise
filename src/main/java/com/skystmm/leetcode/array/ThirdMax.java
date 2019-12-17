package com.skystmm.leetcode.array;

import java.util.Set;
import java.util.TreeSet;

/**
 * 414. Third Maximum Number
 * @author: skystmm
 * @date: 2019/2/4 16:57
 */
public class ThirdMax {
    /**
     * Ac use treeset time :14 ms space O(n)
     * @param nums
     * @return
     */
    public int solution(int[] nums) {

        Set<Integer> sets = new TreeSet<>();
        for(int i : nums){
            sets.add(i);
        }
        Integer[] result = sets.toArray(new Integer[sets.size()]);
        if (result.length < 3) {
            return result[result.length-1];
        }
        return  result[result.length-3];
    }

    /**
     * AC force O(N) time :5 ms space O(1)
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        if (nums.length < 3) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        Long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = Long.valueOf(i);
            }
            if(i < max1 && i> max2){
                max3 = max2;
                max2 = Long.valueOf(i);
            }
            if(i < max2 && i > max3){
                max3 = Long.valueOf(i);
            }
        }

        return max3 == Long.MIN_VALUE ? max1.intValue() : max3.intValue();

    }

}
