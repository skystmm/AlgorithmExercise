package com.skystmm.leetcode.array;

/**
 * 746. Min Cost Climbing Stairs
 * @author: tian.shen
 * @date: 2018/12/18 14:25
 */
public class MinCostClimbingStairs {
    /**
     * Dynamic Programming
     * AC time : 8ms beats: 99.19%
     * @param cost
     * @return
     */
    public int solution(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }


}
