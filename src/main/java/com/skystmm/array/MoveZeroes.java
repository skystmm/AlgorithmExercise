package com.skystmm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 283. Move Zeroes
 * @author: tian.shen
 * @date: 2018/12/1 21:03
 */
public class MoveZeroes {
    /**
     * AC time : 56 ms (use stream) addition space O(n)
     * @param nums
     */
    public void solution(int[] nums) {
        int[] noZero = Arrays.stream(nums).filter(item->item != 0).toArray();
        int length = noZero.length;
        for(int i =0 ; i <nums.length; i++){
            if(i < length){
                nums[i]=noZero[i];
            }
            else{
                nums[i] =0;
            }
        }
    }

    /**
     * AC time : 3 ms, addition space O(n)
     * @param nums
     */
    public void solution2(int[] nums) {
        List<Integer> noZero = new ArrayList<>();
        for(int t : nums){
            if(t != 0 ){
                noZero.add(t);
            }
        }
        int length = noZero.size();
        for(int i =0 ; i <nums.length; i++){
            if(i < length){
                nums[i]=noZero.get(i);
            }
            else{
                nums[i] =0;
            }
        }
    }
}
