package com.skystmm.lintcode.sort;

import java.util.Arrays;

/**
 * 1670. Turn-Based Game
 *
 * @author: skystmm
 * @date: 2020/1/19 14:53
 */
public class TurnBasedGame {
    /**
     * uncheck
     *
     * @param atk: the atk of monsters
     * @return: Output the minimal damage QW will suffer
     */
    public long getAns(int[] atk) {
        // Write your code here
        long total = 0l;
        Arrays.sort(atk);
        if (atk.length == 2) {
            return atk[0];
        }
        int count = 1;
        for (int i = atk.length - 2; i > -1; i--) {
            total += atk[i] * count;
            count++;
        }
        return total;
    }


}
