package com.skystmm.leetcode.hashtable;

import java.util.*;

/**
 * 645. Set Mismatch
 * Created by Administrator on 2017/11/14.
 */

public class SetMismatch {
    /**
     * AC time: 51 ms beats:11.53%
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums){
        int[] res = new int[2];
        Set<Integer> tmp = new HashSet<Integer>();
        for(int i=1;i<=nums.length;i++){
            tmp.add(i);
        }
        for(int i = 0;i<nums.length;i++){
            int cur = nums[i];
            if(tmp.contains(cur)){
                tmp.remove(cur);
            }else{
                res[0] = cur;
            }
        }
        for(int i:tmp){
            res[1] = i;
        }
        return res;
    }

    /**
     * AC time:8ms beats:93.08%
     * @param nums
     * @return
     */
    public static int[] solutionV2(int[] nums){
        int len = nums.length;
        int[] am = new int[len];
        for (int i = 0; i < len; i++) {
            am[nums[i] - 1]++;
        }
        int[] rst = new int[2];
        for(int i = 0; i < am.length; i++) {
            if (am[i] == 2) {
                rst[0] = i + 1;
            } else if (am[i] == 0) {
                rst[1] = i + 1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        SetMismatch.solution(new int []{3,2,3,4,6,5});
    }
}
