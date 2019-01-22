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
     * AC O(m+n) time:41 ms space O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution(int[] nums1, int[] nums2) {
        double result = 0.0;
        int c = 1;
        int total = nums1.length + nums2.length;
        if(total == (total >> 1 <<1)){
            c = 2;
        }
        int i=0,j=0;
        int tmp=0;
        int count =0;
        while(count <= (total/2)){
            if(i<nums1.length && j<nums2.length){
                if(nums1[i] > nums2[j]){
                    if(count == total/2 -1){
                        tmp = nums2[j];
                    }
                    if(count == total/2){
                        result+=nums2[j];
                    }
                    j++;
                    count ++;
                }else{
                    if(count == total/2 -1){
                        tmp = nums1[i];
                    }
                    if(count == total/2){
                        result+=nums1[j];
                    }
                    i++;
                    count++;
                }
            }else{
                if(i<nums1.length ){
                    if(count == total/2 -1){
                        tmp = nums1[i];

                    }
                    if(count == total/2){
                        result+=nums1[i];
                    }
                    i++;
                    count++;
                }

                if(j<nums2.length){
                    if(count == total/2 -1){
                        tmp = nums2[j];

                    }
                    if(count == total/2){
                        result+=nums2[j];
                    }
                    j++;
                    count++;
                }
            }

        }
        if(c == 2){
            return (result+tmp)/2.0;
        }
        return result;

    }

    public static void main(String[] args) {
        new FindMedianSortedArrays().solution(new int[]{1,2},new int[]{3,4});
    }
}
