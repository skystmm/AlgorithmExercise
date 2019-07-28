package com.skystmm.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * 1122. Relative Sort Array
 * @author: skystmm
 * @date: 2019/7/28
 */
public class RelativeSortArray {

    /**
     * AC time : 3 ms space O(n)
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Map<Integer,Integer> infos = new TreeMap<>();
        for(int a : arr1){
            if(infos.containsKey(a)){
                infos.put(a,infos.get(a) +1);
            }else{
                infos.put(a,1);
            }
        }
        int curIndex = 0;
        for(int b : arr2){
            Integer count = infos.remove(b);
            for(int i =0;i<count;i++){
                result[curIndex] = b;
                curIndex++;
            }
        }
        if(!infos.isEmpty()){
            for(Map.Entry<Integer,Integer> entry :infos.entrySet()){
                Integer count = entry.getValue();
                Integer value = entry.getKey();
                for(int i =0;i<count;i++){
                    result[curIndex] = value;
                    curIndex++;
                }
            }
        }
        return result;
    }
}
