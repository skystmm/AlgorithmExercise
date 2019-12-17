package com.skystmm.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * Created by Administrator on 2017/11/15.
 */

public class MinimumIndexSumofTwoLists {
    /**
     * AC time:29ms beat:55.73%
     * @param list1
     * @param list2
     * @return
     */
    public static String[] solution(String[] list1, String[] list2) {
        StringBuffer sb = new StringBuffer();
        Map<String,Integer> common = new HashMap<String,Integer>();
        for(int i = 0;i<list1.length;i++){
            common.put(list1[i],i);
        }
        int min = list1.length + list2.length;
        for(int i =0 ;i<list2.length;i++){
            String fa = list2[i];
            if(common.containsKey(fa)){
                int cur = common.get(fa) + i;
                if(cur < min){
                    sb = new StringBuffer(fa);
                    min = cur;
                }else if(cur == min){
                    sb .append(",").append(fa);
                }
            }
        }
        return sb.toString().split(",");
    }

    /**
     * best OAC code
     * @param list1
     * @param list2
     * @return
     */
    int small = -1;
    int large = -1;
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm = new HashMap();
        List<String> ans = new ArrayList();
        for(int i=0;i<list1.length||i<list2.length;i++) {
            checkMap(list1, i, hm, ans);
            checkMap(list2, i, hm, ans);
            if (small!=-1) break;
        }
        for (int i=large+1, j=small-1; (i<list1.length || i<list2.length) && j>=0; i++, j--) {
            if (i<list1.length && list1[i].equals(list2[j]))  ans.add(list1[i]);
            if (i<list2.length && list2[i].equals(list1[j]))  ans.add(list2[i]);
        }
        return ans.toArray(new String[ans.size()]);
    }
    private void checkMap(String[] list, int index, HashMap<String, Integer> hm, List<String> ans) {
        if (index<list.length) {
            if (hm.containsKey(list[index])) {
                small = hm.get(list[index]);
                large = index;
                ans.add(list[index]);
            } else
                hm.put(list[index], index);
        }
    }
}
