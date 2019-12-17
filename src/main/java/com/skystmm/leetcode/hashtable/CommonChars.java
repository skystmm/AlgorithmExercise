package com.skystmm.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 1002. Find Common Characters
 * @author: skystmm
 * @date: 2019/10/30 14:46
 */
public class CommonChars {
    /**
     * AC time:O(N*M) ,space:O(1)
     * @param A
     * @return
     */
    public List<String> solution(String[] A) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : A){
            char[] tmp = s.toCharArray();
            if(map.isEmpty()){
                map = buildMap(tmp);
            }else{
                Map<String,Integer> tt = buildMap(tmp);
                intersection(tt,map);
            }
            if(map.isEmpty()){
                return new ArrayList<>();
            }
        }

        List<String> results = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int i =0;
            while(i< entry.getValue()){
                results.add(entry.getKey());
                i++;
            }
        }

        return  results;
    }

    private void intersection(Map<String, Integer> tt, Map<String, Integer> map) {
        for(Map.Entry<String,Integer> entry : tt.entrySet()){
            if(map.containsKey(entry.getKey())){
                map.put(entry.getKey(),Math.min(entry.getValue(), map.get(entry.getKey())));
            }
        }
        Iterator<Map.Entry<String,Integer> > it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> item =it.next();
            if(!tt.containsKey(item.getKey())){
                it.remove();
            }
        }
    }

    private Map<String,Integer> buildMap(char[] tmp) {
        Map<String,Integer> map = new HashMap<>();
        for(char c:tmp){
            String t =String.valueOf(c);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return  map;
    }


}
