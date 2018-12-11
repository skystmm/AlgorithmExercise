package com.skystmm.array;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * @author: tian.shen
 * @date: 2018/12/11 16:16
 */
public class ContainsDuplicate {
    /**
     * 1.use hashset : AC 8 ms 80.42%
     * 2.use bitmap
     * 3.use bloom filter(mistake)
     * @param nums
     * @return
     */
    public boolean solution(int[] nums) {
        HashSet<Integer> sets = new HashSet<>(nums.length);
        for(int i : nums){
            if(!sets.add(i)){
                return true;
            }
        }
        return false;
    }


}
