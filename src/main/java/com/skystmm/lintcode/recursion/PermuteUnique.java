package com.skystmm.lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 16. Permutations II
 * @author: skystmm
 * @date: 2020/1/4 22:43
 */
public class PermuteUnique {

    /**
     * AC time:O(N!) space O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        // write your code here
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length == 0){
            res.add(new ArrayList<>());
            return new ArrayList<>(res);
        }
        List<Integer> src = new ArrayList<>(nums.length);
        Arrays.stream(nums).forEach(item->src.add(item) );
        permute(res, new ArrayList<>(), src);
        return  new ArrayList<>(res);
    }

    private void permute(Set<List<Integer>> lists,List<Integer> mid,List<Integer> src){
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
