package com.skystmm.lintcode.array;


/**
 * @author: skystmm
 * @date: 2020/1/17 10:36
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] res = new int[]{-1,-1};
        for(int i=0;i<numbers.length;i++){
            for(int j =i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}
