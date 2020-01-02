package com.skystmm.lintcode.string;

/**
 * 8. Rotate String
 * @author: skystmm
 * @date: 2020/1/1
 */
public class RotateString {
    /**
     *  AC time:O(N^2) space:O(1)
     * @param str
     * @param offset
     */
    public void solution(char[] str, int offset) {
        // write your code here
        if(str.length == 0){
            return;
        }
        if(offset > str.length){
            offset = offset % str.length;
        }
        if(offset == 0){
            return ;
        }
        for(int i = 0;   i <  offset;i++){
            char tmp = str[str.length - offset +i];
            move(str,i,i+(str.length - offset));
            str[i] = tmp;
        }

    }

    private void move(char[] str, int i, int i1) {
        for(int j = i1;j>i;j--){
            str[j] = str[j-1];
        }
    }


}
