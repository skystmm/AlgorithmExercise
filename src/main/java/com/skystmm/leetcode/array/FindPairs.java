package com.skystmm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array
 * Created by Administrator on 2017/10/25.
 */

public class FindPairs {
    /**
     * AC time :41 ms beat:16.97 %
     * @param nums
     * @param k
     * @return
     */
    public static int solutionV1(int[] nums, int k) {
        int leng = nums.length;
        if(leng < 2){
            return 0;
        }
        if(k < 0){
            return 0;
        }
        int count = 0;
        Set<String> appearent = new HashSet<String>();
        Set<Integer> has = new HashSet<Integer>();
        has.add(nums[0]);
        for(int i =1;i<nums.length;i++){
           int cur = nums[i];
           int ma = cur + k;
           int mi = cur - k;
           if(has.contains(ma)){
               String cmp = cur + "," + ma;
               if(!appearent.contains(cmp)){
                   count += 1;
                   appearent.add(cmp);
               }
           }
           if(has.contains(mi)){
                String cmp = mi + "," + cur;
                if(!appearent.contains(cmp)){
                    count += 1;
                    appearent.add(cmp);
                }
           }
           has.add(cur);
        }
        return count;
    }

    /**
     * 排序后双游标移动
     * @param nums
     * @param k
     * @return
     */
    public static int solutionV2(int[] nums, int k) {
        int leng = nums.length;
        if(leng < 2){
            return 0;
        }

        return 0;
    }
}
