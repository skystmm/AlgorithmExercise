package com.skystmm.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Occurrences After Bigram
 *
 * @author: skystmm
 * @date: 2019/12/17 14:34
 */
public class FindOcurrences {
    /**
     * AC time:O(n),space:O(n)
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] solution(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] src = text.split(" ");
        int flag = 0;
        for (String cur : src) {
            switch (flag) {
                case 2:
                    res.add(cur);
                case 0:
                    flag = first.equals(cur) ? 1 : 0;
                    break;
                case 1:
                    flag = second.equals(cur) ? 2 : first.equals(cur) ? 1 : 0;;
                    break;

                default:
                    flag = 0;
            }
        }
        return res.toArray(new String[res.size()]);
    }

}
