package com.skystmm.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * @author: skystmm
 * @date: 2019/10/23 14:28
 */
public class UniqueOccurrences {

    /**
     * AC time: O(n),space: O(n)
     * @param arr
     * @return
     */
    public boolean solution(int[] arr) {
        Map<Integer,Integer> result = new HashMap<>();
        for(int a : arr){
            if(result.containsKey(a)){
                result.put(a, result.get(a) + 1);
            }else{
                result.put(a, 1);
            }
        }
        Set<Integer> countSet = new HashSet<>();
        countSet.addAll(result.values());
        return countSet.size() == result.size();
    }
}
