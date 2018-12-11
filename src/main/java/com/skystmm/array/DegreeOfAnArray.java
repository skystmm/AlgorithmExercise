package com.skystmm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. Degree of an Array
 * @author: tian.shen
 * @date: 2018/12/11 16:32
 */
public class DegreeOfAnArray {
    /**
     * AC 91 ms bad
     * need faster solution
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        Map<Integer,List<Integer>> indexRelation = new HashMap<>(nums.length * 2);
        for(int i =0;i< nums.length ;i++){
            if(!indexRelation.containsKey(nums[i])){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                indexRelation.put(nums[i],tmp);
            }else{
               indexRelation.get(nums[i]).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for(Map.Entry<Integer,List<Integer>>entry  : indexRelation.entrySet()){
            if(entry.getValue().size() > max){
                result = new ArrayList<>();
                result.add(calculate(entry.getValue()));
                max = entry.getValue().size();
            }else if(entry.getValue().size() == max){
                result.add(calculate(entry.getValue()));
            }
        }
        return result.stream().min(Integer::compare).get();
    }

    private int calculate(List<Integer> indexs ){
        int start = indexs.get(0);
        int end = indexs.get(indexs.size() -1);
        return end - start + 1;

    }

}
