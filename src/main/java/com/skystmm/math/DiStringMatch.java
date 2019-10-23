package com.skystmm.math;

/**
 * 942. DI String Match
 * @author: skystmm
 * @date: 2019/10/23 14:09
 */
public class DiStringMatch {

    /**
     * AC time:O(n) space:O(n)
     *
     * @param S
     * @return
     */
    public int[] solution(String S) {
        int length = S.length();

        int start = 0 ,end=length;
        int result[] = new int[length+1];
        char []target = S.toCharArray();
        for(int i =0;i < length;i++){
            char c = target[i];
            if(c == 'I'){
                result[i] = start;
                start++;
            }else{
                result[i] = end;
                end--;
            }
        }
        result[length] = end;
        return result;
    }
}
