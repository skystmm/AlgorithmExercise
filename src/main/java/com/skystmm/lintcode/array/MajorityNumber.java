package com.skystmm.lintcode.array;


import java.util.List;

/**
 * 46. Majority Element
 * @author: skystmm
 * @date: 2020/2/3
 */
public class MajorityNumber {

    /**
     * AC time:O(n) space O(1)
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Integer res = null;
        int count =0;
        for(int cur : nums){
            if(count == 0){
                res = cur;
                count ++;
            }else{
                if(res == cur){
                    count ++;
                }else{
                    count --;

                }
            }

        }
        return res;
    }


}
