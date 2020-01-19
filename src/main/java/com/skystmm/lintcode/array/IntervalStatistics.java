package com.skystmm.lintcode.array;

/**
 * @author: skystmm
 * @date: 2020/1/19 16:06
 */
public class IntervalStatistics {

    /**
     * OAC time: O(n) space O(1)
     * @param arr: the 01 array
     * @param k: the limit
     * @return: the sum of the interval
     */
    public long intervalStatistics(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0) return 0;

        int left = 0, right = 0;
        long numOfOne = 0, sum = 0;

        while (right < arr.length){
            if (arr[right] == 1){
                numOfOne++;
                right++;
                continue;
            }

            if (arr[left] == 1){
                numOfOne--;
                left++;
                continue;
            }

            while (numOfOne > k){
                if (arr[left] == 1){
                    numOfOne--;
                }
                left++;
            }

            sum += right - left + 1 - numOfOne;

            right++;

        }

        return sum;

    }

}
