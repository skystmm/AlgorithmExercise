package com.skystmm.lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 57. 3Sum
 * @author: skystmm
 * @date: 2020/1/19 10:22
 */
public class ThreeSum {
    /**
     * AC time:O(N^2) space:O(1)
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        int i=0,j=numbers.length-1;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(numbers);
        for(;i<j;i++){
            int end = j;
            for(;end > i;end--){
                int total = numbers[i] + numbers[end];
                for(int k = i+1;k<end;k++){
                    if(total+ numbers[k] == 0){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(numbers[i]);
                        tmp.add(numbers[k]);
                        tmp.add(numbers[end]);
                        result.add(tmp);
                    }
                }
            }

        }
        return  new ArrayList<>(result);
    }

}
