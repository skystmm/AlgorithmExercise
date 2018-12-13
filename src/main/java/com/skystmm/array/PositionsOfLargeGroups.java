package com.skystmm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 * @author: tian.shen
 * @date: 2018/12/13 15:30
 */
public class PositionsOfLargeGroups {
    /**
     * AC time: 17 ms
     * @param S
     * @return
     */
    public List<List<Integer>> solution(String S) {
        int limit = 3;
        List<List<Integer>> result =new ArrayList<>();
        char last =S.charAt(0);
        int count = 1;
        for(int i = 1 ; i < S.length();i ++){
            char cur = S.charAt(i);
            if(cur == last){
                count ++;
                if(i +1 == S.length() && count >= limit){
                    List<Integer> tmp = new ArrayList<>(2);
                    tmp.add(i - count + 1);
                    tmp.add(i);
                    result.add(tmp);
                }
            }else if(cur != last){
                if(count >= limit){
                    List<Integer> tmp = new ArrayList<>(2);
                    tmp.add(i - count);
                    tmp.add(i - 1);
                    result.add(tmp);
                }
                count = 1;
                last = cur;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        new PositionsOfLargeGroups().solution("abbxxxxzzy");
    }
}
