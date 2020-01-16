package com.skystmm.lintcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 32. Minimum Window Substring
 * @author: skystmm
 * @date: 2020/1/16 14:54
 */
public class MinWindow {

    /**
     * NAC too much time time:O(n^2) space:O(n)
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String solution(String source , String target) {
        // write your code here
        Map<Character,Integer> targetSrc = new HashMap<>();
        for(char c : target.toCharArray()){
           targetSrc.put(c, targetSrc.getOrDefault(c, 0) +1);
        }
        char[] src = source.toCharArray();
        int minLength =source.length() +1;
        int start =-1;
        int end = -1;
        for(int i = 0;i<src.length - target.length() + 1;i++){
            Map<Character,Integer> cur = new HashMap<>(targetSrc);
            if(cur.containsKey(src[i])){
                for(int j = i;j<src.length && src.length - j >=cur.size();j++){
                    char c = src[j];
                    if(cur.containsKey(c)){
                        if(cur.get(c) > 1){
                            cur.put(c, cur.get(c)-1);
                        }else{
                            cur.remove(c);
                            if(cur.isEmpty()){
                                if(j-i < minLength){
                                    start = i;
                                    end = j;
                                    minLength = j-i;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        }
        if(start == -1 || end == -1){
            return "";
        }
        return end == source.length() - 1?source.substring(start):source.substring(start, end+1);
    }

    /**
     * AC use dynamic programming time:O(N^2) space:O(m+n)
     * @param source
     * @param target
     * @return
     */
    public String solutionV2(String source , String target){
        Map<Character,Integer> targetSrc = new HashMap<>();
        for(char c : target.toCharArray()){
            targetSrc.put(c, targetSrc.getOrDefault(c, 0) +1);
        }
        Map<Character,Integer> sourceMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int tLength =0;
        int sRes = -1;
        int eRes = -1;
        int minLength = source.length()+1;
        char[] src = source.toCharArray();
        for(;end<source.length() ;end++){
            char cur = src[end];
            if(targetSrc.containsKey(cur)){
                sourceMap.put(cur,sourceMap.getOrDefault(cur, 0)+1 );
                if(sourceMap.get(cur).equals(targetSrc.getOrDefault(cur, 0))){
                    tLength ++;
                }
            }
            while(start < end && tLength == targetSrc.size()){
                if(end -start < minLength){
                    sRes = start;
                    eRes = end;
                    minLength = end - start;
                }
                char c = src[start];
                if(targetSrc.containsKey(c)){
                    sourceMap.put(c,sourceMap.get(c) -1 );
                    if(sourceMap.get(c) < targetSrc.get(c)){
                        tLength --;
                    }

                }
                start++;
            }
        }
        if(sRes == -1 || eRes == -1){
            return  "";
        }
        if(eRes == source.length()-1){
            return source.substring(sRes );
        }
        return source.substring(sRes, eRes +1);
    }


}


