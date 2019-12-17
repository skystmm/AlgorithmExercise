package com.skystmm.leetcode.string;

/**
 * 709. To Lower Case
 * @author: skystmm
 * @date: 2019/8/9
 */
public class ToLowerCase {

    /**
     * AC 0ms
     * @param str
     * @return
     */
    public String solution(String str) {
        return str.toLowerCase();
    }

    /**
     * AC : 0ms
     * @param str
     * @return
     */
    public String solution2(String str) {
        StringBuilder sb =new StringBuilder();
        for(char c : str.toCharArray()){
            if(c >64&& c<91){
                sb.append(c+32);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
