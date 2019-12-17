package com.skystmm.leetcode.array;


/**
 * 122. Best Time to Buy and Sell Stock II
 * @author: tian.shen
 * @date: 2018/12/4 14:48
 */
public class BestTimezToBuyAndSellStockII {
    /**
     * AC time:1 ms  99.00%
     * @param prices
     * @return
     */
    public int solution(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for(int i= 1;i<length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
