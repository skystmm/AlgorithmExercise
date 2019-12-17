package com.skystmm.leetcode.array;

/**
 * 914. X of a Kind in a Deck of Cards
 * @author: skystmm
 * @date: 2019/2/1 17:08
 */
public class HasGroupsSizeX {
    /**
     * AC time:12 ms space: O(1)
     * @param deck
     * @return
     */
    public boolean solution(int[] deck) {

        int[] cardCount = new int[10000];
        for(int i:deck){
            cardCount[i] +=1;
        }
        int result = -1;
        for(Integer i : cardCount){
            result = result>0?gcd(result,i):i;
        }
        return result>=2;
    }

    private int gcd(int x, Integer y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
