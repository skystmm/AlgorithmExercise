package com.skystmm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 4. Median of Two Sorted Arrays
 * @author: skystmm
 * @date: 2019/1/22 22:51
 */
public class FindMedianSortedArrays {
    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution(int[] nums1, int[] nums2) {
        double result = 0.0;
        int total = nums1.length + nums2.length;
        Set<Integer> mids = new HashSet<>();
        if(total == (total >> 1 <<1)){
            mids.add(total/2);
            mids.add(total/2 -1);
        }else{
            mids.add(total/2);
        }
        int i=0,j=0;
        int count =0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] > nums2[j]){
                j++;
                count ++;
            }else{
                i++;
                count++;
            }

        }
    }
}
