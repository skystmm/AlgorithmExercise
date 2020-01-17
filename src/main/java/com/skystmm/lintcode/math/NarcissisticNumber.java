package com.skystmm.lintcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 147. Narcissistic Number
 * @author: skystmm
 * @date: 2020/1/3 15:57
 */
public class NarcissisticNumber {
    /**
     * OAC 遍历 time:O(n) space:O(1)
     * @param n
     * @return
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();

        int start = (int)Math.pow(10, n-1);
        int end = (int)Math.pow(10, n);
        //特别考虑start=1的情况，此时start应为0
        if(start == 1)
            start = 0;

        for(int i= start; i < end; i++)
            if(isNarNum(i))
                list.add(i);

        return list;
    }

    private boolean isNarNum(int num){
        //将int转String再转char[]再转int[]，实现数字各位分离
        String str = String.valueOf(num);
        char[] strs = str.toCharArray();

        int[] nums = new int[strs.length];
        for(int i=0; i<nums.length; i++)
            nums[i] = strs[i] - '0';

        int sum = 0;
        int len = nums.length;
        for(int i=0; i<len; i++)
            sum += (int)Math.pow(nums[i], len);

        if(num == sum)
            return true;
        return false;
    }

}
