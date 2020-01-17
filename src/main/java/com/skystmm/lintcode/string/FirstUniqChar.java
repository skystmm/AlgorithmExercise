package com.skystmm.lintcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * 209. First Unique Character in a String
 * @author: skystmm
 * @date: 2020/1/17 10:59
 */
public class FirstUniqChar {
    /**
     * AC time:O(n) space:O(n)
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char solution(String str) {
        // Write your code here
        Map<Character,Integer> count= new HashMap();
        Map<Character,Integer> index= new HashMap<>();
        char[] cs = str.toCharArray();
        for(int i =0;i<cs.length;i++){
            char c = cs[i];
            if(count.containsKey(c)){
                index.remove(c);
            }else{
                count.put(c, 1);
                index.put(c, i);
            }
        }
        Character res = null;
        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> item :index.entrySet()){
            if(item.getValue() < minIndex){
                res = item.getKey();
                minIndex = item.getValue();
            }
        }
        return res;
    }

}
