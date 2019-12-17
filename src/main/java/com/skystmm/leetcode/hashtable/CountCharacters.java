package com.skystmm.leetcode.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * 160. Find Words That Can Be Formed by Characters
 * @author: skystmm
 * @date: 2019/10/28 14:50
 */
public class CountCharacters {
    /**
     * AC time:O(m*n) space :O(n)
     * @param words
     * @param chars
     * @return
     */
    public int solution(String[] words, String chars) {
        Map<Character,Integer> target = buildMap(chars);
        int count = 0;
        for(String s: words){
            Map<Character,Integer> cur = buildMap(s);
            boolean flag = true;
            for(Map.Entry c : cur.entrySet()){
                if(!target.containsKey(c.getKey()) || target.get(c.getKey()) < cur.get(c.getKey())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count+= s.length();
            }
        }
        return count;
    }

    private Map<Character,Integer> buildMap(String chars) {
        Map<Character,Integer> target = new HashMap<>();
        for( Character c : chars.toCharArray()){
            if (target.containsKey(c)) {
                target.put(c, (target.get(c) + 1));
            } else {
                target.put(c, 1);
            }
        }
        return  target;
    }




}
