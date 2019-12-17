package com.skystmm.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * Created by Administrator on 2017/11/15.
 */

public class LongestHarmoniousSubsequence {
    /**
     * AC time:91 ms beat:26.46%
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        int res = 0;
        Map<Integer,Integer> infos = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            if(infos.containsKey(cur)){
                infos.put(cur,infos.get(cur) + 1);
            }else{
                infos.put(cur,1);
            }
        }
        for(Map.Entry<Integer,Integer> tmp:infos.entrySet()){
            int count = 0;
            if(infos.containsKey(tmp.getKey()+1)){
                count = infos.get(tmp.getKey()+1) + tmp.getValue();
                if(res < count){
                    res = count;
                }
            }
            if(infos.containsKey(tmp.getKey()-1)){
                count = infos.get(tmp.getKey()-1) + tmp.getValue();
                if(res < count){
                    res = count;
                }
            }
        }
        return res;
    }
}
