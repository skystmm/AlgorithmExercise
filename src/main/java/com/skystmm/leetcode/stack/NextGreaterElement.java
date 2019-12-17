package com.skystmm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I
 * Created by Administrator on 2018/1/14.
 */

public class NextGreaterElement {
    /**
     * O(n * m) solution
     * AC time : 7 ms beats: 90.40 %
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {
        int len1= nums1.length;
        int len2 = nums2.length;
        int [] res = new int[len1];
        Map<Integer,Integer> indexs = new HashMap<Integer,Integer>();
        for(int i = 0; i< len2;i++){
            indexs.put(nums2[i],i);
        }

        for(int i = 0; i < len1 ; i++){
            int now = nums1[i];

            boolean flag = false;
            for(int j = indexs.get(now);j<len2 && !flag;j++){
                if(nums2[j] > now){
                    res[i] = nums2[j];
                    flag = true;
                }
            }
            if(!flag){
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution(new int[]{4,1,2},new int[]{1,3,4,2});
        //[4,1,2]
//[1,3,4,2]
    }
}
