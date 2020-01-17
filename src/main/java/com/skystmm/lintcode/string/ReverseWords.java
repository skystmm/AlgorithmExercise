package com.skystmm.lintcode.string;

/**
 * 53. Reverse Words in a String
 * @author: skystmm
 * @date: 2020/1/17 10:52
 */
public class ReverseWords {

    /**
     * AC time:O(n) space:O(n)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // write your code here
        StringBuilder sb =new StringBuilder();
        String[] ss = s.split(" ");
        for(int i = ss.length-1;i>=0;i--){
            String cur = ss[i].trim();
            if(cur.length() > 0){
                sb.append(cur);
                if(i != 0){
                    sb.append(" ");
                }
            }

        }
        return sb.toString().trim();
    }


}
