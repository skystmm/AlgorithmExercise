package com.skystmm.string;

/**
 * 1221. Split a String in Balanced Strings
 * @author: skystmm
 * @date: 2019/10/23 11:07
 */
public class BalancedStringSplit {

    /**
     * AC time: O(n) space:o(1)
     * @param s
     * @return
     */
    public int solution(String s) {
        int count = 0;
        boolean flag = true;
        char[] target = s.toCharArray();
        Character last = null;
        int lastCount = 0;
        for(int i=0 ;i<target.length;i++){
            if(last == null){
                last = target[i];
                lastCount = 1;
                continue;
            }
            flag = target[i] ==last && lastCount >0;
            if(flag){
                lastCount++;
            }else{
                if(lastCount > 1){
                    lastCount--;
                }else{
                    lastCount =0;
                    last =null;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * AC time :O(n),space:O(1) fast then V1
     * @param s
     * @return
     */
    public int solutionV2(String s) {
        char[] target = s.toCharArray();
        int LRCount = 0,zeroCount=0,i=0;
        while(i<target.length){
            if(target[i] == 'L'){
                LRCount++;
            }else{
                LRCount--;
            }
            if(i %2 == 1){
                if(LRCount == 0){
                    zeroCount++;
                }
            }
            i++;
        }
        return zeroCount;

    }

}
