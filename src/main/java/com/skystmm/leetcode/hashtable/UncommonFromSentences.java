package com.skystmm.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 884. Uncommon Words from Two Sentences
 * @author: skystmm
 * @date: 2018/12/23 16:35
 */
public class UncommonFromSentences {
    /**
     * AC O(n+m) time : 8ms space:O(n)
     * @param A
     * @param B
     * @return
     */
    public String[] solution(String A, String B) {
        String target = A + " " + B;
        String[] a = target.split(" ");

        Set<String> once = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for(String s : a){
            if(!once.contains(s)&& !repeat.contains(s)){
                once.add(s);
            }else{
                once.remove(s);
                repeat.add(s);
            }
        }
        return  once.toArray(new String[once.size()]);
    }


}
