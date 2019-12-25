package com.skystmm.leetcode.string;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. Groups of Special-Equivalent Strings
 * @author: skystmm
 * @date: 2019/12/24 11:52
 */
public class NumSpecialEquivGroups {
    /**
     * OAC time: O(n*m) ,space: O(n)
     * @param A
     * @return
     */
    public int solution(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
