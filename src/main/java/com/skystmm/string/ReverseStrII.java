package com.skystmm.string;

/**
 * 541. Reverse String II
 * @author: skystmm
 * @date: 2019/10/28 16:27
 */
public class ReverseStrII {
    /**
     * AC time : O(n) space:O(k)
     * @param s
     * @param k
     * @return
     */
    public String solution(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean flag = true;
        while(i < s.length()){
            if(i + k < s.length()){
                sb.append(flag ? reverse(s.substring(i,i+k)):s.substring(i,i+k));
            }else{
                sb.append(flag ? reverse(s.substring(i)):s.substring(i));
            }
            flag = !flag;
            i += k;
        }
        return  sb.toString();
    }

    private String reverse(String a){
        char[] tmp =a.toCharArray();
        int i =0,j=tmp.length-1;
        while(i<j){
            char t = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = t;
            i++;j--;
        }
        return new String(tmp);
    }

}
