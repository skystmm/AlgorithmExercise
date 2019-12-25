package com.skystmm.leetcode.greedy;

import java.util.Arrays;

/**
 * 1046. Last Stone Weight
 * @author: skystmm
 * @date: 2019/12/25 15:49
 */
public class LastStoneWeight {
    /**
     * AC time:O(Nlog(N)) space:O(1)
     * @param stones
     * @return
     */
    public int solution(int[] stones) {
        if(stones.length == 2){
            return  Math.abs(stones[1] - stones[0]);
        }
        Arrays.sort(stones);
        for(int i = stones.length-1;i > 0;i--){
            int cur = stones[i] - stones[i-1];
            stones[i-1] = cur;
            if(cur > 0){
                insert(stones,i-1);
            }else if(cur == 0){
                i--;
            }
        }
        return  stones[0];
    }

    private void insert(int[] stones, int index) {
        int cur = stones[index];
        for(int i = 0; i< index +1;i++){
            if(cur < stones[i]){
                int tmp = stones[i];
                stones[i] = cur;
                for(int j = index;j>i+1;j--){
                    stones[j]=stones[j-1];
                }
                stones[i+1]=tmp;
                return;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().solution(new int[]{1,4}));
    }
}
