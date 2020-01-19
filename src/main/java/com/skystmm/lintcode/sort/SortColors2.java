package com.skystmm.lintcode.sort;

/**
 * 143. Sort Colors II
 * @author: skystmm
 * @date: 2020/1/19 14:41
 */
public class SortColors2 {

    /**
     * AC time(n),space:O(k)
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] tmp =new int[k];
        for(int i :colors){
            tmp[i]++;
        }
        int index = 0;
        for(int i =0;i<k;i++){
            int count = tmp[i];
            while(count >0){
                colors[index] = i-1;
                index++;
                count--;
            }
        }
    }
}
