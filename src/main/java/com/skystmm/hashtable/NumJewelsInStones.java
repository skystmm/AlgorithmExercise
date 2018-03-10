package com.skystmm.hashtable;


/**
 * 771. Jewels and Stones
 * Created by Administrator on 2018/3/10.
 */

public class NumJewelsInStones {
    /**
     * AC time: 18 ms
     * @param J
     * @param S
     * @return
     */
    public int solution(String J, String S) {
        Integer total = 0;
        if(J.length() > 0&& S.length() > 0){
            char[] s = S.toCharArray();
            for(char cur :s){
                String tmp = String.valueOf(cur);
                if(J.contains(tmp)){
                    total+=1;
                }
            }
        }
        return total;
    }
}
