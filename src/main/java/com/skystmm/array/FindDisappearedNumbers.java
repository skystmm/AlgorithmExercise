package com.skystmm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448. Find All Numbers Disappeared in an Array
 * @author: tian.shen
 * @date: 2018/12/1 11:04
 */
public class FindDisappearedNumbers {
    /**
     * AC time : 32 ms
     * @param nums
     * @return
     */
    public List<Integer> solution(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int length = nums.length;
        if(length == 0){
            return  ret;
        }
        Set<Integer> tmp = new HashSet<Integer>();
        for(int i : nums){
            tmp.add(i);
        }
        for(int i = 1 ;i <= length ;i++){
            if(!tmp.contains(i)){
                ret.add(i);
            }
        }
        return ret;
    }

}
