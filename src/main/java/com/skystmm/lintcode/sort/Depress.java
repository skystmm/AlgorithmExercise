package com.skystmm.lintcode.sort;

import java.util.Arrays;

/**
 * @author: skystmm
 * @date: 2020/1/17 11:57
 */
public class Depress {

    /**
     * AC
     * @param m
     * @param k
     * @param arr
     * @return
     */
    public String depress(int m, int k, int[] arr) {
        // Write your code here.
        Arrays.sort(arr);
        int total =0;
        for(int i =0;i<k;i++){
            total+=arr[i];
        }
        if(total < m){
            return "yes";
        }
        return "no";
    }
}
