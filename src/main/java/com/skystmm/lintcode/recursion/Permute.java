package com.skystmm.lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. Permutations
 * @author: skystmm
 * @date: 2020/1/3 15:32
 */
public class Permute {

    /**
     * AC time:O(N!) space:O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            res.add(new ArrayList<>());
            return  res;
        }
        List<Integer> src = new ArrayList<>(nums.length);
        Arrays.stream(nums).forEach(item->src.add(item) );
        permute(res, new ArrayList<>(), src);
        return  res;
    }

    private void permute(List<List<Integer>> lists,List<Integer> mid,List<Integer> src){
        if(src.size() ==  1){
            mid.add(src.get(0));
            lists.add(mid);
            return;
        }
        int i =0;
        while(i <src.size()){
            List<Integer> cur = new ArrayList<>();
            cur.addAll(src);
            List<Integer> curMid = new ArrayList<>();
            curMid.addAll(mid);
            curMid.add(cur.get(i));
            cur.remove(i);
            permute(lists, curMid, cur);
            i++;
        }
    }

}


