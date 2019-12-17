package com.skystmm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 * @author: skystmm
 * @date: 2019/10/28 15:52
 */
public class MinimumAbsDifference {

    /**
     * AC time:O(NlogN) space:O(1)
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int curMin = Integer.MAX_VALUE;
        for(int i =0;i < arr.length - 1 ; i++){
            if(arr[i+1] - arr[i] < curMin){
                result = new ArrayList<>();
                curMin = arr[i+1] - arr[i];
            }
            if(arr[i+1] - arr[i] == curMin){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i+1]);
                result.add(tmp);
            }
        }
        return result;
    }
}
