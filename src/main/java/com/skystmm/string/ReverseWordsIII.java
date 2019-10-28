package com.skystmm.string;

/**
 * 557. Reverse Words in a String III
 * @author: skystmm
 * @date: 2019/10/28 16:22
 */
public class ReverseWordsIII {

    /**
     * Ac time:O(n) ,space :O(1)
     * @param s
     * @return
     */
    public String solution(String s) {
        String[] t = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String x : t){
            char[] tmp =x.toCharArray();
            int i =0,j=tmp.length-1;
            while(i<j){
                char a = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = a;
                i++;j--;
            }
            result.append(new String(tmp)).append(" ");
        }
        return result.substring(0,result.length()-1 );
    }
}
