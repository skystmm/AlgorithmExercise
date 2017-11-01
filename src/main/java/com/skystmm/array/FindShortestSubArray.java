package com.skystmm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. Degree of an Array
 * Created by Administrator on 2017/11/1.
 */

public class FindShortestSubArray {
    /**
     * AC time :43 ms beat:79.36%
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        if(nums == null){
            return 0;
        }
        Map<Integer,List<Integer>> info = new HashMap<Integer,List<Integer>>();
        if(nums.length == 1){
            return 1;
        }
        int result = 1;
        int lma = 0;
        for(int i= 0 ;i < nums.length; i++){
            int cur = nums[i];
            List<Integer> tmp = null;
            if(info.containsKey(cur)){
                info.get(cur).add(i);
            }else{
                tmp = new ArrayList<Integer>();
                tmp.add(i);
                info.put(cur,tmp);
            }
        }
        for(List<Integer> t : info.values()){
            if(lma < t.size()){
                lma = t.size();
                result = t.get(t.size() -1) - t.get(0) + 1;
            }else if(lma == t.size()){
                int curLen = t.get(t.size() -1) - t.get(0) + 1;
                if(curLen < result){
                    result = curLen;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FindShortestSubArray.solution(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2}));
    }
}
