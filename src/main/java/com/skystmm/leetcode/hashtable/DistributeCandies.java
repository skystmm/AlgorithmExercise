package com.skystmm.leetcode.hashtable;

import java.util.HashSet;

/**
 * 575. Distribute Candies
 * Created by Administrator on 2018/3/10.
 */

public class DistributeCandies {
    /**
     * AC time:100ms beats:51.51%
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> kinds = new HashSet<Integer>();
        for(int cur : candies) {
            if (!kinds.contains(cur)) {
                kinds.add(cur);
            }
        }
        int count = candies.length /2;
        if(count < kinds.size()){
            return count;
        }else{
            return kinds.size();
        }
    }
}
