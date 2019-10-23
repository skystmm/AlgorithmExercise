package com.skystmm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * @author: skystmm
 * @date: 2019/10/23 11:44
 */
public class UniqueMorseRepresentations {


    String[] mores = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * AC time: O(n*n) space:O(1)
     * @param words
     * @return
     */
    public int solution(String[] words) {
        Set<String> resultSet = new HashSet<>();
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toLowerCase().toCharArray()){
                sb.append(mores[c -'a']);
            }
            resultSet.add(sb.toString());
        }
        return resultSet.size();
    }



}
