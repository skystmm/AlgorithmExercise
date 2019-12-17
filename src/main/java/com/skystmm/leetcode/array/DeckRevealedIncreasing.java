package com.skystmm.leetcode.array;

import java.util.Arrays;

/**
 * 950. Reveal Cards In Increasing Order
 * @author: skystmm
 * @date: 2019/2/6 16:34
 */
public class DeckRevealedIncreasing {
    /**
     *
     * @param deck
     * @return
     */
    public int[] solution(int[] deck) {
        int [] result  = new int[deck.length];
        Arrays.sort(deck);
        int step = 1;
        for(int i =0;i < deck.length ; i++){
            if(i << 1 < deck.length){
                result[i<< 1] = deck[i];
                step++;
            }else{
                if(step >>1 << 1 == step){
                    result[step] = deck[i];
                }else{
                    result[step] = deck[i];
                }
            }
        }
        return result;
    }
}
