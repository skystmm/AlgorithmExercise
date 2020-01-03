package com.skystmm.lintcode.string;

/**
 * 13. Implement strStr()
 * @author: skystmm
 * @date: 2020/1/3 11:25
 */
public class StrStr {
    /**
     * AC time:O(N*M) space:O(N+M)
     * @param source
     * @param target
     * @return
     */
    public int solution(String source, String target) {
        // Write your code here
        if(source.equals(target) || target.length()==0){
            return 0;
        }
        char[] sourceChar = source.toCharArray();
        char[] targetChar = target.toCharArray();
        for(int i=0;i<source.length();i++){
            for(int j = 0;j<target.length();j++){
                if(i+j >=source.length()){
                    return -1;
                }
                if(sourceChar[i + j] != targetChar[j]){
                    break;
                }
                if(j == target.length()-1){
                    return i;
                }
            }
        }
        return  -1;
    }

}
