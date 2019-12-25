package com.skystmm.leetcode.array;

/**
 * 1217. Play with Chips
 * @author: skystmm
 * @date: 2019/12/24 13:57
 */
public class MinCostToMoveChips {

    /**
     * AC time :O(n) space:O(1)
     * @param chips
     * @return
     */
    public int solution(int[] chips) {
        int[] count = new int[2];
        for(int chip : chips){
            count[chip&1]++;
        }
        return count[0]<count[1]? count[0]: count[1];
    }

}
