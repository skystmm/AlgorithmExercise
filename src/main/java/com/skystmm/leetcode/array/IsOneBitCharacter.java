package com.skystmm.leetcode.array;

/**
 * 717. 1-bit and 2-bit Characters
 * 0 10 11
 * @author: tian.shen
 * @date: 2018/12/1 20:40
 */
public class IsOneBitCharacter {
    /**
     * AC time :5 ms
     * @param bits
     * @return
     */
    public boolean solution(int[] bits) {
        int length = bits.length ;
        if(bits[length - 1] == 1){
            return false;
        }
        int index =0;
        boolean flag = true;
        while(index < length){
            if(bits[index] == 0){
                index +=1 ;
                flag = true;
            }else{
                index +=2 ;
                flag = false;
            }
        }
        return flag;
    }

    /**
     * solution by leetcode
     * @param bits
     * @return
     */
    public boolean solution2(int[] bits){
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}

