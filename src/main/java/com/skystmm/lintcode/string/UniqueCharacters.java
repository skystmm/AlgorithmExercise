package com.skystmm.lintcode.string;


import java.util.HashSet;
import java.util.Set;

/**
 * 157. Unique Characters
 * @author: skystmm
 * @date: 2020/1/17 11:22
 */
public class UniqueCharacters {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        Set<Character> check = new HashSet<>();
        for(char c : str.toCharArray()){
            if(!check.add(c)){
                return  false;
            }
        }
        return true;
    }
}
