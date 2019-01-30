package com.skystmm.array;


/**
 * 643. Maximum Average Subarray I
 * @author: skystmm
 * @date: 2019/1/30 15:40
 */
public class FindMaxAverage {
    /**
     * AC O(n) time:13ms  space O(1)
     * @param nums
     * @param k
     * @return
     */
    public double solution(int[] nums, int k) {
        Double max = null;
        Double cache = null;
        int i = k-1;
        do {
            double cur = 0.0D;
            if(cache ==null){
                for(int j = i -k +1;j<=i;j++){
                    cur += nums[j];
                }
            }else{
                cur = cache + nums[i];
            }
            cache = cur - nums[i-k+1];
            if(max == null || max < cur){
                max = cur;
            }
            i++;
        }while(i<=nums.length-1);

        return max/k;
    }

}