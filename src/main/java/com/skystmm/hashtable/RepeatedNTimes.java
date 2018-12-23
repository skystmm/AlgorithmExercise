package com.skystmm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 961. N-Repeated Element in Size 2N Array
 * @author: skystmm
 * @date: 2018/12/23 16:12
 */
public class RepeatedNTimes {
    /**
     * AC O(n) time: 7ms space :O(n)
     * @param A
     * @return
     */
    public int solution(int[] A) {
        Set<Integer> sets = new HashSet<>();
        for(int a : A){
            if(!sets.add(a)){
                return a;
            }
        }
        return 0;
    }
}
